package com.springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@PropertySource("classpath:application.properties")
public class RedisConfig {

	@Autowired
	Environment environment;
	
	private final String HOST = "spring.redis.host";
	private final String PORT = "spring.redis.port";
		
	@Bean
	 RedisConnectionFactory redisConnectionFactory() {
		String host = environment.getProperty(HOST);
		int port = Integer.parseInt(environment.getProperty(PORT));
		 return new LettuceConnectionFactory(host, port);
	 }
	
	 @Bean
	 RedisTemplate<String, Object> redisTemplate(){
		 RedisTemplate<String, Object> redisTemplate =   new RedisTemplate<>();
		 redisTemplate.setKeySerializer(new StringRedisSerializer());
		 //redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
		 redisTemplate.setValueSerializer(new StringRedisSerializer());
		 redisTemplate.setConnectionFactory(redisConnectionFactory());
	
		 return redisTemplate;
	 }
}
