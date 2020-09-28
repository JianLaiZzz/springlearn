package com.example.springelasticsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.example.springelasticsearch", "service2" })
public class SpringElasticsearchApplication
{

	public static void main(String[] args)
	{
		SpringApplication.run(SpringElasticsearchApplication.class, args);
	}

}
