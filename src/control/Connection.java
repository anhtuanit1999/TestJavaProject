package control;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import entity.DanhSachHoiDong;
import entity.DeTai;
import entity.DiemBaoVeLuanVan;
import entity.GiaoVien;
import entity.HoiDong;
import entity.KetQua;
import entity.LuanVan;
import entity.SinhVien;

public class Connection {
	private static SessionFactory sessionFactory = null;
	public static synchronized SessionFactory getSessionFactory() {
		if(sessionFactory == null) {
			ServiceRegistry registry = new StandardServiceRegistryBuilder()
					.configure()
					.build();
			
			Metadata metadata = new MetadataSources(registry)
					.addAnnotatedClass(GiaoVien.class)
//					.addAnnotatedClass(SinhVien.class)
					.addAnnotatedClass(HoiDong.class)
//					.addAnnotatedClass(LuanVan.class)
//					.addAnnotatedClass(DeTai.class)
//					.addAnnotatedClass(DanhSachHoiDong.class)
//					.addAnnotatedClass(KetQua.class)
//					.addAnnotatedClass(DiemBaoVeLuanVan.class)
					.getMetadataBuilder().build();
			
			sessionFactory = metadata.getSessionFactoryBuilder().build();
		}
		return sessionFactory;
	}
	public static void close() {
		if(!sessionFactory.isClosed()) {
			sessionFactory.close();
		}
	}
}

/*
* (C) Copyright 2020 IUH. All rights reserved.
*
* @author: AnhTuanIT
* @date: 08-11-2020
* @version: 1.0
*/
