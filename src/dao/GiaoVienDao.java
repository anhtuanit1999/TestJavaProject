package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;

import entity.GiaoVien;


public class GiaoVienDao {
	ArrayList<GiaoVien> listGiaoVien;

	public GiaoVienDao() {
		listGiaoVien = new ArrayList<GiaoVien>();
	}
	
	public ArrayList<GiaoVien> docTuBang() throws ParseException {
		Connection con = null;
		try {
			con = Database.getInstance().getConnection();
			String sql = "select * from GiAOVIEN";
			Statement statement = con.createStatement();
			ResultSet res = statement.executeQuery(sql);
			while (res.next()) {
				String maGiaoVien = res.getString(1);
				String hoTen = res.getString(2);
				String chucDanh = res.getString(3);
				String linhVucCongTac = res.getString(4);
				String donViCongTac = res.getString(5);
				String khoaCongTac = res.getString(6);
				
				GiaoVien gv = new GiaoVien(maGiaoVien, hoTen, chucDanh, donViCongTac, khoaCongTac, linhVucCongTac);
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
}
