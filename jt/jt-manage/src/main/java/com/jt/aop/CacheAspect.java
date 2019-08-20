package com.jt.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import com.jt.anno.Cache_Find;
import com.jt.util.ObjectMapperUtil;
import redis.clients.jedis.JedisCluster;


@Component //将对象交给spring容器管理
@Aspect	   //表示切面 切面=切入点+通知
public class CacheAspect {
	//表示调用时注入
	@Autowired(required = false)
	private JedisCluster jedis;
	/**
	 * 环绕通知Around
	 * 1.返回值 必须为Object类型
	 * 			表示执行完成业务之后返回用户数据对象
	 * 2.		(1)必须位于第一位
	 * 			(2)参数类型必须为ProceedingJoinPoint(只有around才能使用因为要控制目标方法执行)
	 * 3.springAOP中提供了可以直接获取注解的方法,但是要求参数的名称必须一致,否则映射错误 
	 *
	 * */
	@Around("@annotation(cacheFind)")
	@Cache_Find
	public Object around(ProceedingJoinPoint joinPoint,Cache_Find cacheFind) {
		String key=getKey(joinPoint,cacheFind);
		String resultJSON = jedis.get(key);
		Object resultData=null;
		
		
		
		if(StringUtils.isEmpty(resultData)) {
			try {
				//需要执行真实的目标方法
				resultData = joinPoint.proceed();
				String value = ObjectMapperUtil.toJSON(resultData);
				
				//判断数据是否永久保存
				if(cacheFind.seconds()>0) {
					jedis.setex(key, cacheFind.seconds(), value);
				}else {
					jedis.set(key, value);
					System.out.println("AOP查询数据成功");
				}
			} catch (Throwable e) {
			
				e.printStackTrace();
				throw new RuntimeException(e);
				}//由于业务需要,要获取目标方法的返回值类型
			Class returnType = getType(joinPoint);
			//表示redis中有数据 将json转化为对象
			resultData = ObjectMapperUtil.toObject(resultJSON,returnType);
			System.out.println("AOP查询缓存成功!!!!");
	
		}
		return resultData;
	}

	private Class getType(ProceedingJoinPoint joinPoint) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		return signature.getReturnType();
		
	}

	private String getKey(ProceedingJoinPoint joinPoint,Cache_Find cacheFind) {
		String key = cacheFind.key();
		if (StringUtils.isEmpty(key)) {
			String name = joinPoint.getSignature().getName();
			String className = joinPoint.getSignature().getDeclaringTypeName();
			Object object = joinPoint.getArgs()[0];
		}else {
			return key;
		}
		return key;
	
	
	}
	

}	
	
	














