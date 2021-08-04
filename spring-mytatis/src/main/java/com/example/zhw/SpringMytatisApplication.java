package com.example.zhw;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringMytatisApplication
{
	@Value("${server.port}")
	private int port;

	public static void main(String[] args)
	{
		SpringApplication.run(SpringMytatisApplication.class, args);
	}

}
