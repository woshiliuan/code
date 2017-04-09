package com.liu.robot.pool;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.druid.pool.DruidDataSource;
import com.liu.robot.utils.ConfigUtils;

public class DataBaseConnectionPool {

	private static final Logger logger = LoggerFactory.getLogger(DataBaseConnectionPool.class);
	private static SqlSessionFactory sessionFactory = null;

	private DataBaseConnectionPool() {
		initSqlSessionFactory();
	}

	private void initSqlSessionFactory() {
		DruidDataSource dataSource = new DruidDataSource();
		initDatasource(dataSource);
		MySqlSessionFactory sqlSessionFactory = new MySqlSessionFactory();
		sqlSessionFactory.setDataSource(dataSource);
		sqlSessionFactory.setConfigLocation(ConfigUtils.getProperty("mybatis.configfile"));
		try {
			 sessionFactory= sqlSessionFactory.buildSqlSessionFactory();
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
	}

	private void initDatasource(DruidDataSource dataSource) {
		dataSource.configFromPropety(ConfigUtils.getProperties());
		dataSource.setDriverClassName(ConfigUtils.getProperty("jdbc.driver.className"));
		dataSource.setUrl(ConfigUtils.getProperty("jdbc.url"));
		dataSource.setUsername(ConfigUtils.getProperty("jdbc.username"));
		dataSource.setPassword(ConfigUtils.getProperty("jdbc.password"));
		dataSource.setMaxActive(Integer.parseInt(ConfigUtils.getProperty("jdbc.maxActive")));
		dataSource.setInitialSize(Integer.parseInt(ConfigUtils.getProperty("jdbc.initialSize")));
		dataSource.setMaxWait(Long.parseLong(ConfigUtils.getProperty("jdbc.maxWait")));
		dataSource.setMinIdle(Integer.parseInt(ConfigUtils.getProperty("jdbc.minIdle")));
		dataSource.setRemoveAbandonedTimeout(Integer.parseInt(ConfigUtils.getProperty("jdbc.removeAbandonedTimeout")));
		try {
			dataSource.init();
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
		}
	}

	private SqlSessionFactory getSessionFactory() throws SQLException {
		if (null != sessionFactory) {
			return sessionFactory;
		}else{
			initSqlSessionFactory();
			return sessionFactory;
		}
	}

	public static SqlSessionFactory getSqlSessionFactory() {
		return DataBaseConnectionPoolHolder.getSqlSessionFactory();
	}

	private static class DataBaseConnectionPoolHolder {

		private static DataBaseConnectionPool dataSource = new DataBaseConnectionPool();

		public static SqlSessionFactory getSqlSessionFactory() {
			try {
				return dataSource.getSessionFactory();
			} catch (SQLException e) {
				logger.error(e.getMessage(), e);
			}
			return null;
		}
	}
}
