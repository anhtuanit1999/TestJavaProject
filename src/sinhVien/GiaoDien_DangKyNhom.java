package sinhVien;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class GiaoDien_DangKyNhom {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField txtThongTinSinVienCanTim;
	private JTable table;
	private JPanel pnChung;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GiaoDien_DangKyNhom window = new GiaoDien_DangKyNhom();
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
	public GiaoDien_DangKyNhom() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
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
		panel.setBounds(0, 10, 1266, 362);
		pnCenter.add(panel);
		panel.setLayout(null);
		
		JLabel lblMSSV = new JLabel("MSSV: ");
		lblMSSV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMSSV.setBounds(49, 61, 116, 14);
		panel.add(lblMSSV);
		
		textField = new JTextField();
		textField.setText((String) null);
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(175, 58, 1081, 20);
		panel.add(textField);
		
		JLabel lblHoTen = new JLabel("Họ tên: ");
		lblHoTen.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHoTen.setBounds(49, 104, 116, 17);
		panel.add(lblHoTen);
		
		textField_1 = new JTextField();
		textField_1.setText((String) null);
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(175, 101, 1081, 20);
		panel.add(textField_1);
		
		JLabel lblKhoaTrucThuoc = new JLabel("Khoa trực thuộc: ");
		lblKhoaTrucThuoc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblKhoaTrucThuoc.setBounds(49, 148, 124, 17);
		panel.add(lblKhoaTrucThuoc);
		
		textField_2 = new JTextField();
		textField_2.setText((String) null);
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(175, 145, 1081, 20);
		panel.add(textField_2);
		
		JLabel lblNamVaoTruong = new JLabel("Năm vào trường: ");
		lblNamVaoTruong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNamVaoTruong.setBounds(49, 190, 128, 17);
		panel.add(lblNamVaoTruong);
		
		textField_3 = new JTextField();
		textField_3.setText("0");
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(175, 187, 1081, 20);
		panel.add(textField_3);
		
		JLabel lblNamTotNghiep = new JLabel("Năm tốt nghiệp: ");
		lblNamTotNghiep.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNamTotNghiep.setBounds(49, 229, 116, 17);
		panel.add(lblNamTotNghiep);
		
		textField_4 = new JTextField();
		textField_4.setText("0");
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(175, 226, 1081, 20);
		panel.add(textField_4);
		
		JButton btnNewButton = new JButton("Đăng ký nhóm");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(629, 292, 142, 44);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Danh s\u00E1ch sinh vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 382, 1246, 422);
		pnCenter.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 71, 1226, 341);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "H\u1ECD t\u00EAn", "Khoa tr\u1EF1c thu\u1ED9c", "N\u0103m v\u00E0o tr\u01B0\u1EDDng", "N\u0103m t\u1ED1t nghi\u1EC7p", "M\u00E3 nh\u00F3m"
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
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Mã sinh viên", "Tên sinh viên", "Số điện thoại", "Địa chỉ", "Khoa trực thuộc", "Năm vào trường", "Năm tốt nghiệp"}));
		comboBox.setBounds(812, 36, 281, 19);
		panel_1.add(comboBox);
		
		JButton btnTim = new JButton("Tìm");
		btnTim.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTim.setBounds(1103, 36, 85, 21);
		panel_1.add(btnTim);
	}
	public JPanel getPanel() {
		return pnChung;
	}
}
