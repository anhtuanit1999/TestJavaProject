package giaovukhoa;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.text.MessageFormat;

import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.Database;
import dao.LuanVanDao;
import dao.TablePrintable;
import entity.LuanVan;

public class GiaoDien_XemChiTietLuanVan implements ActionListener, MouseListener {

	private String maLuanVan;
	public JFrame frame;
	private JTable table1;
	private JTable table2;
	private JTable table3;
	private JButton btnInDanhSach;
	private JComboBox comboBoxTieuChi;
	private LuanVanDao luanVanDao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GiaoDien_XemChiTietLuanVan window = new GiaoDien_XemChiTietLuanVan("LV011");
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
	public GiaoDien_XemChiTietLuanVan(String maLuanVan) {
		this.maLuanVan = maLuanVan;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Database.getInstance().connec();
		luanVanDao = new LuanVanDao();
		frame = new JFrame();
		frame.setBounds(100, 100, 1280, 618);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel pnChung = new JPanel();
		frame.getContentPane().add(pnChung, BorderLayout.CENTER);
		pnChung.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTieuDe = new JLabel("Chi tiết nhóm đăng ký đề tài");
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDe.setFont(new Font("Tahoma", Font.PLAIN, 25));
		pnChung.add(lblTieuDe, BorderLayout.NORTH);
		
		JPanel pnCenter = new JPanel();
		pnChung.add(pnCenter, BorderLayout.CENTER);
		pnCenter.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Danh s\u00E1ch nh\u00F3m \u0111\u0103ng k\u00FD \u0111\u1EC1 t\u00E0i", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 330, 287);
		pnCenter.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 22, 310, 254);
		panel.add(scrollPane);
		
		table1 = new JTable();
		table1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "M\u00E3 nh\u00F3m"
			}
		));
		scrollPane.setViewportView(table1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Danh s\u00E1ch sinh vi\u00EAn \u0111\u0103ng k\u00FD \u0111\u1EC1 t\u00E0i", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(350, 11, 904, 287);
		pnCenter.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 23, 884, 253);
		panel_1.add(scrollPane_1);
		
		table2 = new JTable() {
			@Override
				public Printable getPrintable(PrintMode printMode, MessageFormat headerFormat, MessageFormat footerFormat) {
					return new TablePrintable(this, printMode, headerFormat, footerFormat);
		    }
		};
		
		table2.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "M\u00E3 sinh vi\u00EAn", "H\u1ECD t\u00EAn", "Ng\u00E0y sinh", "S\u1ED1 \u0111i\u1EC7n tho\u1EA1i", "\u0110\u1ECBa ch\u1EC9", "Khoa tr\u1EF1c thu\u1ED9c", "N\u0103m v\u00E0o tr\u01B0\u1EDDng", "N\u0103m t\u1ED1t nghi\u1EC7p", "M\u00E3 nh\u00F3m"
			}
		));
		scrollPane_1.setViewportView(table2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Danh s\u00E1ch sinh vi\u00EAn trong nh\u00F3m", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 382, 1244, 161);
		pnCenter.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 22, 1224, 128);
		panel_2.add(scrollPane_2);
		
		table3 = new JTable();
		table3.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "M\u00E3 sinh vi\u00EAn", "H\u1ECD t\u00EAn", "Ng\u00E0y sinh", "S\u1ED1 \u0111i\u1EC7n tho\u1EA1i", "\u0110\u1ECBa ch\u1EC9", "Khoa tr\u1EF1c thu\u1ED9c", "N\u0103m v\u00E0o tr\u01B0\u1EDDng", "N\u0103m t\u1ED1t nghi\u1EC7p", "M\u00E3 nh\u00F3m"
			}
		));
		scrollPane_2.setViewportView(table3);
		
		JLabel lblTieuChi = new JLabel("Tiêu chí: ");
		lblTieuChi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTieuChi.setBounds(229, 337, 81, 19);
		pnCenter.add(lblTieuChi);
		
		btnInDanhSach = new JButton("In danh sách");
		btnInDanhSach.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnInDanhSach.setBounds(972, 324, 127, 44);
		pnCenter.add(btnInDanhSach);
		
		comboBoxTieuChi = new JComboBox();
		comboBoxTieuChi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBoxTieuChi.setModel(new DefaultComboBoxModel(new String[] {"Danh sách sinh viên đăng ký đề tài", "Danh sách sinh trong nhóm"}));
		comboBoxTieuChi.setBounds(330, 334, 610, 25);
		pnCenter.add(comboBoxTieuChi);
		
		btnInDanhSach.addActionListener(this);
		table1.addMouseListener(this);
		capNhap();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnInDanhSach)) {
			MessageFormat header = null;
			MessageFormat header1 = null;
			MessageFormat footer = new MessageFormat("Page {0,number,integer}");
			LuanVan lv = luanVanDao.timLuanVanTheoMa(maLuanVan);
			try {
				if(comboBoxTieuChi.getSelectedItem().toString().equals("Danh sách sinh viên đăng ký đề tài")) {
					header = new MessageFormat(comboBoxTieuChi.getSelectedItem().toString().toUpperCase() + "\n" + lv.getTenLuanVan().toUpperCase());
//					header1 = new MessageFormat(lv.getTenLuanVan().toUpperCase());
					table2.print(JTable.PrintMode.FIT_WIDTH, header, footer);
				} else {
					int row = table1.getSelectedRow();
					if(row != -1) {
						header = new MessageFormat(comboBoxTieuChi.getSelectedItem().toString().toUpperCase() + " " + table1.getValueAt(row, 1).toString().toUpperCase());
						table3.print(JTable.PrintMode.FIT_WIDTH, header, footer);
					}
				}		
			} catch (PrinterException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	public void capNhap() {
		capNhatTable1();
		capNhatTable2();
	}
	
	public void capNhatTable1() {
		luanVanDao.capNhatTable1(table1, maLuanVan);
	}
	
	public void capNhatTable2() {
		luanVanDao.capNhatTable2(table2, maLuanVan);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table1.getSelectedRow();
		DefaultTableModel model = (DefaultTableModel) table3.getModel();
		model.setRowCount(0);
		luanVanDao.capNhatTable3(table3, table1.getValueAt(row, 1).toString());
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}

/*
* (C) Copyright 2020 IUH. All rights reserved.
*
* @author: AnhTuanIT
* @date: 22-12-2020
* @version: 1.0
*/
