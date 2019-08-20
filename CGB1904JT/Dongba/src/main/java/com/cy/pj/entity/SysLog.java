package com.cy.pj.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class SysLog implements Serializable{
	private static final long serialVersionUID = -4885417306191204914L;
	private Integer id;
	private String username;
	private String operation;
	private String method;
	private String params;
	private Integer time;
	private String ip;
	private Date createTime;
	
}
