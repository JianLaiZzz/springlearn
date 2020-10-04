package com.example.zhw.springshardingsphere.vo;

import lombok.Data;

/**
 * 订单配置表
 */
@Data
public class OrderConfigVo
{
	/**
	 * 编号
	 */
	private Integer id;

	/**
	 * 支付超时时间;单位：分钟
	 */
	private Integer payTimeout;
}