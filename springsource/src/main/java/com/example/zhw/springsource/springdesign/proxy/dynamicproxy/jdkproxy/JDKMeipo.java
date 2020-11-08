package com.example.zhw.springsource.springdesign.proxy.dynamicproxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zhangwei
 * @date 2020/11/8 18:57
 **/
public class JDKMeipo implements InvocationHandler
{

	private Object target;

	public Object getInstance(Object target)
	{
		this.target = target;
		Class<?> classz = target.getClass();
		return Proxy.newProxyInstance(classz.getClassLoader(), classz.getInterfaces(), this);

	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
	{
		before();

		Object o = method.invoke(this.target, args);
		after();

		return o;

	}

	public void before()
	{

		System.out.println("开始之前");
	}

	public void after()
	{

		System.out.println("开始之后");
	}

}
