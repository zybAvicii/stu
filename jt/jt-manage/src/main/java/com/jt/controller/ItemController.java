package com.jt.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jt.pojo.Item;
import com.jt.pojo.ItemDesc;
import com.jt.service.ItemService;
import com.jt.vo.EasyUITable;
import com.jt.vo.SysResult;

@RestController
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	
	/**
	 * 根据分页查询商品信息
	 * localhost:8091/item/query?page=1&rows=50
	 * */
	@RequestMapping("/item/query")
	public EasyUITable findItemByPage(Integer page,Integer rows) {
		
		return itemService.findItemByPage(page,rows);
	}
	/**
	 * 实现商品数据的新增
	 * */
	@RequestMapping("/item/save")
	public SysResult saveIteam(Item item,ItemDesc itemDesc) {
		
		itemService.saveItem(item,itemDesc);
		return SysResult.success();
	
		
	}
	
	/**
	 * 商品更新+商品描述更新
	 * */
	@RequestMapping("/item/update")
	public SysResult updateItem(Item item,ItemDesc itemDesc) {
		itemService.updateItem(item,itemDesc);
		return SysResult.success();
	}
	
	/**
	 * 实现商品下架操作
	 * 
	 * $.post("/item/instock")
	 * 
	 * 规则:
	 * 如果用户传参使用","分割参数,则SpirngMVC
	 * 接受参数时可以使用数组接收,由程序内部实现自动转化
	 * ids:1001,1002,1003
	 * */
	@RequestMapping("/item/instock")
	public SysResult instock(/*String ids*/  Long[] ids) {
		//String[] strIds = ids.split(",");
		
		int status=2;//表示下架
		itemService.updateStatus(ids,status);
		return SysResult.success();
	}
	/**
	 * 上架
	 * */
	@RequestMapping("/item/reshelf")
	public SysResult reshelf(Long[] ids) {
		int status = 1;	//表示上架
		itemService.updateStatus(ids,status);
		return SysResult.success();
	}

	/**
	 * 删除商品
	 * */
	@RequestMapping("/item/delete")
	public SysResult deleteItems(Long [] ids) {
		itemService.deletesItem(ids);
			return SysResult.success();
	}
	
	/**
	 * 根据商品详情信息获取服务器数据(用户添加数据)
	 * */
	@RequestMapping("/item/query/item/desc/{itemId}")
	public SysResult findItemDescById(@PathVariable Long itemId) {
		ItemDesc itemDesc = 
					itemService.findItemDescById(itemId);
		return SysResult.success(itemDesc);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
