package com.qtech.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qtech.dao.CompanyConut;
import com.qtech.dao.CompanyDAO;
import com.qtech.entity.Company;
import com.qtech.entity.PageCompany;

public class CompanyServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public CompanyServlet() {
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
		String currentindex = request.getParameter("currentpageindex");
		int currentpageindex = Integer.valueOf(currentindex);
		CompanyDAO cd = new CompanyDAO();
		List<Company> companyList = null;
		companyList = cd.getAllCompany(currentpageindex);
		//将userlist存放到作用域中
		PageCompany pageCompany = new PageCompany();
		pageCompany.setCurrentPageIndex(currentpageindex);
		if(currentpageindex==1){
		try {
			pageCompany.setTotalDataCount(CompanyConut.getTotalCompany());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pageCompany.setPagerow(pageCompany.getTotalDataCount()/8+1);
		}
		
		pageCompany.setList(companyList);

		request.setAttribute("pagecompany", pageCompany);
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//转发：跳转到showlist.jsp页面
		System.out.println("pageconpany");
		System.out.println(pageCompany.getCurrentPageIndex()+"   "+pageCompany.getPagecount_now()+"   "+pageCompany.getPagerow()+"   "+pageCompany.getTotalDataCount());
		request.getRequestDispatcher("/manage/companyList.jsp").forward(request, response);
		
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
