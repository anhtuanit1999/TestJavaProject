package giaoVien;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class QLGV_GridBagLayout extends JFrame {
	JPanel pnNorth, pnCenter, pnSouth;
	private JLabel lblChucDanh, lblHoTen, lblLinhVucCongTac, lblDonViCongTac, lblKhoaCongTac, lblTieuDe, lbltimkiem;
	private JTextField txtChucDanh, txtHoTen, txtLinhVucCongTac, txtDonViCongTac, txtKhoaCongTac, txttimkiem;
	private JTable table;
	private DefaultTableModel tableModel;
	private JButton btnThem, btnXoaTrang, btnXoa, btnSua, btnXemThongTin, btnTimKiem;
	
	public QLGV_GridBagLayout() {
		pnNorth = new JPanel();
		pnNorth.add(lblTieuDe = new JLabel("Quản Lý Giáo Viên"));
		lblTieuDe.setFont(new Font("ARIAL", Font.BOLD, 30));
		lblTieuDe.setForeground(Color.BLUE);
		
		pnCenter = new JPanel(new GridBagLayout());
		
		pnCenter.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		GridBagConstraints c = new GridBagConstraints();
		c.anchor = GridBagConstraints.NORTHWEST;
		c.fill = GridBagConstraints.HORIZONTAL;
		
		lblChucDanh = new JLabel("Chức danh:");
		c.insets = new Insets(20, 30, 5, 0); //giống padding trong css, thông số lần lượt là top, left, bottom, right
		c.gridx = 0; // toạ độ trục x, y là 0, 0. Điểm 0 nằm ở góc trái trên cùng của Panel
		c.gridy = 0;
		pnCenter.add(lblChucDanh, c);
		
		txtChucDanh = new JTextField();
		c.insets = new Insets(20, 5, 5, 30);
		c.gridx = 1;
		c.gridy = 0;
		pnCenter.add(txtChucDanh, c);
		
		lblHoTen = new JLabel("Họ tên:");
		c.insets = new Insets(5, 30, 5, 0);
		c.gridx = 0;
		c.gridy = 1;
		pnCenter.add(lblHoTen, c);
		
		txtHoTen = new JTextField();
		c.insets = new Insets(5, 5, 5, 30);
		c.gridx = 1;
		c.gridy = 1;
		pnCenter.add(txtHoTen, c);
		
		lblLinhVucCongTac = new JLabel("Lĩnh vực công tác:");
		c.insets = new Insets(5, 30, 5, 0);
		c.gridx = 0;
		c.gridy = 2;
		pnCenter.add(lblLinhVucCongTac, c);
		
		txtLinhVucCongTac = new JTextField();
		c.insets = new Insets(5, 5, 5, 30);
		c.gridx = 1;
		c.gridy = 2;
		pnCenter.add(txtLinhVucCongTac, c);
		
		lblDonViCongTac = new JLabel("Đơn vị công tác:");
		c.insets = new Insets(5, 30, 5, 0);
		c.gridx = 0;
		c.gridy = 3;
		pnCenter.add(lblDonViCongTac, c);
		
		txtDonViCongTac = new JTextField();
		c.insets = new Insets(5, 5, 5, 30);
		c.gridx = 1;
		c.gridy = 3;
		pnCenter.add(txtDonViCongTac, c);
		
		lblKhoaCongTac = new JLabel("Khoa công tác:");
		c.insets = new Insets(5, 30, 5, 0);
		c.gridx = 0;
		c.gridy = 4;
		pnCenter.add(lblKhoaCongTac, c);
		
		txtKhoaCongTac = new JTextField();
		c.insets = new Insets(5, 5, 5, 30);
		c.gridx = 1;
		c.gridy = 4;
		pnCenter.add(txtKhoaCongTac, c);
		
		c.weighty = 1;
		c.weightx = 1;
		pnCenter.add(new JLabel(""), c);
		
		pnSouth = new JPanel();
		JPanel pnTask = new JPanel();
		pnTask.add(btnThem = new JButton("Thêm"));
		pnTask.add(btnXoaTrang = new JButton("Xoá Trắng"));
		pnTask.add(lbltimkiem = new JLabel("Nhập mã để tìm kiếm:"));
		pnTask.add(txttimkiem = new JTextField(10));
		pnTask.add(btnTimKiem = new JButton("Tìm"));
		
		String[] header = "Chức danh, Họ tên, Lĩnh vực công tác, Đơn vị công tác, Khoa công tác".split(",");
		tableModel = new DefaultTableModel(header,0);
		table = new JTable(tableModel);
		JScrollPane scroll = new JScrollPane(table);
		table.setRowHeight(25);
		table.setDefaultEditor(Object.class, null);
		scroll.getViewport().add(table);
		scroll.setPreferredSize(new Dimension(900,290));
		pnTask.setPreferredSize(new Dimension(1000,50));
		pnSouth.add(pnTask);
		pnSouth.add(scroll);
		pnSouth.setBorder(BorderFactory.createEmptyBorder(10,10, 100, 10));
	
		add(pnNorth, BorderLayout.NORTH);
		add(pnCenter, BorderLayout.CENTER);
		add(pnSouth, BorderLayout.SOUTH);
		
		setSize(1000, 700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new QLGV_GridBagLayout().setVisible(true);
	}
}
