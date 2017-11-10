package com.qtech.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.qtech.util.DBUtil;

public class CompanyConut {
	public static int getTotalCompany() throws SQLException {
		int count ;
		// TODO Auto-generated method stub
		DBUtil dbUtil = new DBUtil();
		Connection conn=dbUtil.getConnection();
		PreparedStatement ps=conn.prepareStatement("select count(*) from tb_company");
		ResultSet rs=ps.executeQuery();
		rs.next();
		count = rs.getInt(1);
		System.out.println("查询数据数量为："+count);
		return count;
	}
}
