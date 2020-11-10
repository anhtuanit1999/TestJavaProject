package ui;

import org.hibernate.SessionFactory;

import control.Connection;

public class MainTest {
	public static void main(String[] args) {
		Connection connection = new Connection();
		SessionFactory sessionFactory = connection.getSessionFactory();
	}
}

/*
* (C) Copyright 2020 IUH. All rights reserved.
*
* @author: AnhTuanIT
* @date: 08-11-2020
* @version: 1.0
*/
