package com.qtech.tech;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class AbstractBaseDao 
{
	protected Connection conn;

	public AbstractBaseDao(Connection conn)
	{
		this.conn = conn;
	}

	 

	protected void closeResources(Statement stmt) throws Exception
	{
		try
		{
			if (null != stmt)
			{
				stmt.close();
			}
		}
		catch (SQLException ex)
		{ 
		}
	}

}
