package com.example.zhw;

import com.example.zhw.util.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringMytatisApplicationTests
{
	@Autowired
	private RedisUtil redisUtil;

	@Test
	void contextLoads()
	{

	}

	@Test
	public void testStringCommand() {

		redisUtil.set("name","zhw");

		 System.out.println("value"+redisUtil.get("name"));

	}




}
