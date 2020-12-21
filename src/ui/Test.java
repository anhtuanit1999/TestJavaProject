package ui;

import javax.swing.JFileChooser;

import giaovukhoa.GiaoDien_ChonCongViec;

public class Test {
	public static void main(String[] args) {
		JFileChooser f = new JFileChooser();
        f.setFileSelectionMode(JFileChooser.FILES_ONLY); 
        f.showSaveDialog(null);

        System.out.println(f.getCurrentDirectory());
        System.out.println(f.getSelectedFile());
	}
}

/*
* (C) Copyright 2020 IUH. All rights reserved.
*
* @author: AnhTuanIT
* @date: 13-11-2020
* @version: 1.0
*/
