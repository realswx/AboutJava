package com.qtech.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qtech.dao.StudentDAO;
import com.qtech.entity.Student;
import com.qtech.util.DBUtil;

public class StudentDAOImpl implements StudentDAO {
	
	private DBUtil dbUtil=new DBUtil();

	/**
	 * 
	 */
	@Override
	public List<Student> getAllStudent() {
		
		List<Student> students=new ArrayList<Student>();
		Connection conn=dbUtil.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement("select * from student");
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

	@Override
	public int insertStudent(Student stu) {
		return dbUtil.excuteUpdate("insert into student(name,password) values(?,?)", new Object[]{stu.getUsername(),stu.getPassword()});
	}

	@Override
	public int updateStudent(Student stu) {
		return 0;
	}

	@Override
	public int deleteStudent(Student stu) {
		return 0;
	}

}
