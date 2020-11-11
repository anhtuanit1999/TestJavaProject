package giaovukhoa;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

public class GiaoDien_PhanCongHoiDong {

	private JFrame frame;
	private JTextField txtTenHoiDong;
	private JTextField txtMaHoiDong;
	private JTable table;
	private JTextField txtTimGiaoVien;
	private JTable table_1;
	private JPanel pnChung;
	private JTextField txtNgayBaoVe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GiaoDien_PhanCongHoiDong window = new GiaoDien_PhanCongHoiDong();
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
	public GiaoDien_PhanCongHoiDong() {
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
		
		JLabel lblPhanCongHoiDong = new JLabel("Phân công hội đồng");
		lblPhanCongHoiDong.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhanCongHoiDong.setFont(new Font("Tahoma", Font.PLAIN, 25));
		pnChung.add(lblPhanCongHoiDong, BorderLayout.NORTH);
		
		JPanel pnCenter = new JPanel();
		pnChung.add(pnCenter, BorderLayout.CENTER);
		pnCenter.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Th\u00F4ng tin h\u1ED9i \u0111\u1ED3ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 631, 307);
		pnCenter.add(panel);
		panel.setLayout(null);
		
		JLabel lblTenHoiDong = new JLabel("Tên hội đồng: ");
		lblTenHoiDong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTenHoiDong.setBounds(35, 46, 109, 19);
		panel.add(lblTenHoiDong);
		
		txtTenHoiDong = new JTextField();
		txtTenHoiDong.setBounds(154, 47, 456, 20);
		panel.add(txtTenHoiDong);
		txtTenHoiDong.setColumns(10);
		
		JLabel lblMaHoiDong = new JLabel("Mã hội đồng: ");
		lblMaHoiDong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMaHoiDong.setBounds(35, 88, 109, 19);
		panel.add(lblMaHoiDong);
		
		txtMaHoiDong = new JTextField();
		txtMaHoiDong.setEditable(false);
		txtMaHoiDong.setColumns(10);
		txtMaHoiDong.setBounds(154, 89, 456, 20);
		panel.add(txtMaHoiDong);
		
		JLabel lblNamHoc = new JLabel("Năm học: ");
		lblNamHoc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNamHoc.setBounds(35, 131, 109, 19);
		panel.add(lblNamHoc);
		
		JComboBox comboBoxNamHoc = new JComboBox();
		comboBoxNamHoc.setModel(new DefaultComboBoxModel(new String[] {"2019", "2020", "2021", "2022"}));
		comboBoxNamHoc.setBounds(154, 132, 456, 20);
		panel.add(comboBoxNamHoc);
		
		JLabel lblTenLuanVan = new JLabel("Tên đề tài: ");
		lblTenLuanVan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTenLuanVan.setBounds(35, 180, 109, 19);
		panel.add(lblTenLuanVan);
		
		JComboBox comboBoxTenDeTai = new JComboBox();
		comboBoxTenDeTai.setBounds(154, 181, 456, 20);
		panel.add(comboBoxTenDeTai);
		
		JLabel lblTenNhom = new JLabel("Tên nhóm: ");
		lblTenNhom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTenNhom.setBounds(35, 232, 109, 19);
		panel.add(lblTenNhom);
		
		JComboBox comboBoxTenNhom = new JComboBox();
		comboBoxTenNhom.setBounds(154, 233, 456, 20);
		panel.add(comboBoxTenNhom);
		
		JLabel lblNgayBaoVe = new JLabel("Ngày bảo vệ: ");
		lblNgayBaoVe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNgayBaoVe.setBounds(35, 275, 109, 19);
		panel.add(lblNgayBaoVe);
		
		txtNgayBaoVe = new JTextField();
		txtNgayBaoVe.setColumns(10);
		txtNgayBaoVe.setBounds(154, 276, 456, 20);
		panel.add(txtNgayBaoVe);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Danh s\u00E1ch gi\u00E1o vi\u00EAn thu\u1ED9c h\u1ED9i \u0111\u1ED3ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(651, 11, 603, 307);
		pnCenter.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 22, 583, 240);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"Ch\u1ECDn", "STT", "M\u00E3 gi\u00E1o vi\u00EAn", "Vai tr\u00F2", "T\u00EAn gi\u00E1o vi\u00EAn", "T\u00EAn h\u1ED9i \u0111\u1ED3ng"
			}
		) {
			Class[] columnTypes = new Class[] {
				Boolean.class, Object.class, Object.class, Object.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Danh s\u00E1ch gi\u00E1o vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 329, 1244, 540);
		pnCenter.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblTinGiaoVien = new JLabel("Tên giáo viên: ");
		lblTinGiaoVien.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTinGiaoVien.setBounds(36, 37, 109, 19);
		panel_2.add(lblTinGiaoVien);
		
		txtTimGiaoVien = new JTextField();
		txtTimGiaoVien.setBounds(155, 38, 1052, 20);
		panel_2.add(txtTimGiaoVien);
		txtTimGiaoVien.setColumns(10);
		
		JLabel lblTieuChi = new JLabel("Tiêu chí: ");
		lblTieuChi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTieuChi.setBounds(36, 80, 109, 19);
		panel_2.add(lblTieuChi);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Họ tên giáo viên", "Mã giáo viên", "Đơn vị công tác", "Chức danh", "Khoa công tác"}));
		comboBox.setBounds(155, 81, 1052, 20);
		panel_2.add(comboBox);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 167, 1224, 396);
		panel_2.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"Ch\u1ECDn", "STT", "M\u00E3 gi\u00E1o vi\u00EAn", "T\u00EAn gi\u00E1o vi\u00EAn", "\u0110\u01A1n v\u1ECB c\u00F4ng t\u00E1c", "Khoa c\u00F4ng t\u00E1c", "L\u0129nh v\u1EF1c c\u00F4ng t\u00E1c"
			}
		) {
			Class[] columnTypes = new Class[] {
				Boolean.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane_1.setViewportView(table_1);
		
		JButton btnTimGiaoVien = new JButton("Tìm giáo viên");
		btnTimGiaoVien.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTimGiaoVien.setBounds(214, 112, 127, 44);
		panel_2.add(btnTimGiaoVien);
		
		JButton btnChonGiaoVien = new JButton("Chọn giáo viên");
		btnChonGiaoVien.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnChonGiaoVien.setBounds(418, 112, 143, 44);
		panel_2.add(btnChonGiaoVien);
		
		JButton btnBoChonGiaoVien = new JButton("Bỏ chọn giáo viên");
		btnBoChonGiaoVien.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBoChonGiaoVien.setBounds(621, 112, 157, 44);
		panel_2.add(btnBoChonGiaoVien);
		
		JButton btnLuuHoiDong = new JButton("Lưu hội đồng");
		btnLuuHoiDong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLuuHoiDong.setBounds(851, 112, 127, 44);
		panel_2.add(btnLuuHoiDong);
	}
	public JPanel getPanel() {
		return pnChung;
	}
}

/*
* (C) Copyright 2020 IUH. All rights reserved.
*
* @author: AnhTuanIT
* @date: 05-11-2020
* @version: 1.0
*/
