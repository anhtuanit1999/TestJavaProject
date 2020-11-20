package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Set;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entity.GiaoVien;


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
				String donViCongTac = res.getString(5);
				String khoaCongTac = res.getString(6);
				
				GiaoVien gv = new GiaoVien(maGiaoVien, hoTen, chucDanh, linhVucCongTac, khoaCongTac, donViCongTac);
//				System.out.println(kh);
				listGiaoVien.add(gv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listGiaoVien;
	}
	
	public boolean themGiaoVien(String maGiaoVien, String hoTen, String chucDanh, String donViCongTac, String khoaCongTac,
			String linhVucCongTac) {
		Connection con = Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into SINHVIEN values(?, ?, ?, ?, ?, ?)");
			stmt.setString(1,maGiaoVien);
			stmt.setString(2,hoTen );
			stmt.setString(3, chucDanh);
			stmt.setString(4, donViCongTac);
			stmt.setString(5, khoaCongTac);
			stmt.setString(6, linhVucCongTac);
			
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	public boolean suaGiaoVien(String maGiaoVien, String hoTen, String chucDanh, String donViCongTac, String khoaCongTac,
			String linhVucCongTac) {
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
			stmt.setString(1, hoTen);
			stmt.setString(2, chucDanh);
			stmt.setString(3, linhVucCongTac);
			stmt.setString(4, donViCongTac);
			stmt.setString(5, khoaCongTac);
			stmt.setString(8, maGiaoVien);
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
	
	public void capNhatBang(JTable table, String maGiaoVien) {
		int count = 1;
		Connection con = Database.getInstance().getConnection();
		String sql = "select sv.MaSinhVien, HoTen, TenLuanVan, Diem, GhiChu, diem.MaGiaoVien\r\n" + 
				"from DANHSACH_DANGKYLUANVAN ds\r\n" + 
				"inner join CHITIETCONGVIEC ct on ct.MaHoiDong = ds.MaHoiDong\r\n" + 
				"inner join SINHVIEN sv on sv.MaNhom = ds.MaNhom\r\n" + 
				"inner join LUANVAN lv on lv.MaLuanVan = ds.MaLuanVan\r\n" + 
				"left join DIEMBAOVELUANVAN diem on diem.MaSinhVien = sv.MaSinhVien and diem.MaGiaoVien = ct.MaGiaoVien\r\n" + 
				"where ct.MaGiaoVien = '"+ maGiaoVien +"'";
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
}
