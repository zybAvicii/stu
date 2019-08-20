package com.cy.pj.common.web;
import java.net.BindException;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.cy.pj.common.vo.JsonResult;

import lombok.extern.slf4j.Slf4j;
/**
 *  Spring MVC 全局异常处理
 *  @ControllerAdvice 描述的类为全局异常处理类,
 *  此类内部可以定义很多异常处理方法
 */
//@ControllerAdvice
@RestControllerAdvice //此类也会交给spring管理
@Slf4j
public class GlobalExceptionHandler {
	 /**
	  * @ExceptionHandler 注解描述的方法为异常处理方法
	  */
	   @ExceptionHandler(RuntimeException.class)
	   //@ResponseBody
	   public JsonResult doHandleRuntimeException(
			   RuntimeException e) {
		   e.printStackTrace();
		   return new JsonResult(e);
	   }
	   @ExceptionHandler(BindException.class)
	  public JsonResult doHandleBindException(BindException e) {
		log.error(e.getMessage(),e);
		  return new JsonResult(e);  
	  }
	   
	   
}









