package com.jt.service;

import java.util.List;

import com.jt.vo.EasyUITree;

public interface ItemCatSerivce {
	
	public String findItemCatById(Long iteamCatId);
	
	public List<EasyUITree> findEasyUITreeList(Long parentId);
	
	public List<EasyUITree> findEasyUITreeCache(Long parentId);
}
