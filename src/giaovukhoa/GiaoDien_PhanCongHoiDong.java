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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.hibernate.type.descriptor.java.LocalDateJavaDescriptor;

import javax.swing.JButton;
import com.toedter.components.JLocaleChooser;

import dao.Database;
import dao.GiaoVienDao;
import dao.HoiDongDao;
import dao.LuanVanDao;
import entity.GiaoVien;
import entity.HoiDong;
import entity.LuanVan;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;
import com.github.lgooddatepicker.components.DateTimePicker;
import com.github.lgooddatepicker.components.TimePicker;
import com.github.lgooddatepicker.components.TimePickerSettings;
import com.toedter.calendar.JDateChooser;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.Action;
import javax.swing.DefaultCellEditor;
import javax.swing.border.EtchedBorder;

public class GiaoDien_PhanCongHoiDong {

	private JFrame frame;
	private JTextField txtMaHoiDong;
	private JPanel pnChung;
	private JTextField txtTenHoiDongMoi;
	private JTable tableDanhSachHoiDong;
	private JTable tableDanhSachGiaoVien;
	private JTable tableGiaoVienDuocPhanCong;
	private JTextField txtSoLuongGiaoVien;
	private GiaoDien_ChonCongViec GD_CCV;
	private JTextField txtTenHoiDong;
	private JTextField txtTimKiemHoiDong;
	private DefaultTableModel modelDanhSachGiaoVien;
	private DefaultTableModel modelGiaoVienDuocPhanCong;
	private DefaultCellEditor cellEditorGiaoVienDuocPhanCong;
	private JTextField txtTimKiemGiaoVien;
	private DefaultTableModel modelDanhSachHoiDong;
	private ArrayList<HoiDong> listHoiDong;
	private DefaultComboBoxModel modelComboTenLuanVan;
	private DefaultComboBoxModel modelComboNhomBaoVe;
	private ArrayList<GiaoVien> listGiaoVien;
	private JTextField txtNgayLapHoiDong;
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GiaoDien_PhanCongHoiDong window = new GiaoDien_PhanCongHoiDong();
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
	 * @throws ParseException 
	 */
	public GiaoDien_PhanCongHoiDong() throws SQLException, ParseException {
		initialize();
	}


	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 * @throws ParseException 
	 */
	private void initialize() throws SQLException, ParseException {
		Database.getInstance().connec();
		frame = new JFrame();
		frame.setBounds(100, 100, 1280, 950);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		pnChung = new JPanel();
		frame.getContentPane().add(pnChung, BorderLayout.CENTER);
		pnChung.setLayout(new BorderLayout(0, 0));

		JLabel lblPhanCongHoiDong = new JLabel("Phân công hội đồng");
		lblPhanCongHoiDong.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhanCongHoiDong.setFont(new Font("Tahoma", Font.PLAIN, 25));
		pnChung.add(lblPhanCongHoiDong, BorderLayout.NORTH);

		JPanel pnCenter = new JPanel();
		pnChung.add(pnCenter, BorderLayout.CENTER);
		pnCenter.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "H\u1ED9i \u0111\u1ED3ng \u0111ang l\u1EF1a ch\u1ECDn", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 197, 547, 232);
		pnCenter.add(panel);
		panel.setLayout(null);

