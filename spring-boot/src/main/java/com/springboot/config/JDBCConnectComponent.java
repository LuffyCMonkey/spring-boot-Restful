package com.springboot.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JDBCConnectComponent {

	public final JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCConnectComponent(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
}
