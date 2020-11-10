package entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SinhVien implements Serializable {

	private String maSinhVien;
	private String hoTen;
	
	@Column(name = "DIACHI")
	private String diaChi;
	
	@Column(name = "SODIENTHOAI")
	private String soDienThoai;
	private String ngaySinh;
	private String khoaTrucThuoc;
	
	@Column(name = "NAMVAOTRUONG")
	private int namVaoTruong;
	
	@Column(name = "NAMTOTNGHIEP")
	private int namTotNghiep;
	public String getMaSinhVien() {
		return maSinhVien;
	}
	public void setMaSinhVien(String maSinhVien) {
		this.maSinhVien = maSinhVien;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public String getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getKhoaTrucThuoc() {
		return khoaTrucThuoc;
	}
	public void setKhoaTrucThuoc(String khoaTrucThuoc) {
		this.khoaTrucThuoc = khoaTrucThuoc;
	}
	public int getNamVaoTruong() {
		return namVaoTruong;
	}
	public void setNamVaoTruong(int namVaoTruong) {
		this.namVaoTruong = namVaoTruong;
	}
	public int getNamTotNghiep() {
		return namTotNghiep;
	}
	public void setNamTotNghiep(int namTotNghiep) {
		this.namTotNghiep = namTotNghiep;
	}
	public SinhVien(String maSinhVien, String hoTen, String diaChi, String soDienThoai, String ngaySinh,
			String khoaTrucThuoc, int namVaoTruong, int namTotNghiep) {
		super();
		this.maSinhVien = maSinhVien;
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
		this.ngaySinh = ngaySinh;
		this.khoaTrucThuoc = khoaTrucThuoc;
		this.namVaoTruong = namVaoTruong;
		this.namTotNghiep = namTotNghiep;
	}
	public SinhVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "SinhVien [maSinhVien=" + maSinhVien + ", hoTen=" + hoTen + ", diaChi=" + diaChi + ", soDienThoai="
				+ soDienThoai + ", ngaySinh=" + ngaySinh + ", khoaTrucThuoc=" + khoaTrucThuoc + ", namVaoTruong="
				+ namVaoTruong + ", namTotNghiep=" + namTotNghiep + "]";
	}
	
	
}

/*
* (C) Copyright 2020 IUH. All rights reserved.
*
* @author: AnhTuanIT
* @date: 05-11-2020
* @version: 1.0
*/
