package giaovien;

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
	private JTextField tfMatKhauCu;
	private JTextField tfMatKhauMoi;
	private JTextField tfXacNhanMK;
	private JPanel pnChung;

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
		frame.getContentPane().add(pnChung, BorderLayout.NORTH);
		pnChung.setLayout(new BorderLayout(0, 0));
		
		JLabel lblDoiMatKhau = new JLabel("Đổi Mật Khẩu");
		lblDoiMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblDoiMatKhau.setHorizontalAlignment(SwingConstants.CENTER);
		pnChung.add(lblDoiMatKhau);
		
		JPanel pnCenter = new JPanel();
		frame.getContentPane().add(pnCenter, BorderLayout.CENTER);
		pnCenter.setLayout(null);
		
		JPanel pnDoiMatKhau = new JPanel();
		pnDoiMatKhau.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u0110\u1ED5i M\u1EADt Kh\u1EA9u", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.windowText));
		pnDoiMatKhau.setBounds(350, 115, 630, 311);
		pnCenter.add(pnDoiMatKhau);
		pnDoiMatKhau.setLayout(null);
		
		JLabel lblMatKhauCu = new JLabel("Mật Khẩu Cũ :");
		lblMatKhauCu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMatKhauCu.setBounds(22, 30, 112, 14);
		pnDoiMatKhau.add(lblMatKhauCu);
		
		JLabel lblMtKhuMi = new JLabel("Mật Khẩu Mới :");
		lblMtKhuMi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMtKhuMi.setBounds(22, 64, 136, 14);
		pnDoiMatKhau.add(lblMtKhuMi);
		
		JLabel lblXacNhanMK = new JLabel("Xác Nhận Mật Khẩu Mới :");
		lblXacNhanMK.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblXacNhanMK.setBounds(22, 102, 192, 14);
		pnDoiMatKhau.add(lblXacNhanMK);
		
		tfMatKhauCu = new JTextField();
		tfMatKhauCu.setBounds(198, 30, 367, 20);
		pnDoiMatKhau.add(tfMatKhauCu);
		tfMatKhauCu.setColumns(10);
		
		tfMatKhauMoi = new JTextField();
		tfMatKhauMoi.setBounds(198, 64, 367, 20);
		pnDoiMatKhau.add(tfMatKhauMoi);
		tfMatKhauMoi.setColumns(10);
		
		tfXacNhanMK = new JTextField();
		tfXacNhanMK.setBounds(198, 102, 367, 20);
		pnDoiMatKhau.add(tfXacNhanMK);
		tfXacNhanMK.setColumns(10);
		
		JButton btnDoiMatKhau = new JButton("Tiếp Tục");
		btnDoiMatKhau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDoiMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnDoiMatKhau.setForeground(Color.BLACK);
		btnDoiMatKhau.setBounds(160, 186, 127, 44);
		pnDoiMatKhau.add(btnDoiMatKhau);
		
		JButton btnHuy = new JButton("Hủy");
		btnHuy.setForeground(Color.BLACK);
		btnHuy.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnHuy.setBounds(357, 186, 127, 44);
		pnDoiMatKhau.add(btnHuy);
	}
	public JPanel getJPanel() {
		return pnChung;
	}
}
