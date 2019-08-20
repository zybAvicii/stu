package com.cy;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cy.pj.entity.SysLog;
import com.cy.pj.pojo.dao.SysLogDao;

@SpringBootTest
@RunWith(SpringRunner.class)
public class Test1 {
	
	@Autowired
	private SysLogDao sysLogDao;
	
	
	@Test
	public void findAll() {
		List<SysLog> list = 
				sysLogDao.findAll();
		System.out.println(list);
	}

}















