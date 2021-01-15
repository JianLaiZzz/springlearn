package com.example.zhw.springsource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangwei
 * @date 2021/1/12 21:06
 **/
@RestController
@RequestMapping("/hello2")
public class HelloController
{

	@RequestMapping("/hello")
	public String hello()
	{
		return "zhw";
	}
}
