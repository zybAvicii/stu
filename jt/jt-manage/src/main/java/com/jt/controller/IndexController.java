package com.jt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {
	/**
	 * 'url':'/page/item-add'
	 * 'url':'/page/item-list'
	 * 'url':'/page/item-param-list'
	 * */
	/**
	 * 获取url中的数据当做参数
	 * 步骤:
	 * 1.将需要获取的数据使用{}包裹
	 * 2.参数与参数之间使用/分割,可多个参数
	 * 3.利用@pathvariable注解可以动态获取url中参数
	 * 一般名称必须一致
	 * 如果名称不一致需要使用value属性标识
	 * */
	@RequestMapping("/page/{moduleName}")
	public String module(@PathVariable String moduleName) {
		
		return moduleName;
	}
	//获取当前服务器
	@RequestMapping("/getMsg")
	@ResponseBody
	public String getMsg() {
		return "8091服务器";
	}
	
	
	
	
	
	
	
	
}

















