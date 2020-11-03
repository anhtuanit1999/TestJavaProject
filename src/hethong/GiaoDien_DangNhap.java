package hethong;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GiaoDien_DangNhap {

	private JFrame frame;
	private JTextField tfTaiKhoan;
	private JTextField tfMatKhau;
	private JPanel pnChung;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GiaoDien_DangNhap window = new GiaoDien_DangNhap();
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
	public GiaoDien_DangNhap() {
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
		frame.getContentPane().add(pnChung, BorderLayout.NORTH);
		
		JLabel lblDangNhap = new JLabel("Đăng Nhập");
		lblDangNhap.setFont(new Font("Tahoma", Font.PLAIN, 25));
		pnChung.add(lblDangNhap);
		
		JPanel pnCenter = new JPanel();
		frame.getContentPane().add(pnCenter, BorderLayout.CENTER);
		pnCenter.setLayout(null);
		
		JPanel pnDangNhap = new JPanel();
		pnDangNhap.setBorder(new TitledBorder(null, "\u0110\u0103ng Nh\u1EADp", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnDangNhap.setBounds(438, 147, 464, 263);
		pnCenter.add(pnDangNhap);
		pnDangNhap.setLayout(null);
		
		JLabel lblTaiKhoan = new JLabel("Tài Khoản :");
		lblTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTaiKhoan.setBounds(23, 68, 84, 14);
		pnDangNhap.add(lblTaiKhoan);
		
		JLabel lblMatKhau = new JLabel("Mật Khẩu :");
		lblMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMatKhau.setBounds(23, 104, 78, 19);
		pnDangNhap.add(lblMatKhau);
		
		tfTaiKhoan = new JTextField();
		tfTaiKhoan.setBounds(148, 67, 265, 20);
		pnDangNhap.add(tfTaiKhoan);
		tfTaiKhoan.setColumns(10);
		
		tfMatKhau = new JTextField();
		tfMatKhau.setBounds(148, 105, 265, 20);
		pnDangNhap.add(tfMatKhau);
		tfMatKhau.setColumns(10);
		
		JButton btnTiepTuc = new JButton("Tiếp Tục");
		btnTiepTuc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTiepTuc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTiepTuc.setBounds(80, 183, 127, 44);
		pnDangNhap.add(btnTiepTuc);
		
		JButton btnHuy = new JButton("Hủy");
		btnHuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnHuy.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnHuy.setBounds(260, 183, 127, 44);
		pnDangNhap.add(btnHuy);
	}
	public JPanel getJPanel() {
		return pnChung;
	}

}
