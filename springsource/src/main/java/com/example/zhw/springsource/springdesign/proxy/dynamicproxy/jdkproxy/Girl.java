package com.example.zhw.springsource.springdesign.proxy.dynamicproxy.jdkproxy;

import com.example.zhw.springsource.springdesign.proxy.staticproxy.Person;

/**
 * @author zhangwei
 * @date 2020/11/8 20:00
 **/
public class Girl implements Person
{
	@Override
	public void findLove()
	{
		System.out.println("高富帅");
		System.out.println("身高180cm");
		System.out.println("有6块腹肌");

	}
}
