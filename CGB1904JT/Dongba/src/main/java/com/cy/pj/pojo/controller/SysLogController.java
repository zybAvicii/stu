package com.cy.pj.pojo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/log")
public class SysLogController {
	
	@RequestMapping("doLogUI")
	public String doLogList() {
		return "sys/log_list";
	}
	
}
