package com.jt.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jt.pojo.ItemDesc;

@Mapper
public interface ItemDescMapper extends BaseMapper<ItemDesc>{
		void deleteItemDescById(Long[] ids);
}
