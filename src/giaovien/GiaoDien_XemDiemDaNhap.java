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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GiaoDien_XemDiemDaNhap {

	private JFrame frame;
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
					GiaoDien_XemDiemDaNhap window = new GiaoDien_XemDiemDaNhap();
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
	public GiaoDien_XemDiemDaNhap() {
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
		
		JLabel lblTieuDe = new JLabel("Xem điểm đã nhập");
		lblTieuDe.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		pnChung.add(lblTieuDe, BorderLayout.NORTH);
		
		JPanel pnCenter = new JPanel();
		pnChung.add(pnCenter, BorderLayout.CENTER);
		pnCenter.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Danh s\u00E1ch sinh vi\u00EAn b\u1EA3o v\u1EC7 lu\u1EADn v\u0103n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 1244, 456);
		pnCenter.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 29, 1224, 416);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "T\u00EAn sinh vi\u00EAn", "\u0110i\u1EC3m", "H\u1ECDc k\u1EF3"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		scrollPane.setViewportView(table);
		
		JButton btnCpNht = new JButton("Cập nhật");
		btnCpNht.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCpNht.setBounds(594, 478, 127, 44);
		pnCenter.add(btnCpNht);
		
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
