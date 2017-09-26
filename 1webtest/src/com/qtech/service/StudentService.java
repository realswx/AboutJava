package com.qtech.service;

import java.util.List;

import com.qtech.entity.Student;

public interface StudentService {
	
	List<Student> getAllStudent();
	
	int insertStudent(Student stu);

}
