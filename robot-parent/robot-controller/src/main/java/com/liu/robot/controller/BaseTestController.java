package com.liu.robot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liu.robot.bean.Message;
import com.liu.robot.bean.ResultMessage;
import com.liu.robot.service.MessageService;

/**
* @author 作者 :ANLIU
* @version 创建时间:2016年4月17日
* spring mvc 基本测试类
*/
@Controller
@ImportResource({ "classpath:spring-context.xml"})
@RequestMapping(value="basetest")
public class BaseTestController
{
	@Autowired
	private MessageService messageService ;
	
	@RequestMapping(value = "/test1")
	@ResponseBody
	public String Test1()
	{
		System.out.println("ok");
		return "hello";
	}
	
	@RequestMapping(value = "/test2")
	@ResponseBody
	public ResultMessage<?> Test2()
	{
		ResultMessage<List<Message>> msg = new ResultMessage<List<Message>>();
		System.out.println("ok");
		List<Message> list = messageService.queryMessageList(null, null);
		
		msg.setRetCode(0);
		msg.setRetErrorMsg("query messages success");
		msg.setData(list);
		return msg;
	}
	
}
