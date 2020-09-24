package test;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


public class MainApp_test extends JFrame implements ActionListener {
    private JPanel mainPanel;
	JMenuBar mnBar;
	JMenu mnQuanLy;
	JMenuItem mniQLHD;
	JMenuItem mniPCGV;
	
    public MainApp_test() {
        setTitle("Main Panel");
        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
       
        mainPanel = new JPanel();
        mainPanel.setLayout(new CardLayout());
//        mainPanel.add(new FirstPanel(mainPanel), "QLHD");
//        mainPanel.add(new SecondPanel(mainPanel), "PCGV");
        JPanel QLHD = new QLHD(mainPanel);
        JPanel PCGV = new PCGV(mainPanel);
        mainPanel.add(QLHD, "QLHD");
        mainPanel.add(PCGV, "PCGV");
        setContentPane(mainPanel);

        mnBar = new JMenuBar();
		mniPCGV = new JMenuItem("Phân công giáo viên");
		mniQLHD = new JMenuItem("Quản lý hội đồng");
		mnQuanLy = new JMenu("Quản lý");
		mnQuanLy.add(mniPCGV);
		mnQuanLy.add(mniQLHD);
		mnBar.add(mnQuanLy);
     	setJMenuBar(mnBar);
     	mniPCGV.addActionListener(this);
		mniQLHD.addActionListener(this);
    }

//   
    public void switchPanel(Container container, String panelName) {
        CardLayout card = (CardLayout) (container.getLayout());
        card.show(container, panelName);
    }

    public static void main(String[] args) {
        new MainApp_test().setVisible(true);
}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(mniQLHD)) {
			switchPanel(mainPanel, "QLHD");
		}else if(o.equals(mniPCGV)) {
			switchPanel(mainPanel, "PCGV");
		}
	}
      
}
