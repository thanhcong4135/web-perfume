package PerfumeShop.Entitis;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;

import org.bson.types.ObjectId;

/**
 * Entity implementation class for Entity: SanPham
 *
 */
@Entity
@Table(name = "sanpham")
public class SanPham implements Serializable {

	@Id
	private int masp;
	private String tensp;
	private double gia;
	private String url;
	private String ngaysx;
	private String ngayhh;
	private int soluong;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "loai")
	private LoaiSanPham loaisp;

	@Override
	public String toString() {
		return "SanPham [masp=" + masp + ", tensp=" + tensp + ", gia=" + gia + ", url=" + url + ", ngaysx=" + ngaysx
				+ ", ngayhh=" + ngayhh + ", soluong=" + soluong + ", loaisp=" + loaisp + "]";
	}

	public SanPham(String tensp, double gia, String url, String ngaysx, String ngayhh, int soluong) {
		super();
		this.tensp = tensp;
		this.gia = gia;
		this.url = url;
		this.ngaysx = ngaysx;
		this.ngayhh = ngayhh;
		this.soluong = soluong;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + masp;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SanPham other = (SanPham) obj;
		if (masp != other.masp)
			return false;
		return true;
	}

	public String getTensp() {
		return tensp;
	}

	public int getMasp() {
		return masp;
	}

	public void setMasp(int masp) {
		this.masp = masp;
	}

	public void setTensp(String tensp) {
		this.tensp = tensp;
	}

	public Double getGia() {
		return gia;
	}

	public void setGia(double gia) {
		this.gia = gia;
	}

	public String getNgaysx() {
		return ngaysx;
	}

	public void setNgaysx(String ngaysx) {
		this.ngaysx = ngaysx;
	}

	public String getNgayhh() {
		return ngayhh;
	}

	public void setNgayhh(String ngayhh) {
		this.ngayhh = ngayhh;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public LoaiSanPham getLoaisp() {
		return loaisp;
	}

	public void setLoaisp(LoaiSanPham loaisp) {
		this.loaisp = loaisp;
	}

	public SanPham() {
		super();
	}

}
