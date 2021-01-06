package giaovien;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.Database;
import dao.HoiDongDao;

import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;

public class GiaoDien_XemLichChamDiem {

	private JFrame frame;
	private JTable table;
	private JTextField txtMaHoiDong;
	private JTextField txtTenHoiDong;
	private JTextField txtNgayBaoCao;
	private JTextField txtGioBaoCao;
	private JTextField txtTenDeTai;
	private JTextField txtNamHoc;
	private JTextField textField;
	private JTable table_1;
	private JTable table_2;
	private JPanel pnChung;
	private JButton btnInDanhSach;
	private JComboBox comboBoxTieuChi;
	private JComboBox comboBoxNamHoc;
	private JComboBox comboBoxHocKy;
	private HoiDongDao hoiDongDao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GiaoDien_XemLichChamDiem window = new GiaoDien_XemLichChamDiem();
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
	public GiaoDien_XemLichChamDiem() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Database.getInstance().connec();
		hoiDongDao = new HoiDongDao();
		frame = new JFrame();
		frame.setBounds(100, 100, 1280, 950);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pnChung = new JPanel();
		frame.getContentPane().add(pnChung, BorderLayout.CENTER);
		pnChung.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTieuDe = new JLabel("Lịch chấm điểm luận văn");
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDe.setFont(new Font("Tahoma", Font.PLAIN, 25));
		pnChung.add(lblTieuDe, BorderLayout.NORTH);
		
