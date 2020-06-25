package beans;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import PerfumeShop.Daos.Daos;
import PerfumeShop.Entitis.SanPham;

@SessionScoped
@ManagedBean(name = "cart")
public class CartBean {
	private int ma;
	private Daos dao = new Daos();
	private ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
	private Map<String, Object> sessionMap = externalContext.getSessionMap();
	private List<CartItem> items = new ArrayList<CartItem>();

	public CartBean() {

		String matamthoi = "";
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
		for (String key : params.keySet())
			if (key.equals("ids"))
				matamthoi = params.get("ids").toString();
		//get session
		for (String key : sessionMap.keySet())
			if (key.equals("cart"))
				items = (List<CartItem>) sessionMap.get("cart");
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
		System.out.println("xxx1");
		SanPham sp = dao.getSanpham(ma);
		int index = exists(sp);
		if (index == -1) {
			System.out.println("xxx2");
			items.add(new CartItem(sp, 1));
		} else {
			System.out.println("xxx3");
			int quantity = items.get(index).getSoluong() + 1;
			items.get(index).setSoluong(quantity);
		}
		System.out.println("FUk: " + items.size());
		for (CartItem p : items)
			System.out.println(p.toString());

		sessionMap.put("cartitem", items);
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
	}

	public double total() {
		double s = 0;
		for (CartItem c : items) {
			s += c.getSoluong() * c.getSanpham().getGia();
		}
		return s;
	}

	public String thanhtoan() {
		
	}
	
}