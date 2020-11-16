package sinhVien;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.Database;
import entity.LuanVan;

import javax.swing.ListSelectionModel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class GiaoDien_DangKyDeTai {

	private JFrame frame;
	private JTable table;
	private JTextField txtMaDeTai;
	private JTextField txtTenDeTai;
	private JTextField txtTenSinhVien;
	private JTextField txtMSSV;
	private JPanel pnChung;
	private JTextField txtMaNhom;
	private JTextField txtTimKiem;
	private JTextField txtGiaoVienHuongDan;
	private JTextField txtKhoaTrucThuoc;
	private DefaultTableModel tableModel;
	private ArrayList<LuanVan> listLuanVan;
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
	 * @throws SQLException 
	 */
	public GiaoDien_DangKyDeTai() throws SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 */
	private void initialize() throws SQLException {
		Database.getInstance().connec();
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
		scrollPane.setBounds(10, 74, 653, 469);
		pnCenter.add(scrollPane);

		table = new JTable();
		tableModel = new DefaultTableModel("STT, Mã Đề Tài, Tên Đề Tài, Lĩnh Vực Nghiên Cứu, Năm Học, Giáo Viên Hướng Dẫn, Số Nhóm Đăng Ký Tối Đa, Số Nhóm Đã Đăng Ký".split(","),0);
		table.setModel(tableModel);
		scrollPane.setViewportView(table);

		JPanel pnDeTai = new JPanel();
		pnDeTai.setBorder(new TitledBorder(null, "Ch\u1ECDn \u0111\u1EC1 t\u00E0i", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnDeTai.setBounds(673, 74, 581, 469);
		pnCenter.add(pnDeTai);
		pnDeTai.setLayout(null);

		JLabel lblMaDeTai = new JLabel("Mã đề tài: ");
		lblMaDeTai.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMaDeTai.setBounds(32, 246, 93, 14);
		pnDeTai.add(lblMaDeTai);

		txtMaDeTai = new JTextField();
		txtMaDeTai.setEditable(false);
		txtMaDeTai.setBounds(186, 246, 362, 20);
		pnDeTai.add(txtMaDeTai);
		txtMaDeTai.setColumns(10);

		JLabel lblTenDeTai = new JLabel("Tên đề tài: ");
		lblTenDeTai.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTenDeTai.setBounds(32, 297, 93, 14);
		pnDeTai.add(lblTenDeTai);

		txtTenDeTai = new JTextField();
		txtTenDeTai.setEditable(false);
		txtTenDeTai.setBounds(186, 294, 362, 20);
		pnDeTai.add(txtTenDeTai);
		txtTenDeTai.setColumns(10);

		JButton btnDangKy = new JButton("Đăng ký");

		btnDangKy.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnDangKy.setBounds(240, 395, 164, 33);
		pnDeTai.add(btnDangKy);

		JLabel lblTenSinhVien = new JLabel("Tên sinh viên: ");
		lblTenSinhVien.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTenSinhVien.setBounds(32, 157, 116, 14);
		pnDeTai.add(lblTenSinhVien);

		txtTenSinhVien = new JTextField();
		txtTenSinhVien.setEditable(false);
		txtTenSinhVien.setBounds(186, 155, 362, 20);
		pnDeTai.add(txtTenSinhVien);
		txtTenSinhVien.setColumns(10);

		JLabel lblMSSV = new JLabel("MSSV: ");
		lblMSSV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMSSV.setBounds(32, 62, 93, 14);
		pnDeTai.add(lblMSSV);

		txtMSSV = new JTextField();
		txtMSSV.setEditable(false);
		txtMSSV.setBounds(186, 59, 362, 20);
		pnDeTai.add(txtMSSV);
		txtMSSV.setColumns(10);

		JLabel lblMaNhom = new JLabel("Mã Nhóm:");
		lblMaNhom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMaNhom.setBounds(32, 109, 116, 14);
		pnDeTai.add(lblMaNhom);

		txtMaNhom = new JTextField();
		txtMaNhom.setColumns(10);
		txtMaNhom.setBounds(186, 109, 362, 20);
		pnDeTai.add(txtMaNhom);

		JLabel lblGiaoVienHuongDan = new JLabel("Giáo viên hướng dẫn:");
		lblGiaoVienHuongDan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGiaoVienHuongDan.setBounds(32, 341, 152, 21);
		pnDeTai.add(lblGiaoVienHuongDan);

		txtGiaoVienHuongDan = new JTextField();
		txtGiaoVienHuongDan.setEditable(false);
		txtGiaoVienHuongDan.setColumns(10);
		txtGiaoVienHuongDan.setBounds(186, 342, 362, 20);
		pnDeTai.add(txtGiaoVienHuongDan);

		JLabel lblKhoaTrucThuoc = new JLabel("Khoa trực thuộc:");
		lblKhoaTrucThuoc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblKhoaTrucThuoc.setBounds(32, 199, 116, 20);
		pnDeTai.add(lblKhoaTrucThuoc);

		txtKhoaTrucThuoc = new JTextField();
		txtKhoaTrucThuoc.setColumns(10);
		txtKhoaTrucThuoc.setBounds(186, 200, 362, 20);
		pnDeTai.add(txtKhoaTrucThuoc);

		txtTimKiem = new JTextField();
		txtTimKiem.setBounds(169, 36, 258, 25);
		pnCenter.add(txtTimKiem);
		txtTimKiem.setColumns(10);

		JButton btnTimKiem = new JButton("Tìm");
		btnTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTimKiem.setBounds(583, 36, 80, 28);
		pnCenter.add(btnTimKiem);

		JComboBox comboBoxTimKiem = new JComboBox();
		comboBoxTimKiem.setModel(new DefaultComboBoxModel(new String[] {"Chọn tiêu chí...", "Mã đề tài", "Tên đề tài", "Giáo viên hướng dẫn"}));
		comboBoxTimKiem.setBounds(435, 36, 138, 25);
		pnCenter.add(comboBoxTimKiem);

		JButton btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLamMoi.setBounds(10, 36, 89, 28);
		pnCenter.add(btnLamMoi);

		txtKhoaTrucThuoc.setText("Công Nghệ Thông Tin");
		txtMaNhom.setText("NH001");
		btnLamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					updateTableData();
					loadTable();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
		});

		btnDangKy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String maNhom = txtMaNhom.getText().toString();
				String maDeTai = txtMaDeTai.getText();
				try {
					Connection con = Database.getInstance().getConnection();
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery("SELECT MaNhom, MaLuanVan FROM DANHSACH_DANGKYLUANVAN WHERE MaNhom = '"+maNhom+"'");
					while(rs.next()) {
						if(rs.getString(2) != null) {
							JOptionPane.showMessageDialog(null, "Nhóm đã đăng ký luận văn trước đó. Nếu muốn sửa đổi, liên hệ Giáo Vụ Khoa.");
							return;
						}
					}

					stmt.executeUpdate("UPDATE DANHSACH_DANGKYLUANVAN SET MaLuanVan = '"+maDeTai+"' WHERE MaNhom = '"+maNhom+"'");
					JOptionPane.showMessageDialog(null, "Đăng Ký Thành Công!");
					updateTableData();
					loadTable();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		});

		table.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				int row = table.getSelectedRow();
				txtMaDeTai.setText(table.getValueAt(row, 1).toString());
				txtTenDeTai.setText(table.getValueAt(row, 2).toString());
				txtGiaoVienHuongDan.setText(table.getValueAt(row, 5).toString());
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tableModel.setRowCount(0);
				String tieuChi = comboBoxTimKiem.getSelectedItem().toString();
				String noiDungTimKiem = txtTimKiem.getText();
				int i = 1;
				if(tieuChi.equalsIgnoreCase("Chọn tiêu chí...")) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn tiêu chí!");
					loadTable();	
				}else if(tieuChi.equalsIgnoreCase("Mã đề tài")){
					for(LuanVan lv : listLuanVan) {
						if(lv.getMaLuanVan().equalsIgnoreCase(noiDungTimKiem)) {
							Object[] rowData = {
									i,
									lv.getMaLuanVan(),
									lv.getTenLuanVan(),
									lv.getLinhVucNghienCuu(),
									lv.getNamHoc(),
									lv.getTenGiaoVien(),
									lv.getSoNhomThamGiaToiDa(),
									lv.getSoNhomDangKy()
							};
							i++;
							tableModel.addRow(rowData);
						}	
					}
					if(tableModel.getRowCount() == 0) {
						JOptionPane.showMessageDialog(null, "Không tìm thấy!");
						loadTable();
					}
				}else if(tieuChi.equalsIgnoreCase("Tên đề tài")) {
					for(LuanVan lv : listLuanVan) {
						if(lv.getTenLuanVan().equalsIgnoreCase(noiDungTimKiem)) {
							Object[] rowData = {
									i,
									lv.getMaLuanVan(),
									lv.getTenLuanVan(),
									lv.getLinhVucNghienCuu(),
									lv.getNamHoc(),
									lv.getTenGiaoVien(),
									lv.getSoNhomThamGiaToiDa(),
									lv.getSoNhomDangKy()
							};
							i++;
							tableModel.addRow(rowData);
						}	
					}
					if(tableModel.getRowCount() == 0) {
						JOptionPane.showMessageDialog(null, "Không tìm thấy!");
						loadTable();
					}
				}else if(tieuChi.equalsIgnoreCase("Giáo viên hướng dẫn")) {
					for(LuanVan lv : listLuanVan) {
						if(lv.getTenGiaoVien().equalsIgnoreCase(noiDungTimKiem)) {
							Object[] rowData = {
									i,
									lv.getMaLuanVan(),
									lv.getTenLuanVan(),
									lv.getLinhVucNghienCuu(),
									lv.getNamHoc(),
									lv.getTenGiaoVien(),
									lv.getSoNhomThamGiaToiDa(),
									lv.getSoNhomDangKy()
							};
							i++;
							tableModel.addRow(rowData);
						}	
					}
					if(tableModel.getRowCount() == 0) {
						JOptionPane.showMessageDialog(null, "Không tìm thấy!");
						loadTable();
					}
				}
			}
		});
		
		txtTimKiem.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				if(txtTimKiem.getText().trim().length() == 0) {
					loadTable();
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

		updateTableData();
		loadTable();

	}

	public JPanel getPanel() {
		return pnChung;
	}

	private void loadTable() {
		tableModel.setRowCount(0);
		int i = 1;
		for(LuanVan lv:listLuanVan) {
			Object[] rowData = {
					i,
					lv.getMaLuanVan(),
					lv.getTenLuanVan(),
					lv.getLinhVucNghienCuu(),
					lv.getNamHoc(),
					lv.getTenGiaoVien(),
					lv.getSoNhomThamGiaToiDa(),
					lv.getSoNhomDangKy()
			};
			i++;
			tableModel.addRow(rowData);
		}
	}
	private void updateTableData() throws SQLException {
		int index = 1;
		int row = 0;
		listLuanVan = new ArrayList<LuanVan>();
		String linhVucNghienCuu = txtKhoaTrucThuoc.getText();
		String maLuanVan, tenLuanVan, tenGiaoVien;
		int namHoc, soNhomToiDa, soNhomDangKy;
		Connection con = Database.getInstance().getConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT LUANVAN.MaLuanVan, TenLuanVan, LinhVucNghienCuu, NamHoc, GIAOVIEN.HoTen, SoNhomThamGiaToiDa FROM LUANVAN JOIN GIAOVIEN ON LUANVAN.MaGiaoVien = GIAOVIEN.MaGiaoVien WHERE LinhVucNghienCuu = N'"+linhVucNghienCuu+"'");
		
		try {
			while(rs.next()) {
				Statement stmt_2 = con.createStatement();
				ResultSet rs_2 = stmt_2.executeQuery("SELECT COUNT(MaLuanVan) AS SoNhomDangKy FROM DANHSACH_DANGKYLUANVAN WHERE MaLuanVan = '"+rs.getString("MaLuanVan")+"'");
				rs_2.next();
				soNhomDangKy = rs_2.getInt("SoNhomDangKy");
				maLuanVan = rs.getString("MaLuanVan");
				tenLuanVan = rs.getString("TenLuanVan");
				namHoc = rs.getInt("NamHoc");
				tenGiaoVien = rs.getString("HoTen");
				soNhomToiDa = rs.getInt("SoNhomThamGiaToiDa");
				LuanVan lv = new LuanVan(maLuanVan, tenLuanVan, linhVucNghienCuu, namHoc, tenGiaoVien, soNhomToiDa, soNhomDangKy);
				listLuanVan.add(lv);
			}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		};
	}

}
