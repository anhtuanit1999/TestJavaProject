package giaovukhoa;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
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

public class GiaoDien_QuanLyLuanVan implements MouseListener, ActionListener {

	private JFrame frame;
	private JPanel pnChung;
	private JTable table;
	private JTextField txtTenLuanVan;
	private DefaultComboBoxModel<String> comboModel;
	private DefaultTableModel tableModel;
	private JTextField txtLinhVucNghienCuu;
	private JTextField txtNoiDungLuanVan;
	private GiaoVienDao giaoVienDao;
	private JComboBox comboBoxTenGiaoVien;
	private LuanVanDao luanVanDao;
	private JButton btnThem;
	private JComboBox comboBoxNamHoc;
	private JTextArea txtaTomTat;
	private JComboBox comboBoxSoNhomThamGia;
	private JButton btnSua;
	private JButton btnXoa;

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
		giaoVienDao = new GiaoVienDao();
		luanVanDao = new LuanVanDao();
		frame = new JFrame();
		frame.setBounds(100, 100, 1280, 950);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		pnChung = new JPanel();
		frame.getContentPane().add(pnChung, BorderLayout.CENTER);
		pnChung.setLayout(new BorderLayout(0, 0));
		
		JPanel pnCenter = new JPanel();
		pnCenter.setLayout(null);
		pnChung.add(pnCenter, BorderLayout.CENTER);
		
