package giaovien;

import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import dao.Database;
import dao.GiaoVienDao;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GiaoDien_XemDiemDaNhap {

	private JFrame frame;
	private JTable table;
	private JPanel pnChung;
	private GiaoVienDao giaoVienDao;
	
	private String maGiaoVien;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GiaoDien_XemDiemDaNhap window = new GiaoDien_XemDiemDaNhap("GV001");
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
	public GiaoDien_XemDiemDaNhap(String maGiaoVien) {
		this.maGiaoVien = maGiaoVien;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Database.getInstance().connec();
		giaoVienDao = new GiaoVienDao();
		frame = new JFrame();
		frame.setBounds(100, 100, 1280, 950);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pnChung = new JPanel();
		frame.getContentPane().add(pnChung, BorderLayout.CENTER);
		pnChung.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTieuDe = new JLabel("Xem điểm đã nhập");
		lblTieuDe.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		pnChung.add(lblTieuDe, BorderLayout.NORTH);
		
		JPanel pnCenter = new JPanel();
		pnChung.add(pnCenter, BorderLayout.CENTER);
		pnCenter.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Danh s\u00E1ch sinh vi\u00EAn b\u1EA3o v\u1EC7 lu\u1EADn v\u0103n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 1244, 858);
		pnCenter.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 29, 1224, 818);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "M\u00E3 sinh vi\u00EAn", "T\u00EAn sinh vi\u00EAn", "T\u00EAn lu\u1EADn v\u0103n", "\u0110i\u1EC3m", "Ghi ch\u00FA"
			}
		));
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		scrollPane.setViewportView(table);
		
		capNhat();
	}
	
	public JPanel getPanel() {
		return pnChung;
	}

	public void capNhat() {
		giaoVienDao.capNhatBang(table, maGiaoVien);
	}
}
