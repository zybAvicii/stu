package com.jt.test.redis;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.mapper.Mapper;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jt.pojo.ItemDesc;

public class TestJson {
	@Test
	public void toJson() throws JsonProcessingException {
		ItemDesc itemDesc =new ItemDesc();
		itemDesc.setItemId(1000L);
		itemDesc.setItemDesc("商品描述信息");
		//单个对象转化为json
		ObjectMapper mapper=new ObjectMapper();
		String json = mapper.writeValueAsString(itemDesc);
		System.out.println(json);	
	}
	
	
	@Test
	public void testList() throws IOException {
		ItemDesc itemDesc =new ItemDesc();
		itemDesc.setItemId(1000L);
		itemDesc.setItemDesc("商品描述信息");
		ItemDesc itemDesc2 =new ItemDesc();
		itemDesc2.setItemId(1000L);
		itemDesc2.setItemDesc("商品描述信息");
		ItemDesc itemDesc3 =new ItemDesc();
		itemDesc3.setItemId(1000L);
		itemDesc3.setItemDesc("商品描述信息");
		
		List<ItemDesc> list=new ArrayList<ItemDesc>();
		list.add(itemDesc);
		list.add(itemDesc2);
		list.add(itemDesc3);
		
		ObjectMapper mapper=new ObjectMapper();
		String json = mapper.writeValueAsString(list);
		System.out.println(json);
		
		//将listjson转化为list对象
		List<ItemDesc> itemList=
				mapper.readValue(json,list.getClass());//mapper对象转换的
		
		System.out.println(itemList);
	}
	
	
	
 
}