		JPanel pnThongTinLuanVan = new JPanel();
		pnThongTinLuanVan.setLayout(null);
		pnThongTinLuanVan.setBorder(new TitledBorder(null, "Th\u00F4ng Tin Lu\u1EADn V\u0103n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnThongTinLuanVan.setBounds(10, 11, 1244, 332);
		pnCenter.add(pnThongTinLuanVan);
		
		JLabel lblLinhVucNghienCuu = new JLabel("Lĩnh vực nghiên cứu:");
		lblLinhVucNghienCuu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLinhVucNghienCuu.setBounds(56, 73, 140, 20);
		pnThongTinLuanVan.add(lblLinhVucNghienCuu);
		
		JLabel lblTomTat = new JLabel("Tóm tắt:");
		lblTomTat.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTomTat.setBounds(56, 144, 103, 14);
		pnThongTinLuanVan.add(lblTomTat);
		
		comboModel = new DefaultComboBoxModel<String>();
		
		txtaTomTat = new JTextArea();
		txtaTomTat.setBounds(217, 141, 955, 53);
		pnThongTinLuanVan.add(txtaTomTat);
		
		JLabel lblTenLuanVan = new JLabel("Tên luận văn:");
		lblTenLuanVan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTenLuanVan.setBounds(56, 42, 107, 20);
		pnThongTinLuanVan.add(lblTenLuanVan);
		
		txtTenLuanVan = new JTextField();
		txtTenLuanVan.setColumns(10);
		txtTenLuanVan.setBounds(217, 41, 955, 20);
		pnThongTinLuanVan.add(txtTenLuanVan);
		
		JLabel lblNoiDungLuanVan = new JLabel("Nội dung luận văn: ");
		lblNoiDungLuanVan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNoiDungLuanVan.setBounds(56, 104, 140, 20);
		pnThongTinLuanVan.add(lblNoiDungLuanVan);
		
		txtLinhVucNghienCuu = new JTextField();
		txtLinhVucNghienCuu.setColumns(10);
		txtLinhVucNghienCuu.setBounds(217, 75, 955, 20);
		pnThongTinLuanVan.add(txtLinhVucNghienCuu);
		
		txtNoiDungLuanVan = new JTextField();
		txtNoiDungLuanVan.setColumns(10);
		txtNoiDungLuanVan.setBounds(217, 106, 955, 20);
		pnThongTinLuanVan.add(txtNoiDungLuanVan);
		
		JLabel lblNamHoc = new JLabel("Năm học: ");
		lblNamHoc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNamHoc.setBounds(56, 206, 107, 20);
		pnThongTinLuanVan.add(lblNamHoc);
		
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
		
		comboBoxSoNhomThamGia = new JComboBox();
		comboBoxSoNhomThamGia.setModel(new DefaultComboBoxModel(new String[] {"2", "3", "5"}));
		comboBoxSoNhomThamGia.setBounds(217, 271, 955, 18);
		pnThongTinLuanVan.add(comboBoxSoNhomThamGia);
		
		comboBoxNamHoc = new JComboBox();
		comboBoxNamHoc.setBounds(217, 208, 955, 18);
		pnThongTinLuanVan.add(comboBoxNamHoc);
		
		btnThem = new JButton("Thêm");
		btnThem.setBounds(258, 370, 127, 44);
		pnCenter.add(btnThem);
		
		btnSua = new JButton("Sửa");
		btnSua.setBounds(517, 370, 127, 44);
		pnCenter.add(btnSua);
		
		btnXoa = new JButton("Xóa");
		btnXoa.setBounds(779, 370, 127, 44);
		pnCenter.add(btnXoa);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(null, "Danh s\u00E1ch lu\u1EADn v\u0103n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 425, 1244, 443);
		pnCenter.add(panel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 22, 1224, 381);
		panel.add(scrollPane);
		
		table = new JTable();
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "M\u00E3 lu\u1EADn v\u0103n", "T\u00EAn lu\u1EADn v\u0103n", "L\u0129nh v\u1EF1c nghi\u00EAn c\u1EE9u", "N\u1ED9i dung", "N\u0103m h\u1ECDc", "T\u00F3m t\u1EAFt", "Gi\u00E1o vi\u00EAn ra \u0111\u1EC1 t\u00E0i", "S\u1ED1 nh\u00F3m tham gia t\u1ED1i \u0111a"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblTieuDe = new JLabel("Quản lý luận văn");
		lblTieuDe.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		pnChung.add(lblTieuDe, BorderLayout.NORTH);
		
		updateComboBoxTenGiaoVien();
		updateComboBoxNamHoc();
		luanVanDao.updateBangLuanVan(table);
		btnThem.addActionListener(this);
		table.addMouseListener(this);
		btnXoa.addActionListener(this);
		btnSua.addActionListener(this);
		
	}
	public JPanel getPanel() {
		return pnChung;
	}
	
	public int timChiSoComboNamHoc() {
		int row = table.getSelectedRow();
		int index = 0;
		for (int i = 0; i < 3; i++) {
			if(table.getValueAt(row, 5).toString().trim().equals(comboBoxNamHoc.getItemAt(i).toString().trim())) {
				index = i;
			}
		}
		return index;
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
	
	public int timChiSoNhomThamGia() {
		int row = table.getSelectedRow();
		int index = 0;
		for (int i = 0; i < comboBoxSoNhomThamGia.getItemCount(); i++) {
			if(comboBoxSoNhomThamGia.getItemAt(i).toString().trim().equals(table.getValueAt(row, 8).toString().trim())) {
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
		txtNoiDungLuanVan.setText(table.getValueAt(row, 4).toString());
		txtaTomTat.setText(table.getValueAt(row, 6).toString());
		
		comboBoxNamHoc.setSelectedIndex(timChiSoComboNamHoc());
		comboBoxTenGiaoVien.setSelectedIndex(timChiSoTenGiaoVien());
		comboBoxSoNhomThamGia.setSelectedIndex(timChiSoNhomThamGia());
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
		try {
			listGV = giaoVienDao.docTuBang();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(GiaoVien gv: listGV) {
			DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) comboBoxTenGiaoVien.getModel();
			comboBoxModel.addElement(gv.getHoTen() + " - " + gv.getMaGiaoVien());
		}
	}
	
	public void updateComboBoxNamHoc() {
		LocalDate date = LocalDate.now();
		int nam = date.getYear();
		DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) comboBoxNamHoc.getModel();
		comboBoxModel.addElement(nam);
		comboBoxModel.addElement(nam + 1);
		comboBoxModel.addElement(nam + 2);
	}
	
	public boolean kiemTraTextField() {
		String regex = "[A-Z]+.*(\\s[A-Z]+.*)*";
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
		if(!txtNoiDungLuanVan.getText().trim().matches(regex)) {
			JOptionPane.showMessageDialog(frame, "Chữ đầu tiên là chữ hoa, theo sau là các ký tự thường.");
			txtNoiDungLuanVan.requestFocus();
			txtNoiDungLuanVan.selectAll();
			return false;
		}
		return true;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnThem)) {
			if(kiemTraTextField()) {
				String regex = "GV\\d{3}";
				String tenLuanVan = txtTenLuanVan.getText();
				String linhVucNghienCuu = txtLinhVucNghienCuu.getText();
				String noiDungLuanVan = txtNoiDungLuanVan.getText();
				String tomTat = txtaTomTat.getText();
				int namHoc = Integer.parseInt(comboBoxNamHoc.getSelectedItem().toString());
				int soNhomThamGia = Integer.parseInt(comboBoxSoNhomThamGia.getSelectedItem().toString());
				
				Pattern pattern = Pattern.compile(regex);
				Matcher matcher = pattern.matcher(comboBoxTenGiaoVien.getSelectedItem().toString());
				String maGiaoVien = "";
				while(matcher.find()) {
					maGiaoVien += comboBoxTenGiaoVien.getSelectedItem().toString().substring(matcher.start(), matcher.end());
				}
				LuanVan lv = new LuanVan(luanVanDao.sinhMaLuanVanTuDong(), tenLuanVan, linhVucNghienCuu, noiDungLuanVan, namHoc, tomTat, maGiaoVien, soNhomThamGia);
				if(luanVanDao.kiemTraLuanVanDaTonTai(tenLuanVan, linhVucNghienCuu)) {
					JOptionPane.showMessageDialog(frame, "Luận văn đã tồn tại");
					return;
				}
				luanVanDao.themLuanVan(lv);
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);
				luanVanDao.updateBangLuanVan(table);
			}
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
					}
				}
			}
		} else if(o.equals(btnSua)) {
			String regex = "GV\\d{3}";
			String tenLuanVan = txtTenLuanVan.getText();
			String linhVucNghienCuu = txtLinhVucNghienCuu.getText();
			String noiDungLuanVan = txtNoiDungLuanVan.getText();
			String tomTat = txtaTomTat.getText();
			int namHoc = Integer.parseInt(comboBoxNamHoc.getSelectedItem().toString());
			int soNhomThamGia = Integer.parseInt(comboBoxSoNhomThamGia.getSelectedItem().toString());
			
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(comboBoxTenGiaoVien.getSelectedItem().toString());
			String maGiaoVien = "";
			while(matcher.find()) {
				maGiaoVien += comboBoxTenGiaoVien.getSelectedItem().toString().substring(matcher.start(), matcher.end());
			}
			LuanVan lv = new LuanVan(luanVanDao.sinhMaLuanVanTuDong(), tenLuanVan, linhVucNghienCuu, noiDungLuanVan, namHoc, tomTat, maGiaoVien, soNhomThamGia);
			String maLuanVan = table.getValueAt(table.getSelectedRow(), 1).toString();
			LuanVan lvCu = luanVanDao.timLuanVanTheoMa(maLuanVan);
			if(luanVanDao.kiemTraLuanVanDaTonTai(tenLuanVan, linhVucNghienCuu) && (!lv.getTenLuanVan().equals(tenLuanVan) || !lv.getLinhVucNghienCuu().equals(linhVucNghienCuu))) {
				JOptionPane.showMessageDialog(frame, "Luận văn đã tồn tại");
				return;
			}
			luanVanDao.suaLuanVan(maLuanVan, lv);
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.setRowCount(0);
			luanVanDao.updateBangLuanVan(table);
		}
		
	}
}
