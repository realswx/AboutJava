package com.qtech.tech;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;


public class DBConnectionFactory
{
	private DataSource dataSource;

	private static DBConnectionFactory instance = new DBConnectionFactory();

	// 用于获取数据源
	private DBConnectionFactory()
	{
		this.setupDataSource();
	}

	private void setupDataSource()
	{
		if (null == this.dataSource)
		{
			 BasicDataSource ds = new BasicDataSource();

			try
			{
				ds.setDriverClassName(ConfigHelper.getConfig(
						DBString.DB_CONFIG_FILE).getProperty(
						DBString.DB_DRIVER_PROPERTY));

				ds.setUrl(ConfigHelper.getConfig(DBString.DB_CONFIG_FILE)
						.getProperty(DBString.DB_URL_PROPERTY));

				ds.setUsername(ConfigHelper.getConfig(DBString.DB_CONFIG_FILE)
						.getProperty(DBString.DB_USERNAME));
				ds.setPassword(ConfigHelper.getConfig(DBString.DB_CONFIG_FILE)
						.getProperty(DBString.DB_PASSWORD));

				int initConn = Integer.parseInt(ConfigHelper.getConfig(
						DBString.DB_CONFIG_FILE).getProperty(
						DBString.DB_INIT_CONNECTIONS, "30"));

				ds.setInitialSize(initConn);

				int maxConn = Integer.parseInt(ConfigHelper.getConfig(
						DBString.DB_CONFIG_FILE).getProperty(
						DBString.DB_CONFIG_FILE, "30"));

				ds.setMaxTotal(maxConn);
			}
			catch (IOException ex)
			{
				ex.printStackTrace();
			}
			
			this.dataSource = ds; //为数据源赋值
		}
	}
	
	public static DBConnectionFactory getInstance()
	{
		return instance;
	}
	
	public Connection getConnection()
	{
		Connection conn = null;
		
		try
		{
			conn = dataSource.getConnection();
			
			conn.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
		
		return conn;
	}
}
