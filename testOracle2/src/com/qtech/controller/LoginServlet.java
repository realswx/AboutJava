package com.qtech.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qtech.dao.impl.StudentDAOImpl;
import com.qtech.entity.Student;

public class LoginServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StudentDAOImpl sdi = new StudentDAOImpl();
		String name = request.getParameter("userLogname");
		String passString = request.getParameter("userPwd");
		List<Student> students = sdi.getAllStudent();
		int temp = 0;
		System.out.println(name+"     "+passString);
		for(Student student:students){
			System.out.println(student.toString());
			if(name.equals(student.getUsername())){
				if(passString.equals(student.getPassword())){
					temp=1;
				}else{
					System.out.println("密码错误");
				}
			}
			
		}
		if(temp==0){
			System.out.println("用户不存在");
		}else{
			HttpSession session = request.getSession();
			session.setAttribute("username", name);
			session.setAttribute("password", passString);
			response.sendRedirect("manage/main.jsp");
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
