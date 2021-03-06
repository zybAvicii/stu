package com.jt.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.HttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.config.HttpClientClose;
import com.jt.pojo.Item;
import com.jt.service.ItemServer;
import com.jt.util.HttpClientService;
import com.jt.util.ObjectMapperUtil;

@Service
public class ItemServerImpl implements ItemServer{
	
	@Autowired
	private HttpClientService httpClient;
	
	@Override
	public Item findItemById(Long itemId) {
		String url = 
				"http://manage.jt.com/web/item/findItemById";
		Map<String, String> params=new HashMap<String,String>();
		params.put("itemId",""+itemId);
		String result = httpClient.doGet(url,params);
		Item item = ObjectMapperUtil.toObject(result, Item.class);
		return item;
	}

}
