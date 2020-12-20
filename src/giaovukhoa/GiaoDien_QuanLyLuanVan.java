package giaovukhoa;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JTextField;
import javax.swing.JSlider;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.Database;
import dao.GiaoVienDao;
import dao.LuanVanDao;
import entity.GiaoVien;
import entity.LuanVan;
import entity.SinhVien;

import javax.swing.JButton;
import javax.swing.JTextArea;
import com.toedter.calendar.JDateChooser;

public class GiaoDien_QuanLyLuanVan implements MouseListener, ActionListener, KeyListener {

	private JFrame frame;
	private JPanel pnChung;
	private JTable table;
	private JTextField txtTenLuanVan;
	private DefaultComboBoxModel<String> comboModel;
	private DefaultTableModel tableModel;
	private JTextField txtLinhVucNghienCuu;
	private GiaoVienDao giaoVienDao;
	private JComboBox comboBoxTenGiaoVien;
	private LuanVanDao luanVanDao;
	private JButton btnThem;
	private JTextArea txtaMoTa;
	private JButton btnSua;
	private JButton btnXoa;
	private JTextField txtSoNhomThamGiaToiDa;
	private JDateChooser dateChooserNgayLap;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GiaoDien_QuanLyLuanVan window = new GiaoDien_QuanLyLuanVan();
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
	public GiaoDien_QuanLyLuanVan() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Database.getInstance().connec();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int oldHeight = 950;
		int oldWidth = 1280;
		double height = screenSize.getHeight() < oldHeight ? oldHeight : screenSize.getHeight();
		double width = screenSize.getWidth() < oldWidth ? oldWidth : screenSize.getWidth();
		giaoVienDao = new GiaoVienDao();
		luanVanDao = new LuanVanDao();
		frame = new JFrame();
		frame.setBounds(100, 100, 1280, 950);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setResizable(false);
		
		pnChung = new JPanel();
		frame.getContentPane().add(pnChung, BorderLayout.CENTER);
		pnChung.setLayout(new BorderLayout(0, 0));
		
		JPanel pnCenter = new JPanel();
		pnCenter.setLayout(null);
		pnChung.add(pnCenter, BorderLayout.CENTER);
		
