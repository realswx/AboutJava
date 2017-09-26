package com.qtech.dao;

import java.util.List;

import com.qtech.entity.Student;

 

public interface StudentDAO {
	
	List<Student> getAllStudent();
	
	int insertStudent(Student stu);
	
	int updateStudent(Student stu);
	
	int deleteStudent(Student stu);

}
