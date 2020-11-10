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
import dao.DeTaiDao;
import dao.SinhVienDao;
import entity.DeTai;
import entity.SinhVien;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

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
	private JTextField txtTenDeTai;
	private JTextField txtTenLuanVan;
	private JTextField txtDiemVong1;
	private JTextField txtDiemVong2;
	private JTextField txtChuTichHoiDong;
	private JTextField txtThuKy;
	private JTextField textField;
	private JTextField txtGiaoVienPhanBien2;
	private JTextField txtGiaoVienPhanBien3;
	private JPanel pnChung;
	private JTextField txtThoiGianBaoVe;
	private SinhVienDao sinhVienDao;
	private DeTaiDao deTaiDao;

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
		deTaiDao = new DeTaiDao();
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
		lblMSSV.setBounds(43, 43, 116, 14);
		pnCenter.add(lblMSSV);
		
		txtMSSV = new JTextField();
		txtMSSV.setEditable(false);
		txtMSSV.setBounds(169, 40, 419, 20);
		pnCenter.add(txtMSSV);
		txtMSSV.setColumns(10);
		
		JLabel lblHoTen = new JLabel("Họ tên: ");
		lblHoTen.setBounds(43, 86, 116, 14);
		pnCenter.add(lblHoTen);
		
		txtHoTen = new JTextField();
		txtHoTen.setEditable(false);
		txtHoTen.setBounds(169, 83, 419, 20);
		pnCenter.add(txtHoTen);
		txtHoTen.setColumns(10);
		
		JLabel lblDiaChi = new JLabel("Địa chỉ: ");
		lblDiaChi.setBounds(43, 131, 116, 14);
		pnCenter.add(lblDiaChi);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setEditable(false);
		txtDiaChi.setBounds(169, 128, 419, 20);
		pnCenter.add(txtDiaChi);
		txtDiaChi.setColumns(10);
		
		JLabel lblNgaySinh = new JLabel("Ngày sinh: ");
		lblNgaySinh.setBounds(43, 172, 116, 14);
		pnCenter.add(lblNgaySinh);
		
		txtNgaySinh = new JTextField();
		txtNgaySinh.setEditable(false);
		txtNgaySinh.setBounds(169, 169, 419, 20);
		pnCenter.add(txtNgaySinh);
		txtNgaySinh.setColumns(10);
		
		JLabel lblSoDienThoai = new JLabel("Số điện thoại: ");
		lblSoDienThoai.setBounds(43, 214, 116, 14);
		pnCenter.add(lblSoDienThoai);
		
		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setEditable(false);
		txtSoDienThoai.setBounds(169, 211, 419, 20);
		pnCenter.add(txtSoDienThoai);
		txtSoDienThoai.setColumns(10);
		
		JLabel lblKhoaTrucThuoc = new JLabel("Khoa trực thuộc: ");
		lblKhoaTrucThuoc.setBounds(43, 256, 116, 14);
		pnCenter.add(lblKhoaTrucThuoc);
		
		txtKhoaTrucThuoc = new JTextField();
		txtKhoaTrucThuoc.setEditable(false);
		txtKhoaTrucThuoc.setBounds(169, 253, 419, 20);
		pnCenter.add(txtKhoaTrucThuoc);
		txtKhoaTrucThuoc.setColumns(10);
		
		JLabel lblNamVaoTruong = new JLabel("Năm vào trường: ");
		lblNamVaoTruong.setBounds(43, 304, 116, 14);
		pnCenter.add(lblNamVaoTruong);
		
		txtNamVaoTruong = new JTextField();
		txtNamVaoTruong.setEditable(false);
		txtNamVaoTruong.setBounds(169, 301, 419, 20);
		pnCenter.add(txtNamVaoTruong);
		txtNamVaoTruong.setColumns(10);
		
		JLabel lblNamTotNghiep = new JLabel("Năm tốt nghiệp: ");
		lblNamTotNghiep.setBounds(43, 359, 116, 14);
		pnCenter.add(lblNamTotNghiep);
		
		txtNamTotNghiep = new JTextField();
		txtNamTotNghiep.setEditable(false);
		txtNamTotNghiep.setBounds(169, 356, 419, 20);
		pnCenter.add(txtNamTotNghiep);
		txtNamTotNghiep.setColumns(10);
		
		lblIcon = new JLabel("");
		lblIcon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblIcon.setIcon(new ImageIcon(getClass().getResource("/avatar.png")));
		lblIcon.setBounds(809, 27, 256, 370);
		pnCenter.add(lblIcon);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u0110\u1EC1 t\u00E0i \u0111\u00E3 ch\u1ECDn", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 428, 635, 441);
		pnCenter.add(panel);
		panel.setLayout(null);
		
		JLabel lblTenDeTai = new JLabel("Tên đề tài: ");
		lblTenDeTai.setBounds(30, 51, 116, 14);
		panel.add(lblTenDeTai);
		
		txtTenDeTai = new JTextField();
		txtTenDeTai.setEditable(false);
		txtTenDeTai.setBounds(156, 48, 419, 20);
		panel.add(txtTenDeTai);
		txtTenDeTai.setColumns(10);
		
		JLabel lblTenLuanVan = new JLabel("Tên luận văn: ");
		lblTenLuanVan.setBounds(30, 101, 116, 14);
		panel.add(lblTenLuanVan);
		
		txtTenLuanVan = new JTextField();
		txtTenLuanVan.setEditable(false);
		txtTenLuanVan.setBounds(156, 98, 419, 20);
		panel.add(txtTenLuanVan);
		txtTenLuanVan.setColumns(10);
		
		JLabel lblTomTat = new JLabel("Tóm Tắt: ");
		lblTomTat.setBounds(30, 154, 116, 14);
		panel.add(lblTomTat);
		
		JTextArea txtaTomTat = new JTextArea();
		txtaTomTat.setEditable(false);
		txtaTomTat.setBounds(156, 149, 419, 99);
		panel.add(txtaTomTat);
		
		JLabel lblDiemVong1 = new JLabel("Điểm vòng 1: ");
		lblDiemVong1.setBounds(30, 285, 116, 14);
		panel.add(lblDiemVong1);
		
		txtDiemVong1 = new JTextField();
		txtDiemVong1.setEditable(false);
		txtDiemVong1.setBounds(156, 282, 419, 20);
		panel.add(txtDiemVong1);
		txtDiemVong1.setColumns(10);
		
		JLabel lblDiemVong2 = new JLabel("Điểm vòng 2: ");
		lblDiemVong2.setBounds(30, 332, 116, 14);
		panel.add(lblDiemVong2);
		
		txtDiemVong2 = new JTextField();
		txtDiemVong2.setEditable(false);
		txtDiemVong2.setBounds(156, 329, 419, 20);
		panel.add(txtDiemVong2);
		txtDiemVong2.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "H\u1ED9i \u0111\u1ED3ng b\u1EA3o v\u1EC7 lu\u1EADn v\u0103n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(655, 428, 599, 441);
		pnCenter.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblChuTichHoiDong = new JLabel("Chủ tịch hội đồng: ");
		lblChuTichHoiDong.setBounds(45, 81, 109, 14);
		panel_1.add(lblChuTichHoiDong);
		
		txtChuTichHoiDong = new JTextField();
		txtChuTichHoiDong.setEditable(false);
		txtChuTichHoiDong.setBounds(164, 78, 383, 20);
		panel_1.add(txtChuTichHoiDong);
		txtChuTichHoiDong.setColumns(10);
		
		JLabel lblThuKy = new JLabel("Thư ký: ");
		lblThuKy.setBounds(45, 122, 109, 14);
		panel_1.add(lblThuKy);
		
		txtThuKy = new JTextField();
		txtThuKy.setEditable(false);
		txtThuKy.setBounds(164, 119, 383, 20);
		panel_1.add(txtThuKy);
		txtThuKy.setColumns(10);
		
		JLabel lblGiaoVienPhanBien1 = new JLabel("Giáo viên phản biện 1: ");
		lblGiaoVienPhanBien1.setBounds(45, 167, 110, 14);
		panel_1.add(lblGiaoVienPhanBien1);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(164, 164, 383, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblGiaoVienPhanBien2 = new JLabel("Giáo viên phản biện 2: ");
		lblGiaoVienPhanBien2.setBounds(45, 218, 116, 14);
		panel_1.add(lblGiaoVienPhanBien2);
		
		txtGiaoVienPhanBien2 = new JTextField();
		txtGiaoVienPhanBien2.setEditable(false);
		txtGiaoVienPhanBien2.setBounds(164, 215, 383, 20);
		panel_1.add(txtGiaoVienPhanBien2);
		txtGiaoVienPhanBien2.setColumns(10);
		
		JLabel lblGiaoVienPhanBien3 = new JLabel("Giáo viên phản biện 3: ");
		lblGiaoVienPhanBien3.setBounds(45, 267, 116, 14);
		panel_1.add(lblGiaoVienPhanBien3);
		
		txtGiaoVienPhanBien3 = new JTextField();
		txtGiaoVienPhanBien3.setEditable(false);
		txtGiaoVienPhanBien3.setBounds(164, 264, 383, 20);
		panel_1.add(txtGiaoVienPhanBien3);
		txtGiaoVienPhanBien3.setColumns(10);
		
		JLabel lblGhiChu = new JLabel("Ghi chú: ");
		lblGhiChu.setBounds(45, 314, 109, 14);
		panel_1.add(lblGhiChu);
		
		JTextArea txtaGhiChu = new JTextArea();
		txtaGhiChu.setEditable(false);
		txtaGhiChu.setBounds(164, 309, 383, 74);
		panel_1.add(txtaGhiChu);
		
		JLabel lblThoiGianBaoVe = new JLabel("Thời gian bảo vệ: ");
		lblThoiGianBaoVe.setBounds(45, 40, 109, 14);
		panel_1.add(lblThoiGianBaoVe);
		
		txtThoiGianBaoVe = new JTextField();
		txtThoiGianBaoVe.setEditable(false);
		txtThoiGianBaoVe.setColumns(10);
		txtThoiGianBaoVe.setBounds(164, 37, 383, 20);
		panel_1.add(txtThoiGianBaoVe);
		
		try {
			updateTextField(0);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public JPanel getPanel() {
		return pnChung;
	}
	
	private void updateTextField(int ma) throws ParseException {
		List<SinhVien> listSinhVien = sinhVienDao.docTuBang();
		SinhVien sv = listSinhVien.get(ma);
		txtMSSV.setText(sv.getMaSinhVien());
		txtHoTen.setText(sv.getHoTen());
		txtNgaySinh.setText(sv.getNgaySinh());
		txtDiaChi.setText(sv.getDiaChi());
		txtSoDienThoai.setText(sv.getSoDienThoai());
		txtKhoaTrucThuoc.setText(sv.getKhoaTrucThuoc());
		txtNamVaoTruong.setText(sv.getNamVaoTruong() + "");
		txtNamTotNghiep.setText(sv.getNamTotNghiep() + "");
		
		
		List<DeTai> listDeTai = deTaiDao.docTuBang();
		DeTai dt = listDeTai.get(ma);
		txtTenDeTai.setText(dt.getTenDeTai());
		
	}
}
