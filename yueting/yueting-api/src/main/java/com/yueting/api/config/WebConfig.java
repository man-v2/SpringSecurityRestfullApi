package com.yueting.api.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.yueting.api.filter.TimerFilter;
import com.yueting.api.interceptor.TimerInterceptor;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter{

	@Autowired
	private TimerInterceptor timerInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(timerInterceptor);
	}
	
	@Bean
	public FilterRegistrationBean timerFilter() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		
		TimerFilter timerFilter = new TimerFilter();
		registrationBean.setFilter(timerFilter);
		
		List<String> urls = new ArrayList();
		urls.add("/*");
		registrationBean.setUrlPatterns(urls);
		
		return registrationBean;
	}
}
