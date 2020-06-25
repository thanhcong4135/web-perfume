package beans;

import PerfumeShop.Entitis.SanPham;

public class CartItem {
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

	public CartItem() {
		super();
	}

	public CartItem(SanPham sanpham, int soluong) {
		super();
		this.sanpham = sanpham;
		this.soluong = soluong;
	}

	@Override
	public String toString() {
		return "CartItem [sanpham=" + sanpham + ", soluong=" + soluong + "]";
	}

}
