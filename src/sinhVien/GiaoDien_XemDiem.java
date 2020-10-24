package sinhVien;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class GiaoDien_XemDiem {

	private JFrame frame;
	private JPanel pnChung;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;

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
		pnDemVong1.setBorder(new TitledBorder(null, "\u0110i\u1EC3m v\u00F2ng 1", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnDemVong1.setBounds(10, 30, 616, 447);
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
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(134, 53, 441, 20);
		pnDemVong1.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(134, 103, 441, 20);
		pnDemVong1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(134, 152, 441, 20);
		pnDemVong1.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(134, 198, 441, 20);
		pnDemVong1.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(134, 243, 441, 20);
		pnDemVong1.add(textField_4);
		
		JLabel lblDiemVong1 = new JLabel("Điểm vòng 1: ");
		lblDiemVong1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDiemVong1.setBounds(30, 296, 94, 14);
		pnDemVong1.add(lblDiemVong1);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(134, 295, 441, 20);
		pnDemVong1.add(textField_5);
		
		JLabel lblGhiChu = new JLabel("Ghi chú: ");
		lblGhiChu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGhiChu.setBounds(30, 348, 94, 14);
		pnDemVong1.add(lblGhiChu);
		
		JTextArea txtaGhiChu = new JTextArea();
		txtaGhiChu.setEditable(false);
		txtaGhiChu.setBounds(134, 345, 441, 79);
		pnDemVong1.add(txtaGhiChu);
		
		JPanel pnDiemVong2 = new JPanel();
		pnDiemVong2.setLayout(null);
		pnDiemVong2.setBorder(new TitledBorder(null, "\u0110i\u1EC3m v\u00F2ng 2", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnDiemVong2.setBounds(636, 30, 618, 447);
		pnCenter.add(pnDiemVong2);
		
		JLabel lblGiaoVien1_1 = new JLabel("Giáo viên 1: ");
		lblGiaoVien1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGiaoVien1_1.setBounds(38, 55, 94, 14);
		pnDiemVong2.add(lblGiaoVien1_1);
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBounds(142, 52, 441, 20);
		pnDiemVong2.add(textField_6);
		
		JLabel lblGiaoVien2_1 = new JLabel("Giáo viên 2: ");
		lblGiaoVien2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGiaoVien2_1.setBounds(38, 105, 94, 14);
		pnDiemVong2.add(lblGiaoVien2_1);
		
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		textField_7.setBounds(142, 102, 441, 20);
		pnDiemVong2.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setEditable(false);
		textField_8.setColumns(10);
		textField_8.setBounds(142, 151, 441, 20);
		pnDiemVong2.add(textField_8);
		
		JLabel lblGiaoVien3_1 = new JLabel("Giáo viên 3: ");
		lblGiaoVien3_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGiaoVien3_1.setBounds(38, 154, 94, 14);
		pnDiemVong2.add(lblGiaoVien3_1);
		
		JLabel lblGiaoVien4_1 = new JLabel("Giáo viên 4: ");
		lblGiaoVien4_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGiaoVien4_1.setBounds(38, 200, 94, 14);
		pnDiemVong2.add(lblGiaoVien4_1);
		
		textField_9 = new JTextField();
		textField_9.setEditable(false);
		textField_9.setColumns(10);
		textField_9.setBounds(142, 197, 441, 20);
		pnDiemVong2.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setEditable(false);
		textField_10.setColumns(10);
		textField_10.setBounds(142, 242, 441, 20);
		pnDiemVong2.add(textField_10);
		
		JLabel lblGiaoVien5_1 = new JLabel("Giáo viên 5: ");
		lblGiaoVien5_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGiaoVien5_1.setBounds(38, 245, 94, 14);
		pnDiemVong2.add(lblGiaoVien5_1);
		
		JLabel lblDiemVong2 = new JLabel("Điểm vòng 2:");
		lblDiemVong2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDiemVong2.setBounds(38, 295, 94, 14);
		pnDiemVong2.add(lblDiemVong2);
		
		textField_11 = new JTextField();
		textField_11.setEditable(false);
		textField_11.setColumns(10);
		textField_11.setBounds(142, 294, 441, 20);
		pnDiemVong2.add(textField_11);
		
		JLabel lblGhiChu_1 = new JLabel("Ghi chú: ");
		lblGhiChu_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGhiChu_1.setBounds(38, 347, 94, 14);
		pnDiemVong2.add(lblGhiChu_1);
		
		JTextArea txtaGhiChu_1 = new JTextArea();
		txtaGhiChu_1.setEditable(false);
		txtaGhiChu_1.setBounds(142, 344, 441, 79);
		pnDiemVong2.add(txtaGhiChu_1);
		
		JPanel pnKetQua = new JPanel();
		pnKetQua.setLayout(null);
		pnKetQua.setBorder(new TitledBorder(null, "K\u1EBFt qu\u1EA3 b\u1EA3o v\u1EC7 lu\u1EADn v\u0103n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnKetQua.setBounds(10, 488, 1244, 381);
		pnCenter.add(pnKetQua);
		
		JLabel lblHoTen = new JLabel("Họ tên: ");
		lblHoTen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblHoTen.setBounds(62, 35, 119, 25);
		pnKetQua.add(lblHoTen);
		
		JLabel lblTenLuanVan = new JLabel("Tên luận văn: ");
		lblTenLuanVan.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTenLuanVan.setBounds(62, 101, 134, 25);
		pnKetQua.add(lblTenLuanVan);
		
		JLabel lblTenDeTai = new JLabel("Tên đề tài: ");
		lblTenDeTai.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTenDeTai.setBounds(62, 165, 119, 25);
		pnKetQua.add(lblTenDeTai);
		
		JLabel lblKetQua = new JLabel("Kết quả: ");
		lblKetQua.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblKetQua.setBounds(62, 227, 119, 25);
		pnKetQua.add(lblKetQua);
		
		JLabel lblGhiChuLuanVan = new JLabel("Ghi Chú: ");
		lblGhiChuLuanVan.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblGhiChuLuanVan.setBounds(62, 288, 119, 25);
		pnKetQua.add(lblGhiChuLuanVan);
		
		textField_12 = new JTextField();
		textField_12.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_12.setEditable(false);
		textField_12.setColumns(10);
		textField_12.setBounds(191, 35, 961, 25);
		pnKetQua.add(textField_12);
		
		textField_13 = new JTextField();
		textField_13.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_13.setEditable(false);
		textField_13.setColumns(10);
		textField_13.setBounds(191, 106, 961, 25);
		pnKetQua.add(textField_13);
		
		textField_14 = new JTextField();
		textField_14.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_14.setEditable(false);
		textField_14.setColumns(10);
		textField_14.setBounds(191, 170, 961, 25);
		pnKetQua.add(textField_14);
		
		textField_15 = new JTextField();
		textField_15.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_15.setEditable(false);
		textField_15.setColumns(10);
		textField_15.setBounds(191, 232, 961, 25);
		pnKetQua.add(textField_15);
		
		JTextArea txtGhiChu = new JTextArea();
		txtGhiChu.setFont(new Font("Monospaced", Font.PLAIN, 18));
		txtGhiChu.setEditable(false);
		txtGhiChu.setBounds(191, 288, 961, 69);
		pnKetQua.add(txtGhiChu);
	}
	public JPanel getPanel() {
		return pnChung;
	}
}

/*
* (C) Copyright 2020 IUH. All rights reserved.
*
* @author: AnhTuanIT
* @date: 24-10-2020
* @version: 1.0
*/
