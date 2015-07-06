package com.store59.kylin.ext.data;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.store59.kylin.datasource.factory.MasterDB;
import com.store59.kylin.ext.data.mapper.AppVersionMapper;

@Configuration
public class ExtMasterFactory {
	@Autowired
	private MasterDB masterDB;

	@Bean
	public SqlSessionTemplate masterSqlSession() {
		return masterDB.getSqlSession();
	}

	@Bean
	public MapperFactoryBean<AppVersionMapper> masterAppVersionMapper()
			throws Exception {
		MapperFactoryBean<AppVersionMapper> mapperFactory = new MapperFactoryBean<>();
		mapperFactory.setMapperInterface(AppVersionMapper.class);
		mapperFactory.setSqlSessionTemplate(masterSqlSession());
		return mapperFactory;
	}
}