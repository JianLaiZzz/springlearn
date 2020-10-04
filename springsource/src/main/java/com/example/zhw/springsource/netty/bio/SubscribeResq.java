package com.example.zhw.springsource.netty.bio;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhangwei1
 * @date 2020/6/5 15:03
 */
@Data
public class SubscribeResq implements Serializable
{
	private int subReqId;

	private int resqCode;

	private String desc;
}