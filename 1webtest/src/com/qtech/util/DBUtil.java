package com.qtech.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	
	private String driver="com.mysql.jdbc.Driver";
	
	private String url="jdbc:mysql://localhost:3306/itoffer";
	
	private String username="root";
	
	private String password="987654";
	
	Connection conn=null;

	public Connection getConnection()
	{
		if(null==conn)
		{
			try {
				Class.forName(driver);
				conn=DriverManager.getConnection(url,username,password);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return conn;
		
	}
	public void closeAll(Connection conn,Statement statement,ResultSet rs)
	{
		if(null!=conn)
		{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(statement!=conn)
		{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(rs!=conn)
		{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	/**
	 * JDBC中的增删改的通用方法
	 * @param sql 执行的
	 * @param param 执行为preparedStatement赋值
	 * @return 受影响的行数
	 */
	public int excuteUpdate(String sql,Object[] param)
	{
		PreparedStatement pstate=null;
		
		int num=0;
		conn=getConnection();
		
		try {
			pstate=conn.prepareStatement(sql);
			
			if(null!=param)
			{
				for (int i = 0; i < param.length; i++) 
				{
					pstate.setObject(i+1, param[i]);
				}
				
			}
			num=pstate.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			closeAll(conn, pstate, null);
		}
		 
		return num;
	}
	
	public static void main(String[] args) {
		
		System.out.println(new DBUtil().getConnection());
		
		
	}
	
	

}
