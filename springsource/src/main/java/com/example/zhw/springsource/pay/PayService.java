package com.example.zhw.springsource.pay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

/**
 * @Author ZhangWei
 * @Date 2021/7/16 14:19
 * @Version 1.0
 */
public class PayService
{
	@Autowired
	private AliaPay aliaPay;
	@Autowired
	private WeixinPay weixinPay;
	@Autowired
	private JingDongPay jingDongPay;

	public void toPay(String code)
	{
		if ("alia".equals(code))
		{
			aliaPay.pay();
		}
		else if ("weixin".equals(code))
		{
			weixinPay.pay();
		}
		else if ("jingdong".equals(code))
		{
			jingDongPay.pay();

		}
		else
		{
			System.out.println("找不到支付方式");
		}
	}
}
