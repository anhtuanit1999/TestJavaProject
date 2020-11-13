package giaovukhoa;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
import dao.LuanVanDao;
import entity.LuanVan;
import entity.SinhVien;

import javax.swing.JButton;
import javax.swing.JTextArea;

public class GiaoDien_QuanLyLuanVan implements MouseListener {

	private JFrame frame;
	private JPanel pnChung;
	private JTable table;
	private JTextField txtTenLuanVan;
	private DefaultComboBoxModel<String> comboModel;
	private LuanVanDao luanVanDao;
	private DefaultTableModel tableModel;
	private JTextField txtLinhVucNghienCuu;
	private JTextField txtNoiDungLuanVan;

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
//		deTaiDao = new DeTaiDao();
//		luanVanDao = new LuanVanDao();
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
		
		JLabel lblLinhVucNghienCuu = new JLabel("Lĩnh vực nghiên cứu:");
		lblLinhVucNghienCuu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLinhVucNghienCuu.setBounds(56, 88, 140, 20);
		pnThongTinLuanVan.add(lblLinhVucNghienCuu);
		
		JLabel lblNoiDung = new JLabel("Nội dung:");
		lblNoiDung.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNoiDung.setBounds(52, 177, 107, 20);
		pnThongTinLuanVan.add(lblNoiDung);
		
		JLabel lblTomTat = new JLabel("Tóm tắt:");
		lblTomTat.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTomTat.setBounds(56, 280, 103, 14);
		pnThongTinLuanVan.add(lblTomTat);
		
		comboModel = new DefaultComboBoxModel<String>();
		
		JTextArea txtaTomTat = new JTextArea();
		txtaTomTat.setBounds(217, 277, 955, 91);
		pnThongTinLuanVan.add(txtaTomTat);
		
		JLabel lblTenLuanVan = new JLabel("Tên luận văn:");
		lblTenLuanVan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTenLuanVan.setBounds(56, 42, 107, 20);
		pnThongTinLuanVan.add(lblTenLuanVan);
		
		txtTenLuanVan = new JTextField();
		txtTenLuanVan.setColumns(10);
		txtTenLuanVan.setBounds(217, 41, 955, 20);
		pnThongTinLuanVan.add(txtTenLuanVan);
		
		JLabel lblNoiDungLuanVan = new JLabel("Nội dung luận văn: ");
		lblNoiDungLuanVan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNoiDungLuanVan.setBounds(56, 135, 140, 20);
		pnThongTinLuanVan.add(lblNoiDungLuanVan);
		
		JTextArea txtaNoiDung = new JTextArea();
		txtaNoiDung.setBounds(217, 177, 955, 91);
		pnThongTinLuanVan.add(txtaNoiDung);
		
		txtLinhVucNghienCuu = new JTextField();
		txtLinhVucNghienCuu.setColumns(10);
		txtLinhVucNghienCuu.setBounds(217, 90, 955, 20);
		pnThongTinLuanVan.add(txtLinhVucNghienCuu);
		
		txtNoiDungLuanVan = new JTextField();
		txtNoiDungLuanVan.setColumns(10);
		txtNoiDungLuanVan.setBounds(217, 137, 955, 20);
		pnThongTinLuanVan.add(txtNoiDungLuanVan);
		
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
				"STT", "M\u00E3 lu\u1EADn v\u0103n", "T\u00EAn lu\u1EADn v\u0103n", "L\u0129nh v\u1EF1c nghi\u00EAn c\u1EE9u", "N\u1ED9i dung", "T\u00F3m t\u1EAFt"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblTieuDe = new JLabel("Quản lý luận văn");
		lblTieuDe.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		pnChung.add(lblTieuDe, BorderLayout.NORTH);
		
//		try {
//			updateComBoBoxLuanVan();
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			updateTableData();
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		table.addMouseListener(this);
	}
	public JPanel getPanel() {
		return pnChung;
	}
	private void updateTableData() throws ParseException {
		int count = 1;
//		List<LuanVan> list = luanVanDao.docTuBang();
//		for (LuanVan lv : list) {
//			String[] rowData = {
//					count++ + "", 
//					lv.getMaDeTai(), 
//					lv.getTenLuanVan(),
//					lv.getMaLuanVan(),
//					lv.getLinhVucNghienCuu(),
//					lv.getNoiDungLuanVan(),
//					lv.getTomTat()
//					};
//			tableModel.addRow(rowData);
//		}
//		table.setModel(tableModel);
	}
	private void updateComBoBoxLuanVan() throws ParseException {
//		List<DeTai> listDeTai = deTaiDao.docTuBang();
//		for (DeTai dt : listDeTai) {
//			comboModel.addElement(dt.getTenDeTai());
//		}
		
	}
	
	public void updatecomboBoxTenSinhVien(String maLuanVan) throws ParseException {
		List<SinhVien> listSinhVien = luanVanDao.timSinhVienLamLuanVanThemMa(maLuanVan);
		for (SinhVien sv : listSinhVien) {
			updatecomboBoxTenSinhVien(sv.getHoTen());
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object o = e.getSource();
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
