package detai;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;

public class GiaoDien_BaoCaoDeTai {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GiaoDien_BaoCaoDeTai window = new GiaoDien_BaoCaoDeTai();
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
	public GiaoDien_BaoCaoDeTai() {
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
		
		JPanel pnChung = new JPanel();
		frame.getContentPane().add(pnChung, BorderLayout.CENTER);
		pnChung.setLayout(new BorderLayout(0, 0));
		
		JPanel pnCenter = new JPanel();
		pnChung.add(pnCenter, BorderLayout.CENTER);
		pnCenter.setLayout(null);
		
		JPanel pnBaoCao = new JPanel();
		pnBaoCao.setBorder(new TitledBorder(null, "B\u00E1o C\u00E1o \u0110\u1EC1 T\u00E0i", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnBaoCao.setBounds(113, 30, 1058, 391);
		pnCenter.add(pnBaoCao);
		pnBaoCao.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 27, 1003, 338);
		pnBaoCao.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "M\u00E3 \u0110\u1EC1 T\u00E0i", "T\u00EAn \u0110\u1EC1 T\u00E0i", "H\u1ECDc K\u00EC", "S\u1ED1 Nh\u00F3m \u0110\u0103ng K\u00ED"
			}
		));
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		scrollPane.setViewportView(table);
		
		JPanel pnDeTai = new JPanel();
		pnDeTai.setBorder(new TitledBorder(null, "\u0110\u1EC1 T\u00E0i", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnDeTai.setBounds(113, 469, 1058, 122);
		pnCenter.add(pnDeTai);
		pnDeTai.setLayout(null);
		
		JLabel lblTenDeTai = new JLabel("Tên Đề Tài:");
		lblTenDeTai.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTenDeTai.setBounds(29, 52, 111, 14);
		pnDeTai.add(lblTenDeTai);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(180, 50, 833, 22);
		pnDeTai.add(comboBox);
		
		JLabel lblTieuDe = new JLabel("Báo Cáo Đề Tài");
		lblTieuDe.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		pnChung.add(lblTieuDe, BorderLayout.NORTH);
	}
}
