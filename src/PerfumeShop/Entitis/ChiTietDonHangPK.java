package PerfumeShop.Entitis;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: ChiTietDonHangPK
 *
 */
@Embeddable

public class ChiTietDonHangPK implements Serializable {

	
	private String maspid;
	private String donhangid;
	
	

	public ChiTietDonHangPK(String maspid, String donhangid) {
		super();
		this.maspid = maspid;
		this.donhangid = donhangid;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((donhangid == null) ? 0 : donhangid.hashCode());
		result = prime * result + ((maspid == null) ? 0 : maspid.hashCode());
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
		ChiTietDonHangPK other = (ChiTietDonHangPK) obj;
		if (donhangid == null) {
			if (other.donhangid != null)
				return false;
		} else if (!donhangid.equals(other.donhangid))
			return false;
		if (maspid == null) {
			if (other.maspid != null)
				return false;
		} else if (!maspid.equals(other.maspid))
			return false;
		return true;
	}



	public String getMaspid() {
		return maspid;
	}



	public void setMaspid(String maspid) {
		this.maspid = maspid;
	}



	public String getDonhangid() {
		return donhangid;
	}



	public void setDonhangid(String donhangid) {
		this.donhangid = donhangid;
	}



	public ChiTietDonHangPK() {
		super();
	}



	@Override
	public String toString() {
		return "ChiTietDonHangPK [maspid=" + maspid + ", donhangid=" + donhangid + "]";
	}
   
}
