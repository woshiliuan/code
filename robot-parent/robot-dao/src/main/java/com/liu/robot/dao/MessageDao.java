package com.liu.robot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.liu.robot.bean.Message;

/**
 * 和message表相关的数据库操作
 * 
 * @author LIUAN
 *
 */
public interface MessageDao
{
	/**
	 * 根据条件查询消息列表
	 * @return 
	 */
	public List<Message> queryMessageList(@Param("command")String command, @Param("description")String description);
	
}
