package beans;

import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import PerfumeShop.Daos.Daos;
import PerfumeShop.Entitis.KhachHang;

@ManagedBean
public class DangnhapBean {
	private ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
	private Map<String, Object> sessionMap = externalContext.getSessionMap();
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
			sessionMap.put("checklogin", true);
			return "successkh";
		} else if (validAdmin) {
			HttpSession session = Sessionutil.getSession();
			session.setAttribute("Admin", user);
			sessionMap.put("checklogin", true);
			return "loginAdmin";
		}
		return "incorrect";
	}

	public String logout() {
		HttpSession session = Sessionutil.getSession();
		sessionMap.put("username", null);
		sessionMap.put("checklogin", false);
		return "logout";
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
