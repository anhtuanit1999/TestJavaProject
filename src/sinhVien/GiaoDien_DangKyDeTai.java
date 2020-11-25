package sinhVien;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.Database;
import dao.SinhVienDao;
import entity.LuanVan;
import entity.SinhVien;

import javax.swing.ListSelectionModel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

public class GiaoDien_DangKyDeTai implements KeyListener {

	private JFrame frame;
	private JTable table;
	private JTextField txtMaDeTaiDaDangKy;
	private JTextField txtTenDeTaiDaDangKy;
	private JTextField txtTenSinhVien_2;
	private JTextField txtTenSinhVien_1;
	private JPanel pnChung;
	private JTextField txtMaNhom;
	private JTextField txtTimKiem;
	private JTextField txtGiaoVienHuongDanDaDangKy;
	private JTextField txtKhoaTrucThuoc;
	private DefaultTableModel tableModel;
	private ArrayList<LuanVan> listLuanVan;
	private JTextField txtMaDeTai;
	private JTextField txtTenDeTai;
	private JTextField txtNamHoc;
	private JTextField txtGiaoVienHuongDan;
	private JTextField txtLinhVucNghienCuu;
	private JTextField txtNamHocDaDangKy;
	private JTextField txtMaSinhVien_1;
	private JTextField txtMaSinhVien_2;
	private JTextField txtMaHoiDong;
	private JTextField txtTenHoiDong;
	private JTextField txtGioBaoCao;
	private JTextField txtNgayBaoCao;
	private String maSinhVien;
	private SinhVienDao SinhVienDao;
	private JComboBox comboBoxTimKiem;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GiaoDien_DangKyDeTai window = new GiaoDien_DangKyDeTai("SV001");
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
	 */
	public GiaoDien_DangKyDeTai(String maSinhVien) throws SQLException {
		this.maSinhVien = maSinhVien;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 */
	private void initialize() throws SQLException {
		Database.getInstance().connec();
		SinhVienDao = new SinhVienDao();
		frame = new JFrame();
		frame.setBounds(10, 10, 1280, 950);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		pnChung = new JPanel();
		frame.getContentPane().add(pnChung, BorderLayout.CENTER);
		pnChung.setLayout(new BorderLayout(0, 0));

		JLabel lblTieuDe = new JLabel("Đăng Ký Đề Tài");
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDe.setFont(new Font("Tahoma", Font.PLAIN, 25));
		pnChung.add(lblTieuDe, BorderLayout.NORTH);

		JPanel pnCenter = new JPanel();
		pnCenter.setBorder(new TitledBorder(null, "\u0110\u1EC1 t\u00E0i", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnChung.add(pnCenter, BorderLayout.CENTER);
		pnCenter.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 310, 581, 458);
		pnCenter.add(scrollPane);

		table = new JTable();
		tableModel = new DefaultTableModel("STT, Mã Đề Tài, Tên Đề Tài, Lĩnh Vực Nghiên Cứu, Năm Học, Giáo Viên Hướng Dẫn, Số Nhóm Đăng Ký Tối Đa, Số Nhóm Đã Đăng Ký".split(","),0);
		table.setModel(tableModel);
		scrollPane.setViewportView(table);

		JPanel pnThongTinNhom = new JPanel();
		pnThongTinNhom.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng tin nh\u00F3m", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnThongTinNhom.setBounds(10, 61, 581, 201);
		pnCenter.add(pnThongTinNhom);
		pnThongTinNhom.setLayout(null);

		JLabel lblMSSV_1 = new JLabel("MSSV 1: ");
		lblMSSV_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMSSV_1.setBounds(367, 78, 93, 14);
		pnThongTinNhom.add(lblMSSV_1);

		txtTenSinhVien_1 = new JTextField();
		txtTenSinhVien_1.setEditable(false);
		txtTenSinhVien_1.setBounds(141, 78, 216, 20);
		pnThongTinNhom.add(txtTenSinhVien_1);
		txtTenSinhVien_1.setColumns(10);

		JLabel lblMaNhom = new JLabel("Mã Nhóm:");
		lblMaNhom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMaNhom.setBounds(24, 32, 116, 14);
		pnThongTinNhom.add(lblMaNhom);

		txtMaNhom = new JTextField();
		txtMaNhom.setEditable(false);
		txtMaNhom.setColumns(10);
		txtMaNhom.setBounds(142, 32, 415, 20);
		pnThongTinNhom.add(txtMaNhom);

		JLabel lblKhoaTrucThuoc = new JLabel("Khoa trực thuộc:");
		lblKhoaTrucThuoc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblKhoaTrucThuoc.setBounds(24, 163, 116, 20);
		pnThongTinNhom.add(lblKhoaTrucThuoc);

		txtKhoaTrucThuoc = new JTextField();
		txtKhoaTrucThuoc.setEditable(false);
		txtKhoaTrucThuoc.setColumns(10);
		txtKhoaTrucThuoc.setBounds(142, 166, 415, 20);
		pnThongTinNhom.add(txtKhoaTrucThuoc);

		txtTimKiem = new JTextField();
		txtTimKiem.setBounds(94, 272, 258, 25);
		pnCenter.add(txtTimKiem);
		txtTimKiem.setColumns(10);

		JButton btnTimKiem = new JButton("Tìm");
		btnTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTimKiem.setBounds(508, 272, 80, 28);
		pnCenter.add(btnTimKiem);

		comboBoxTimKiem = new JComboBox();
		comboBoxTimKiem.setModel(new DefaultComboBoxModel(new String[] {"Chọn tiêu chí...", "Mã đề tài", "Tên đề tài", "Giáo viên hướng dẫn"}));
		comboBoxTimKiem.setBounds(360, 272, 138, 25);
		pnCenter.add(comboBoxTimKiem);

		JLabel lblTenSinhVien_1 = new JLabel("Tên sinh viên 1: ");
		lblTenSinhVien_1.setBounds(24, 78, 116, 14);
		pnThongTinNhom.add(lblTenSinhVien_1);
		lblTenSinhVien_1.setFont(new Font("Tahoma", Font.PLAIN, 15));

		txtTenSinhVien_2 = new JTextField();
		txtTenSinhVien_2.setBounds(141, 122, 216, 20);
		pnThongTinNhom.add(txtTenSinhVien_2);
		txtTenSinhVien_2.setEditable(false);
		txtTenSinhVien_2.setColumns(10);

		txtMaSinhVien_1 = new JTextField();
		txtMaSinhVien_1.setEditable(false);
		txtMaSinhVien_1.setColumns(10);
		txtMaSinhVien_1.setBounds(432, 78, 125, 20);
		pnThongTinNhom.add(txtMaSinhVien_1);

		JLabel lblTenSinhVien_2 = new JLabel("Tên sinh viên 2: ");
		lblTenSinhVien_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTenSinhVien_2.setBounds(24, 122, 116, 14);
		pnThongTinNhom.add(lblTenSinhVien_2);

		JLabel lblMaSinhVien_2 = new JLabel("MSSV 2: ");
		lblMaSinhVien_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMaSinhVien_2.setBounds(367, 122, 93, 14);
		pnThongTinNhom.add(lblMaSinhVien_2);

		txtMaSinhVien_2 = new JTextField();
		txtMaSinhVien_2.setEditable(false);
		txtMaSinhVien_2.setColumns(10);
		txtMaSinhVien_2.setBounds(432, 122, 125, 20);
		pnThongTinNhom.add(txtMaSinhVien_2);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng tin lu\u1EADn v\u0103n \u0111\u00E3 \u0111\u0103ng k\u00FD", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(601, 64, 655, 164);
		pnCenter.add(panel);
		panel.setLayout(null);

		JLabel lblMaDeTaiDaDangKy = new JLabel("Mã đề tài: ");
		lblMaDeTaiDaDangKy.setBounds(59, 26, 93, 14);
		panel.add(lblMaDeTaiDaDangKy);
		lblMaDeTaiDaDangKy.setFont(new Font("Tahoma", Font.PLAIN, 15));

		txtMaDeTaiDaDangKy = new JTextField();
		txtMaDeTaiDaDangKy.setBounds(218, 26, 362, 20);
		panel.add(txtMaDeTaiDaDangKy);
		txtMaDeTaiDaDangKy.setEditable(false);
		txtMaDeTaiDaDangKy.setColumns(10);

		JLabel lblTenDeTaiDaDangKy = new JLabel("Tên đề tài: ");
		lblTenDeTaiDaDangKy.setBounds(59, 62, 93, 14);
		panel.add(lblTenDeTaiDaDangKy);
		lblTenDeTaiDaDangKy.setFont(new Font("Tahoma", Font.PLAIN, 15));

		txtTenDeTaiDaDangKy = new JTextField();
		txtTenDeTaiDaDangKy.setBounds(218, 62, 362, 20);
		panel.add(txtTenDeTaiDaDangKy);
		txtTenDeTaiDaDangKy.setEditable(false);
		txtTenDeTaiDaDangKy.setColumns(10);

		JLabel lblGiaoVienHuongDantxtMaDeTaiDaDangKy = new JLabel("Giáo viên hướng dẫn:");
		lblGiaoVienHuongDantxtMaDeTaiDaDangKy.setBounds(59, 128, 152, 21);
		panel.add(lblGiaoVienHuongDantxtMaDeTaiDaDangKy);
		lblGiaoVienHuongDantxtMaDeTaiDaDangKy.setFont(new Font("Tahoma", Font.PLAIN, 15));

		txtGiaoVienHuongDanDaDangKy = new JTextField();
		txtGiaoVienHuongDanDaDangKy.setBounds(219, 131, 362, 20);
		panel.add(txtGiaoVienHuongDanDaDangKy);
		txtGiaoVienHuongDanDaDangKy.setEditable(false);
		txtGiaoVienHuongDanDaDangKy.setColumns(10);

		JLabel lblNamHocDaDangKy = new JLabel("Năm học:");
		lblNamHocDaDangKy.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNamHocDaDangKy.setBounds(58, 92, 93, 24);
		panel.add(lblNamHocDaDangKy);

		txtNamHocDaDangKy = new JTextField();
		txtNamHocDaDangKy.setEditable(false);
		txtNamHocDaDangKy.setColumns(10);
		txtNamHocDaDangKy.setBounds(218, 97, 362, 20);
		panel.add(txtNamHocDaDangKy);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng tin lu\u1EADn v\u0103n \u0111ang l\u1EF1a chon ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(601, 429, 655, 339);
		pnCenter.add(panel_1);

		JLabel lblMaDeTai = new JLabel("Mã đề tài: ");
		lblMaDeTai.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMaDeTai.setBounds(59, 37, 93, 14);
		panel_1.add(lblMaDeTai);

		txtMaDeTai = new JTextField();
		txtMaDeTai.setEditable(false);
		txtMaDeTai.setColumns(10);
		txtMaDeTai.setBounds(218, 37, 362, 20);
		panel_1.add(txtMaDeTai);

		JLabel lblTenDeTai = new JLabel("Tên đề tài: ");
		lblTenDeTai.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTenDeTai.setBounds(59, 73, 93, 14);
		panel_1.add(lblTenDeTai);

		txtTenDeTai = new JTextField();
		txtTenDeTai.setEditable(false);
		txtTenDeTai.setColumns(10);
		txtTenDeTai.setBounds(218, 73, 362, 20);
		panel_1.add(txtTenDeTai);

		JLabel lblGiaoVienHuongDan = new JLabel("Giáo viên hướng dẫn:");
		lblGiaoVienHuongDan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGiaoVienHuongDan.setBounds(59, 189, 152, 21);
		panel_1.add(lblGiaoVienHuongDan);

		txtNamHoc = new JTextField();
		txtNamHoc.setEditable(false);
		txtNamHoc.setColumns(10);
		txtNamHoc.setBounds(219, 112, 362, 20);
		panel_1.add(txtNamHoc);

		JButton btnDangKy = new JButton("Đăng ký");
		btnDangKy.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDangKy.setBounds(218, 242, 164, 33);
		panel_1.add(btnDangKy);

		JLabel lblNamHoc = new JLabel("Năm học:");
		lblNamHoc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNamHoc.setBounds(59, 107, 93, 24);
		panel_1.add(lblNamHoc);

		txtGiaoVienHuongDan = new JTextField();
		txtGiaoVienHuongDan.setEditable(false);
		txtGiaoVienHuongDan.setColumns(10);
		txtGiaoVienHuongDan.setBounds(218, 192, 362, 20);
		panel_1.add(txtGiaoVienHuongDan);

		JLabel lblLinhVucNghienCuu = new JLabel("Lĩnh vực nghiên cứu:");
		lblLinhVucNghienCuu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLinhVucNghienCuu.setBounds(59, 146, 152, 24);
		panel_1.add(lblLinhVucNghienCuu);

		txtLinhVucNghienCuu = new JTextField();
		txtLinhVucNghienCuu.setEditable(false);
		txtLinhVucNghienCuu.setColumns(10);
		txtLinhVucNghienCuu.setBounds(218, 151, 362, 20);
		panel_1.add(txtLinhVucNghienCuu);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng Tin H\u1ED9i \u0110\u1ED3ng ch\u1EA5m b\u00E1o c\u00E1o", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(601, 248, 655, 171);
		pnCenter.add(panel_2);

		JLabel lblMaHoiDong = new JLabel("Mã hội đồng:");
		lblMaHoiDong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMaHoiDong.setBounds(59, 26, 93, 20);
		panel_2.add(lblMaHoiDong);

		txtMaHoiDong = new JTextField();
		txtMaHoiDong.setEditable(false);
		txtMaHoiDong.setColumns(10);
		txtMaHoiDong.setBounds(218, 26, 362, 20);
		panel_2.add(txtMaHoiDong);

		JLabel lblTenHoiDong = new JLabel("Tên hội đồng");
		lblTenHoiDong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTenHoiDong.setBounds(59, 62, 93, 20);
		panel_2.add(lblTenHoiDong);

		txtTenHoiDong = new JTextField();
		txtTenHoiDong.setEditable(false);
		txtTenHoiDong.setColumns(10);
		txtTenHoiDong.setBounds(218, 62, 362, 20);
		panel_2.add(txtTenHoiDong);

		JLabel lblGioBaoCao = new JLabel("Giờ báo cáo:");
		lblGioBaoCao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGioBaoCao.setBounds(59, 128, 152, 21);
		panel_2.add(lblGioBaoCao);

		txtGioBaoCao = new JTextField();
		txtGioBaoCao.setEditable(false);
		txtGioBaoCao.setColumns(10);
		txtGioBaoCao.setBounds(219, 131, 362, 20);
		panel_2.add(txtGioBaoCao);

		JLabel lblNgayBaoCao = new JLabel("Ngày báo cáo:");
		lblNgayBaoCao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNgayBaoCao.setBounds(58, 92, 106, 24);
		panel_2.add(lblNgayBaoCao);

		txtNgayBaoCao = new JTextField();
		txtNgayBaoCao.setEditable(false);
		txtNgayBaoCao.setColumns(10);
		txtNgayBaoCao.setBounds(218, 97, 362, 20);
		panel_2.add(txtNgayBaoCao);

		table.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				int row = table.getSelectedRow();
				txtMaDeTai.setText(table.getValueAt(row, 1).toString());
				txtTenDeTai.setText(table.getValueAt(row, 2).toString());
				txtGiaoVienHuongDan.setText(table.getValueAt(row, 5).toString());
				txtNamHoc.setText(table.getValueAt(row, 4).toString());
				txtLinhVucNghienCuu.setText(table.getValueAt(row, 3).toString());

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				eventTimKiem();
			}
		});

