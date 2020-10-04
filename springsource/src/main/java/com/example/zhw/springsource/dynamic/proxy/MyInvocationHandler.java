package com.example.zhw.springsource.dynamic.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: zhw
 * @createDate: 2020/5/5
 */
public class MyInvocationHandler implements InvocationHandler
{
	// 目标对象
	private Object target;

	/**
	 * 构造方法
	 * 
	 * @param target
	 *            目标对象
	 */
	public MyInvocationHandler(Object target)
	{
		super();
		this.target = target;
	}

	public Object getTarget()
	{
		return target;
	}

	public void setTarget(Object target)
	{
		this.target = target;
	}

	@Override
	public Object invoke(Object o, Method method, Object[] objects) throws Throwable
	{
		// 在目标对象的方法执行之前简单的打印一下
		System.out.println("------------------before------------------");

		UserService proxyUserService = (UserService) o;

		// 执行目标对象的方法
		Object result = method.invoke(target, objects);

		// 在目标对象的方法执行之后简单的打印一下
		System.out.println("-------------------after------------------");

		return result;
	}

	/**
	 * 获取目标对象的代理对象
	 * 
	 * @return 代理对象
	 */
	public Object getProxyObject()
	{
		return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
				target.getClass().getInterfaces(), this);
	}

}
