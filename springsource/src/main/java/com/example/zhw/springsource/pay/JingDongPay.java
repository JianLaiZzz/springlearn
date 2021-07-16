package com.example.zhw.springsource.pay;

import com.example.zhw.springsource.pay.annotation.PayCode;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @Author ZhangWei
 * @Date 2021/7/16 14:19
 * @Version 1.0
 */

@Service
@PayCode(value = "jingdong", name = "京东支付")
public class JingDongPay implements IPay
{
	@Override
	public boolean support(String code)
	{
		return "jingdong".equals(code);
	}

	@PostConstruct
	public void init()
	{
		PayStrategyFactory.register("jingDongPay", this);
	}

	@Override
	public void pay()
	{
		System.out.println("===发起京东支付===");
	}
}
