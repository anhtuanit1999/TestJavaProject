package giaovien;

import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
	private JComboBox comboBoxNamHoc;

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
	 * @throws SQLException 
	 */
	public GiaoDien_XemDiemDaNhap(String maGiaoVien) throws SQLException {
		this.maGiaoVien = maGiaoVien;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 */
	private void initialize() throws SQLException {
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
		scrollPane.setBounds(10, 48, 1224, 799);
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
		
		comboBoxNamHoc = new JComboBox();
		comboBoxNamHoc.setBounds(1082, 17, 152, 21);
		panel.add(comboBoxNamHoc);
		
		capNhat();
		
		comboBoxNamHoc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);
				if(comboBoxNamHoc.getSelectedIndex() == 0) {
					return;
				}
				String namHoc = comboBoxNamHoc.getSelectedItem().toString().substring(0, 4); 
				giaoVienDao.capNhatBang(table, maGiaoVien, namHoc);
			}
		});
	}
	
	public JPanel getPanel() {
		return pnChung;
	}
	
	public void updateComboBoxNamHoc() throws SQLException {
		comboBoxNamHoc.setModel(new DefaultComboBoxModel<>());
		comboBoxNamHoc.addItem("Chọn năm học...");
		Connection con = Database.getInstance().getConnection();
		Statement statement = con.createStatement();
		ResultSet res = statement.executeQuery("SELECT DISTINCT YEAR(NgayBaoCao) AS NamHoc FROM HOIDONG ORDER BY YEAR(NgayBaoCao) ASC");
		while(res.next()) {
			int namHoc_temp = res.getInt(1) + 1;
			comboBoxNamHoc.addItem(res.getString(1) + " - " +namHoc_temp);
		}
	}

	public void capNhat() throws SQLException {
		updateComboBoxNamHoc();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
	}
}
