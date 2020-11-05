package sinhVien;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class GiaoDien_TimDeTai {

	private JFrame frame;
	private JTextField textField;
	private JTable table;
	private JPanel pnChung;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GiaoDien_TimDeTai window = new GiaoDien_TimDeTai();
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
	public GiaoDien_TimDeTai() {
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
		
		JLabel lblTieuDe = new JLabel("Tìm đề tài");
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDe.setFont(new Font("Tahoma", Font.PLAIN, 25));
		pnChung.add(lblTieuDe, BorderLayout.NORTH);
		
		JPanel pnCenter = new JPanel();
		pnChung.add(pnCenter, BorderLayout.CENTER);
		pnCenter.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Th\u00F4ng tin \u0111\u1EC1 t\u00E0i c\u1EA7n t\u00ECm", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 11, 1244, 458);
		pnCenter.add(panel);
		panel.setLayout(null);
		
		JLabel lblThongTinDeTai = new JLabel("Nhập thông tin đề tài: ");
		lblThongTinDeTai.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblThongTinDeTai.setBounds(52, 72, 156, 28);
		panel.add(lblThongTinDeTai);
		
		textField = new JTextField();
		textField.setBounds(218, 78, 948, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblTieuChi = new JLabel("Tìm theo tiêu chí: ");
		lblTieuChi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTieuChi.setBounds(52, 134, 156, 28);
		panel.add(lblTieuChi);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Mã đề tài", "Tên đề tài", "Mô tả", "Tên giáo viên ra đề tài"}));
		comboBox.setBounds(218, 140, 948, 22);
		panel.add(comboBox);
		
		JLabel lblNamHoc = new JLabel("Năm học: ");
		lblNamHoc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNamHoc.setBounds(52, 200, 156, 28);
		panel.add(lblNamHoc);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Không", "2019 - 2020", "2020 - 2021", "2021 - 2022"}));
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_1.setBounds(218, 206, 373, 22);
		panel.add(comboBox_1);
		
		JLabel lblHocKy = new JLabel("Học kỳ: ");
		lblHocKy.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHocKy.setBounds(601, 200, 156, 28);
		panel.add(lblHocKy);
		
		JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1_1.setModel(new DefaultComboBoxModel(new String[] {"Không", "Kỳ 1", "Kỳ 2"}));
		comboBox_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_1_1.setBounds(767, 206, 399, 22);
		panel.add(comboBox_1_1);
		
		JButton btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTimKiem.setBounds(323, 343, 127, 44);
		panel.add(btnTimKiem);
		
		JButton btnXoaTrang = new JButton("Xóa trắng");
		btnXoaTrang.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnXoaTrang.setBounds(785, 343, 127, 44);
		panel.add(btnXoaTrang);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Danh s\u00E1ch \u0111\u1EC1 t\u00E0i tr\u00F9ng kh\u1EDBp", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 480, 1244, 389);
		pnCenter.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 23, 1224, 355);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "M\u00E3 \u0111\u1EC1 t\u00E0i", "T\u00EAn \u0111\u1EC1 t\u00E0i", "M\u00F4 t\u1EA3", "Gi\u00E1o vi\u00EAn ra \u0111\u1EC1 t\u00E0i", "S\u1ED1 nh\u00F3m tham gia"
			}
		));
		scrollPane.setViewportView(table);
	}
	public JPanel getPanel() {
		return pnChung;
	}
}

/*
* (C) Copyright 2020 IUH. All rights reserved.
*
* @author: AnhTuanIT
* @date: 03-11-2020
* @version: 1.0
*/