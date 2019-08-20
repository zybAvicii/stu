package com.jt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jt.anno.Cache_Find;
import com.jt.service.ItemCatSerivce;import com.jt.vo.EasyUITable;
import com.jt.vo.EasyUITree;

@RestController
public class ItemCatController {
		@Autowired
		private ItemCatSerivce itemCatSerivce;
		/**
		 * 根据商品分类ID号,查询商品类名称
		 * data:{itemCatId:val}
		 * 
		 * 用户传递的参数名称必须和接收的参数名称一致
		 * String data=request.getParamter("itemCatId"); request只能返回String类型
		 * 所以-> Long aa=Long.parseLong(data);
		 * */
		@RequestMapping("/item/cat/queryItemName")//不执行视图解析器
		public String findItemCatNameById(Long itemCatId) {
				String findItemCatById = 
						itemCatSerivce.findItemCatById(itemCatId);
			return findItemCatById;
		}
		
		/**
		 * @RequestParam 
		 * 		defaultValue:默认值 当参数为null时 设定默认值
		 * 		name/value:获取用户传递的数据信息
		 * 		required:是否为必须传递值  true / false
		 * 		
		 * */
		
		@RequestMapping("/item/cat/list")
		@Cache_Find()
		public List<EasyUITree> findItemCatList(
				@RequestParam(defaultValue = "0",name="id") Long parentId) {
					//defaultValue="0" parentId=0,查询一级标题
			
		
			return itemCatSerivce.findEasyUITreeList(parentId);
			//return itemCatSerivce.findEasyUITreeCache(parentId);
		}
		/*查parent_id=0方法
		@RequestMapping("/item/cat/list")
		public List<EasyUITree> findItemCatList() {
			Long parentIdLong=0L;
			return itemCatSerivce.findEasyUITreeList(parentIdLong);
		}
		*/
		
		
		
}

















