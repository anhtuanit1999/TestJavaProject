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
import javax.swing.SwingConstants;

public class GiaoDien_DangNhap {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
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
		frame.getContentPane().add(pnChung, BorderLayout.CENTER);
		pnChung.setLayout(new BorderLayout(0, 0));
		
		JLabel lblDangNhap = new JLabel("Đăng Nhập");
		lblDangNhap.setHorizontalAlignment(SwingConstants.CENTER);
		lblDangNhap.setFont(new Font("Tahoma", Font.PLAIN, 25));
		pnChung.add(lblDangNhap, BorderLayout.NORTH);
		
		JPanel pnCenter = new JPanel();
		pnCenter.setLayout(null);
		pnChung.add(pnCenter, BorderLayout.CENTER);
		
		JPanel pnDangNhap = new JPanel();
		pnDangNhap.setLayout(null);
		pnDangNhap.setBorder(new TitledBorder(null, "\u0110\u0103ng Nh\u1EADp", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnDangNhap.setBounds(438, 147, 464, 263);
		pnCenter.add(pnDangNhap);
		
		JLabel lblTaiKhoan = new JLabel("Tài Khoản :");
		lblTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTaiKhoan.setBounds(23, 68, 84, 14);
		pnDangNhap.add(lblTaiKhoan);
		
		JLabel lblMatKhau = new JLabel("Mật Khẩu :");
		lblMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMatKhau.setBounds(23, 104, 78, 19);
		pnDangNhap.add(lblMatKhau);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(148, 67, 265, 20);
		pnDangNhap.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(148, 105, 265, 20);
		pnDangNhap.add(textField_1);
		
		JButton btnTiepTuc = new JButton("Tiếp Tục");
		btnTiepTuc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTiepTuc.setBounds(80, 183, 127, 44);
		pnDangNhap.add(btnTiepTuc);
		
		JButton btnHuy = new JButton("Hủy");
		btnHuy.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnHuy.setBounds(260, 183, 127, 44);
		pnDangNhap.add(btnHuy);
	}
	public JPanel getPanel() {
		return pnChung;
	}

}
