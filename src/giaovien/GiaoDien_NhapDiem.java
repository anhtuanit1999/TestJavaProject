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
	private JTextField txtTenDeTai;
	private JTextField txtLuanVan;
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
		lblDiemSo.setBounds(49, 105, 106, 19);
		pnThongTinSinhVien.add(lblDiemSo);
		
		txtDiemSo = new JTextField();
		txtDiemSo.setColumns(10);
		txtDiemSo.setBounds(176, 106, 416, 20);
		pnThongTinSinhVien.add(txtDiemSo);
		
		JLabel lblVongCham = new JLabel("Vòng chấm: ");
		lblVongCham.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblVongCham.setBounds(49, 163, 106, 19);
		pnThongTinSinhVien.add(lblVongCham);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Vòng 1", "Vòng 2"}));
		comboBox.setBounds(180, 164, 412, 20);
		pnThongTinSinhVien.add(comboBox);
		
		JLabel lblGhiChu = new JLabel("Ghi chú: ");
		lblGhiChu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGhiChu.setBounds(49, 226, 106, 19);
		pnThongTinSinhVien.add(lblGhiChu);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(176, 225, 416, 197);
		pnThongTinSinhVien.add(textArea);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Danh s\u00E1ch sinh vi\u00EAn b\u1EA3o v\u1EC7 lu\u1EADn v\u0103n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(676, 11, 578, 456);
		pnCenter.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 29, 558, 416);
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
		btnNhapDiem.setBounds(445, 478, 127, 44);
		pnCenter.add(btnNhapDiem);
		
		JButton btnCpNht = new JButton("Cập nhật");
		btnCpNht.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCpNht.setBounds(628, 478, 127, 44);
		pnCenter.add(btnCpNht);
		
		JButton btnXoaTrang = new JButton("Xóa Trắng");
		btnXoaTrang.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnXoaTrang.setBounds(808, 478, 127, 44);
		pnCenter.add(btnXoaTrang);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 533, 1244, 289);
		pnCenter.add(panel_1);
		panel_1.setBorder(new TitledBorder(null, "Th\u00F4ng tin \u0111\u1EC1 t\u00E0i", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setLayout(null);
		
		JLabel lblTenDeTai = new JLabel("Tên đề tài: ");
		lblTenDeTai.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTenDeTai.setBounds(38, 44, 106, 19);
		panel_1.add(lblTenDeTai);
		
		txtTenDeTai = new JTextField();
		txtTenDeTai.setEditable(false);
		txtTenDeTai.setColumns(10);
		txtTenDeTai.setBounds(204, 45, 988, 20);
		panel_1.add(txtTenDeTai);
		
		JLabel lblTenDeTai_1 = new JLabel("Tên luận văn: ");
		lblTenDeTai_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTenDeTai_1.setBounds(38, 102, 106, 19);
		panel_1.add(lblTenDeTai_1);
		
		txtLuanVan = new JTextField();
		txtLuanVan.setEditable(false);
		txtLuanVan.setColumns(10);
		txtLuanVan.setBounds(204, 103, 988, 20);
		panel_1.add(txtLuanVan);
		
		JLabel lblNoiDung = new JLabel("Nội dung: ");
		lblNoiDung.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNoiDung.setBounds(38, 157, 106, 19);
		panel_1.add(lblNoiDung);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(204, 156, 988, 22);
		panel_1.add(textArea_1);
	}
	
	public JPanel getPanel() {
		return pnChung;
	}
}
