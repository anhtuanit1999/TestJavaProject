package giaovukhoa;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class GiaoDien_ChonCongViec {

	public JFrame frame;
	private JTable table;
	private JPanel pnChung;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GiaoDien_ChonCongViec window = new GiaoDien_ChonCongViec();
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
	public GiaoDien_ChonCongViec() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 914, 522);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		pnChung = new JPanel();
		frame.getContentPane().add(pnChung, BorderLayout.CENTER);
		pnChung.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTieuDe = new JLabel("Chọn công việc cho giáo viên");
		lblTieuDe.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		pnChung.add(lblTieuDe, BorderLayout.NORTH);
		
		JPanel pnCenter = new JPanel();
		pnChung.add(pnCenter, BorderLayout.CENTER);
		pnCenter.setLayout(null);
		
		JLabel lblCongViec = new JLabel("Công việc: ");
		lblCongViec.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCongViec.setBounds(33, 43, 84, 19);
		pnCenter.add(lblCongViec);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Giáo viên phản biện", "Thư ký", "Chủ tịch"}));
		comboBox.setBounds(127, 40, 591, 25);
		pnCenter.add(comboBox);
		
		JButton btnPhanCong = new JButton("Phân công");
		btnPhanCong.setBounds(739, 28, 127, 44);
		pnCenter.add(btnPhanCong);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Danh s\u00E1ch gi\u00E1o vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 83, 878, 358);
		pnCenter.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 23, 858, 324);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "M\u00E3 gi\u00E1o vi\u00EAn", "T\u00EAn gi\u00E1o vi\u00EAn", "Ch\u1EE9c v\u1EE5"
			}
		));
		scrollPane.setViewportView(table);
	}
	public JPanel getPanel() {
		return pnChung;
	}
}

/*
* (C) Copyright 2020 IUH. All rights reserved.
*
* @author: AnhTuanIT
* @date: 13-11-2020
* @version: 1.0
*/
