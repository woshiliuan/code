package com.liuan.robot.robotinterface.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
* @author 作者 :ANLIU
* @version 创建时间:2016年4月17日
* 入口类
*/
@Configuration
@ComponentScan(basePackages = "com.liuan.robot")
@EnableAutoConfiguration
public class Application extends SpringBootServletInitializer
{
	@SuppressWarnings("static-access")
	public static void main(String[] args)
	{
		SpringApplication application = new SpringApplication();
		application.setAddCommandLineProperties(false);
		application.run(Application.class,args);
	}
}
