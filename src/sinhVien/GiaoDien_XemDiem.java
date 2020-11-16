package sinhVien;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import dao.Database;
import dao.LuanVanDao;
import dao.SinhVienDao;
import entity.LuanVan;
import entity.SinhVien;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import java.awt.Color;

public class GiaoDien_XemDiem {

	private JFrame frame;
	private JPanel pnChung;
	private JTextField txtGiaoVien1;
	private JTextField txtGiaoVien2;
	private JTextField txtGiaoVien3;
	private JTextField txtGiaoVien4;
	private JTextField txtGiaoVien5;
	private JTextField txtDiemTrungBinh;
	private JTextField txtHoTen;
	private JTextField txtTenLuanVan;
	private JTextField txtKetQua;
	private JTextField txtDiem_GV1;
	private JTextField txtDiem_GV2;
	private JTextField txtDiem_GV3;
	private JTextField txtDiem_GV4;
	private JTextField txtDiem_GV5;
	private SinhVienDao sinhVienDao;
	
	private final String maSinhVien = "SV001";
	private JTextArea txtaGhiChu;
	private LuanVanDao luanVanDao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GiaoDien_XemDiem window = new GiaoDien_XemDiem();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GiaoDien_XemDiem() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Database.getInstance().connec();
		sinhVienDao = new SinhVienDao();
		luanVanDao = new LuanVanDao();
		frame = new JFrame();
		frame.setBounds(100, 100, 1280, 950);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pnChung = new JPanel();
		frame.getContentPane().add(pnChung, BorderLayout.CENTER);
		pnChung.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTieuDe = new JLabel("Xem điểm");
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDe.setFont(new Font("Tahoma", Font.PLAIN, 25));
		pnChung.add(lblTieuDe, BorderLayout.NORTH);
		
		JPanel pnCenter = new JPanel();
		pnCenter.setLayout(null);
		pnChung.add(pnCenter, BorderLayout.CENTER);
		
		JPanel pnDemVong1 = new JPanel();
		pnDemVong1.setLayout(null);
		pnDemVong1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u0110i\u1EC3m b\u1EA3o v\u1EC7 lu\u1EADn v\u0103n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnDemVong1.setBounds(10, 30, 1244, 361);
		pnCenter.add(pnDemVong1);
		
		JLabel lblGiaoVien1 = new JLabel("Giáo viên 1: ");
		lblGiaoVien1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGiaoVien1.setBounds(30, 56, 94, 14);
		pnDemVong1.add(lblGiaoVien1);
		
		JLabel lblGiaoVien2 = new JLabel("Giáo viên 2: ");
		lblGiaoVien2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGiaoVien2.setBounds(30, 106, 94, 14);
		pnDemVong1.add(lblGiaoVien2);
		
		JLabel lblGiaoVien3 = new JLabel("Giáo viên 3: ");
		lblGiaoVien3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGiaoVien3.setBounds(30, 155, 94, 14);
		pnDemVong1.add(lblGiaoVien3);
		
		JLabel lblGiaoVien4 = new JLabel("Giáo viên 4: ");
		lblGiaoVien4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGiaoVien4.setBounds(30, 201, 94, 14);
		pnDemVong1.add(lblGiaoVien4);
		
		JLabel lblGiaoVien5 = new JLabel("Giáo viên 5: ");
		lblGiaoVien5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGiaoVien5.setBounds(30, 246, 94, 14);
		pnDemVong1.add(lblGiaoVien5);
		
		txtGiaoVien1 = new JTextField();
		txtGiaoVien1.setEditable(false);
		txtGiaoVien1.setColumns(10);
		txtGiaoVien1.setBounds(149, 53, 886, 20);
		pnDemVong1.add(txtGiaoVien1);
		
		txtGiaoVien2 = new JTextField();
		txtGiaoVien2.setEditable(false);
		txtGiaoVien2.setColumns(10);
		txtGiaoVien2.setBounds(149, 103, 886, 20);
		pnDemVong1.add(txtGiaoVien2);
		
		txtGiaoVien3 = new JTextField();
		txtGiaoVien3.setEditable(false);
		txtGiaoVien3.setColumns(10);
		txtGiaoVien3.setBounds(149, 152, 886, 20);
		pnDemVong1.add(txtGiaoVien3);
		
		txtGiaoVien4 = new JTextField();
		txtGiaoVien4.setEditable(false);
		txtGiaoVien4.setColumns(10);
		txtGiaoVien4.setBounds(149, 198, 886, 20);
		pnDemVong1.add(txtGiaoVien4);
		
		txtGiaoVien5 = new JTextField();
		txtGiaoVien5.setEditable(false);
		txtGiaoVien5.setColumns(10);
		txtGiaoVien5.setBounds(149, 243, 886, 20);
		pnDemVong1.add(txtGiaoVien5);
		
		JLabel lblDiemTrungBinh = new JLabel("Điểm trung bình: ");
		lblDiemTrungBinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDiemTrungBinh.setBounds(30, 296, 113, 14);
		pnDemVong1.add(lblDiemTrungBinh);
		
		txtDiemTrungBinh = new JTextField();
		txtDiemTrungBinh.setEditable(false);
		txtDiemTrungBinh.setColumns(10);
		txtDiemTrungBinh.setBounds(149, 295, 1055, 20);
		pnDemVong1.add(txtDiemTrungBinh);
		
