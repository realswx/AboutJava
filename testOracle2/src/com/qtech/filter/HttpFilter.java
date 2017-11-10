package com.qtech.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class HttpFilter implements Filter{
	private FilterConfig filterConfig;
	@Override
	public void destroy() {
		// TODO 自动生成的方法存�?
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		// TODO 自动生成的方法存�?
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		doFilter(request, response, chain);
		
	}

	public FilterConfig getFilterConfig() {
		return filterConfig;
	}
public abstract void doFilter(HttpServletRequest request,HttpServletResponse response,FilterChain filterConfig);
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO 自动生成的方法存�?
		this.filterConfig = filterConfig;
		init();
	}

	protected void init() {
		// TODO 自动生成的方法存�?
		
	}

}
