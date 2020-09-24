package test;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QLHD extends JPanel implements ActionListener {

	private JLabel lblTenHoiDong, lblThoiGianThanhLap, lblTieuDe;
	private JTextField txtTenHoiDong = new JTextField(80);
	private JTextField txtThoiGianThanhLap = new JTextField(80);
	private JButton btnThem, btnXoa, btnSua, btnKiemTra, btnCapNhat, btnPhanCong;
	
	private DefaultTableModel tableModel;
	private JTable table;
	private JScrollPane scroll;
	private JPanel panel;
	Box bCenter;
    private JPanel mainPanel;
    public String info;
    
    
    
    public QLHD(JPanel mainPanel) {
        this.mainPanel = mainPanel;
 
		
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
		
		bCenter.add(Box.createVerticalStrut(70));
		
		b1 = Box.createHorizontalBox();
		bCenter.add(b1);
		b1.add(Box.createHorizontalStrut(20));
		b1.add(lblTenHoiDong = new JLabel("Tên Hội Đồng: "));
		b1.add(Box.createHorizontalStrut(20));
		b1.add(txtTenHoiDong);
		b1.add(Box.createHorizontalStrut(20));
//		b1.add(btnKiemTra = new JButton("Kiểm tra"));
//		b1.add(Box.createHorizontalStrut(20));
		bCenter.add(Box.createVerticalStrut(20));
		
		b2 = Box.createHorizontalBox();
		bCenter.add(b2);
		b2.add(Box.createHorizontalStrut(20));
		b2.add(lblThoiGianThanhLap = new JLabel("Thời gian thành lập: "));
		b2.add(Box.createHorizontalStrut(20));
		b2.add(txtThoiGianThanhLap);
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
		String[] columns = {"Tên Hội Đồng", "Thời gian thành lập"};
		tableModel = new DefaultTableModel(columns, 0);
		b7.add(scroll = new JScrollPane(table = new JTable(tableModel)));
		b7.add(Box.createHorizontalStrut(20));
		bCenter.add(Box.createVerticalStrut(20));
		
		lblTenHoiDong.setPreferredSize(lblThoiGianThanhLap.getPreferredSize());
		
		add(bCenter);
		btnPhanCong.addActionListener(this);
		
    }
    
    
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnPhanCong)) {
			MainApp_test main = new MainApp_test();
            main.switchPanel(mainPanel, "PCGV");
            String text = txtTenHoiDong.getText();
            PCGV pcgv = new PCGV(mainPanel);
            pcgv.setTextTest(text);
		}
	}
}
	
	
    	
    


