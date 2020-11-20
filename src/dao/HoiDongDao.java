package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

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
				String ngayLap = res.getString(3);
				String ngayBaoCao = res.getString(4);
				HoiDong hd = new HoiDong(maHoiDong, tenHoiDong, ngayLap, ngayBaoCao);
				listHoiDong.add(hd);
			}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return listHoiDong;
	}
	
	public String taoHoiDong(String tenHoiDong, String ngayBaoCao) throws SQLException {
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
		String ngayHienTai = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		String sql = "INSERT INTO HOIDONG(MaHoiDong, TenHoiDong, NgayLap, NgayBaoCao) VALUES (?,?,?,?)";
		PreparedStatement preStatement = con.prepareStatement(sql);
		preStatement.setString(1, maHoiDong);
		preStatement.setNString(2, tenHoiDong);
		preStatement.setString(3, ngayHienTai);
		preStatement.setString(4, ngayBaoCao);
		preStatement.executeUpdate();
		return maHoiDong;
	}
	
	public void timKiemHoiDongTheoTieuChi(String maHoiDong, String tenHoiDong, String ngayLap, String NgayBaoCao, JTable table) throws SQLException {
		Connection con = Database.getInstance().getConnection();
		Statement statement = con.createStatement();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		int i = 1;
		ResultSet res = statement.executeQuery("SELECT * FROM HOIDONG WHERE MaHoiDong LIKE '%"+maHoiDong+"%' AND TenHoiDong LIKE N'%"+tenHoiDong+"%' AND NgayLap LIKE '%"+ngayLap+"%' AND NgayBaoCao LIKE '%"+NgayBaoCao+"%'");
		while(res.next()) {
			Object[] rowData = {
					i,
					res.getString(1),
					res.getString(2),
					res.getString(3),
					res.getString(4)
			};
			model.addRow(rowData);
			i++;
		}
		table.setModel(model);
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
