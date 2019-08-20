package com.jt;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jt.mapper.UserMapper;
import com.jt.pojo.User;

@SpringBootTest //springBoot容器启动时加载测试类的配置
@RunWith(SpringRunner.class)
public class TestSpringBoot {
	@Autowired
	private UserMapper userMapper;
	
	@Test
	public void test2() {
		User user=new User();
		user.setAge(1111).setId(null).setName("sb").setSex("a");
		int rows =
				userMapper.insert(user);
		System.out.println("入库成功!"+rows);
	}
	
	
	
	
	
	
	@Test
	public void testFind() {
		List<User> findAll = 
				userMapper.findAll();
		System.out.println(findAll);
		System.out.println("获取代理对象的类型"+userMapper.getClass());
	}
	
	@Test
	public void inserUser() {
		User user =new User();
		user.setId(null).setName("憨憨").setSex("sb").setAge(1000);
		 userMapper.insertUser(user);
		 System.out.println("done");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
