package hoiDong;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class PhanCongGiaoVien extends JFrame {
	private JLabel lblTenHoiDong, lblTenGiaoVien, lblNhiemVu, lblTieuDe;
	private JTextField txtTenHoiDong, txtThoiGianThanhLap;
	private JButton btnThem, btnXoa, btnSua, btnKiemTra, btnCapNhat;
	
	private DefaultTableModel tableModel;
	private JTable table;
	private JScrollPane scroll;
	private JComboBox cbGiaoVien, cbNhiemVu;
	private DefaultComboBoxModel giaoVienModel, nhiemVuModel;
	
	private JPanel panel;
	Box bCenter;
	public JPanel mainPanel;
	public PhanCongGiaoVien(JPanel mainPanel) {
		super("Phân công giáo viên");
		this.mainPanel = mainPanel;
		setSize(1000, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		Box b0, b1, b2, b3, b4, b5, b6, b7, b8, b9;
		bCenter = Box.createVerticalBox();
		bCenter.add(Box.createVerticalStrut(20));
		lblTieuDe = new JLabel("Phân công giáo viên");
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
		b1.add(lblTenHoiDong = new JLabel("Tên Hội Đồng: "));
		b1.add(Box.createHorizontalStrut(20));
		b1.add(txtTenHoiDong = new JTextField());
		b1.add(Box.createHorizontalStrut(20));
		txtTenHoiDong.setEditable(false);
//		b1.add(btnKiemTra = new JButton("Kiểm tra"));
//		b1.add(Box.createHorizontalStrut(20));
		bCenter.add(Box.createVerticalStrut(20));
		
		b2 = Box.createHorizontalBox();
		bCenter.add(b2);
		b2.add(Box.createHorizontalStrut(20));
		b2.add(lblTenGiaoVien = new JLabel("Tên giáo viên: "));
		b2.add(Box.createHorizontalStrut(20));
		b2.add(cbGiaoVien = new JComboBox());
		giaoVienModel = new DefaultComboBoxModel();
		giaoVienModel.addElement("Nguyễn Văn A");
		cbGiaoVien.setModel(giaoVienModel);
		b2.add(Box.createHorizontalStrut(20));
		bCenter.add(Box.createVerticalStrut(20));
		
		b3 = Box.createHorizontalBox();
		bCenter.add(b3);
		b3.add(Box.createHorizontalStrut(20));
		b3.add(lblNhiemVu = new JLabel("Nhiệm vụ: "));
		b3.add(Box.createHorizontalStrut(20));
		b3.add(cbNhiemVu = new JComboBox());
		nhiemVuModel = new DefaultComboBoxModel();
		nhiemVuModel.addElement("Chủ tịch Hội Đồng");
		cbNhiemVu.setModel(nhiemVuModel);
		b3.add(Box.createHorizontalStrut(20));
		bCenter.add(Box.createVerticalStrut(20));
		
		
		b6 = Box.createHorizontalBox();
		bCenter.add(b6);
		b6.add(btnThem = new JButton("Phân Công"));
		b6.add(Box.createHorizontalStrut(20));
//		b6.add(btnXoa = new JButton("Xóa"));
//		b6.add(Box.createHorizontalStrut(20));
//		b6.add(btnSua = new JButton("Sửa"));
//		b6.add(Box.createHorizontalStrut(20));
////		b6.add(btnCapNhat = new JButton("Cập nhật"));
//		b6.add(btnSua = new JButton("Phân công giáo viên"));
//		b6.add(Box.createHorizontalStrut(20));
		bCenter.add(Box.createVerticalStrut(20));
		
		b7 = Box.createHorizontalBox();
		bCenter.add(b7);
		b7.add(Box.createHorizontalStrut(20));
		String[] columns = {"Tên giáo viên", "Nhiệm vụ"};
		tableModel = new DefaultTableModel(columns, 0);
		b7.add(scroll = new JScrollPane(table = new JTable(tableModel)));
		b7.add(Box.createHorizontalStrut(20));
		bCenter.add(Box.createVerticalStrut(20));
		
		lblNhiemVu.setPreferredSize(lblTenGiaoVien.getPreferredSize());
//		lblTenHoiDong.setPreferredSize(lblTenGiaoVien.getPreferredSize());
		bCenter.setBorder(BorderFactory.createTitledBorder("Quản lý Hội Đồng"));
		
		add(bCenter, BorderLayout.CENTER);
		
		
	}
	
//	public static void main(String[] args) {
//		new PhanCongGiaoVien().setVisible(true);
//	}
	
	public JPanel getPanel() {
		panel = new JPanel(new BorderLayout());
		panel.add(bCenter, BorderLayout.CENTER);
		return panel;
	}
}
