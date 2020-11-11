package giaovien;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

public class GiaoDien_NhapDiem {

	private JFrame frame;
	private JTextField txtTenSinhVien;
	private JTextField txtDiemSo;
	private JTable table;
	private JPanel pnChung;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GiaoDien_NhapDiem window = new GiaoDien_NhapDiem();
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
	public GiaoDien_NhapDiem() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1280, 950);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pnChung = new JPanel();
		frame.getContentPane().add(pnChung, BorderLayout.CENTER);
		pnChung.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTieuDe = new JLabel("Nhập điểm");
		lblTieuDe.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		pnChung.add(lblTieuDe, BorderLayout.NORTH);
		
		JPanel pnCenter = new JPanel();
		pnChung.add(pnCenter, BorderLayout.CENTER);
		pnCenter.setLayout(null);
		
		JPanel pnThongTinSinhVien = new JPanel();
		pnThongTinSinhVien.setBorder(new TitledBorder(null, "Th\u00F4ng tin sinh vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnThongTinSinhVien.setBounds(10, 11, 656, 456);
		pnCenter.add(pnThongTinSinhVien);
		pnThongTinSinhVien.setLayout(null);
		
		JLabel lblTenSinhVien = new JLabel("Tên sinh viên: ");
		lblTenSinhVien.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTenSinhVien.setBounds(49, 50, 106, 19);
		pnThongTinSinhVien.add(lblTenSinhVien);
		
		txtTenSinhVien = new JTextField();
		txtTenSinhVien.setEditable(false);
		txtTenSinhVien.setBounds(176, 51, 416, 20);
		pnThongTinSinhVien.add(txtTenSinhVien);
		txtTenSinhVien.setColumns(10);
		
		JLabel lblDiemSo = new JLabel("Điểm số: ");
		lblDiemSo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDiemSo.setBounds(49, 90, 106, 19);
		pnThongTinSinhVien.add(lblDiemSo);
		
		txtDiemSo = new JTextField();
		txtDiemSo.setColumns(10);
		txtDiemSo.setBounds(176, 91, 416, 20);
		pnThongTinSinhVien.add(txtDiemSo);
		
		JLabel lblVongCham = new JLabel("Vòng chấm: ");
		lblVongCham.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblVongCham.setBounds(49, 133, 106, 19);
		pnThongTinSinhVien.add(lblVongCham);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Vòng 1", "Vòng 2"}));
		comboBox.setBounds(180, 134, 412, 20);
		pnThongTinSinhVien.add(comboBox);
		
		JLabel lblGhiChu = new JLabel("Ghi chú: ");
		lblGhiChu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGhiChu.setBounds(49, 226, 106, 19);
		pnThongTinSinhVien.add(lblGhiChu);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(176, 225, 416, 197);
		pnThongTinSinhVien.add(textArea);
		
		JLabel lblHocKy = new JLabel("Học kỳ: ");
		lblHocKy.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHocKy.setBounds(49, 176, 106, 19);
		pnThongTinSinhVien.add(lblHocKy);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"2019 - 2020", "2020 - 2021", "2021 - 2022"}));
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_1.setBounds(180, 177, 412, 20);
		pnThongTinSinhVien.add(comboBox_1);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Danh s\u00E1ch sinh vi\u00EAn b\u1EA3o v\u1EC7 lu\u1EADn v\u0103n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(676, 11, 578, 858);
		pnCenter.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 29, 558, 818);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "T\u00EAn sinh vi\u00EAn", "Lu\u1EADn v\u0103n", "\u0110i\u1EC3m s\u1ED1"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnNhapDiem = new JButton("Nhập điểm");
		btnNhapDiem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNhapDiem.setBounds(87, 478, 127, 44);
		pnCenter.add(btnNhapDiem);
		
		JButton btnCpNht = new JButton("Cập nhật");
		btnCpNht.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCpNht.setBounds(270, 478, 127, 44);
		pnCenter.add(btnCpNht);
		
		JButton btnXoaTrang = new JButton("Xóa Trắng");
		btnXoaTrang.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnXoaTrang.setBounds(450, 478, 127, 44);
		pnCenter.add(btnXoaTrang);
	}
	
	public JPanel getPanel() {
		return pnChung;
	}
}
