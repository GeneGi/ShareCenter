package net.jimmyme.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static HibernateUtil instance;
	
	private SessionFactory sessionFactory;
	
	public HibernateUtil(){
		
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}
	
	public Session openSession(){
		
		return sessionFactory.openSession();
	}
	
	public void closeSession(Session session){
		
		session.close();
	}
	
	public static HibernateUtil getInstance(){
		
		if(instance == null){
			instance = new HibernateUtil();
		}
		
		return instance;
	}

}
