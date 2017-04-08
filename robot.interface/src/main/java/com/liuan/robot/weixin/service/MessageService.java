package com.liuan.robot.weixin.service;

import java.util.List;
import com.liuan.robot.weixin.bean.Message;

/**
 * 列表业务相关的功能
 * 
 * @author LIUAN
 *
 */
public interface MessageService
{
	
	public List<Message> queryMessageList(String command, String description) ;
	
}
