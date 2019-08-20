package com.jt.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jt.pojo.Item;
import com.jt.service.ItemService;

@RequestMapping("/web/item")
@RestController//要求返回json串
public class webItemController {
	
	@Autowired
	private ItemService itemService;
	
	
	@RequestMapping("findItemById")
	public Item findItemById(Long itemId) {
		
		
		return itemService.findItemById(itemId);
	}
	
}
