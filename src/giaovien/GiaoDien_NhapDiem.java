package giaovien;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashSet;
import java.util.Set;

import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.Database;
import dao.GiaoVienDao;

import javax.swing.JButton;

public class GiaoDien_NhapDiem implements MouseListener, ActionListener{

	private JFrame frame;
	private JTextField txtTenSinhVien;
	private JTextField txtDiemSo;
	private JTable table;
	private JPanel pnChung;
	private GiaoVienDao giaoVienDao;
	private JButton btnNhapDiem;
	private JTextField txtMaSinhVien;
	private JTextArea txtaGhiChu;
	private JButton btnCapNhat;
	private final String maGiaoVien = "GV002";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GiaoDien_NhapDiem window = new GiaoDien_NhapDiem();
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
	public GiaoDien_NhapDiem() {
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
		
		JLabel lblTieuDe = new JLabel("Nhập điểm");
		lblTieuDe.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		pnChung.add(lblTieuDe, BorderLayout.NORTH);
		
		JPanel pnCenter = new JPanel();
		pnChung.add(pnCenter, BorderLayout.CENTER);
		pnCenter.setLayout(null);
		
		JPanel pnThongTinSinhVien = new JPanel();
		pnThongTinSinhVien.setBorder(new TitledBorder(null, "Th\u00F4ng tin sinh vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnThongTinSinhVien.setBounds(10, 11, 656, 393);
		pnCenter.add(pnThongTinSinhVien);
		pnThongTinSinhVien.setLayout(null);
		
		JLabel lblTenSinhVien = new JLabel("Tên sinh viên: ");
		lblTenSinhVien.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTenSinhVien.setBounds(49, 50, 106, 19);
		pnThongTinSinhVien.add(lblTenSinhVien);
		
		txtTenSinhVien = new JTextField();
		txtTenSinhVien.setEditable(false);
		txtTenSinhVien.setBounds(176, 51, 416, 20);
		pnThongTinSinhVien.add(txtTenSinhVien);
		txtTenSinhVien.setColumns(10);
		
		JLabel lblDiemSo = new JLabel("Điểm số: ");
		lblDiemSo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDiemSo.setBounds(49, 119, 106, 19);
		pnThongTinSinhVien.add(lblDiemSo);
		
		txtDiemSo = new JTextField();
		txtDiemSo.setColumns(10);
		txtDiemSo.setBounds(176, 120, 416, 20);
		pnThongTinSinhVien.add(txtDiemSo);
		
		JLabel lblGhiChu = new JLabel("Ghi chú: ");
		lblGhiChu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGhiChu.setBounds(49, 166, 106, 19);
		pnThongTinSinhVien.add(lblGhiChu);
		
		txtaGhiChu = new JTextArea();
		txtaGhiChu.setBounds(176, 165, 416, 197);
		pnThongTinSinhVien.add(txtaGhiChu);
		
		JLabel lblMSinhVin = new JLabel("Mã sinh viên: ");
		lblMSinhVin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMSinhVin.setBounds(49, 87, 106, 19);
		pnThongTinSinhVien.add(lblMSinhVin);
		
		txtMaSinhVien = new JTextField();
		txtMaSinhVien.setEditable(false);
		txtMaSinhVien.setColumns(10);
		txtMaSinhVien.setBounds(176, 88, 416, 20);
		pnThongTinSinhVien.add(txtMaSinhVien);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Danh s\u00E1ch sinh vi\u00EAn b\u1EA3o v\u1EC7 lu\u1EADn v\u0103n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(676, 11, 578, 858);
		pnCenter.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 29, 558, 818);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "M\u00E3 sinh vi\u00EAn", "T\u00EAn sinh vi\u00EAn", "Lu\u1EADn v\u0103n", "\u0110i\u1EC3m s\u1ED1", "Ghi ch\u00FA"
			}
		));
		scrollPane.setViewportView(table);
		
		btnNhapDiem = new JButton("Nhập điểm");
		btnNhapDiem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNhapDiem.setBounds(211, 415, 127, 44);
		pnCenter.add(btnNhapDiem);
		
		btnCapNhat = new JButton("Cập nhật");
		btnCapNhat.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCapNhat.setBounds(394, 415, 127, 44);
		pnCenter.add(btnCapNhat);
		
		btnCapNhat.addActionListener(this);
		btnNhapDiem.addActionListener(this);
		table.addMouseListener(this);
		giaoVienDao.capNhatBang(table, maGiaoVien);
	}
	
	public JPanel getPanel() {
		return pnChung;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		txtTenSinhVien.setText(table.getValueAt(row, 2).toString());
		txtMaSinhVien.setText(table.getValueAt(row, 1).toString());
		txtDiemSo.setText(table.getValueAt(row, 4) == null ? "" : table.getValueAt(row, 4).toString());
		txtaGhiChu.setText(table.getValueAt(row, 5) == null ? "" : table.getValueAt(row, 5).toString());
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public boolean kiemTra() {
		String regex = "(10|\\d|\\d\\.\\d{0,2})";
		if(txtDiemSo.getText().trim().matches(regex)) {
			return true;
		}
		JOptionPane.showMessageDialog(frame, "Điểm là số nguyên hoặc số thực theo thang điểm 10");
		return false;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnNhapDiem)) {
			if(kiemTra()) {
				String maSinhVien = txtMaSinhVien.getText();
				float diem = Float.parseFloat(txtDiemSo.getText());
				String ghiChu = txtaGhiChu.getText();
				if(giaoVienDao.nhapDiem(maGiaoVien, maSinhVien, diem, ghiChu)) {
					JOptionPane.showMessageDialog(frame, "Nhập điểm cho sinh viên"+ txtTenSinhVien.getText() +" thành công!");
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.setNumRows(0);
					giaoVienDao.capNhatBang(table, maGiaoVien);
					return;
				}
				JOptionPane.showMessageDialog(frame, "Không thể nhập điểm cho sinh viên " + txtTenSinhVien.getText() + " 2 lần");
			}
		} else if(o.equals(btnCapNhat)) {
			if(kiemTra()) {
				String maSinhVien = txtMaSinhVien.getText();
				float diem = Float.parseFloat(txtDiemSo.getText());
				String ghiChu = txtaGhiChu.getText();
				if(giaoVienDao.suaDiem(maGiaoVien, maSinhVien, diem, ghiChu)) {
					JOptionPane.showMessageDialog(frame, "Sửa điểm cho sinh viên"+ txtTenSinhVien.getText() +" thành công!");
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.setNumRows(0);
					giaoVienDao.capNhatBang(table, maGiaoVien);
					return;
				}
				JOptionPane.showMessageDialog(frame, "Đã sửa điểm cho sinh viên " + txtTenSinhVien.getText());
			}
		}
		
	}
}
