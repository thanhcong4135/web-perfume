package beans;

import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import PerfumeShop.Daos.Daos;
import PerfumeShop.Entitis.SanPham;

@ManagedBean(name = "chitiet")
public class DetailBean {
	private Daos dao;
	private int maSp;
	private SanPham sanpham;

	public DetailBean() {
		String matamthoi = "";
		dao = new Daos();
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
		for (String key : params.keySet())
			if (key.equals("idsp"))
				matamthoi = params.get("idsp");
		if (matamthoi.equals(""))
			maSp = 0;
		else
			maSp = Integer.parseInt(matamthoi);
		sanpham = dao.getSanpham(maSp);
	}

	public SanPham getSanpham() {
		return sanpham;
	}

	public void setSanpham(SanPham sanpham) {
		this.sanpham = sanpham;
	}

	public int getMaSp() {
		return maSp;
	}

	public void setMaSp(int maSp) {
		this.maSp = maSp;
	}

}
