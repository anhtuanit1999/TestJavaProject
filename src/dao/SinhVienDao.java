package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import entity.SinhVien;

public class SinhVienDao {
	ArrayList<SinhVien> listSinhVien;

	public SinhVienDao() {
		listSinhVien = new ArrayList<SinhVien>();
	}
	
	public ArrayList<SinhVien> docTuBang() throws ParseException {
		Connection con = null;
		try {
			con = Database.getInstance().getConnection();
			String sql = "select * from SINHVIEN";
			Statement statement = con.createStatement();
			ResultSet res = statement.executeQuery(sql);
			while (res.next()) {
				String maSinhVien = res.getString(1);
				String hoTen = res.getString(2);
				String ngaySinh = res.getString(3);
				String soDienThoai = res.getString(4);
				String diaChi = res.getString(5);
				String khoaTrucThuoc = res.getString(6);
				int namVaoTruong = Integer.parseInt(res.getString(7));
				int namTotNghiep = Integer.parseInt(res.getString(8));
				String maNhom = res.getString(9);
				SinhVien sv = new SinhVien(maSinhVien, hoTen, ngaySinh, soDienThoai, diaChi, khoaTrucThuoc, namVaoTruong, namTotNghiep, maNhom);
				listSinhVien.add(sv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listSinhVien;
	}
	
	public boolean themSinhVien(String maSinhVien, String hoTen, String diaChi, String soDienThoai, String ngaySinh,
			String khoaTrucThuoc, int namVaoTruong, int namTotNghiep, String maNhom) {
		Connection con = Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into SINHVIEN values(?, ?, ?, ?, ?, ?, ?, ?, ?)");
			stmt.setString(1,maSinhVien);
			stmt.setString(2,hoTen );
			stmt.setString(3, diaChi);
			stmt.setString(4, soDienThoai);
			stmt.setString(5, ngaySinh);
			stmt.setString(6, khoaTrucThuoc);
			stmt.setInt(7, namVaoTruong);
			stmt.setInt(8, namTotNghiep);
			stmt.setString(9, maNhom);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	public boolean suaSinhVien(String maSinhVien, String hoTen, String diaChi, String soDienThoai, String ngaySinh,
			String khoaTrucThuoc, int namVaoTruong, int namTotNghiep) {
		Connection con = Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update SINHVIEN "
					+ "set HoTen = ?,"
					+ "NgaySinh = ?,"
					+ "SoDienThoai = ?,"
					+ "DiaChi = ?,"
					+ "KhoaTrucThuoc = ? "
					+ "NamVaoTruong = ? "
					+ "NamTotNghiep = ? "
					+ "where MaSinhVien = ?");
			stmt.setString(1, hoTen);
			stmt.setString(2, ngaySinh);
			stmt.setString(3, soDienThoai);
			stmt.setString(4, diaChi);
			stmt.setString(5, khoaTrucThuoc);
			stmt.setInt(6, namVaoTruong);
			stmt.setInt(7, namTotNghiep);
			stmt.setString(8, maSinhVien);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	
//	public boolean xoaSinhVien(String maSinhVien) {
//		Connection con = Database.getInstance().getConnection();
//		PreparedStatement stmt = null;
//		int n = 0;
//		try {
//			stmt = con.prepareStatement("delete from SINHVIEN where MaSinhVien = ?");
//			stmt.setString(1, maSinhVien);
//			n = stmt.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return n > 0;
//	}
	
	public SinhVien timSinhVien(String maSinhVien) {
		SinhVien sv = null;
		Connection con = Database.getInstance().getConnection();
		String sql = "select * \r\n" + 
				"from SINHVIEN sv\r\n" + 
				"where sv.MaSinhVien = '"+ maSinhVien +"'";
		Statement statement;
		try {
			statement = con.createStatement();
			ResultSet res = statement.executeQuery(sql);
			if(res.next()) {
				String hoTen = res.getString(2);
				String ngaySinh = res.getString(3);
				String soDienThoai = res.getString(4);
				String diaChi = res.getString(5);
				String khoaTrucThuoc = res.getString(6);
				int namVaoTruong = res.getInt(7);
				int namTotNghiep = res.getInt(8);
				String maNhom = res.getString(9);
				sv = new SinhVien(maSinhVien, hoTen, ngaySinh, soDienThoai, diaChi, khoaTrucThuoc, namVaoTruong, namTotNghiep, maNhom);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sv;
	}
	
	public SinhVien timSinhVienCungNhom(String maNhom, String maSinhVien) {
		SinhVien sv = null;
		Connection con = Database.getInstance().getConnection();
		String sql = "select sv.MaSinhVien, sv.HoTen, sv.NgaySinh, sv.SoDienThoai, sv.DiaChi, sv.KhoaTrucThuoc, sv.NamVaoTruong, sv.NamTotNghiep\r\n" + 
				"from SINHVIEN sv\r\n" + 
				"inner join DANHSACH_DANGKYLUANVAN ds on ds.MaNhom = sv.MaNhom\r\n" + 
				"where ds.MaNhom = '"+ maNhom +"' and sv.MaSinhVien <> '"+ maSinhVien +"'";
		Statement statement;
		try {
			statement = con.createStatement();
			ResultSet res = statement.executeQuery(sql);
			
			if(res.next()) {
				String hoTen = res.getString(2);
				String ngaySinh = res.getString(3);
				String soDienThoai = res.getString(4);
				String diaChi = res.getString(5);
				String khoaTrucThuoc = res.getString(6);
				int namVaoTruong = res.getInt(7);
				int namTotNghiep = res.getInt(8);
				sv = new SinhVien(maSinhVien, hoTen, ngaySinh, soDienThoai, diaChi, khoaTrucThuoc, namVaoTruong, namTotNghiep, maNhom);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sv;
	}
	
	public ResultSet xemDiem(String maSinhVien) {
		ResultSet res = null;
		Connection con = Database.getInstance().getConnection();
		String sql = "select gv.HoTen, diem.Diem, diem.GhiChu\r\n" + 
				"from SINHVIEN sv\r\n" + 
				"inner join DIEMBAOVELUANVAN diem on diem.MaSinhVien = sv.MaSinhVien\r\n" + 
				"inner join GIAOVIEN gv on diem.MaGiaoVien = gv.MaGiaoVien\r\n" + 
				"where sv.MaSinhVien = '"+ maSinhVien +"'";
		Statement statement;
		try {
			statement = con.createStatement();
			res = statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public ArrayList<SinhVien> timSinhVien(String maSinhVien, String hoTen, String soDienThoai, String diaChi, String khoaTrucThuoc, String namVaoTruong, String namTotNghiep) {
		ArrayList<SinhVien> list = new ArrayList<SinhVien>();
		Connection con = Database.getInstance().getConnection();
		String sql = "select *\r\n" + 
				"from SINHVIEN sv\r\n" + 
				"where sv.MaSinhVien like '%"+ maSinhVien +"%' and \r\n" + 
				"sv.HoTen like N'%"+ hoTen +"%' and \r\n" + 
				"sv.SoDienThoai like '%"+ soDienThoai +"%' and \r\n" + 
				"sv.KhoaTrucThuoc like N'%"+ khoaTrucThuoc +"%' and \r\n" + 
				"sv.DiaChi like '%"+ diaChi +"%' and \r\n" + 
				"sv.NamVaoTruong like '%"+ namVaoTruong +"%' and \r\n" + 
				"sv.NamTotNghiep like '%"+ namTotNghiep +"%'";
		Statement statement;
		try {
			statement = con.createStatement();
			ResultSet res = statement.executeQuery(sql);
			while(res.next()) {
				String maSinhVienCanTim = res.getString(1);
				String hoTenCanTim = res.getString(2);
				String ngaySinh = res.getString(3);
				String soDienThoaiCanTim = res.getString(4);
				String diaChiCanTim = res.getString(5);
				String khoaTrucThuocCanTim = res.getString(6);
				int namVaoTruongCanTim = res.getInt(7);
				int namTotNghiepCanTim = res.getInt(8);
				String maNhom = res.getString(9);
				SinhVien sv = new SinhVien(maSinhVienCanTim, hoTenCanTim, ngaySinh, soDienThoaiCanTim, diaChiCanTim, khoaTrucThuocCanTim, namVaoTruongCanTim, namTotNghiepCanTim, maNhom);
				list.add(sv);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean dangKyNhom(String maSinhVien1, String maSinhVien2) {
		String ngayHienTai = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		Connection con = Database.getInstance().getConnection();
		String maNhom = sinhMaNhomTuDong();
		String sql = "INSERT INTO DANHSACH_DANGKYLUANVAN(MaNhom, MaLuanVan,MaHoiDong, NgayLap, NgayBaoCao) VALUES ('"+ maNhom +"', NULL, NULL, '"+ngayHienTai+"', NULL)\r\n" + 
				"UPDATE SINHVIEN SET MaNhom = '"+ maNhom +"' WHERE MaSinhVien = '"+ maSinhVien1 +"'\r\n" + 
				"UPDATE SINHVIEN SET MaNhom = '"+ maNhom +"' WHERE MaSinhVien = '"+ maSinhVien2 +"'";
		Statement statement;
		try {
			statement = con.createStatement();
			int n = statement.executeUpdate(sql);
			return n > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public String sinhMaNhomTuDong() {
		String count = null;
		Connection con = Database.getInstance().getConnection();
		String sql = "select COUNT(ds.MaNhom)\r\n" + 
				"from DANHSACH_DANGKYLUANVAN ds";
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
		return "NH" + count;
	}
}
