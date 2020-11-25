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
import javax.swing.table.DefaultTableModel;

import dao.DangNhapDao;
import dao.Database;

import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class GiaoDien_DoiMatKhau implements ActionListener, KeyListener {

	private JFrame frame;
	private JPanel pnChung;
	private JPanel pnCenter;
	private JPanel pnDoiMatKhau;
	private JLabel lblMatKhauCu;
	private JLabel lblMtKhuMi;
	private JLabel lblXacNhanMK;
	private JButton btnDoiMatKhau;
	private JLabel lblTieuDe;
	private String taiKhoan;
	private DangNhapDao dangNhapDao;
	private JPasswordField pwdMatKhau;
	private JPasswordField pwdMatKhauMoi;
	private JPasswordField pwdXacNhanMatKhauMoi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GiaoDien_DoiMatKhau window = new GiaoDien_DoiMatKhau("GV001");
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
	public GiaoDien_DoiMatKhau(String taiKhoan) {
		this.taiKhoan = taiKhoan;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Database.getInstance().connec();
		dangNhapDao = new DangNhapDao();
		frame = new JFrame();
		frame.setBounds(100, 100, 1280, 950);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		pnChung = new JPanel();
		frame.getContentPane().add(pnChung, BorderLayout.CENTER);
		pnChung.setLayout(new BorderLayout(0, 0));
		
		lblTieuDe = new JLabel("Đổi mật khẩu");
		pnChung.add(lblTieuDe, BorderLayout.NORTH);
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDe.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		pnCenter = new JPanel();
		pnCenter.setLayout(null);
		pnChung.add(pnCenter, BorderLayout.CENTER);
		
		pnDoiMatKhau = new JPanel();
		pnDoiMatKhau.setLayout(null);
		pnDoiMatKhau.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u0110\u1ED5i M\u1EADt Kh\u1EA9u", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.windowText));
		pnDoiMatKhau.setBounds(350, 115, 630, 280);
		pnCenter.add(pnDoiMatKhau);
		
		lblMatKhauCu = new JLabel("Mật Khẩu Cũ :");
		lblMatKhauCu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMatKhauCu.setBounds(22, 30, 112, 14);
		pnDoiMatKhau.add(lblMatKhauCu);
		
		lblMtKhuMi = new JLabel("Mật Khẩu Mới :");
		lblMtKhuMi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMtKhuMi.setBounds(22, 64, 136, 14);
		pnDoiMatKhau.add(lblMtKhuMi);
		
		lblXacNhanMK = new JLabel("Xác Nhận Mật Khẩu Mới :");
		lblXacNhanMK.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblXacNhanMK.setBounds(22, 102, 192, 14);
		pnDoiMatKhau.add(lblXacNhanMK);
		
		btnDoiMatKhau = new JButton("Đổi mật khẩu");
		btnDoiMatKhau.setForeground(Color.BLACK);
		btnDoiMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnDoiMatKhau.setBounds(240, 179, 127, 44);
		pnDoiMatKhau.add(btnDoiMatKhau);
		
		pwdMatKhau = new JPasswordField();
		pwdMatKhau.setBounds(198, 29, 367, 20);
		pnDoiMatKhau.add(pwdMatKhau);
		
		pwdMatKhauMoi = new JPasswordField();
		pwdMatKhauMoi.setBounds(198, 63, 367, 20);
		pnDoiMatKhau.add(pwdMatKhauMoi);
		
		pwdXacNhanMatKhauMoi = new JPasswordField();
		pwdXacNhanMatKhauMoi.setBounds(198, 101, 367, 20);
		pnDoiMatKhau.add(pwdXacNhanMatKhauMoi);
		
		btnDoiMatKhau.addActionListener(this);
		pwdMatKhau.addKeyListener(this);
		pwdMatKhauMoi.addKeyListener(this);
		pwdXacNhanMatKhauMoi.addKeyListener(this);
	}
	public JPanel getPanel() {
		return pnChung;
	}
	public boolean kiemTraPasswordField() {
		String regex = ".+";
		if(!pwdMatKhau.getText().matches(regex)) {
			JOptionPane.showMessageDialog(frame, "Mật khẩu không hợp lệ");
			pwdMatKhau.requestFocus();
			pwdMatKhau.selectAll();
			return false;
		}
		if(!pwdMatKhauMoi.getText().matches(regex)) {
			JOptionPane.showMessageDialog(frame, "Mật khẩu mới không hợp lệ");
			pwdMatKhauMoi.requestFocus();
			pwdMatKhauMoi.selectAll();
			return false;
		}
		if(!pwdXacNhanMatKhauMoi.getText().equals(pwdMatKhauMoi.getText())) {
			JOptionPane.showMessageDialog(frame, "Mật khẩu xác nhận không trùng khớp");
			pwdXacNhanMatKhauMoi.requestFocus();
			pwdXacNhanMatKhauMoi.selectAll();
			return false;
		}
		return true;
	}
	
	public void xoaTrang() {
		pwdMatKhau.setText("");
		pwdMatKhauMoi.setText("");
		pwdXacNhanMatKhauMoi.setText("");
	}
	
	public void eventDoiMatKhau() {
		if(kiemTraPasswordField()) {
			if(dangNhapDao.kiemTraTaiKhoan(taiKhoan, pwdMatKhau.getText())) {
				if (JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn đổi mật khẩu?", "WARNING",
				        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					if (dangNhapDao.doiMatKhau(taiKhoan, pwdMatKhau.getText(), pwdMatKhauMoi.getText())) {
						JOptionPane.showMessageDialog(frame, "Đổi mật khẩu thành công");
						xoaTrang();
						return;
					}
					JOptionPane.showMessageDialog(frame, "Đổi mật khẩu thất bại");
					xoaTrang();
				}

			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnDoiMatKhau)) {
			eventDoiMatKhau();
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			eventDoiMatKhau();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
