package hethong;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.TitledBorder;

import giaodienchinh.GiaoDienChinh;
import giaodienchinh.GiaoDien_DangNhap;

import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GiaoDien_DangXuat implements ActionListener {

	private JFrame frame;
	private JPanel pnChung;
	private JButton btnDangXuat;
	private GiaoDienChinh giaoDienChinh;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GiaoDien_DangXuat window = new GiaoDien_DangXuat(new GiaoDienChinh("SV001"));
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GiaoDien_DangXuat(GiaoDienChinh giaoDienChinh) {
		this.giaoDienChinh = giaoDienChinh;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1280, 950);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		 pnChung = new JPanel();
		frame.getContentPane().add(pnChung);
		pnChung.setLayout(new BorderLayout(0, 0));
		
		JLabel lblDangXuat = new JLabel("Hệ Thống");
		lblDangXuat.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblDangXuat.setHorizontalAlignment(SwingConstants.CENTER);
		pnChung.add(lblDangXuat, BorderLayout.NORTH);
		
		JPanel pnCenter = new JPanel();
		pnChung.add(pnCenter, BorderLayout.CENTER);
		pnCenter.setLayout(null);
		
		JPanel pnDangXuat = new JPanel();
		pnDangXuat.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u0110\u0103ng Xu\u1EA5t", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		pnDangXuat.setBounds(409, 79, 449, 237);
		pnCenter.add(pnDangXuat);
		pnDangXuat.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Đăng Xuất Hệ Thống");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(166, 52, 125, 23);
		pnDangXuat.add(lblNewLabel);
		
		btnDangXuat = new JButton("Đăng Xuất");
		btnDangXuat.setForeground(Color.BLACK);
		btnDangXuat.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnDangXuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDangXuat.setBounds(177, 126, 114, 46);
		pnDangXuat.add(btnDangXuat);
		
		btnDangXuat.addActionListener(this);
	}
	public JPanel getPanel() {
		return pnChung;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnDangXuat)) {
			if (JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn đăng xuất?", "WARNING",
			        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				JOptionPane.showMessageDialog(frame, "Đăng xuất thành công");
				GiaoDien_DangNhap giaoDien_DangNhap = new GiaoDien_DangNhap();
				giaoDien_DangNhap.frame.setVisible(true);
				giaoDienChinh.frame.dispose();
				frame.dispose();
			}
		}
		
	}
}
