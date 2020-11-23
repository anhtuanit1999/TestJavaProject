package giaodienchinh;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.border.TitledBorder;

import dao.DangNhapDao;
import dao.Database;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JPasswordField;

public class GiaoDien_DangNhap implements ActionListener {

	public JFrame frame;
	private JTextField txtTaiKhoan;
	private JPanel pnChung;
	private JPasswordField pwdMatKhau;
	private JButton btnTiepTuc;
	private DangNhapDao dangNhapDao;

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
		Database.getInstance().connec();
		frame = new JFrame();
		dangNhapDao = new DangNhapDao();
		frame.setBounds(100, 100, 488, 333);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
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
		pnDangNhap.setBounds(0, 0, 464, 263);
		pnCenter.add(pnDangNhap);
		
		JLabel lblTaiKhoan = new JLabel("Tài Khoản :");
		lblTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTaiKhoan.setBounds(23, 68, 84, 14);
		pnDangNhap.add(lblTaiKhoan);
		
		JLabel lblMatKhau = new JLabel("Mật Khẩu :");
		lblMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMatKhau.setBounds(23, 104, 78, 19);
		pnDangNhap.add(lblMatKhau);
		
		txtTaiKhoan = new JTextField();
		txtTaiKhoan.setColumns(10);
		txtTaiKhoan.setBounds(148, 67, 265, 20);
		pnDangNhap.add(txtTaiKhoan);
		
		btnTiepTuc = new JButton("Đăng nhập");
		btnTiepTuc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTiepTuc.setBounds(180, 162, 127, 44);
		pnDangNhap.add(btnTiepTuc);
		
		pwdMatKhau = new JPasswordField();
		pwdMatKhau.setBounds(148, 105, 265, 19);
		pnDangNhap.add(pwdMatKhau);
		
		btnTiepTuc.addActionListener(this);
	}
	public JPanel getPanel() {
		return pnChung;
	}

	public void xoaTrang() {
		txtTaiKhoan.setText("");
		pwdMatKhau.setText("");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnTiepTuc)) {
			String taiKhoan = txtTaiKhoan.getText().trim();
			String matKhau = pwdMatKhau.getText().trim();
			if(dangNhapDao.kiemTraTaiKhoan(taiKhoan, matKhau)) {
				JOptionPane.showMessageDialog(frame, "Đăng nhập thành công");
				xoaTrang();
				try {
					GiaoDienChinh giaoDienChinh = new GiaoDienChinh(taiKhoan);
					giaoDienChinh.frame.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.dispose();
				return;
			}
			JOptionPane.showMessageDialog(frame, "Tài khoản hoặc mật khẩu không đúng");
			xoaTrang();
			return;
		}
		
	}
}
