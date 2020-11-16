package giaovukhoa;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JTextField;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.UIManager;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JDateChooserCellEditor;
import com.toedter.components.JLocaleChooser;

import dao.Database;
import dao.HoiDongDao;
import entity.HoiDong;

import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class GiaoDien_PhanCongHoiDongChamDiem {

	private JFrame frame;
	private JPanel pnChung;
	private JTextField txtMaHoiDong;
	private JTextField txtTenHoiDong;
	private JTextField txtTimKiemHoiDong;
	private JTextField txtSoLuong;
	private JTable tableDanhSachNhom;
	private JTable tableDanhSachNhomDuocChon;
	private JTable tableDanhSachHoiDong;
	private DefaultTableModel modelDanhSachHoiDong;
	private ArrayList<HoiDong> listHoiDong;
	private DefaultTableModel modelDanhSachNhomDuocChon;

	/**
	 * Launch the application.
	 */

	class JDateChooserEditor extends DefaultCellEditor
	{
		public JDateChooserEditor(JCheckBox checkBox)
		{
			super(checkBox);

		}

		JDateChooser date;
		public Component getTableCellEditorComponent(JTable table, Object value,
				boolean isSelected, int row, int column) 
		{

			date = new JDateChooser();
			date.setDateFormatString("yyyy-MM-dd");
			return date;
		}

		public Object getCellEditorValue() 
		{
			return new String(((JTextField)date.getDateEditor().getUiComponent()).getText());
		}

		public boolean stopCellEditing()
		{
			return super.stopCellEditing();
		}

		protected void fireEditingStopped() {
			super.fireEditingStopped();
		}
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GiaoDien_PhanCongHoiDongChamDiem window = new GiaoDien_PhanCongHoiDongChamDiem();
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
	public GiaoDien_PhanCongHoiDongChamDiem() throws SQLException {
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
		pnChung.setLayout(null);

		JLabel lblPhanCongHoiDongChamDiem = new JLabel("Phân công hội đồng chấm điểm");
		lblPhanCongHoiDongChamDiem.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhanCongHoiDongChamDiem.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblPhanCongHoiDongChamDiem.setBounds(0, 0, 1262, 31);
		pnChung.add(lblPhanCongHoiDongChamDiem);

		JPanel pnCenter = new JPanel();
		pnCenter.setLayout(null);
		pnCenter.setBounds(0, 0, 1262, 872);
		pnChung.add(pnCenter);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Danh s\u00E1ch h\u1ED9i \u0111\u1ED3ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(592, 57, 662, 378);
		pnCenter.add(panel_1);

		JLocaleChooser localeChooser = new JLocaleChooser();
		localeChooser.setBounds(-78, 287, 57, 20);
		panel_1.add(localeChooser);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 57, 642, 304);
		panel_1.add(scrollPane);


		tableDanhSachHoiDong = new JTable();
		modelDanhSachHoiDong = new DefaultTableModel("STT, Mã Hội Đồng, Tên Hội Đồng".split(","),0);
		tableDanhSachHoiDong.setModel(modelDanhSachHoiDong);
		scrollPane.setViewportView(tableDanhSachHoiDong);

		JButton btnTimKiemHoiDong = new JButton("Tìm");
		btnTimKiemHoiDong.setBounds(578, 16, 74, 31);
		panel_1.add(btnTimKiemHoiDong);

		txtTimKiemHoiDong = new JTextField();
		txtTimKiemHoiDong.setColumns(10);
		txtTimKiemHoiDong.setBounds(197, 18, 248, 27);
		panel_1.add(txtTimKiemHoiDong);

		JComboBox comboBoxTimKiemHoiDong = new JComboBox();
		comboBoxTimKiemHoiDong.setModel(new DefaultComboBoxModel(new String[] {"Chọn tiêu chí...", "Mã Hội Đồng", "Tên Hội Đồng"}));
		comboBoxTimKiemHoiDong.setBounds(455, 18, 113, 27);
		panel_1.add(comboBoxTimKiemHoiDong);

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Danh s\u00E1ch nh\u00F3m", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBounds(10, 445, 581, 427);
		pnCenter.add(panel_3);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 59, 561, 358);
		panel_3.add(scrollPane_1);

		tableDanhSachNhom = new JTable();
		scrollPane_1.setViewportView(tableDanhSachNhom);

		JComboBox comboBoxLocNhom = new JComboBox();
		comboBoxLocNhom.setModel(new DefaultComboBoxModel(new String[] {"Nhóm chưa được phân công", "Nhóm đã được phân công"}));
		comboBoxLocNhom.setBounds(378, 22, 193, 27);
		panel_3.add(comboBoxLocNhom);

		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Nh\u00F3m \u0111\u01B0\u1EE3c ch\u1ECDn", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3_1.setBounds(673, 445, 581, 427);
		pnCenter.add(panel_3_1);

		JScrollPane scrollPane_1_1 = new JScrollPane();
		scrollPane_1_1.setBounds(10, 22, 561, 395);
		panel_3_1.add(scrollPane_1_1);

		tableDanhSachNhomDuocChon = new JTable();
		modelDanhSachNhomDuocChon = new DefaultTableModel("Mã Nhóm, Mã Luận Văn, Ngày Báo Cáo".split(","), 0);
		tableDanhSachNhomDuocChon.setModel(modelDanhSachNhomDuocChon);
		scrollPane_1_1.setViewportView(tableDanhSachNhomDuocChon);

		JButton btnThemNhom = new JButton(">>");

		btnThemNhom.setBounds(601, 521, 68, 23);
		pnCenter.add(btnThemNhom);

		JButton btnXoaPhanCong = new JButton("<<");
		btnXoaPhanCong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modelDanhSachNhomDuocChon.removeRow(tableDanhSachNhomDuocChon.getSelectedRow());
				txtSoLuong.setText(String.valueOf((modelDanhSachNhomDuocChon.getRowCount())));
			}
		});
		btnXoaPhanCong.setBounds(601, 707, 68, 23);
		pnCenter.add(btnXoaPhanCong);

		JLabel lblSoLuongGiaoVien = new JLabel("Số lượng:");
		lblSoLuongGiaoVien.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoLuongGiaoVien.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSoLuongGiaoVien.setBounds(604, 581, 62, 23);
		pnCenter.add(lblSoLuongGiaoVien);

		txtSoLuong = new JTextField();
		txtSoLuong.setColumns(10);
		txtSoLuong.setBounds(604, 615, 62, 20);
		pnCenter.add(txtSoLuong);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "H\u1ED9i \u0111\u1ED3ng \u0111\u01B0\u1EE3c l\u1EF1a ch\u1ECDn", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1_1.setBounds(10, 57, 572, 378);
		pnCenter.add(panel_1_1);

		JButton btnTimKiemHoiDong_2 = new JButton("Tìm");
		btnTimKiemHoiDong_2.setBounds(578, 16, 74, 31);
		panel_1_1.add(btnTimKiemHoiDong_2);

		txtMaHoiDong = new JTextField();
		txtMaHoiDong.setBounds(159, 39, 372, 20);
		panel_1_1.add(txtMaHoiDong);
		txtMaHoiDong.setEditable(false);
		txtMaHoiDong.setColumns(10);

		JLabel lblMaHoiDong = new JLabel("Mã hội đồng: ");
		lblMaHoiDong.setBounds(40, 38, 109, 19);
		panel_1_1.add(lblMaHoiDong);
		lblMaHoiDong.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lblTenHoiDong = new JLabel("Tên hội đồng: ");
		lblTenHoiDong.setBounds(40, 86, 109, 19);
		panel_1_1.add(lblTenHoiDong);
		lblTenHoiDong.setFont(new Font("Tahoma", Font.PLAIN, 15));

		txtTenHoiDong = new JTextField();
		txtTenHoiDong.setBounds(159, 88, 372, 20);
		panel_1_1.add(txtTenHoiDong);
		txtTenHoiDong.setEditable(false);
		txtTenHoiDong.setColumns(10);

		JButton btnLuuHoiDong = new JButton("Phân Công Hội Đồng Chấm Điểm");
		btnLuuHoiDong.setBounds(159, 147, 267, 38);
		panel_1_1.add(btnLuuHoiDong);
		btnLuuHoiDong.setFont(new Font("Tahoma", Font.PLAIN, 15));

		tableDanhSachHoiDong.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				txtMaHoiDong.setText(tableDanhSachHoiDong.getValueAt(tableDanhSachHoiDong.getSelectedRow(), 1).toString());
				txtTenHoiDong.setText(tableDanhSachHoiDong.getValueAt(tableDanhSachHoiDong.getSelectedRow(), 2).toString());
				String maHoiDong = txtMaHoiDong.getText();
				try {
					Connection con = Database.getInstance().getConnection();
					modelDanhSachNhomDuocChon.setRowCount(0);
					Statement st = con.createStatement();
					ResultSet res = st.executeQuery("SELECT MaNhom, MaLuanVan, NgayBaoCao FROM DANHSACH_DANGKYLUANVAN WHERE MaHoiDong = '"+maHoiDong+"'");
					while(res.next()) {
						Object[] rowData = {
								res.getString(1),
								res.getString(2),
								res.getString(3),
						};
						modelDanhSachNhomDuocChon.addRow(rowData);
					}
					tableDanhSachNhomDuocChon.setModel(modelDanhSachNhomDuocChon);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});



		tableDanhSachNhomDuocChon.getColumnModel().getColumn(2).setCellEditor(new JDateChooserEditor(new JCheckBox()));
		btnThemNhom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object[] rowData = {
						tableDanhSachNhom.getValueAt(tableDanhSachNhom.getSelectedRow(),1),
						tableDanhSachNhom.getValueAt(tableDanhSachNhom.getSelectedRow(), 2),
						"Chọn ngày..."
				};
				modelDanhSachNhomDuocChon.addRow(rowData);
				txtSoLuong.setText(String.valueOf((modelDanhSachNhomDuocChon.getRowCount())));
				tableDanhSachNhomDuocChon.setRowSelectionInterval(tableDanhSachNhomDuocChon.getRowCount()-1, tableDanhSachNhomDuocChon.getRowCount()-1);
			}

		});	
		
		btnTimKiemHoiDong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modelDanhSachHoiDong.setRowCount(0);
				String tieuChi = comboBoxTimKiemHoiDong.getSelectedItem().toString();
				String noiDungTimKiem = txtTimKiemHoiDong.getText();
				int i = 1;
				if(tieuChi.equalsIgnoreCase("Chọn tiêu chí...")) {
					try {
						JOptionPane.showMessageDialog(null, "Vui lòng chọn tiêu chí!");
						loadTableDanhSachHoiDong();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else if(tieuChi.equalsIgnoreCase("Mã Hội Đồng")){
					for(HoiDong hd : listHoiDong) {
						if(hd.getMaHoiDong().equalsIgnoreCase(noiDungTimKiem)) {
							Object[] rowData = {
									i,
									hd.getMaHoiDong(),
									hd.getTenHoiDong()
							};
							modelDanhSachHoiDong.addRow(rowData);
						}
					}
					if(modelDanhSachHoiDong.getRowCount() == 0) {
						try {
							JOptionPane.showMessageDialog(null, "Không tìm thấy!");
							loadTableDanhSachHoiDong();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}else if(tieuChi.equalsIgnoreCase("Tên Hội Đồng")) {
					for(HoiDong hd : listHoiDong) {
						if(hd.getTenHoiDong().equalsIgnoreCase(noiDungTimKiem)) {
							Object[] rowData = {
									i,
									hd.getMaHoiDong(),
									hd.getTenHoiDong()
							};
							modelDanhSachHoiDong.addRow(rowData);
						}
					}
					if(modelDanhSachHoiDong.getRowCount() == 0) {
						try {
							JOptionPane.showMessageDialog(null, "Không tìm thấy!");
							loadTableDanhSachHoiDong();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		});

		txtTimKiemHoiDong.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				if(txtTimKiemHoiDong.getText().trim().length() == 0) {
					try {
						loadTableDanhSachHoiDong();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
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

		comboBoxLocNhom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String tieuChi = comboBoxLocNhom.getSelectedItem().toString();
				try {
					if(tieuChi.equalsIgnoreCase("Nhóm chưa được phân công")){
						updateTableDanhSachNhomChuaPhanCong();
					}else {
						updateTableDanhSachNhomDaPhanCong();;
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		btnLuuHoiDong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(txtMaHoiDong.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn Hội Đồng muốn phân công!");
					return;
				}
				try {
					Connection con = Database.getInstance().getConnection();
					String maHoiDong = txtMaHoiDong.getText();
					Statement st = con.createStatement();
					st.executeUpdate("UPDATE DANHSACH_DANGKYLUANVAN SET MaHoiDong = NULL WHERE MaHoiDong = '"+maHoiDong+"'");
					for(int i = 0; i < tableDanhSachNhomDuocChon.getRowCount(); i++) {
						String maNhom = tableDanhSachNhomDuocChon.getValueAt(i, 0).toString();
						String ngayBaoCao = tableDanhSachNhomDuocChon.getValueAt(i, 2).toString();
						PreparedStatement stmt = con.prepareStatement("UPDATE DANHSACH_DANGKYLUANVAN SET MaHoiDong = ?, NgayBaoCao = ? WHERE MaNhom = ?");
						stmt.setString(1, maHoiDong);
						stmt.setString(2, ngayBaoCao);
						stmt.setString(3, maNhom);
						stmt.executeUpdate();
					}
					updateTableDanhSachHoiDong();
					loadTableDanhSachHoiDong();
					updateTableDanhSachNhomChuaPhanCong();
					modelDanhSachNhomDuocChon.setRowCount(0);
					JOptionPane.showMessageDialog(null, "Lưu thành công!");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Vui lòng chọn ngày báo cáo!");
					return;
				}
			}
		});
		updateTableDanhSachHoiDong();
		loadTableDanhSachHoiDong();
		updateTableDanhSachNhomChuaPhanCong();
	}

	public void updateTableDanhSachHoiDong() throws SQLException {
		HoiDongDao dao = new HoiDongDao();
		listHoiDong = dao.docTuBang();
	}

	public void loadTableDanhSachHoiDong() throws SQLException {
		modelDanhSachHoiDong.setRowCount(0);
		int i = 1;
		for(HoiDong hd : listHoiDong) {
			Object[] rowData = {
					i,
					hd.getMaHoiDong(),
					hd.getTenHoiDong()
			};
			modelDanhSachHoiDong.addRow(rowData);
			i++;
		}
	}

	public void updateTableDanhSachNhomChuaPhanCong() throws SQLException {
		Database.getInstance().connec();
		Connection con = Database.getInstance().getConnection();
		DefaultTableModel modelGiaoVienChuaDuocPhanCong = new DefaultTableModel("STT, Mã Nhóm, Mã Luận Văn".split(","),0);
		modelGiaoVienChuaDuocPhanCong.setRowCount(0);
		int i = 1;
		Statement st = con.createStatement();
		ResultSet res = st.executeQuery("SELECT * FROM DANHSACH_DANGKYLUANVAN WHERE MaHoiDong IS NULL");
		while(res.next()) {
			Object[] rowData = {
					i,
					res.getString(1),
					res.getString(2),
					res.getString(3),
					res.getString(4)
			};
			i++;
			modelGiaoVienChuaDuocPhanCong.addRow(rowData);
		}
		tableDanhSachNhom.setModel(modelGiaoVienChuaDuocPhanCong);
	}

	public void updateTableDanhSachNhomDaPhanCong() throws SQLException {
		Database.getInstance().connec();
		Connection con = Database.getInstance().getConnection();
		DefaultTableModel modelGiaoVienDuocPhanCong = new DefaultTableModel("STT, Mã Nhóm, Mã Luận Văn, Mã Hội Đồng, Ngày Báo Cáo".split(","),0);
		modelGiaoVienDuocPhanCong.setRowCount(0);
		int i = 1;
		Statement st = con.createStatement();
		ResultSet res = st.executeQuery("SELECT * FROM DANHSACH_DANGKYLUANVAN WHERE MaHoiDong IS NOT NULL");
		while(res.next()) {
			Object[] rowData = {
					i,
					res.getString(1),
					res.getString(2),
					res.getString(3),
					res.getString(4)
			};
			i++;
			modelGiaoVienDuocPhanCong.addRow(rowData);
		}
		tableDanhSachNhom.setModel(modelGiaoVienDuocPhanCong);
	}
	
	public JPanel getPanel() {
		return pnChung;
	}
}
