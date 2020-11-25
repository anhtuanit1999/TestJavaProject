package sinhVien;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
import javax.transaction.Transactional.TxType;

import dao.Database;
import dao.LuanVanDao;

import javax.swing.JCheckBox;

public class GiaoDien_TimDeTai implements ActionListener, KeyListener {

	private JFrame frame;
	private JTextField txtThongTin;
	private JTable table;
	private JPanel pnChung;
	private JButton btnTimKiem;
	private LuanVanDao luanVanDao;
	private JComboBox comboBoxTieuChi;

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
		Database.getInstance().connec();
		luanVanDao = new LuanVanDao();
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
		
		txtThongTin = new JTextField();
		txtThongTin.setBounds(218, 78, 948, 20);
		panel.add(txtThongTin);
		txtThongTin.setColumns(10);
		
		JLabel lblTieuChi = new JLabel("Tìm theo tiêu chí: ");
		lblTieuChi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTieuChi.setBounds(52, 134, 156, 28);
		panel.add(lblTieuChi);
		
		comboBoxTieuChi = new JComboBox();
		comboBoxTieuChi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBoxTieuChi.setModel(new DefaultComboBoxModel(new String[] {"Mã đề tài", "Tên đề tài", "Tên giáo viên ra đề tài"}));
		comboBoxTieuChi.setBounds(218, 140, 948, 22);
		panel.add(comboBoxTieuChi);
		
		JLabel lblNamHoc = new JLabel("Năm học: ");
		lblNamHoc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNamHoc.setBounds(52, 200, 156, 28);
		panel.add(lblNamHoc);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Không", "2019 - 2020", "2020 - 2021", "2021 - 2022"}));
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_1.setBounds(218, 206, 948, 22);
		panel.add(comboBox_1);
		
		btnTimKiem = new JButton("Tìm kiếm");
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
				"STT", "M\u00E3 \u0111\u1EC1 t\u00E0i", "T\u00EAn \u0111\u1EC1 t\u00E0i", " Gi\u00E1o vi\u00EAn ra \u0111\u1EC1 t\u00E0i", "S\u1ED1 nh\u00F3m tham gia"
			}
		));
		scrollPane.setViewportView(table);
		
		btnTimKiem.addActionListener(this);
		txtThongTin.addKeyListener(this);
		comboBoxTieuChi.addKeyListener(this);
	}
	public JPanel getPanel() {
		return pnChung;
	}
	
	public void eventTimKiem() {
		String maLuanVan = "";
		String tenLuanVan = "";
		String tenGiaoVienRaDeTai = "";
		String giaTri = comboBoxTieuChi.getSelectedItem().toString();
		if(giaTri == "Mã đề tài") {
			maLuanVan = txtThongTin.getText() == null ? "" : txtThongTin.getText().toString();
		} else if(giaTri == "Tên đề tài") {
			tenLuanVan = txtThongTin.getText() == null ? "" : txtThongTin.getText().toString();
		} else if(giaTri == "Tên giáo viên ra đề tài") {
			tenGiaoVienRaDeTai = txtThongTin.getText() == null ? "" : txtThongTin.getText().toString();
		}
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		luanVanDao.updateTableTimLuanVanTheoTieuChi(maLuanVan, tenLuanVan, tenGiaoVienRaDeTai, table);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnTimKiem)) {
			eventTimKiem();
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			eventTimKiem();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}

/*
* (C) Copyright 2020 IUH. All rights reserved.
*
* @author: AnhTuanIT
* @date: 03-11-2020
* @version: 1.0
*/
