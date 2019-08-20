package com.jt.util;

import com.jt.pojo.User;

//threadlocal API
//动态获取User对象
public class UserThreadLocal {

	private static ThreadLocal<User> thread=new ThreadLocal<User>();
	
	public static void set(User user) {
		thread.set(user);
		
	}
	public static User get() {
		User user = thread.get();
		return user;	
	}
	public static void remove() {
		thread.remove();
	}
	
}