		JLabel lblMaHoiDong = new JLabel("Mã hội đồng: ");
		lblMaHoiDong.setBounds(31, 21, 109, 19);
		lblMaHoiDong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblMaHoiDong);

		txtMaHoiDong = new JTextField();
		txtMaHoiDong.setBounds(186, 23, 336, 20);
		txtMaHoiDong.setEditable(false);
		txtMaHoiDong.setColumns(10);
		panel.add(txtMaHoiDong);

		JButton btnLuuHoiDong = new JButton("Lưu Hội Đồng");
		btnLuuHoiDong.setBounds(188, 170, 132, 38);
		btnLuuHoiDong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(btnLuuHoiDong);

		JButton btnXoaHoiDong = new JButton("Xoá Hội Đồng");
		btnXoaHoiDong.setBounds(342, 170, 132, 38);
		btnXoaHoiDong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(btnXoaHoiDong);

		txtTenHoiDong = new JTextField();
		txtTenHoiDong.setBounds(186, 55, 336, 20);
		panel.add(txtTenHoiDong);
		txtTenHoiDong.setColumns(10);

		JLabel lblTenHoiDong = new JLabel("Tên hội đồng: ");
		lblTenHoiDong.setBounds(31, 53, 109, 19);
		panel.add(lblTenHoiDong);
		lblTenHoiDong.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lblNgayLapHoiDong = new JLabel("Ngày lập:");
		lblNgayLapHoiDong.setBounds(31, 89, 144, 19);
		lblNgayLapHoiDong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblNgayLapHoiDong);
		
		DatePickerSettings dateSettings = new DatePickerSettings();
        dateSettings.setFormatForDatesCommonEra("yyyy-MM-dd");
		DatePicker dateNgayChamBaoCao = new DatePicker(dateSettings);
		dateNgayChamBaoCao.setBounds(186, 127, 336, 19);
		panel.add(dateNgayChamBaoCao);
		
		JLabel lblNgayChamBaoCao = new JLabel("Ngày chấm báo cáo:");
		lblNgayChamBaoCao.setBounds(31, 124, 144, 19);
		lblNgayChamBaoCao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblNgayChamBaoCao);
		
		txtNgayLapHoiDong = new JTextField();
		txtNgayLapHoiDong.setEditable(false);
		txtNgayLapHoiDong.setColumns(10);
		txtNgayLapHoiDong.setBounds(186, 91, 336, 20);
		panel.add(txtNgayLapHoiDong);

		btnXoaHoiDong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HoiDongDao dao = new HoiDongDao();
				int ret = JOptionPane.showConfirmDialog(null, "Bạn có muốn xoá hội đồng này?", "Xoá", JOptionPane.YES_NO_OPTION);
				if(ret == JOptionPane.YES_OPTION) {
					try {
						dao.xoaHoiDong(txtMaHoiDong.getText());
						updateTableDanhSachHoiDong();
						txtTenHoiDong.setText(null);
						txtMaHoiDong.setText(null);
						dateNgayChamBaoCao.setText(null);
						txtNgayLapHoiDong.setText(null);
						JOptionPane.showMessageDialog(null, "Xoá Thành Công!");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});

		

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Danh s\u00E1ch h\u1ED9i \u0111\u1ED3ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(567, 28, 687, 401);
		pnCenter.add(panel_1);
		panel_1.setLayout(null);

		JLocaleChooser localeChooser = new JLocaleChooser();
		localeChooser.setBounds(-78, 287, 57, 20);
		panel_1.add(localeChooser);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 57, 667, 304);
		panel_1.add(scrollPane);

		tableDanhSachHoiDong = new JTable();
		modelDanhSachHoiDong = new DefaultTableModel("STT, Mã Hội Đồng, Tên Hội Đồng, Ngày Lập, Ngày Chấm Báo C".split(","),0);
		tableDanhSachHoiDong.setModel(modelDanhSachHoiDong);
		scrollPane.setViewportView(tableDanhSachHoiDong);

		JButton btnTimKiemHoiDong = new JButton("Tìm");
		btnTimKiemHoiDong.setBounds(603, 16, 74, 31);
		panel_1.add(btnTimKiemHoiDong);

		txtTimKiemHoiDong = new JTextField();
		txtTimKiemHoiDong.setBounds(222, 18, 248, 27);
		panel_1.add(txtTimKiemHoiDong);
		txtTimKiemHoiDong.setColumns(10);

		JComboBox comboBoxTimKiemHoiDong = new JComboBox();
		comboBoxTimKiemHoiDong.setModel(new DefaultComboBoxModel(new String[] {"Chọn tiêu chí...", "Mã Hội Đồng", "Tên Hội Đồng"}));
		comboBoxTimKiemHoiDong.setBounds(480, 18, 113, 27);
		panel_1.add(comboBoxTimKiemHoiDong);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "H\u1ED9i \u0111\u1ED3ng m\u1EDBi", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(10, 28, 547, 167);
		pnCenter.add(panel_2);

		JLabel lblTenHoiDongMoi = new JLabel("Tên hội đồng: ");
		lblTenHoiDongMoi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTenHoiDongMoi.setBounds(35, 27, 109, 19);
		panel_2.add(lblTenHoiDongMoi);

		txtTenHoiDongMoi = new JTextField();
		txtTenHoiDongMoi.setColumns(10);
		txtTenHoiDongMoi.setBounds(187, 28, 336, 20);
		panel_2.add(txtTenHoiDongMoi);

		JButton txtTaoHoiDong = new JButton("Tạo Hội Đồng");
		txtTaoHoiDong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTaoHoiDong.setBounds(187, 112, 132, 38);
		panel_2.add(txtTaoHoiDong);

		JLabel lblNgayChamBaoCaoMoi = new JLabel("Ngày chấm báo cáo:");
		lblNgayChamBaoCaoMoi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNgayChamBaoCaoMoi.setBounds(35, 68, 144, 19);
		panel_2.add(lblNgayChamBaoCaoMoi);

		DatePickerSettings dateSettings_1 = new DatePickerSettings();
        dateSettings_1.setFormatForDatesCommonEra("yyyy-MM-dd");
        
		DatePicker dateNgayChamBaoCaoMoi = new DatePicker(dateSettings_1);
		dateNgayChamBaoCaoMoi.getComponentDateTextField().setFont(new Font("Tahoma", Font.PLAIN, 15));
		dateNgayChamBaoCaoMoi.setBounds(187, 68, 336, 19);
		panel_2.add(dateNgayChamBaoCaoMoi);


		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Danh s\u00E1ch gi\u00E1o vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBounds(10, 439, 581, 404);
		pnCenter.add(panel_3);
		panel_3.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 59, 561, 358);
		panel_3.add(scrollPane_1);

		tableDanhSachGiaoVien = new JTable();
		modelDanhSachGiaoVien = new DefaultTableModel("STT,Mã Giáo Viên,Tên Giáo Viên, Chức Danh, Lĩnh Vực Công Tác, Khoa Công Tác, Đơn Vị Công Tác".split(","),0);
		tableDanhSachGiaoVien.setModel(modelDanhSachGiaoVien);
		scrollPane_1.setViewportView(tableDanhSachGiaoVien);

		txtTimKiemGiaoVien = new JTextField();
		txtTimKiemGiaoVien.setColumns(10);
		txtTimKiemGiaoVien.setBounds(116, 22, 248, 27);
		panel_3.add(txtTimKiemGiaoVien);

		JComboBox comboBoxTimKiemGiaoVien = new JComboBox();
		comboBoxTimKiemGiaoVien.setModel(new DefaultComboBoxModel(new String[] {"Chọn tiêu chí...", "Mã giáo viên", "Tên giáo viên", "Khoa công tác"}));
		comboBoxTimKiemGiaoVien.setBounds(374, 22, 113, 27);
		panel_3.add(comboBoxTimKiemGiaoVien);

		JButton btnTimKiemGiaoVien = new JButton("Tìm");
		btnTimKiemGiaoVien.setBounds(497, 20, 74, 31);
		panel_3.add(btnTimKiemGiaoVien);

		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Gi\u00E1o vi\u00EAn \u0111\u01B0\u1EE3c ph\u00E2n c\u00F4ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3_1.setBounds(673, 439, 581, 404);
		pnCenter.add(panel_3_1);

		JScrollPane scrollPane_1_1 = new JScrollPane();
		scrollPane_1_1.setBounds(10, 22, 561, 395);
		panel_3_1.add(scrollPane_1_1);

		tableGiaoVienDuocPhanCong = new JTable();
		modelGiaoVienDuocPhanCong = new DefaultTableModel("Mã Giáo Viên, Tên Giáo Viên, Công Việc".split(","),0);
		tableGiaoVienDuocPhanCong.setModel(modelGiaoVienDuocPhanCong);
		scrollPane_1_1.setViewportView(tableGiaoVienDuocPhanCong);

		JComboBox comboBoxCongViec=new JComboBox();
		comboBoxCongViec.addItem("Chủ Tịch Hội Đồng");
		comboBoxCongViec.addItem("Giáo Viên Phản Biện");
		comboBoxCongViec.addItem("Thư Ký");

		cellEditorGiaoVienDuocPhanCong = new DefaultCellEditor(comboBoxCongViec);
		tableGiaoVienDuocPhanCong.getColumnModel().getColumn(2).setCellEditor(cellEditorGiaoVienDuocPhanCong);

		JButton btnThemPhanCong = new JButton(">>");
		btnThemPhanCong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object[] rowData = {
						tableDanhSachGiaoVien.getValueAt(tableDanhSachGiaoVien.getSelectedRow(),1),
						tableDanhSachGiaoVien.getValueAt(tableDanhSachGiaoVien.getSelectedRow(), 2),
						"Chọn công việc..."
				};
				modelGiaoVienDuocPhanCong.addRow(rowData);
				txtSoLuongGiaoVien.setText(String.valueOf((modelGiaoVienDuocPhanCong.getRowCount())));
			}
		});
		btnThemPhanCong.setBounds(598, 478, 68, 23);
		pnCenter.add(btnThemPhanCong);

		JButton btnXoaPhanCong = new JButton("<<");
		btnXoaPhanCong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modelGiaoVienDuocPhanCong.removeRow(tableGiaoVienDuocPhanCong.getSelectedRow());
				txtSoLuongGiaoVien.setText(String.valueOf((modelGiaoVienDuocPhanCong.getRowCount())));
			}
		});
		btnXoaPhanCong.setBounds(598, 664, 68, 23);
		pnCenter.add(btnXoaPhanCong);

		JLabel lblSoLuongGiaoVien = new JLabel("Số lượng:");
		lblSoLuongGiaoVien.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSoLuongGiaoVien.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoLuongGiaoVien.setBounds(601, 538, 62, 23);
		pnCenter.add(lblSoLuongGiaoVien);

		txtSoLuongGiaoVien = new JTextField();
		txtSoLuongGiaoVien.setBounds(601, 572, 62, 20);
		pnCenter.add(txtSoLuongGiaoVien);
		txtSoLuongGiaoVien.setColumns(10);


		btnTimKiemHoiDong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modelDanhSachHoiDong.setRowCount(0);
				String tieuChi = comboBoxTimKiemHoiDong.getSelectedItem().toString();
				String noiDungTimKiem = txtTimKiemHoiDong.getText();
				int i = 1;
				if(tieuChi.equalsIgnoreCase("Chọn tiêu chí...")) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn tiêu chí!");
