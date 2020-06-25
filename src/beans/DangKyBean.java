package beans;

import java.util.List;

import javax.faces.bean.ManagedBean;

import org.bson.types.ObjectId;

import PerfumeShop.Daos.Daos;
import PerfumeShop.Entitis.KhachHang;
import PerfumeShop.Entitis.TaiKhoan;
@ManagedBean
public class DangKyBean {
	private KhachHang khachhang;
	private Daos dao;
	private String uName;
	private String pass;
	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public DangKyBean() {
		khachhang = new KhachHang();
		dao = new Daos();
	}

	public KhachHang getKhachhang() {
		return khachhang;
	}

	public void setKhachhang(KhachHang khachhang) {
		this.khachhang = khachhang;
	}
	
	public String dangKy() {
		khachhang.setTaikhoan(new TaiKhoan(uName, pass));
		khachhang.setMahk(dao.getIDKH()+1);
		boolean x = dao.themKH(khachhang);
		if(x)
			return "success";
		return "error";
	}
	
	public List<KhachHang> getKhachhangs(){
		return dao.getKhachhangs();
	}
	
	public String deleteKhachhang(KhachHang kh) {
		
		boolean x = dao.xoaKH(kh);
		if(x)
			return "success";
		return "error";
	}
	
}
