package sinhVien;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.Database;
import dao.SinhVienDao;
import entity.SinhVien;
import giaodienchinh.GiaoDienChinh;

import javax.swing.UIManager;
import java.awt.Color;

public class GiaoDien_DangKyNhom implements MouseListener, ActionListener {

	private JFrame frame;
	private JTextField txtMSSVChinh;
	private JTextField txtHoTenChinh;
	private JTextField txtKhoaTrucThuocChinh;
	private JTextField txtNamVaoTruongChinh;
	private JTextField txtNamTotNghiepChinh;
	private JTextField txtThongTinSinVienCanTim;
	private JTable table;
	private JPanel pnChung;
	private SinhVienDao sinhVienDao;
	
	private String maSinhVien;
	private JComboBox comboBoxTieuChi;
	private JButton btnTim;
	private JTextField txtMSSV;
	private JTextField txtHoTen;
	private JTextField txtKhoaTrucThuoc;
	private JTextField txtNamVaoTruong;
	private JTextField txtNamTotNghiep;
	private JButton btnDangKyNhom;
	private JTextField txtMaNhomChinh;
	private JTextField txtMaNhom;
	private GiaoDienChinh giaoDienChinh;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GiaoDien_DangKyNhom window = new GiaoDien_DangKyNhom("SV001", null);
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
	public GiaoDien_DangKyNhom(String maSinhVien, GiaoDienChinh giaoDienChinh) {
		this.maSinhVien = maSinhVien;
		this.giaoDienChinh = giaoDienChinh;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Database.getInstance().connec();
		sinhVienDao = new SinhVienDao();
		frame = new JFrame();
		frame.setBounds(100, 100, 1280, 1024);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pnChung = new JPanel();
		frame.getContentPane().add(pnChung, BorderLayout.CENTER);
		pnChung.setLayout(new BorderLayout(0, 0));
		
		JLabel lblDangKyNhom = new JLabel("Đăng ký nhóm");
		lblDangKyNhom.setHorizontalAlignment(SwingConstants.CENTER);
		lblDangKyNhom.setFont(new Font("Tahoma", Font.PLAIN, 25));
		pnChung.add(lblDangKyNhom, BorderLayout.NORTH);
		
		JPanel pnCenter = new JPanel();
		pnChung.add(pnCenter, BorderLayout.CENTER);
		pnCenter.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Th\u00F4ng tin sinh vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(0, 10, 619, 281);
		pnCenter.add(panel);
		panel.setLayout(null);
		
		JLabel lblMSSV = new JLabel("MSSV: ");
		lblMSSV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMSSV.setBounds(49, 32, 116, 14);
		panel.add(lblMSSV);
		
		txtMSSVChinh = new JTextField();
		txtMSSVChinh.setText((String) null);
		txtMSSVChinh.setEditable(false);
		txtMSSVChinh.setColumns(10);
		txtMSSVChinh.setBounds(175, 29, 434, 20);
		panel.add(txtMSSVChinh);
		
		JLabel lblHoTen = new JLabel("Họ tên: ");
		lblHoTen.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHoTen.setBounds(49, 75, 116, 17);
		panel.add(lblHoTen);
		
		txtHoTenChinh = new JTextField();
		txtHoTenChinh.setText((String) null);
		txtHoTenChinh.setEditable(false);
		txtHoTenChinh.setColumns(10);
		txtHoTenChinh.setBounds(175, 72, 434, 20);
		panel.add(txtHoTenChinh);
		
		JLabel lblKhoaTrucThuoc = new JLabel("Khoa trực thuộc: ");
		lblKhoaTrucThuoc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblKhoaTrucThuoc.setBounds(49, 119, 124, 17);
		panel.add(lblKhoaTrucThuoc);
		
		txtKhoaTrucThuocChinh = new JTextField();
		txtKhoaTrucThuocChinh.setText((String) null);
		txtKhoaTrucThuocChinh.setEditable(false);
		txtKhoaTrucThuocChinh.setColumns(10);
		txtKhoaTrucThuocChinh.setBounds(175, 116, 434, 20);
		panel.add(txtKhoaTrucThuocChinh);
		
		JLabel lblNamVaoTruong = new JLabel("Năm vào trường: ");
		lblNamVaoTruong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNamVaoTruong.setBounds(49, 161, 128, 17);
		panel.add(lblNamVaoTruong);
		
		txtNamVaoTruongChinh = new JTextField();
		txtNamVaoTruongChinh.setText("0");
		txtNamVaoTruongChinh.setEditable(false);
		txtNamVaoTruongChinh.setColumns(10);
		txtNamVaoTruongChinh.setBounds(175, 158, 434, 20);
		panel.add(txtNamVaoTruongChinh);
		
		JLabel lblNamTotNghiep = new JLabel("Năm tốt nghiệp: ");
		lblNamTotNghiep.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNamTotNghiep.setBounds(49, 200, 116, 17);
		panel.add(lblNamTotNghiep);
		
		txtNamTotNghiepChinh = new JTextField();
		txtNamTotNghiepChinh.setText("0");
		txtNamTotNghiepChinh.setEditable(false);
		txtNamTotNghiepChinh.setColumns(10);
		txtNamTotNghiepChinh.setBounds(175, 197, 434, 20);
		panel.add(txtNamTotNghiepChinh);
		
		JLabel lblMaNhomChinh = new JLabel("Mã nhóm: ");
		lblMaNhomChinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMaNhomChinh.setBounds(49, 241, 116, 14);
		panel.add(lblMaNhomChinh);
		
		txtMaNhomChinh = new JTextField();
		txtMaNhomChinh.setText((String) null);
		txtMaNhomChinh.setEditable(false);
		txtMaNhomChinh.setColumns(10);
		txtMaNhomChinh.setBounds(175, 238, 434, 20);
		panel.add(txtMaNhomChinh);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Danh s\u00E1ch sinh vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 382, 1246, 561);
		pnCenter.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 71, 1226, 479);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "MSSV", "H\u1ECD t\u00EAn", "Khoa tr\u1EF1c thu\u1ED9c", "N\u0103m v\u00E0o tr\u01B0\u1EDDng", "N\u0103m t\u1ED1t nghi\u1EC7p", "M\u00E3 nh\u00F3m"
			}
		));
		table.getColumnModel().getColumn(0).setResizable(false);
		scrollPane.setViewportView(table);
		
		JLabel lblThongTinCanTim = new JLabel("Thông tin sinh viên cần tìm: ");
		lblThongTinCanTim.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblThongTinCanTim.setBounds(50, 35, 194, 19);
		panel_1.add(lblThongTinCanTim);
		
		txtThongTinSinVienCanTim = new JTextField();
		txtThongTinSinVienCanTim.setBounds(254, 37, 488, 19);
		panel_1.add(txtThongTinSinVienCanTim);
		txtThongTinSinVienCanTim.setColumns(10);
		
		JLabel lblTieuChi = new JLabel("Tiêu chí: ");
		lblTieuChi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTieuChi.setBounds(752, 35, 71, 19);
		panel_1.add(lblTieuChi);
		
		comboBoxTieuChi = new JComboBox();
		comboBoxTieuChi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBoxTieuChi.setModel(new DefaultComboBoxModel(new String[] {"Mã sinh viên", "Tên sinh viên", "Số điện thoại", "Địa chỉ", "Khoa trực thuộc", "Năm vào trường", "Năm tốt nghiệp"}));
		comboBoxTieuChi.setBounds(812, 36, 281, 19);
		panel_1.add(comboBoxTieuChi);
		
		btnTim = new JButton("Tìm");
		btnTim.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTim.setBounds(1103, 36, 85, 21);
		panel_1.add(btnTim);
		
		btnDangKyNhom = new JButton("Đăng ký nhóm");
		btnDangKyNhom.setBounds(558, 315, 142, 44);
		pnCenter.add(btnDangKyNhom);
		btnDangKyNhom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Th\u00F4ng tin sinh vi\u00EAn mu\u1ED1n \u0111\u0103ng k\u00FD nh\u00F3m", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(628, 10, 628, 281);
		pnCenter.add(panel_2);
		
		JLabel lblMSSV_1 = new JLabel("MSSV: ");
		lblMSSV_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMSSV_1.setBounds(49, 32, 116, 14);
		panel_2.add(lblMSSV_1);
		
		txtMSSV = new JTextField();
		txtMSSV.setText((String) null);
		txtMSSV.setEditable(false);
		txtMSSV.setColumns(10);
		txtMSSV.setBounds(175, 29, 443, 20);
		panel_2.add(txtMSSV);
		
		JLabel lblHoTen_1 = new JLabel("Họ tên: ");
		lblHoTen_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHoTen_1.setBounds(49, 75, 116, 17);
		panel_2.add(lblHoTen_1);
		
		txtHoTen = new JTextField();
		txtHoTen.setText((String) null);
		txtHoTen.setEditable(false);
		txtHoTen.setColumns(10);
		txtHoTen.setBounds(175, 72, 443, 20);
		panel_2.add(txtHoTen);
		
		JLabel lblKhoaTrucThuoc_1 = new JLabel("Khoa trực thuộc: ");
		lblKhoaTrucThuoc_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblKhoaTrucThuoc_1.setBounds(49, 119, 124, 17);
		panel_2.add(lblKhoaTrucThuoc_1);
		
		txtKhoaTrucThuoc = new JTextField();
		txtKhoaTrucThuoc.setText((String) null);
		txtKhoaTrucThuoc.setEditable(false);
		txtKhoaTrucThuoc.setColumns(10);
		txtKhoaTrucThuoc.setBounds(175, 116, 443, 20);
		panel_2.add(txtKhoaTrucThuoc);
		
		JLabel lblNamVaoTruong_1 = new JLabel("Năm vào trường: ");
		lblNamVaoTruong_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNamVaoTruong_1.setBounds(49, 161, 128, 17);
		panel_2.add(lblNamVaoTruong_1);
		
		txtNamVaoTruong = new JTextField();
		txtNamVaoTruong.setText("0");
		txtNamVaoTruong.setEditable(false);
		txtNamVaoTruong.setColumns(10);
		txtNamVaoTruong.setBounds(175, 158, 443, 20);
		panel_2.add(txtNamVaoTruong);
		
		JLabel lblNamTotNghiep_1 = new JLabel("Năm tốt nghiệp: ");
		lblNamTotNghiep_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNamTotNghiep_1.setBounds(49, 200, 116, 17);
		panel_2.add(lblNamTotNghiep_1);
		
		txtNamTotNghiep = new JTextField();
		txtNamTotNghiep.setText("0");
		txtNamTotNghiep.setEditable(false);
		txtNamTotNghiep.setColumns(10);
		txtNamTotNghiep.setBounds(175, 197, 443, 20);
		panel_2.add(txtNamTotNghiep);
		
		JLabel lblMaNhom = new JLabel("Mã nhóm: ");
		lblMaNhom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMaNhom.setBounds(49, 239, 116, 14);
		panel_2.add(lblMaNhom);
		
		txtMaNhom = new JTextField();
		txtMaNhom.setText((String) null);
		txtMaNhom.setEditable(false);
		txtMaNhom.setColumns(10);
		txtMaNhom.setBounds(175, 236, 434, 20);
		panel_2.add(txtMaNhom);
		
		table.addMouseListener(this);
		btnTim.addActionListener(this);
		btnDangKyNhom.addActionListener(this);
		
		try {
			capNhat();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public JPanel getPanel() {
		return pnChung;
	}
	public void capNhat() throws ParseException {
		updateTable();
		updateTextField();
	}
	public void updateTextField() {
		SinhVien sv = sinhVienDao.timSinhVien(maSinhVien);
		txtMSSVChinh.setText(sv.getMaSinhVien());
		txtHoTenChinh.setText(sv.getHoTen());
		txtKhoaTrucThuocChinh.setText(sv.getKhoaTrucThuoc());
		txtNamVaoTruongChinh.setText(sv.getNamVaoTruong() + "");
		txtNamTotNghiepChinh.setText(sv.getNamTotNghiep() + "");
		txtMaNhomChinh.setText(sv.getMaNhom() == null ? "Chưa có nhóm" : sv.getMaNhom());
	}
	public void updateTable() throws ParseException {
		ArrayList<SinhVien> list = sinhVienDao.timSinhVien("", "", "", "", "", "", "");
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		
		int count = 1;
		for (SinhVien s : list) {
			if(s.getMaSinhVien().equals(maSinhVien)) {
				continue;
			}
			String[] rowData = {
					count++ + "",
					s.getMaSinhVien(),
					s.getHoTen(),
					s.getKhoaTrucThuoc(),
					s.getNamVaoTruong() + "",
					s.getNamTotNghiep() + "",
					s.getMaNhom()
			};
			model.addRow(rowData);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		txtMSSV.setText(table.getValueAt(row, 1).toString());
		txtHoTen.setText(table.getValueAt(row, 2).toString());
		txtKhoaTrucThuoc.setText(table.getValueAt(row, 3).toString());
		txtNamVaoTruong.setText(table.getValueAt(row, 4).toString());
		txtNamTotNghiep.setText(table.getValueAt(row, 5).toString());
		String maNhom = table.getValueAt(row, 6) == null ? "Chưa có nhóm" : table.getValueAt(row, 6).toString();
		txtMaNhom.setText(maNhom);
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
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnTim)) {
			String maSinhVien = "";
			String hoTen = "";
			String soDienThoai = "";
			String diaChi = "";
			String khoaTrucThuoc = "";
			String namVaoTruong = "";
			String namTotNghiep = "";
			String tieuChi = comboBoxTieuChi.getSelectedItem().toString().trim();
			if(tieuChi.equals("Mã sinh viên")) {
				maSinhVien = txtThongTinSinVienCanTim.getText() == null ? "" : txtThongTinSinVienCanTim.getText().toString().trim();
			} else if(tieuChi.equals("Tên sinh viên")) {
				hoTen = txtThongTinSinVienCanTim.getText() == null ? "" : txtThongTinSinVienCanTim.getText().toString().trim();
			} else if(tieuChi.equals("Số điện thoại")) {
				soDienThoai = txtThongTinSinVienCanTim.getText() == null ? "" : txtThongTinSinVienCanTim.getText().toString().trim();
			} else if(tieuChi.equals("Địa chỉ")) {
				diaChi = txtThongTinSinVienCanTim.getText() == null ? "" : txtThongTinSinVienCanTim.getText().toString().trim();
			}  else if(tieuChi.equals("Khoa trực thuộc")) {
				khoaTrucThuoc = txtThongTinSinVienCanTim.getText() == null ? "" : txtThongTinSinVienCanTim.getText().toString().trim();
			} else if(tieuChi.equals("Năm vào trường")) {
				namVaoTruong = txtThongTinSinVienCanTim.getText() == null ? "" : txtThongTinSinVienCanTim.getText().toString().trim();
			} else if(tieuChi.equals("Năm tốt nghiệp")) {
				namTotNghiep = txtThongTinSinVienCanTim.getText() == null ? "" : txtThongTinSinVienCanTim.getText().toString().trim();
			}
			
			ArrayList<SinhVien> list = sinhVienDao.timSinhVien(maSinhVien, hoTen, soDienThoai, diaChi, khoaTrucThuoc, namVaoTruong, namTotNghiep);
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.setRowCount(0);
			
			int count = 1;
			for (SinhVien s : list) {
				if(s.getMaSinhVien().equals(maSinhVien)) {
					continue;
				}
				String[] rowData = {
						count++ + "",
						s.getMaSinhVien(),
						s.getHoTen(),
						s.getKhoaTrucThuoc(),
						s.getNamVaoTruong() + "",
						s.getNamTotNghiep() + "",
						s.getMaNhom()
				};
				model.addRow(rowData);
			}
		} else if(o.equals(btnDangKyNhom)) {
			if(kiemTra()) {
				String maSinhVien1 = maSinhVien;
				String maSinhVien2 = txtMSSV.getText().trim();
				String maNhom1 = sinhVienDao.timSinhVien(maSinhVien1).getMaNhom();
				String maNhom2 = null;
				try {
					maNhom2 = sinhVienDao.timSinhVien(maSinhVien2).getMaNhom();
				} catch (Exception e2) {
					// TODO: handle exception
				}
				if(maNhom1 != null) {
					JOptionPane.showMessageDialog(frame, "Bạn đã đăng ký nhóm " + maNhom1);
					return;
				}
				if(maNhom2 != null) {
					JOptionPane.showMessageDialog(frame, "Sinh viên " + txtHoTen.getText().trim() + " đã đăng ký nhóm " + maNhom2);
					return;
				}
				if(sinhVienDao.dangKyNhom(maSinhVien1, maSinhVien2)) {
					JOptionPane.showMessageDialog(frame, "Đăng ký nhóm thành công");
					giaoDienChinh.moGiaoDienDangKyDeTai();
					try {
						capNhat();
						txtMaNhom.setText(txtMaNhomChinh.getText());
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					return;
				}
			}
			JOptionPane.showMessageDialog(frame, "Chưa chọn sinh viên muốn đăng ký nhóm");
		}
		
	}
	
	public boolean kiemTra() {
		int row = table.getSelectedRow();
		return row >= 0 && !txtMSSV.getText().equals("");
	}
}
