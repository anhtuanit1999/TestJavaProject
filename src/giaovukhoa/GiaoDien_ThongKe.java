package giaovukhoa;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import antlr.collections.List;
import dao.Database;
import entity.ThongKeSinhVien;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.event.ActionEvent;

public class GiaoDien_ThongKe implements ActionListener {

	private JFrame frame;
	private JTable table;
	private JTextField txtTongSo;
	private JPanel pnChung;
	private JComboBox comboBoxNamHoc;
	private JComboBox comboBoxTieuChi;
	private DefaultTableModel modelTable;
	private ArrayList<ThongKeSinhVien> list;
	private JComboBox comboBoxHocKy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GiaoDien_ThongKe window = new GiaoDien_ThongKe();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 */
	public GiaoDien_ThongKe() throws SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 */
	private void initialize() throws SQLException {
		Database.getInstance().connec();
		frame = new JFrame();
		frame.setBounds(100, 100, 1280, 950);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pnChung = new JPanel();
		frame.getContentPane().add(pnChung, BorderLayout.CENTER);
		pnChung.setLayout(new BorderLayout(0, 0));
		
		JLabel lblThongKe = new JLabel("Thống kê");
		lblThongKe.setHorizontalAlignment(SwingConstants.CENTER);
		lblThongKe.setFont(new Font("Tahoma", Font.PLAIN, 25));
		pnChung.add(lblThongKe, BorderLayout.NORTH);
		
		JPanel pnCenter = new JPanel();
		pnChung.add(pnCenter, BorderLayout.CENTER);
		pnCenter.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Th\u00F4ng tin c\u1EA7n th\u1ED1ng k\u00EA", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 1244, 858);
		pnCenter.add(panel);
		panel.setLayout(null);
		
		JLabel lblTieuChi = new JLabel("Tiêu chí: ");
		lblTieuChi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTieuChi.setBounds(57, 53, 75, 19);
		panel.add(lblTieuChi);
		
		comboBoxTieuChi = new JComboBox();
		comboBoxTieuChi.setModel(new DefaultComboBoxModel(new String[] {"Chọn tiêu chí...", "Danh sách sinh viên bảo vệ luận văn thành công", "Danh sách sinh viên bảo vệ luận văn không thành công", "Danh sách sinh viên loại giỏi", "Danh sách sinh viên loại khá", "Danh sách sinh viên loại trung bình", "Danh sách sinh viên loại yếu"}));
		comboBoxTieuChi.setBounds(142, 54, 447, 20);
		panel.add(comboBoxTieuChi);
		
		JLabel lblNamHoc = new JLabel("Năm học: ");
		lblNamHoc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNamHoc.setBounds(647, 53, 75, 19);
		panel.add(lblNamHoc);
		
		comboBoxNamHoc = new JComboBox();
		comboBoxNamHoc.setBounds(732, 54, 182, 20);
		panel.add(comboBoxNamHoc);
		
		JButton btnInDanhSach = new JButton("In danh sách");
		btnInDanhSach.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnInDanhSach.setBounds(558, 133, 127, 44);
		panel.add(btnInDanhSach);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 187, 1224, 660);
		panel.add(scrollPane);
		
		table = new JTable();
		modelTable = new DefaultTableModel("STT, Mã Sinh Viên, Tên Sinh Viên, Điểm Trung Bình, Xếp Loại".split(","), 0);
		table.setModel(modelTable);
		scrollPane.setViewportView(table);
		
		JLabel lblTongSo = new JLabel("Tổng số:");
		lblTongSo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTongSo.setBounds(57, 95, 75, 19);
		panel.add(lblTongSo);
		
		txtTongSo = new JTextField();
		txtTongSo.setEditable(false);
		txtTongSo.setBounds(142, 96, 1037, 20);
		panel.add(txtTongSo);
		txtTongSo.setColumns(10);
		
		JLabel lblHocKy = new JLabel("Học kỳ: ");
		lblHocKy.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHocKy.setBounds(924, 53, 75, 19);
		panel.add(lblHocKy);
		
