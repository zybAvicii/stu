package com.cy.pj.sys.dao;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PageDao<T> {
	/**
	 * 总记录数
	 * */
	int getRowCount(@Param("name")String name);
	
	/**
	 * 首页,上一页,下一页
	 * */
	List<T> findPageObjects(
			@Param("name")String name,
			@Param("startIndex")Integer startIndex,
			@Param("pageSize")Integer pageSize);
}
