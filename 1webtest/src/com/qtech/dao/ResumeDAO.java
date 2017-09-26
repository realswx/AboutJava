package com.qtech.dao;

import java.sql.Connection;


import java.sql.PreparedStatement;

import com.qtech.util.DBUtil;

public class ResumeDAO {
	public void updateHeadShot(int id, String newFileName ) {
		String sql = "update tb_resume_basicinfo set head_shot=? where basicinfo_if = ?";
		DBUtil dbUtil = new DBUtil();
		Connection connection = dbUtil.getConnection();
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, newFileName);
			ps.setInt(2, id);
			ps.executeQuery();
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
		dbUtil.closeAll(connection, ps, null);
		}
		
	}	
}
