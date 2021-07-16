package com.example.zhw.springsource.pay;

/**
 * @Author ZhangWei
 * @Date 2021/7/16 14:16
 * @Version 1.0
 */
public interface IPay
{

	boolean support(String code);

	void pay();
}
