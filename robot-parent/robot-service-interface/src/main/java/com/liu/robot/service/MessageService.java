package com.liu.robot.service;

import java.util.List;

import com.liu.robot.bean.Message;

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
