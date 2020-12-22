package entity;

import java.io.Serializable;
import java.util.Date;

public class LuanVan implements Serializable {
	private String maLuanVan;
	private String tenLuanVan;
	private String linhVucNghienCuu;
	private String moTa;
	
	private Date ngayLap;
	
	private String maGiaoVien;
	private int soNhomThamGiaToiDa;
	public LuanVan(String maLuanVan, String tenLuanVan, String linhVucNghienCuu, String moTa, Date ngayLap,
			String maGiaoVien, int soNhomThamGiaToiDa) {
		super();
		this.maLuanVan = maLuanVan;
		this.tenLuanVan = tenLuanVan;
		this.linhVucNghienCuu = linhVucNghienCuu;
		this.moTa = moTa;
		this.ngayLap = ngayLap;
		this.maGiaoVien = maGiaoVien;
		this.soNhomThamGiaToiDa = soNhomThamGiaToiDa;
	}
	public LuanVan() {
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
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public Date getNgayLap() {
		return ngayLap;
	}
	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
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
	@Override
	public String toString() {
		return "LuanVan [maLuanVan=" + maLuanVan + ", tenLuanVan=" + tenLuanVan + ", linhVucNghienCuu="
				+ linhVucNghienCuu + ", moTa=" + moTa + ", ngayLap=" + ngayLap + ", maGiaoVien=" + maGiaoVien
				+ ", soNhomThamGiaToiDa=" + soNhomThamGiaToiDa + "]";
	}
	
	
	
}

/*
* (C) Copyright 2020 IUH. All rights reserved.
*
* @author: AnhTuanIT
* @date: 05-11-2020
* @version: 1.0
*/
