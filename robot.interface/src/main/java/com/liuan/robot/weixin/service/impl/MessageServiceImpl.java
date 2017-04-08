package com.liuan.robot.weixin.service.impl;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.liuan.robot.base.pool.SqlSessionFactoryUtil;
import com.liuan.robot.weixin.bean.Message;
import com.liuan.robot.weixin.dao.MessageDao;
import com.liuan.robot.weixin.service.MessageService;

/**
 * 列表业务相关的功能
 * 
 * @author LIUAN
 *
 */
@Service(value = "messageService")
public class MessageServiceImpl implements MessageService
{
	private static Logger logger = LoggerFactory.getLogger(MessageServiceImpl.class);
	
	@Override
	public List<Message> queryMessageList(String command, String description)
	{
		SqlSession session = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
		List<Message> messageList = null;
		try
		{
			MessageDao messageDao = session.getMapper(MessageDao.class);
			messageList = messageDao.queryMessageList(command, description);
		} catch (Exception e)
		{
			if (session != null)
			{
				session.rollback();
			}
			logger.error("MessageServiceImpl queryMessageList method error:", e);
			throw e;
		} finally
		{
			if (session != null)
			{
				session.close();
			}
		}
		return messageList;
	}
}
