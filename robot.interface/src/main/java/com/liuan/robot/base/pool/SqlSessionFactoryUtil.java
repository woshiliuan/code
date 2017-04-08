package com.liuan.robot.base.pool;

import org.apache.ibatis.session.SqlSessionFactory;


public class SqlSessionFactoryUtil {
	public static SqlSessionFactory getSqlSessionFactory() {
		return DataBaseConnectionPool.getSqlSessionFactory();
	}
}
