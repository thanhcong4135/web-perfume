package PerfumeShop.Daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import PerfumeShop.Entitis.ChiTietDonHang;
import PerfumeShop.Entitis.DonHang;
import PerfumeShop.Entitis.KhachHang;
import PerfumeShop.Entitis.LoaiSanPham;
import PerfumeShop.Entitis.QuanLy;
import PerfumeShop.Entitis.SanPham;

public class Daos {
	private EntityManager em;

	public Daos() {
		em = MyEntityManager.getInstance().getEntityManager();
	}

	// Loai san pham

	public boolean themLoai(LoaiSanPham lsp) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(lsp);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	public boolean xoaLoai(LoaiSanPham lsp) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.remove(lsp);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	public List<LoaiSanPham> getLoaisanphams() {
		return em.createNativeQuery("db.loaisanpham.find({})", LoaiSanPham.class).getResultList();
	}

	public LoaiSanPham getLoaisanpham(int ma) {
		return em.find(LoaiSanPham.class, ma);
	}

	public int getIDLoai() {
		int idMax = 0;
		String query = "db.loaisanpham.find({}).sort({_id:-1}).limit(1)";
		List<LoaiSanPham> lsp = em.createNativeQuery(query, LoaiSanPham.class).getResultList();
		for (LoaiSanPham loaiSanPham : lsp) {
			idMax = loaiSanPham.getMaloai();
		}
		return idMax;
	}

	// het

	// San Pham

	public boolean themSP(SanPham sp) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(sp);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	public boolean xoaSP(SanPham sp) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.remove(sp);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	public boolean suaSP(SanPham sp) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(sp);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	public List<SanPham> getSanphams() {
		return em.createNativeQuery("db.sanpham.find({})", SanPham.class).getResultList();
	}

	public SanPham getSanpham(int ma) {
		return em.find(SanPham.class, ma);
	}

	public List<SanPham> getSPbyLoai(String ma) {
		return em.createNativeQuery("db.sanpham.find({loai:\"" + ma + "\"})", SanPham.class).getResultList();
	}

	public int getIDSP() {
		int idMax = 0;
		String query = "db.sanpham.find({}).sort({_id:-1}).limit(1)";
		List<SanPham> lsp = em.createNativeQuery(query, SanPham.class).getResultList();
		for (SanPham sp : lsp) {
			idMax = sp.getMasp();
		}
		return idMax;
	}
	// het

	// Them hoa don

	public DonHang themHD(DonHang dh) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(dh);
			tr.commit();
			return dh;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}

	public List<DonHang> getDonhangs() {
		return em.createNativeQuery("db.donhang.find({})", DonHang.class).getResultList();
	}

	// Chi Tiet Don Hang

	public boolean themCTHD(ChiTietDonHang ct) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(ct);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	public List<ChiTietDonHang> getChitietdonhangs() {
		return em.createNativeQuery("db.chitiethoadon.find({})", ChiTietDonHang.class).getResultList();
	}

	// Them khach hang

	public boolean themKH(KhachHang kh) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(kh);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	public boolean xoaKH(KhachHang kh) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.remove(kh);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	public boolean suaKH(KhachHang kh) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(kh);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	public List<KhachHang> getKhachhangs() {
		return em.createNativeQuery("db.khachhang.find({})", KhachHang.class).getResultList();
	}

	public KhachHang getKhachhang(int ma) {
		return em.find(KhachHang.class, ma);
	}

	public int getIDKH() {
		int idMax = 0;
		String query = "db.khachhang.find({}).sort({_id:-1}).limit(1)";
		List<KhachHang> lkh = em.createNativeQuery(query, KhachHang.class).getResultList();
		for (KhachHang kh : lkh) {
			idMax = kh.getMahk();
		}
		return idMax;
	}

	public boolean login(String pass, String user) {
		List<KhachHang> li = em.createNativeQuery(
				"db.khachhang.find({taikhoan:{password:\"" + pass + "\",username:\"" + user + "\"}})", KhachHang.class)
				.getResultList();
		if (li.size() > 0)
			return true;
		return false;
	}

	// Quan Ly
	public boolean themQL(QuanLy ql) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(ql);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	public boolean xoaQL(QuanLy ql) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.remove(ql);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	public boolean suaQL(QuanLy ql) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(ql);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	public List<QuanLy> getQuanlys() {
		return em.createNativeQuery("db.quanly.find({})", QuanLy.class).getResultList();
	}

	public boolean getQL(String pass, String user) {
		List<QuanLy> lql = em.createNativeQuery("db.quanly.find({taikhoan:{password:\"" + pass + "\",username:\"" + user + "\"}})",
				QuanLy.class).getResultList();
		if(lql.size() > 0)
			return true;
		return false;
	}
}
