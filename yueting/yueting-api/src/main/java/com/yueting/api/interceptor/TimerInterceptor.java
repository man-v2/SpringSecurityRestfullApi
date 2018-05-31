package com.yueting.api.interceptor;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class TimerInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse arg1, Object handler, Exception arg3)
			throws Exception {
		System.out.println("afterCompletion");
		Long start = (Long)request.getAttribute("startTime");
		System.out.println("time interceptor 耗时："+(new Date().getTime() - start));
		System.out.println("Exception");
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse arg1, Object handler, ModelAndView arg3)
			throws Exception {
		System.out.println("postHandle");
		Long start = (Long)request.getAttribute("startTime");
		System.out.println("time interceptor 耗时："+(new Date().getTime() - start));

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse arg1, Object handler) throws Exception {
		System.out.println("preHandle");
		System.out.println("class-name: "+((HandlerMethod)handler).getBean().getClass().getName());
		System.out.println("method-name: "+((HandlerMethod)handler).getMethod().getName());
		request.setAttribute("startTime", new Date().getTime());
		return true;
	}

}
