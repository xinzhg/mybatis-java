package com.dylan.web.controller;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import com.dylan.dao.PortalDocumentMapper;
import com.jolbox.bonecp.BoneCPDataSource;

public class DatabaseConfig {
	@Bean
	public PortalDocumentMapper portalDocumentMapper() throws Exception {
		SqlSessionTemplate sessionTemplate = new SqlSessionTemplate(sqlSessionFactory());
		return sessionTemplate.getMapper(PortalDocumentMapper.class);
	}

	@Bean
	public PlatformTransactionManager transactionalManagerOne() {
		return new DataSourceTransactionManager(dataSource());
	}

	// @Bean
	// public DataSourceTransactionManager transactionManager() {
	// final DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
	// transactionManager.setDataSource(dataSource());
	// return transactionManager;
	// }
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource());
		return sessionFactoryBean.getObject();
	}

	private BoneCPDataSource dataSource() {
		BoneCPDataSource ds = new BoneCPDataSource();
		ds.setDriverClass("com.mysql.jdbc.Driver");
		ds.setJdbcUrl("jdbc:mysql://localhost:3306/webportal");
		ds.setUsername("root");
		ds.setPassword("mysql");
		ds.setAcquireIncrement(1);
		ds.setMinConnectionsPerPartition(2);
		ds.setMaxConnectionsPerPartition(20);
		ds.setPartitionCount(2);
		return ds;
	}
}
