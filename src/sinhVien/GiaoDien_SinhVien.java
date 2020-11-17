package sinhVien;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.text.ParseException;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import dao.Database;
import dao.LuanVanDao;
import dao.SinhVienDao;
import entity.LuanVan;
import entity.SinhVien;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.Color;

public class GiaoDien_SinhVien {

	private JFrame frame;
	private JTextField txtMSSV;
	private JTextField txtHoTen;
	private JTextField txtDiaChi;
	private JTextField txtNgaySinh;
	private JTextField txtSoDienThoai;
	private JTextField txtKhoaTrucThuoc;
	private JTextField txtNamVaoTruong;
	private JTextField txtNamTotNghiep;
	private JLabel lblIcon;
	private JTextField txtTenLuanVan;
	private JPanel pnChung;
	private SinhVienDao sinhVienDao;
	private JTextField txtTenSinhVienCungLamLuanVan;
	
	private final String maSinhVien = "SV001";
	private JTextField txtMaNhom;
	private LuanVanDao luanVanDao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GiaoDien_SinhVien window = new GiaoDien_SinhVien();
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
	public GiaoDien_SinhVien() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Database.getInstance().connec();
		sinhVienDao = new SinhVienDao();
		luanVanDao = new LuanVanDao();
		frame = new JFrame();
		frame.setBounds(10, 10, 1280, 950);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pnChung = new JPanel();
		frame.getContentPane().add(pnChung, BorderLayout.CENTER);
		pnChung.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTieuDe = new JLabel("Giao Diện Sinh Viên");
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDe.setFont(new Font("Tahoma", Font.PLAIN, 25));
		pnChung.add(lblTieuDe, BorderLayout.NORTH);
		
