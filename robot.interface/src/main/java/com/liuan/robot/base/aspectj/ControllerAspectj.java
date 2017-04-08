package com.liuan.robot.base.aspectj;

import javax.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import com.alibaba.fastjson.JSON;

/**
* @author 作者 :ANLIU
* @version 创建时间:2016年7月2日
* 类说明
*/
@Component
@Aspect
public class ControllerAspectj
{
	private static Logger logger = LoggerFactory.getLogger(ControllerAspectj.class);
	
	@Around("@annotation(requestMapping)")
	public Object recordRequestLog(ProceedingJoinPoint point,RequestMapping requestMapping) throws Throwable
	{
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		
		logger.debug("Start request :" + request.getRequestURI() + ",Remote address:" + request.getRemoteAddr());
		
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
		logger.debug("End request :" + request.getRequestURI() + ",Cost:" + (end - start) +"ms");
		return obj;
		
	}
	
}
