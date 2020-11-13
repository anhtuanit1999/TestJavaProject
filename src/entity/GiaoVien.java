package entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class GiaoVien implements Serializable {
	private String maGiaoVien;
	private String hoTen;
	private String chucDanh;
	private String linhVucCongTac;
	private String donViCongTac;
	private String khoaCongTac;
	public GiaoVien(String maGiaoVien, String hoTen, String chucDanh, String linhVucCongTac, String donViCongTac,
			String khoaCongTac) {
		super();
		this.maGiaoVien = maGiaoVien;
		this.hoTen = hoTen;
		this.chucDanh = chucDanh;
		this.linhVucCongTac = linhVucCongTac;
		this.donViCongTac = donViCongTac;
		this.khoaCongTac = khoaCongTac;
	}
	public String getMaGiaoVien() {
		return maGiaoVien;
	}
	public void setMaGiaoVien(String maGiaoVien) {
		this.maGiaoVien = maGiaoVien;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getChucDanh() {
		return chucDanh;
	}
	public void setChucDanh(String chucDanh) {
		this.chucDanh = chucDanh;
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
	@Override
	public String toString() {
		return "GiaoVien [maGiaoVien=" + maGiaoVien + ", hoTen=" + hoTen + ", chucDanh=" + chucDanh
				+ ", linhVucCongTac=" + linhVucCongTac + ", donViCongTac=" + donViCongTac + ", khoaCongTac="
				+ khoaCongTac + "]";
	}
	
}

/*
* (C) Copyright 2020 IUH. All rights reserved.
*
* @author: AnhTuanIT
* @date: 05-11-2020
* @version: 1.0
*/
