package gitHub;

public class LuanVan {
	private String linhVucNghienCuu;
	private int maLuanVan;
	private int maSinhVien;
	private String noiDungLuanVan;
	private String tenLuanVan;
	private String tomTat;
	public String getLinhVucNghienCuu() {
		return linhVucNghienCuu;
	}
	public void setLinhVucNghienCuu(String linhVucNghienCuu) {
		this.linhVucNghienCuu = linhVucNghienCuu;
	}
	public int getMaLuanVan() {
		return maLuanVan;
	}
	public void setMaLuanVan(int maLuanVan) {
		this.maLuanVan = maLuanVan;
	}
	public int getMaSinhVien() {
		return maSinhVien;
	}
	public void setMaSinhVien(int maSinhVien) {
		this.maSinhVien = maSinhVien;
	}
	public String getNoiDungLuanVan() {
		return noiDungLuanVan;
	}
	public void setNoiDungLuanVan(String noiDungLuanVan) {
		this.noiDungLuanVan = noiDungLuanVan;
	}
	public String getTenLuanVan() {
		return tenLuanVan;
	}
	public void setTenLuanVan(String tenLuanVan) {
		this.tenLuanVan = tenLuanVan;
	}
	public String getTomTat() {
		return tomTat;
	}
	public void setTomTat(String tomTat) {
		this.tomTat = tomTat;
	}
	public LuanVan(String linhVucNghienCuu, int maLuanVan, int maSinhVien, String noiDungLuanVan, String tenLuanVan,
			String tomTat) {
		super();
		this.linhVucNghienCuu = linhVucNghienCuu;
		this.maLuanVan = maLuanVan;
		this.maSinhVien = maSinhVien;
		this.noiDungLuanVan = noiDungLuanVan;
		this.tenLuanVan = tenLuanVan;
		this.tomTat = tomTat;
	}
	public LuanVan() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "LuanVan [linhVucNghienCuu=" + linhVucNghienCuu + ", maLuanVan=" + maLuanVan + ", maSinhVien="
				+ maSinhVien + ", noiDungLuanVan=" + noiDungLuanVan + ", tenLuanVan=" + tenLuanVan + ", tomTat="
				+ tomTat + "]";
	}
}
