package com.example.zhw.springsource.springdesign.proxy.dbroute;

import lombok.Data;

/**
 * @author zhangwei
 * @date 2020/11/5 15:39
 */
@Data
public class Order {

    private Object orderInfo;
    /**
     * 订单创建时间进行按年分库
     */
    private Long createTime;

    private String id;
}
