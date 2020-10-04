package com.example.zhw.springshardingsphere.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 订单表
 */
@ApiModel(value = "com-example-zhw-springshardingsphere-vo-Orders")
@Data
public class Orders
{
	/**
	 * 订单编号
	 */
	@ApiModelProperty(value = "订单编号")
	private Long id;

	/**
	 * 用户编号
	 */
	@ApiModelProperty(value = "用户编号")
	private Integer userId;
}