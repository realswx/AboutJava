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
		System.out.println("doPost");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String path = this.getServletContext().getRealPath("/");	//��ȡ��������ַ
		Part p = request.getPart("headShot");	//��ȡ�û�ѡ����ϴ��ļ�	
			/*ApplicationPart ap = (ApplicationPart) p;

			String fname1 = ap.getFilename();	
			System.out.println(fname1);//��ȡ�ϴ��ļ���
			int path_idx = fname1.lastIndexOf("\\") + 1;			//���ϴ��ļ������н�ȡ
			String fname2 = fname1.substring(path_idx, fname1.length());	
			p.write(path + "/upload/" + fname2);					// д�� web ��Ŀ��·���µ�upload�ļ�����
			out.write("�ļ��ϴ��ɹ�");		*/
		String fileName =  ((ApplicationPart) p).getSubmittedFileName();
		String newFileName = System.currentTimeMillis()+fileName.substring(fileName.lastIndexOf("."));
		String filepath = getServletContext().getRealPath("/applicant/images");
		System.out.println("ͷ�񱣴�·��Ϊ��"+filepath);
		File file = new File(filepath);
		if(!file.exists())
			file.mkdirs();
			p.write(filepath+"/"+newFileName);
			ResumeDAO rDao = new ResumeDAO();
			rDao.updateHeadShot(1, newFileName);
			response.sendRedirect("applicant/resume.html");
		
		
	}
}
