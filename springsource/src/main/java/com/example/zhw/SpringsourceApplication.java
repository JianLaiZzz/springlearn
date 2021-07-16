package com.example.zhw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = { "com.example.zhw.common.controller", "com.example.zhw.springsource.pay.*" })
public class SpringsourceApplication
{

	public static void main(String[] args)
	{
		//		System.out.println("zhagwwerwer１１2121111");
		//		//        SpringApplication.run(com.example.zhw.SpringsourceApplication.class, args);
		//		System.out.println("hehhe1113213123123");
		//
		//		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		//		Dog person = (Dog) context.getBean("person");

		SpringApplication.run(SpringsourceApplication.class, args);
	}

	public void say()
	{

	}
}
