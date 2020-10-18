package gitHub;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class MainApp extends JFrame implements ActionListener {
	JMenuBar mnBar;
	JMenu mnSinhVien;
	JMenuItem mniThongTinSinhVien;
	JMenuItem mniDangKyDeTai;
	JMenuItem mniXemDiem;
	
//	public CardLayout cards = new CardLayout();
	JPanel viewPanel = new JPanel();
	
	public MainApp() {
		// Cấu hình app
		super("Quản lý luận văn");
		setSize(1280, 1024);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
//		setLayout(new BorderLayout());
		
		setContentPane(viewPanel);
		// Cài đặt menu
		mnBar = new JMenuBar();
		mnSinhVien = new JMenu("Sinh viên");
		mnBar.add(mnSinhVien);
		
		mniThongTinSinhVien = new JMenuItem("Thông tin sinh viên");
		mniDangKyDeTai = new JMenuItem("Đăng ký đề tài");
		mniXemDiem = new JMenuItem("Xem điểm");
		mnSinhVien.add(mniThongTinSinhVien);
		mnSinhVien.add(mniDangKyDeTai);
		mnSinhVien.add(mniXemDiem);
		
		setJMenuBar(mnBar);
		mniThongTinSinhVien.addActionListener(this);
		mniDangKyDeTai.addActionListener(this);
		mniXemDiem.addActionListener(this);
	}
	
	public static void main(String[] args) {
		new MainApp().setVisible(true);
	}
	
	public void switchPanel(Container container, String panelName) {
	    CardLayout card = (CardLayout) (container.getLayout());
	    card.show(container, panelName);
	}
	public JPanel getViewPanel() {
		return viewPanel;
	}
	// Chuyen String sang phanconggiaovien

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		
	}
}

