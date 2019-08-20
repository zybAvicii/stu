package com.cy.pj.pojo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PageController {
	
	
	@RequestMapping("doIndexUI")
	public String doStartUI() {
		return "starter";
	}
	@RequestMapping("doPageUI")
	public String doPageUI() {
		
		return "common/page";
	}
}
