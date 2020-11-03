package gitHub;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Font;
import java.awt.Color;
import javax.swing.KeyStroke;
import javax.swing.border.LineBorder;

import giaovien.GiaoDien_GiaoVien;
import giaovien.GiaoDien_NhapDiem;
import giaovien.GiaoDien_XemDiemDaNhap;
import hethong.GiaoDien_DangNhap;
import hethong.GiaoDien_DangXuat;
import hethong.GiaoDien_DoiMatKhau;
import sinhVien.GiaoDien_DangKyDeTai;
import sinhVien.GiaoDien_SinhVien;
import sinhVien.GiaoDien_XemDiem;

import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.CardLayout;

public class GiaoDienChinh implements ActionListener {

	private JFrame frame;
	private JPanel pnChung;
	
	private CardLayout card;
	private GiaoDien_SinhVien GD_SV;
	private JMenuItem mniDangKyDeTai;
	private JMenu mnGiaoVien;
	private JMenuItem mniThongTinSinhVien;
	private JMenuItem mniXemDiem;
	private JMenuItem mniNhapDiem;
	private JMenuItem mniXemDiemDaNhap;
	private JMenu mnGiaoVuKhoa;
	private JMenuItem mniXepLichBaoVeLuanVan;
	private JMenu mnThongKe;
	private JMenuItem mniSinhVienBaoVeLuanVanThanhCong;
	private JMenuItem mniSinhVienBaoVeLuanVanKhongThanhCong;
	private JMenuItem mniXepLoaiDiemSinhVien;
	private JMenu mnDeTai;
	private JMenu mnLuanVan;
	private GiaoDien_DangKyDeTai GD_DKDT;
	private GiaoDien_XemDiem GD_XD;
	private GiaoDien_GiaoVien GD_GV;
	private JMenuItem mniThongTinGiaovien;
	private GiaoDien_NhapDiem GD_ND;
	private GiaoDien_DangNhap GD_DN;
	private JMenu mnHeThong;
	private JMenuItem mniDangNhap;
	private JMenuItem mniDoiMatKhau;
	private JMenuItem mniDangXuat;
	private GiaoDien_DoiMatKhau GD_DMK;
	private GiaoDien_DangXuat GD_DX;
	private GiaoDien_XemDiemDaNhap GD_XDDN;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GiaoDienChinh window = new GiaoDienChinh();
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
	public GiaoDienChinh() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Giao diện chính");
		frame.setBounds(10, 10, 1280, 1024);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		// menu sinh viên
		JMenu mnSinhVien = new JMenu("Sinh Viên");
		mnSinhVien.setBorder(new LineBorder(Color.GRAY, 1, true));
		mnSinhVien.setForeground(Color.BLACK);
		mnSinhVien.setBackground(Color.GRAY);
		mnSinhVien.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		menuBar.add(mnSinhVien);
		
		mniThongTinSinhVien = new JMenuItem("Thông tinh sinh viên");
		mniThongTinSinhVien.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		mniThongTinSinhVien.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnSinhVien.add(mniThongTinSinhVien);
		mnSinhVien.addSeparator();
		
		mniDangKyDeTai = new JMenuItem("Đăng ký đề tài");
		mniDangKyDeTai.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		mniDangKyDeTai.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnSinhVien.add(mniDangKyDeTai);
		mnSinhVien.addSeparator();
		
		mniXemDiem = new JMenuItem("Xem điểm");
		mniXemDiem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		mniXemDiem.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnSinhVien.add(mniXemDiem);
		
		// menu giáo viên
		mnGiaoVien = new JMenu("Giáo viên");
		mnGiaoVien.setBorder(new LineBorder(Color.GRAY, 1, true));
		mnGiaoVien.setForeground(Color.BLACK);
		mnGiaoVien.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		menuBar.add(mnGiaoVien);
		
		mniThongTinGiaovien = new JMenuItem("Thông tin giáo viên");
		mniThongTinGiaovien.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnGiaoVien.add(mniThongTinGiaovien);
		mnGiaoVien.addSeparator();
		
		mniNhapDiem = new JMenuItem("Nhập điểm");
		mniNhapDiem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		mniNhapDiem.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnGiaoVien.add(mniNhapDiem);
		mnGiaoVien.addSeparator();
		
		mniXemDiemDaNhap = new JMenuItem("Xem điểm đã nhập");
		mniXemDiemDaNhap.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnGiaoVien.add(mniXemDiemDaNhap);
		
		// menu giáo vụ khoa
		mnGiaoVuKhoa = new JMenu("Giáo vụ khoa");
		mnGiaoVuKhoa.setBorder(new LineBorder(Color.GRAY, 1, true));
		mnGiaoVuKhoa.setForeground(Color.BLACK);
		mnGiaoVuKhoa.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		menuBar.add(mnGiaoVuKhoa);
		
		mniXepLichBaoVeLuanVan = new JMenuItem("Xếp lịch bảo vệ luận văn");
		mniXepLichBaoVeLuanVan.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnGiaoVuKhoa.add(mniXepLichBaoVeLuanVan);
		mnGiaoVuKhoa.addSeparator();
		
		JMenuItem mniPhanCongHoiDong = new JMenuItem("Phân công hội đồng");
		mniPhanCongHoiDong.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnGiaoVuKhoa.add(mniPhanCongHoiDong);
		mnGiaoVuKhoa.addSeparator();
		
		mnThongKe = new JMenu("Thống kê");
		mnThongKe.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnGiaoVuKhoa.add(mnThongKe);
		
