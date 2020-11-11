package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;

import entity.LuanVan;
import entity.SinhVien;


public class LuanVanDao {
	ArrayList<LuanVan> listLuanVan;

	public LuanVanDao() {
		listLuanVan = new ArrayList<LuanVan>();
	}
	
	public ArrayList<LuanVan> docTuBang() throws ParseException {
		Connection con = null;
		try {
			con = Database.getInstance().getConnection();
			String sql = "select * from LUANVAN";
			Statement statement = con.createStatement();
			ResultSet res = statement.executeQuery(sql);
			while (res.next()) {
				String maLuanVan = res.getString(1);
				String maDeTai = res.getString(2);
				String tenLuanVan = res.getString(3);
				String linhVucNghienCuu = res.getString(4);
				String noiDungLuanVan = res.getString(5);
				String tomTat = res.getString(6);
				
				LuanVan lv = new LuanVan(maLuanVan, maDeTai, tenLuanVan, linhVucNghienCuu, noiDungLuanVan, tomTat);
//				System.out.println(kh);
				listLuanVan.add(lv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listLuanVan;
	}
	
	public boolean themLuanVan(String maLuanVan, String maDeTai, String tenLuanVan, String linhVucNghienCuu, String noiDungLuanVan,
			String tomTat) {
		Connection con = Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into SINHVIEN values(?, ?, ?, ?, ?, ?)");
			stmt.setString(1,maLuanVan);
			stmt.setString(2,tenLuanVan );
			stmt.setString(3, linhVucNghienCuu);
			stmt.setString(4, noiDungLuanVan);
			stmt.setString(5, tomTat);
			stmt.setString(6, maDeTai);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	public boolean suaLuanVan(String maLuanVan, String maDeTai, String tenLuanVan, String linhVucNghienCuu, String noiDungLuanVan,
			String tomTat) {
		Connection con = Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update LUANVAN "
					+ "set TenLuanVan = ?,"
					+ "LinhVucNghienCuu = ?,"
					+ "NoiDungLuanVan = ?,"
					+ "TomTat = ?,"
					+ "MaDeTai = ? "
					+ "where MaLuanVan = ?");
			stmt.setString(1, tenLuanVan);
			stmt.setString(2, linhVucNghienCuu);
			stmt.setString(3, noiDungLuanVan);
			stmt.setString(4, tomTat);
			stmt.setString(5, maDeTai);
			stmt.setString(8, maLuanVan);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	
	public boolean xoaLuanVan(String maLuanVan) {
		Connection con = Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete from LuanVan where MaLuanVan = ?");
			stmt.setString(1, maLuanVan);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	
	public ArrayList<SinhVien> timSinhVienLamLuanVanThemMa(String maLuanVan) throws ParseException {
		Connection con = null;
		ArrayList<SinhVien> listSinhVien = new ArrayList<SinhVien>();
		try {
			con = Database.getInstance().getConnection();
			String sql = "select *\r\n"
					+ "from SINHVIEN sv\r\n"
					+ "where sv.MaSinhVien in (select dslv_sv.MaSinhVien\r\n"
					+ "						from LuanVan lv\r\n"
					+ "						inner join DanhSachLuanVan_SinhVien dslv_sv\r\n"
					+ "						on lv.MaLuanVan = dslv_sv.MaLuanVan\r\n"
					+ "						where lv.MaLuanVan = '"+ maLuanVan +"')";
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
				
				SinhVien sv = new SinhVien(maSinhVien, hoTen, diaChi, soDienThoai, ngaySinh, khoaTrucThuoc, namVaoTruong, namTotNghiep);
				listSinhVien.add(sv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listSinhVien;
	}
}
