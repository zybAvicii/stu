package com.jt.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class EasyUIImage {
	 private Integer error=0;//1.表示文件失败,0成功
	 private String url;//图片访问地址
	 private Integer width;  //设定跨度宽高
	 private Integer height;
}