		comboBoxHocKy = new JComboBox();
		comboBoxHocKy.setModel(new DefaultComboBoxModel(new String[] {"Chọn học kỳ", "Học kỳ 1", "Học kỳ 2", "Học kỳ 3"}));
		comboBoxHocKy.setBounds(1009, 54, 170, 20);
		panel.add(comboBoxHocKy);
		updateComboBoxNamHoc();
		
		
		comboBoxNamHoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modelTable.setRowCount(0);
				comboBoxTieuChi.setSelectedItem("Chọn tiêu chí...");
				if(comboBoxNamHoc.getSelectedIndex() == 0) {				
					return;
				}
				try {
					updateDanhSachSinhVien();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		comboBoxNamHoc.addActionListener(this);
		comboBoxTieuChi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					updateDanhSachSinhVien();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				modelTable.setRowCount(0);
				int i = 1;
				if(comboBoxNamHoc.getSelectedIndex() == 0) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn năm học!");
					return;
				}
				if(comboBoxTieuChi.getSelectedItem().toString().equalsIgnoreCase("Danh sách sinh viên bảo vệ luận văn thành công")) {
					for(ThongKeSinhVien tk: list) {
						if(tk.getXepLoai().equalsIgnoreCase("Yếu") == false) {
							Object[] rowData = {
										i,
										tk.getMaSinhVien(),
										tk.getTenSinhVien(),
										tk.getDiemTB(),
										tk.getXepLoai()
							};
							modelTable.addRow(rowData);
							i++;
						}	
					}
				}else if(comboBoxTieuChi.getSelectedItem().toString().equalsIgnoreCase("Danh sách sinh viên bảo vệ luận văn không thành công")) {
					for(ThongKeSinhVien tk: list) {
						if(tk.getXepLoai().equalsIgnoreCase("Yếu")) {
							Object[] rowData = {
										i,
										tk.getMaSinhVien(),
										tk.getTenSinhVien(),
										tk.getDiemTB(),
										tk.getXepLoai()
							};
							modelTable.addRow(rowData);
							i++;
						}	
					}
				}else if(comboBoxTieuChi.getSelectedItem().toString().equalsIgnoreCase("Danh sách sinh viên loại giỏi")) {
					for(ThongKeSinhVien tk: list) {
						if(tk.getXepLoai().equalsIgnoreCase("Giỏi")) {
							Object[] rowData = {
										i,
										tk.getMaSinhVien(),
										tk.getTenSinhVien(),
										tk.getDiemTB(),
										tk.getXepLoai()
							};
							modelTable.addRow(rowData);
							i++;
						}	
					}
				}else if(comboBoxTieuChi.getSelectedItem().toString().equalsIgnoreCase("Danh sách sinh viên loại khá")) {
					for(ThongKeSinhVien tk: list) {
						if(tk.getXepLoai().equalsIgnoreCase("Khá")) {
							Object[] rowData = {
										i,
										tk.getMaSinhVien(),
										tk.getTenSinhVien(),
										tk.getDiemTB(),
										tk.getXepLoai()
							};
							modelTable.addRow(rowData);
							i++;
						}	
					}
				}else if(comboBoxTieuChi.getSelectedItem().toString().equalsIgnoreCase("Danh sách sinh viên loại trung bình")) {
					for(ThongKeSinhVien tk: list) {
						if(tk.getXepLoai().equalsIgnoreCase("Trung Bình")) {
							Object[] rowData = {
										i,
										tk.getMaSinhVien(),
										tk.getTenSinhVien(),
										tk.getDiemTB(),
										tk.getXepLoai()
							};
							modelTable.addRow(rowData);
							i++;
						}	
					}
				}else if(comboBoxTieuChi.getSelectedItem().toString().equalsIgnoreCase("Danh sách sinh viên loại yếu")) {
					for(ThongKeSinhVien tk: list) {
						if(tk.getXepLoai().equalsIgnoreCase("Yếu")) {
							Object[] rowData = {
										i,
										tk.getMaSinhVien(),
										tk.getTenSinhVien(),
										tk.getDiemTB(),
										tk.getXepLoai()
							};
							modelTable.addRow(rowData);
							i++;
						}	
					}
				}
				txtTongSo.setText(String.valueOf(table.getRowCount()));
			}
		});
		
		btnInDanhSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MessageFormat header = new MessageFormat(comboBoxTieuChi.getSelectedItem().toString().toUpperCase());
				MessageFormat footer = new MessageFormat("Page {0,number,integer}");
				try {
					table.print(JTable.PrintMode.FIT_WIDTH, header, footer);
					
				} catch (PrinterException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});
		
	}
	public JPanel getPanel() {
		return pnChung;
	}
	
	public String[] xuLyHocKy() {
		String[] hocKy = {"1", "12"};
		String hk = comboBoxHocKy.getSelectedItem().toString();
		if(hk.equals("Học kỳ 1")) {
			hocKy = new String[] {"1", "4"};
		} else if(hk.equals("Học kỳ 2")) {
			hocKy = new String[] {"5", "8"};
		} else if(hk.equals("Học kỳ 3")) {
			hocKy = new String[] {"9", "12"};
		}
		return hocKy;
	}
	
	public void updateComboBoxNamHoc() throws SQLException {
		comboBoxNamHoc.addItem("Chọn năm học...");
		Connection con = Database.getInstance().getConnection();
		Statement statement = con.createStatement();
		ResultSet res = statement.executeQuery("SELECT DISTINCT YEAR(NgayBaoCao) AS NamHoc FROM HOIDONG ORDER BY YEAR(NgayBaoCao) ASC");
		while(res.next()) {
			int namHoc_temp = res.getInt(1) + 1;
			comboBoxNamHoc.addItem(res.getString(1) + " - " +namHoc_temp);
		}
	}
	
	public void updateDanhSachSinhVien() throws SQLException {
		list = new ArrayList<ThongKeSinhVien>();
		double diemTB = -1;
		String maSinhVien;
		String tenSinhVien;
		String xepLoai;
		String namHoc = comboBoxNamHoc.getSelectedItem().toString().substring(0, 4); 
		String[] hocKy = xuLyHocKy();
		Connection con = Database.getInstance().getConnection();
		Statement statement = con.createStatement();
		ResultSet res = statement.executeQuery("SELECT DIEMBAOVELUANVAN.MaSinhVien, SINHVIEN.HoTen, AVG(Diem)"
				+ " AS DTB FROM DIEMBAOVELUANVAN JOIN SINHVIEN ON"
				+ " DIEMBAOVELUANVAN.MaSinhVien = SINHVIEN.MaSinhVien GROUP BY DIEMBAOVELUANVAN.MaSinhVien, SINHVIEN.HoTen"
				+ " HAVING DIEMBAOVELUANVAN.MaSinhVien IN (SELECT MaSinhVien FROM SINHVIEN WHERE MaNhom IN"
				+ " (SELECT MaNhom FROM DANHSACH_DANGKYLUANVAN WHERE YEAR(NgayBaoCao) like '"+namHoc+"' and MONTH(NgayBaoCao) >= "+ hocKy[0] +" and MONTH(NgayBaoCao) <= "+ hocKy[1] +"))");
		while (res.next()) {
			maSinhVien = res.getString(1);
			tenSinhVien = res.getNString(2);
			diemTB = res.getDouble(3);
			if(diemTB >= 8.5) {
				xepLoai = "Giỏi";
			}else if(diemTB >= 6.5) {
				xepLoai = "Khá";
			}else if(diemTB >= 5) {
				xepLoai = "Trung Bình";
			}else {
				xepLoai = "Yếu";
			}
			ThongKeSinhVien tk = new ThongKeSinhVien(maSinhVien, tenSinhVien, diemTB, xepLoai);
			list.add(tk);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(comboBoxHocKy)) {
			
		}
	}
	

}

/*
* (C) Copyright 2020 IUH. All rights reserved.
*
* @author: AnhTuanIT
* @date: 05-11-2020
* @version: 1.0
*/
