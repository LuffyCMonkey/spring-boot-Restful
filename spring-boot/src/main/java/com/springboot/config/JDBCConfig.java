package com.springboot.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource("classpath:application.properties")
public class JDBCConfig {

	@Autowired
	Environment environment;

	private final String URL = "spring.datasource.url";
	private final String USER = "spring.datasource.username";
	private final String PASSWORD = "spring.datasource.password";
	private final String DRIVER = "spring.datasource.driverClassName";
	
	@Bean
	DataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setUrl(environment.getProperty(URL));
		driverManagerDataSource.setUsername(environment.getProperty(USER));
		driverManagerDataSource.setPassword(environment.getProperty(PASSWORD));
		driverManagerDataSource.setDriverClassName(environment.getProperty(DRIVER));

		return driverManagerDataSource;
	}
	
	/*
	 * MyBatis 사용시 주석 해지 하고 위 DataSource 
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		
		sessionFactory.setDataSource(dataSource);
		sessionFactory.setMapperLocations(
				new PathMatchingResourcePatternResolver().getResources("classpath:mappers/*.xml"));
		
		sessionFactory.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
		return sessionFactory.getObject();		
	}
	*/
	
}
