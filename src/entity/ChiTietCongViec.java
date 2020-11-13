package entity;

import java.io.Serializable;

public class ChiTietCongViec implements Serializable {
	private String maHoiDong;
	private String maGiaoVien;
	private String congViec;
	public ChiTietCongViec(String maHoiDong, String maGiaoVien, String congViec) {
		super();
		this.maHoiDong = maHoiDong;
		this.maGiaoVien = maGiaoVien;
		this.congViec = congViec;
	}
	public String getMaHoiDong() {
		return maHoiDong;
	}
	public void setMaHoiDong(String maHoiDong) {
		this.maHoiDong = maHoiDong;
	}
	public String getMaGiaoVien() {
		return maGiaoVien;
	}
	public void setMaGiaoVien(String maGiaoVien) {
		this.maGiaoVien = maGiaoVien;
	}
	public String getCongViec() {
		return congViec;
	}
	public void setCongViec(String congViec) {
		this.congViec = congViec;
	}
	@Override
	public String toString() {
		return "ChiTietCongViec [maHoiDong=" + maHoiDong + ", maGiaoVien=" + maGiaoVien + ", congViec=" + congViec
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
