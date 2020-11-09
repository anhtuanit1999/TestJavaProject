package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class DeTai implements Serializable {
	@Id
	@Column(name = "MADETAI")
	private int maDeTai;
	
	@ManyToOne
	@JoinColumn(name = "MAGIAOVIENRADE", nullable = false)
	private GiaoVien giaoVien;
	
	@Column(name = "TENDETAI")
	private String tenDeTai;
	
	@Column(name = "MOTADETAI")
	private String moTaDeTai;
	
	@Column(name = "SONHOMTHAMGIA")
	private int soNhomThamGia;
}

/*
* (C) Copyright 2020 IUH. All rights reserved.
*
* @author: AnhTuanIT
* @date: 05-11-2020
* @version: 1.0
*/
