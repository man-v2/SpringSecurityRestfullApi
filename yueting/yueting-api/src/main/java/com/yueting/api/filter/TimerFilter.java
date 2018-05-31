package com.yueting.api.filter;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.stereotype.Component;

/**
 * 过滤器使用2种方式：
 * 	1. implements Filter
 *  2. FilterRegistrationBean 注册过滤器 see webconfig
 * @author Administrator
 *
 */
//@Component
public class TimerFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		long start = new Date().getTime();
		chain.doFilter(request, response);
		System.out.println("TimerFilter 耗时： "+(new Date().getTime() - start));
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