		txtTimKiem.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				if(txtTimKiem.getText().isEmpty()) {
					try {
						updateTableData();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

			@Override
			public void insertUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void changedUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		btnDangKy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String maNhom = txtMaNhom.getText();
				String maDeTai = txtMaDeTai.getText();
				try {
					Connection con = Database.getInstance().getConnection();
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery("SELECT MaNhom, MaLuanVan "
							+ "FROM DANHSACH_DANGKYLUANVAN "
							+ "WHERE MaNhom = '"+maNhom+"'");
					while(rs.next()) {
						if(rs.getString(2) != null) {
							JOptionPane.showMessageDialog(null, "Nhóm đã đăng ký luận văn trước đó. Nếu muốn sửa đổi, liên hệ Giáo Vụ Khoa.");
							return;
						}
					}
					if(table.getValueAt(table.getSelectedRow(), 7).equals(table.getValueAt(table.getSelectedRow(), 6))) {
						JOptionPane.showMessageDialog(null, "Luận văn đã đủ số nhóm đăng ký.");
						return;
					}
					stmt.executeUpdate("UPDATE DANHSACH_DANGKYLUANVAN SET MaLuanVan = '"+maDeTai+"' WHERE MaNhom = '"+maNhom+"'");
					JOptionPane.showMessageDialog(null, "Đăng Ký Thành Công!");
					updateTableData();
					loadDeTaiDaDangKy();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		});
		txtTimKiem.addKeyListener(this);
		comboBoxTimKiem.addKeyListener(this);

		capNhat();
	}
	