		JPanel pnCenter = new JPanel();
		pnCenter.setBorder(new TitledBorder(null, "Th\u00F4ng tin sinh vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnChung.add(pnCenter, BorderLayout.CENTER);
		pnCenter.setLayout(null);
		
		JLabel lblMSSV = new JLabel("MSSV: ");
		lblMSSV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMSSV.setBounds(42, 112, 116, 14);
		pnCenter.add(lblMSSV);
		
		txtMSSV = new JTextField();
		txtMSSV.setEditable(false);
		txtMSSV.setBounds(168, 109, 419, 20);
		pnCenter.add(txtMSSV);
		txtMSSV.setColumns(10);
		
		JLabel lblHoTen = new JLabel("Họ tên: ");
		lblHoTen.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHoTen.setBounds(42, 155, 116, 17);
		pnCenter.add(lblHoTen);
		
		txtHoTen = new JTextField();
		txtHoTen.setEditable(false);
		txtHoTen.setBounds(168, 152, 419, 20);
		pnCenter.add(txtHoTen);
		txtHoTen.setColumns(10);
		
		JLabel lblDiaChi = new JLabel("Địa chỉ: ");
		lblDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDiaChi.setBounds(42, 200, 116, 17);
		pnCenter.add(lblDiaChi);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setEditable(false);
		txtDiaChi.setBounds(168, 197, 419, 20);
		pnCenter.add(txtDiaChi);
		txtDiaChi.setColumns(10);
		
		JLabel lblNgaySinh = new JLabel("Ngày sinh: ");
		lblNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNgaySinh.setBounds(42, 241, 116, 17);
		pnCenter.add(lblNgaySinh);
		
		txtNgaySinh = new JTextField();
		txtNgaySinh.setEditable(false);
		txtNgaySinh.setBounds(168, 238, 419, 20);
		pnCenter.add(txtNgaySinh);
		txtNgaySinh.setColumns(10);
		
		JLabel lblSoDienThoai = new JLabel("Số điện thoại: ");
		lblSoDienThoai.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSoDienThoai.setBounds(42, 283, 116, 17);
		pnCenter.add(lblSoDienThoai);
		
		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setEditable(false);
		txtSoDienThoai.setBounds(168, 280, 419, 20);
		pnCenter.add(txtSoDienThoai);
		txtSoDienThoai.setColumns(10);
		
		JLabel lblKhoaTrucThuoc = new JLabel("Khoa trực thuộc: ");
		lblKhoaTrucThuoc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblKhoaTrucThuoc.setBounds(42, 325, 116, 17);
		pnCenter.add(lblKhoaTrucThuoc);
		
		txtKhoaTrucThuoc = new JTextField();
		txtKhoaTrucThuoc.setEditable(false);
		txtKhoaTrucThuoc.setBounds(168, 322, 419, 20);
		pnCenter.add(txtKhoaTrucThuoc);
		txtKhoaTrucThuoc.setColumns(10);
		
		JLabel lblNamVaoTruong = new JLabel("Năm vào trường: ");
		lblNamVaoTruong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNamVaoTruong.setBounds(42, 373, 128, 17);
		pnCenter.add(lblNamVaoTruong);
		
		txtNamVaoTruong = new JTextField();
		txtNamVaoTruong.setEditable(false);
		txtNamVaoTruong.setBounds(168, 370, 419, 20);
		pnCenter.add(txtNamVaoTruong);
		txtNamVaoTruong.setColumns(10);
		
		JLabel lblNamTotNghiep = new JLabel("Năm tốt nghiệp: ");
		lblNamTotNghiep.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNamTotNghiep.setBounds(42, 428, 116, 17);
		pnCenter.add(lblNamTotNghiep);
		
		txtNamTotNghiep = new JTextField();
		txtNamTotNghiep.setEditable(false);
		txtNamTotNghiep.setBounds(168, 425, 419, 20);
		pnCenter.add(txtNamTotNghiep);
		txtNamTotNghiep.setColumns(10);
		
		lblIcon = new JLabel("");
		lblIcon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblIcon.setIcon(new ImageIcon(getClass().getResource("/avatar.png")));
		lblIcon.setBounds(809, 27, 256, 370);
		pnCenter.add(lblIcon);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u0110\u1EC1 t\u00E0i \u0111\u00E3 ch\u1ECDn", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 568, 1244, 301);
		pnCenter.add(panel);
		panel.setLayout(null);
		
		JLabel lblTenLuanVan = new JLabel("Tên luận văn: ");
		lblTenLuanVan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTenLuanVan.setBounds(31, 45, 141, 14);
		panel.add(lblTenLuanVan);
		
		txtTenLuanVan = new JTextField();
		txtTenLuanVan.setEditable(false);
		txtTenLuanVan.setBounds(182, 42, 1032, 20);
		panel.add(txtTenLuanVan);
		txtTenLuanVan.setColumns(10);
		
		txtTenSinhVienCungLamLuanVan = new JTextField();
		txtTenSinhVienCungLamLuanVan.setEditable(false);
		txtTenSinhVienCungLamLuanVan.setColumns(10);
		txtTenSinhVienCungLamLuanVan.setBounds(177, 113, 1037, 20);
		panel.add(txtTenSinhVienCungLamLuanVan);
		
		JLabel lblSinhVienCungNhom = new JLabel("Sinh viên cùng nhóm: ");
		lblSinhVienCungNhom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSinhVienCungNhom.setBounds(31, 116, 145, 17);
		panel.add(lblSinhVienCungNhom);
		
		JLabel lblMaNhom = new JLabel("Mã nhóm: ");
		lblMaNhom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMaNhom.setBounds(42, 486, 116, 17);
		pnCenter.add(lblMaNhom);
		
		txtMaNhom = new JTextField();
		txtMaNhom.setEditable(false);
		txtMaNhom.setColumns(10);
		txtMaNhom.setBounds(168, 483, 419, 20);
		pnCenter.add(txtMaNhom);
		
		try {
			updateTextField();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public JPanel getPanel() {
		return pnChung;
	}
	
	private void updateTextField() throws ParseException {
		SinhVien sv = sinhVienDao.timSinhVien(maSinhVien);
		if(sv == null) {
			System.out.println("hihi");
			return;
		}
		txtMSSV.setText(sv.getMaSinhVien());
		txtHoTen.setText(sv.getHoTen());
		txtNgaySinh.setText(sv.getNgaySinh());
		txtDiaChi.setText(sv.getDiaChi());
		txtSoDienThoai.setText(sv.getSoDienThoai());
		txtKhoaTrucThuoc.setText(sv.getKhoaTrucThuoc());
		txtNamVaoTruong.setText(sv.getNamVaoTruong() + "");
		txtNamTotNghiep.setText(sv.getNamTotNghiep() + "");
		txtMaNhom.setText(sv.getMaNhom());
		
		LuanVan lv = luanVanDao.timLuanVanTheoMaSinhVien(maSinhVien);
		if(lv != null) {
			txtTenLuanVan.setText(lv.getTenLuanVan());
		} else {
			txtTenLuanVan.setText("");
		}
		
		String tenSinhVienCungNhom = sinhVienDao.timSinhVienCungNhom(sv.getMaNhom(), sv.getMaSinhVien()) == null ? "" : 
			sinhVienDao.timSinhVienCungNhom(sv.getMaNhom(), sv.getMaSinhVien()).getHoTen();
		txtTenSinhVienCungLamLuanVan.setText(tenSinhVienCungNhom);
	}
}
