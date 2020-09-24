package hoiDong;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

import giaoVien.QuanLyGiaoVien;
import gitHub.MainApp;

public class QuanLyHoiDong extends JFrame implements ActionListener {
	private JLabel lblTenHoiDong, lblThoiGianThanhLap, lblTieuDe;
	private JTextField txtTenHoiDong, txtThoiGianThanhLap;
	private JButton btnThem, btnXoa, btnSua, btnKiemTra, btnCapNhat, btnPhanCong;
	
	private DefaultTableModel tableModel;
	private JTable table;
	private JScrollPane scroll;
	private JPanel panel;
	Box bCenter;
	private JPanel mainPanel;
	MainApp mainApp;
	public QuanLyHoiDong(MainApp mainApp) {
		super("Quản lý Hội Đồng");
//		this.mainPanel = mainPanel;
		this.mainApp = mainApp;
		setSize(1000, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		Box b0, b1, b2, b3, b4, b5, b6, b7, b8, b9;
		bCenter = Box.createVerticalBox();
		bCenter.add(Box.createVerticalStrut(20));
		lblTieuDe = new JLabel("Quản lý Hội Đồng");
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
//		b1.add(btnKiemTra = new JButton("Kiểm tra"));
//		b1.add(Box.createHorizontalStrut(20));
		bCenter.add(Box.createVerticalStrut(20));
		
		b2 = Box.createHorizontalBox();
		bCenter.add(b2);
		b2.add(Box.createHorizontalStrut(20));
		b2.add(lblThoiGianThanhLap = new JLabel("Thời gian thành lập: "));
		b2.add(Box.createHorizontalStrut(20));
		b2.add(txtThoiGianThanhLap = new JTextField());
		b2.add(Box.createHorizontalStrut(20));
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
		b6.add(btnPhanCong = new JButton("Phân công giáo viên"));
		b6.add(Box.createHorizontalStrut(20));
		bCenter.add(Box.createVerticalStrut(20));
		
		b7 = Box.createHorizontalBox();
		bCenter.add(b7);
		b7.add(Box.createHorizontalStrut(20));
		String[] columns = {"Tên Hội Đồng", "Thời gian thành lậpqqq"};
		tableModel = new DefaultTableModel(columns, 0);
		b7.add(scroll = new JScrollPane(table = new JTable(tableModel)));
		b7.add(Box.createHorizontalStrut(20));
		bCenter.add(Box.createVerticalStrut(20));
		
		lblTenHoiDong.setPreferredSize(lblThoiGianThanhLap.getPreferredSize());
		
		bCenter.setBorder(BorderFactory.createTitledBorder("Quản lý Hội Đồng"));
		
//		mainPanel.add(bCenter);
		add(bCenter, BorderLayout.CENTER);
//		panel = new JPanel(new BorderLayout());
//		panel.add(bCenter, BorderLayout.CENTER);
		
		btnPhanCong.addActionListener(this);
	
	}
	
//	public static void main(String[] args) {
//		new QuanLyHoiDong().setVisible(true);
//	}
//	
	public JPanel getPanel() {
		panel = new JPanel(new BorderLayout());
		panel.add(bCenter, BorderLayout.CENTER);
		return panel;
		
	}
	
	public boolean kiemTra() {
		if (!txtTenHoiDong.getText().trim().matches("[A-Z][a-z]+(\\s[A-Z][a-z]*)*")) {
			txtTenHoiDong.requestFocus();
			txtTenHoiDong.selectAll();
			JOptionPane.showMessageDialog(this, "Các ký tự đầu phải là chữ in hoa, mỗi từ cách nhau bởi dấu cách");
			return false;
		}
		return true;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnPhanCong)) {
			if (kiemTra()) {
				mainApp.switchPanel(mainApp.getViewPanel(),"PCGV");
				mainApp.tranferString(txtTenHoiDong.getText());
			}
		}
	}
}