//						loadTableDanhSachHoiDong();
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
						JOptionPane.showMessageDialog(null, "Không tìm thấy!");
//							loadTableDanhSachHoiDong();
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
						JOptionPane.showMessageDialog(null, "Không tìm thấy!");
//							loadTableDanhSachHoiDong();
					}
				}
			}
		});


		tableDanhSachHoiDong.addMouseListener(new MouseAdapter() {


			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				txtMaHoiDong.setText(tableDanhSachHoiDong.getValueAt(tableDanhSachHoiDong.getSelectedRow(), 1).toString());
				txtTenHoiDong.setText(tableDanhSachHoiDong.getValueAt(tableDanhSachHoiDong.getSelectedRow(), 2).toString());
				txtNgayLapHoiDong.setText(tableDanhSachHoiDong.getValueAt(tableDanhSachHoiDong.getSelectedRow(), 3).toString());
				dateNgayChamBaoCao.setText(tableDanhSachHoiDong.getValueAt(tableDanhSachHoiDong.getSelectedRow(), 4).toString());
				
				try {
					loadGiaoVienDuocPhanCong(txtMaHoiDong.getText());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});

		txtTimKiemHoiDong.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				if(txtTimKiemHoiDong.getText().trim().length() == 0) {
				}
			}

			@Override
			public void insertUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				if(txtTimKiemHoiDong.getText().trim().length() == 0) {
				}
			}

			@Override
			public void changedUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				if(txtTimKiemHoiDong.getText().trim().length() == 0) {
				}
			}
		});

		txtTaoHoiDong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(dateNgayChamBaoCaoMoi.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn ngày báo cáo!");
					return;
				}
				if(dateNgayChamBaoCaoMoi.getDate().compareTo(LocalDate.now()) < 0 ) {
					JOptionPane.showMessageDialog(null, "Ngày báo cáo không được nhỏ hơn ngày hiện tại!");
					return;
				}
				
				String tenHoiDong = txtTenHoiDongMoi.getText();
				String ngayBaoCao = dateNgayChamBaoCaoMoi.toString();
				HoiDongDao dao = new HoiDongDao();
				try {
					String maHoiDong = dao.taoHoiDong(tenHoiDong, ngayBaoCao);
					JOptionPane.showMessageDialog(null, "Tạo Hội Đồng Thành Công!\n\nMã Hội Đồng: "+maHoiDong+".\nTên Hội Đồng: "+tenHoiDong+".");
					updateTableDanhSachHoiDong();
					tableDanhSachHoiDong.setRowSelectionInterval(tableDanhSachHoiDong.getRowCount()-1, tableDanhSachHoiDong.getRowCount()-1);
					txtMaHoiDong.setText(maHoiDong);
					txtTenHoiDong.setText(tenHoiDong);
					txtNgayLapHoiDong.setText(tableDanhSachHoiDong.getValueAt(tableDanhSachHoiDong.getSelectedRow(), 3).toString());
					dateNgayChamBaoCao.setText(tableDanhSachHoiDong.getValueAt(tableDanhSachHoiDong.getSelectedRow(), 4).toString());
					txtTenHoiDongMoi.setText(null);
					modelGiaoVienDuocPhanCong.setRowCount(0);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		btnTimKiemGiaoVien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modelDanhSachGiaoVien.setRowCount(0);
				String tieuChi = comboBoxTimKiemGiaoVien.getSelectedItem().toString();
				String noiDungTimKiem = txtTimKiemGiaoVien.getText();
				int i = 1;
				try {
				if(tieuChi.equalsIgnoreCase("Chọn tiêu chí...")) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn tiêu chí!");
					loadTableDanhSachGiaoVien();
				}else if(tieuChi.equalsIgnoreCase("Mã giáo viên")){
					timKiemGiaoVien(noiDungTimKiem, "", "");
				}else if(tieuChi.equalsIgnoreCase("Tên giáo viên")){
					timKiemGiaoVien("",noiDungTimKiem, "");
				}else if(tieuChi.equalsIgnoreCase("Khoa công tác")){
					timKiemGiaoVien("","",noiDungTimKiem);
				}
			}catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			}
		
		});

		txtTimKiemGiaoVien.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				if(txtTimKiemGiaoVien.getText().trim().length() == 0) {
					loadTableDanhSachGiaoVien();
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
		
		btnLuuHoiDong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String maGiaoVien;
				String congViec;
				for(int i = 0; i < tableGiaoVienDuocPhanCong.getRowCount(); i++ ) {
					congViec = tableGiaoVienDuocPhanCong.getValueAt(i, 2).toString();
					if(congViec.equalsIgnoreCase("Chọn công việc...")) {
						JOptionPane.showMessageDialog(null, "Vui lòng chọn công việc cho giáo viên!");
						return;
					}
				}
				try {
					Connection con = Database.getInstance().getConnection();;
					String maHoiDong = txtMaHoiDong.getText();
					String tenHoiDong = txtTenHoiDong.getText();
					String ngayBaoCao = dateNgayChamBaoCao.getText();
					LocalDate ngayLap = LocalDate.parse(txtNgayLapHoiDong.getText(), dtf);
					if(dateNgayChamBaoCao.getDate().compareTo(ngayLap) < 0) {
						JOptionPane.showMessageDialog(null, "Ngày báo cáo không thể nhỏ hơn ngày lập!");
						return;
					}
					Statement st = con.createStatement();
					st.executeUpdate("DELETE FROM CHITIETCONGVIEC WHERE MaHoiDong = '"+maHoiDong+"'");
					PreparedStatement stmt = con.prepareStatement("UPDATE HOIDONG SET TenHoiDong = ?, NgayBaoCao = ? WHERE MaHoiDong = ?");
					//					st.executeUpdate("UPDATE HOIDONG SET TenHoiDong = '"+tenHoiDong+"' WHERE MaHoiDong = '"+maHoiDong+"'");
					stmt.setNString(1, tenHoiDong);
					stmt.setString(3, maHoiDong);
					stmt.setString(2, ngayBaoCao);
					stmt.executeUpdate();
					for(int i = 0; i < tableGiaoVienDuocPhanCong.getRowCount(); i++ ) {
						maGiaoVien= tableGiaoVienDuocPhanCong.getValueAt(i, 0).toString();
						congViec = tableGiaoVienDuocPhanCong.getValueAt(i, 2).toString();
						PreparedStatement preStatement = con.prepareStatement("INSERT CHITIETCONGVIEC(MaHoiDong, MaGiaoVien, CongViec) VALUES (?,?,?)");
						preStatement.setString(1, maHoiDong);
						preStatement.setString(2, maGiaoVien);
						preStatement.setString(3, congViec);
						preStatement.executeUpdate();
					}
					JOptionPane.showMessageDialog(null, "Lưu Thành Công!");
					modelGiaoVienDuocPhanCong.setRowCount(0);
					txtSoLuongGiaoVien.setText(null);
					tableDanhSachHoiDong.getSelectionModel().clearSelection();
					updateTableDanhSachHoiDong();
//					loadTableDanhSachHoiDong();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Một giáo viên không thể làm hai công việc trong một Hội Đồng!");
					e.printStackTrace();
				}
			}
		});

		updateTableDanhSachHoiDong();
		updateTableDanhSachGiaoVien();
		loadTableDanhSachGiaoVien();
	}
	public JPanel getPanel() {
		return pnChung;
	}
	
	public void timKiemGiaoVien(String maGiaoVien, String tenGiaoVien, String khoaCongTac) throws SQLException {
		Connection con = Database.getInstance().getConnection();
		Statement stmt = con.createStatement();
		int i = 1;
		ResultSet rs = stmt.executeQuery("select MaGiaoVien, HoTen, ChucDanh, LinhVucCongTac, KhoaCongTac, DonViCongTac from GiAOVIEN WHERE MaGiaoVien LIKE '%"+maGiaoVien+"%' AND HoTen LIKE N'%"+tenGiaoVien+"%' AND KhoaCongTac LIKE N'%"+khoaCongTac+"%'");
		while(rs.next()) {
			Object[] rowData = {
					i,
					rs.getString("MaGiaoVien"),
					rs.getString("HoTen"),
					rs.getString("ChucDanh"),
					rs.getString("LinhVucCongTac"),
					rs.getString("KhoaCongTac"),
					rs.getString("DonViCongTac")
			};
			modelDanhSachGiaoVien.addRow(rowData);
			i++;
		}
		tableDanhSachGiaoVien.setModel(modelDanhSachGiaoVien);
		
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


	public void loadGiaoVienDuocPhanCong(String maHoiDong) throws SQLException {
		Database.getInstance().connec();
		Connection con = Database.getInstance().getConnection();
		modelGiaoVienDuocPhanCong.setRowCount(0);
		PreparedStatement st = con.prepareStatement("SELECT GIAOVIEN.MaGiaoVien, HoTen, CongViec FROM GIAOVIEN JOIN CHITIETCONGVIEC ON GIAOVIEN.MaGiaoVien = CHITIETCONGVIEC.MaGiaoVien WHERE CHITIETCONGVIEC.MaHoiDong = ?");
		st.setString(1, maHoiDong);
		ResultSet res = st.executeQuery();
		while(res.next()) {
			Object[] rowData = {
					res.getString(1),
					res.getString(2),
					res.getString(3)
			};
			modelGiaoVienDuocPhanCong.addRow(rowData);
		}
	}

	public void loadTableDanhSachGiaoVien() {
		modelDanhSachGiaoVien.setRowCount(0);
		int i = 1;
		for(GiaoVien gv : listGiaoVien) {
			Object[] rowData = {i,
					gv.getMaGiaoVien(),
					gv.getHoTen(),
					gv.getChucDanh(),
					gv.getLinhVucCongTac(),
					gv.getKhoaCongTac(),
					gv.getDonViCongTac()
			};
			modelDanhSachGiaoVien.addRow(rowData);		
			i++;
		}
	}
	public void updateTableDanhSachGiaoVien() throws SQLException  {
		GiaoVienDao gvd = new GiaoVienDao();	
		listGiaoVien = gvd.docTuBang();
	}
}

/*
 * (C) Copyright 2020 IUH. All rights reserved.
 *
 * @author: AnhTuanIT
 * @date: 05-11-2020
 * @version: 1.0
 */
