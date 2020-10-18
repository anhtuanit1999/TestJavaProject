package gitHub;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;




public class QuanLiLuanVan extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel lblLinhVucNghienCuu, lblMaLuanVan, lblMaSinhVien, lblTenLuanVan, lblNoiDungLuanVan, lblTomTat, lblTieuDe;
	JTextField txtLinhVucNghienCuu, txtMaLuanVan, txtMaSinhVien, txtTenLuanVan, txtNoiDungLuanVan, txtTomTat;
	JButton btnThem, btnXoa, btnSua, btnKiemTra, btnCapNhat;
	
	DefaultTableModel tableModel;
	JTable table;
	JScrollPane scroll;
	
	JPanel panel;
	public QuanLiLuanVan() {
		super("Quản lý luận văn");
		setSize(1280,1024);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		//setVisible(true);
		Box bCenter, b0, b1, b2, b3, b4, b5, b6, b7, b8;
		bCenter = Box.createVerticalBox();
		bCenter.add(Box.createVerticalStrut(20));
		lblTieuDe = new JLabel("Quản lý luận văn");
		lblTieuDe.setFont(new Font("Arial", Font.BOLD, 20));
		b0 = Box.createHorizontalBox();
		bCenter.add(b0);
		b0.add(Box.createHorizontalStrut(20));
		b0.add(lblTieuDe, SwingConstants.CENTER);
		b0.add(Box.createHorizontalStrut(20));
		bCenter.add(Box.createVerticalStrut(20));
		
		bCenter.add(Box.createVerticalStrut(100));
		
		b1 = Box.createHorizontalBox();
		bCenter.add(b1);
		b1.add(Box.createHorizontalStrut(20));
		b1.add(lblLinhVucNghienCuu = new JLabel("Lĩnh vực nghiên cứu: "));
		b1.add(Box.createHorizontalStrut(20));
		b1.add(txtLinhVucNghienCuu = new JTextField());
		b1.add(Box.createHorizontalStrut(20));
		//b1.add(btnKiemTra = new JButton("Kiểm tra"));
		//b1.add(Box.createHorizontalStrut(20));
		bCenter.add(Box.createVerticalStrut(20));
		
		b2 = Box.createHorizontalBox();
		bCenter.add(b2);
		b2.add(Box.createHorizontalStrut(20));
		b2.add(lblMaLuanVan = new JLabel("Mã luận văn: "));
		b2.add(Box.createHorizontalStrut(20));
		b2.add(txtMaLuanVan = new JTextField());
		b2.add(Box.createHorizontalStrut(20));
		bCenter.add(Box.createVerticalStrut(20));
		
		b3 = Box.createHorizontalBox();
		bCenter.add(b3);
		b3.add(Box.createHorizontalStrut(20));
		b3.add(lblMaSinhVien = new JLabel("Mã sinh viên: "));
		b3.add(Box.createHorizontalStrut(20));
		b3.add(txtMaSinhVien = new JTextField());
		b3.add(Box.createHorizontalStrut(20));
		bCenter.add(Box.createVerticalStrut(20));
		
		b4 = Box.createHorizontalBox();
		bCenter.add(b4);
		b4.add(Box.createHorizontalStrut(20));
		b4.add(lblNoiDungLuanVan = new JLabel("Nội dung luận văn: "));
		b4.add(Box.createHorizontalStrut(20));
		b4.add(txtNoiDungLuanVan = new JTextField());
		b4.add(Box.createHorizontalStrut(20));
		bCenter.add(Box.createVerticalStrut(20));
		
		b5 = Box.createHorizontalBox();
		bCenter.add(b5);
		b5.add(Box.createHorizontalStrut(20));
		b5.add(lblTenLuanVan = new JLabel("Tên luận văn: "));
		b5.add(Box.createHorizontalStrut(20));
		b5.add(txtTenLuanVan = new JTextField());
		b5.add(Box.createHorizontalStrut(20));
		bCenter.add(Box.createVerticalStrut(20));
		
		b6 = Box.createHorizontalBox();
		bCenter.add(b6);
		b6.add(Box.createHorizontalStrut(20));
		b6.add(lblTomTat = new JLabel("Tóm tắt: "));
		b6.add(Box.createHorizontalStrut(20));
		b6.add(txtTomTat = new JTextField());
		b6.add(Box.createHorizontalStrut(20));
		bCenter.add(Box.createVerticalStrut(20));
		
//		b7 = Box.createHorizontalBox();
//		bCenter.add(b7);
//		b7.add(Box.createHorizontalStrut(20));
//		b7.add(lblNamTotNghiep = new JLabel("Năm tốt nghiệp: "));
//		b7.add(Box.createHorizontalStrut(20));
//		b7.add(txtNamTotNghiep = new JTextField());
//		b7.add(Box.createHorizontalStrut(20));
//		bCenter.add(Box.createVerticalStrut(100));
		
		b7 = Box.createHorizontalBox();
		bCenter.add(b7);
		b7.add(btnThem = new JButton("Thêm"));
		b7.add(Box.createHorizontalStrut(20));
		b7.add(btnXoa = new JButton("Xóa"));
		b7.add(Box.createHorizontalStrut(20));
		b7.add(btnSua = new JButton("Sửa"));
		b7.add(Box.createHorizontalStrut(20));
		b7.add(btnCapNhat = new JButton("Cập nhật"));
		bCenter.add(Box.createVerticalStrut(20));
		
		b8 = Box.createHorizontalBox();
		bCenter.add(b8);
		b8.add(Box.createHorizontalStrut(20));
		String[] columns = {"Lĩnh vực nghiên cứu", "Mã luận văn", "Mã sinh viên", "Nội dung", "Tên luận văn","Tóm tắt"};
		tableModel = new DefaultTableModel(columns, 0);
		b8.add(scroll = new JScrollPane(table = new JTable(tableModel)));
		b8.add(Box.createHorizontalStrut(20));
		bCenter.add(Box.createVerticalStrut(20));
		
		lblTomTat.setPreferredSize(lblLinhVucNghienCuu.getPreferredSize());
		lblMaLuanVan.setPreferredSize(lblLinhVucNghienCuu.getPreferredSize());
		lblMaSinhVien.setPreferredSize(lblLinhVucNghienCuu.getPreferredSize());
		lblNoiDungLuanVan.setPreferredSize(lblLinhVucNghienCuu.getPreferredSize());
		lblTenLuanVan.setPreferredSize(lblLinhVucNghienCuu.getPreferredSize());
		
		bCenter.setBorder(BorderFactory.createTitledBorder("Quản lý luận văn"));
		
		add(bCenter, BorderLayout.CENTER);
		
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnSua.addActionListener(this);
		btnCapNhat.addActionListener(this);
		//btnKiemTra.addActionListener(this);
		panel = new JPanel(new BorderLayout());
		panel.add(bCenter, BorderLayout.CENTER);
	}
	public static void main(String[] args) {
		new QuanLiLuanVan().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnThem)) {
			//if (!kiemTraNhap()) {
				
			//}
			
		} else if (o.equals(btnXoa)) {
			
		} else if (o.equals(btnSua)) {
			
		} else if (o.equals(btnCapNhat)) {
			
		} else if (o.equals(btnKiemTra)) {
			
		}
	}
	
	public JPanel getPanel() {
		return panel;
	}
}
	

