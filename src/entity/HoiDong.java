package entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class HoiDong implements Serializable {
	@Id
	@Column(name = "MAHOIDONG")
	private int maHoiDong;
	
	@Column(name = "TENHOIDONG")
	private String tenHoiDong;
	
	@Column(name = "NGAYBAOVE")
	private LocalDate ngayBaoVe;
	
//	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	@JoinTable(name = "DANHSACHHOIDONG", 
//				joinColumns = { @JoinColumn(referencedColumnName = "MA_GIAOVIEN") },
//				inverseJoinColumns = @JoinColumn(referencedColumnName = "MA_HOIDONG"))
	@OneToMany(mappedBy = "HoiDong")
	private Set<DanhSachHoiDong> danhSachHoiDongs = new HashSet();
}

/*
* (C) Copyright 2020 IUH. All rights reserved.
*
* @author: AnhTuanIT
* @date: 05-11-2020
* @version: 1.0
*/
