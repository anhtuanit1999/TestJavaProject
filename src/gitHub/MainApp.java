 package gitHub;

import java.awt.BorderLayout;
import java.awt.CardLayout;
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
	JMenu mnQuanLy;
	JMenuItem mniQLSV;
	JMenuItem mniQLLV;
	
	CardLayout cards;
	JPanel panel;
	public MainApp() {
		// Cấu hình app
		super("Quản lý luận văn");
		setSize(1280, 1024);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		// Card Layout
//		setLayout(cards = new CardLayout());
		panel = new JPanel(cards = new CardLayout());
		
		// Cài đặt menu
		mnBar = new JMenuBar();
		mnQuanLy = new JMenu("Quản lý");
		mnBar.add(mnQuanLy);
		
		mniQLSV = new JMenuItem("Quản lý sinh viên");
		mnQuanLy.add(mniQLSV);

		panel.add(new QuanLySinhVien().getPanel(), "QLSV");
		
		mniQLLV = new JMenuItem("Quản lý luận văn");
		mnQuanLy.add(mniQLLV);

		panel.add(new QuanLiLuanVan().getPanel(), "QLLV");
		
		mniQLLV.addActionListener(this);
		mniQLSV.addActionListener(this);
		
		add(panel, BorderLayout.CENTER);
		
		setJMenuBar(mnBar);
	}
	
	public static void main(String[] args) {
		new MainApp().setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(mniQLSV)) {
			cards.show(panel, "QLSV");
			System.out.println("hihi");
		}else if(o.equals(mniQLLV)) {
			cards.show(panel, "QLLV");
			System.out.println("hoho");
		}
		
	}
}

