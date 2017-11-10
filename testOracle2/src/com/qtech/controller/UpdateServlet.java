package com.qtech.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.PseudoColumnUsage;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qtech.entity.Company;
import com.qtech.util.DBUtil;

public class UpdateServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UpdateServlet() {
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
		request.setCharacterEncoding("utf-8");
		String action  = request.getParameter("action");
		
		if(action.equals("companyupdate_echo")){
			String companyid = request.getParameter("companyid");
			Company company = new Company();
			PreparedStatement ps;
			ResultSet rs;
			DBUtil dbUtil = new DBUtil();
			Connection connection = dbUtil.getConnection();
			try {
				ps = connection.prepareStatement("select * from tb_company where company_id="+companyid);
				rs = ps.executeQuery();
				if(rs.next()){
					company.setC_id(rs.getInt("company_id"));
					company.setC_name(rs.getString("company_name"));
					company.setC_area(rs.getString("company_area"));
					company.setC_size(rs.getString("company_size"));
					company.setC_type(rs.getString("company_type"));
					company.setC_brief(rs.getString("company_brief"));
					company.setC_state(rs.getInt("company_state"));
					company.setC_sort(rs.getInt("company_sort"));
					company.setC_viewnum(rs.getInt("company_viewnum"));
					company.setC_pic(rs.getString("company_pic"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("company", company);
			request.getRequestDispatcher("manage/companyUpdate.jsp").forward(request, response);;
			
		}
		
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

		doGet(request, response);
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
