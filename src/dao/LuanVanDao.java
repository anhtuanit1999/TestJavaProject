package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
				String tenLuanVan = res.getString(2);
				String linhVucNghienCuu = res.getString(3);
				Date ngayLap = new SimpleDateFormat("yyyy-MM-dd").parse(res.getString(4));
				String moTa = res.getString(5);
				String maGiaoVien = res.getString(6);
				int soNhomThamGiaToiDa = res.getInt(7);
				LuanVan lv = new LuanVan(maLuanVan, tenLuanVan, linhVucNghienCuu, moTa, ngayLap, maGiaoVien, soNhomThamGiaToiDa);
				listLuanVan.add(lv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listLuanVan;
	}
	
	public boolean themLuanVan(LuanVan lv) {
		Connection con = Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into LUANVAN values(?, ?, ?, ?, ?, ?, ?)");
			stmt.setString(1, lv.getMaLuanVan());
			stmt.setString(2, lv.getTenLuanVan() );
			stmt.setString(3, lv.getLinhVucNghienCuu());
			stmt.setString(4, new SimpleDateFormat("yyyy-MM-dd").format(lv.getNgayLap()));
			stmt.setString(5, lv.getMoTa());
			stmt.setString(6, lv.getMaGiaoVien());
			stmt.setInt(7, lv.getSoNhomThamGiaToiDa());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	public boolean suaLuanVan(String maLuanVan, LuanVan lv) {
		Connection con = Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update LUANVAN "
					+ "set TenLuanVan = ?,"
					+ "LinhVucNghienCuu = ?,"
					+ "NgayLap = ?,"
					+ "MoTa = ?,"
					+ "MaGiaoVien = ?,"
					+ "SoNhomThamGiaToiDa = ? "
					+ "where MaLuanVan = ?");
			stmt.setString(1, lv.getTenLuanVan());
			stmt.setString(2, lv.getLinhVucNghienCuu());
			stmt.setString(3, new SimpleDateFormat("yyyy-MM-dd").format(lv.getNgayLap()));
			stmt.setString(4, lv.getMoTa());
			stmt.setString(5, lv.getMaGiaoVien() + "");
			stmt.setString(6, lv.getSoNhomThamGiaToiDa() + "");
			stmt.setString(7, maLuanVan);
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
				
//				SinhVien sv = new SinhVien(maSinhVien, hoTen, diaChi, soDienThoai, ngaySinh, khoaTrucThuoc, namVaoTruong, namTotNghiep);
//				listSinhVien.add(sv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listSinhVien;
	}
	
	public LuanVan timLuanVanTheoMaSinhVien(String maSinhVien) {
		LuanVan lv = null;
		Connection con = Database.getInstance().getConnection();
		String sql = "select lv.MaLuanVan, lv.TenLuanVan, lv.LinhVucNghienCuu, lv.MoTa, lv.NgayLap, lv.MaGiaoVien, lv.SoNhomThamGiaToiDa\r\n" + 
				"from SINHVIEN sv\r\n" + 
				"inner join DANHSACH_DANGKYLUANVAN ds on ds.MaNhom = sv.MaNhom\r\n" + 
				"inner join LUANVAN lv on lv.MaLuanVan = ds.MaLuanVan\r\n" + 
				"where sv.MaSinhVien = '"+ maSinhVien +"'";
		Statement statement;
		try {
			statement = con.createStatement();
			ResultSet res = statement.executeQuery(sql);
			if(!res.next()) {
				return null;
			}
			String maLuanVan = res.getString(1);
			String tenLuanVan = res.getString(2);
			String linhVucNghienCuu = res.getString(3);
			Date ngayLap = new SimpleDateFormat("yyyy-MM-dd").parse(res.getString(5));
			String moTa = res.getString(4);
			String maGiaoVien = res.getString(6);
			int soNhomThamGiaToiDa = res.getInt(7);
			lv = new LuanVan(maLuanVan, tenLuanVan, linhVucNghienCuu, moTa, ngayLap, maGiaoVien, soNhomThamGiaToiDa);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lv;
	}
	
	public void updateTableTimLuanVanTheoTieuChi(String maLuanVan, String tenLuanVan, String tenGiaoVienRaDeTai, JTable table) {
		Connection con = Database.getInstance().getConnection();
		String sql = "select lv.MaLuanVan, lv.TenLuanVan, gv.HoTen, lv.SoNhomThamGiaToiDa\r\n" + 
				"from LUANVAN lv\r\n" + 
				"inner join GIAOVIEN gv on gv.MaGiaoVien = lv.MaGiaoVien\r\n" + 
				"where lv.MaLuanVan like N'%"+ maLuanVan +"%' and lv.TenLuanVan like N'%"+ tenLuanVan +"%' and gv.HoTen like N'%"+ tenGiaoVienRaDeTai +"%'";
		Statement statement;
		int count = 1;
		try {
			statement = con.createStatement();
			ResultSet res = statement.executeQuery(sql);
			while(res.next()) {
				String[] rowData = {
						count++ + "",
						res.getString(1),
						res.getString(2),
						res.getString(3),
						res.getInt(4) + ""
				};
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(rowData);
				table.setModel(model);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateBangLuanVan(JTable table) {
		Connection con = null;
		int count = 1;
		try {
			con = Database.getInstance().getConnection();
			String sql = "select lv.MaLuanVan, lv.TenLuanVan, lv.LinhVucNghienCuu, lv.NgayLap, lv.MoTa, gv.HoTen, lv.SoNhomThamGiaToiDa\r\n" + 
					"from LUANVAN lv\r\n" + 
					"inner join GIAOVIEN gv on gv.MaGiaoVien = lv.MaGiaoVien";
			Statement statement = con.createStatement();
			ResultSet res = statement.executeQuery(sql);
			while (res.next()) {
				String[] rowData = {
						count++ + "",
						res.getString(1),
						res.getString(2),
						res.getString(3),
						res.getString(4),
						res.getString(5),
						res.getString(6),
						res.getString(7)
				};
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(rowData);
				table.setModel(model);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public LuanVan timLuanVanTheoMa(String maLuanVanCanTim) {
		LuanVan lv = null;
		Connection con = Database.getInstance().getConnection();
		String sql = "select *\r\n" + 
				"from LUANVAN lv\r\n" + 
				"where lv.MaLuanVan = '"+ maLuanVanCanTim +"'";
		Statement statement;
		try {
			statement = con.createStatement();
			ResultSet res = statement.executeQuery(sql);
			res.next();
			String maLuanVan = res.getString(1);
			String tenLuanVan = res.getString(2);
			String linhVucNghienCuu = res.getString(3);
			Date ngayLap = new SimpleDateFormat("yyyy-MM-dd").parse(res.getString(4));
			String moTa = res.getString(5);
			String maGiaoVien = res.getString(6);
			int soNhomThamGiaToiDa = res.getInt(7);
			lv = new LuanVan(maLuanVan, tenLuanVan, linhVucNghienCuu, moTa, ngayLap, maGiaoVien, soNhomThamGiaToiDa);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lv;
	}
	
	public boolean kiemTraLuanVanDaTonTai(String tenLuanVanCanKiemTra, String linhVucNghienCuuCanKiemTra) {
		LuanVan lv = null;
		boolean result = true;
		Connection con = Database.getInstance().getConnection();
		String sql = "select *\r\n" + 
				"from LUANVAN lv\r\n" + 
				"where lv.TenLuanVan like N'%"+ tenLuanVanCanKiemTra +"%' and lv.LinhVucNghienCuu like N'%"+ linhVucNghienCuuCanKiemTra +"%'";
		Statement statement;
		ResultSet res = null;
		try {
			statement = con.createStatement();
			res = statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			result = res.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public String sinhMaLuanVanTuDong() {
		String count = null;
		Connection con = Database.getInstance().getConnection();
		String sql = "select COUNT(lv.MaLuanVan)\r\n" + 
				"from LUANVAN lv";
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
		return "LV" + count;
	}
}
