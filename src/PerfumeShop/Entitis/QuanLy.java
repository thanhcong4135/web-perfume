package PerfumeShop.Entitis;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;

import org.bson.types.ObjectId;

/**
 * Entity implementation class for Entity: QuanLy
 *
 */
@Entity
@Table(name = "quanly")
public class QuanLy implements Serializable {

	@Id
	private int maql;
	private String tenql;
	private String ngaysinh;
	private String cmnd;
	private String email;
	private String sodt;

	private TaiKhoan taikhoan;

	@Override
	public String toString() {
		return "QuanLy [maql=" + maql + ", tenql=" + tenql + ", ngaysinh=" + ngaysinh + ", cmnd=" + cmnd + ", email="
				+ email + ", sodt=" + sodt + ", taikhoan=" + taikhoan + "]";
	}

	public QuanLy(String tenql, String ngaysinh, String cmnd, String email, String sodt) {
		super();
		this.tenql = tenql;
		this.ngaysinh = ngaysinh;
		this.cmnd = cmnd;
		this.email = email;
		this.sodt = sodt;
	}

	public int getMaql() {
		return maql;
	}

	public void setMaql(int maql) {
		this.maql = maql;
	}

	public String getTenql() {
		return tenql;
	}

	public void setTenql(String tenql) {
		this.tenql = tenql;
	}

	public String getNgaysinh() {
		return ngaysinh;
	}

	public void setNgaysinh(String ngaysinh) {
		this.ngaysinh = ngaysinh;
	}

	public String getCmnd() {
		return cmnd;
	}

	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSodt() {
		return sodt;
	}

	public void setSodt(String sodt) {
		this.sodt = sodt;
	}

	public TaiKhoan getTaikhoan() {
		return taikhoan;
	}

	public void setTaikhoan(TaiKhoan taikhoan) {
		this.taikhoan = taikhoan;
	}

	public QuanLy() {
		super();
	}

}
