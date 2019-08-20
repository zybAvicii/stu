package com.jt.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.druid.util.StringUtils;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.jt.service.UserService;
import com.jt.vo.SysResult;
import redis.clients.jedis.JedisCluster;
@RequestMapping("/user")
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private JedisCluster jedisCluster;
	
	
	/**
	 * 实现用户信息校验
	 * */
	@RequestMapping("/check/{param}/{type}")
	public JSONPObject checkUser(
							   @PathVariable String param,
							   @PathVariable Integer type,
							   String callback) {
					JSONPObject jsonpObject;
					try {
						boolean flag = 
								userService.findCheckUser(param,type);//用户名校验	
						jsonpObject = new JSONPObject(callback,SysResult.success(flag));
					
					} catch (Exception e) {
						e.printStackTrace();
						jsonpObject=new JSONPObject(callback,SysResult.success());
					}
			
					return jsonpObject;						
	}
	
	
	@RequestMapping("/query/{ticket}")
	
	public JSONPObject findUserByTicket(@PathVariable String ticket,String callback) {
		
		String userJSON = jedisCluster.get(ticket);
		JSONPObject jsonpObject = null;
		if(StringUtils.isEmpty(userJSON)) {
			jsonpObject = new JSONPObject(callback,SysResult.fail());
		}else {
			jsonpObject = new JSONPObject(callback,SysResult.success(userJSON));
		}
		return jsonpObject;
	}
	
	
	
	
	
	
	

}











