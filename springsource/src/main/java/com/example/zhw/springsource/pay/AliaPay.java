package com.example.zhw.springsource.pay;

import com.example.zhw.springsource.pay.annotation.PayCode;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @Author ZhangWei
 * @Date 2021/7/16 14:18
 * @Version 1.0
 */

@Service
@PayCode(value = "alia", name = "支付宝支付")
public class AliaPay implements IPay
{
	@Override
	public boolean support(String code)
	{
		return "alia".equals(code);
	}

	@PostConstruct
	public void init()
	{
		PayStrategyFactory.register("aliaPay", this);
	}

	@Override
	public void pay()
	{

		System.out.println("===发起支付宝支付===");
	}
}
