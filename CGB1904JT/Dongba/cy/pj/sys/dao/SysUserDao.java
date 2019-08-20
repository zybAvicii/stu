package com.cy.pj.sys.dao;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import com.cy.pj.common.vo.CheckBox;
import com.cy.pj.sys.entity.SysUser;
import com.cy.pj.sys.vo.SysUserDeptVo;

@Mapper
public interface SysUserDao extends PageDao<SysUserDeptVo> {
    
	 SysUserDeptVo findObjectById(Integer id);
	
	 int updateObject(SysUser entity);
	 
	 
	 int insertObject(SysUser entity);
	
	 List<CheckBox> findObjects();
	 
	 
	 SysUser findUserByUserName(String username);
	 
	/*
	 @Update("update sys_users "
     		+ "set valid=#{valid},modifiedUser=#{modifiedUser},modifiedTime=now() "
     		+ "where id=#{id}")*/
	 /**禁用与启用*/
	 // #{valid与@param("valid")相同}
	 int validById(
			 @Param("id")Integer id,  //基于用户id修改
			 @Param("valid")Integer valid, //修改状态
			 @Param("modifiedUser")String modifiedUser);//修改的人
}













