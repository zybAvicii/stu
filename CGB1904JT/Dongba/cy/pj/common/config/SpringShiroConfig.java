package com.cy.pj.common.config;

import java.util.LinkedHashMap;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cy.pj.sys.service.realm.ShiroUserRealm;

@Configuration
public class SpringShiroConfig {
	
	@Bean("securityManager")//没有名字默认方法名
	
	public SecurityManager newSecuritymManager(
			@Autowired	Realm realm) {//or ShiroUserRealm Realm实现类
		DefaultWebSecurityManager sManager = 
				new DefaultWebSecurityManager();
		sManager.setRealm(realm);
		return sManager;
	}
	@Bean("shiroFilterFactory")
	@Autowired
	public ShiroFilterFactoryBean newShiroFilterFactoryBean(
			SecurityManager securityManager) {
		ShiroFilterFactoryBean fBean =
				new ShiroFilterFactoryBean();
		//设置认证的URL
		
		fBean.setLoginUrl("/doLoginUI");
		
		fBean.setSecurityManager(securityManager);
		LinkedHashMap<String,String> map = 
				new LinkedHashMap<>();
		fBean.setFilterChainDefinitionMap(map);
		//设置允许匿名访问的资源
		 map.put("/bower_components/**","anon");
		 map.put("/build/**","anon");
		 map.put("/dist/**","anon");
		 map.put("/plugins/**","anon");
		
		 map.put("/user/doLogin","anon");
		// map.put("doLogout","logout");
		 
		 //设置必须认证才可以访问的资源
		 map.put("/**","authc");
	
		 fBean.setFilterChainDefinitionMap(map);
		return fBean;
	}
}
















