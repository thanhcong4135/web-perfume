package PerfumeShop.Entitis;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: ChiTietDonHang
 *
 */
@SuppressWarnings("serial")
@Embeddable
@Table(name = "chitiethoadon")
public class ChiTietDonHang implements Serializable {

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "masp")
	private SanPham sanpham;

	private double gia;
	private double ship;
	private int soluong;

	@Override
	public String toString() {
		return "ChiTietDonHang [sanpham=" + sanpham + ", gia=" + gia + ", ship=" + ship + ", soluong=" + soluong + "]";
	}


	public SanPham getSanpham() {
		return sanpham;
	}

	public void setSanpham(SanPham sanpham) {
		this.sanpham = sanpham;
	}

	public double getGia() {
		return gia;
	}

	public void setGia(double gia) {
		this.gia = gia;
	}

	public double getShip() {
		return ship;
	}

	public void setShip(double ship) {
		this.ship = ship;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public ChiTietDonHang(SanPham sanpham, double gia, double ship, int soluong) {
		super();
		this.sanpham = sanpham;
		this.gia = gia;
		this.ship = ship;
		this.soluong = soluong;
	}

	public ChiTietDonHang() {
		super();
	}

}
