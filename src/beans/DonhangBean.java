package beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.servlet.http.HttpSession;

import PerfumeShop.Daos.Daos;
import PerfumeShop.Entitis.DonHang;
import PerfumeShop.Entitis.KhachHang;

@ManagedBean(name = "donhang")
public class DonhangBean {
	private Daos dao;

	public DonhangBean() {
		dao = new Daos();
	}

	public List<DonHang> getDonhangs() {
		return dao.getDonhangs();
	}

	public List<DonHang> getDHByKH() {
		HttpSession session = Sessionutil.getSession();
		String seAdmin = (String) session.getAttribute("username");
		KhachHang kh = null;
		List<KhachHang> lkh = dao.getKhachhangs();
		for (KhachHang khachHang : lkh) {
			if (khachHang.getTaikhoan().getUsername().equalsIgnoreCase(seAdmin)) {
				kh = khachHang;
			}
		}
		List<DonHang> ldh = dao.getDonhangs();
		List<DonHang> dhn = new ArrayList<DonHang>();
		for (DonHang dh : ldh) {
			if (dh.getKhachhang().getMahk() == kh.getMahk()) {
				dhn.add(dh);			
			}
		}
		return dhn;
	}

}
