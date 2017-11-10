package com.qtech.util;

import java.sql.Connection;

import javax.sql.DataSource;

public class DBConnectionFactory {
	
	private DataSource dataSource;
	
	private static DBConnectionFactory instance=new DBConnectionFactory();
	
	private DBConnectionFactory()
	{
		//dbcp
		
		/*BasicDataSource dbs=new BasicDataSource();
		
		dbs.setUrl(url);
		
		dbs.setDriverClassName(driverClassName)
		
		dbs.setUsername(username);
		
		dbs.setPassword(password);
		
		dbs.setInitialSize(30);
		
		dbs.setMaxTotal(60);
		
		 dbs.setDefaultTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
		
		
		dataSource=dbs;*/
		
		
	}
	
	public static DBConnectionFactory  getInstance()
	{
		return instance;
	}
	
	
	
	
	
	
	
	

}
