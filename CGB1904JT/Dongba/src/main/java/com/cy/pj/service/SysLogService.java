package com.cy.pj.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cy.pj.entity.SysLog;


public interface SysLogService {
	
	List<SysLog> findAll();
}
