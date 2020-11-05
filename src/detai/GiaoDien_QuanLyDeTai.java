package detai;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class GiaoDien_QuanLyDeTai {

	private JFrame frame;
	private JTable table;

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
		frame.getContentPane().add(pnChung, BorderLayout.NORTH);
		pnChung.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTIeuDe = new JLabel("Quản Lý Đề Tài");
		lblTIeuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTIeuDe.setFont(new Font("Tahoma", Font.PLAIN, 25));
		pnChung.add(lblTIeuDe, BorderLayout.NORTH);
		
		JPanel pnCenter = new JPanel();
		frame.getContentPane().add(pnCenter, BorderLayout.CENTER);
		pnCenter.setBorder(new TitledBorder(null, "\u0110\u1EC1 T\u00E0i", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnCenter.setLayout(null);
		
		JPanel pnDeTai = new JPanel();
		pnDeTai.setBounds(169, 55, 930, 438);
		pnCenter.add(pnDeTai);
		pnDeTai.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 930, 438);
		pnDeTai.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "M\u00E3 \u0110\u1EC1 T\u00E0i", "T\u00EAn \u0110\u1EC1 T\u00E0i", "S\u1ED1 Nh\u00F3m \u0110\u0103ng K\u00FD", "H\u1ECDc K\u1EF3"
			}
		));
		table.getColumnModel().getColumn(3).setPreferredWidth(102);
		scrollPane.setViewportView(table);
	}
}
