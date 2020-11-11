package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LuanVan implements Serializable {
	@Id
	@Column(name = "MALUANVAN")
	private String maLuanVan;
	
	@Column(name = "MADETAI")
	private String maDeTai;
	
	
	private SinhVien sinhVien;
	
	private String tenLuanVan;
	
	private String linhVucNghienCuu;
	
	private String noiDungLuanVan;
	
	private String tomTat;

	public String getMaLuanVan() {
		return maLuanVan;
	}

	public void setMaLuanVan(String maLuanVan) {
		this.maLuanVan = maLuanVan;
	}

	public String getMaDeTai() {
		return maDeTai;
	}

	public void setMaDeTai(String maDeTai) {
		this.maDeTai = maDeTai;
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

	public String getTomTat() {
		return tomTat;
	}

	public void setTomTat(String tomTat) {
		this.tomTat = tomTat;
	}

	public LuanVan(String maLuanVan, String maDeTai, String tenLuanVan, String linhVucNghienCuu, String noiDungLuanVan,
			String tomTat) {
		super();
		this.maLuanVan = maLuanVan;
		this.maDeTai = maDeTai;
		this.tenLuanVan = tenLuanVan;
		this.linhVucNghienCuu = linhVucNghienCuu;
		this.noiDungLuanVan = noiDungLuanVan;
		this.tomTat = tomTat;
	}

	public LuanVan() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "LuanVan [maLuanVan=" + maLuanVan + ", maDeTai=" + maDeTai + ", tenLuanVan=" + tenLuanVan
				+ ", linhVucNghienCuu=" + linhVucNghienCuu + ", noiDungLuanVan=" + noiDungLuanVan + ", tomTat=" + tomTat
				+ "]";
	}
	
}

/*
* (C) Copyright 2020 IUH. All rights reserved.
*
* @author: AnhTuanIT
* @date: 05-11-2020
* @version: 1.0
*/
