package entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class GiaoVien implements Serializable {
	@Id
	@Column(name = "MAGIAOVIEN")
	private int maGiaoVien;
	
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
	
//	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	@JoinTable(name = "DANHSACHHOIDONG", 
//			joinColumns = { @JoinColumn(referencedColumnName = "MA_HOIDOING") },
//			inverseJoinColumns = { @JoinColumn(referencedColumnName = "MA_GIAOVIEN") })
	@OneToMany(mappedBy = "GiaoVien")
	private Set<DanhSachHoiDong> danhSachHoiDongs = new HashSet();
}

/*
* (C) Copyright 2020 IUH. All rights reserved.
*
* @author: AnhTuanIT
* @date: 05-11-2020
* @version: 1.0
*/
