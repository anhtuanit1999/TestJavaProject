package giaovukhoa;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

public class GiaoDien_BaoCao {

	private JFrame frame;
	private JTable table;
	private JPanel pnChung;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GiaoDien_BaoCao window = new GiaoDien_BaoCao();
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
	public GiaoDien_BaoCao() {
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
		
		pnChung = new JPanel();
		frame.getContentPane().add(pnChung, BorderLayout.CENTER);
		pnChung.setLayout(new BorderLayout(0, 0));
		
		JPanel pnCenter = new JPanel();
		pnChung.add(pnCenter, BorderLayout.CENTER);
		pnCenter.setLayout(null);
		
		JPanel pnBaoCao = new JPanel();
		pnBaoCao.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Danh s\u00E1ch sinh vi\u00EAn \u0111\u0103ng k\u00FD \u0111\u1EC1 t\u00E0i", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnBaoCao.setBounds(10, 30, 1244, 839);
		pnCenter.add(pnBaoCao);
		pnBaoCao.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 155, 1224, 673);
		pnBaoCao.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "M\u00E3 sinh vi\u00EAn", "T\u00EAn sinh vi\u00EAn", "N\u0103m h\u1ECDc"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblTenLuanVan = new JLabel("Tên luận văn:");
		lblTenLuanVan.setBounds(481, 40, 102, 20);
		pnBaoCao.add(lblTenLuanVan);
		lblTenLuanVan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JComboBox comboBoxTenDeTai = new JComboBox();
		comboBoxTenDeTai.setBounds(593, 41, 602, 22);
		pnBaoCao.add(comboBoxTenDeTai);
		
		JComboBox comboBoxNamHoc = new JComboBox();
		comboBoxNamHoc.setModel(new DefaultComboBoxModel(new String[] {"2019 ", "2020", "2021"}));
		comboBoxNamHoc.setBounds(179, 41, 292, 22);
		pnBaoCao.add(comboBoxNamHoc);
		
		JLabel lblNamHoc = new JLabel("Năm học: ");
		lblNamHoc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNamHoc.setBounds(67, 40, 102, 20);
		pnBaoCao.add(lblNamHoc);
		
		JButton btnNewButton = new JButton("Xem Danh Sách");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(400, 90, 151, 44);
		pnBaoCao.add(btnNewButton);
		
		JButton btnInDanhSch = new JButton("Xuất Danh Sách");
		btnInDanhSch.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnInDanhSch.setBounds(671, 90, 151, 44);
		pnBaoCao.add(btnInDanhSch);
		
		JLabel lblTieuDe = new JLabel("Báo Cáo");
		lblTieuDe.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		pnChung.add(lblTieuDe, BorderLayout.NORTH);
	}
	public JPanel getPanel() {
		return pnChung;
	}
}
