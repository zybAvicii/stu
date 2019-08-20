package com.jt.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//如果保证返回的数据类型都是Json串则可以使用@restController
@Controller
@ConfigurationProperties(prefix="jdbc")
public class JDBCController {
	/*@Value(value="${jdbc.driver}")
	private String driver;		//驱动名
	@Value(value="${jdbc.name}")
	private String name;		//用户名信息
	@Value(value="${jdbc.password}")
	private String password;    //密码
		
	@RequestMapping("doTest")
	@ResponseBody
	public String doTest() {
		return "服务器返回"+driver+"|"+name+"|"+password;
		
	}
	*/
	/**
	 * 批量为属性赋值
	 * 规定:如果使用批量赋值操作,需要使用set方法
	 * 对比@VALUE注解更加常用
	 * */
	private String driver;
	private String name;
	private String password;
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@RequestMapping("doTest")
	@ResponseBody
	public String doTest() {
		return "服务器返回"+driver+"|"+name+"|"+password;
		
	}
	
	
	
	
	}
