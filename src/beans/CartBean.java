package beans;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import PerfumeShop.Daos.Daos;
import PerfumeShop.Entitis.ChiTietDonHang;
import PerfumeShop.Entitis.DonHang;
import PerfumeShop.Entitis.KhachHang;
import PerfumeShop.Entitis.SanPham;

@SessionScoped
@ManagedBean(name = "cart")
public class CartBean {
	private int ma;
	private Daos dao = new Daos();
	private ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
	private Map<String, Object> sessionMap = externalContext.getSessionMap();
	private Map<String, String> params = externalContext.getRequestParameterMap();
	private List<CartItem> items = new ArrayList<CartItem>();

	public CartBean() {
		String matamthoi = "";
		for (String key : params.keySet()) {
			if (key.equals("ids"))
				matamthoi = params.get("ids");
		}

		System.out.println("ID: " + matamthoi);
		// get session
		for (String key : sessionMap.keySet())
			if (key.equals("cartitem"))
				items = (List<CartItem>) sessionMap.get("cartitem");
		ma = Integer.parseInt(matamthoi);
	}

	public List<CartItem> getItems() {
		return items;
	}

	public void setItems(List<CartItem> items) {
		this.items = items;
	}

	private int exists(SanPham sp) {
		if (items.size() != 0)
			for (int i = 0; i < items.size(); i++) {
				if (items.get(i).getSanpham().getMasp() == sp.getMasp()) {
					return i;
				}
			}
		return -1;
	}

	public void addCart() {
		SanPham sp = dao.getSanpham(ma);
		int index = exists(sp);
		if (index == -1) {
			items.add(new CartItem(sp, 1));
		} else {
			int quantity = items.get(index).getSoluong() + 1;
			items.get(index).setSoluong(quantity);
		}
		sessionMap.replace("cartitem", items);

	}

	public void updateCart(SanPham sp, int quantity) {
		int index = exists(sp);
		if (index == -1) {
			items.get(index).setSoluong(quantity);
		}
	}

	public void deleteCart(SanPham sp) {
		int index = this.exists(sp);
		items.remove(index);
		sessionMap.put("cartitem", items);
	}

	public double total() {
		double s = 0;
		for (CartItem c : items) {
			s += c.getSoluong() * c.getSanpham().getGia();
		}
		return s;
	}

	public void thanhtoan() {
		HttpSession session = Sessionutil.getSession();
		String seAdmin = (String) session.getAttribute("username");
		KhachHang kh = null;
		List<KhachHang> lkh = dao.getKhachhangs();
		for (KhachHang khachHang : lkh) {
			if (khachHang.getTaikhoan().getUsername().equalsIgnoreCase(seAdmin)) {
				kh = khachHang;
			}
		}
		List<ChiTietDonHang> lct = new ArrayList<ChiTietDonHang>();
		for (int i = 0; i < items.size(); i++) {
			lct.add(new ChiTietDonHang(items.get(i).getSanpham(), items.get(i).getSoluong()));
		}

		String now = LocalDate.now().toString();
		DonHang dh = new DonHang(kh.getDiachi(), now, total(), kh);
		dh.setListCTDH(lct);
		dh.setMadh(dao.getIDDH() + 1);
		dao.themHD(dh);
		sessionMap.put("cartitem", null);

	}

}