package com.example.zhw.config;


import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author: zhw
 * @createDate: 2020/4/19
 */

@Configuration
@MapperScan("com.example.zhw.mapper.*")
@EnableTransactionManagement
public class MybatisConfig
{
	@Bean
	public PaginationInterceptor paginationInterceptor()
	{
		return new PaginationInterceptor();
	}
}
