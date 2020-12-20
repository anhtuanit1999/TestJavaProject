 package giaovien;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.text.ParseException;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.Database;
import dao.GiaoVienDao;
import entity.GiaoVien;
import entity.SinhVien;

public class GiaoDien_GiaoVien {

	private JFrame frame;
	private JTextField txtMSGV;
	private JTextField txtHoTen;
	private JTextField txtChucDanh;
	private JTextField txtLinhVucCongTac;
	private JTextField txtDonViCongTac;
	private JTextField txtKhoaCongTac;
	private JLabel lblIcon;
	private JPanel pnChung;
	private GiaoVienDao giaoVienDao;
	private String maGiaoVien;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GiaoDien_GiaoVien window = new GiaoDien_GiaoVien("GV001");
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
	public GiaoDien_GiaoVien(String maGiaoVien) {
		this.maGiaoVien = maGiaoVien;
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
		frame = new JFrame();
		frame.setBounds(10, 10, 1280, 950);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setResizable(false);
		
		pnChung = new JPanel();
		frame.getContentPane().add(pnChung, BorderLayout.CENTER);
		pnChung.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTieuDe = new JLabel("Giao Diện Giáo Viên");
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDe.setFont(new Font("Tahoma", Font.PLAIN, 25));
		pnChung.add(lblTieuDe, BorderLayout.NORTH);
		
		JPanel pnCenter = new JPanel();
		pnCenter.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Th\u00F4ng tin gi\u00E1o vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnChung.add(pnCenter, BorderLayout.CENTER);
		pnCenter.setLayout(null);
		
		JLabel lblMaGiaoVien = new JLabel("Mã giáo viên: ");
		lblMaGiaoVien.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMaGiaoVien.setBounds((int)Math.round(width/2 - (oldWidth/2 - 10)), 245, 116, 17);
		pnCenter.add(lblMaGiaoVien);
		
		txtMSGV = new JTextField();
		txtMSGV.setEditable(false);
		txtMSGV.setBounds((int)Math.round(width/2 - (oldWidth/2 - 196)), 242, 419, 20);
		pnCenter.add(txtMSGV);
		txtMSGV.setColumns(10);
		
		JLabel lblHoTen = new JLabel("Họ tên: ");
		lblHoTen.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHoTen.setBounds((int)Math.round(width/2 - (oldWidth/2 - 10)), 298, 116, 17);
		pnCenter.add(lblHoTen);
		
		txtHoTen = new JTextField();
		txtHoTen.setEditable(false);
		txtHoTen.setBounds((int)Math.round(width/2 - (oldWidth/2 - 196)), 295, 419, 20);
		pnCenter.add(txtHoTen);
		txtHoTen.setColumns(10);
		
		JLabel lblChucDanh = new JLabel("Chức danh: ");
		lblChucDanh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblChucDanh.setBounds((int)Math.round(width/2 - (oldWidth/2 - 10)), 352, 116, 17);
		pnCenter.add(lblChucDanh);
		
		txtChucDanh = new JTextField();
		txtChucDanh.setEditable(false);
		txtChucDanh.setBounds((int)Math.round(width/2 - (oldWidth/2 - 196)), 352, 419, 20);
		pnCenter.add(txtChucDanh);
		txtChucDanh.setColumns(10);
		
		JLabel lblDonViCongTac = new JLabel("Đơn vị công tác: ");
		lblDonViCongTac.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDonViCongTac.setBounds((int)Math.round(width/2 - (oldWidth/2 - 10)), 423, 116, 17);
		pnCenter.add(lblDonViCongTac);
		
		txtLinhVucCongTac = new JTextField();
		txtLinhVucCongTac.setEditable(false);
		txtLinhVucCongTac.setBounds((int)Math.round(width/2 - (oldWidth/2 - 196)), 420, 419, 20);
		pnCenter.add(txtLinhVucCongTac);
		txtLinhVucCongTac.setColumns(10);
		
		JLabel lblKhoaCongTac = new JLabel("Khoa công tác: ");
		lblKhoaCongTac.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblKhoaCongTac.setBounds((int)Math.round(width/2 - (oldWidth/2 - 10)), 489, 116, 17);
		pnCenter.add(lblKhoaCongTac);
		
		txtDonViCongTac = new JTextField();
		txtDonViCongTac.setEditable(false);
		txtDonViCongTac.setBounds((int)Math.round(width/2 - (oldWidth/2 - 196)), 486, 419, 20);
		pnCenter.add(txtDonViCongTac);
		txtDonViCongTac.setColumns(10);
		
		JLabel lblLinhVucCongTac = new JLabel("Lĩnh vực công tác: ");
		lblLinhVucCongTac.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLinhVucCongTac.setBounds((int)Math.round(width/2 - (oldWidth/2 - 10)), 550, 125, 17);
		pnCenter.add(lblLinhVucCongTac);
		
		txtKhoaCongTac = new JTextField();
		txtKhoaCongTac.setEditable(false);
		txtKhoaCongTac.setBounds((int)Math.round(width/2 - (oldWidth/2 - 196)), 547, 419, 20);
		pnCenter.add(txtKhoaCongTac);
		txtKhoaCongTac.setColumns(10);
		
		lblIcon = new JLabel("");
		lblIcon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblIcon.setIcon(new ImageIcon(getClass().getResource("/avatar.png")));
		lblIcon.setBounds((int)Math.round(width/2 - (oldWidth/2 - 822)), 239, 245, 328);
		pnCenter.add(lblIcon);
		
		try {
			capNhat();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public JPanel getPanel() {
		return pnChung;
	}
	
	public void capNhat() throws ParseException {
		updateTextField();
	}
	public void updateTextField() throws ParseException {
		GiaoVien gv = giaoVienDao.timGiaoVien(maGiaoVien);
		txtMSGV.setText(gv.getMaGiaoVien());
		txtHoTen.setText(gv.getHoTen());
		txtChucDanh.setText(gv.getChucDanh());
		txtLinhVucCongTac.setText(gv.getLinhVucCongTac());
		txtDonViCongTac.setText(gv.getDonViCongTac());
		txtKhoaCongTac.setText(gv.getKhoaCongTac());
		
		
//		List<GiaoVien> listDeTai = deTaiDao.docTuBang();
//		DeTai dt = listDeTai.get(ma);
//		txtTenDeTai.setText(dt.getTenDeTai());
		
	}	
}
