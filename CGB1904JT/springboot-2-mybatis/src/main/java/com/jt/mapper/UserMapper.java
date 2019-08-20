package com.jt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jt.pojo.User;

@Mapper//可以在主启动类中加@MapperScan("com.jt.mapper")
public interface UserMapper extends BaseMapper<User>{
	/*@Select("select * from user")*/
	List<User> findAll();
	
	
	void  insertUser(User user);
}
