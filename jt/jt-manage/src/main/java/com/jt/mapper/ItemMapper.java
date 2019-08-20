package com.jt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jt.pojo.Item;
@Mapper
public interface ItemMapper extends BaseMapper<Item>{
	/**
	 * 关于使用mybatis规则说明
	 * mybatis在进行接口传参时,只能传递单值
	 * 如果需要传递多值,需要将单值进行封装
	 * 1.1封装对象类型 User
	 * 1.2封装为array list
	 * 1.3封装为Map集合<key,value> @param标识map集合中的key,key不能重复
	 * 
	 * 
	 * $符和#号
	 * 		#号:	
	 * 			1.使用#号有预编译的效果
	 * 			2.使用#号为参数添加一对""号
	 * 		$符:
	 * 			一般以字段名称为参数时使用$
	 * 
	 * */	
	@Select("SELECT * FROM tb_item ORDER BY updated DESC LIMIT #{start},#{rows}")
	List<Item> findItemByPage(
				@Param("start")Integer start,
				@Param("rows")Integer rows);
}














