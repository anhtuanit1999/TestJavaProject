package gitHub;

public class SinhVien {
	private String hoTen, ngaySinh, soDienThoai, diaChi, khoaTrucThuoc, namVaoTruong, namTotNghiep;

	public SinhVien(String hoTen, String ngaySinh, String soDienThoai, String diaChi, String khoaTrucThuoc,
			String namVaoTruong, String namTotNghiep) {
		super();
		this.hoTen = hoTen;
		this.ngaySinh = ngaySinh;
		this.soDienThoai = soDienThoai;
		this.diaChi = diaChi;
		this.khoaTrucThuoc = khoaTrucThuoc;
		this.namVaoTruong = namVaoTruong;
		this.namTotNghiep = namTotNghiep;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getKhoaTrucThuoc() {
		return khoaTrucThuoc;
	}

	public void setKhoaTrucThuoc(String khoaTrucThuoc) {
		this.khoaTrucThuoc = khoaTrucThuoc;
	}

	public String getNamVaoTruong() {
		return namVaoTruong;
	}

	public void setNamVaoTruong(String namVaoTruong) {
		this.namVaoTruong = namVaoTruong;
	}

	public String getNamTotNghiep() {
		return namTotNghiep;
	}

	public void setNamTotNghiep(String namTotNghiep) {
		this.namTotNghiep = namTotNghiep;
	}

	@Override
	public String toString() {
		return "SinhVien [hoTen=" + hoTen + ", ngaySinh=" + ngaySinh + ", soDienThoai=" + soDienThoai + ", diaChi="
				+ diaChi + ", khoaTrucThuoc=" + khoaTrucThuoc + ", namVaoTruong=" + namVaoTruong + ", namTotNghiep="
				+ namTotNghiep + "]";
	}
	
}
