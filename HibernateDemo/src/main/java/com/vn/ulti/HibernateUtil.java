package com.vn.ulti;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	public static SessionFactory factory = null;
	
	public static SessionFactory getSessionFactory() {
		try {
			if(factory == null) {
				Configuration configuration = new Configuration();
				factory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();
			}
			return factory;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