		mniSinhVienBaoVeLuanVanThanhCong = new JMenuItem("Sinh viên bảo vệ luận văn thành công");
		mniSinhVienBaoVeLuanVanThanhCong.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnThongKe.add(mniSinhVienBaoVeLuanVanThanhCong);
		mnThongKe.addSeparator();
		
		mniSinhVienBaoVeLuanVanKhongThanhCong = new JMenuItem("Sinh viên bảo vệ luận văn không thành công");
		mniSinhVienBaoVeLuanVanKhongThanhCong.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnThongKe.add(mniSinhVienBaoVeLuanVanKhongThanhCong);
		mnThongKe.addSeparator();
		
		mniXepLoaiDiemSinhVien = new JMenuItem("Xếp loại điểm sinh viên");
		mniXepLoaiDiemSinhVien.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnThongKe.add(mniXepLoaiDiemSinhVien);
		
		// menu đề tài
		mnDeTai = new JMenu("Đề tài");
		mnDeTai.setBorder(new LineBorder(Color.GRAY, 1, true));
		mnDeTai.setForeground(Color.BLACK);
		mnDeTai.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		menuBar.add(mnDeTai);
		
		// menu đề tài
		mnLuanVan = new JMenu("Luận văn");
		mnLuanVan.setBorder(new LineBorder(Color.GRAY, 1, true));
		mnLuanVan.setForeground(Color.BLACK);
		mnLuanVan.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		menuBar.add(mnLuanVan);
		
		// menu hệ thống
		mnHeThong = new JMenu("Hệ thống");
		mnHeThong.setBorder(new LineBorder(Color.GRAY, 1, true));
		mnHeThong.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		menuBar.add(mnHeThong);
		
		mniDangNhap = new JMenuItem("Đăng nhập");
		mniDangNhap.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnHeThong.add(mniDangNhap);
		mnHeThong.addSeparator();
		
		mniDoiMatKhau = new JMenuItem("Đổi mật khẩu");
		mniDoiMatKhau.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnHeThong.add(mniDoiMatKhau);
		mnHeThong.addSeparator();
		
		mniDangXuat = new JMenuItem("Đăng xuất");
		mniDangXuat.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnHeThong.add(mniDangXuat);
		
		pnChung = new JPanel();
		card = new CardLayout();
		frame.getContentPane().add(pnChung, BorderLayout.CENTER);
		pnChung.setLayout(card);
		
		// Sinh viên
		// Giao diện sinh viên
		GD_SV = new GiaoDien_SinhVien();
		pnChung.add(GD_SV.getPanel(), "ThongTinSinhVien");
		
		// Giao diện đăng ký đề tài
		GD_DKDT = new GiaoDien_DangKyDeTai();
		pnChung.add(GD_DKDT.getPanel(), "DangKyDeTai");
		
		// Giao diện xem điểm
		GD_XD = new GiaoDien_XemDiem();
		pnChung.add(GD_XD.getPanel(), "XemDiem");
		
		// Giáo viên
		// Giao diện giáo viên
		GD_GV = new GiaoDien_GiaoVien();
		pnChung.add(GD_GV.getPanel(), "ThongTinGiaoVien");
		
		// Giao diện nhập điểm
		GD_ND = new GiaoDien_NhapDiem();
		pnChung.add(GD_ND.getPanel(), "NhapDiem");
		
		// Giao diện xem điểm đã nhập
		GD_XDDN = new GiaoDien_XemDiemDaNhap();
		pnChung.add(GD_XDDN.getPanel(), "XemDiemDaNhap");
		
		// Hệ thống
		// Giao diện đăng nhập
		GD_DN = new GiaoDien_DangNhap();
		pnChung.add(GD_DN.getPanel(), "DangNhap");
		
		// Giao diện đổi mật khẩu
		GD_DMK = new GiaoDien_DoiMatKhau();
		pnChung.add(GD_DMK.getPanel(), "DoiMatKhau");
		
		// Giao diện đăng xuất
		GD_DX = new GiaoDien_DangXuat();
		pnChung.add(GD_DX.getPanel(), "DangXuat");
		
		mniThongTinSinhVien.addActionListener(this);
		mniDangKyDeTai.addActionListener(this);
		mniXemDiem.addActionListener(this);
		
		mniThongTinGiaovien.addActionListener(this);
		mniNhapDiem.addActionListener(this);
		mniXemDiemDaNhap.addActionListener(this);
		
		mniDangNhap.addActionListener(this);
		mniDoiMatKhau.addActionListener(this);
		mniDangXuat.addActionListener(this);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(mniThongTinSinhVien)) {
			card.show(pnChung, "ThongTinSinhVien");
		} else if(o.equals(mniDangKyDeTai)) {
			card.show(pnChung, "DangKyDeTai");
		} else if(o.equals(mniXemDiem)) {
			card.show(pnChung, "XemDiem");
		} else if(o.equals(mniThongTinGiaovien)) {
			card.show(pnChung, "ThongTinGiaoVien");
		} else if(o.equals(mniNhapDiem)) {
			card.show(pnChung, "NhapDiem");
		} else if(o.equals(mniXemDiemDaNhap)) {
			card.show(pnChung, "XemDiemDaNhap");
		}
		
		else if(o.equals(mniDangNhap)) {
			card.show(pnChung, "DangNhap");
		} else if(o.equals(mniDoiMatKhau)) {
			card.show(pnChung, "DoiMatKhau");
		} else if(o.equals(mniDangXuat)) {
			card.show(pnChung, "DangXuat");
		} 
		
		
	}

}
