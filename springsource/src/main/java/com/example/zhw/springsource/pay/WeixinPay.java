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
@PayCode(value = "weixin", name = "微信支付")
public class WeixinPay implements IPay
{
	@Override
	public boolean support(String code)
	{
		return "weixin".equals(code);
	}

	@PostConstruct
	public void init()
	{
		PayStrategyFactory.register("weixinPay", this);
	}

	@Override
	public void pay()
	{
		System.out.println("===发起微信支付===");
	}
}
