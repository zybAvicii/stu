package com.jt.service;


import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jt.mapper.UserMapper;
import com.jt.pojo.User;
import com.jt.util.ObjectMapperUtil;

import redis.clients.jedis.JedisCluster;

@Service(timeout = 3000)
public class DubboUserServiceImpl implements DubboUserService {
		
		@Autowired
		private JedisCluster jedisCluster;
		@Autowired
		private UserMapper userMapper;
		@Override
		public void insertUser(User user) {
			String md5Pass =
					DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
		user.setPassword(md5Pass)
			.setCreated(new Date())
			.setUpdated(user.getCreated());
		System.out.println(user);
		userMapper.insert(user);
		}

		@Override
		public String doLogin(User user) {
				String md5Pass = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
				//user账号密码,md5加密
				user.setPassword(md5Pass);//设置密码
				QueryWrapper<User> queryWrapper = new QueryWrapper<User>(user);
				
				User userDB = userMapper.selectOne(queryWrapper);//查数据库中	
				String key = null;//秘钥																
				if(userDB!=null) {//查到数据
					//表示用户名密码正确    UUID
					 key = 
					DigestUtils.md5DigestAsHex(UUID.randomUUID().toString().getBytes());
					//数据脱敏处理
					userDB.setPassword("123456");
					String userJSON = ObjectMapperUtil.toJSON(userDB);
					jedisCluster.setex(key,7*24*3600, userJSON);
				}
				return key;
		}
		
}













