package com.example.zhw.springsource.springdesign.proxy.dbroute;

/**
 * @author zhangwei
 * @date 2020/11/5 15:41
 */
public class OrderServiceImpl implements IOrderService {

    private OrderDao orderDao;

    public OrderServiceImpl() {
        orderDao = new OrderDao();
    }


    @Override
    public int createOrder(Order order) {

        System.out.println("OrderService调用orderDao创建订单");
        return orderDao.insert(order);
    }
}
