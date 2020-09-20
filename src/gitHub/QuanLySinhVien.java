package gitHub;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.TabExpander;

public class QuanLySinhVien extends JFrame implements ActionListener {
	JLabel lblHoTen, lblNgaySinh, lblSoDienThoai, lblDiaChi, lblKhoaTrucThuoc, lblNamVaoTruong, lblNamTotNghiep, lblTieuDe;
	JTextField txtHoTen, txtNgaySinh, txtSoDienThoai, txtDiaChi, txtKhoaTrucThuoc, txtNamVaoTruong, txtNamTotNghiep;
	JButton btnThem, btnXoa, btnSua, btnKiemTra, btnCapNhat;
	
	DefaultTableModel tableModel;
	JTable table;
	JScrollPane scroll;
	
	JPanel panel;
	
	public QuanLySinhVien() {
		// Cấu hình app
		super("Quản lý sinh viên");
		setSize(1280, 1024);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		Box bCenter, b0, b1, b2, b3, b4, b5, b6, b7, b8, b9;
		bCenter = Box.createVerticalBox();
		bCenter.add(Box.createVerticalStrut(20));
		lblTieuDe = new JLabel("Quản lý sinh viên");
		lblTieuDe.setFont(new Font("Arial", Font.BOLD, 20));
		b0 = Box.createHorizontalBox();
		bCenter.add(b0);
		b0.add(Box.createHorizontalStrut(20));
		b0.add(lblTieuDe, SwingConstants.CENTER);
		b0.add(Box.createHorizontalStrut(20));
		bCenter.add(Box.createVerticalStrut(20));
		
		bCenter.add(Box.createVerticalStrut(100));
		
		b1 = Box.createHorizontalBox();
		bCenter.add(b1);
		b1.add(Box.createHorizontalStrut(20));
		b1.add(lblHoTen = new JLabel("Họ tên: "));
		b1.add(Box.createHorizontalStrut(20));
		b1.add(txtHoTen = new JTextField());
		b1.add(Box.createHorizontalStrut(20));
		b1.add(btnKiemTra = new JButton("Kiểm tra"));
		b1.add(Box.createHorizontalStrut(20));
		bCenter.add(Box.createVerticalStrut(20));
		
		b2 = Box.createHorizontalBox();
		bCenter.add(b2);
		b2.add(Box.createHorizontalStrut(20));
		b2.add(lblNgaySinh = new JLabel("Ngày sinh: "));
		b2.add(Box.createHorizontalStrut(20));
		b2.add(txtNgaySinh = new JTextField());
		b2.add(Box.createHorizontalStrut(20));
		bCenter.add(Box.createVerticalStrut(20));
		
		b3 = Box.createHorizontalBox();
		bCenter.add(b3);
		b3.add(Box.createHorizontalStrut(20));
		b3.add(lblSoDienThoai = new JLabel("Số điện thoại: "));
		b3.add(Box.createHorizontalStrut(20));
		b3.add(txtSoDienThoai = new JTextField());
		b3.add(Box.createHorizontalStrut(20));
		bCenter.add(Box.createVerticalStrut(20));
		
		b4 = Box.createHorizontalBox();
		bCenter.add(b4);
		b4.add(Box.createHorizontalStrut(20));
		b4.add(lblDiaChi = new JLabel("Địa chỉ: "));
		b4.add(Box.createHorizontalStrut(20));
		b4.add(txtDiaChi = new JTextField());
		b4.add(Box.createHorizontalStrut(20));
		bCenter.add(Box.createVerticalStrut(20));
		
		b5 = Box.createHorizontalBox();
		bCenter.add(b5);
		b5.add(Box.createHorizontalStrut(20));
		b5.add(lblKhoaTrucThuoc = new JLabel("Khoa trực thuộc: "));
		b5.add(Box.createHorizontalStrut(20));
		b5.add(txtKhoaTrucThuoc = new JTextField());
		b5.add(Box.createHorizontalStrut(20));
		bCenter.add(Box.createVerticalStrut(20));
		
		b6 = Box.createHorizontalBox();
		bCenter.add(b6);
		b6.add(Box.createHorizontalStrut(20));
		b6.add(lblNamVaoTruong = new JLabel("Năm vào trường: "));
		b6.add(Box.createHorizontalStrut(20));
		b6.add(txtNamVaoTruong = new JTextField());
		b6.add(Box.createHorizontalStrut(20));
		bCenter.add(Box.createVerticalStrut(20));
		
		b7 = Box.createHorizontalBox();
		bCenter.add(b7);
		b7.add(Box.createHorizontalStrut(20));
		b7.add(lblNamTotNghiep = new JLabel("Năm tốt nghiệp: "));
		b7.add(Box.createHorizontalStrut(20));
		b7.add(txtNamTotNghiep = new JTextField());
		b7.add(Box.createHorizontalStrut(20));
		bCenter.add(Box.createVerticalStrut(100));
		
		b8 = Box.createHorizontalBox();
		bCenter.add(b8);
		b8.add(btnThem = new JButton("Thêm"));
		b8.add(Box.createHorizontalStrut(20));
		b8.add(btnXoa = new JButton("Xóa"));
		b8.add(Box.createHorizontalStrut(20));
		b8.add(btnSua = new JButton("Sửa"));
		b8.add(Box.createHorizontalStrut(20));
		b8.add(btnCapNhat = new JButton("Cập nhật"));
		bCenter.add(Box.createVerticalStrut(20));
		
		b9 = Box.createHorizontalBox();
		bCenter.add(b9);
		b9.add(Box.createHorizontalStrut(20));
		String[] columns = {"Họ tên", "Ngày sinh", "Khoa trực thuộc", "Năm vào trường", "Năm tốt nghiệp"};
		tableModel = new DefaultTableModel(columns, 0);
		b9.add(scroll = new JScrollPane(table = new JTable(tableModel)));
		b9.add(Box.createHorizontalStrut(20));
		bCenter.add(Box.createVerticalStrut(20));
		
		lblHoTen.setPreferredSize(lblNamVaoTruong.getPreferredSize());
		lblNgaySinh.setPreferredSize(lblNamVaoTruong.getPreferredSize());
		lblSoDienThoai.setPreferredSize(lblNamVaoTruong.getPreferredSize());
		lblDiaChi.setPreferredSize(lblNamVaoTruong.getPreferredSize());
		lblKhoaTrucThuoc.setPreferredSize(lblNamVaoTruong.getPreferredSize());
		lblNamTotNghiep.setPreferredSize(lblNamVaoTruong.getPreferredSize());
		
		bCenter.setBorder(BorderFactory.createTitledBorder("Quản lý sinh viên"));
		
		add(bCenter, BorderLayout.CENTER);
		
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnSua.addActionListener(this);
		btnCapNhat.addActionListener(this);
		btnKiemTra.addActionListener(this);
		panel = new JPanel(new BorderLayout());
		panel.add(bCenter, BorderLayout.CENTER);
	}
	
