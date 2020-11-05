package giaovukhoa;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;

public class GiaoDien_QuanLyDeTai {

	private JFrame frame;
	private JTextField txtTenDeTai;
	private JTextField txtMaDeTai;
	private JTable table;
	private JPanel pnChung;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GiaoDien_QuanLyDeTai window = new GiaoDien_QuanLyDeTai();
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
	public GiaoDien_QuanLyDeTai() {
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
		
		JLabel lblTieuDe = new JLabel("Quản Lý Đề Tài");
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDe.setFont(new Font("Tahoma", Font.PLAIN, 25));
		pnChung.add(lblTieuDe, BorderLayout.NORTH);
		
		JPanel pnCenter = new JPanel();
		pnChung.add(pnCenter, BorderLayout.CENTER);
		pnCenter.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Th\u00F4ng tin lu\u1EADn v\u0103n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(8, 20, 1245, 410);
		pnCenter.add(panel);
		panel.setLayout(null);
		
		JLabel lblTenDeTai = new JLabel("Tên đề tài: ");
		lblTenDeTai.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTenDeTai.setBounds(45, 60, 95, 19);
		panel.add(lblTenDeTai);
		
		txtTenDeTai = new JTextField();
		txtTenDeTai.setBounds(191, 61, 986, 20);
		panel.add(txtTenDeTai);
		txtTenDeTai.setColumns(10);
		
		JLabel lblMaDeTai = new JLabel("Mã đề tài: ");
		lblMaDeTai.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMaDeTai.setBounds(45, 105, 95, 19);
		panel.add(lblMaDeTai);
		
		txtMaDeTai = new JTextField();
		txtMaDeTai.setEditable(false);
		txtMaDeTai.setColumns(10);
		txtMaDeTai.setBounds(191, 106, 986, 20);
		panel.add(txtMaDeTai);
		
		JLabel lblGioVinRa = new JLabel("Giáo viên ra đề tài: ");
		lblGioVinRa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGioVinRa.setBounds(45, 152, 136, 19);
		panel.add(lblGioVinRa);
		
		JComboBox comboBoxGiaoVienRaDeTai = new JComboBox();
		comboBoxGiaoVienRaDeTai.setBounds(191, 153, 986, 20);
		panel.add(comboBoxGiaoVienRaDeTai);
		
		JLabel lblSoNhomThamGia = new JLabel("Số nhóm tham gia: ");
		lblSoNhomThamGia.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSoNhomThamGia.setBounds(45, 199, 136, 19);
		panel.add(lblSoNhomThamGia);
		
		JComboBox comboBoxSoNhomThamGia = new JComboBox();
		comboBoxSoNhomThamGia.setModel(new DefaultComboBoxModel(new String[] {"2", "3", "4", "5"}));
		comboBoxSoNhomThamGia.setBounds(191, 200, 422, 20);
		panel.add(comboBoxSoNhomThamGia);
		
		JLabel lblNamHoc = new JLabel("Năm học: ");
		lblNamHoc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNamHoc.setBounds(623, 197, 136, 19);
		panel.add(lblNamHoc);
		
		JComboBox comboBoxNamHoc = new JComboBox();
		comboBoxNamHoc.setModel(new DefaultComboBoxModel(new String[] {"2019 - 2020", "2020 - 2021", "2021 - 2022"}));
		comboBoxNamHoc.setBounds(769, 198, 408, 20);
		panel.add(comboBoxNamHoc);
		
		JLabel lblMoTaDeTai = new JLabel("Mô tả đề tài: ");
		lblMoTaDeTai.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMoTaDeTai.setBounds(45, 248, 95, 19);
		panel.add(lblMoTaDeTai);
		
		JTextArea txtaMoTaDeTai = new JTextArea();
		txtaMoTaDeTai.setBounds(191, 247, 986, 152);
		panel.add(txtaMoTaDeTai);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Danh s\u00E1ch \u0111\u1EC1 t\u00E0i", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 506, 1243, 363);
		pnCenter.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 35, 1223, 317);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "M\u00E3 \u0111\u1EC1 t\u00E0i", "T\u00EAn \u0111\u1EC1 t\u00E0i", "Gi\u00E1o vi\u00EAn ra \u0111\u1EC1 t\u00E0i", "S\u1ED1 nh\u00F3m tham gia", "N\u0103m h\u1ECDc", "M\u00F4 t\u1EA3 \u0111\u1EC1 t\u00E0i"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThem.setBounds(346, 451, 127, 44);
		pnCenter.add(btnThem);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnXoa.setBounds(564, 451, 127, 44);
		pnCenter.add(btnXoa);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSua.setBounds(792, 451, 127, 44);
		pnCenter.add(btnSua);
	}
	public JPanel getPanel() {
		return pnChung;
	}
}
