package PerfumeShop.Entitis;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: DonHang
 *
 */
@Entity
@Table(name = "donhang")
public class DonHang implements Serializable {

	@Id
	private int madh;
	private String diachi;
	private String ngaymua;
	private double tongtien;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "makhachhang")
	private KhachHang khachhang;
	@ElementCollection(targetClass = ChiTietDonHang.class, fetch = FetchType.EAGER)
	private List<ChiTietDonHang> listCTDH;

	public DonHang(String diachi, String ngaymua, double tongtien, KhachHang khachhang) {
		super();
		this.diachi = diachi;
		this.ngaymua = ngaymua;
		this.tongtien = tongtien;
		this.khachhang = khachhang;
	}

	@Override
	public String toString() {
		return "DonHang [madh=" + madh + ", diachi=" + diachi + ", ngaymua=" + ngaymua + ", tongtien=" + tongtien
				+ ", khachhang=" + khachhang + ", listCTDH=" + listCTDH + "]";
	}

	public int getMadh() {
		return madh;
	}

	public void setMadh(int madh) {
		this.madh = madh;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getNgaymua() {
		return ngaymua;
	}

	public void setNgaymua(String ngaymua) {
		this.ngaymua = ngaymua;
	}

	public double getTongtien() {
		return tongtien;
	}

	public void setTongtien(double tongtien) {
		this.tongtien = tongtien;
	}

	public KhachHang getKhachhang() {
		return khachhang;
	}

	public void setKhachhang(KhachHang khachhang) {
		this.khachhang = khachhang;
	}

	public List<ChiTietDonHang> getListCTDH() {
		return listCTDH;
	}

	public void setListCTDH(List<ChiTietDonHang> listCTDH) {
		this.listCTDH = listCTDH;
	}

	public DonHang() {
		super();
	}

}
