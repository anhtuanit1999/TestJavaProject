package entity;

import java.io.Serializable;

public class DeTai implements Serializable {
	private String maDeTai;
	private String maGiaoVienRaDe;
	private String tenDeTai;
	private String moTaDeTai;
	private int soNhomThamGia;
	private String namHoc;
	public String getMaDeTai() {
		return maDeTai;
	}
	public void setMaDeTai(String maDeTai) {
		this.maDeTai = maDeTai;
	}
	public String getMaGiaoVienRaDe() {
		return maGiaoVienRaDe;
	}
	public void setMaGiaoVienRaDe(String maGiaoVienRaDe) {
		this.maGiaoVienRaDe = maGiaoVienRaDe;
	}
	public String getTenDeTai() {
		return tenDeTai;
	}
	public void setTenDeTai(String tenDeTai) {
		this.tenDeTai = tenDeTai;
	}
	public String getMoTaDeTai() {
		return moTaDeTai;
	}
	public void setMoTaDeTai(String moTaDeTai) {
		this.moTaDeTai = moTaDeTai;
	}
	public int getSoNhomThamGia() {
		return soNhomThamGia;
	}
	public void setSoNhomThamGia(int soNhomThamGia) {
		this.soNhomThamGia = soNhomThamGia;
	}
	public String getNamHoc() {
		return namHoc;
	}
	public void setNamHoc(String namHoc) {
		this.namHoc = namHoc;
	}
	public DeTai(String maDeTai, String maGiaoVienRaDe, String tenDeTai, String moTaDeTai, int soNhomThamGia,
			String namHoc) {
		super();
		this.maDeTai = maDeTai;
		this.maGiaoVienRaDe = maGiaoVienRaDe;
		this.tenDeTai = tenDeTai;
		this.moTaDeTai = moTaDeTai;
		this.soNhomThamGia = soNhomThamGia;
		this.namHoc = namHoc;
	}
	public DeTai() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "DeTai [maDeTai=" + maDeTai + ", maGiaoVienRaDe=" + maGiaoVienRaDe + ", tenDeTai=" + tenDeTai
				+ ", moTaDeTai=" + moTaDeTai + ", soNhomThamGia=" + soNhomThamGia + ", namHoc=" + namHoc + "]";
	}
	
}

/*
* (C) Copyright 2020 IUH. All rights reserved.
*
* @author: AnhTuanIT
* @date: 05-11-2020
* @version: 1.0
*/
