package entity;

import java.io.Serializable;

public class LuanVan implements Serializable {
	private String maLuanVan;
	private String tenLuanVan;
	private String linhVucNghienCuu;
	private String noiDungLuanVan;
	private int namHoc;
	private String tomTat;
	private String maGiaoVien;
	private int soNhomThamGiaToiDa;
	private int soNhomDangKy;
	private String tenGiaoVien;
	
	public LuanVan(String maLuanVan, String tenLuanVan, String linhVucNghienCuu, String noiDungLuanVan, int namHoc,
			String tomTat, String maGiaoVien, int soNhomThamGiaToiDa) {
		super();
		this.maLuanVan = maLuanVan;
		this.tenLuanVan = tenLuanVan;
		this.linhVucNghienCuu = linhVucNghienCuu;
		this.noiDungLuanVan = noiDungLuanVan;
		this.namHoc = namHoc;
		this.tomTat = tomTat;
		this.maGiaoVien = maGiaoVien;
		this.soNhomThamGiaToiDa = soNhomThamGiaToiDa;
	}
	
	public LuanVan(String maLuanVan, String tenLuanVan, String linhVucNghienCuu, int namHoc, String tenGiaoVien, int soNhomThamGiaToiDa,
			int soNhomDangKy) {
		super();
		this.maLuanVan = maLuanVan;
		this.tenLuanVan = tenLuanVan;
		this.linhVucNghienCuu = linhVucNghienCuu;
		this.namHoc = namHoc;
		this.soNhomThamGiaToiDa = soNhomThamGiaToiDa;
		this.soNhomDangKy = soNhomDangKy;
		this.tenGiaoVien = tenGiaoVien;
	}



	public String getMaLuanVan() {
		return maLuanVan;
	}
	public void setMaLuanVan(String maLuanVan) {
		this.maLuanVan = maLuanVan;
	}
	public String getTenLuanVan() {
		return tenLuanVan;
	}
	public void setTenLuanVan(String tenLuanVan) {
		this.tenLuanVan = tenLuanVan;
	}
	public String getLinhVucNghienCuu() {
		return linhVucNghienCuu;
	}
	public void setLinhVucNghienCuu(String linhVucNghienCuu) {
		this.linhVucNghienCuu = linhVucNghienCuu;
	}
	public String getNoiDungLuanVan() {
		return noiDungLuanVan;
	}
	public void setNoiDungLuanVan(String noiDungLuanVan) {
		this.noiDungLuanVan = noiDungLuanVan;
	}
	public int getNamHoc() {
		return namHoc;
	}
	public void setNamHoc(int namHoc) {
		this.namHoc = namHoc;
	}
	public String getTomTat() {
		return tomTat;
	}
	public void setTomTat(String tomTat) {
		this.tomTat = tomTat;
	}
	public String getMaGiaoVien() {
		return maGiaoVien;
	}
	public void setMaGiaoVien(String maGiaoVien) {
		this.maGiaoVien = maGiaoVien;
	}
	public int getSoNhomThamGiaToiDa() {
		return soNhomThamGiaToiDa;
	}
	public void setSoNhomThamGiaToiDa(int soNhomThamGiaToiDa) {
		this.soNhomThamGiaToiDa = soNhomThamGiaToiDa;
	}
	public int getSoNhomDangKy() {
		return soNhomDangKy;
	}

	public void setSoNhomDangKy(int soNhomDangKy) {
		this.soNhomDangKy = soNhomDangKy;
	}
	public String getTenGiaoVien() {
		return tenGiaoVien;
	}
	public void setTenGiaoVien(String tenGiaoVien) {
		this.tenGiaoVien = tenGiaoVien;
	}

	@Override
	public String toString() {
		return "LuanVan [maLuanVan=" + maLuanVan + ", tenLuanVan=" + tenLuanVan + ", linhVucNghienCuu="
				+ linhVucNghienCuu + ", noiDungLuanVan=" + noiDungLuanVan + ", namHoc=" + namHoc + ", tomTat=" + tomTat
				+ ", maGiaoVien=" + maGiaoVien + ", soNhomThamGiaToiDa=" + soNhomThamGiaToiDa + "]";
	}
	
	
}

/*
* (C) Copyright 2020 IUH. All rights reserved.
*
* @author: AnhTuanIT
* @date: 05-11-2020
* @version: 1.0
*/
