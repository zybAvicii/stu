package com.jt.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)//方法中生效   @Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)//在运行期生效
public @interface Cache_Find {
	
	String key() default "";//有默认值,用户可以选择不写
							//用户有值用用户的,没有值自动生成
	int seconds() default 0;
	//seconds=0,表示用户设置该数据不需要超时时间,如果不等于0则说明自动定义了超时时间						
	
}
