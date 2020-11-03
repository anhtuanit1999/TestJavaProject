package giaovien;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class GiaoDien_GiaoVien {

	private JFrame frame;
	private JTextField txtMSSV;
	private JTextField txtHoTen;
	private JTextField txtDiaChi;
	private JTextField txtNgaySinh;
	private JTextField txtSoDienThoai;
	private JTextField txtKhoaTrucThuoc;
	private JLabel lblIcon;
	private JTextField txtTenDeTai;
	private JTextField txtSinhVienThucHien1;
	private JPanel pnChung;
	private JTextField txtSinhVienThucHien2;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GiaoDien_GiaoVien window = new GiaoDien_GiaoVien();
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
	public GiaoDien_GiaoVien() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(10, 10, 1280, 950);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pnChung = new JPanel();
		frame.getContentPane().add(pnChung, BorderLayout.CENTER);
		pnChung.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTieuDe = new JLabel("Giao Diện Giáo Viên");
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDe.setFont(new Font("Tahoma", Font.PLAIN, 25));
		pnChung.add(lblTieuDe, BorderLayout.NORTH);
		
		JPanel pnCenter = new JPanel();
		pnCenter.setBorder(new TitledBorder(null, "Th\u00F4ng tin sinh vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnChung.add(pnCenter, BorderLayout.CENTER);
		pnCenter.setLayout(null);
		
		JLabel lblMaGiaoVien = new JLabel("Mã giáo viên: ");
		lblMaGiaoVien.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMaGiaoVien.setBounds(62, 75, 116, 17);
		pnCenter.add(lblMaGiaoVien);
		
		txtMSSV = new JTextField();
		txtMSSV.setEditable(false);
		txtMSSV.setBounds(188, 72, 419, 20);
		pnCenter.add(txtMSSV);
		txtMSSV.setColumns(10);
		
		JLabel lblHoTen = new JLabel("Họ tên: ");
		lblHoTen.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHoTen.setBounds(62, 128, 116, 17);
		pnCenter.add(lblHoTen);
		
		txtHoTen = new JTextField();
		txtHoTen.setEditable(false);
		txtHoTen.setBounds(188, 125, 419, 20);
		pnCenter.add(txtHoTen);
		txtHoTen.setColumns(10);
		
		JLabel lblChucDanh = new JLabel("Chức danh: ");
		lblChucDanh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblChucDanh.setBounds(62, 182, 116, 17);
		pnCenter.add(lblChucDanh);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setEditable(false);
		txtDiaChi.setBounds(188, 182, 419, 20);
		pnCenter.add(txtDiaChi);
		txtDiaChi.setColumns(10);
		
		JLabel lblDonViCongTac = new JLabel("Đơn vị công tác: ");
		lblDonViCongTac.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDonViCongTac.setBounds(62, 253, 116, 17);
		pnCenter.add(lblDonViCongTac);
		
		txtNgaySinh = new JTextField();
		txtNgaySinh.setEditable(false);
		txtNgaySinh.setBounds(188, 250, 419, 20);
		pnCenter.add(txtNgaySinh);
		txtNgaySinh.setColumns(10);
		
		JLabel lblKhoaCongTac = new JLabel("Khoa công tác: ");
		lblKhoaCongTac.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblKhoaCongTac.setBounds(62, 319, 116, 17);
		pnCenter.add(lblKhoaCongTac);
		
		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setEditable(false);
		txtSoDienThoai.setBounds(188, 316, 419, 20);
		pnCenter.add(txtSoDienThoai);
		txtSoDienThoai.setColumns(10);
		
		JLabel lblLinhVucCongTac = new JLabel("Lĩnh vực công tác: ");
		lblLinhVucCongTac.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLinhVucCongTac.setBounds(62, 380, 125, 17);
		pnCenter.add(lblLinhVucCongTac);
		
		txtKhoaTrucThuoc = new JTextField();
		txtKhoaTrucThuoc.setEditable(false);
		txtKhoaTrucThuoc.setBounds(188, 377, 419, 20);
		pnCenter.add(txtKhoaTrucThuoc);
		txtKhoaTrucThuoc.setColumns(10);
		
		lblIcon = new JLabel("");
		lblIcon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblIcon.setIcon(new ImageIcon(getClass().getResource("/avatar.png")));
		lblIcon.setBounds(820, 27, 245, 328);
		pnCenter.add(lblIcon);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u0110\u1EC1 t\u00E0i \u0111\u00E3 \u0111ang ch\u1EA5m g\u1EA7n nh\u1EA5t", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 487, 635, 382);
		pnCenter.add(panel);
		panel.setLayout(null);
		
		JLabel lblTenDeTai = new JLabel("Tên đề tài: ");
		lblTenDeTai.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTenDeTai.setBounds(30, 51, 116, 19);
		panel.add(lblTenDeTai);
		
		txtTenDeTai = new JTextField();
		txtTenDeTai.setEditable(false);
		txtTenDeTai.setBounds(169, 50, 419, 20);
		panel.add(txtTenDeTai);
		txtTenDeTai.setColumns(10);
		
		JLabel lblSinhVienThucHien1 = new JLabel("Sinh viên thực hiện: ");
		lblSinhVienThucHien1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSinhVienThucHien1.setBounds(30, 101, 132, 20);
		panel.add(lblSinhVienThucHien1);
		
		txtSinhVienThucHien1 = new JTextField();
		txtSinhVienThucHien1.setEditable(false);
		txtSinhVienThucHien1.setBounds(169, 100, 419, 20);
		panel.add(txtSinhVienThucHien1);
		txtSinhVienThucHien1.setColumns(10);
		
		JLabel lblTomTat = new JLabel("Tóm Tắt: ");
		lblTomTat.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTomTat.setBounds(30, 240, 116, 19);
		panel.add(lblTomTat);
		
		JTextArea txtaTomTat = new JTextArea();
		txtaTomTat.setEditable(false);
		txtaTomTat.setBounds(169, 239, 419, 99);
		panel.add(txtaTomTat);
		
		JLabel lblSinhVienThucHien2 = new JLabel("Sinh viên thực hiện: ");
		lblSinhVienThucHien2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSinhVienThucHien2.setBounds(30, 152, 132, 17);
		panel.add(lblSinhVienThucHien2);
		
		txtSinhVienThucHien2 = new JTextField();
		txtSinhVienThucHien2.setEditable(false);
		txtSinhVienThucHien2.setColumns(10);
		txtSinhVienThucHien2.setBounds(169, 149, 419, 20);
		panel.add(txtSinhVienThucHien2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "H\u1ED9i \u0111\u1ED3ng b\u1EA3o v\u1EC7 lu\u1EADn v\u0103n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(655, 487, 599, 382);
		pnCenter.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 31, 567, 340);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"T\u00EAn sinh vi\u00EAn", "Lu\u1EADn v\u0103n"
			}
		));
		scrollPane.setViewportView(table);
	}
	
	public JPanel getPanel() {
		return pnChung;
	}
}
