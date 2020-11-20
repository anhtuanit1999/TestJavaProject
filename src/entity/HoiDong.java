package entity;

import java.io.Serializable;
import java.time.LocalDate;
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
public class HoiDong implements Serializable {
	private String maHoiDong;
	private String tenHoiDong;
	private String ngayLap;
	private String ngayBaoCao;
	
	
	public HoiDong(String maHoiDong, String tenHoiDong, String ngayLap, String ngayBaoCao) {
		super();
		this.maHoiDong = maHoiDong;
		this.tenHoiDong = tenHoiDong;
		this.ngayLap = ngayLap;
		this.ngayBaoCao = ngayBaoCao;
	}
	public String getNgayLap() {
		return ngayLap;
	}
	public void setNgayLap(String ngayLap) {
		this.ngayLap = ngayLap;
	}
	public String getNgayBaoCao() {
		return ngayBaoCao;
	}
	public void setNgayBaoCao(String ngayBaoCao) {
		this.ngayBaoCao = ngayBaoCao;
	}
	public String getMaHoiDong() {
		return maHoiDong;
	}
	public void setMaHoiDong(String maHoiDong) {
		this.maHoiDong = maHoiDong;
	}
	public String getTenHoiDong() {
		return tenHoiDong;
	}
	public void setTenHoiDong(String tenHoiDong) {
		this.tenHoiDong = tenHoiDong;
	}
	@Override
	public String toString() {
		return "HoiDong [maHoiDong=" + maHoiDong + ", tenHoiDong=" + tenHoiDong + "]";
	}
	
}

/*
* (C) Copyright 2020 IUH. All rights reserved.
*
* @author: AnhTuanIT
* @date: 05-11-2020
* @version: 1.0
*/
