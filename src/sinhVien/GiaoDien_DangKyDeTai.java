package sinhVien;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.Database;

import javax.swing.ListSelectionModel;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class GiaoDien_DangKyDeTai implements MouseListener {

	private JFrame frame;
	private JTable table;
	private JTextField txtMaDeTai;
	private JTextField txtTenDeTai;
	private JTextField txtTenSinhVien;
	private JTextField txtMSSV;
	private JPanel pnChung;
	private DefaultTableModel tabelModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GiaoDien_DangKyDeTai window = new GiaoDien_DangKyDeTai();
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
	public GiaoDien_DangKyDeTai() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Database.getInstance().connec();
//		deTaiDao = new DeTaiDao();
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
		scrollPane.setBounds(10, 41, 614, 828);
		pnCenter.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "M\u00E3 \u0111\u1EC1 t\u00E0i", "T\u00EAn \u0111\u1EC1 t\u00E0i", "S\u1ED1 nh\u00F3m \u0111\u0103ng k\u00FD", "N\u0103m h\u1ECDc"
			}
		));
		scrollPane.setViewportView(table);
		
		JPanel pnDeTai = new JPanel();
		pnDeTai.setBorder(new TitledBorder(null, "Ch\u1ECDn \u0111\u1EC1 t\u00E0i", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnDeTai.setBounds(634, 41, 620, 469);
		pnCenter.add(pnDeTai);
		pnDeTai.setLayout(null);
		
		JLabel lblMaDeTai = new JLabel("Mã đề tài: ");
		lblMaDeTai.setBounds(32, 157, 93, 14);
		pnDeTai.add(lblMaDeTai);
		
		txtMaDeTai = new JTextField();
		txtMaDeTai.setEditable(false);
		txtMaDeTai.setBounds(135, 154, 450, 20);
		pnDeTai.add(txtMaDeTai);
		txtMaDeTai.setColumns(10);
		
		JLabel lblTenDeTai = new JLabel("Tên đề tài: ");
		lblTenDeTai.setBounds(32, 211, 93, 14);
		pnDeTai.add(lblTenDeTai);
		
		txtTenDeTai = new JTextField();
		txtTenDeTai.setEditable(false);
		txtTenDeTai.setBounds(135, 208, 450, 20);
		pnDeTai.add(txtTenDeTai);
		txtTenDeTai.setColumns(10);
		
		JButton btnDangKy = new JButton("Đăng ký");
		btnDangKy.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnDangKy.setBounds(251, 303, 164, 33);
		pnDeTai.add(btnDangKy);
		
		JLabel lblTenSinhVien = new JLabel("Tên sinh viên: ");
		lblTenSinhVien.setBounds(32, 112, 93, 14);
		pnDeTai.add(lblTenSinhVien);
		
		txtTenSinhVien = new JTextField();
		txtTenSinhVien.setEditable(false);
		txtTenSinhVien.setBounds(135, 109, 450, 20);
		pnDeTai.add(txtTenSinhVien);
		txtTenSinhVien.setColumns(10);
		
		JLabel lblMSSV = new JLabel("MSSV: ");
		lblMSSV.setBounds(32, 62, 93, 14);
		pnDeTai.add(lblMSSV);
		
		txtMSSV = new JTextField();
		txtMSSV.setEditable(false);
		txtMSSV.setBounds(135, 59, 450, 20);
		pnDeTai.add(txtMSSV);
		txtMSSV.setColumns(10);
		
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
//		List<DeTai> list = deTaiDao.docTuBang();
//		for (DeTai dt : list) {
//			String[] rowData = {
//					count++ + "", 
//					dt.getMaDeTai(), 
//					dt.getTenDeTai(),
//					dt.getSoNhomThamGia() + "",
//					dt.getNamHoc()
//					
//					};
//			System.out.println(dt);
//			tabelModel.addRow(rowData);
//		}
//		table.setModel(tabelModel);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		txtMaDeTai.setText(table.getValueAt(row, 1).toString());
		txtTenDeTai.setText(table.getValueAt(row, 2).toString());
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
