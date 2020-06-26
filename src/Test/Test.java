package Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import PerfumeShop.Daos.Daos;
import PerfumeShop.Entitis.ChiTietDonHang;
import PerfumeShop.Entitis.ChiTietDonHangPK;
import PerfumeShop.Entitis.DonHang;
import PerfumeShop.Entitis.KhachHang;
import PerfumeShop.Entitis.LoaiSanPham;
import PerfumeShop.Entitis.QuanLy;
import PerfumeShop.Entitis.SanPham;
import PerfumeShop.Entitis.TaiKhoan;

public class Test {

	public static void main(String[] args) {
		
		Daos dao = new Daos();
//		LoaiSanPham lsp = new LoaiSanPham("Cao Cap");
//		lsp.setMaloai(dao.getIDLoai()+1);
//		dao.themLoai(lsp);
//		SanPham sp = new SanPham("Louis", 100, "./images/nh3.jpg", "12/02/2020", "21/02/2022", 3);
//		sp.setMasp(dao.getIDSP()+1);
//		sp.setLoaisp(lsp);
//		SanPham sp1 = new SanPham("Menup", 200, "./images/nh3.jpg", "12/02/2019", "15/03/2021", 4);
//		sp1.setMasp(dao.getIDSP()+1);
//		sp1.setLoaisp(lsp);
//		dao.themSP(sp);
//		dao.themSP(sp1);
//		List<SanPham> lsp = dao.getSanpham("5eedbc4c3cc1050250afb0e6");
//		for(SanPham spp : lsp ) {
//			System.out.println(dao.xoaSP(spp));
//		}
//		System.out.println(dao.getLoaisanpham("5ef00e563cc10500ecd8a4a3"));
//		QuanLy ql = new QuanLy("bao", "22/12/2018", "13864654", "baolecc@gmail.com", "131313");
//		ql.setTaikhoan(new TaiKhoan("QLBao", "123456"));
//		dao.themQL(ql);
		
		System.out.println(dao.getDonhangs());
		
	}

}