	public void capNhat() throws SQLException {
		updateTableData();
		loadThongTinNhom();
		loadDeTaiDaDangKy();
		updateThongTinHoiDong();
	}

	public JPanel getPanel() {
		return pnChung;
	}

	public void updateThongTinHoiDong() throws SQLException {
		Connection con = Database.getInstance().getConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT DANHSACH_DANGKYLUANVAN.MaHoiDong, TenHoiDong, CONVERT(VARCHAR(10),DANHSACH_DANGKYLUANVAN.NgayBaoCao,120) AS [NgayBaoCao], CONVERT(VARCHAR(5),DANHSACH_DANGKYLUANVAN.NgayBaoCao,114) AS [GioBaoCao]  "
				+ "FROM DANHSACH_DANGKYLUANVAN "
				+ "JOIN HOIDONG ON DANHSACH_DANGKYLUANVAN.MaHoiDong = HOIDONG.MaHoiDong "
				+ "WHERE MaNhom = '"+txtMaNhom.getText()+"'");
		while(rs.next()) {
			txtMaHoiDong.setText(rs.getString(1));
			txtTenHoiDong.setText(rs.getString(2));
			txtNgayBaoCao.setText(rs.getString(3));
			txtGioBaoCao.setText(rs.getString(4));
		}
	}

	public void loadThongTinNhom() throws SQLException {
		SinhVien sv1 = SinhVienDao.timSinhVien(maSinhVien);
		txtMaSinhVien_1.setText(sv1.getMaSinhVien());
		txtTenSinhVien_1.setText(sv1.getHoTen());
		txtKhoaTrucThuoc.setText(sv1.getKhoaTrucThuoc());
		txtMaNhom.setText(sv1.getMaNhom());
		SinhVien sv2 = SinhVienDao.timSinhVienCungNhom(txtMaNhom.getText().trim(), txtMaSinhVien_1.getText().trim());
		if(sv2 != null) {
			txtTenSinhVien_2.setText(sv2.getHoTen());
			txtMaSinhVien_2.setText(sv2.getMaSinhVien());
		}
	}

	public void loadDeTaiDaDangKy() throws SQLException {
		Connection con = Database.getInstance().getConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT DANHSACH_DANGKYLUANVAN.MaLuanVan, TenLuanVan, YEAR(NgayLap) AS NamHoc, HoTen "
				+ "FROM DANHSACH_DANGKYLUANVAN "
				+ "JOIN LUANVAN ON DANHSACH_DANGKYLUANVAN.MaLuanVan = LUANVAN.MaLuanVan "
				+ "JOIN GIAOVIEN ON LUANVAN.MaGiaoVien = GIAOVIEN.MaGiaoVien "
				+ "WHERE MaNhom = '"+txtMaNhom.getText()+"'");
		while(rs.next()) {
			int namHoc_temp = rs.getInt("NamHoc") + 1;
			String namHoc = rs.getInt("NamHoc") + " - " + namHoc_temp;
			txtMaDeTaiDaDangKy.setText(rs.getString("MaLuanVan"));
			txtTenDeTaiDaDangKy.setText(rs.getString("TenLuanVan")); 
			txtNamHocDaDangKy.setText(namHoc);
			txtGiaoVienHuongDanDaDangKy.setText(rs.getString("HoTen"));
		}
	}
	public void updateTableData() throws SQLException {
		String linhVucNghienCuu = txtKhoaTrucThuoc.getText();
		Connection con = Database.getInstance().getConnection();
		Statement stmt = con.createStatement();
		tableModel.setRowCount(0);
		int namHienTai = LocalDate.now().getYear();
		int namHienTai_temp = namHienTai +1;
		String namHoc = namHienTai + " - " + namHienTai_temp;
		ResultSet rs = stmt.executeQuery("SELECT MaLuanVan, TenLuanVan, LinhVucNghienCuu, YEAR(NgayLap), MoTa, GIAOVIEN.HoTen, SoNhomThamGiaToiDa "
				+ "FROM LUANVAN "
				+ "JOIN GIAOVIEN ON LUANVAN.MaGiaoVien = GIAOVIEN.MaGiaoVien "
				+ "WHERE YEAR(NgayLap) = "+namHienTai+"");
		int i =1;
		try {
			while(rs.next()) {
				Statement stmt_2 = con.createStatement();
				ResultSet rs_2 = stmt_2.executeQuery("SELECT COUNT(MaLuanVan) AS SoNhomDangKy "
						+ "FROM DANHSACH_DANGKYLUANVAN "
						+ "WHERE MaLuanVan = '"+rs.getString("MaLuanVan")+"'");
				rs_2.next();
				Object[] rowData = {
						i,
						rs.getString("MaLuanVan"),
						rs.getString("TenLuanVan"),
						linhVucNghienCuu,
						namHoc,
						rs.getString("HoTen"),
						rs.getString("SoNhomThamGiaToiDa"),
						rs_2.getString("SoNhomDangKy")
				};
				i++;
				tableModel.addRow(rowData);
			}
			table.setModel(tableModel);
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		};
	}
	
	public void eventTimKiem() {
		tableModel.setRowCount(0);
		String tieuChi = comboBoxTimKiem.getSelectedItem().toString();
		String noiDungTimKiem = txtTimKiem.getText();
		try {
			if(tieuChi.equalsIgnoreCase("Chọn tiêu chí...")) {
				JOptionPane.showMessageDialog(null, "Vui lòng chọn tiêu chí!");
				try {
					updateTableData();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}else if(tieuChi.equalsIgnoreCase("Mã đề tài")){
				timKiemLuanVan(noiDungTimKiem, "", "");
			}else if(tieuChi.equalsIgnoreCase("Tên đề tài")) {
				timKiemLuanVan("", noiDungTimKiem, "");
			}else if(tieuChi.equalsIgnoreCase("Giáo viên hướng dẫn")) {
				timKiemLuanVan("", "", noiDungTimKiem);
			}
			if(tableModel.getRowCount() == 0) {
				JOptionPane.showMessageDialog(null, "Không tìm thấy!");
				try {
					updateTableData();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void timKiemLuanVan(String maLuanVan, String tenLuanVan, String giaoVien) throws SQLException {
		Connection con = Database.getInstance().getConnection();
		Statement stmt = con.createStatement();
		int i = 1;
		String linhVucNghienCuu = txtKhoaTrucThuoc.getText();
		int namHienTai = LocalDate.now().getYear();
		int namHienTai_temp = namHienTai +1;
		String namHoc = namHienTai + " - " + namHienTai_temp;
		ResultSet rs = stmt.executeQuery("SELECT MaLuanVan, TenLuanVan, LinhVucNghienCuu, YEAR(NgayLap), MoTa, GIAOVIEN.HoTen, SoNhomThamGiaToiDa "
				+ "FROM LUANVAN "
				+ "JOIN GIAOVIEN ON LUANVAN.MaGiaoVien = GIAOVIEN.MaGiaoVien "
				+ "WHERE LinhVucNghienCuu = N'"+linhVucNghienCuu+"' AND MaLuanVan LIKE '%"+maLuanVan+"%' AND TenLuanVan LIKE N'%"+tenLuanVan+"%' AND GIAOVIEN.HoTen LIKE N'%"+giaoVien+"%' AND YEAR(NgayLap) = "+namHienTai+"");
		try {
			while(rs.next()) {
				Statement stmt_2 = con.createStatement();
				ResultSet rs_2 = stmt_2.executeQuery("SELECT COUNT(MaLuanVan) AS SoNhomDangKy "
						+ "FROM DANHSACH_DANGKYLUANVAN "
						+ "WHERE MaLuanVan = '"+rs.getString("MaLuanVan")+"'");
				rs_2.next();
				Object[] rowData = {
						i,
						rs.getString("MaLuanVan"),
						rs.getString("TenLuanVan"),
						linhVucNghienCuu,
						namHoc,
						rs.getString("HoTen"),
						rs.getString("SoNhomThamGiaToiDa"),
						rs_2.getString("SoNhomDangKy")
				};
				i++;
				tableModel.addRow(rowData);
			}
			table.setModel(tableModel);
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		};
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			eventTimKiem();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
