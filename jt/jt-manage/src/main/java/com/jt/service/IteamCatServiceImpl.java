package com.jt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jt.mapper.ItemCatMapper;
import com.jt.pojo.ItemCat;
import com.jt.util.ObjectMapperUtil;
import com.jt.vo.EasyUITree;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.ShardedJedis;

@Service
public class IteamCatServiceImpl implements ItemCatSerivce{
	@Autowired
	private ItemCatMapper itemCatMapper;
	//@Autowired
	private JedisCluster jedis;
	
	@Override
	public String findItemCatById(Long iteamCatId) {
			ItemCat selectById =
						itemCatMapper.selectById(iteamCatId);
		return selectById.getName();
	}
	
	@Override
	public List<EasyUITree> findEasyUITreeList(Long parentId) {
		/**查询出一级菜单信息*/
		QueryWrapper<ItemCat> queryWrapper =new QueryWrapper<ItemCat>();
		queryWrapper.eq("parent_id",parentId);
		List<ItemCat> itemCatList = 
				itemCatMapper.selectList(queryWrapper);
		
		
		/**转换成vo对象用户展示*/
		
		List<EasyUITree> treeList=new ArrayList<EasyUITree>();
		for (ItemCat itemCat : itemCatList) {
			EasyUITree easyUITree=new EasyUITree();
			String state=itemCat.getIsParent()?"closed":"open";
				easyUITree.setId(itemCat.getId())
						  .setText(itemCat.getName())
						  .setState(state);
				treeList.add(easyUITree);
		}
		
		return treeList;
	}

	@Override
	public List<EasyUITree> findEasyUITreeCache(Long parentId) {
		List<EasyUITree> treeList=new ArrayList<EasyUITree>();
		String key="ITEM_CAT"+parentId;
		
		String result = jedis.get(key);
		if(StringUtils.isEmpty(result)) {
			 treeList = findEasyUITreeList(parentId);
			 
			 String value = ObjectMapperUtil.toJSON(treeList);
			 jedis.set(key, value);
			 System.out.println("查询后台数据库");
		}else {
			treeList=ObjectMapperUtil.toObject(result, treeList.getClass());
			System.out.println("查询redis缓存");
		}
		
		
		return treeList;
	}

	

}










