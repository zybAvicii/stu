package com.cy.pj.common.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.DelegatingFilterProxy;

@Configuration
public class WebFilterConfig {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	public FilterRegistrationBean newFilterRegistrationBean() {
		 FilterRegistrationBean fBean=
		 new FilterRegistrationBean();
		 fBean.setFilter(new DelegatingFilterProxy("shiroFilterFactory"));
		 fBean.addUrlPatterns("/*");
		 return fBean;
	 }
}
//newFilterRegistrationBean