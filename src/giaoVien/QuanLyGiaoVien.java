package giaoVien;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class QuanLyGiaoVien extends JFrame {
	
	private JLabel lblChucDanh, lblHoTen, lblLinhVucCongTac, lblDonViCongTac, lblKhoaCongTac, lblTieuDe;
	private JTextField txtChucDanh, txtHoTen, txtLinhVucCongTac, txtDonViCongTac, txtKhoaCongTac;
	private JButton btnThem, btnXoa, btnSua, btnKiemTra, btnCapNhat;
	
	private DefaultTableModel tableModel;
	private JTable table;
	private JScrollPane scroll;
	
	private JPanel panel;
	Box bCenter;
	public QuanLyGiaoVien() {
		super("Quản lý giáo viên");
		setSize(1280, 1024);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		Box b0, b1, b2, b3, b4, b5, b6, b7, b8, b9;
		bCenter = Box.createVerticalBox();
		bCenter.add(Box.createVerticalStrut(20));
		lblTieuDe = new JLabel("Quản lý giáo viên");
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
		b1.add(lblChucDanh = new JLabel("Chức danh: "));
		b1.add(Box.createHorizontalStrut(20));
		b1.add(txtChucDanh = new JTextField());
		b1.add(Box.createHorizontalStrut(20));
//		b1.add(btnKiemTra = new JButton("Kiểm tra"));
//		b1.add(Box.createHorizontalStrut(20));
		bCenter.add(Box.createVerticalStrut(20));
		
		b2 = Box.createHorizontalBox();
		bCenter.add(b2);
		b2.add(Box.createHorizontalStrut(20));
		b2.add(lblHoTen = new JLabel("Họ tên: "));
		b2.add(Box.createHorizontalStrut(20));
		b2.add(txtHoTen = new JTextField());
		b2.add(Box.createHorizontalStrut(20));
		bCenter.add(Box.createVerticalStrut(20));
		
		b3 = Box.createHorizontalBox();
		bCenter.add(b3);
		b3.add(Box.createHorizontalStrut(20));
		b3.add(lblLinhVucCongTac = new JLabel("Lĩnh vực công tác: "));
		b3.add(Box.createHorizontalStrut(20));
		b3.add(txtLinhVucCongTac = new JTextField());
		b3.add(Box.createHorizontalStrut(20));
		bCenter.add(Box.createVerticalStrut(20));
		
		b4 = Box.createHorizontalBox();
		bCenter.add(b4);
		b4.add(Box.createHorizontalStrut(20));
		b4.add(lblDonViCongTac = new JLabel("Đơn vị công tác: "));
		b4.add(Box.createHorizontalStrut(20));
		b4.add(txtDonViCongTac = new JTextField());
		b4.add(Box.createHorizontalStrut(20));
		bCenter.add(Box.createVerticalStrut(20));
		
		b5 = Box.createHorizontalBox();
		bCenter.add(b5);
		b5.add(Box.createHorizontalStrut(20));
		b5.add(lblKhoaCongTac = new JLabel("Khoa công tác: "));
		b5.add(Box.createHorizontalStrut(20));
		b5.add(txtKhoaCongTac = new JTextField());
		b5.add(Box.createHorizontalStrut(20));
		bCenter.add(Box.createVerticalStrut(20));
		
		b6 = Box.createHorizontalBox();
		bCenter.add(b6);
		b6.add(btnThem = new JButton("Thêm"));
		b6.add(Box.createHorizontalStrut(20));
		b6.add(btnXoa = new JButton("Xóa"));
		b6.add(Box.createHorizontalStrut(20));
		b6.add(btnSua = new JButton("Sửa"));
		b6.add(Box.createHorizontalStrut(20));
//		b6.add(btnCapNhat = new JButton("Cập nhật"));
		bCenter.add(Box.createVerticalStrut(20));
		
		b7 = Box.createHorizontalBox();
		bCenter.add(b7);
		b7.add(Box.createHorizontalStrut(20));
		String[] columns = {"Chức danh", "Họ tên", "Lĩnh vực công tác", "Đơn vị công tác", "Khoa công tác"};
		tableModel = new DefaultTableModel(columns, 0);
		b7.add(scroll = new JScrollPane(table = new JTable(tableModel)));
		b7.add(Box.createHorizontalStrut(20));
		bCenter.add(Box.createVerticalStrut(20));
		
		lblChucDanh.setPreferredSize(lblLinhVucCongTac.getPreferredSize());
		lblHoTen.setPreferredSize(lblLinhVucCongTac.getPreferredSize());
		lblDonViCongTac.setPreferredSize(lblLinhVucCongTac.getPreferredSize());
		lblKhoaCongTac.setPreferredSize(lblLinhVucCongTac.getPreferredSize());
		
		bCenter.setBorder(BorderFactory.createTitledBorder("Quản lý giáo viên"));
		
		add(bCenter, BorderLayout.CENTER);
		
	}
	
	public static void main(String[] args) {
		new QuanLyGiaoVien().setVisible(true);
	}
	
	public JPanel getPanel() {
		panel = new JPanel(new BorderLayout());
		panel.add(bCenter, BorderLayout.CENTER);
		return panel;
	}
}
