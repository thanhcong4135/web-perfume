package beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.servlet.http.HttpSession;

import PerfumeShop.Daos.Daos;
import PerfumeShop.Entitis.KhachHang;

@ManagedBean
public class DangnhapBean {
	private String user;
	private String pass;
	private Daos dao;

	private String sss;
	private String sadmin;

	public String getSadmin() {
		return sadmin;
	}

	public void setSadmin(String sadmin) {
		this.sadmin = sadmin;
	}

	public String getSss() {
		return sss;
	}

	public void setSss(String sss) {
		this.sss = sss;
	}

	public DangnhapBean() {
		dao = new Daos();
		HttpSession session = Sessionutil.getSession();
		sss = (String) session.getAttribute("username");
		sadmin = (String) session.getAttribute("Admin");
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String validateUsernamePassword() {
		boolean valid = dao.login(pass, user);
		boolean validAdmin = dao.getQL(pass, user);
		if (valid) {
			HttpSession session = Sessionutil.getSession();
			session.setAttribute("username", user);
			return "successkh";
		} else if (validAdmin) {
			HttpSession session = Sessionutil.getSession();
			session.setAttribute("Admin", user);
			return "loginAdmin";
		}
		return "incorrect";
	}

	public KhachHang getprofile() {
		KhachHang kh = null;
		HttpSession session = Sessionutil.getSession();
		String sss = (String) session.getAttribute("username");
		List<KhachHang> lkh = dao.getKhachhangs();
		for (KhachHang khachHang : lkh) {
			if (khachHang.getTaikhoan().getUsername().equalsIgnoreCase(sss)) {
				kh = khachHang;
			}
		}
		return kh;

	}

}