		txtDiem_GV1 = new JTextField();
		txtDiem_GV1.setEditable(false);
		txtDiem_GV1.setBounds(1062, 55, 142, 20);
		pnDemVong1.add(txtDiem_GV1);
		txtDiem_GV1.setColumns(10);
		
		txtDiem_GV2 = new JTextField();
		txtDiem_GV2.setEditable(false);
		txtDiem_GV2.setColumns(10);
		txtDiem_GV2.setBounds(1062, 100, 142, 20);
		pnDemVong1.add(txtDiem_GV2);
		
		txtDiem_GV3 = new JTextField();
		txtDiem_GV3.setEditable(false);
		txtDiem_GV3.setColumns(10);
		txtDiem_GV3.setBounds(1062, 155, 142, 20);
		pnDemVong1.add(txtDiem_GV3);
		
		txtDiem_GV4 = new JTextField();
		txtDiem_GV4.setEditable(false);
		txtDiem_GV4.setColumns(10);
		txtDiem_GV4.setBounds(1062, 203, 142, 20);
		pnDemVong1.add(txtDiem_GV4);
		
		txtDiem_GV5 = new JTextField();
		txtDiem_GV5.setEditable(false);
		txtDiem_GV5.setColumns(10);
		txtDiem_GV5.setBounds(1062, 248, 142, 20);
		pnDemVong1.add(txtDiem_GV5);
		
		JPanel pnKetQua = new JPanel();
		pnKetQua.setLayout(null);
		pnKetQua.setBorder(new TitledBorder(null, "K\u1EBFt qu\u1EA3 b\u1EA3o v\u1EC7 lu\u1EADn v\u0103n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnKetQua.setBounds(10, 418, 1244, 451);
		pnCenter.add(pnKetQua);
		
		JLabel lblHoTen = new JLabel("Họ tên: ");
		lblHoTen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblHoTen.setBounds(62, 35, 119, 25);
		pnKetQua.add(lblHoTen);
		
		JLabel lblTenLuanVan = new JLabel("Tên luận văn: ");
		lblTenLuanVan.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTenLuanVan.setBounds(62, 101, 134, 25);
		pnKetQua.add(lblTenLuanVan);
		
		JLabel lblKetQua = new JLabel("Kết quả: ");
		lblKetQua.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblKetQua.setBounds(62, 164, 119, 25);
		pnKetQua.add(lblKetQua);
		
		JLabel lblGhiChuLuanVan = new JLabel("Ghi Chú: ");
		lblGhiChuLuanVan.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblGhiChuLuanVan.setBounds(62, 234, 119, 25);
		pnKetQua.add(lblGhiChuLuanVan);
		
		txtHoTen = new JTextField();
		txtHoTen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtHoTen.setEditable(false);
		txtHoTen.setColumns(10);
		txtHoTen.setBounds(191, 35, 961, 25);
		pnKetQua.add(txtHoTen);
		
		txtTenLuanVan = new JTextField();
		txtTenLuanVan.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtTenLuanVan.setEditable(false);
		txtTenLuanVan.setColumns(10);
		txtTenLuanVan.setBounds(191, 106, 961, 25);
		pnKetQua.add(txtTenLuanVan);
		
		txtKetQua = new JTextField();
		txtKetQua.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtKetQua.setEditable(false);
		txtKetQua.setColumns(10);
		txtKetQua.setBounds(191, 169, 961, 25);
		pnKetQua.add(txtKetQua);
		
		txtaGhiChu = new JTextArea();
		txtaGhiChu.setFont(new Font("Monospaced", Font.PLAIN, 18));
		txtaGhiChu.setEditable(false);
		txtaGhiChu.setBounds(191, 234, 961, 136);
		pnKetQua.add(txtaGhiChu);
		
		updateTextField();
	}
	
	public JPanel getPanel() {
		return pnChung;
	}
	
	public void updateTextField() {
		ResultSet res = sinhVienDao.xemDiem(maSinhVien);
		SinhVien sv = sinhVienDao.timSinhVien(maSinhVien);
		LuanVan lv = luanVanDao.timLuanVanTheoMaSinhVien(maSinhVien);
		int count = 0;
		float result = 0;
		String ghiChu = "";
		JTextField[][] listTextField = {
				{txtGiaoVien1, txtDiem_GV1},
				{txtGiaoVien2, txtDiem_GV2},
				{txtGiaoVien3, txtDiem_GV3},
				{txtGiaoVien4, txtDiem_GV4},
				{txtGiaoVien5, txtDiem_GV5}
		};
		try {
			while(res.next()) {
				listTextField[count][0].setText(res.getString(1));
				listTextField[count][1].setText(res.getString(2));
				ghiChu += " " + res.getString(3);
				result += res.getFloat(2);
				count++;
			}
			txtDiemTrungBinh.setText(result / count + "");
			txtaGhiChu.setText(ghiChu);
			
			txtHoTen.setText(sv.getHoTen());
			txtTenLuanVan.setText(lv.getTenLuanVan());
			if(count == 5) {
				if(result / count > 5) {
					txtKetQua.setText("Bảo vệ luận văn thành công");
				} else {
					txtKetQua.setText("Bảo vệ luận văn thất bại");
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

/*
* (C) Copyright 2020 IUH. All rights reserved.
*
* @author: AnhTuanIT
* @date: 24-10-2020
* @version: 1.0
*/