		JPanel pnCenter = new JPanel();
		pnChung.add(pnCenter, BorderLayout.CENTER);
		pnCenter.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "L\u1ECBch ch\u1EA5m \u0111i\u1EC3m", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 611, 423);
		pnCenter.add(panel);
		panel.setLayout(null);
		
		JLabel lblTieuChi = new JLabel("Tiêu chí: ");
		lblTieuChi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTieuChi.setBounds(31, 26, 60, 19);
		panel.add(lblTieuChi);
		
		comboBoxTieuChi = new JComboBox();
		comboBoxTieuChi.setModel(new DefaultComboBoxModel(new String[] {"Lịch chưa chấm điểm", "Lịch đã chấm điểm"}));
		comboBoxTieuChi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBoxTieuChi.setBounds(116, 25, 174, 20);
		panel.add(comboBoxTieuChi);
		
		JLabel lblNamHoc = new JLabel("Năm học: ");
		lblNamHoc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNamHoc.setBounds(31, 69, 75, 19);
		panel.add(lblNamHoc);
		
		comboBoxNamHoc = new JComboBox();
		comboBoxNamHoc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBoxNamHoc.setBounds(116, 68, 174, 20);
		panel.add(comboBoxNamHoc);
		
		JLabel lblHocKy = new JLabel("Học kỳ: ");
		lblHocKy.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHocKy.setBounds(315, 68, 75, 19);
		panel.add(lblHocKy);
		
		comboBoxHocKy = new JComboBox();
		comboBoxHocKy.setModel(new DefaultComboBoxModel(new String[] {"Học kỳ 1", "Học kỳ 2", "Học kỳ 3"}));
		comboBoxHocKy.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBoxHocKy.setBounds(400, 67, 174, 20);
		panel.add(comboBoxHocKy);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 107, 591, 305);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "M\u00E3 h\u1ED9i \u0111\u1ED3ng", "T\u00EAn h\u1ED9i \u0111\u1ED3ng", "M\u00E3 lu\u1EADn v\u0103n", "T\u00EAn lu\u1EADn v\u0103n", "M\u00E3 nh\u00F3m"
			}
		));
		scrollPane.setViewportView(table);
		
		btnInDanhSach = new JButton("In danh sách");
		btnInDanhSach.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnInDanhSach.setBounds(315, 13, 127, 44);
		panel.add(btnInDanhSach);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Th\u00F4ng tin h\u1ED9i \u0111\u1ED3ng ch\u1EA5m b\u00E1o c\u00E1o", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(631, 11, 623, 423);
		pnCenter.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblMaHoiDong = new JLabel("Mã hội đồng: ");
		lblMaHoiDong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMaHoiDong.setBounds(53, 58, 111, 19);
		panel_1.add(lblMaHoiDong);
		
		txtMaHoiDong = new JTextField();
		txtMaHoiDong.setEditable(false);
		txtMaHoiDong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtMaHoiDong.setBounds(174, 59, 397, 19);
		panel_1.add(txtMaHoiDong);
		txtMaHoiDong.setColumns(10);
		
		JLabel lblTenHoiDong = new JLabel("Tên hội đồng: ");
		lblTenHoiDong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTenHoiDong.setBounds(53, 102, 111, 19);
		panel_1.add(lblTenHoiDong);
		
		txtTenHoiDong = new JTextField();
		txtTenHoiDong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTenHoiDong.setEditable(false);
		txtTenHoiDong.setColumns(10);
		txtTenHoiDong.setBounds(174, 103, 397, 19);
		panel_1.add(txtTenHoiDong);
		
		JLabel lblNgayBaoCao = new JLabel("Ngày báo cáo: ");
		lblNgayBaoCao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNgayBaoCao.setBounds(53, 147, 111, 19);
		panel_1.add(lblNgayBaoCao);
		
		txtNgayBaoCao = new JTextField();
		txtNgayBaoCao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtNgayBaoCao.setEditable(false);
		txtNgayBaoCao.setColumns(10);
		txtNgayBaoCao.setBounds(174, 148, 397, 19);
		panel_1.add(txtNgayBaoCao);
		
		JLabel lblGioBaoCao = new JLabel("Giờ báo cáo: ");
		lblGioBaoCao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGioBaoCao.setBounds(53, 195, 111, 19);
		panel_1.add(lblGioBaoCao);
		
		txtGioBaoCao = new JTextField();
		txtGioBaoCao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtGioBaoCao.setEditable(false);
		txtGioBaoCao.setColumns(10);
		txtGioBaoCao.setBounds(174, 196, 397, 19);
		panel_1.add(txtGioBaoCao);
		
		JLabel lblTenDeTai = new JLabel("Tên đề tài: ");
		lblTenDeTai.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTenDeTai.setBounds(53, 243, 111, 19);
		panel_1.add(lblTenDeTai);
		
		txtTenDeTai = new JTextField();
		txtTenDeTai.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTenDeTai.setEditable(false);
		txtTenDeTai.setColumns(10);
		txtTenDeTai.setBounds(174, 244, 397, 19);
		panel_1.add(txtTenDeTai);
		
		JLabel lblNamHocLV = new JLabel("Năm học: ");
		lblNamHocLV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNamHocLV.setBounds(53, 292, 111, 19);
		panel_1.add(lblNamHocLV);
		
		txtNamHoc = new JTextField();
		txtNamHoc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtNamHoc.setEditable(false);
		txtNamHoc.setColumns(10);
		txtNamHoc.setBounds(174, 293, 397, 19);
		panel_1.add(txtNamHoc);
		
		JLabel lblGiaoVenHuongDan = new JLabel("Giáo viên hướng dẫn: ");
		lblGiaoVenHuongDan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGiaoVenHuongDan.setBounds(53, 343, 153, 19);
		panel_1.add(lblGiaoVenHuongDan);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(216, 344, 355, 19);
		panel_1.add(textField);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Th\u00F4ng tin sinh vi\u00EAn trong nh\u00F3m", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 445, 611, 424);
		pnCenter.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 22, 591, 391);
		panel_2.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "M\u00E3 sinh vi\u00EAn", "T\u00EAn sinh vi\u00EAn", "S\u1ED1 \u0111i\u1EC7n tho\u1EA1i", "M\u00E3 nh\u00F3m"
			}
		));
		scrollPane_1.setViewportView(table_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Th\u00F4ng tin l\u1ECBch ch\u1EA5m \u0111i\u1EC3m", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1_1.setBounds(631, 445, 623, 424);
		pnCenter.add(panel_1_1);
		panel_1_1.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 26, 603, 387);
		panel_1_1.add(scrollPane_2);
		
		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "T\u00EAn h\u1ED9i \u0111\u1ED3ng", "T\u00EAn lu\u1EADn v\u0103n", "M\u00E3 sinh vi\u00EAn", "T\u00EAn sinh vi\u00EAn", "Ng\u00E0y b\u00E1o b\u00E1o", "Gi\u1EDD b\u00E1o c\u00E1o"
			}
		));
		scrollPane_2.setViewportView(table_2);
		
		try {
			capNhat();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public JPanel getPanel() {
		return pnChung;
	}
	
	public void capNhat() throws SQLException {
		updateComboBoxNamHoc();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		hoiDongDao.updateTableLichChamDiem(table, "GV001");
	}
	
	public void updateComboBoxNamHoc() throws SQLException {
		comboBoxNamHoc.setModel(new DefaultComboBoxModel<>());
		Connection con = Database.getInstance().getConnection();
		Statement statement = con.createStatement();
		ResultSet res = statement.executeQuery("SELECT DISTINCT YEAR(NgayLap) AS NamHoc FROM HOIDONG ORDER BY YEAR(NgayLap) ASC");
		while(res.next()) {
			int namHoc_temp = res.getInt(1) + 1;
			comboBoxNamHoc.addItem(res.getString(1) + " - " +namHoc_temp);
		}
	}
	
	
}

/*
* (C) Copyright 2020 IUH. All rights reserved.
*
* @author: AnhTuanIT
* @date: 23-12-2020
* @version: 1.0
*/
