package com.jt;

import java.util.Arrays;
import java.util.List;

import javax.sql.RowSet;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.jt.mapper.UserMapper;
import com.jt.pojo.User;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestMybatisPlus {
	@Autowired
	private UserMapper userMapper;
	@Test
	public void testSelectOne() {
	/*
		int id=46;
		User user 
			= userMapper.selectById(id);
		System.out.println(user);
		*/
		
		//根据非主键查询   queryWrapper条件构造器=where
		QueryWrapper<User> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("name", "奥特曼");
		//select * from user where name ="xxx";
		User selectOne = 
				userMapper.selectOne(queryWrapper);
		System.out.println(selectOne);
		
	}
	
	/**
	 * 查询多个数据
	 * eq  =
	 * gt  >
	 * ge  >=
	 * lt  <
	 * le  <=
	 * 
	 * */
	@Test
	public void test3() {
		//查询列表所有数据,不需要where(querywrapper)
		List<User> userList 
				= userMapper.selectList(null);
		System.out.println(userList);
		
		//查询年龄大于18岁的
		QueryWrapper<User> queryWrapper= new QueryWrapper<>();
		queryWrapper.gt("age", 18).eq("sex", "女");
		List<User> selectList = userMapper.selectList(queryWrapper);
		System.out.println(selectList);
		}
	
	/**
	 * 用户更新操作 update
	 * 
	 * 将id=54的数据的name名称改为奥特曼,sex=女,age=5000
	 * sql:update user set name="奥特曼",sex="女",age="5000"
	 * */
	@Test
	public void testUpdateUser() {
		//利用主键更新,其余属性当值
		User user=new User();
		user.setId(54).setName("奥特曼").setAge(5000).setSex("女");
		int rows= userMapper.updateById(user);
		System.out.println("影响"+rows);
	}
	//利用条件构造器实现数据的更新
		/**
		 * entity需要修改的数据
		 * updateWrapper更新条件构造器
		 * 可以为null表示全表修改
		 * 按照特定的规则编辑where条件
		 * */
		@Test
		public void testUpdateUser2() {
			User user =new User();
			user.setName("怪兽").setAge(500).setSex("儿子");
			UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
			updateWrapper.eq("id",53);
			int update = 
					userMapper.update(user, updateWrapper);//updateWrapper表示修改id=53的,user为需要修改的数据
			System.out.println("更新"+update);
		}
		
		
		/**
		 * 删除操作
		 * 将56数据删除
		 * */
		@Test
		public void testDeleteById() {
			//主键删除
			int deleteById = userMapper.deleteById(56);
			System.out.println(deleteById);
		}
		
		@Test
		public void testDeleteUser() {
			//根据age=2删除
			QueryWrapper<User> queryWrapper = new QueryWrapper<>();
			queryWrapper.eq("age",2);
			int delete = userMapper.delete(queryWrapper);
			System.out.println(delete);
		}
		
		@Test
		public void testDeletePiliang() {
			//批量删除
			Integer [] intArray= {55,56,57};
			List<Integer> idList = Arrays.asList(intArray);
			int rows = userMapper.deleteBatchIds(idList);
			System.out.println("批量删除了"+rows);
		}
	
	
	
	}















