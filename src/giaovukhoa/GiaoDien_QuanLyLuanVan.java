package giaovukhoa;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.text.ParseException;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JSlider;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.Database;
import dao.DeTaiDao;
import entity.DeTai;
import entity.SinhVien;

import javax.swing.JButton;
import javax.swing.JTextArea;

public class GiaoDien_QuanLyLuanVan {

	private JFrame frame;
	private JTextField txtNoiDung;
	private JPanel pnChung;
	private JTable table;
	private JTextField textField;
	private JTextField txtMaLuanVan;
	private JTextField txtTenLuanVan;
	private JTextField txtMaSinhVien;
	private DeTaiDao deTaiDao;
	private DefaultComboBoxModel<String> comboModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GiaoDien_QuanLyLuanVan window = new GiaoDien_QuanLyLuanVan();
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
	public GiaoDien_QuanLyLuanVan() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Database.getInstance().connec();
		deTaiDao = new DeTaiDao();
		frame = new JFrame();
		frame.setBounds(100, 100, 1280, 950);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		pnChung = new JPanel();
		frame.getContentPane().add(pnChung, BorderLayout.CENTER);
		pnChung.setLayout(new BorderLayout(0, 0));
		
		JPanel pnCenter = new JPanel();
		pnCenter.setLayout(null);
		pnChung.add(pnCenter, BorderLayout.CENTER);
		
		JPanel pnThongTinLuanVan = new JPanel();
		pnThongTinLuanVan.setLayout(null);
		pnThongTinLuanVan.setBorder(new TitledBorder(null, "Th\u00F4ng Tin Lu\u1EADn V\u0103n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnThongTinLuanVan.setBounds(10, 11, 1244, 379);
		pnCenter.add(pnThongTinLuanVan);
		
		JLabel lblTenDeTai = new JLabel("Tên đề tài:");
		lblTenDeTai.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTenDeTai.setBounds(56, 40, 107, 14);
		pnThongTinLuanVan.add(lblTenDeTai);
		
		JLabel lblLinhVucNghienCuu = new JLabel("Lĩnh vực nghiên cứu:");
		lblLinhVucNghienCuu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLinhVucNghienCuu.setBounds(56, 200, 140, 20);
		pnThongTinLuanVan.add(lblLinhVucNghienCuu);
		
		JLabel lblNoiDung = new JLabel("Nội dung:");
		lblNoiDung.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNoiDung.setBounds(56, 240, 107, 20);
		pnThongTinLuanVan.add(lblNoiDung);
		
		JLabel lblTomTat = new JLabel("Tóm tắt:");
		lblTomTat.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTomTat.setBounds(56, 280, 103, 14);
		pnThongTinLuanVan.add(lblTomTat);
		
		txtNoiDung = new JTextField();
		txtNoiDung.setColumns(10);
		txtNoiDung.setBounds(217, 239, 955, 20);
		pnThongTinLuanVan.add(txtNoiDung);
		
		comboModel = new DefaultComboBoxModel<String>();
		JComboBox comboBoxLinhVucNghienCuu = new JComboBox(comboModel);
		comboBoxLinhVucNghienCuu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBoxLinhVucNghienCuu.setBounds(217, 199, 955, 25);
		pnThongTinLuanVan.add(comboBoxLinhVucNghienCuu);
		
		JTextArea txtaTomTat = new JTextArea();
		txtaTomTat.setBounds(217, 277, 955, 91);
		pnThongTinLuanVan.add(txtaTomTat);
		
		JLabel lblMTi = new JLabel("Mã đề tài:");
		lblMTi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMTi.setBounds(623, 41, 151, 14);
		pnThongTinLuanVan.add(lblMTi);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(784, 40, 388, 20);
		pnThongTinLuanVan.add(textField);
		
		JComboBox comboBoxTenDeTai = new JComboBox();
		comboBoxTenDeTai.setBounds(217, 39, 388, 20);
		pnThongTinLuanVan.add(comboBoxTenDeTai);
		
		JLabel lblTenLuanVan = new JLabel("Tên luận văn:");
		lblTenLuanVan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTenLuanVan.setBounds(56, 77, 107, 20);
		pnThongTinLuanVan.add(lblTenLuanVan);
		
		JLabel lblMaLuanVan = new JLabel("Mã luận văn:");
		lblMaLuanVan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMaLuanVan.setBounds(623, 78, 151, 14);
		pnThongTinLuanVan.add(lblMaLuanVan);
		
		txtMaLuanVan = new JTextField();
		txtMaLuanVan.setEditable(false);
		txtMaLuanVan.setColumns(10);
		txtMaLuanVan.setBounds(784, 77, 388, 20);
		pnThongTinLuanVan.add(txtMaLuanVan);
		
		txtTenLuanVan = new JTextField();
		txtTenLuanVan.setColumns(10);
		txtTenLuanVan.setBounds(217, 76, 388, 20);
		pnThongTinLuanVan.add(txtTenLuanVan);
		
		JLabel lblTenSinhVien = new JLabel("Tên sinh viên:");
		lblTenSinhVien.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTenSinhVien.setBounds(56, 115, 107, 20);
		pnThongTinLuanVan.add(lblTenSinhVien);
		
		JLabel lblMaSinhVien = new JLabel("Mã sinh viên:");
		lblMaSinhVien.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMaSinhVien.setBounds(623, 116, 151, 14);
		pnThongTinLuanVan.add(lblMaSinhVien);
		
		txtMaSinhVien = new JTextField();
		txtMaSinhVien.setEditable(false);
		txtMaSinhVien.setColumns(10);
		txtMaSinhVien.setBounds(784, 115, 388, 20);
		pnThongTinLuanVan.add(txtMaSinhVien);
		
		JComboBox comboBoxTenSinhVien = new JComboBox();
		comboBoxTenSinhVien.setBounds(217, 117, 388, 20);
		pnThongTinLuanVan.add(comboBoxTenSinhVien);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setBounds(261, 401, 127, 44);
		pnCenter.add(btnThem);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setBounds(520, 401, 127, 44);
		pnCenter.add(btnSua);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setBounds(782, 401, 127, 44);
		pnCenter.add(btnXoa);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(null, "Danh s\u00E1ch lu\u1EADn v\u0103n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 454, 1244, 414);
		pnCenter.add(panel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 22, 1224, 392);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "T\u00EAn \u0111\u1EC1 t\u00E0i", "M\u00E3 \u0111\u1EC1 t\u00E0i", "T\u00EAn lu\u1EADn v\u0103n", "M\u00E3 lu\u1EADn v\u0103n", "T\u00EAn sinh vi\u00EAn", "L\u0129nh v\u1EF1c nghi\u00EAn c\u1EE9u", "N\u1ED9i dung", "T\u00F3m t\u1EAFt"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblTieuDe = new JLabel("Quản lý luận văn");
		lblTieuDe.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		pnChung.add(lblTieuDe, BorderLayout.NORTH);
		
		try {
			updateComBoBox();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public JPanel getPanel() {
		return pnChung;
	}
	private void updateComBoBox() throws ParseException {
		List<DeTai> listDeTai = deTaiDao.docTuBang();
		for (DeTai dt : listDeTai) {
			comboModel.addElement(dt.getTenDeTai());
		}
		
	}
}
