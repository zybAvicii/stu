package com.jt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jt.pojo.Item;
import com.jt.service.ItemServer;


@Controller
@RequestMapping("/items")
public class ItemController {
 
	
	@Autowired
	private ItemServer itemServer;
	
	/**
	 * 实现商品详情展现.
	 */
	 @RequestMapping("/{itemId}") 
	 public String findItemById(
		 @PathVariable Long itemId,Model model) {
		 Item item = itemServer.findItemById(itemId);
		 
		 model.addAttribute("item", item);
		
		 return "item"; //跳转到商品展现页面
	}
	
}
 

