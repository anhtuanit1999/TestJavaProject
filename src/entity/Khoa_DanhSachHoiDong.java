package entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Khoa_DanhSachHoiDong {
	@Column(name = "MA_HOIDONG")
	private int maHoiDong;
	
	@Column(name = "MA_GIAOVIEN")
	private int maGiaoVien;
}

/*
* (C) Copyright 2020 IUH. All rights reserved.
*
* @author: AnhTuanIT
* @date: 09-11-2020
* @version: 1.0
*/
