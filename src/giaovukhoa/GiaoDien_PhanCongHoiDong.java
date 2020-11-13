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
import com.toedter.components.JLocaleChooser;
import com.toedter.calendar.JDateChooser;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;

public class GiaoDien_PhanCongHoiDong implements ActionListener {

	private JFrame frame;
	private JTextField txtMaHoiDong;
	private JPanel pnChung;
	private JTextField txtMaHoiDongMoi;
	private JTextField textField_1;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTextField textField;
	private JTextField textField_2;
	private JButton btnChonCongViec;
	private GiaoDien_ChonCongViec GD_CCV;

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
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "H\u1ED9i \u0111\u1ED3ng \u0111\u00E3 c\u00F3", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 11, 547, 145);
		pnCenter.add(panel);
		panel.setLayout(null);
		
		JLabel lblTenHoiDong = new JLabel("Tên hội đồng: ");
		lblTenHoiDong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTenHoiDong.setBounds(35, 46, 109, 19);
		panel.add(lblTenHoiDong);
		
		JLabel lblMaHoiDong = new JLabel("Mã hội đồng: ");
		lblMaHoiDong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMaHoiDong.setBounds(35, 88, 109, 19);
		panel.add(lblMaHoiDong);
		
		txtMaHoiDong = new JTextField();
		txtMaHoiDong.setEditable(false);
		txtMaHoiDong.setColumns(10);
		txtMaHoiDong.setBounds(154, 89, 372, 20);
		panel.add(txtMaHoiDong);
		
		JComboBox comboBoxTenHoiDong = new JComboBox();
		comboBoxTenHoiDong.setBounds(154, 47, 372, 20);
		panel.add(comboBoxTenHoiDong);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Danh s\u00E1ch h\u1ED9i \u0111\u1ED3ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(567, 11, 687, 335);
		pnCenter.add(panel_1);
		panel_1.setLayout(null);
		
		JLocaleChooser localeChooser = new JLocaleChooser();
		localeChooser.setBounds(-78, 287, 57, 20);
		panel_1.add(localeChooser);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 27, 667, 297);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "M\u00E3 h\u1ED9i \u0111\u1ED3ng", "T\u00EAn h\u1ED9i \u0111\u1ED3ng"
			}
		));
		scrollPane.setViewportView(table);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "H\u1ED9i \u0111\u1ED3ng m\u1EDBi", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(10, 167, 547, 232);
		pnCenter.add(panel_2);
		
		JLabel lblTenHoiDongMoi = new JLabel("Tên hội đồng: ");
		lblTenHoiDongMoi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTenHoiDongMoi.setBounds(35, 46, 109, 19);
		panel_2.add(lblTenHoiDongMoi);
		
		JLabel lblMaHoiDongMoi = new JLabel("Mã hội đồng: ");
		lblMaHoiDongMoi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMaHoiDongMoi.setBounds(35, 88, 109, 19);
		panel_2.add(lblMaHoiDongMoi);
		
		txtMaHoiDongMoi = new JTextField();
		txtMaHoiDongMoi.setColumns(10);
		txtMaHoiDongMoi.setBounds(154, 89, 369, 20);
		panel_2.add(txtMaHoiDongMoi);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(154, 47, 369, 20);
		panel_2.add(textField_1);
		
		JLabel lblNgayBaoCao = new JLabel("Ngày báo cáo: ");
		lblNgayBaoCao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNgayBaoCao.setBounds(35, 133, 109, 19);
		panel_2.add(lblNgayBaoCao);
		
		JDateChooser dateChNgayBaoCao = new JDateChooser();
		dateChNgayBaoCao.setBounds(154, 133, 369, 20);
		panel_2.add(dateChNgayBaoCao);
		
		JLabel lblSoLuongGiaoVienThamGia = new JLabel("Số giáo viên tham gia: ");
		lblSoLuongGiaoVienThamGia.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSoLuongGiaoVienThamGia.setBounds(35, 176, 157, 19);
		panel_2.add(lblSoLuongGiaoVienThamGia);
		
		textField_2 = new JTextField();
		textField_2.setText("5");
		textField_2.setColumns(10);
		textField_2.setBounds(195, 177, 328, 20);
		panel_2.add(textField_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Danh s\u00E1ch gi\u00E1o vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBounds(10, 410, 581, 459);
		pnCenter.add(panel_3);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 22, 561, 426);
		panel_3.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "M\u00E3 gi\u00E1o vi\u00EAn", "T\u00EAn gi\u00E1o vi\u00EAn", "Ch\u1EE9c danh", "L\u0129nh v\u1EF1c c\u00F4ng t\u00E1c", "\u0110\u01A1n v\u1ECB c\u00F4ng t\u00E1c", "Khoa c\u00F4ng t\u00E1c"
			}
		));
		scrollPane_1.setViewportView(table_1);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Gi\u00E1o vi\u00EAn \u0111\u01B0\u1EE3c ph\u00E2n c\u00F4ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3_1.setBounds(673, 410, 581, 459);
		pnCenter.add(panel_3_1);
		
		JScrollPane scrollPane_1_1 = new JScrollPane();
		scrollPane_1_1.setBounds(10, 22, 561, 426);
		panel_3_1.add(scrollPane_1_1);
		
		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "M\u00E3 gi\u00E1o vi\u00EAn", "T\u00EAn gi\u00E1o vi\u00EAn", "C\u00F4ng vi\u1EC7c"
			}
		));
		scrollPane_1_1.setViewportView(table_2);
		
		JButton btnThemPhanCong = new JButton(">>");
		btnThemPhanCong.setBounds(598, 514, 68, 23);
		pnCenter.add(btnThemPhanCong);
		
		JButton btnThemPhanCong_1 = new JButton("<<");
		btnThemPhanCong_1.setBounds(598, 700, 68, 23);
		pnCenter.add(btnThemPhanCong_1);
		
		JLabel lblSoLuongGiaoVien = new JLabel("Số lượng GV:");
		lblSoLuongGiaoVien.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoLuongGiaoVien.setBounds(601, 574, 62, 23);
		pnCenter.add(lblSoLuongGiaoVien);
		
		textField = new JTextField();
		textField.setBounds(601, 608, 62, 20);
		pnCenter.add(textField);
		textField.setColumns(10);
		
		JButton btnLuuHoiDong = new JButton("Lưu hội đồng");
		btnLuuHoiDong.setBounds(577, 357, 127, 44);
		pnCenter.add(btnLuuHoiDong);
		
		JButton btnCapNhatHoiDong = new JButton("Cập nhật hội đồng");
		btnCapNhatHoiDong.setBounds(741, 355, 127, 44);
		pnCenter.add(btnCapNhatHoiDong);
		
		JButton btnXoaHoiDong = new JButton("Xóa hội đồng");
		btnXoaHoiDong.setBounds(904, 355, 127, 44);
		pnCenter.add(btnXoaHoiDong);
		
		btnChonCongViec = new JButton("Chọn công việc");
		btnChonCongViec.setBounds(1067, 357, 127, 44);
		pnCenter.add(btnChonCongViec);
		
		btnChonCongViec.addActionListener(this);
	}
	public JPanel getPanel() {
		return pnChung;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnChonCongViec)) {
			GD_CCV = new GiaoDien_ChonCongViec();
			GD_CCV.frame.setVisible(true);
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
