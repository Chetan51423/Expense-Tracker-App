package com.db;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import com.mysql.cj.jdbc.Driver;
import com.entity.Expense;
import com.entity.User;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory()
	{
		if(sessionFactory==null)
		{
			try {
				Configuration configuration = new Configuration();
				
				Properties properties = new Properties();
						
				properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
				properties.put(Environment.URL,"jdbc:mysql://localhost:3306/hibernate_db" );
				properties.put(Environment.USER, "root");
				properties.put(Environment.PASS, "Pass@123");
				properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
				properties.put(Environment.HBM2DDL_AUTO, "update");
				properties.put(Environment.SHOW_SQL, true);
//				org.hibernate.dialect.MySQL8Dialect
				
				configuration.setProperties(properties);
				configuration.addAnnotatedClass(User.class);
				configuration.addAnnotatedClass(Expense.class);
				
				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
	.applySettings(configuration.getProperties()).build();
				
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		
		return sessionFactory;
	}

}
