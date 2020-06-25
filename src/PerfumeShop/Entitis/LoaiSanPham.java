package PerfumeShop.Entitis;

import java.io.Serializable;
import javax.persistence.*;

import org.bson.types.ObjectId;

/**
 * Entity implementation class for Entity: LoaiSanPham
 *
 */
@Entity
@Table(name = "loaisanpham")
public class LoaiSanPham implements Serializable {

	@Id
	private int maloai;
	private String tenloai;

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + maloai;
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
		LoaiSanPham other = (LoaiSanPham) obj;
		if (maloai != other.maloai)
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "LoaiSanPham [maloai=" + maloai + ", tenloai=" + tenloai + "]";
	}



	public LoaiSanPham(String tenloai) {
		super();
		this.tenloai = tenloai;
	}



	public int getMaloai() {
		return maloai;
	}



	public void setMaloai(int maloai) {
		this.maloai = maloai;
	}



	public String getTenloai() {
		return tenloai;
	}



	public void setTenloai(String tenloai) {
		this.tenloai = tenloai;
	}



	public LoaiSanPham() {
		super();
	}

}
