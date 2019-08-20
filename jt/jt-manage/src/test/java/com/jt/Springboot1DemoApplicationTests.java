package com.jt;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jt.mapper.ItemMapper;
import com.jt.pojo.Item;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot1DemoApplicationTests {

	@Autowired
	private ItemMapper itemMapper;
	
	
	@Test
	public void test() {
		List<Item> selectList = itemMapper.selectList(null);
		System.err.println(selectList);
	}
	

}
