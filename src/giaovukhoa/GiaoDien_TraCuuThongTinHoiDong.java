package giaovukhoa;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;
import java.awt.Color;
import com.toedter.components.JLocaleChooser;

import dao.Database;
import dao.HoiDongDao;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.border.EtchedBorder;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class GiaoDien_TraCuuThongTinHoiDong implements KeyListener {

	private JFrame frame;
	private JTextField txtTimKiemHoiDong;
	private JTextField txtMaHoiDong;
	private JTextField txtTenHoiDong;
	private JTextField txtNgayBaoCao;
	private JTextField txtNgayLap;
	private JTable tableDanhSachHoiDong;
	private JTable tableDanhSachNhom;
	private JTable tableDanhSachGiaoVien;
	private DefaultTableModel modelDanhSachNhom;
	private DefaultTableModel modelGiaoVienDuocPhanCong;
	private DefaultTableModel modelDanhSachHoiDong;
	private JComboBox comboBoxTimKiemHoiDong;
	private JComboBox comboBoxNamHoc;
	private JPanel pnChung;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GiaoDien_TraCuuThongTinHoiDong window = new GiaoDien_TraCuuThongTinHoiDong();
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
	public GiaoDien_TraCuuThongTinHoiDong() throws SQLException {
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
		pnChung.setLayout(null);
		frame.getContentPane().add(pnChung, BorderLayout.CENTER);

		JLabel lblTitle = new JLabel("Tra cứu hội đồng");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTitle.setBounds(0, 0, 1262, 31);
		pnChung.add(lblTitle);

		JPanel pnCenter = new JPanel();
		pnCenter.setLayout(null);
		pnCenter.setBounds(0, 0, 1262, 872);
		pnChung.add(pnCenter);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Danh s\u00E1ch h\u1ED9i \u0111\u1ED3ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 39, 1244, 378);
		pnCenter.add(panel_1);

		JLocaleChooser localeChooser = new JLocaleChooser();
		localeChooser.setBounds(-78, 287, 57, 20);
		panel_1.add(localeChooser);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 57, 611, 304);
		panel_1.add(scrollPane);

		tableDanhSachHoiDong = new JTable();
		modelDanhSachHoiDong = new DefaultTableModel("STT,Mã Hội Đồng, Tên Hội Đồng, Ngày Lập, Ngày Chấm Báo Cáo".split(","),0);
		scrollPane.setViewportView(tableDanhSachHoiDong);
		tableDanhSachHoiDong.setModel(modelDanhSachHoiDong);
		JButton btnTimKiemHoiDong = new JButton("Tìm");
		btnTimKiemHoiDong.setBounds(416, 19, 74, 27);
		panel_1.add(btnTimKiemHoiDong);

		txtTimKiemHoiDong = new JTextField();
		txtTimKiemHoiDong.setColumns(10);
		txtTimKiemHoiDong.setBounds(35, 19, 248, 27);
		panel_1.add(txtTimKiemHoiDong);

		comboBoxTimKiemHoiDong = new JComboBox();
		comboBoxTimKiemHoiDong.setModel(new DefaultComboBoxModel(new String[] {"Chọn tiêu chí...", "Mã Hội Đồng", "Tên Hội Đồng", "Ngày Lập", "Ngày Chấm Báo Cáo"}));
		comboBoxTimKiemHoiDong.setBounds(293, 18, 113, 27);
		panel_1.add(comboBoxTimKiemHoiDong);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(631, 57, 603, 304);
		panel_1.add(panel_1_1);
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng tin h\u1ED9i \u0111\u1ED3ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));

		txtMaHoiDong = new JTextField();
		txtMaHoiDong.setEditable(false);
		txtMaHoiDong.setColumns(10);
		txtMaHoiDong.setBounds(199, 40, 349, 20);
		panel_1_1.add(txtMaHoiDong);

		JLabel lblMaHoiDong = new JLabel("Mã hội đồng: ");
		lblMaHoiDong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMaHoiDong.setBounds(40, 38, 109, 19);
		panel_1_1.add(lblMaHoiDong);

		JLabel lblTenHoiDong = new JLabel("Tên hội đồng: ");
		lblTenHoiDong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTenHoiDong.setBounds(40, 86, 109, 19);
		panel_1_1.add(lblTenHoiDong);

		txtTenHoiDong = new JTextField();
		txtTenHoiDong.setEditable(false);
		txtTenHoiDong.setColumns(10);
		txtTenHoiDong.setBounds(199, 88, 349, 20);
		panel_1_1.add(txtTenHoiDong);

		JLabel lblNgayChamBaoCao = new JLabel("Ngày chấm báo cáo:");
		lblNgayChamBaoCao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNgayChamBaoCao.setBounds(40, 171, 149, 19);
		panel_1_1.add(lblNgayChamBaoCao);

		txtNgayBaoCao = new JTextField();
		txtNgayBaoCao.setEditable(false);
		txtNgayBaoCao.setColumns(10);
		txtNgayBaoCao.setBounds(199, 173, 349, 20);
		panel_1_1.add(txtNgayBaoCao);

		JLabel lblNgayLapHoiDong = new JLabel("Ngày lập hội đồng:");
		lblNgayLapHoiDong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNgayLapHoiDong.setBounds(40, 130, 149, 19);
		panel_1_1.add(lblNgayLapHoiDong);

		txtNgayLap = new JTextField();
		txtNgayLap.setEditable(false);
		txtNgayLap.setColumns(10);
		txtNgayLap.setBounds(199, 132, 349, 20);
		panel_1_1.add(txtNgayLap);

		comboBoxNamHoc = new JComboBox();
		comboBoxNamHoc.setBounds(500, 18, 121, 27);
		panel_1.add(comboBoxNamHoc);

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Danh s\u00E1ch nh\u00F3m \u0111\u01B0\u1EE3c ch\u1EA5m", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBounds(10, 427, 622, 445);
		pnCenter.add(panel_3);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 22, 602, 395);
		panel_3.add(scrollPane_1);


		tableDanhSachNhom = new JTable();
		scrollPane_1.setViewportView(tableDanhSachNhom);
		modelDanhSachNhom = new DefaultTableModel("STT, Mã Nhóm, Mã Luận Văn, Ngày Báo Cáo, Giờ Báo Cáo".split(","),0);
		tableDanhSachNhom.setModel(modelDanhSachNhom);

		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Danh s\u00E1ch c\u00E1c gi\u00E1o vi\u00EAn trong h\u1ED9i \u0111\u1ED3ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3_1.setBounds(642, 427, 612, 445);
		pnCenter.add(panel_3_1);

		JScrollPane scrollPane_1_1 = new JScrollPane();
		scrollPane_1_1.setBounds(10, 22, 561, 395);
		panel_3_1.add(scrollPane_1_1);

		tableDanhSachGiaoVien = new JTable();
		scrollPane_1_1.setViewportView(tableDanhSachGiaoVien);
		modelGiaoVienDuocPhanCong = new DefaultTableModel("STT,Mã Giáo Viên, Tên Giáo Viên, Công Việc".split(","),0);
		tableDanhSachGiaoVien.setModel(modelGiaoVienDuocPhanCong);
		

		comboBoxNamHoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					modelDanhSachNhom.setRowCount(0);
					modelGiaoVienDuocPhanCong.setRowCount(0);
					String namHoc = comboBoxNamHoc.getSelectedItem().toString().substring(0, 4);
					txtMaHoiDong.setText("");
					txtTenHoiDong.setText("");
					txtNgayLap.setText("");
					txtNgayBaoCao.setText("");
					if(!namHoc.equals("Chọn")) {
						updateTableDanhSachHoiDong(namHoc);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		tableDanhSachHoiDong.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
				txtMaHoiDong.setText(tableDanhSachHoiDong.getValueAt(tableDanhSachHoiDong.getSelectedRow(), 1).toString());
				txtTenHoiDong.setText(tableDanhSachHoiDong.getValueAt(tableDanhSachHoiDong.getSelectedRow(), 2).toString());
				txtNgayLap.setText(tableDanhSachHoiDong.getValueAt(tableDanhSachHoiDong.getSelectedRow(), 3).toString());
				txtNgayBaoCao.setText(tableDanhSachHoiDong.getValueAt(tableDanhSachHoiDong.getSelectedRow(), 4).toString());
				updateTableDanhSachNhom();
				updateTableDanhSachGiaoVien();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		btnTimKiemHoiDong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				eventTimKiem();
			}
		});
		
		txtTimKiemHoiDong.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				if(txtTimKiemHoiDong.getText().isEmpty()) {
					try {
						String namHoc = comboBoxNamHoc.getSelectedItem().toString().substring(0, 4);
						if(!namHoc.equals("Chọn")) {
							updateTableDanhSachHoiDong(namHoc);
						}
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
		txtTimKiemHoiDong.addKeyListener(this);
		comboBoxTimKiemHoiDong.addKeyListener(this);
		comboBoxNamHoc.addKeyListener(this);
		
		capNhat();
	}
	
	public void capNhat() throws SQLException {
		updateComboBoxNamHoc();
	}
	
	public void eventTimKiem() {
		modelDanhSachHoiDong.setRowCount(0);
		String tieuChi = comboBoxTimKiemHoiDong.getSelectedItem().toString();
		String noiDungTimKiem = txtTimKiemHoiDong.getText();
		String namHoc = comboBoxNamHoc.getSelectedItem().toString().substring(0, 4); 
		if(comboBoxNamHoc.getSelectedItem().toString().equalsIgnoreCase("Chọn năm học...")) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn năm học!");
			return;
		}
		try {
			if(tieuChi.equalsIgnoreCase("Chọn tiêu chí...")) {
				JOptionPane.showMessageDialog(null, "Vui lòng chọn tiêu chí!");
				if(!namHoc.equals("Chọn")) {
					updateTableDanhSachHoiDong(namHoc);
				}
				return;
			}else if(tieuChi.equalsIgnoreCase("Mã Hội Đồng")){
				timKiemHoiDong(noiDungTimKiem, "", "", "", namHoc);
			}else if(tieuChi.equalsIgnoreCase("Tên Hội Đồng")) {
				timKiemHoiDong("", noiDungTimKiem,"" , "", namHoc);
			}else if(tieuChi.equalsIgnoreCase("Ngày Lập")) {
				timKiemHoiDong("", "", noiDungTimKiem, "", namHoc);
			}else if(tieuChi.equalsIgnoreCase("Ngày Chấm Báo Cáo")) {
				timKiemHoiDong("", "", "", noiDungTimKiem, namHoc);
			}
			if(modelDanhSachHoiDong.getRowCount() == 0) {
				JOptionPane.showMessageDialog(null, "Không tìm thấy!");
				try {
					if(!namHoc.equals("Chọn")) {
						updateTableDanhSachHoiDong(namHoc);
					}
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

	public void updateComboBoxNamHoc() throws SQLException {
		comboBoxNamHoc.setModel(new DefaultComboBoxModel<>());
		comboBoxNamHoc.addItem("Chọn năm học...");
		Connection con = Database.getInstance().getConnection();
		Statement statement = con.createStatement();
		ResultSet res = statement.executeQuery("SELECT DISTINCT YEAR(NgayLap) AS NamHoc FROM HOIDONG ORDER BY YEAR(NgayLap) ASC");
		while(res.next()) {
			int namHoc_temp = res.getInt(1) + 1;
			comboBoxNamHoc.addItem(res.getString(1) + " - " +namHoc_temp);
		}
	}
	public void updateTableDanhSachHoiDong(String namHoc) throws SQLException {
		modelDanhSachHoiDong.setRowCount(0);
		int i = 1;
		Connection con = Database.getInstance().getConnection();
		String sql = "select * from HOIDONG WHERE YEAR(NgayLap) = '"+namHoc+"'";
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
	
	public void updateTableDanhSachNhom() throws SQLException {
		Connection con = Database.getInstance().getConnection();
		modelDanhSachNhom.setRowCount(0);
		int i = 1;
		Statement st = con.createStatement();
		ResultSet res = st.executeQuery("SELECT MaNhom, MaLuanVan, CONVERT(VARCHAR(10),NgayBaoCao,120) AS [NgayBaoCao], CONVERT(VARCHAR(5),NgayBaoCao,114) AS [GioBaoCao] FROM DANHSACH_DANGKYLUANVAN WHERE MaHoiDong = '"+txtMaHoiDong.getText()+"'");
		while(res.next()) {
			Object[] rowData = {
					i,
					res.getString(1),
					res.getString(2),
					res.getString(3),
					res.getString(4),
			};
			i++;
			modelDanhSachNhom.addRow(rowData);
		}
		tableDanhSachNhom.setModel(modelDanhSachNhom);
	}
	
	public void updateTableDanhSachGiaoVien() throws SQLException {
		Connection con = Database.getInstance().getConnection();
		modelGiaoVienDuocPhanCong.setRowCount(0);
		String maHoiDong = txtMaHoiDong.getText();
		int i = 1;
		PreparedStatement st = con.prepareStatement("SELECT GIAOVIEN.MaGiaoVien, HoTen, CongViec FROM GIAOVIEN JOIN CHITIETCONGVIEC ON GIAOVIEN.MaGiaoVien = CHITIETCONGVIEC.MaGiaoVien WHERE CHITIETCONGVIEC.MaHoiDong = ?");
		st.setString(1, maHoiDong);
		ResultSet res = st.executeQuery();
		while(res.next()) {
			Object[] rowData = {
					i,
					res.getString(1),
					res.getString(2),
					res.getString(3)
			};
			i++;
			modelGiaoVienDuocPhanCong.addRow(rowData);
		}
		tableDanhSachGiaoVien.setModel(modelGiaoVienDuocPhanCong);
	}
	
	public void timKiemHoiDong(String maHoiDong, String tenHoiDong, String ngayLap, String NgayBaoCao, String namHoc) throws SQLException {
		Connection con = Database.getInstance().getConnection();
		Statement statement = con.createStatement();
		int i = 1;
		ResultSet res = statement.executeQuery("SELECT * FROM HOIDONG WHERE MaHoiDong LIKE '%"+maHoiDong+"%' AND TenHoiDong LIKE N'%"+tenHoiDong+"%' AND NgayLap LIKE '%"+ngayLap+"%' AND NgayBaoCao LIKE '%"+NgayBaoCao+"%' AND YEAR(NgayLap) = '"+namHoc+"'");
		while(res.next()) {
			Object[] rowData = {
					i,
					res.getString(1),
					res.getString(2),
					res.getString(3),
					res.getString(4)
			};
			modelDanhSachHoiDong.addRow(rowData);
			i++;
		}
		tableDanhSachHoiDong.setModel(modelDanhSachHoiDong);
	}
	public JPanel getPanel() {
		return pnChung;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			eventTimKiem();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
