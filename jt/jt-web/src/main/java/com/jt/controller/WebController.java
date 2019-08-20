package com.jt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jt.pojo.Item;
import com.jt.service.ItemServer;

@RestController
@RequestMapping("/web/item")
public class WebController {

	@Autowired
	private ItemServer itemServer;
	
	@RequestMapping("findItemById")
	public Item findItemById(Long itemId) {
		return itemServer.findItemById(itemId);
	}
}
