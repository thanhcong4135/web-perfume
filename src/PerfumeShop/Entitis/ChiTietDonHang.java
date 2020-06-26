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
	private int soluong;


	public SanPham getSanpham() {
		return sanpham;
	}

	public void setSanpham(SanPham sanpham) {
		this.sanpham = sanpham;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	
	public ChiTietDonHang(SanPham sanpham, int soluong) {
		super();
		this.sanpham = sanpham;
		this.soluong = soluong;
	}

	public ChiTietDonHang() {
		super();
	}

}
