package entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;

@Embeddable
public class Khoa_DanhSachHoiDong {
	@Column(name = "MA_HOIDONG")
	private int maHoiDong;
	
	@Column(name = "MA_HOIDONG")
	private int maGiaoVien;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + maGiaoVien;
		result = prime * result + maHoiDong;
		return result;
	}

	public Khoa_DanhSachHoiDong() {
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Khoa_DanhSachHoiDong other = (Khoa_DanhSachHoiDong) obj;
		if (maGiaoVien != other.maGiaoVien)
			return false;
		if (maHoiDong != other.maHoiDong)
			return false;
		return true;
	}
	
	
}

/*
* (C) Copyright 2020 IUH. All rights reserved.
*
* @author: AnhTuanIT
* @date: 09-11-2020
* @version: 1.0
*/
