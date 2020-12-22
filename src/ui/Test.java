package ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFileChooser;

import giaovukhoa.GiaoDien_ChonCongViec;

public class Test {
	public static void main(String[] args) {
		try {
			System.out.println(new SimpleDateFormat("yyyy-MM-dd").parse("2020-12-22"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

/*
* (C) Copyright 2020 IUH. All rights reserved.
*
* @author: AnhTuanIT
* @date: 13-11-2020
* @version: 1.0
*/
