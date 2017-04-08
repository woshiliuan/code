package com.liuan.robot.robotinterface.testcontroller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.liuan.robot.base.bean.ResultMessage;
import com.liuan.robot.weixin.bean.Message;
import com.liuan.robot.weixin.service.MessageService;

/**
* @author 作者 :ANLIU
* @version 创建时间:2016年4月17日
* spring mvc 基本测试类
*/
@Controller
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
