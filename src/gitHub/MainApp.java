package gitHub;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

public class MainApp extends JFrame implements ActionListener {
	JMenuBar mnBar;
	JMenu mnQuanLy;
	JMenuItem mniQLSV;
	CardLayout cards;
	public MainApp() {
		// Cấu hình app
		super("Quản lý luận văn");
		setSize(1280, 1024);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		// Card Layout
		cards = new CardLayout();
		
		// Cài đặt menu
		mnBar = new JMenuBar();
		mnQuanLy = new JMenu("Quản lý");
		mnBar.add(mnQuanLy);
		
		mniQLSV = new JMenuItem("Quản lý sinh viên");
		mnQuanLy.add(mniQLSV);
		
		setJMenuBar(mnBar);
	}
	
	public static void main(String[] args) {
		new MainApp().setVisible(true);;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(mniQLSV)) {
//			cards.show(parent, name);
		}
		
	}
}

