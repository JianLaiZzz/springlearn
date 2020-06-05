package com.example.zhw.springsource.netty.bio;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhangwei1
 * @date 2020/6/5 15:00
 */
@Data
public class SubscribeReq implements Serializable {
    private String userName;

    private int subReqId;

    private String productName;

    private String iphoneNumber;

    private String address;

}