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

import giaoVien.QuanLyGiaoVien;
import hoiDong.PhanCongGiaoVien;
import hoiDong.QuanLyHoiDong;

public class MainApp extends JFrame implements ActionListener {
	JMenuBar mnBar;
	JMenu mnQuanLy;
	JMenuItem mniQLSV;
	JMenuItem mniQLGV;
	JMenuItem mniQLHD;
//	public CardLayout cards = new CardLayout();
	JPanel viewPanel = new JPanel();
	
	public MainApp() {
		// Cấu hình app
		super("Quản lý luận văn");
		setSize(1280, 1024);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
//		setLayout(new BorderLayout());
		
		viewPanel.setLayout(new CardLayout());
		viewPanel.add(new QuanLySinhVien().getPanel(), "QLSV");
		viewPanel.add(new QuanLyGiaoVien().getPanel(), "QLGV");
		viewPanel.add(new QuanLyHoiDong().getPanel(), "QLHD");
//		viewPanel.add(new PhanCongGiaoVien(viewPanel), "PCGV");
		setContentPane(viewPanel);
		// Cài đặt menu
		mnBar = new JMenuBar();
		mnQuanLy = new JMenu("Quản lý");
		mnBar.add(mnQuanLy);
		
		mniQLSV = new JMenuItem("Quản lý sinh viên");
		mniQLGV = new JMenuItem("Quản lý giáo viên");
		mniQLHD = new JMenuItem("Quản lý hội đồng");
		mnQuanLy.add(mniQLGV);
		mnQuanLy.add(mniQLSV);
		mnQuanLy.add(mniQLHD);
		
		setJMenuBar(mnBar);
		mniQLSV.addActionListener(this);
		mniQLGV.addActionListener(this);
		mniQLHD.addActionListener(this);
	}
	
	public static void main(String[] args) {
		new MainApp().setVisible(true);
	}
	
	public void switchPanel(Container container, String panelName) {
	    CardLayout card = (CardLayout) (container.getLayout());
	    card.show(container, panelName);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(mniQLSV)) {
			switchPanel(viewPanel,"QLSV");
		}else if(o.equals(mniQLGV)) {
			switchPanel(viewPanel,"QLGV");
		}else if(o.equals(mniQLHD)) {
//			((CardLayout)viewPanel.getLayout()).show(viewPanel, "QLHD");
			switchPanel(viewPanel,"QLHD");
		}
//		
	}
}

