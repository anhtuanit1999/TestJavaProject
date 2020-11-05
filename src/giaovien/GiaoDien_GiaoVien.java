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
	private JPanel pnChung;

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
		pnCenter.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Th\u00F4ng tin gi\u00E1o vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnChung.add(pnCenter, BorderLayout.CENTER);
		pnCenter.setLayout(null);
		
		JLabel lblMaGiaoVien = new JLabel("Mã giáo viên: ");
		lblMaGiaoVien.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMaGiaoVien.setBounds(70, 245, 116, 17);
		pnCenter.add(lblMaGiaoVien);
		
		txtMSSV = new JTextField();
		txtMSSV.setEditable(false);
		txtMSSV.setBounds(196, 242, 419, 20);
		pnCenter.add(txtMSSV);
		txtMSSV.setColumns(10);
		
		JLabel lblHoTen = new JLabel("Họ tên: ");
		lblHoTen.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHoTen.setBounds(70, 298, 116, 17);
		pnCenter.add(lblHoTen);
		
		txtHoTen = new JTextField();
		txtHoTen.setEditable(false);
		txtHoTen.setBounds(196, 295, 419, 20);
		pnCenter.add(txtHoTen);
		txtHoTen.setColumns(10);
		
		JLabel lblChucDanh = new JLabel("Chức danh: ");
		lblChucDanh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblChucDanh.setBounds(70, 352, 116, 17);
		pnCenter.add(lblChucDanh);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setEditable(false);
		txtDiaChi.setBounds(196, 352, 419, 20);
		pnCenter.add(txtDiaChi);
		txtDiaChi.setColumns(10);
		
		JLabel lblDonViCongTac = new JLabel("Đơn vị công tác: ");
		lblDonViCongTac.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDonViCongTac.setBounds(70, 423, 116, 17);
		pnCenter.add(lblDonViCongTac);
		
		txtNgaySinh = new JTextField();
		txtNgaySinh.setEditable(false);
		txtNgaySinh.setBounds(196, 420, 419, 20);
		pnCenter.add(txtNgaySinh);
		txtNgaySinh.setColumns(10);
		
		JLabel lblKhoaCongTac = new JLabel("Khoa công tác: ");
		lblKhoaCongTac.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblKhoaCongTac.setBounds(70, 489, 116, 17);
		pnCenter.add(lblKhoaCongTac);
		
		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setEditable(false);
		txtSoDienThoai.setBounds(196, 486, 419, 20);
		pnCenter.add(txtSoDienThoai);
		txtSoDienThoai.setColumns(10);
		
		JLabel lblLinhVucCongTac = new JLabel("Lĩnh vực công tác: ");
		lblLinhVucCongTac.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLinhVucCongTac.setBounds(70, 550, 125, 17);
		pnCenter.add(lblLinhVucCongTac);
		
		txtKhoaTrucThuoc = new JTextField();
		txtKhoaTrucThuoc.setEditable(false);
		txtKhoaTrucThuoc.setBounds(196, 547, 419, 20);
		pnCenter.add(txtKhoaTrucThuoc);
		txtKhoaTrucThuoc.setColumns(10);
		
		lblIcon = new JLabel("");
		lblIcon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblIcon.setIcon(new ImageIcon(getClass().getResource("/avatar.png")));
		lblIcon.setBounds(822, 239, 245, 328);
		pnCenter.add(lblIcon);
	}
	
	public JPanel getPanel() {
		return pnChung;
	}
}
