package com.jt.service;

import java.util.List;

import com.jt.pojo.Item;
import com.jt.pojo.ItemDesc;
import com.jt.vo.EasyUITable;
import com.jt.vo.SysResult;

public interface ItemService {
	
	EasyUITable findItemByPage(Integer page,Integer rows);

	void saveItem(Item item,ItemDesc itemDesc);
	
	void updateItem(Item item,ItemDesc itemDesc);
	
	void updateStatus(Long[] ids, int status);
	
	void deletesItem(Long[] ids);
	
	ItemDesc findItemDescById(Long itemId);
	
	Item findItemById(Long item);
	 
}
