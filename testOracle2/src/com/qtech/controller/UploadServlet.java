package com.qtech.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import java.io.PrintWriter;

import javax.servlet.annotation.MultipartConfig;

import oracle.net.aso.f;

import org.apache.catalina.core.ApplicationPart;

import com.qtech.dao.ResumeDAO;

/**
 * Servlet implementation class UploadServlet
 */
@MultipartConfig
public class UploadServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost!!!!!!!!!!!!");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String path = this.getServletContext().getRealPath("/");	//获取服务器地址
		Part p = request.getPart("headShot");	//获取用户选择的上传文件	
		String fileName = ((ApplicationPart) p).getSubmittedFileName();
		String newFileName = System.currentTimeMillis()+fileName.substring(fileName.lastIndexOf("."));
		String filepath = getServletContext().getRealPath("/applicant/images");
		System.out.println("头像保存路径为："+filepath);
		File file = new File(filepath);
		if(!file.exists())
			file.mkdirs();
			p.write(filepath+"/"+newFileName);
			ResumeDAO rDao = new ResumeDAO();
			rDao.updateHeadShot(1, newFileName);
			response.sendRedirect("applicant/resume.html");
		
		
	}
}
