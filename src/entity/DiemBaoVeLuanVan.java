package entity;

import java.io.Serializable;

public class DiemBaoVeLuanVan implements Serializable {
	private int maGiaoVien;
	private int maSinhVien;
	private float diem;
	private String ghiChu;
	public DiemBaoVeLuanVan(int maGiaoVien, int maSinhVien, float diem, String ghiChu) {
		super();
		this.maGiaoVien = maGiaoVien;
		this.maSinhVien = maSinhVien;
		this.diem = diem;
		this.ghiChu = ghiChu;
	}
	public int getMaGiaoVien() {
		return maGiaoVien;
	}
	public void setMaGiaoVien(int maGiaoVien) {
		this.maGiaoVien = maGiaoVien;
	}
	public int getMaSinhVien() {
		return maSinhVien;
	}
	public void setMaSinhVien(int maSinhVien) {
		this.maSinhVien = maSinhVien;
	}
	public float getDiem() {
		return diem;
	}
	public void setDiem(float diem) {
		this.diem = diem;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	@Override
	public String toString() {
		return "DiemBaoVeLuanVan [maGiaoVien=" + maGiaoVien + ", maSinhVien=" + maSinhVien + ", diem=" + diem
				+ ", ghiChu=" + ghiChu + "]";
	}
	
}

/*
* (C) Copyright 2020 IUH. All rights reserved.
*
* @author: AnhTuanIT
* @date: 05-11-2020
* @version: 1.0
*/
