package com.example.zhw.springsource.springdesign.proxy.dynamicproxy.jdkproxy;

import com.example.zhw.springsource.springdesign.proxy.staticproxy.Person;

/**
 * @author zhangwei
 * @date 2020/11/8 19:06
 **/
public class Customer implements Person
{
	@Override
	public void findLove()
	{
		System.out.println("高富帅");
		System.out.println("身高180");
	}

	public static void main(String[] args)
	{

		Person o = (Person) new JDKMeipo().getInstance(new Customer());
		o.findLove();

	}
}
