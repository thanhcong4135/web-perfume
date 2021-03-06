package PerfumeShop.Entitis;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.*;

import org.bson.types.ObjectId;

/**
 * Entity implementation class for Entity: KhachHang
 *
 */
@Entity
@Table(name = "khachhang")
public class KhachHang implements Serializable {

	@Id
	private int mahk;
	private String tenkh;
	private String email;
	private String sodt;
	private String ngaysinh;
	private String diachi;
	private TaiKhoan taikhoan;

	public int getMahk() {
		return mahk;
	}

	public void setMahk(int mahk) {
		this.mahk = mahk;
	}

	public String getTenkh() {
		return tenkh;
	}

	public String getNgaysinh() {
		return ngaysinh;
	}

	public void setNgaysinh(String ngaysinh) {
		this.ngaysinh = ngaysinh;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public void setTenkh(String tenkh) {
		this.tenkh = tenkh;
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

	@Override
	public String toString() {
		return "KhachHang [mahk=" + mahk + ", tenkh=" + tenkh + ", email=" + email + ", sodt=" + sodt + ", taikhoan="
				+ taikhoan + "]";
	}

	public KhachHang(String tenkh, String email, String sodt, String ngaysinh, String diachi, TaiKhoan taikhoan) {
		super();
		this.tenkh = tenkh;
		this.email = email;
		this.sodt = sodt;
		this.ngaysinh = ngaysinh;
		this.diachi = diachi;
		this.taikhoan = taikhoan;
	}

	public TaiKhoan getTaikhoan() {
		return taikhoan;
	}

	public void setTaikhoan(TaiKhoan taikhoan) {
		this.taikhoan = taikhoan;
	}

	public KhachHang() {
		super();
	}

}
