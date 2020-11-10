package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import entity.DeTai;
import entity.SinhVien;

public class DeTaiDao {
	ArrayList<DeTai> listDeTai;

	public DeTaiDao() {
		listDeTai = new ArrayList<DeTai>();
	}
	
	public ArrayList<DeTai> docTuBang() throws ParseException {
		Connection con = null;
		try {
			con = Database.getInstance().getConnection();
			String sql = "select * from DETAI";
			Statement statement = con.createStatement();
			ResultSet res = statement.executeQuery(sql);
			while (res.next()) {
				String maDeTai = res.getString(1);
				String tenDeTai = res.getString(2);
				String namHoc = res.getString(3);
				String moTa = res.getString(4);
				int soNhomThamGia = Integer.parseInt(res.getString(5));
				String maGiaoVienRaDe = res.getString(6);
				
				
				DeTai dt = new DeTai(maDeTai, maGiaoVienRaDe, tenDeTai, moTa, soNhomThamGia,namHoc);
//				System.out.println(kh);
				listDeTai.add(dt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listDeTai;
	}
	
	public boolean themDeTai(String maDeTai, String maGiaoVienRaDe, String tenDeTai, String moTaDeTai, int soNhomThamGia,String namHoc)  {
		Connection con = Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into DeTai values(?, ?, ?, ?, ? )");
			stmt.setString(1,maDeTai);
			stmt.setString(2, tenDeTai);
			stmt.setString(3, namHoc);
			stmt.setString(4, moTaDeTai);
			stmt.setInt(5, soNhomThamGia);
			stmt.setString(6, maGiaoVienRaDe);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	public boolean suaDeTai(String maDeTai, String maGiaoVienRaDe, String tenDeTai, String moTaDeTai, int soNhomThamGia,String namHoc) {
		Connection con = Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update DETAI "
					+ "set TenDeTai = ?,"
					+ "NamHoc = ?,"
					+ "MoTa = ?,"
					+ "SoNhomThamGia = ?,"
					+ "MaGiaoVienRaDeTai = ? "
					+ "where MaDeTai = ?");
			stmt.setString(1,tenDeTai);
			stmt.setString(2, namHoc);
			stmt.setString(3, moTaDeTai);
			stmt.setInt(4, soNhomThamGia);
			stmt.setString(5, maGiaoVienRaDe);
			stmt.setString(6, maDeTai);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	
	public boolean xoaDeTai(String maDeTai) {
		Connection con = Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete from DeTai where MaDeTai = ?");
			stmt.setString(1, maDeTai);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}
}
