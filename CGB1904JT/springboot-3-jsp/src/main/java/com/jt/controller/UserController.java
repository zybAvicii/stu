package com.jt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.pojo.User;
import com.jt.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping("findAll")
	public String findAll(Model model) {//request对象,Model操作相当于Request
		//查询user表的全部记录
		//将服务器数据传递给request对象
		List<User> findAll = userService.findAll();
		model.addAttribute("userList",findAll);
		return "userList";
	}
	
	/**-------------------------------------------------------------------------------------*/
	@RequestMapping("loadajax")
	public String ajax() {
		return "userList-ajax";
	}
	
	@RequestMapping("/ajaxUserList")
	@ResponseBody
	public List<User> findUser(){	
		List<User> findAll = userService.findAll();
		return findAll;
	}
	/**-------------------------------------------------------------------------------------*/
}
