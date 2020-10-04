package com.example.zhw.springshardingsphere;

import com.example.zhw.springshardingsphere.mapper.OrderConfigMapper;
import com.example.zhw.springshardingsphere.vo.OrderConfigVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringShardingsphereApplication.class)
public class OrderConfigMapperTest
{

	@Autowired
	private OrderConfigMapper orderConfigMapper;

	@Test
	public void testSelectById()
	{
		OrderConfigVo orderConfig = orderConfigMapper.selectByPrimaryKey(1);
		System.out.println(orderConfig);
	}
}
