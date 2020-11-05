package giaovukhoa;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;

public class GiaoDien_ThongKe {

	private JFrame frame;
	private JTable table;
	private JTextField txtTongSo;
	private JPanel pnChung;

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
	 */
	public GiaoDien_ThongKe() {
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
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Danh sách sinh viên bảo vệ luận văn thành công", "Danh sách sinh viên bảo vệ luận văn không thành công", "Danh sách sinh viên loại giỏi", "Danh sách sinh viên loại khá", "Danh sách sinh viên loại trung bình", "Danh sách sinh viên loại yếu"}));
		comboBox.setBounds(142, 54, 447, 20);
		panel.add(comboBox);
		
		JLabel lblNamHoc = new JLabel("Năm học: ");
		lblNamHoc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNamHoc.setBounds(647, 53, 75, 19);
		panel.add(lblNamHoc);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"2019 - 2020", "2020 - 2021", "2021 - 2022"}));
		comboBox_1.setBounds(732, 54, 447, 20);
		panel.add(comboBox_1);
		
		JButton btnThongKe = new JButton("Thống kê");
		btnThongKe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThongKe.setBounds(335, 132, 127, 44);
		panel.add(btnThongKe);
		
		JButton btnInDanhSach = new JButton("In danh sách");
		btnInDanhSach.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnInDanhSach.setBounds(696, 132, 127, 44);
		panel.add(btnInDanhSach);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 187, 1224, 660);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "M\u00E3 sinh vi\u00EAn", "T\u00EAn sinh vi\u00EAn", "\u0110i\u1EC3m v\u00F2ng 1", "\u0110i\u1EC3m v\u00F2ng 2", "X\u1EBFp lo\u1EA1i"
			}
		));
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
