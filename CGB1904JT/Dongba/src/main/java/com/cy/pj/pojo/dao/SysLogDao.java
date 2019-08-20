package com.cy.pj.pojo.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import com.cy.pj.entity.SysLog;

@Mapper
public interface SysLogDao {
	
	List<SysLog> findAll();

}
