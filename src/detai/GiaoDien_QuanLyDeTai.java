package detai;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

public class GiaoDien_QuanLyDeTai {

	private JFrame frame;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GiaoDien_QuanLyDeTai window = new GiaoDien_QuanLyDeTai();
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
	public GiaoDien_QuanLyDeTai() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1280, 950);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel pnChung = new JPanel();
		frame.getContentPane().add(pnChung, BorderLayout.CENTER);
		pnChung.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTieuDe = new JLabel("Quản Lý Đề Tài");
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDe.setFont(new Font("Tahoma", Font.PLAIN, 25));
		pnChung.add(lblTieuDe, BorderLayout.NORTH);
		
		JPanel pnCenter = new JPanel();
		pnCenter.setBorder(new TitledBorder(null, "\u0110\u1EC1 T\u00E0i", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnChung.add(pnCenter, BorderLayout.CENTER);
		pnCenter.setLayout(null);
		
		JPanel pnDeTai = new JPanel();
		pnDeTai.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnDeTai.setBounds(30, 36, 606, 389);
		pnCenter.add(pnDeTai);
		pnDeTai.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 586, 367);
		pnDeTai.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "M\u00E3 \u0110\u1EC1 T\u00E0i", "T\u00EAn \u0110\u1EC1 T\u00E0i"
			}
		));
		scrollPane.setViewportView(table);
		
		JPanel pnDeTai1 = new JPanel();
		pnDeTai1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnDeTai1.setBounds(658, 36, 568, 389);
		pnCenter.add(pnDeTai1);
		pnDeTai1.setLayout(null);
		
		JLabel lblMaDeTai = new JLabel("Mã Đề Tài:");
		lblMaDeTai.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMaDeTai.setBounds(58, 95, 121, 14);
		pnDeTai1.add(lblMaDeTai);
		
		JLabel lblTenDeTai = new JLabel("Tên Đề Tài:");
		lblTenDeTai.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTenDeTai.setBounds(58, 152, 129, 14);
		pnDeTai1.add(lblTenDeTai);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(189, 94, 332, 20);
		pnDeTai1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(189, 151, 332, 20);
		pnDeTai1.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setBounds(388, 485, 155, 56);
		pnCenter.add(btnThem);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setBounds(629, 485, 149, 56);
		pnCenter.add(btnSua);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setBounds(845, 485, 139, 56);
		pnCenter.add(btnXoa);
	}
}
