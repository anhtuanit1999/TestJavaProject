package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LuanVan implements Serializable {
	@Id
	@Column(name = "MALUANVAN")
	private int maLuanVan;
	
	@Column(name = "MADETAI")
	private int maDeTai;
	
	
	private SinhVien sinhVien;
	
	private String tenLuanVan;
	
	private String linhVucNghienCuu;
	
	private String noiDungLuanVan;
	
	private String tomTat;
}

/*
* (C) Copyright 2020 IUH. All rights reserved.
*
* @author: AnhTuanIT
* @date: 05-11-2020
* @version: 1.0
*/
