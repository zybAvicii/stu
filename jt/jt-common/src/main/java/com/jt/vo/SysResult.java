package com.jt.vo;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 定义系统返回值vo
 * */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class SysResult implements Serializable{	//系统结果返回,显示程序运行正确或错误信息返回
	private Integer status;		//服务器返回200正确,201失败
	private String msg;			//服务器返回提示信息
	private Object data;		//服务器返回业务数据
	 
	public static SysResult success() {
		return new SysResult(200,"服务器执行成功!!!", null);
	}
	public static SysResult success(String msg,Object data) {
		return new SysResult(200, msg, data);
	}
	public static SysResult success(Object data) {
		return new SysResult(200,"服务器执行成功!!!", data);
	}
	public static SysResult fail() {
		return new SysResult(201,"服务器处理失败!!!",null);
	}
	/*
	 * public static SysResult success(String name) {
	 * 
	 * return new SysResult(200,name,null); }
	 */
}
