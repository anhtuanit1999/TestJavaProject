package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

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
				String tenSinhVien = res.getString(2);
				String ngaySinh = res.getString(3);
				String soDienThoai = res.getString(4);
				String diaChi = res.getString(5);
				String khoaTrucThuoc = res.getString(6);
				int namVaoTruong = Integer.parseInt(res.getString(7));
				int namTotNghiep = Integer.parseInt(res.getString(8));
				
				SinhVien sv = new SinhVien(maSinhVien, tenSinhVien, diaChi, soDienThoai, ngaySinh, khoaTrucThuoc, namVaoTruong, namTotNghiep);
//				System.out.println(kh);
				listSinhVien.add(sv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listSinhVien;
	}
	
	public boolean themSinhVien(String maSinhVien, String hoTen, String diaChi, String soDienThoai, String ngaySinh,
			String khoaTrucThuoc, int namVaoTruong, int namTotNghiep) {
		Connection con = Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into SINHVIEN values(?, ?, ?, ?, ?, ?, ?, ?)");
			stmt.setString(1,maSinhVien);
			stmt.setString(2,hoTen );
			stmt.setString(3, diaChi);
			stmt.setString(4, soDienThoai);
			stmt.setString(5, ngaySinh);
			stmt.setString(6, khoaTrucThuoc);
			stmt.setInt(7, namVaoTruong);
			stmt.setInt(8, namTotNghiep);
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
	
	public boolean xoaSinhVien(String maSinhVien) {
		Connection con = Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete from SINHVIEN where MaSinhVien = ?");
			stmt.setString(1, maSinhVien);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	
}
