package com.jt.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain=true)
@TableName(value = "user") //对象与表一一对应
//如果表名与对象的名称一致,可省略不写
public class User {
	@TableId(type = IdType.AUTO)
	private Integer id;//主键自增
	@TableField(value = "name")//手动配置属性与字段的对应关系
	private String name;
	private Integer age;
	private String sex;
}
