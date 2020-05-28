package com.springboot.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.config.JDBCConnectComponent;

@RestController
public class StatusController {
	
	
	@Autowired
	RedisTemplate<String, Object> redisTemplate;
	
	@Autowired
	JDBCConnectComponent jdbcConfig;

	/**
	 * Restful API 
	 * @return
	 */
	@RequestMapping(value="/ping", method = RequestMethod.GET)
	@ResponseStatus(value= HttpStatus.OK)
	public  String isRunning() {
		return "Alive";
	}
	
	
	/**
	 * redis 연결 테스트
	 * @return
	 */
	@RequestMapping(value="/getRedis", method = RequestMethod.GET)
	@ResponseStatus(value= HttpStatus.OK)
	public  String getRedisData() {
		
		ValueOperations<String, Object> vop = redisTemplate.opsForValue();

        //vop.set("jdkSerial", "jdk");
//        String result = (String) vop.get("jdkSerial");
        String value = "{'keys':Temp,'123':Temp,'daf':Temp}";
		vop.set("test",value);
		
        //byte[] result_2 =  (byte[]) vop.get("luffy");
        String result_2 =  (String) vop.get("test");
        System.out.println("Result2 : "+result_2);
        
        //System.out.println(vop.get("luffy").toString());
		return result_2;
	}
	
	/**
	 * My-SQL 연결 테스트 
	 * @return
	 */
	@RequestMapping(value="/getMysql", method = RequestMethod.GET)
	@ResponseStatus(value= HttpStatus.OK)
	public  String getMysqlData() {
		
		String SQL_GET_USER = "select user_id from test.admin_user limit 1";
		String SQL_GET_ALL = "select * from test.admin_user";
		
		String resultData  = jdbcConfig.jdbcTemplate.queryForObject(SQL_GET_USER,String.class);
		System.out.println("resultData  : "+ resultData);
		
		List<?> resultDataALL  = jdbcConfig.jdbcTemplate.queryForList(SQL_GET_ALL);
		System.out.println("resultDataAll : "+resultDataALL.toString());
		
		return resultDataALL.toString();
	}
}
