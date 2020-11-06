package com.example.zhw.springsource.springdesign.proxy.dbroute;

import com.example.zhw.springsource.springdesign.proxy.dbroute.proxy.OrderServiceStaticProxy;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhangwei
 * @date 2020/11/5 16:02
 */
public class DbRouteProxyTest {

    public static void main(String[] args) {
        try {
            Order order = new Order();


            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            Date date = sdf.parse("2017/02/01");
            order.setCreateTime(date.getTime());

            IOrderService orderService = (IOrderService) new OrderServiceStaticProxy(new OrderServiceImpl());
            orderService.createOrder(order);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
