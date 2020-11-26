package giaovukhoa;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.transaction.Transactional.TxType;

import dao.Database;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class GiaoDien_XoaNhom {

	private JFrame frame;
	private JTextField txtTimKiem;
	private JTable tableDanhSachNhom;
	private JTable tableDanhSachSinhVien;
	private JTextField txtNgayLap;
	private JTextField txtMaNhom;
	private DefaultTableModel modelDanhSachSinhVien;
	private JPanel pnChung;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GiaoDien_XoaNhom window = new GiaoDien_XoaNhom();
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
	public GiaoDien_XoaNhom() throws SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 */
	private void initialize() throws SQLException {
		Database.getInstance().connec();
		frame = new JFrame();
		frame.setBounds(100, 100, 1280, 950);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		pnChung = new JPanel();
		frame.getContentPane().add(pnChung, BorderLayout.CENTER);
		pnChung.setLayout(new BorderLayout(0, 0));

		JLabel lblTieuDe = new JLabel("Xoá Nhóm");
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDe.setFont(new Font("Tahoma", Font.PLAIN, 25));
		pnChung.add(lblTieuDe, BorderLayout.NORTH);

		JPanel pnCenter = new JPanel();
		pnChung.add(pnCenter, BorderLayout.CENTER);
		pnCenter.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Danh S\u00E1ch Nh\u00F3m", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(20, 24, 570, 636);
		pnCenter.add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 57, 550, 569);
		panel.add(scrollPane);

		tableDanhSachNhom = new JTable();
		scrollPane.setViewportView(tableDanhSachNhom);

		JComboBox comboBoxDanhSachNhom = new JComboBox();
		comboBoxDanhSachNhom.addItem("Nhóm chưa phân công");
		comboBoxDanhSachNhom.addItem("Nhóm đã phân công");
		comboBoxDanhSachNhom.setBounds(419, 26, 141, 21);
		panel.add(comboBoxDanhSachNhom);

		JButton btnTimKiem = new JButton("Tìm");
		btnTimKiem.setBounds(351, 26, 58, 21);
		panel.add(btnTimKiem);

		JComboBox comboBoxTimKiem = new JComboBox();
		comboBoxTimKiem.addItem("Mã nhóm");
		comboBoxTimKiem.addItem("Ngày lập");
		comboBoxTimKiem.setBounds(231, 26, 110, 21);
		panel.add(comboBoxTimKiem);

		txtTimKiem = new JTextField();
		txtTimKiem.setBounds(10, 28, 211, 19);
		panel.add(txtTimKiem);
		txtTimKiem.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Chi Ti\u1EBFt Nh\u00F3m \u0110ang Ch\u1ECDn", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(592, 282, 664, 378);
		pnCenter.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblMaHoiDong = new JLabel("Mã Nhóm:");
		lblMaHoiDong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMaHoiDong.setBounds(59, 55, 93, 19);
		panel_1.add(lblMaHoiDong);

		JLabel lblNgyLpHi = new JLabel("Ngày Lập Nhóm:");
		lblNgyLpHi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNgyLpHi.setBounds(59, 105, 143, 19);
		panel_1.add(lblNgyLpHi);

		txtNgayLap = new JTextField();
		txtNgayLap.setEditable(false);
		txtNgayLap.setBounds(207, 107, 397, 19);
		panel_1.add(txtNgayLap);
		txtNgayLap.setColumns(10);

		txtMaNhom = new JTextField();
		txtMaNhom.setEditable(false);
		txtMaNhom.setColumns(10);
		txtMaNhom.setBounds(207, 57, 397, 19);
		panel_1.add(txtMaNhom);

		JButton btnXoa = new JButton("Xoá Nhóm");
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnXoa.setBounds(207, 160, 113, 30);
		panel_1.add(btnXoa);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Sinh Vi\u00EAn Trong Nh\u00F3m", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1_1.setBounds(591, 24, 665, 248);
		pnCenter.add(panel_1_1);
		panel_1_1.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(324, 20, 2, 2);
		panel_1_1.add(scrollPane_1);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 20, 645, 207);
		panel_1_1.add(scrollPane_2);

		modelDanhSachSinhVien = new DefaultTableModel("STT, Mã Sinh Viên, Họ Tên, Ngày Sinh, Khoa Trực Thuộc, Mã Nhóm".split(","), 0);
		tableDanhSachSinhVien = new JTable(modelDanhSachSinhVien);

		scrollPane_2.setViewportView(tableDanhSachSinhVien);

		comboBoxDanhSachNhom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comboBoxTimKiem.setModel(new DefaultComboBoxModel<>());
				txtMaNhom.setText(null);
				txtNgayLap.setText(null);
				try {
					if(comboBoxDanhSachNhom.getSelectedIndex() == 0) {
						comboBoxTimKiem.addItem("Mã nhóm");
						comboBoxTimKiem.addItem("Ngày lập");
						loadTableDanhSachNhomChuaPhanCong();
					}else {
						comboBoxTimKiem.addItem("Mã nhóm");
						comboBoxTimKiem.addItem("Mã luận văn");
						comboBoxTimKiem.addItem("Mã hội đồng");
						comboBoxTimKiem.addItem("Ngày lập");
						comboBoxTimKiem.addItem("Ngày báo cáo");
						loadTableDanhSachNhomDaPhanCong();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		tableDanhSachNhom.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent arg0) {
				try {
				if(comboBoxDanhSachNhom.getSelectedIndex() == 0) {
					txtMaNhom.setText(tableDanhSachNhom.getValueAt(tableDanhSachNhom.getSelectedRow(), 1).toString());
					txtNgayLap.setText(tableDanhSachNhom.getValueAt(tableDanhSachNhom.getSelectedRow(), 2).toString());
					loadTableDanhSachSinhVien();
				}else if (comboBoxDanhSachNhom.getSelectedIndex() == 1) {
					txtMaNhom.setText(tableDanhSachNhom.getValueAt(tableDanhSachNhom.getSelectedRow(), 1).toString());
					txtNgayLap.setText(tableDanhSachNhom.getValueAt(tableDanhSachNhom.getSelectedRow(), 4).toString());
					loadTableDanhSachSinhVien();
				}
				}catch (SQLException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				
			}
		});

		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int ret = JOptionPane.showConfirmDialog(null, "Bạn có muốn xoá nhóm này?", "Xoá", JOptionPane.YES_NO_OPTION);
				if(ret == JOptionPane.YES_OPTION) {
					Connection con = Database.getInstance().getConnection();
					if(comboBoxDanhSachNhom.getSelectedIndex() == 1) {
						JOptionPane.showMessageDialog(null, "Không được xoá nhóm đã được phân công hội đồng");
						return;
					}else {
						try {
							for(int i = 0; i < 2; i++) {
								Statement st = con.createStatement();
								st.executeUpdate("UPDATE SINHVIEN SET MaNhom = NULL WHERE MaSinhVien = '"+tableDanhSachSinhVien.getValueAt(i, 1).toString()+"'");
							}
							Statement st = con.createStatement();
							st.executeUpdate("DELETE FROM DANHSACH_DANGKYLUANVAN WHERE MaNhom = '"+txtMaNhom.getText()+"'");
							loadTableDanhSachNhomChuaPhanCong();
							modelDanhSachSinhVien.setRowCount(0);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
				}
			}
		});

		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String noiDungTimKiem = txtTimKiem.getText();
				try {
					if(comboBoxDanhSachNhom.getSelectedIndex() == 0) {
						if(comboBoxTimKiem.getSelectedIndex() == 0) {
							timKiemNhomChuaPhanCong(noiDungTimKiem, "");
						}else if (comboBoxTimKiem.getSelectedIndex() == 1) {
							timKiemNhomChuaPhanCong("", noiDungTimKiem);
						}
					}else if(comboBoxDanhSachNhom.getSelectedIndex() == 1) {
						if(comboBoxTimKiem.getSelectedItem().toString().equalsIgnoreCase("Mã nhóm")) {
							timKiemNhomDaPhanCong(noiDungTimKiem, "","","","");
						}else if(comboBoxTimKiem.getSelectedItem().toString().equalsIgnoreCase("Mã luận văn")) {
							timKiemNhomDaPhanCong("", noiDungTimKiem,"","","");
						}else if(comboBoxTimKiem.getSelectedItem().toString().equalsIgnoreCase("Mã hội đồng")) {
							timKiemNhomDaPhanCong("","",noiDungTimKiem,"","");
						}else if(comboBoxTimKiem.getSelectedItem().toString().equalsIgnoreCase("Ngày lập")) {
							timKiemNhomDaPhanCong("","","",noiDungTimKiem,"");
						}else if(comboBoxTimKiem.getSelectedItem().toString().equalsIgnoreCase("Ngày báo cáo")) {
							timKiemNhomDaPhanCong("", "","","",noiDungTimKiem);
						}
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		txtTimKiem.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				try {
				if(txtTimKiem.getText().trim().length() == 0 && comboBoxDanhSachNhom.getSelectedIndex() == 0) {
					loadTableDanhSachNhomChuaPhanCong();
				}else if(txtTimKiem.getText().trim().length() == 0 && comboBoxDanhSachNhom.getSelectedIndex() == 1) {
					loadTableDanhSachNhomDaPhanCong();
				}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			@Override
			public void insertUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
			}

			@Override
			public void changedUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
			}
		});

		capNhat();
	}
	
	public void capNhat() throws SQLException {
		loadTableDanhSachNhomChuaPhanCong();
	}

	public void loadTableDanhSachNhomChuaPhanCong() throws SQLException {
		Connection con = Database.getInstance().getConnection();
		tableDanhSachNhom.setModel(new DefaultTableModel());
		DefaultTableModel model = new DefaultTableModel("STT, Mã Nhóm, Ngày Lập".split(","), 0);
		int i = 1;
		PreparedStatement st = con.prepareStatement("SELECT MaNhom, NgayLap FROM DANHSACH_DANGKYLUANVAN WHERE MaHoiDong IS NULL");
		ResultSet res = st.executeQuery();
		while(res.next()) {
			Object[] rowData = {
					i,
					res.getString(1),
					res.getString(2),
			};
			model.addRow(rowData);
			i++;
		}
		tableDanhSachNhom.setModel(model);
	}

	public void loadTableDanhSachNhomDaPhanCong() throws SQLException {
		Connection con = Database.getInstance().getConnection();
		tableDanhSachNhom.setModel(new DefaultTableModel());
		DefaultTableModel model = new DefaultTableModel("STT, Mã Nhóm, Mã Luận Văn, Mã Hội Đồng, Ngày Lập, Ngày Báo Cáo".split(","), 0);
		int i = 1;
		PreparedStatement st = con.prepareStatement("SELECT * FROM DANHSACH_DANGKYLUANVAN WHERE MaHoiDong IS NOT NULL");
		ResultSet res = st.executeQuery();
		while(res.next()) {
			Object[] rowData = {
					i,
					res.getString(1),
					res.getString(2),
					res.getString(3),
					res.getString(4),
					res.getString(5),
			};
			model.addRow(rowData);
			i++;
		}
		tableDanhSachNhom.setModel(model);
	}

	public void loadTableDanhSachSinhVien() throws SQLException {
		modelDanhSachSinhVien.setRowCount(0);
		Connection con = Database.getInstance().getConnection();
		int i = 1;
		Statement st = con.createStatement();
		ResultSet res = st.executeQuery("SELECT MaSinhVien, HoTen, NgaySinh, KhoaTrucThuoc, MaNhom FROM SINHVIEN WHERE MaNhom = '"+txtMaNhom.getText()+"'");
		while(res.next()) {
			Object[] rowData = {
					i,
					res.getString(1),
					res.getString(2),
					res.getString(3),
					res.getString(4),
					res.getString(5),
			};
			modelDanhSachSinhVien.addRow(rowData);
			i++;
		}
	}

	public void timKiemNhomChuaPhanCong(String maNhom, String NgayLap) throws SQLException {
		Connection con = Database.getInstance().getConnection();
		Statement statement = con.createStatement();
		DefaultTableModel model = (DefaultTableModel) tableDanhSachNhom.getModel();
		model.setRowCount(0);
		int i = 1;
		ResultSet res = statement.executeQuery("SELECT MaNhom, NgayLap "
				+ "FROM DANHSACH_DANGKYLUANVAN "
				+ "WHERE MaNhom LIKE '%"+maNhom+"%' AND NgayLap LIKE '%"+NgayLap+"%' AND MaHoiDong IS NULL");
		while(res.next()) {
			Object[] rowData = {
					i,
					res.getString(1),
					res.getString(2),
			};
			model.addRow(rowData);
			i++;
		}
		if(model.getRowCount() == 0) {
			JOptionPane.showMessageDialog(null, "Không tìm thấy!");
			loadTableDanhSachNhomChuaPhanCong();
			return;
		}
		tableDanhSachNhom.setModel(model);
	}
	
	public void timKiemNhomDaPhanCong(String maNhom, String maLuanVan, String maHoiDong, String NgayLap, String ngayBaoCao) throws SQLException {
		Connection con = Database.getInstance().getConnection();
		Statement statement = con.createStatement();
		DefaultTableModel model = (DefaultTableModel) tableDanhSachNhom.getModel();
		model.setRowCount(0);
		int i = 1;
		ResultSet res = statement.executeQuery("SELECT MaNhom, MaLuanVan,MaHoiDong, NgayLap, CONVERT(VARCHAR(10),NgayBaoCao,120) AS [NgayBaoCao]"
				+ "FROM DANHSACH_DANGKYLUANVAN "
				+ "WHERE MaNhom LIKE '%"+maNhom+"%' AND MaLuanVan LIKE '%"+maLuanVan+"%' AND MaHoiDong LIKE '%"+maHoiDong+"%' AND NgayLap LIKE '%"+NgayLap+"%' AND cast ([NgayBaoCao] as date) LIKE '%"+ngayBaoCao+"%'");
		while(res.next()) {
			Object[] rowData = {
					i,
					res.getString(1),
					res.getString(2),
					res.getString(3),
					res.getString(4),
					res.getString(5)
			};
			model.addRow(rowData);
			i++;
		}
		if(model.getRowCount() == 0) {
			try {
			JOptionPane.showMessageDialog(null, "Không tìm thấy!");
				loadTableDanhSachNhomDaPhanCong();
				return;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		tableDanhSachNhom.setModel(model);
	}
	
	public JPanel getPanel() {
		return pnChung;
	}
}

