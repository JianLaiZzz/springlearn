package com.example.zhw.springsource.pay.annotation;

import com.example.zhw.springsource.pay.IPay;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ZhangWei
 * @Date 2021/7/16 14:24
 * @Version 1.0
 */

@Service
public class PayService2 implements ApplicationListener<ContextRefreshedEvent>
{

	private static Map<String, IPay> payMap = null;

	public void pay(String code)
	{
		payMap.get(code).pay();
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent)
	{

		ApplicationContext applicationContext = contextRefreshedEvent.getApplicationContext();
		Map<String, Object> beansWithAnnotation = applicationContext
				.getBeansWithAnnotation(PayCode.class);

		if (beansWithAnnotation != null)
		{
			payMap = new HashMap<>(156);
			beansWithAnnotation.forEach((key, value) ->
			{
				String bizType = value.getClass().getAnnotation(PayCode.class).value();
				payMap.put(bizType, (IPay) value);
			});
		}

	}
}
