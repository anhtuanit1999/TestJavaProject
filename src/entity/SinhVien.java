package entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SinhVien implements Serializable {
	@Id
	@Column(name = "MASINHVIEN")
	private int maSinhVien;
	
	@Column(name = "HOTEN")
	private String hoTen;
	
	@Column(name = "DIACHI")
	private String diaChi;
	
	@Column(name = "SODIENTHOAI")
	private String soDienThoai;
	
	@Column(name = "NGAYSINH")
	private LocalDate ngaySinh;
	
	@Column(name = "KHOATRUCTHUOC")
	private String khoaTrucThuoc;
	
	@Column(name = "NAMVAOTRUONG")
	private int namVaoTruong;
	
	@Column(name = "NAMTOTNGHIEP")
	private int namTotNghiep;
}

/*
* (C) Copyright 2020 IUH. All rights reserved.
*
* @author: AnhTuanIT
* @date: 05-11-2020
* @version: 1.0
*/
