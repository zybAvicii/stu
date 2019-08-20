package com.jt.vo;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;
//@ControllerAdvice	//定义全局异常处理机制
@RestControllerAdvice
@Slf4j				//引入日志API
public class SysResultControllerAdvice {
	
	//当发生什么异常时使用该处理方式
	@ExceptionHandler(RuntimeException.class)
	//@ResponseBody
	public SysResult sysResultException(Exception exception) {
		exception.printStackTrace();
		log.error("服务器异常:"+exception.getMessage());
		return SysResult.fail();
	}
}
