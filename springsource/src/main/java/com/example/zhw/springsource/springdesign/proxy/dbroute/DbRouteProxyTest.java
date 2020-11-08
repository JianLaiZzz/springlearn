package com.example.zhw.springsource.springdesign.proxy.dbroute;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.example.zhw.springsource.springdesign.proxy.dynamicproxy.jdkproxy.OrderServiceDynamicProxy;

/**
 * @author zhangwei
 * @date 2020/11/5 16:02
 */
public class DbRouteProxyTest
{

	public static void main(String[] args)
	{
		try
		{
			Order order = new Order();

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			Date date = sdf.parse("2017/02/01");
			order.setCreateTime(date.getTime());

			//            IOrderService orderService = (IOrderService) new OrderServiceStaticProxy(new OrderServiceImpl());

			IOrderService orderService = (IOrderService) new OrderServiceDynamicProxy()
					.getInstance(new OrderServiceImpl());
			orderService.createOrder(order);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}
}
