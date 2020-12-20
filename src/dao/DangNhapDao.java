package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class DangNhapDao {
	public boolean kiemTraTaiKhoan(String taiKhoan, String matKhau) {
		String regex = "SV\\d{3}|GV\\d{3}|GVK|admin";
		if(taiKhoan.matches(regex)) {
			String quyen = layQuyenDangNhapTuongUng(taiKhoan);
			Connection con = Database.getInstance().getConnection();
			String sql = "select *\r\n" + 
					"from "+ quyen +" tk\r\n" + 
					"where tk.MaTaiKhoan = '"+ taiKhoan +"'";
			Statement statement;
			try {
				statement = con.createStatement();
				ResultSet res = statement.executeQuery(sql);
				if(res.next()) {
					if(res.getString(1).trim().equals(taiKhoan) && res.getString(2).trim().equals(matKhau)) {
						return true;
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return false;
	}
	public String layQuyenDangNhapTuongUng(String taiKhoan) {
		String regexSinhVien = "SV\\d{3}";
		String regexGiaoVien = "GV\\d{3}";
		if(taiKhoan.matches(regexSinhVien)) {
			return "TAIKHOANSINHVIEN";
		} else if(taiKhoan.matches(regexGiaoVien)) {
			return "TAIKHOANGIAOVIEN";
		}
		return "TAIKHOAN";
		
	}
	public boolean doiMatKhau(String taiKhoan, String matKhau, String matKhauMoi) {
		if(kiemTraTaiKhoan(taiKhoan, matKhau)) {
			Connection con = Database.getInstance().getConnection();
			PreparedStatement stmt = null;
			String quyen = layQuyenDangNhapTuongUng(taiKhoan);
			int n = 0;
			try {
				stmt = con.prepareStatement("update "+ quyen +" "
						+ "set MatKhau = ? "
						+ "where MaTaiKhoan = ?");
				stmt.setString(1, matKhauMoi);
				stmt.setString(2, taiKhoan);
				n = stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return n > 0;
		}
		return false;
	}
	
	public String[] layTaiKhoanSinhVien() {
		List<String> list = new ArrayList<String>();
		Connection con = Database.getInstance().getConnection();
		String sql = "select tk.MaTaiKhoan\r\n" + 
				"from TAIKHOANSINHVIEN tk";
		Statement statement;
		try {
			statement = con.createStatement();
			ResultSet res = statement.executeQuery(sql);
			while(res.next()) {
				list.add(res.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String[] arr = new String[list.size()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = list.get(i);
		}
		return arr;
	}
	
	public String[] layTaiKhoanGiaoVien() {
		List<String> list = new ArrayList<String>();
		Connection con = Database.getInstance().getConnection();
		String sql = "select tk.MaTaiKhoan\r\n" + 
				"from TAIKHOANGIAOVIEN tk";
		Statement statement;
		try {
			statement = con.createStatement();
			ResultSet res = statement.executeQuery(sql);
			while(res.next()) {
				list.add(res.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String[] arr = new String[list.size()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = list.get(i);
		}
		return arr;
	}
}

/*
* (C) Copyright 2020 IUH. All rights reserved.
*
* @author: AnhTuanIT
* @date: 23-11-2020
* @version: 1.0
*/
