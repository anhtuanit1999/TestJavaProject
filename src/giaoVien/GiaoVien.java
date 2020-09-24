package giaoVien;


public class GiaoVien {
	private String chucDanh, hoTen, linhVucCongTac, donViCongTac, khoaCongTac;

	public GiaoVien(String chucDanh, String hoTen, String linhVucCongTac, String donViCongTac, String khoaCongTac) {
		super();
		this.chucDanh = chucDanh;
		this.hoTen = hoTen;
		this.linhVucCongTac = linhVucCongTac;
		this.donViCongTac = donViCongTac;
		this.khoaCongTac = khoaCongTac;
	}

	public String getChucDanh() {
		return chucDanh;
	}

	public void setChucDanh(String chucDanh) {
		this.chucDanh = chucDanh;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getLinhVucCongTac() {
		return linhVucCongTac;
	}

	public void setLinhVucCongTac(String linhVucCongTac) {
		this.linhVucCongTac = linhVucCongTac;
	}

	public String getDonViCongTac() {
		return donViCongTac;
	}

	public void setDonViCongTac(String donViCongTac) {
		this.donViCongTac = donViCongTac;
	}

	public String getKhoaCongTac() {
		return khoaCongTac;
	}

	public void setKhoaCongTac(String khoaCongTac) {
		this.khoaCongTac = khoaCongTac;
	}
	
	
	
}

