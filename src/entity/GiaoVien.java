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
	@Id
	@Column(name = "MAGIAOVIEN")
	private String maGiaoVien;
	
	@Column(name = "HOTEN")
	private String hoTen;
	
	@Column(name = "CHUCDANH")
	private String chucDanh;
	
	@Column(name = "DONVICONGTAC")
	private String donViCongTac;
	
	@Column(name = "KHOACONGTAC")
	private String khoaCongTac;
	
	@Column(name = "LINHVUCCONGTAC")
	private String linhVucCongTac;
	
//	@OneToMany(mappedBy = "GiaoVien")
//	private DeTai deTai;
	
	@OneToMany(mappedBy = "MA_HOIDONG")
	private Set<DanhSachHoiDong> danhSachHoiDongs = new HashSet();

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

	public String getLinhVucCongTac() {
		return linhVucCongTac;
	}

	public void setLinhVucCongTac(String linhVucCongTac) {
		this.linhVucCongTac = linhVucCongTac;
	}

	public GiaoVien(String maGiaoVien, String hoTen, String chucDanh, String donViCongTac, String khoaCongTac,
			String linhVucCongTac) {
		super();
		this.maGiaoVien = maGiaoVien;
		this.hoTen = hoTen;
		this.chucDanh = chucDanh;
		this.donViCongTac = donViCongTac;
		this.khoaCongTac = khoaCongTac;
		this.linhVucCongTac = linhVucCongTac;
	}

	public GiaoVien() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "GiaoVien [maGiaoVien=" + maGiaoVien + ", hoTen=" + hoTen + ", chucDanh=" + chucDanh + ", donViCongTac="
				+ donViCongTac + ", khoaCongTac=" + khoaCongTac + ", linhVucCongTac=" + linhVucCongTac
				+ ", danhSachHoiDongs=" + danhSachHoiDongs + "]";
	}
	
	
}

/*
* (C) Copyright 2020 IUH. All rights reserved.
*
* @author: AnhTuanIT
* @date: 05-11-2020
* @version: 1.0
*/
