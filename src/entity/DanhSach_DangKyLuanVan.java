package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class DanhSach_DangKyLuanVan implements Serializable {
	private String maNhom;
	private String maLuanVan;
	private String maHoiDong;
	private String ngayBaoCao;
	public DanhSach_DangKyLuanVan(String maNhom, String maLuanVan, String maHoiDong, String ngayBaoCao) {
		super();
		this.maNhom = maNhom;
		this.maLuanVan = maLuanVan;
		this.maHoiDong = maHoiDong;
		this.ngayBaoCao = ngayBaoCao;
	}
	public String getMaNhom() {
		return maNhom;
	}
	public void setMaNhom(String maNhom) {
		this.maNhom = maNhom;
	}
	public String getMaLuanVan() {
		return maLuanVan;
	}
	public void setMaLuanVan(String maLuanVan) {
		this.maLuanVan = maLuanVan;
	}
	public String getMaHoiDong() {
		return maHoiDong;
	}
	public void setMaHoiDong(String maHoiDong) {
		this.maHoiDong = maHoiDong;
	}
	public String getNgayBaoCao() {
		return ngayBaoCao;
	}
	public void setNgayBaoCao(String ngayBaoCao) {
		this.ngayBaoCao = ngayBaoCao;
	}
	@Override
	public String toString() {
		return "DanhSach_DangKyLuanVan [maNhom=" + maNhom + ", maLuanVan=" + maLuanVan + ", maHoiDong=" + maHoiDong
				+ ", ngayBaoCao=" + ngayBaoCao + "]";
	}
	
}

/*
* (C) Copyright 2020 IUH. All rights reserved.
*
* @author: AnhTuanIT
* @date: 05-11-2020
* @version: 1.0
*/
