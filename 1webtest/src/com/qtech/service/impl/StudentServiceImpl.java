package com.qtech.service.impl;

import java.util.List;

import com.qtech.dao.StudentDAO;
import com.qtech.dao.impl.StudentDAOImpl;
import com.qtech.entity.Student;
import com.qtech.service.StudentService;

public class StudentServiceImpl implements StudentService {
	
	private StudentDAO sdao=new StudentDAOImpl();

	@Override
	public List<Student> getAllStudent() {
		return sdao.getAllStudent();
	}
	
	
	@Override
	public int insertStudent(Student stu) {
		 
		return sdao.insertStudent(stu);
	}
	
	public static void main(String[] args) {
		
		/*StudentServiceImpl ssi=new StudentServiceImpl();
		
		List<Student> students=ssi.getAllStudent();
		
		for (Student student : students) {
			System.out.println(student.getId()+"\t"+student.getUsername());
		}*/
		StudentServiceImpl ssi=new StudentServiceImpl();
		Student stu=new Student();
		
		stu.setUsername("ss");
		
		stu.setPassword("987654");
		
		ssi.insertStudent(stu);
		
	}

	

}
