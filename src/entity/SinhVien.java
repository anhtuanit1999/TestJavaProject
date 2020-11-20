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
	private String ngaySinh;
	private String soDienThoai;
	private String diaChi;
	private String khoaTrucThuoc;
	private int namVaoTruong;
	private int namTotNghiep;
	private String maNhom;
	public SinhVien(String maSinhVien, String hoTen, String ngaySinh, String soDienThoai, String diaChi,
			String khoaTrucThuoc, int namVaoTruong, int namTotNghiep, String maNhom) {
		super();
		this.maSinhVien = maSinhVien;
		this.hoTen = hoTen;
		this.ngaySinh = ngaySinh;
		this.soDienThoai = soDienThoai;
		this.diaChi = diaChi;
		this.khoaTrucThuoc = khoaTrucThuoc;
		this.namVaoTruong = namVaoTruong;
		this.namTotNghiep = namTotNghiep;
		this.maNhom = maNhom;
	}
	
	public SinhVien(String maSinhVien, String hoTen, String khoaTrucThuoc, String maNhom) {
		super();
		this.maSinhVien = maSinhVien;
		this.hoTen = hoTen;
		this.khoaTrucThuoc = khoaTrucThuoc;
		this.maNhom = maNhom;
	}
	
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
	public String getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
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
	public String getMaNhom() {
		return maNhom;
	}
	public void setMaNhom(String maNhom) {
		this.maNhom = maNhom;
	}
	@Override
	public String toString() {
		return "SinhVien [maSinhVien=" + maSinhVien + ", hoTen=" + hoTen + ", ngaySinh=" + ngaySinh + ", soDienThoai="
				+ soDienThoai + ", diaChi=" + diaChi + ", khoaTrucThuoc=" + khoaTrucThuoc + ", namVaoTruong="
				+ namVaoTruong + ", namTotNghiep=" + namTotNghiep + ", maNhom=" + maNhom + "]";
	}	
}

/*
* (C) Copyright 2020 IUH. All rights reserved.
*
* @author: AnhTuanIT
* @date: 05-11-2020
* @version: 1.0
*/
