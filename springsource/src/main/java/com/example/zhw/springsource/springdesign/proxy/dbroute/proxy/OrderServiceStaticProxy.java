package com.example.zhw.springsource.springdesign.proxy.dbroute.proxy;

import com.example.zhw.springsource.springdesign.proxy.dbroute.IOrderService;
import com.example.zhw.springsource.springdesign.proxy.dbroute.Order;
import com.example.zhw.springsource.springdesign.proxy.dbroute.db.DynamicDataSourceEntity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhangwei
 * @date 2020/11/5 15:58
 */
public class OrderServiceStaticProxy implements IOrderService {

    private SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");

    private IOrderService orderService;

    public OrderServiceStaticProxy(IOrderService orderService) {
        this.orderService = orderService;
    }


    @Override
    public int createOrder(Order order) {

        Long time = order.getCreateTime();
        Integer dbRouter = Integer.valueOf(yearFormat.format(new Date(time)));

        System.out.println("静态代理类自动分配到【DB_" + dbRouter + "】数据源处理数据");

        DynamicDataSourceEntity.set(dbRouter);

        this.orderService.createOrder(order);
        DynamicDataSourceEntity.restore();

        return 0;
    }
}
