package giaovukhoa;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.Database;
import dao.GhiFileDao;
import dao.GiaoVienDao;
import entity.GiaoVien;
import entity.SinhVien;

public class GiaoDien_QuanLyGiaoVien implements ActionListener, MouseListener {

	private JFrame frame;
	private JTextField txtHoTen;
	private JTextField txtChucDanh;
	private JTextField txtLinhVucCongTac;
	private JTextField txtDonViCongTac;
	private JTextField txtKhoaCongTac;
	private JTable table;
	private JPanel pnChung;
	private GiaoVienDao giaoVienDao;
	private JButton btnThem;
	private JButton btnSua;
	private JButton btnXoa;
	private JButton btnXoaTrang;
	private JButton btnExecl;
	private GhiFileDao ghiFileDao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GiaoDien_QuanLyGiaoVien window = new GiaoDien_QuanLyGiaoVien();
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
	public GiaoDien_QuanLyGiaoVien() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Database.getInstance().connec();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int oldHeight = 950;
		int oldWidth = 1280;
		double height = screenSize.getHeight() < oldHeight ? oldHeight : screenSize.getHeight();
		double width = screenSize.getWidth() < oldWidth ? oldWidth : screenSize.getWidth();
		ghiFileDao = new GhiFileDao();
		giaoVienDao = new GiaoVienDao();
		frame = new JFrame();
		frame.setBounds(100, 100, 1280, 950);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setResizable(false);
		
		pnChung = new JPanel();
		frame.getContentPane().add(pnChung, BorderLayout.CENTER);
		pnChung.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTieuDe = new JLabel("Quản lý giáo viên");
		lblTieuDe.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		pnChung.add(lblTieuDe, BorderLayout.NORTH);
		
		JPanel pnCenter = new JPanel();
		pnChung.add(pnCenter, BorderLayout.CENTER);
		pnCenter.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Th\u00F4ng tin gi\u00E1o vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds((int)Math.round(width/2 - (oldWidth/2 - 10)), 11, 1244, 371);
		pnCenter.add(panel);
		panel.setLayout(null);
		
		JLabel lblHoTen = new JLabel("Họ tên: ");
		lblHoTen.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHoTen.setBounds(60, 52, 160, 19);
		panel.add(lblHoTen);
		
		txtHoTen = new JTextField();
		txtHoTen.setBounds(230, 53, 953, 20);
		panel.add(txtHoTen);
		txtHoTen.setColumns(10);
		
		JLabel lblChucDanh = new JLabel("Chức danh: ");
		lblChucDanh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblChucDanh.setBounds(60, 98, 160, 19);
		panel.add(lblChucDanh);
		
		txtChucDanh = new JTextField();
		txtChucDanh.setColumns(10);
		txtChucDanh.setBounds(230, 99, 953, 20);
		panel.add(txtChucDanh);
		
		JLabel lblLinhVucCongTac = new JLabel("Lĩnh vực công tác: ");
		lblLinhVucCongTac.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLinhVucCongTac.setBounds(60, 144, 160, 19);
		panel.add(lblLinhVucCongTac);
		
		txtLinhVucCongTac = new JTextField();
		txtLinhVucCongTac.setColumns(10);
		txtLinhVucCongTac.setBounds(230, 145, 953, 20);
		panel.add(txtLinhVucCongTac);
		
		JLabel lblDonViCongTac = new JLabel("Đơn vị công tác: ");
		lblDonViCongTac.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDonViCongTac.setBounds(60, 191, 160, 19);
		panel.add(lblDonViCongTac);
		
		txtDonViCongTac = new JTextField();
		txtDonViCongTac.setColumns(10);
		txtDonViCongTac.setBounds(230, 192, 953, 20);
		panel.add(txtDonViCongTac);
		
		JLabel lblKhoaCongTac = new JLabel("Khoa công tác: ");
		lblKhoaCongTac.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblKhoaCongTac.setBounds(60, 242, 160, 19);
		panel.add(lblKhoaCongTac);
		
