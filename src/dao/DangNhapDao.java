package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;


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
}

/*
* (C) Copyright 2020 IUH. All rights reserved.
*
* @author: AnhTuanIT
* @date: 23-11-2020
* @version: 1.0
*/
