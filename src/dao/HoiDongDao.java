package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import entity.HoiDong;

public class HoiDongDao {
	ArrayList<HoiDong> listHoiDong;
	public HoiDongDao() {
		listHoiDong = new ArrayList<HoiDong>();
	}

	public ArrayList<HoiDong> docTuBang() throws SQLException{
		listHoiDong.clear();
		try {
			Connection con = Database.getInstance().getConnection();
			String sql = "select * from HOIDONG";
			Statement statement = con.createStatement();
			ResultSet res = statement.executeQuery(sql);
			while (res.next()) {
				String maHoiDong = res.getString(1);
				String tenHoiDong = res.getNString(2);
				HoiDong hd = new HoiDong(maHoiDong, tenHoiDong);
				listHoiDong.add(hd);
			}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return listHoiDong;
	}
	
	public String taoHoiDong(String tenHoiDong) throws SQLException {
		int tempID = 0;
		String maHoiDong = null;
		Connection con = Database.getInstance().getConnection();
		Statement statement = con.createStatement();
		ResultSet res = statement.executeQuery("SELECT TOP 1 MaHoiDong FROM HOIDONG ORDER BY MaHoiDong DESC");
		while (res.next()) {
			tempID = Integer.parseInt(res.getString(1).substring(2).trim());
		}
		tempID++;
		if(Integer.toString(tempID).length() > 2) {
			maHoiDong = "HD" + tempID; 
		}else if(Integer.toString(tempID).length() > 1){
			maHoiDong = "HD" + "0" + tempID; 
		}else if(Integer.toString(tempID).length() == 1) {
			maHoiDong = "HD" + "00" + tempID; 
		}
		
		String sql = "INSERT INTO HOIDONG(MaHoiDong, TenHoiDong) VALUES (?,?)";
		PreparedStatement preStatement = con.prepareStatement(sql);
		preStatement.setString(1, maHoiDong);
		preStatement.setNString(2, tenHoiDong);
		preStatement.executeUpdate();
		return maHoiDong;
	}
	
	public void suaHoiDong(String maHoiDong, String tenHoiDong) throws SQLException {
		Connection con = Database.getInstance().getConnection();
		String sql = "UPDATE HOIDONG SET TenHoiDong = ? WHERE MaHoiDong = ?";
		PreparedStatement preStatement = con.prepareStatement(sql);
		preStatement.setNString(1, tenHoiDong);
		preStatement.setString(2, maHoiDong);
		preStatement.executeUpdate();

	}
	
	public void xoaHoiDong(String maHoiDong) throws SQLException {
		Database.getInstance().connec();
		Connection con = Database.getInstance().getConnection();
		Statement st = con.createStatement();
		st.executeUpdate("DELETE FROM CHITIETCONGVIEC WHERE MaHoiDong = '"+maHoiDong+"'");
		st.executeUpdate("UPDATE DANHSACH_DANGKYLUANVAN SET MaHoiDong = NULL WHERE MaHoiDong = '"+maHoiDong+"'");
		st.executeUpdate("DELETE FROM HOIDONG WHERE MaHoiDong = '"+maHoiDong+"'");
	}
	

}
