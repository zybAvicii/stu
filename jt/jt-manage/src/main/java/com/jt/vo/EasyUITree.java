package com.jt.vo;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class EasyUITree {
	private Long id;		//节点id
	private String text;	//节点名称
	private String state;	//节点开关open,closed
	
}
