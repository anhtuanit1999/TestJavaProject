package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class DanhSachHoiDong implements Serializable {
	@EmbeddedId
	private Khoa_DanhSachHoiDong ma;
	
	@ManyToOne
    @MapsId("MA_HOIDONG")
    @JoinColumn(name = "MA_HOIDONG")
	private HoiDong hoiDong;
	
	@ManyToOne
    @MapsId("MA_GIAOVIEN")
    @JoinColumn(name = "MA_GIAOVIEN")
	private GiaoVien giaoVien;
	
	private int namHoc;
}

/*
* (C) Copyright 2020 IUH. All rights reserved.
*
* @author: AnhTuanIT
* @date: 05-11-2020
* @version: 1.0
*/
