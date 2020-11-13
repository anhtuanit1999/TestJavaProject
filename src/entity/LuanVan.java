package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LuanVan implements Serializable {
	private String maLuanVan;
	private String tenLuanVan;
	private String linhVucNghienCuu;
	private String noiDungLuanVan;
	private int namHoc;
	private String tomTat;
	private SinhVien maGiaoVien;
	public LuanVan(String maLuanVan, String tenLuanVan, String linhVucNghienCuu, String noiDungLuanVan, int namHoc,
			String tomTat, SinhVien maGiaoVien) {
		super();
		this.maLuanVan = maLuanVan;
		this.tenLuanVan = tenLuanVan;
		this.linhVucNghienCuu = linhVucNghienCuu;
		this.noiDungLuanVan = noiDungLuanVan;
		this.namHoc = namHoc;
		this.tomTat = tomTat;
		this.maGiaoVien = maGiaoVien;
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
	public SinhVien getMaGiaoVien() {
		return maGiaoVien;
	}
	public void setMaGiaoVien(SinhVien maGiaoVien) {
		this.maGiaoVien = maGiaoVien;
	}
	@Override
	public String toString() {
		return "LuanVan [maLuanVan=" + maLuanVan + ", tenLuanVan=" + tenLuanVan + ", linhVucNghienCuu="
				+ linhVucNghienCuu + ", noiDungLuanVan=" + noiDungLuanVan + ", namHoc=" + namHoc + ", tomTat=" + tomTat
				+ ", maGiaoVien=" + maGiaoVien + "]";
	}
	
}

/*
* (C) Copyright 2020 IUH. All rights reserved.
*
* @author: AnhTuanIT
* @date: 05-11-2020
* @version: 1.0
*/
