package com.example.zhw.springsource;

import com.example.zhw.springsource.pay.IPay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author zhangwei
 * @date 2021/1/12 21:06
 **/
@RestController
@RequestMapping("/hello2")
public class HelloController
{

	static
	{
		System.out.println("ehheh");
	}

	private Map map;

	public HelloController(Map<String, IPay> map)
	{

		System.out.println("ehheh11111");
		this.map = map;
	}

	@RequestMapping("/hello")
	public String hello()
	{
		return "zhw";
	}
}