	public static void main(String[] args) {
		new QuanLySinhVien().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnThem)) {
			if (!kiemTraNhap()) {
				
			}
			
		} else if (o.equals(btnXoa)) {
			
		} else if (o.equals(btnSua)) {
			
		} else if (o.equals(btnCapNhat)) {
			
		} else if (o.equals(btnKiemTra)) {
			
		}
	}
	
	public JPanel getPanel() {
		return panel;
	}
	
	public boolean kiemTraNhap() {
		// Kiểm tra họ tên
		if (!txtHoTen.getText().trim().matches("[A-Z][a-z]+(\s[A-Z][a-z]*)*")) {
			txtHoTen.requestFocus();
			txtHoTen.selectAll();
			JOptionPane.showMessageDialog(this, "Các ký tự đầu phải là chữ in hoa, mỗi từ cách nhau bởi dấu cách");
			return false;
		}
		
		// Kiểm tra ngày sinh có đúng định dạng không?
		if (!txtNgaySinh.getText().trim().matches("\\d{2}[/-]\\d{2}[/-]\\d{4}")) {
			txtNgaySinh.requestFocus();
			txtNgaySinh.selectAll();
			JOptionPane.showMessageDialog(this, "Định dạng ngày sinh thuộc dạng dd-mm-yyyy hoặc dd/mm/yyyy");
			return false;
		} else { // Kiểm tra ngày sinh nếu nhập đúng thì kiểm tra tiếp xem tuổi có lớn hơn 18 không?
			String txtNS = txtNgaySinh.getText().trim();
			int nam = Integer.parseInt(txtNS.substring(6, 10));
			int thang = Integer.parseInt(txtNS.substring(3, 5));
			int ngay = Integer.parseInt(txtNS.substring(0, 2));
			
			LocalDate ngayHomNay = LocalDate.now();
			LocalDate ngaySinh = LocalDate.of(nam, thang, ngay);
			if (!ngaySinh.isBefore(ngayHomNay) || (ngayHomNay.getYear() - ngaySinh.getYear() + 1 < 18)) {
				txtNgaySinh.requestFocus();
				txtNgaySinh.selectAll();
				JOptionPane.showMessageDialog(this, "Ngày sinh nhập sai địng dạng (dd/mm/yyyy hoặc dd-mm-yyyy) hoặc tuổi nhỏ hơn 18t");
				return false;
			}
		}
		
		// Kiểm tra số điện thoại có đúng định dạng không?
		if (!txtSoDienThoai.getText().trim().matches("0\\d{9}")) {
			txtSoDienThoai.requestFocus();
			txtSoDienThoai.selectAll();
			JOptionPane.showMessageDialog(this, "Số điện thoại phải có 10 ký tự số và bắt đầu bằng số 0");
			return false;
		}
		
		// Kiểm tra địa chỉ có đúng định dạng không?
		if (!txtDiaChi.getText().trim().matches("[a-zA-Z0-9,/]+(\s[a-zA-Z0-9,/]*)*")) {
			txtDiaChi.requestFocus();
			txtDiaChi.selectAll();
			JOptionPane.showMessageDialog(this, "Mỗi từ cách nhau bởi dấu cách và có chứa ký tự số, ký tự chưa, ký tự \",\"");
			return false;
		}
		
		// Kiểm tra khoa trực thuộc có đúng định dạng không?
		if (!txtKhoaTrucThuoc.getText().trim().matches("[A-Z][a-z]+(\s[A-Z][a-z]*)*")) {
			txtKhoaTrucThuoc.requestFocus();
			txtKhoaTrucThuoc.selectAll();
			JOptionPane.showMessageDialog(this, "Các ký tự đầu phải là chữ in hoa, mỗi từ cách nhau bởi dấu cách");
			return false;
		}
		
		// Kiểm tra năm vào trường có lớn hơn năm hiện tại không hoặc có đúng định dạng không?
		if (!txtNamVaoTruong.getText().trim().matches("\\d{4}")) {
			txtNamVaoTruong.requestFocus();
			txtNamVaoTruong.selectAll();
			JOptionPane.showMessageDialog(this, "Định dạng năm yyyy");
		} else {
			if (Integer.parseInt(txtNamVaoTruong.getText().trim()) > LocalDate.now().getYear()) {
				txtNamVaoTruong.requestFocus();
				txtNamVaoTruong.selectAll();
				JOptionPane.showMessageDialog(this, "Năm vào trường nhỏ hơn hoặc bằng năm hiện tại");
			}
		}
		// Kiểm tra năm tốt nghiệp có lớn hơn năm hiện tại không hoặc có đúng định dạng không?
		if (!txtNamTotNghiep.getText().trim().matches("\\d{4}")) {
			txtNamTotNghiep.requestFocus();
			txtNamTotNghiep.selectAll();
			JOptionPane.showMessageDialog(this, "Định dạng năm yyyy");
		} else {
			if (Integer.parseInt(txtNamVaoTruong.getText().trim()) > Integer.parseInt(txtNamTotNghiep.getText().trim())) {
				txtNamVaoTruong.requestFocus();
				txtNamVaoTruong.selectAll();
				JOptionPane.showMessageDialog(this, "Năm vào trường nhỏ hơn năm tốt nghiệp");
			}
		}
		return true;
	}
}
