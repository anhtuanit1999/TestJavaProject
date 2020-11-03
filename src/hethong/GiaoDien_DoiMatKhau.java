package hethong;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GiaoDien_DoiMatKhau {

	private JFrame frame;
	private JPanel pnChung;
	private JPanel pnCenter;
	private JPanel pnDoiMatKhau;
	private JLabel lblMatKhauCu;
	private JLabel lblMtKhuMi;
	private JLabel lblXacNhanMK;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnDoiMatKhau;
	private JButton btnHuy;
	private JLabel lblTieuDe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GiaoDien_DoiMatKhau window = new GiaoDien_DoiMatKhau();
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
	public GiaoDien_DoiMatKhau() {
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
		pnDoiMatKhau.setBounds(350, 115, 630, 311);
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
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(198, 30, 367, 20);
		pnDoiMatKhau.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(198, 64, 367, 20);
		pnDoiMatKhau.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(198, 102, 367, 20);
		pnDoiMatKhau.add(textField_2);
		
		btnDoiMatKhau = new JButton("Tiếp Tục");
		btnDoiMatKhau.setForeground(Color.BLACK);
		btnDoiMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnDoiMatKhau.setBounds(160, 186, 127, 44);
		pnDoiMatKhau.add(btnDoiMatKhau);
		
		btnHuy = new JButton("Hủy");
		btnHuy.setForeground(Color.BLACK);
		btnHuy.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnHuy.setBounds(357, 186, 127, 44);
		pnDoiMatKhau.add(btnHuy);
	}
	public JPanel getPanel() {
		return pnChung;
	}
}
