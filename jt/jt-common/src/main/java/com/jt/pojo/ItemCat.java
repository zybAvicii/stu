package com.jt.pojo;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@TableName("tb_item_cat")
public class ItemCat {
	private Long id;
	private Integer parentId;
	private String name;
	private Integer status;
	private Integer sortOrder;
	private Boolean isParent;
	private Date created;
	private Date updated;
	
	
}