		JPanel pnThongTinLuanVan = new JPanel();
		pnThongTinLuanVan.setLayout(null);
		pnThongTinLuanVan.setBorder(new TitledBorder(null, "Th\u00F4ng Tin Lu\u1EADn V\u0103n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnThongTinLuanVan.setBounds((int)Math.round(width/2 - (oldWidth/2 - 10)), 11, 1244, 332);
		pnCenter.add(pnThongTinLuanVan);
		
		JLabel lblLinhVucNghienCuu = new JLabel("Lĩnh vực nghiên cứu:");
		lblLinhVucNghienCuu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLinhVucNghienCuu.setBounds(56, 73, 140, 20);
		pnThongTinLuanVan.add(lblLinhVucNghienCuu);
		
		JLabel lblMoTa = new JLabel("Mô tả: ");
		lblMoTa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMoTa.setBounds(56, 119, 103, 14);
		pnThongTinLuanVan.add(lblMoTa);
		
		comboModel = new DefaultComboBoxModel<String>();
		
		txtaMoTa = new JTextArea();
		txtaMoTa.setBounds(217, 116, 955, 53);
		pnThongTinLuanVan.add(txtaMoTa);
		
		JLabel lblTenLuanVan = new JLabel("Tên luận văn:");
		lblTenLuanVan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTenLuanVan.setBounds(56, 42, 107, 20);
		pnThongTinLuanVan.add(lblTenLuanVan);
		
		txtTenLuanVan = new JTextField();
		txtTenLuanVan.setColumns(10);
		txtTenLuanVan.setBounds(217, 41, 955, 20);
		pnThongTinLuanVan.add(txtTenLuanVan);
		
		txtLinhVucNghienCuu = new JTextField();
		txtLinhVucNghienCuu.setColumns(10);
		txtLinhVucNghienCuu.setBounds(217, 75, 955, 20);
		pnThongTinLuanVan.add(txtLinhVucNghienCuu);
		
		JLabel lblNgayLap = new JLabel("Ngày lập: ");
		lblNgayLap.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNgayLap.setBounds(56, 206, 107, 20);
		pnThongTinLuanVan.add(lblNgayLap);
		
		JLabel lblGiaoVienRaDeTai = new JLabel("Giáo viên ra đề tài: ");
		lblGiaoVienRaDeTai.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGiaoVienRaDeTai.setBounds(56, 237, 140, 20);
		pnThongTinLuanVan.add(lblGiaoVienRaDeTai);
		
		JLabel lblSNhmTham = new JLabel("Số nhóm tham gia: ");
		lblSNhmTham.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSNhmTham.setBounds(56, 268, 151, 20);
		pnThongTinLuanVan.add(lblSNhmTham);
		
		comboBoxTenGiaoVien = new JComboBox();
		comboBoxTenGiaoVien.setBounds(217, 239, 955, 18);
		pnThongTinLuanVan.add(comboBoxTenGiaoVien);
		
		txtSoNhomThamGiaToiDa = new JTextField();
		txtSoNhomThamGiaToiDa.setText("3");
		txtSoNhomThamGiaToiDa.setColumns(10);
		txtSoNhomThamGiaToiDa.setBounds(217, 270, 955, 20);
		pnThongTinLuanVan.add(txtSoNhomThamGiaToiDa);
		
		dateChooserNgayLap = new JDateChooser();
		dateChooserNgayLap.setBounds(217, 206, 955, 20);
		pnThongTinLuanVan.add(dateChooserNgayLap);
		
		btnThem = new JButton("Thêm");
		btnThem.setBounds((int)Math.round(width/2 - (oldWidth/2 - 258)), 370, 127, 44);
		pnCenter.add(btnThem);
		
		btnSua = new JButton("Sửa");
		btnSua.setBounds((int)Math.round(width/2 - (oldWidth/2 - 517)), 370, 127, 44);
		pnCenter.add(btnSua);
		
		btnXoa = new JButton("Xóa");
		btnXoa.setBounds((int)Math.round(width/2 - (oldWidth/2 - 779)), 370, 127, 44);
		pnCenter.add(btnXoa);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(null, "Danh s\u00E1ch lu\u1EADn v\u0103n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds((int)Math.round(width/2 - (oldWidth/2 - 10)), 425, 1244, 443);
		pnCenter.add(panel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 22, 1224, 381);
		panel.add(scrollPane);
		
		table = new JTable();
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "M\u00E3 lu\u1EADn v\u0103n", "T\u00EAn lu\u1EADn v\u0103n", "L\u0129nh v\u1EF1c nghi\u00EAn c\u1EE9u", "Ng\u00E0y l\u1EADp", "M\u00F4 t\u1EA3", "Gi\u00E1o vi\u00EAn ra \u0111\u1EC1 t\u00E0i", "S\u1ED1 nh\u00F3m tham gia t\u1ED1i \u0111a"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblTieuDe = new JLabel("Quản lý luận văn");
		lblTieuDe.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		pnChung.add(lblTieuDe, BorderLayout.NORTH);
		
		capNhat();
		btnThem.addActionListener(this);
		table.addMouseListener(this);
		btnXoa.addActionListener(this);
		btnSua.addActionListener(this);
		txtSoNhomThamGiaToiDa.addKeyListener(this);
		comboBoxTenGiaoVien.addKeyListener(this);
		
	}
	public JPanel getPanel() {
		return pnChung;
	}
	
	public void capNhat() {
		updateComboBoxTenGiaoVien();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		luanVanDao.updateBangLuanVan(table);
	}
	
	public int timChiSoTenGiaoVien() {
		int row = table.getSelectedRow();
		int index = 0;
		for (int i = 0; i < comboBoxTenGiaoVien.getItemCount(); i++) {
			String maGiaoVien = comboBoxTenGiaoVien.getItemAt(i).toString();
			if(maGiaoVien.indexOf(table.getValueAt(row, 7).toString().trim()) != -1) {
				index = i;
			}
		}
		return index;
	}
	

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		txtTenLuanVan.setText(table.getValueAt(row, 2).toString());
		txtLinhVucNghienCuu.setText(table.getValueAt(row, 3).toString());
		txtaMoTa.setText(table.getValueAt(row, 5).toString());
		try {
			dateChooserNgayLap.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(table.getValueAt(row, 4).toString()));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		txtSoNhomThamGiaToiDa.setText(table.getValueAt(row, 7).toString());
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void updateComboBoxTenGiaoVien() {
		ArrayList<GiaoVien> listGV = null;
		listGV = giaoVienDao.docTuBang();
		for(GiaoVien gv: listGV) {
			DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) comboBoxTenGiaoVien.getModel();
			comboBoxModel.addElement(gv.getHoTen() + " - " + gv.getMaGiaoVien());
		}
	}

	
	public boolean kiemTraTextField() {
		String regex = "[A-Z]+.*(\\s[A-Z]+.*)*";
		String regexSo = "\\d+";
		if(!txtTenLuanVan.getText().trim().matches(regex)) {
			JOptionPane.showMessageDialog(frame, "Chữ đầu tiên là chữ hoa, theo sau là các ký tự thường.");
			txtTenLuanVan.requestFocus();
			txtTenLuanVan.selectAll();
			return false;
		}
		if(!txtLinhVucNghienCuu.getText().trim().matches(regex)) {
			JOptionPane.showMessageDialog(frame, "Chữ đầu tiên là chữ hoa, theo sau là các ký tự thường.");
			txtLinhVucNghienCuu.requestFocus();
			txtLinhVucNghienCuu.selectAll();
			return false;
		}
		if(dateChooserNgayLap.getDate() == null) {
			JOptionPane.showMessageDialog(frame, "Sai định dạng ngày dd-MM-yyyy");
			dateChooserNgayLap.setDate(null);
			dateChooserNgayLap.requestFocus();
			return false;
		}
		if(!txtSoNhomThamGiaToiDa.getText().trim().matches(regexSo)) {
			JOptionPane.showMessageDialog(frame, "Chỉ chấp nhận số nguyên.");
			txtLinhVucNghienCuu.requestFocus();
			txtLinhVucNghienCuu.selectAll();
			return false;
		}
		return true;
	}
	
	public void xoaTrang() {
		txtTenLuanVan.setText("");
		txtLinhVucNghienCuu.setText("");
		txtaMoTa.setText("");
		dateChooserNgayLap.setDate(null);
		comboBoxTenGiaoVien.setSelectedIndex(0);
		txtSoNhomThamGiaToiDa.setText("3");
	}
	
	public void eventThem() {
		if(kiemTraTextField()) {
			String regex = "GV\\d{3}";
			String tenLuanVan = txtTenLuanVan.getText();
			String linhVucNghienCuu = txtLinhVucNghienCuu.getText();
			String moTa = txtaMoTa.getText();
			Date ngayLap = dateChooserNgayLap.getDate();
			int soNhomThamGiaToiDa = Integer.parseInt(txtSoNhomThamGiaToiDa.getText());
			
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(comboBoxTenGiaoVien.getSelectedItem().toString());
			String maGiaoVien = "";
			while(matcher.find()) {
				maGiaoVien += comboBoxTenGiaoVien.getSelectedItem().toString().substring(matcher.start(), matcher.end());
			}
			LuanVan lv = new LuanVan(luanVanDao.sinhMaLuanVanTuDong(), tenLuanVan, linhVucNghienCuu, moTa, ngayLap, maGiaoVien, soNhomThamGiaToiDa);
			if(luanVanDao.kiemTraLuanVanDaTonTai(tenLuanVan, linhVucNghienCuu)) {
				JOptionPane.showMessageDialog(frame, "Luận văn đã tồn tại");
				return;
			}
			System.out.println(dateChooserNgayLap.getDate());
			JOptionPane.showMessageDialog(frame, "Thêm thành công!");
			luanVanDao.themLuanVan(lv);
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.setRowCount(0);
			luanVanDao.updateBangLuanVan(table);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnThem)) {
			eventThem();
		} else if(o.equals(btnXoa)) {
			int row = table.getSelectedRow();
			if (row >= 0) {
				String maLuanVan = (String) table.getValueAt(row, 1);
				if (JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa?", "WARNING",
				        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					if (luanVanDao.xoaLuanVan(maLuanVan)) {
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						model.setRowCount(0);
						luanVanDao.updateBangLuanVan(table);
						xoaTrang();
					}
				}
			}
		} else if(o.equals(btnSua)) {
			String regex = "GV\\d{3}";
			String tenLuanVan = txtTenLuanVan.getText();
			String linhVucNghienCuu = txtLinhVucNghienCuu.getText();
			String moTa = txtaMoTa.getText();
			Date ngayLap = dateChooserNgayLap.getDate();
			int soNhomThamGiaToiDa = Integer.parseInt(txtSoNhomThamGiaToiDa.getText());
			
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(comboBoxTenGiaoVien.getSelectedItem().toString());
			String maGiaoVien = "";
			while(matcher.find()) {
				maGiaoVien += comboBoxTenGiaoVien.getSelectedItem().toString().substring(matcher.start(), matcher.end());
			}
			LuanVan lv = new LuanVan(luanVanDao.sinhMaLuanVanTuDong(), tenLuanVan, linhVucNghienCuu, moTa, ngayLap, maGiaoVien, soNhomThamGiaToiDa);
			String maLuanVan = table.getValueAt(table.getSelectedRow(), 1).toString();
			if(luanVanDao.kiemTraLuanVanDaTonTai(tenLuanVan, linhVucNghienCuu) && (!lv.getTenLuanVan().equals(tenLuanVan) || !lv.getLinhVucNghienCuu().equals(linhVucNghienCuu))) {
				JOptionPane.showMessageDialog(frame, "Luận văn đã tồn tại");
				return;
			}
			JOptionPane.showMessageDialog(frame, "Sửa thành công!");
			luanVanDao.suaLuanVan(maLuanVan, lv);
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.setRowCount(0);
			luanVanDao.updateBangLuanVan(table);
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			eventThem();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
