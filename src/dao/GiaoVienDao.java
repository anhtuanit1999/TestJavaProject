package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entity.GiaoVien;
import entity.LuanVan;
import entity.SinhVien;


public class GiaoVienDao {
	ArrayList<GiaoVien> listGiaoVien;

	public GiaoVienDao() {
		listGiaoVien = new ArrayList<GiaoVien>();
	}
	
	public ArrayList<GiaoVien> docTuBang() {
		Connection con = null;
		try {
			con = Database.getInstance().getConnection();
			String sql = "select MaGiaoVien, HoTen, ChucDanh, LinhVucCongTac, KhoaCongTac, DonViCongTac from GiAOVIEN";
			Statement statement = con.createStatement();
			ResultSet res = statement.executeQuery(sql);
			while (res.next()) {
				String maGiaoVien = res.getString(1);
				String hoTen = res.getString(2);
				String chucDanh = res.getString(3);
				String linhVucCongTac = res.getString(4);
				String khoaCongTac = res.getString(5);
				String donViCongTac = res.getString(6);
				
				
				GiaoVien gv = new GiaoVien(maGiaoVien, hoTen, chucDanh, linhVucCongTac, khoaCongTac, donViCongTac);
				listGiaoVien.add(gv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listGiaoVien;
	}
	
	public boolean themGiaoVien(GiaoVien gv) {
		Connection con = Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into GIAOVIEN values(?, ?, ?, ?, ?, ?)");
			stmt.setString(1, gv.getMaGiaoVien());
			stmt.setString(2, gv.getHoTen());
			stmt.setString(3, gv.getChucDanh());
			stmt.setString(4, gv.getLinhVucCongTac());
			stmt.setString(5, gv.getDonViCongTac());
			stmt.setString(6, gv.getKhoaCongTac());
			
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	public boolean suaGiaoVien(String maGiaoVien, GiaoVien gv) {
		Connection con = Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update GIAOVIEN "
					+ "set HoTen = ?,"
					+ "ChucDanh = ?,"
					+ "LinhVucCongTac = ?,"
					+ "DonViCongTac = ?,"
					+ "KhoaCongTac = ? "
					+ "where MaGiaoVien = ?");
			stmt.setString(1, gv.getHoTen());
			stmt.setString(2, gv.getChucDanh());
			stmt.setString(3, gv.getLinhVucCongTac());
			stmt.setString(4, gv.getDonViCongTac());
			stmt.setString(5, gv.getDonViCongTac());
			stmt.setString(6, maGiaoVien);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	
	public boolean xoaGiaoVien(String maGiaoVien) {
		Connection con = Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete from GIAOVIEN where MaGiaoVien = ?");
			stmt.setString(1, maGiaoVien);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	
	public void capNhatBang(JTable table, String maGiaoVien, String namHoc, String[] hocKy) {
		int count = 1;
		Connection con = Database.getInstance().getConnection();
		String sql = "select sv.MaSinhVien, HoTen, TenLuanVan, Diem, GhiChu, diem.MaGiaoVien\r\n" + 
				"from DANHSACH_DANGKYLUANVAN ds\r\n" + 
				"inner join CHITIETCONGVIEC ct on ct.MaHoiDong = ds.MaHoiDong\r\n" + 
				"inner join SINHVIEN sv on sv.MaNhom = ds.MaNhom\r\n" + 
				"inner join LUANVAN lv on lv.MaLuanVan = ds.MaLuanVan\r\n" + 
				"left join DIEMBAOVELUANVAN diem on diem.MaSinhVien = sv.MaSinhVien and diem.MaGiaoVien = ct.MaGiaoVien\r\n" + 
				"where ct.MaGiaoVien = '"+ maGiaoVien +"' AND YEAR(ds.NgayBaoCao) = '"+namHoc+"' and MONTH(ds.NgayBaoCao) >= "+ hocKy[0] +" and MONTH(ds.NgayBaoCao) <= "+ hocKy[1] +"";
		Statement statement;
		try {
			statement = con.createStatement();
			ResultSet res = statement.executeQuery(sql);
			while (res.next()) {
				String maSinhVien = res.getString(1);
				String tenSinhVien = res.getString(2);
				String tenLuanVan = res.getString(3);
				String diem = res.getString(4);
				String ghiChu = res.getString(5);
				String[] rowData = {
						count++ + "",
						maSinhVien,
						tenSinhVien,
						tenLuanVan,
						diem,
						ghiChu
				};
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(rowData);
				table.setModel(model);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean nhapDiem(String maGiaoVien, String maSinhVien, float diem, String ghiChu) {
		Connection con = Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into DIEMBAOVELUANVAN values(?, ?, ?, ?)");
			stmt.setString(1, maSinhVien);
			stmt.setString(2, maGiaoVien);
			stmt.setFloat(3, diem);
			stmt.setString(4, ghiChu);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Trùng!");
		}
		return n > 0;
	}
	
	public boolean suaDiem(String maGiaoVien, String maSinhVien, float diem, String ghiChu) {
		Connection con = Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update DIEMBAOVELUANVAN "
					+ "set Diem = ?,"
					+ "GhiChu = ? "
					+ "where MaGiaoVien = ? and MaSinhVien = ?");
			stmt.setFloat(1, diem);
			stmt.setString(2, ghiChu);
			stmt.setString(3, maGiaoVien);
			stmt.setString(4, maSinhVien);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	
	public GiaoVien timGiaoVien(String maGiaoVienCanTim) {
		GiaoVien gv = null;
		Connection con = Database.getInstance().getConnection();
		String sql = "select *\r\n" + 
				"from GIAOVIEN gv\r\n" + 
				"where gv.MaGiaoVien = '"+ maGiaoVienCanTim +"'";
		Statement statement;
		try {
			statement = con.createStatement();
			ResultSet res = statement.executeQuery(sql);
			if(res.next()) {
				String maGiaoVien = res.getString(1);
				String hoTen = res.getString(2);
				String chucDanh = res.getString(3);
				String linhVucCongTac = res.getString(4);
				String donViCongTac = res.getString(5);
				String khoaCongTac = res.getString(6);
				gv = new GiaoVien(maGiaoVien, hoTen, chucDanh, linhVucCongTac, khoaCongTac, donViCongTac);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return gv;
	}
	
	public String sinhMaGiaoVienTuDong() {
		String count = null;
		Connection con = Database.getInstance().getConnection();
		String sql = "select COUNT(gv.MaGiaoVien)\r\n" + 
				"from GIAOVIEN gv";
		Statement statement;
		try {
			statement = con.createStatement();
			ResultSet res = statement.executeQuery(sql);
			res.next();
			count = res.getInt(1) + 1 + "";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for (int i = 0; i <= 3 - count.split("").length ; i++) {
			count = "0" + count;
		}
		return "GV" + count;
	}
	
	public boolean kiemTraGiaoVienDaTonTai(String tenGiaoVien, String chucDanh, String linhVucCongTac, String donViCongTac, String khoaCongTac) {
		SinhVien sv = null;
		boolean result = true;
		Connection con = Database.getInstance().getConnection();
		String sql = "select *\r\n" + 
				"from GIAOVIEN gv\r\n" + 
				"where gv.HoTen like N'%"+ tenGiaoVien +"%' and gv.ChucDanh like N'%"+ chucDanh +"%' "
						+ "and gv.LinhVucCongTac like N'%"+ linhVucCongTac +"%' and gv.DonViCongTac like N'%"+ donViCongTac +"%' and gv.KhoaCongTac like N'%"+ khoaCongTac +"%'";
		Statement statement;
		ResultSet res = null;
		try {
			statement = con.createStatement();
			res = statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			result = res.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public void updateBangGiaoVien(JTable table) {
		Connection con = null;
		int count = 1;
		try {
			con = Database.getInstance().getConnection();
			String sql = "select *\r\n" + 
					"from GIAOVIEN gv";
			Statement statement = con.createStatement();
			ResultSet res = statement.executeQuery(sql);
			while (res.next()) {
				String[] rowData = {
						count++ + "",
						res.getString(1),
						res.getString(2),
						res.getString(3),
						res.getString(4),
						res.getString(5),
						res.getString(6)
				};
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(rowData);
				table.setModel(model);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
