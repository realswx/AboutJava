package com.qtech.filter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qtech.dao.ResumeDAO;

public class toMainFilter extends HttpFilter{

	@Override
	public void doFilter(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterConfig) {
		HttpSession session = request.getSession();
		String nameString = (String) session.getAttribute("username");
		ResumeDAO rDao = new ResumeDAO();
		rDao.getAllResume();
		
	}
	
}