		txtKhoaCongTac = new JTextField();
		txtKhoaCongTac.setColumns(10);
		txtKhoaCongTac.setBounds(230, 243, 953, 20);
		panel.add(txtKhoaCongTac);
		
		btnThem = new JButton("Thêm");
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThem.setBounds(131, 302, 127, 44);
		panel.add(btnThem);
		
		btnSua = new JButton("Sửa");
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSua.setBounds(351, 302, 127, 44);
		panel.add(btnSua);
		
		btnXoa = new JButton("Xóa");
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnXoa.setBounds(571, 302, 127, 44);
		panel.add(btnXoa);
		
		btnXoaTrang = new JButton("Xóa trắng");
		btnXoaTrang.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnXoaTrang.setBounds(795, 302, 127, 44);
		panel.add(btnXoaTrang);
		
		btnExecl = new JButton("Thêm từ Excel");
		btnExecl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnExecl.setBounds(1005, 302, 146, 44);
		panel.add(btnExecl);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Danh s\u00E1ch gi\u00E1o vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds((int)Math.round(width/2 - (oldWidth/2 - 10)), 393, 1244, 476);
		pnCenter.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 23, 1224, 442);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "M\u00E3 gi\u00E1o vi\u00EAn", "H\u1ECD t\u00EAn", "Ch\u1EE9c danh", "L\u0129nh v\u1EF1c c\u00F4ng t\u00E1c", "\u0110\u01A1n v\u1ECB c\u00F4ng t\u00E1c", "Khoa c\u00F4ng t\u00E1c"
			}
		));
		scrollPane.setViewportView(table);
		
		capNhat();
		btnThem.addActionListener(this);
		btnSua.addActionListener(this);
		btnXoa.addActionListener(this);
		btnExecl.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		table.addMouseListener(this);
	}
	
	public JPanel getPanel() {
		return pnChung;
	}
	
	public void capNhat() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		giaoVienDao.updateBangGiaoVien(table);
	}
	
	public boolean kiemTraTextField() {
		String regex = "[A-Z]+.*(\\s[A-Z]+.*)*";
		if(!txtHoTen.getText().trim().matches(regex)) {
			JOptionPane.showMessageDialog(frame, "Chữ đầu tiên là chữ hoa, theo sau là các ký tự thường.");
			txtHoTen.requestFocus();
			txtHoTen.selectAll();
			return false;
		}
		if(!txtChucDanh.getText().trim().matches(regex)) {
			JOptionPane.showMessageDialog(frame, "Chữ đầu tiên là chữ hoa, theo sau là các ký tự thường.");
			txtChucDanh.requestFocus();
			txtChucDanh.selectAll();
			return false;
		}
		if(!txtLinhVucCongTac.getText().trim().matches(regex)) {
			JOptionPane.showMessageDialog(frame, "Chữ đầu tiên là chữ hoa, theo sau là các ký tự thường.");
			txtLinhVucCongTac.requestFocus();
			txtLinhVucCongTac.selectAll();
			return false;
		}
		if(!txtDonViCongTac.getText().trim().matches(regex)) {
			JOptionPane.showMessageDialog(frame, "Chữ đầu tiên là chữ hoa, theo sau là các ký tự thường.");
			txtDonViCongTac.requestFocus();
			txtDonViCongTac.selectAll();
			return false;
		}
		if(!txtKhoaCongTac.getText().trim().matches(regex)) {
			JOptionPane.showMessageDialog(frame, "Chữ đầu tiên là chữ hoa, theo sau là các ký tự thường.");
			txtKhoaCongTac.requestFocus();
			txtKhoaCongTac.selectAll();
			return false;
		}
		return true;
	}

	public void xoaTrang() {
		txtHoTen.setText("");
		txtChucDanh.setText("");
		txtLinhVucCongTac.setText("");
		txtDonViCongTac.setText("");
		txtKhoaCongTac.setText("");
	}
	
	public void eventThem() {
		if(kiemTraTextField()) {
			String hoTen = txtHoTen.getText();
			String chucDanh = txtChucDanh.getText();
			String linhVucCongTac = txtLinhVucCongTac.getText();
			String donViCongTac = txtDonViCongTac.getText();
			String khoaCongTac = txtKhoaCongTac.getText();
			
			GiaoVien gv = new GiaoVien(giaoVienDao.sinhMaGiaoVienTuDong(), hoTen, chucDanh, linhVucCongTac, donViCongTac, khoaCongTac);
			if(giaoVienDao.kiemTraGiaoVienDaTonTai(hoTen, chucDanh, linhVucCongTac, donViCongTac, khoaCongTac)) {
				JOptionPane.showMessageDialog(frame, "Giáo viên đã tồn tại");
				return;
			}
			JOptionPane.showMessageDialog(frame, "Thêm thành công!");
			giaoVienDao.themGiaoVien(gv);
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.setRowCount(0);
			giaoVienDao.updateBangGiaoVien(table);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnThem)) {
			eventThem();
		} else if(o.equals(btnXoa)) {
			int row = table.getSelectedRow();
			if (row >= 0) {
				String maGiaoVien = (String) table.getValueAt(row, 1);
				if (JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa?", "WARNING",
				        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					if (giaoVienDao.xoaGiaoVien(maGiaoVien)) {
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						model.setRowCount(0);
						giaoVienDao.updateBangGiaoVien(table);
						xoaTrang();
					}
				}
			}
		} else if(o.equals(btnSua)) {
			String hoTen = txtHoTen.getText();
			String chucDanh = txtChucDanh.getText();
			String linhVucCongTac = txtLinhVucCongTac.getText();
			String donViCongTac = txtDonViCongTac.getText();
			String khoaCongTac = txtKhoaCongTac.getText();
			
			GiaoVien gv = new GiaoVien(giaoVienDao.sinhMaGiaoVienTuDong(), hoTen, chucDanh, linhVucCongTac, donViCongTac, khoaCongTac);
			String maGiaoVien = table.getValueAt(table.getSelectedRow(), 1).toString();
			if(giaoVienDao.kiemTraGiaoVienDaTonTai(hoTen, chucDanh, linhVucCongTac, donViCongTac, khoaCongTac) && (!gv.getHoTen().equals(hoTen) || 
					!gv.getChucDanh().equals(chucDanh) || !gv.getLinhVucCongTac().equals(linhVucCongTac) || !gv.getDonViCongTac().equals(donViCongTac) || !gv.getKhoaCongTac().equals(khoaCongTac))) {
				JOptionPane.showMessageDialog(frame, "Giaso viên đã tồn tại");
				return;
			}
			JOptionPane.showMessageDialog(frame, "Sửa thành công!");
			giaoVienDao.suaGiaoVien(maGiaoVien, gv);
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.setRowCount(0);
			giaoVienDao.updateBangGiaoVien(table);
		} else if(o.equals(btnExecl)) {
			JFileChooser f = new JFileChooser();
			f.setFileSelectionMode(JFileChooser.FILES_ONLY); 
			f.showSaveDialog(null);
			try {
				List<GiaoVien> list = ghiFileDao.docFileGiaoVien(f.getSelectedFile().getAbsolutePath());
				list.forEach(ele -> {
					if(giaoVienDao.kiemTraGiaoVienDaTonTai(ele.getHoTen(), ele.getChucDanh(), ele.getLinhVucCongTac(), ele.getDonViCongTac(), ele.getKhoaCongTac()) || ele.getMaGiaoVien() == null) {
						return;
					} else {
						giaoVienDao.themGiaoVien(ele);
					}
				});
				System.out.println("Done");
				capNhat();
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(frame, "Hãy chọn file có đuôi .xlsx");
			}
		} else if(o.equals(btnXoaTrang)) {
			xoaTrang();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		txtHoTen.setText(table.getValueAt(row, 2).toString());
		txtChucDanh.setText(table.getValueAt(row, 3).toString());
		txtLinhVucCongTac.setText(table.getValueAt(row, 4).toString());
		txtDonViCongTac.setText(table.getValueAt(row, 5).toString());
		txtKhoaCongTac.setText(table.getValueAt(row, 6).toString());
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
* @date: 21-12-2020
* @version: 1.0
*/
