package com.example.zhw.springshardingsphere;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "cn.iocoder.springboot.lab18.shardingdatasource.mapper")
public class SpringShardingsphereApplication
{

	public static void main(String[] args)
	{
		SpringApplication.run(SpringShardingsphereApplication.class, args);
	}

}
