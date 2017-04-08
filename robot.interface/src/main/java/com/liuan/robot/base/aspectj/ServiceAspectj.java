package com.liuan.robot.base.aspectj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSON;

/**
* @author 作者 :ANLIU
* @version 创建时间:2016年7月2日
* 类说明
*/
@Component
@Aspect
public class ServiceAspectj
{
	private static Logger logger = LoggerFactory.getLogger(ServiceAspectj.class);
	
	@Around("@within(service)")
	public Object recordRequestLog(ProceedingJoinPoint point,Service service) throws Throwable
	{
		
		logger.debug("Start invoke :" + point.getSignature().getName());
		
		Object[] args = point.getArgs();
		if(args != null)
		{
			logger.debug("Request Param:" + args);
		}
		else
		{
			logger.debug("Request Param: Nothing..." );
		}
		long start = System.currentTimeMillis();
		Object obj = point.proceed();
		if(obj != null)
		{
			String retStr = JSON.toJSONString(obj);
			if(retStr.length() > 300)
			{
				retStr = retStr.substring(0, 100) + "......." + retStr.substring(retStr.length() - 100, retStr.length());
			}
			logger.debug("Response Object :" + retStr);
		}
		else
		{
			logger.debug("Response Object :Nothing");
		}
		long end = System.currentTimeMillis();
		logger.debug("End invoke:" + point.getSignature().getName() + ",Cost:" + (end - start) + "ms");
		return obj;
		
	}
	
}
