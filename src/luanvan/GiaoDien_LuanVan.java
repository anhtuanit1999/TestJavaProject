package luanvan;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSlider;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

public class GiaoDien_LuanVan {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GiaoDien_LuanVan window = new GiaoDien_LuanVan();
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
	public GiaoDien_LuanVan() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1280, 950);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel pnChung = new JPanel();
		frame.getContentPane().add(pnChung, BorderLayout.SOUTH);
		pnChung.setLayout(null);
		
		JLabel lblTieuDe = new JLabel("Giao Diện Luận Văn");
		lblTieuDe.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblTieuDe, BorderLayout.NORTH);
		
		JPanel pnCenter = new JPanel();
		frame.getContentPane().add(pnCenter, BorderLayout.CENTER);
		pnCenter.setLayout(null);
		
		JPanel pnThongTinLuanVan = new JPanel();
		pnThongTinLuanVan.setBorder(new TitledBorder(null, "Th\u00F4ng Tin Lu\u1EADn V\u0103n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnThongTinLuanVan.setBounds(10, 11, 656, 456);
		pnCenter.add(pnThongTinLuanVan);
		pnThongTinLuanVan.setLayout(null);
		
		JLabel lblMaDeTai = new JLabel("Mã Đề Tài:");
		lblMaDeTai.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMaDeTai.setBounds(56, 40, 107, 14);
		pnThongTinLuanVan.add(lblMaDeTai);
		
		JLabel lblMaLuanVan = new JLabel("Mã Luận Văn:");
		lblMaLuanVan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMaLuanVan.setBounds(56, 80, 107, 14);
		pnThongTinLuanVan.add(lblMaLuanVan);
		
		JLabel lblMaSinhVien = new JLabel("Mã Sinh Viên:");
		lblMaSinhVien.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMaSinhVien.setBounds(56, 120, 107, 14);
		pnThongTinLuanVan.add(lblMaSinhVien);
		
		JLabel lblTenLuanVan = new JLabel("Tên Luận Văn:");
		lblTenLuanVan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTenLuanVan.setBounds(56, 160, 107, 14);
		pnThongTinLuanVan.add(lblTenLuanVan);
		
		JLabel lblLinhVucNghienCuu = new JLabel("Lĩnh Vực Nghiên Cứu:");
		lblLinhVucNghienCuu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLinhVucNghienCuu.setBounds(56, 200, 140, 14);
		pnThongTinLuanVan.add(lblLinhVucNghienCuu);
		
		JLabel lblNoiDung = new JLabel("Nội Dung:");
		lblNoiDung.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNoiDung.setBounds(56, 240, 107, 14);
		pnThongTinLuanVan.add(lblNoiDung);
		
		JLabel lblTomTat = new JLabel("Tóm Tắt:");
		lblTomTat.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTomTat.setBounds(56, 280, 103, 14);
		pnThongTinLuanVan.add(lblTomTat);
		
		textField = new JTextField();
		textField.setBounds(217, 39, 387, 20);
		pnThongTinLuanVan.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(217, 79, 387, 20);
		pnThongTinLuanVan.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(217, 119, 387, 20);
		pnThongTinLuanVan.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(217, 159, 387, 20);
		pnThongTinLuanVan.add(textField_3);
		textField_3.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(217, 239, 387, 20);
		pnThongTinLuanVan.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(217, 279, 387, 116);
		pnThongTinLuanVan.add(textField_6);
		textField_6.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Khoa học kỹ thuật và công nghệ", "Khoa học nông nghiệp", "Khoa học Tự nhiên", "Khoa học xã hội", "Khoa học Y - Dược"}));
		comboBox.setBounds(217, 199, 387, 20);
		pnThongTinLuanVan.add(comboBox);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Danh S\u00E1ch Lu\u1EADn V\u0103n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
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
				"M\u00E3 \u0110\u1EC1 T\u00E0i", "M\u00E3 Sinh Vi\u00EAn", "M\u00E3 Lu\u1EADn V\u0103n", "T\u00EAn Lu\u1EADn V\u0103n", "L\u0129nh V\u1EF1c Nghi\u00EAn C\u1EE9u"
			}
		));
		table.getColumnModel().getColumn(3).setPreferredWidth(78);
		table.getColumnModel().getColumn(4).setPreferredWidth(115);
		scrollPane.setViewportView(table);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setBounds(267, 488, 127, 44);
		pnCenter.add(btnThem);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setBounds(526, 488, 127, 44);
		pnCenter.add(btnSua);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setBounds(788, 488, 127, 44);
		pnCenter.add(btnXoa);
	}
}
