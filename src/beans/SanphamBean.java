package beans;

import java.util.List;

import javax.faces.bean.ManagedBean;

import PerfumeShop.Daos.Daos;
import PerfumeShop.Entitis.LoaiSanPham;
import PerfumeShop.Entitis.SanPham;

@ManagedBean
public class SanphamBean {
	private SanPham sanpham;
	private Daos dao = new Daos();
	private String loai;
	private String tempGia;
	private List<LoaiSanPham> listLoai = dao.getLoaisanphams();
	

	public List<LoaiSanPham> getListLoai() {
		return listLoai;
	}

	public void setListLoai(List<LoaiSanPham> listLoai) {
		this.listLoai = listLoai;
	}

	public String getTempGia() {
		return tempGia;
	}

	public void setTempGia(String tempGia) {
		this.tempGia = tempGia;
	}

	public String getLoai() {
		return loai;
	}

	public void setLoai(String loai) {
		this.loai = loai;
	}

	public SanphamBean() {
		sanpham = new SanPham();
	}

	public SanPham getSanpham() {
		return sanpham;
	}

	public void setSanpham(SanPham sanpham) {
		this.sanpham = sanpham;
	}

	public List<SanPham> getSanphams() {
		return dao.getSanphams();
	}

	public SanPham getSanpham(int ma) {
		return dao.getSanpham(ma);
	}


	public String xoasp(SanPham sp) {
		boolean x = dao.xoaSP(sp);
		if (x)
			return "success";
		return "error";
	}

	public String themsp() {
		LoaiSanPham lsp = dao.getLoaisanpham(Integer.parseInt(loai));
		System.out.println(loai);	
			sanpham.setLoaisp(lsp);
			sanpham.setMasp(dao.getIDSP()+1);
			sanpham.setGia(Double.parseDouble(tempGia));
			boolean x = dao.themSP(sanpham);
			if (x)
				return "success1";

		return "error1";
	}
}
