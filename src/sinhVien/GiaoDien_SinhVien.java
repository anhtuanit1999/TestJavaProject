package sinhVien;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
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
import java.awt.Dimension;

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
	
	private final String maSinhVien;
	private JTextField txtMaNhom;
	private LuanVanDao luanVanDao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GiaoDien_SinhVien window = new GiaoDien_SinhVien("SV001");
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
	public GiaoDien_SinhVien(String maSinhVien) {
		this.maSinhVien = maSinhVien;
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
		int font = 15;
		double height = screenSize.getHeight() < oldHeight ? oldHeight : screenSize.getHeight();
		double width = screenSize.getWidth() < oldWidth ? oldWidth : screenSize.getWidth();
		sinhVienDao = new SinhVienDao();
		luanVanDao = new LuanVanDao();
		frame = new JFrame();
		frame.setBounds(10, 10, 1280, 950);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setResizable(false);
		
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
		lblMSSV.setFont(new Font("Tahoma", Font.PLAIN, font));
		lblMSSV.setBounds((int)Math.round(width/2 - (oldWidth/2 - 42)), 112, 116, 14);
		pnCenter.add(lblMSSV);
		
		txtMSSV = new JTextField();
		txtMSSV.setEditable(false);
		txtMSSV.setBounds((int)Math.round(width/2 - (oldWidth/2 - 168)), 109, 419, 20);
		pnCenter.add(txtMSSV);
		txtMSSV.setColumns(10);
		
		JLabel lblHoTen = new JLabel("Họ tên: ");
		lblHoTen.setFont(new Font("Tahoma", Font.PLAIN, font));
		lblHoTen.setBounds((int)Math.round(width/2 - (oldWidth/2 - 42)), 155, 116, 17);
		pnCenter.add(lblHoTen);
		
		txtHoTen = new JTextField();
		txtHoTen.setEditable(false);
		txtHoTen.setBounds((int)Math.round(width/2 - (oldWidth/2 - 168)), 152, 419, 20);
		pnCenter.add(txtHoTen);
		txtHoTen.setColumns(10);
		
		JLabel lblDiaChi = new JLabel("Địa chỉ: ");
		lblDiaChi.setFont(new Font("Tahoma", Font.PLAIN, font));
		lblDiaChi.setBounds((int)Math.round(width/2 - (oldWidth/2 - 42)), 200, 116, 17);
		pnCenter.add(lblDiaChi);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setEditable(false);
		txtDiaChi.setBounds((int)Math.round(width/2 - (oldWidth/2 - 168)), 197, 419, 20);
		pnCenter.add(txtDiaChi);
		txtDiaChi.setColumns(10);
		
		JLabel lblNgaySinh = new JLabel("Ngày sinh: ");
		lblNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, font));
		lblNgaySinh.setBounds((int)Math.round(width/2 - (oldWidth/2 - 42)), 241, 116, 17);
		pnCenter.add(lblNgaySinh);
		
		txtNgaySinh = new JTextField();
		txtNgaySinh.setEditable(false);
		txtNgaySinh.setBounds((int)Math.round(width/2 - (oldWidth/2 - 168)), 238, 419, 20);
		pnCenter.add(txtNgaySinh);
		txtNgaySinh.setColumns(10);
		
		JLabel lblSoDienThoai = new JLabel("Số điện thoại: ");
		lblSoDienThoai.setFont(new Font("Tahoma", Font.PLAIN, font));
		lblSoDienThoai.setBounds((int)Math.round(width/2 - (oldWidth/2 - 42)), 283, 116, 17);
		pnCenter.add(lblSoDienThoai);
		
		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setEditable(false);
		txtSoDienThoai.setBounds((int)Math.round(width/2 - (oldWidth/2 - 168)), 280, 419, 20);
		pnCenter.add(txtSoDienThoai);
		txtSoDienThoai.setColumns(10);
		
		JLabel lblKhoaTrucThuoc = new JLabel("Khoa trực thuộc: ");
		lblKhoaTrucThuoc.setFont(new Font("Tahoma", Font.PLAIN, font));
		lblKhoaTrucThuoc.setBounds((int)Math.round(width/2 - (oldWidth/2 - 42)), 325, 116, 17);
		pnCenter.add(lblKhoaTrucThuoc);
		
		txtKhoaTrucThuoc = new JTextField();
		txtKhoaTrucThuoc.setEditable(false);
		txtKhoaTrucThuoc.setBounds((int)Math.round(width/2 - (oldWidth/2 - 168)), 322, 419, 20);
		pnCenter.add(txtKhoaTrucThuoc);
		txtKhoaTrucThuoc.setColumns(10);
		
		JLabel lblNamVaoTruong = new JLabel("Năm vào trường: ");
		lblNamVaoTruong.setFont(new Font("Tahoma", Font.PLAIN, font));
		lblNamVaoTruong.setBounds((int)Math.round(width/2 - (oldWidth/2 - 42)), 373, 128, 17);
		pnCenter.add(lblNamVaoTruong);
		
		txtNamVaoTruong = new JTextField();
		txtNamVaoTruong.setEditable(false);
		txtNamVaoTruong.setBounds((int)Math.round(width/2 - (oldWidth/2 - 168)), 370, 419, 20);
		pnCenter.add(txtNamVaoTruong);
		txtNamVaoTruong.setColumns(10);
		
		JLabel lblNamTotNghiep = new JLabel("Năm tốt nghiệp: ");
		lblNamTotNghiep.setFont(new Font("Tahoma", Font.PLAIN, font));
		lblNamTotNghiep.setBounds((int)Math.round(width/2 - (oldWidth/2 - 42)), 428, 116, 17);
		pnCenter.add(lblNamTotNghiep);
		
		txtNamTotNghiep = new JTextField();
		txtNamTotNghiep.setEditable(false);
		txtNamTotNghiep.setBounds((int)Math.round(width/2 - (oldWidth/2 - 168)), 425, 419, 20);
		pnCenter.add(txtNamTotNghiep);
		txtNamTotNghiep.setColumns(10);
		
		lblIcon = new JLabel("");
		lblIcon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblIcon.setIcon(new ImageIcon(getClass().getResource("/avatar.png")));
		lblIcon.setBounds((int)Math.round(width/2 - (oldWidth/2 - 809)), 27, 256, 370);
		pnCenter.add(lblIcon);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u0110\u1EC1 t\u00E0i \u0111\u00E3 ch\u1ECDn", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds((int)Math.round(width/2 - (oldWidth/2 - 10)), 568, 1244, 301);
		pnCenter.add(panel);
		panel.setLayout(null);
		
		JLabel lblTenLuanVan = new JLabel("Tên luận văn: ");
		lblTenLuanVan.setFont(new Font("Tahoma", Font.PLAIN, font));
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
		lblSinhVienCungNhom.setFont(new Font("Tahoma", Font.PLAIN, font));
		lblSinhVienCungNhom.setBounds(31, 116, 145, 17);
		panel.add(lblSinhVienCungNhom);
		
		JLabel lblMaNhom = new JLabel("Mã nhóm: ");
		lblMaNhom.setFont(new Font("Tahoma", Font.PLAIN, font));
		lblMaNhom.setBounds((int)Math.round(width/2 - (oldWidth/2 - 42)), 486, 116, 17);
		pnCenter.add(lblMaNhom);
		
		txtMaNhom = new JTextField();
		txtMaNhom.setEditable(false);
		txtMaNhom.setColumns(10);
		txtMaNhom.setBounds((int)Math.round(width/2 - (oldWidth/2 - 168)), 483, 419, 20);
		pnCenter.add(txtMaNhom);
		
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
		updateTextField();
	}
	
	public void updateTextField() throws ParseException {
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
