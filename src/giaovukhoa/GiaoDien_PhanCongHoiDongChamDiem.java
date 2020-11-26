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
import java.time.LocalDate;
import java.time.LocalTime;
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

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.TimePicker;
import com.github.lgooddatepicker.components.TimePickerSettings;
import com.github.lgooddatepicker.tableeditors.DateTableEditor;
import com.github.lgooddatepicker.tableeditors.TimeTableEditor;
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
	private JTextField txtNgayBaoCao;
	private JTextField txtTimKiemNhom;
	private JTextField txtNgayLapHoiDong;
	private DefaultTableModel modelNhomChuaDuocPhanCong;
	private DefaultTableModel modelNhomDuocPhanCong;
	/**
	 * Launch the application.
	 */


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
		modelDanhSachHoiDong = new DefaultTableModel("STT, Mã Hội Đồng, Tên Hội Đồng, Ngày Lập Hội Đồng, Ngày Chấm Báo Cáo".split(","),0);
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
		comboBoxTimKiemHoiDong.setModel(new DefaultComboBoxModel(new String[] {"Chọn tiêu chí...", "Mã Hội Đồng", "Tên Hội Đồng", "Ngày Lập", "Ngày Chấm Báo Cáo"}));
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

		modelNhomChuaDuocPhanCong = new DefaultTableModel("STT, Mã Nhóm, Mã Luận Văn, Ngày Lập".split(","),0);
		modelNhomDuocPhanCong = new DefaultTableModel("STT, Mã Nhóm, Mã Luận Văn, Mã Hội Đồng, Ngày Lập, Ngày Báo Cáo, Giờ Báo Cáo".split(","),0);
		JComboBox comboBoxLocNhom = new JComboBox();
		comboBoxLocNhom.setModel(new DefaultComboBoxModel(new String[] {"Nhóm chưa được phân công", "Nhóm đã được phân công"}));
		comboBoxLocNhom.setBounds(404, 22, 167, 27);
		panel_3.add(comboBoxLocNhom);

		txtTimKiemNhom = new JTextField();
		txtTimKiemNhom.setColumns(10);
		txtTimKiemNhom.setBounds(10, 22, 190, 27);
		panel_3.add(txtTimKiemNhom);

		JComboBox comboBoxTimKiemNhom = new JComboBox();
		comboBoxTimKiemNhom.setBounds(207, 22, 109, 27);
		comboBoxTimKiemNhom.addItem("Mã Nhóm");
		comboBoxTimKiemNhom.addItem("Mã Luận Văn");
		comboBoxTimKiemNhom.addItem("Ngày Lập");

		panel_3.add(comboBoxTimKiemNhom);

		JButton btnTimKiemNhom = new JButton("Tìm");
		btnTimKiemNhom.setBounds(320, 20, 74, 31);
		panel_3.add(btnTimKiemNhom);

		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Nh\u00F3m \u0111\u01B0\u1EE3c ch\u1ECDn", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3_1.setBounds(673, 445, 581, 427);
		pnCenter.add(panel_3_1);

		JScrollPane scrollPane_1_1 = new JScrollPane();
		scrollPane_1_1.setBounds(10, 22, 561, 395);
		panel_3_1.add(scrollPane_1_1);


		TimePickerSettings ts = new TimePickerSettings();
		ts.use24HourClockFormat();
		TimePicker timePicker = new TimePicker(ts);
		tableDanhSachNhomDuocChon = new JTable();
		modelDanhSachNhomDuocChon = new DefaultTableModel("Mã Nhóm, Mã Luận Văn, Giờ Báo Cáo".split(","), 0);
		tableDanhSachNhomDuocChon.setModel(modelDanhSachNhomDuocChon);

		tableDanhSachNhomDuocChon.setDefaultEditor(LocalTime.class, new TimeTableEditor());
		tableDanhSachNhomDuocChon.getColumnModel().getColumn(2).setCellEditor(tableDanhSachNhomDuocChon.getDefaultEditor(LocalTime.class));
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
		txtMaHoiDong.setBounds(199, 40, 349, 20);
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
		txtTenHoiDong.setBounds(199, 88, 349, 20);
		panel_1_1.add(txtTenHoiDong);
		txtTenHoiDong.setEditable(false);
		txtTenHoiDong.setColumns(10);

		JButton btnLuuHoiDong = new JButton("Phân Công Hội Đồng Chấm Điểm");
		btnLuuHoiDong.setBounds(199, 213, 267, 38);
		panel_1_1.add(btnLuuHoiDong);
		btnLuuHoiDong.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lblNgyChmBo = new JLabel("Ngày chấm báo cáo:");
		lblNgyChmBo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNgyChmBo.setBounds(40, 171, 149, 19);
		panel_1_1.add(lblNgyChmBo);

		txtNgayBaoCao = new JTextField();
		txtNgayBaoCao.setEditable(false);
		txtNgayBaoCao.setColumns(10);
		txtNgayBaoCao.setBounds(199, 173, 349, 20);
		panel_1_1.add(txtNgayBaoCao);

		JLabel lblNgayLapHoiDong = new JLabel("Ngày lập hội đồng:");
		lblNgayLapHoiDong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNgayLapHoiDong.setBounds(40, 130, 149, 19);
		panel_1_1.add(lblNgayLapHoiDong);

		txtNgayLapHoiDong = new JTextField();
		txtNgayLapHoiDong.setEditable(false);
		txtNgayLapHoiDong.setColumns(10);
		txtNgayLapHoiDong.setBounds(199, 132, 349, 20);
		panel_1_1.add(txtNgayLapHoiDong);

		tableDanhSachHoiDong.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				txtMaHoiDong.setText(tableDanhSachHoiDong.getValueAt(tableDanhSachHoiDong.getSelectedRow(), 1).toString());
				txtTenHoiDong.setText(tableDanhSachHoiDong.getValueAt(tableDanhSachHoiDong.getSelectedRow(), 2).toString());
				txtNgayBaoCao.setText(tableDanhSachHoiDong.getValueAt(tableDanhSachHoiDong.getSelectedRow(), 4).toString());
				txtNgayLapHoiDong.setText(tableDanhSachHoiDong.getValueAt(tableDanhSachHoiDong.getSelectedRow(), 3).toString());
				String maHoiDong = txtMaHoiDong.getText();
				try {
					Connection con = Database.getInstance().getConnection();
					modelDanhSachNhomDuocChon.setRowCount(0);
					Statement st = con.createStatement();
					ResultSet res = st.executeQuery("SELECT MaNhom, MaLuanVan, CONVERT(VARCHAR(5),NgayBaoCao,114) AS [GioBaoCao] FROM DANHSACH_DANGKYLUANVAN WHERE MaHoiDong = '"+maHoiDong+"'");
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
		btnThemNhom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tableDanhSachNhom.getSelectedRow() == -1) {
					return;
				}
				Object[] rowData = {
						tableDanhSachNhom.getValueAt(tableDanhSachNhom.getSelectedRow(),1),
						tableDanhSachNhom.getValueAt(tableDanhSachNhom.getSelectedRow(), 2),
						"Chọn giờ..."
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
				HoiDongDao  hd = new HoiDongDao();
				try {
					if(tieuChi.equalsIgnoreCase("Chọn tiêu chí...")) {
						JOptionPane.showMessageDialog(null, "Vui lòng chọn tiêu chí!");
						updateTableDanhSachHoiDong();
					}else if(tieuChi.equalsIgnoreCase("Mã Hội Đồng")){
						hd.timKiemHoiDongTheoTieuChi(noiDungTimKiem, "", "", "", tableDanhSachHoiDong);
					}else if(tieuChi.equalsIgnoreCase("Tên Hội Đồng")) {
						hd.timKiemHoiDongTheoTieuChi("", noiDungTimKiem, "", "", tableDanhSachHoiDong);
					}else if(tieuChi.equalsIgnoreCase("Ngày Lập")) {
						hd.timKiemHoiDongTheoTieuChi("", "", noiDungTimKiem, "", tableDanhSachHoiDong);
					}else if(tieuChi.equalsIgnoreCase("Ngày Chấm Báo Cáo")) {
						hd.timKiemHoiDongTheoTieuChi("", "", "", noiDungTimKiem, tableDanhSachHoiDong);
					}
					if(modelDanhSachHoiDong.getRowCount() == 0) {
						JOptionPane.showMessageDialog(null, "Không tìm thấy!");
						try {
							updateTableDanhSachHoiDong();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}catch (SQLException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		});

		txtTimKiemHoiDong.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				if(txtTimKiemHoiDong.getText().trim().length() == 0) {
					try {
						updateTableDanhSachHoiDong();
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
				modelDanhSachNhomDuocChon.setRowCount(0);
				String tieuChi = comboBoxLocNhom.getSelectedItem().toString();
				try {
					if(tieuChi.equalsIgnoreCase("Nhóm chưa được phân công")){
						comboBoxTimKiemNhom.setModel(new DefaultComboBoxModel<>());
						comboBoxTimKiemNhom.addItem("Mã Nhóm");
						comboBoxTimKiemNhom.addItem("Mã Luận Văn");
						comboBoxTimKiemNhom.addItem("Ngày Lập");
						updateTableDanhSachNhomChuaPhanCong();
					}else {
						comboBoxTimKiemNhom.setModel(new DefaultComboBoxModel<>());
						comboBoxTimKiemNhom.addItem("Mã Nhóm");
						comboBoxTimKiemNhom.addItem("Mã Luận Văn");
						comboBoxTimKiemNhom.addItem("Mã Hội Đồng");
						comboBoxTimKiemNhom.addItem("Ngày Lập");
						comboBoxTimKiemNhom.addItem("Ngày Báo Cáo");
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
						String ngayBaoCao = txtNgayBaoCao.getText() + " " + tableDanhSachNhomDuocChon.getValueAt(i, 2).toString();
						PreparedStatement stmt = con.prepareStatement("UPDATE DANHSACH_DANGKYLUANVAN SET MaHoiDong = ?, NgayBaoCao = ? WHERE MaNhom = ?");
						stmt.setString(1, maHoiDong);
						stmt.setString(2, ngayBaoCao);
						stmt.setString(3, maNhom);
						stmt.executeUpdate();
					}
					updateTableDanhSachHoiDong();
					updateTableDanhSachNhomChuaPhanCong();
					modelDanhSachNhomDuocChon.setRowCount(0);
					comboBoxLocNhom.setSelectedItem("Nhóm chưa được phân công");
					JOptionPane.showMessageDialog(null, "Lưu thành công!");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
//					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Vui lòng chọn ngày báo cáo!");
					return;
				}
			}
		});

		btnTimKiemNhom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//				tableDanhSachNhom.setModel(new DefaultTableModel());
				String tieuChi = comboBoxTimKiemNhom.getSelectedItem().toString();
				String tieuChiLoc = comboBoxLocNhom.getSelectedItem().toString();
				String noiDungTimKiem = txtTimKiemNhom.getText();
				try {
					if(tieuChiLoc.equalsIgnoreCase("Nhóm chưa được phân công")) {
						if(tieuChi.equalsIgnoreCase("Mã Nhóm")) {
							timKiemNhomChuaPhanCong(noiDungTimKiem, "","");
						}else if(tieuChi.equalsIgnoreCase("Mã Luận Văn")) {
							timKiemNhomChuaPhanCong("", noiDungTimKiem,"");
						}else if(tieuChi.equalsIgnoreCase("Ngày Lập")) {
							timKiemNhomChuaPhanCong("", "",noiDungTimKiem);
						}

					}else {
						if(tieuChi.equalsIgnoreCase("Mã Nhóm")) {
							timKiemNhomDaPhanCong(noiDungTimKiem, "","","","");
						}else if(tieuChi.equalsIgnoreCase("Mã Luận Văn")) {
							timKiemNhomDaPhanCong("", noiDungTimKiem,"","","");
						}else if(tieuChi.equalsIgnoreCase("Mã Hội Đồng")) {
							timKiemNhomDaPhanCong("", "",noiDungTimKiem,"","");
						}else if(tieuChi.equalsIgnoreCase("Ngày lập")) {
							timKiemNhomDaPhanCong("","","",noiDungTimKiem,"");
						}else if(tieuChi.equalsIgnoreCase("Ngày Báo Cáo")) {
							timKiemNhomDaPhanCong("", "","","",noiDungTimKiem);
						}
					}

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		capNhat();
	}
	
	public void capNhat() throws SQLException {
		updateTableDanhSachHoiDong();
		updateTableDanhSachNhomChuaPhanCong();
	}

	public void updateTableDanhSachHoiDong() throws SQLException {
		modelDanhSachHoiDong.setRowCount(0);
		int i = 1;
		Connection con = Database.getInstance().getConnection();
		String sql = "select * from HOIDONG WHERE YEAR(NgayLap) = '"+LocalDate.now().getYear()+"'";
		Statement statement = con.createStatement();
		ResultSet res = statement.executeQuery(sql);
		while (res.next()) {
			Object[] rowData = {
					i,
					res.getString(1),
					res.getNString(2),
					res.getString(3),
					res.getString(4)
			};
			modelDanhSachHoiDong.addRow(rowData);
			i++;
		}
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
			JOptionPane.showMessageDialog(null, "Không tìm thấy!");
			try {
				updateTableDanhSachNhomDaPhanCong();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		tableDanhSachNhom.setModel(model);
	}

	public void timKiemNhomChuaPhanCong(String maNhom, String maLuanVan, String NgayLap) throws SQLException {
		Connection con = Database.getInstance().getConnection();
		Statement statement = con.createStatement();
		DefaultTableModel model = (DefaultTableModel) tableDanhSachNhom.getModel();
		model.setRowCount(0);
		int i = 1;
		ResultSet res = statement.executeQuery("SELECT MaNhom, MaLuanVan, NgayLap "
				+ "FROM DANHSACH_DANGKYLUANVAN "
				+ "WHERE MaNhom LIKE '%"+maNhom+"%' AND MaLuanVan LIKE '%"+maLuanVan+"%' AND NgayLap LIKE '%"+NgayLap+"%' AND MaHoiDong IS NULL");
		while(res.next()) {
			Object[] rowData = {
					i,
					res.getString(1),
					res.getString(2),
					res.getString(3),
			};
			model.addRow(rowData);
			i++;
		}
		if(model.getRowCount() == 0) {
			JOptionPane.showMessageDialog(null, "Không tìm thấy!");
			try {
				updateTableDanhSachNhomChuaPhanCong();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		tableDanhSachNhom.setModel(model);
	}


	public void updateTableDanhSachNhomChuaPhanCong() throws SQLException {
		Database.getInstance().connec();
		Connection con = Database.getInstance().getConnection();;
		modelNhomChuaDuocPhanCong.setRowCount(0);
		int i = 1;
		Statement st = con.createStatement();
		ResultSet res = st.executeQuery("SELECT MaNhom, MaLuanVan, NgayLap"
				+ " FROM DANHSACH_DANGKYLUANVAN WHERE MaHoiDong IS NULL AND MaLuanVan IS NOT NULL ");
		while(res.next()) {
			Object[] rowData = {
					i,
					res.getString(1),
					res.getString(2),
					res.getString(3),
			};
			i++;
			modelNhomChuaDuocPhanCong.addRow(rowData);
		}
		tableDanhSachNhom.setModel(modelNhomChuaDuocPhanCong);
	}

	public void updateTableDanhSachNhomDaPhanCong() throws SQLException {
		Database.getInstance().connec();
		Connection con = Database.getInstance().getConnection();
		modelNhomDuocPhanCong.setRowCount(0);
		int i = 1;
		Statement st = con.createStatement();
		ResultSet res = st.executeQuery("SELECT MaNhom, MaLuanVan,MaHoiDong, NgayLap, CONVERT(VARCHAR(10),NgayBaoCao,120) AS [NgayBaoCao], CONVERT(VARCHAR(5),NgayBaoCao,114) AS [GioBaoCao] "
				+ "FROM DANHSACH_DANGKYLUANVAN "
				+ "WHERE MaHoiDong IS NOT NULL");
		while(res.next()) {
			Object[] rowData = {
					i,
					res.getString(1),
					res.getString(2),
					res.getString(3),
					res.getString(4),
					res.getString(5),
					res.getString(6),
			};
			i++;
			modelNhomDuocPhanCong.addRow(rowData);
		}
		tableDanhSachNhom.setModel(modelNhomDuocPhanCong);
	}


	public JPanel getPanel() {
		return pnChung;
	}
}
