package giaodienchinh;

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

import dao.DangNhapDao;
import dao.Database;
import giaovien.GiaoDien_GiaoVien;
import giaovien.GiaoDien_NhapDiem;
import giaovien.GiaoDien_XemDiemDaNhap;
import giaovukhoa.GiaoDien_BaoCao;
import giaovukhoa.GiaoDien_PhanCongHoiDong;
import giaovukhoa.GiaoDien_PhanCongHoiDongChamDiem;
import giaovukhoa.GiaoDien_QuanLyLuanVan;
import giaovukhoa.GiaoDien_ThongKe;
import giaovukhoa.GiaoDien_TraCuuThongTinHoiDong;
import hethong.GiaoDien_DangXuat;
import hethong.GiaoDien_DoiMatKhau;
import sinhVien.GiaoDien_DangKyDeTai;
import sinhVien.GiaoDien_SinhVien;
import sinhVien.GiaoDien_TimDeTai;
import sinhVien.GiaoDien_XemDiem;

import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.CardLayout;

public class GiaoDienChinh implements ActionListener {

	public JFrame frame;
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
	private JMenu mnThongKe;
	private JMenuItem mniSinhVienBaoVeLuanVanThanhCong;
	private JMenuItem mniSinhVienBaoVeLuanVanKhongThanhCong;
	private JMenuItem mniXepLoaiDiemSinhVien;
	private JMenuItem mniPhanCongHoiDongChamDiem;
	private GiaoDien_DangKyDeTai GD_DKDT;
	private GiaoDien_XemDiem GD_XD;
	private GiaoDien_GiaoVien GD_GV;
	private JMenuItem mniThongTinGiaovien;
	private GiaoDien_NhapDiem GD_ND;
	private GiaoDien_DangNhap GD_DN;
	private JMenu mnHeThong;
	private JMenuItem mniDoiMatKhau;
	private JMenuItem mniDangXuat;
	private GiaoDien_DoiMatKhau GD_DMK;
	private GiaoDien_DangXuat GD_DX;
	private GiaoDien_XemDiemDaNhap GD_XDDN;
	private JMenuItem mniTimDeTai;
	private JMenu mnBaoCao;
	private JMenuItem mniDanhSachSinhVienDangKyDeTai;
	private JMenuItem mniQuanLyLuanVan;
	private GiaoDien_TimDeTai GD_TDT;
	private GiaoDien_QuanLyLuanVan GD_QLLV;
	private GiaoDien_BaoCao GD_BC;
	private GiaoDien_PhanCongHoiDong GD_PCHD;
	private JMenuItem mniPhanCongHoiDong;
	private GiaoDien_ThongKe GD_SVBVLVTC;
	private GiaoDien_ThongKe GD_SVBVLVKTC;
	private GiaoDien_ThongKe GD_XDSV;
	private GiaoDien_PhanCongHoiDongChamDiem GD_PCHDCD;
	private JMenuItem mniTraCuuThongTinHoiDong;
	private GiaoDien_TraCuuThongTinHoiDong GD_TCHD;
	
	private String taiKhoan;
	private DangNhapDao dangNhapDao;
	private JMenu mnSinhVien;
	
	

