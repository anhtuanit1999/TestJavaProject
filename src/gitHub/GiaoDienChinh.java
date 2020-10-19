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

import sinhVien.GiaoDien_DangKyDeTai;
import sinhVien.GiaoDien_SinhVien;

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
		
		pnChung = new JPanel();
		card = new CardLayout();
		frame.getContentPane().add(pnChung, BorderLayout.CENTER);
		pnChung.setLayout(card);
		
		// Giao diện sinh viên
		GD_SV = new GiaoDien_SinhVien();
		pnChung.add(GD_SV.getPanel(), "ThongTinSinhVien");
		
		// Giao diện đăng ký đề tài
		GD_DKDT = new GiaoDien_DangKyDeTai();
		pnChung.add(GD_DKDT.getPanel(), "DangKyDeTai");
		
		mniThongTinSinhVien.addActionListener(this);
		mniDangKyDeTai.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(mniThongTinSinhVien)) {
			card.show(pnChung, "ThongTinSinhVien");
		} else if(o.equals(mniDangKyDeTai)) {
			card.show(pnChung, "DangKyDeTai");
		}
		
		
	}

}
