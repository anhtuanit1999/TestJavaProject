package giaovukhoa;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import dao.Database;
import dao.GhiFileDao;
import dao.SinhVienDao;
import entity.LuanVan;
import entity.SinhVien;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class GiaoDien_QuanLySinhVien implements ActionListener, MouseListener, KeyListener {

	private JFrame frame;
	private JTextField txtHoTen;
	private JTextField txtSoDienThoai;
	private JTextField txtDiaChi;
	private JTextField txtKhoaTrucThuoc;
	private JTextField txtNamVaoTruong;
	private JTextField txtNamTotNghiep;
	private JTable table;
	private JPanel pnChung;
	private JDateChooser dateChooserNgaySinh;
	private JButton btnThem;
	private JButton btnSua;
	private JButton btnXoa;
	private JButton btnExecl;
	private SinhVienDao sinhVienDao;
	private JButton btnXoaTrang;
	private GhiFileDao ghiFileDao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GiaoDien_QuanLySinhVien window = new GiaoDien_QuanLySinhVien();
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
	public GiaoDien_QuanLySinhVien() {
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
		sinhVienDao = new SinhVienDao();
		frame = new JFrame();
		frame.setBounds(100, 100, 1280, 950);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setResizable(false);
		
		pnChung = new JPanel();
		frame.getContentPane().add(pnChung, BorderLayout.CENTER);
		pnChung.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTieuDe = new JLabel("Quản lý sinh viên");
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDe.setFont(new Font("Tahoma", Font.PLAIN, 25));
		pnChung.add(lblTieuDe, BorderLayout.NORTH);
		
		JPanel pnCenter = new JPanel();
		pnChung.add(pnCenter, BorderLayout.CENTER);
		pnCenter.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Th\u00F4ng tin sinh vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds((int)Math.round(width/2 - (oldWidth/2 - 10)), 11, 1244, 333);
		pnCenter.add(panel);
		panel.setLayout(null);
		
		JLabel lblHoTen = new JLabel("Họ tên:  ");
		lblHoTen.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHoTen.setBounds(53, 38, 131, 19);
		panel.add(lblHoTen);
		
		txtHoTen = new JTextField();
		txtHoTen.setColumns(10);
		txtHoTen.setBounds(194, 39, 998, 20);
		panel.add(txtHoTen);
		
		JLabel lblNgaySinh = new JLabel("Ngày sinh: ");
		lblNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNgaySinh.setBounds(53, 68, 131, 19);
		panel.add(lblNgaySinh);
		
		JLabel lblSoDienThoai = new JLabel("Số điện thoại: ");
		lblSoDienThoai.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSoDienThoai.setBounds(53, 98, 131, 19);
		panel.add(lblSoDienThoai);
		
		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setColumns(10);
		txtSoDienThoai.setBounds(194, 99, 998, 20);
		panel.add(txtSoDienThoai);
		
		JLabel lblDiaChi = new JLabel("Địa chỉ: ");
		lblDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDiaChi.setBounds(53, 128, 131, 19);
		panel.add(lblDiaChi);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(194, 129, 998, 20);
		panel.add(txtDiaChi);
		
		JLabel lblKhoaTrucThuoc = new JLabel("Khoa trực thuộc: ");
		lblKhoaTrucThuoc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblKhoaTrucThuoc.setBounds(53, 158, 131, 19);
		panel.add(lblKhoaTrucThuoc);
		
		txtKhoaTrucThuoc = new JTextField();
		txtKhoaTrucThuoc.setColumns(10);
		txtKhoaTrucThuoc.setBounds(194, 159, 998, 20);
		panel.add(txtKhoaTrucThuoc);
		
		JLabel lblNamVaoTruong = new JLabel("Năm vào trường: ");
		lblNamVaoTruong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNamVaoTruong.setBounds(53, 190, 131, 19);
		panel.add(lblNamVaoTruong);
		
		txtNamVaoTruong = new JTextField();
		txtNamVaoTruong.setColumns(10);
		txtNamVaoTruong.setBounds(194, 191, 998, 20);
		panel.add(txtNamVaoTruong);
		
		JLabel lblNamTotNghiep = new JLabel("Năm tốt nghiệp: ");
		lblNamTotNghiep.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNamTotNghiep.setBounds(53, 220, 131, 19);
		panel.add(lblNamTotNghiep);
		
		txtNamTotNghiep = new JTextField();
		txtNamTotNghiep.setColumns(10);
		txtNamTotNghiep.setBounds(194, 221, 998, 20);
		panel.add(txtNamTotNghiep);
		
		dateChooserNgaySinh = new JDateChooser();
		dateChooserNgaySinh.setBounds(194, 67, 998, 20);
		panel.add(dateChooserNgaySinh);
		
		btnThem = new JButton("Thêm");
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThem.setBounds(76, 272, 127, 44);
		panel.add(btnThem);
		
		btnSua = new JButton("Sửa");
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSua.setBounds(296, 272, 127, 44);
		panel.add(btnSua);
		
		btnXoa = new JButton("Xóa");
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnXoa.setBounds(516, 272, 127, 44);
		panel.add(btnXoa);
		
		btnExecl = new JButton("Thêm từ Excel");
		btnExecl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnExecl.setBounds(950, 272, 146, 44);
		panel.add(btnExecl);
		
		btnXoaTrang = new JButton("Xóa trắng");
		btnXoaTrang.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnXoaTrang.setBounds(740, 272, 127, 44);
		panel.add(btnXoaTrang);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Danh s\u00E1ch sinh vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds((int)Math.round(width/2 - (oldWidth/2 - 10)), 355, 1244, 514);
		pnCenter.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 22, 1224, 481);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "M\u00E3 sinh vi\u00EAn", "H\u1ECD t\u00EAn", "Ng\u00E0y sinh", "S\u1ED1 \u0111i\u1EC7n tho\u1EA1i", "\u0110\u1ECBa ch\u1EC9", "Khoa tr\u1EF1c thu\u1ED9c", " N\u0103m v\u00E0o tr\u01B0\u1EDDng", "N\u0103m t\u1ED1t nghi\u1EC7p", "M\u00E3 Nh\u00F3m"
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
		txtNamTotNghiep.addKeyListener(this);
	}
	
	public JPanel getPanel() {
		return pnChung;
	}
	
	public void capNhat() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		sinhVienDao.updateBangSinhVien(table);
	}
	
	public boolean kiemTraTextField() {
		String regex = "[A-Z]+.*(\\s[A-Z]+.*)*";
		String regexSo = "\\d{4}";
		if(!txtHoTen.getText().trim().matches(regex)) {
			JOptionPane.showMessageDialog(frame, "Chữ đầu tiên là chữ hoa, theo sau là các ký tự thường.");
			txtHoTen.requestFocus();
			txtHoTen.selectAll();
			return false;
		}
		if(dateChooserNgaySinh.getDate() == null) {
			JOptionPane.showMessageDialog(frame, "Sai định dạng ngày dd-MM-yyyy");
			dateChooserNgaySinh.setDate(null);
			dateChooserNgaySinh.requestFocus();
			return false;
		}
		if(!txtSoDienThoai.getText().trim().matches("0\\d{9}")) {
			JOptionPane.showMessageDialog(frame, "Số điện thoại phải có 10 chữ số và bắt đầu bằng số 0");
			txtSoDienThoai.requestFocus();
			txtSoDienThoai.selectAll();
			return false;
		}
		if(!txtDiaChi.getText().trim().matches(regex)) {
			JOptionPane.showMessageDialog(frame, "Chữ đầu tiên là chữ hoa, theo sau là các ký tự thường.");
			txtDiaChi.requestFocus();
			txtDiaChi.selectAll();
			return false;
		}
		if(!txtKhoaTrucThuoc.getText().trim().matches(regex)) {
			JOptionPane.showMessageDialog(frame, "Chữ đầu tiên là chữ hoa, theo sau là các ký tự thường.");
			txtKhoaTrucThuoc.requestFocus();
			txtKhoaTrucThuoc.selectAll();
			return false;
		}
		if(!txtNamVaoTruong.getText().trim().matches(regexSo)) {
			JOptionPane.showMessageDialog(frame, "Phải có 4 chữ số");
			txtNamVaoTruong.requestFocus();
			txtNamVaoTruong.selectAll();
			return false;
		}
		if(!txtNamTotNghiep.getText().trim().matches(regexSo) && Integer.parseInt(txtNamVaoTruong.getText()) < Integer.parseInt(txtNamTotNghiep.getText())) {
			JOptionPane.showMessageDialog(frame, "Phải có 4 chữ số lớn hơn năm vào trường");
			txtNamTotNghiep.requestFocus();
			txtNamTotNghiep.selectAll();
			return false;
		}
		return true;
	}
	
	public void xoaTrang() {
		txtHoTen.setText("");
		dateChooserNgaySinh.setDate(null);
		txtSoDienThoai.setText("");
		txtDiaChi.setText("");
		txtKhoaTrucThuoc.setText("");
		txtNamVaoTruong.setText("");
		txtNamTotNghiep.setText("");
	}
	
	public void eventThem() {
		if(kiemTraTextField()) {
			String hoTen = txtHoTen.getText();
			Date ngaySinh = dateChooserNgaySinh.getDate();
			String soDienThoai = txtSoDienThoai.getText();
			String diaChi = txtDiaChi.getText();
			String khoaTrucThuoc = txtKhoaTrucThuoc.getText();
			int namVaoTruong = Integer.parseInt(txtNamVaoTruong.getText());
			int namTotNghiep = Integer.parseInt(txtNamTotNghiep.getText());
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			
			SinhVien sv = new SinhVien(sinhVienDao.sinhMaSinhVienTuDong(), hoTen, df.format(ngaySinh), soDienThoai, diaChi, khoaTrucThuoc, namVaoTruong, namTotNghiep, null);
			if(sinhVienDao.kiemTraSinhVienDaTonTai(hoTen, df.format(ngaySinh))) {
				JOptionPane.showMessageDialog(frame, "Sinh viên đã tồn tại");
				return;
			}
			JOptionPane.showMessageDialog(frame, "Thêm thành công!");
			sinhVienDao.themSinhVien(sv);
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.setRowCount(0);
			sinhVienDao.updateBangSinhVien(table);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnThem)) {
			eventThem();
		} else if(o.equals(btnXoa)) {
			int row = table.getSelectedRow();
			String maNhom = (String) table.getValueAt(row, 9);
			if (row >= 0) {
				String maSinhVien = (String) table.getValueAt(row, 1);
				if (JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa?", "WARNING",
				        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					if(maNhom != null) {
						JOptionPane.showMessageDialog(frame, "Phải xóa nhóm của sinh viên trước");
						return;
					}
					if (sinhVienDao.xoaSinhVien(maSinhVien)) {
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						model.setRowCount(0);
						sinhVienDao.updateBangSinhVien(table);
						xoaTrang();
					}
				}
			}
		} else if(o.equals(btnSua)) {
			String hoTen = txtHoTen.getText();
			Date ngaySinh = dateChooserNgaySinh.getDate();
			String soDienThoai = txtSoDienThoai.getText();
			String diaChi = txtDiaChi.getText();
			String khoaTrucThuoc = txtKhoaTrucThuoc.getText();
			int namVaoTruong = Integer.parseInt(txtNamVaoTruong.getText());
			int namTotNghiep = Integer.parseInt(txtNamTotNghiep.getText());
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			
			SinhVien sv = new SinhVien(sinhVienDao.sinhMaSinhVienTuDong(), hoTen, df.format(ngaySinh), soDienThoai, diaChi, khoaTrucThuoc, namVaoTruong, namTotNghiep, null);
			String maSinhVien = table.getValueAt(table.getSelectedRow(), 1).toString();
			if(sinhVienDao.kiemTraSinhVienDaTonTai(hoTen, df.format(ngaySinh)) && (!sv.getHoTen().equals(hoTen) || !sv.getNgaySinh().equals(df.format(ngaySinh)))) {
				JOptionPane.showMessageDialog(frame, "Sinh viên đã tồn tại");
				return;
			}
			JOptionPane.showMessageDialog(frame, "Sửa thành công!");
			sinhVienDao.suaSinhVien(maSinhVien, sv);
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.setRowCount(0);
			sinhVienDao.updateBangSinhVien(table);
		} else if(o.equals(btnXoaTrang)) {
			xoaTrang();
		} else if(o.equals(btnExecl)) {
			JFileChooser f = new JFileChooser();
			f.setFileSelectionMode(JFileChooser.FILES_ONLY); 
			f.showSaveDialog(null);
			try {
				List<SinhVien> list = ghiFileDao.docFileSinhVien(f.getSelectedFile().getAbsolutePath());
				list.forEach(ele -> {
					if(sinhVienDao.kiemTraSinhVienDaTonTai(ele.getHoTen(), ele.getNgaySinh()) || ele.getMaSinhVien() == null) {
						return;
					} else {
						sinhVienDao.themSinhVien(ele);
					}
				});
				System.out.println("Done");
				capNhat();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		txtHoTen.setText(table.getValueAt(row, 2).toString());
		txtSoDienThoai.setText(table.getValueAt(row, 4).toString());
		txtDiaChi.setText(table.getValueAt(row, 5).toString());
		txtKhoaTrucThuoc.setText(table.getValueAt(row, 6).toString());
		txtNamVaoTruong.setText(table.getValueAt(row, 7).toString());
		txtNamTotNghiep.setText(table.getValueAt(row, 8).toString());
		try {
			dateChooserNgaySinh.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(table.getValueAt(row, 3).toString()));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			eventThem();
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
* @date: 21-12-2020
* @version: 1.0
*/
