package com.liu.robot.pool;

import org.apache.ibatis.session.SqlSessionFactory;


public class SqlSessionFactoryUtil {
	public static SqlSessionFactory getSqlSessionFactory() {
		return DataBaseConnectionPool.getSqlSessionFactory();
	}
}
