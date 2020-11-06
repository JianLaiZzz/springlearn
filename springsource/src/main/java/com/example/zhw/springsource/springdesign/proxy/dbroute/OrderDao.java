package com.example.zhw.springsource.springdesign.proxy.dbroute;

/**
 * @author zhangwei
 * @date 2020/11/5 15:41
 */
public class OrderDao {

    public int insert(Order order) {
        System.out.println("OrderDao创建Order成功!");
        return 1;
    }
}
