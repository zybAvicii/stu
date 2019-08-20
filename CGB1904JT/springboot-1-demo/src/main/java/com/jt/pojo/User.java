package com.jt.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain =true) //连续操作对象(生成多份)
public class User {
	
	private String name;
	private int age;
	private String sex;
	private Integer id;
	
}
