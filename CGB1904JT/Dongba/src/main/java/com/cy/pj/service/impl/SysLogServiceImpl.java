package com.cy.pj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cy.pj.entity.SysLog;
import com.cy.pj.pojo.dao.SysLogDao;
import com.cy.pj.service.SysLogService;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class SysLogServiceImpl  implements SysLogService{
	@Autowired
	private SysLogDao sysLogDao;
	
	@Override
	public List<SysLog> findAll() {
		List<SysLog> list = sysLogDao.findAll();
		log.info(list.toString());
	
		return list;
	}

}
