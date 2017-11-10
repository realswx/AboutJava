package com.qtech.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.catalina.core.ApplicationPart;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.qtech.dao.CompanyDAO;

public class InsertServlet extends HttpServlet{
	static String companyName = null;
	static String companyArea = null;
	String companySize = null;
	String companyType = null;
	static String companyBrief = null;
	static String companySort = null;
	static String companyState = null;
	String filename=null;
	 String t1 = null;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String action = req.getParameter("action"); 
		 resp.setContentType("text/html");
	        DiskFileItemFactory factory = new DiskFileItemFactory();
	        ServletFileUpload upload = new ServletFileUpload(factory);
	        List items = null;
	        try {
	            items = upload.parseRequest(req);
	        } catch (FileUploadException e) {
	            e.printStackTrace();
	        } // 解析request请求
	        Iterator iter = items.iterator();// 遍历表单中提交过来的内容
	        
	        while (iter.hasNext()) {
	            FileItem item = (FileItem) iter.next();
	            if (item.isFormField()) { // 如果是表单域 ，就是非文件上传元素
	                String value = item.getString("UTF-8"); // 获取value属性的值，这里需要指明UTF-8格式，否则出现中文乱码问题
	                if (item.getFieldName().equals("companyName")) {// 对应form中属性的名字
	                	companyName = value;
	                } else if (item.getFieldName().equals("companyArea")) {
	                	companyArea = value;
	                }else if (item.getFieldName().equals("companySize")) {
	                	companySize = value;
	            }else if (item.getFieldName().equals("companyType")) {
	            	companyType = value;
	            }else if (item.getFieldName().equals("companyBrief")) {
	            	value = value.substring(3);
	            	value = value.substring(0,value.length()-4);
	            	companyBrief = value;
	            }else if (item.getFieldName().equals("companyState")) {
	            	companyState = value;
	            }else if (item.getFieldName().equals("companySort")) {
	            	companySort = value;
	            }
	            }else {
	                String fieldName = item.getFieldName(); // 文件域中name属性的值
	                System.out.println("fieldName:" + fieldName);
	                filename = item.getName(); // 文件的全路径，绝对路径名加文件名
	                System.out.println(filename);
	                t1 = System.getProperty("user.dir").substring(0,
	                        System.getProperty("user.dir").length() - 4);
	                File saveFile = new File(t1 + "/webapps/webtest/" + filename); // 定义一个file指向一个具体的文件
	                try {
	                    item.write(saveFile);// 把上传的内容写到一个文件中
	                } catch (Exception e) {
	                    /* e.printStackTrace(); */
	                    System.out.println("文件为空");
	                }
	            }
	        }
	        
	        CompanyDAO cdao = new CompanyDAO();
	        if(action.equals("update")){
			try {
				String companyid = req.getParameter("companyid");
				cdao.updateCompany(companyid,companyName, companyArea, companySize, companyType, companyBrief, companyState, companySort,t1 + "/webapps/webtest/" + filename );
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};
	        }else if(action.equals("insert")){
	        	try {
					cdao.insertCompany(companyName, companyArea, companySize, companyType, companyBrief, companyState, companySort,t1 + "/webapps/webtest/" + filename );
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				};
	        }
			resp.sendRedirect("CompanyServlet?currentpageindex=1");
	        
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
