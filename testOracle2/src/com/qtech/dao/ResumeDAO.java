package com.qtech.dao;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qtech.entity.Student;
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
public List<Student> getAllResume() {
		
		List<Student> students=new ArrayList<Student>();
		DBUtil dbUtil = new DBUtil();
		Connection conn=dbUtil.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement("select * from tb_resume_basicinfo");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Student student=new Student();
				student.setId(rs.getInt("id"));
				student.setUsername(rs.getString("name"));
				student.setPassword(rs.getString("password"));
				
				students.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return students;
	}

}