	public String getTaiKhoan() {
		return taiKhoan;
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GiaoDienChinh window = new GiaoDienChinh("GV001");
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws ParseException 
	 */
	public GiaoDienChinh(String taiKhoan) throws SQLException, ParseException {
		this.taiKhoan = taiKhoan;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 * @throws ParseException 
	 */
	private void initialize() throws SQLException, ParseException {
		Database.getInstance().connec();
		dangNhapDao = new DangNhapDao();
		frame = new JFrame();
		frame.setTitle("Giao diện chính");
		frame.setBounds(10, 10, 1280, 1024);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		// menu sinh viên
		mnSinhVien = new JMenu("Sinh Viên");
		mnSinhVien.setBorder(new LineBorder(Color.GRAY, 1, true));
		mnSinhVien.setForeground(Color.BLACK);
		mnSinhVien.setBackground(Color.GRAY);
		mnSinhVien.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		menuBar.add(mnSinhVien);
		
		mniThongTinSinhVien = new JMenuItem("Thông tinh sinh viên");
		mniThongTinSinhVien.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		mniThongTinSinhVien.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnSinhVien.add(mniThongTinSinhVien);
		mnSinhVien.addSeparator();
		
		mniDangKyDeTai = new JMenuItem("Đăng ký đề tài");
		mniDangKyDeTai.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		mniDangKyDeTai.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnSinhVien.add(mniDangKyDeTai);
		mnSinhVien.addSeparator();
		
		mniXemDiem = new JMenuItem("Xem điểm");
		mniXemDiem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		mniXemDiem.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnSinhVien.add(mniXemDiem);
		mnSinhVien.addSeparator();
		
		mniTimDeTai = new JMenuItem("Tìm đề tài");
		mniTimDeTai.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_4, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		mniTimDeTai.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnSinhVien.add(mniTimDeTai);
		
		// menu giáo viên
		mnGiaoVien = new JMenu("Giáo viên");
		mnGiaoVien.setBorder(new LineBorder(Color.GRAY, 1, true));
		mnGiaoVien.setForeground(Color.BLACK);
		mnGiaoVien.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		menuBar.add(mnGiaoVien);
		
		mniThongTinGiaovien = new JMenuItem("Thông tin giáo viên");
		mniThongTinGiaovien.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_5, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		mniThongTinGiaovien.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnGiaoVien.add(mniThongTinGiaovien);
		mnGiaoVien.addSeparator();
		
		mniNhapDiem = new JMenuItem("Nhập điểm");
		mniNhapDiem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_6, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		mniNhapDiem.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnGiaoVien.add(mniNhapDiem);
		mnGiaoVien.addSeparator();
		
		mniXemDiemDaNhap = new JMenuItem("Xem điểm đã nhập");
		mniXemDiemDaNhap.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_7, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		mniXemDiemDaNhap.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnGiaoVien.add(mniXemDiemDaNhap);
		
		// menu giáo vụ khoa
		mnGiaoVuKhoa = new JMenu("Giáo vụ khoa");
		mnGiaoVuKhoa.setBorder(new LineBorder(Color.GRAY, 1, true));
		mnGiaoVuKhoa.setForeground(Color.BLACK);
		mnGiaoVuKhoa.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		menuBar.add(mnGiaoVuKhoa);
		
		mniQuanLyLuanVan = new JMenuItem("Quản lý luận văn");
		mniQuanLyLuanVan.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnGiaoVuKhoa.add(mniQuanLyLuanVan);
		mnGiaoVuKhoa.addSeparator();
		
		mniPhanCongHoiDong = new JMenuItem("Phân công hội đồng");
		mniPhanCongHoiDong.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnGiaoVuKhoa.add(mniPhanCongHoiDong);
		mnGiaoVuKhoa.addSeparator();
		
		mniPhanCongHoiDongChamDiem = new JMenuItem("Phân công hội đồng chấm điểm");
		mniPhanCongHoiDongChamDiem.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnGiaoVuKhoa.add(mniPhanCongHoiDongChamDiem);
		mnGiaoVuKhoa.addSeparator();
		
		mniTraCuuThongTinHoiDong = new JMenuItem("Tra cứu thông tin hội đồng");
		mniTraCuuThongTinHoiDong.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnGiaoVuKhoa.add(mniTraCuuThongTinHoiDong);
		mnGiaoVuKhoa.addSeparator();
		
		mnThongKe = new JMenu("Thống kê");
		mnThongKe.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnGiaoVuKhoa.add(mnThongKe);
		mnGiaoVuKhoa.addSeparator();
		
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
		
		mnBaoCao = new JMenu("Báo cáo");
		mnBaoCao.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnGiaoVuKhoa.add(mnBaoCao);
		
		mniDanhSachSinhVienDangKyDeTai = new JMenuItem("Danh sách sinh viên đăng ký đề tài");
		mniDanhSachSinhVienDangKyDeTai.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnBaoCao.add(mniDanhSachSinhVienDangKyDeTai);
		
		// menu hệ thống
		mnHeThong = new JMenu("Hệ thống");
		mnHeThong.setForeground(Color.BLACK);
		mnHeThong.setBorder(new LineBorder(Color.GRAY, 1, true));
		mnHeThong.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		menuBar.add(mnHeThong);
		
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
		
		String quyen = dangNhapDao.layQuyenDangNhapTuongUng(taiKhoan);
		if(quyen.equals("TAIKHOANSINHVIEN")) {
			mnGiaoVien.setEnabled(false);
			mnGiaoVuKhoa.setEnabled(false);
			
			// Sinh viên ------------------------------------------------------------
			// Giao diện sinh viên
			GD_SV = new GiaoDien_SinhVien(taiKhoan);
			pnChung.add(GD_SV.getPanel(), "ThongTinSinhVien");
			
			// Giao diện đăng ký đề tài
			GD_DKDT = new GiaoDien_DangKyDeTai(taiKhoan);
			pnChung.add(GD_DKDT.getPanel(), "DangKyDeTai");
			
			// Giao diện xem điểm
			GD_XD = new GiaoDien_XemDiem(taiKhoan);
			pnChung.add(GD_XD.getPanel(), "XemDiem");
			
			// Giao diện tìm đề tài
			GD_TDT = new GiaoDien_TimDeTai();
			pnChung.add(GD_TDT.getPanel(), "TimDeTai");
			
			// Hệ thống ----------------------------------------------------------------
			
			// Giao diện đổi mật khẩu
			GD_DMK = new GiaoDien_DoiMatKhau(taiKhoan);
			pnChung.add(GD_DMK.getPanel(), "DoiMatKhau");
			
		} else if(quyen.equals("TAIKHOANGIAOVIEN")) {
			mnSinhVien.setEnabled(false);
			mnGiaoVuKhoa.setEnabled(false);
			
			// Giáo viên ------------------------------------------------------------
			// Giao diện giáo viên
			GD_GV = new GiaoDien_GiaoVien(taiKhoan);
			pnChung.add(GD_GV.getPanel(), "ThongTinGiaoVien");
			
			// Giao diện nhập điểm
			GD_ND = new GiaoDien_NhapDiem(taiKhoan);
			pnChung.add(GD_ND.getPanel(), "NhapDiem");
			
			// Giao diện xem điểm đã nhập
			GD_XDDN = new GiaoDien_XemDiemDaNhap(taiKhoan);
			pnChung.add(GD_XDDN.getPanel(), "XemDiemDaNhap");
			
			// Hệ thống ----------------------------------------------------------------
			
			// Giao diện đổi mật khẩu
			GD_DMK = new GiaoDien_DoiMatKhau(taiKhoan);
			pnChung.add(GD_DMK.getPanel(), "DoiMatKhau");
						
		} else {
			if(taiKhoan.equals("GVK")) {
				mnSinhVien.setEnabled(false);
				mnGiaoVien.setEnabled(false);
				
				// Giáo vụ khoa ------------------------------------------------------------
				// Giao diện quản lý luận văn
				GD_QLLV = new GiaoDien_QuanLyLuanVan();
				pnChung.add(GD_QLLV.getPanel(), "QuanLyLuanVan");
				
				// Giao diện báo cáo
				GD_BC = new GiaoDien_BaoCao();
				pnChung.add(GD_BC.getPanel(), "BaoCaoDanhSach");
				
				// Giao diện phân công hội đồng
				GD_PCHD = new GiaoDien_PhanCongHoiDong();
				pnChung.add(GD_PCHD.getPanel(), "PhanCongHoiDong");
				
				// Giao diện phân công hội đồng chấm điểm
				GD_PCHDCD = new GiaoDien_PhanCongHoiDongChamDiem();
				pnChung.add(GD_PCHDCD.getPanel(), "PhanCongHoiDongChamDiem");
				
				GD_TCHD = new GiaoDien_TraCuuThongTinHoiDong();
				pnChung.add(GD_TCHD.getPanel(), "TraCuuThongTinHoiDong");
				
				// Giao diện thống kê danh sách sinh viên bảo vệ luận văn thành công
				GD_SVBVLVTC = new GiaoDien_ThongKe();
				pnChung.add(GD_SVBVLVTC.getPanel(), "ThongKe");
				
				// Giao diện thống kê danh sách sinh viên bảo vệ luận văn không thành công
				GD_SVBVLVKTC = new GiaoDien_ThongKe();
				pnChung.add(GD_SVBVLVKTC.getPanel(), "ThongKe");
				
				// Giao diện thống kê xếp loại điểm sinh viên
				GD_XDSV = new GiaoDien_ThongKe();
				pnChung.add(GD_XDSV.getPanel(), "ThongKe");
				
				// Hệ thống ----------------------------------------------------------------
				
				// Giao diện đổi mật khẩu
				GD_DMK = new GiaoDien_DoiMatKhau(taiKhoan);
				pnChung.add(GD_DMK.getPanel(), "DoiMatKhau");
				
			} else {
				// Hệ thống ----------------------------------------------------------------
				
				// Giao diện đổi mật khẩu
				GD_DMK = new GiaoDien_DoiMatKhau("admin");
				pnChung.add(GD_DMK.getPanel(), "DoiMatKhau");
			}
			
			// Sinh viên ------------------------------------------------------------
			// Giao diện sinh viên
			GD_SV = new GiaoDien_SinhVien("SV001");
			pnChung.add(GD_SV.getPanel(), "ThongTinSinhVien");
			
			// Giao diện đăng ký đề tài
			GD_DKDT = new GiaoDien_DangKyDeTai("SV001");
			pnChung.add(GD_DKDT.getPanel(), "DangKyDeTai");
			
			// Giao diện xem điểm
			GD_XD = new GiaoDien_XemDiem("SV001");
			pnChung.add(GD_XD.getPanel(), "XemDiem");
			
			// Giao diện tìm đề tài
			GD_TDT = new GiaoDien_TimDeTai();
			pnChung.add(GD_TDT.getPanel(), "TimDeTai");
			
			// Giáo viên ------------------------------------------------------------
			// Giao diện giáo viên
			GD_GV = new GiaoDien_GiaoVien("GV001");
			pnChung.add(GD_GV.getPanel(), "ThongTinGiaoVien");
			
			// Giao diện nhập điểm
			GD_ND = new GiaoDien_NhapDiem("GV001");
			pnChung.add(GD_ND.getPanel(), "NhapDiem");
			
			// Giao diện xem điểm đã nhập
			GD_XDDN = new GiaoDien_XemDiemDaNhap("GV001");
			pnChung.add(GD_XDDN.getPanel(), "XemDiemDaNhap");
			
			// Giáo vụ khoa ------------------------------------------------------------
			// Giao diện quản lý luận văn
			GD_QLLV = new GiaoDien_QuanLyLuanVan();
			pnChung.add(GD_QLLV.getPanel(), "QuanLyLuanVan");
			
			// Giao diện báo cáo
			GD_BC = new GiaoDien_BaoCao();
			pnChung.add(GD_BC.getPanel(), "BaoCaoDanhSach");
			
			// Giao diện phân công hội đồng
			GD_PCHD = new GiaoDien_PhanCongHoiDong();
			pnChung.add(GD_PCHD.getPanel(), "PhanCongHoiDong");
			
			// Giao diện phân công hội đồng chấm điểm
			GD_PCHDCD = new GiaoDien_PhanCongHoiDongChamDiem();
			pnChung.add(GD_PCHDCD.getPanel(), "PhanCongHoiDongChamDiem");
			
			GD_TCHD = new GiaoDien_TraCuuThongTinHoiDong();
			pnChung.add(GD_TCHD.getPanel(), "TraCuuThongTinHoiDong");
			
			// Giao diện thống kê danh sách sinh viên bảo vệ luận văn thành công
			GD_SVBVLVTC = new GiaoDien_ThongKe();
			pnChung.add(GD_SVBVLVTC.getPanel(), "ThongKe");
			
			// Giao diện thống kê danh sách sinh viên bảo vệ luận văn không thành công
			GD_SVBVLVKTC = new GiaoDien_ThongKe();
			pnChung.add(GD_SVBVLVKTC.getPanel(), "ThongKe");
			
			// Giao diện thống kê xếp loại điểm sinh viên
			GD_XDSV = new GiaoDien_ThongKe();
			pnChung.add(GD_XDSV.getPanel(), "ThongKe");
			
		}
		
		// Hệ thống ----------------------------------------------------------------
		
		// Giao diện đăng xuất
		GD_DX = new GiaoDien_DangXuat(this);
		pnChung.add(GD_DX.getPanel(), "DangXuat");
		
		mniThongTinSinhVien.addActionListener(this);
		mniDangKyDeTai.addActionListener(this);
		mniXemDiem.addActionListener(this);
		mniTimDeTai.addActionListener(this);
		
		mniThongTinGiaovien.addActionListener(this);
		mniNhapDiem.addActionListener(this);
		mniXemDiemDaNhap.addActionListener(this);
		
		mniQuanLyLuanVan.addActionListener(this);
		mniDanhSachSinhVienDangKyDeTai.addActionListener(this);
		mniPhanCongHoiDong.addActionListener(this);
		mniPhanCongHoiDongChamDiem.addActionListener(this);
		mniSinhVienBaoVeLuanVanThanhCong.addActionListener(this);
		mniSinhVienBaoVeLuanVanKhongThanhCong.addActionListener(this);
		mniXepLoaiDiemSinhVien.addActionListener(this);
		
		mniTraCuuThongTinHoiDong.addActionListener(this);
		mniDoiMatKhau.addActionListener(this);
		mniDangXuat.addActionListener(this);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(mniThongTinSinhVien)) { // Sinh viên -------------------------------
			card.show(pnChung, "ThongTinSinhVien");
		} else if(o.equals(mniDangKyDeTai)) {
			card.show(pnChung, "DangKyDeTai");
		} else if(o.equals(mniXemDiem)) {
			card.show(pnChung, "XemDiem");
		} else if(o.equals(mniTimDeTai)) {
			card.show(pnChung, "TimDeTai");
		} else if(o.equals(mniThongTinGiaovien)) { // Giáo viên --------------------------
			card.show(pnChung, "ThongTinGiaoVien");
		} else if(o.equals(mniNhapDiem)) {
			card.show(pnChung, "NhapDiem");
		} else if(o.equals(mniXemDiemDaNhap)) {
			card.show(pnChung, "XemDiemDaNhap");
		} else if(o.equals(mniQuanLyLuanVan)) { // Giáo vụ khoa ---------------------------
			card.show(pnChung, "QuanLyLuanVan");
		} else if(o.equals(mniDanhSachSinhVienDangKyDeTai)) {
			card.show(pnChung, "BaoCaoDanhSach");
		} else if(o.equals(mniPhanCongHoiDong)) {
			card.show(pnChung, "PhanCongHoiDong");
		} else if (o.equals(mniPhanCongHoiDongChamDiem)) {
			card.show(pnChung, "PhanCongHoiDongChamDiem");
		} else if(o.equals(mniTraCuuThongTinHoiDong)) {
			card.show(pnChung, "TraCuuThongTinHoiDong");
		} else if(o.equals(mniSinhVienBaoVeLuanVanThanhCong)) {
			card.show(pnChung, "ThongKe");
		} else if(o.equals(mniSinhVienBaoVeLuanVanKhongThanhCong)) {
			card.show(pnChung, "ThongKe");
		} else if(o.equals(mniXepLoaiDiemSinhVien)) {
			card.show(pnChung, "ThongKe");
		} else if(o.equals(mniDoiMatKhau)) { // Hệ thống --------------------------------------
			card.show(pnChung, "DoiMatKhau");
		} else if(o.equals(mniDangXuat)) {
			card.show(pnChung, "DangXuat");
		}
		
		
	}

}
