package com.example.zhw.springsource.springdesign.proxy.dynamicproxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.example.zhw.springsource.springdesign.proxy.dbroute.db.DynamicDataSourceEntity;

/**
 * @author zhangwei
 * @date 2020/11/8 19:18
 **/
public class OrderServiceDynamicProxy implements InvocationHandler
{
	private Object target;

	private SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");

	public Object getInstance(Object target)
	{
		this.target = target;
		Class<?> classz = target.getClass();
		return Proxy.newProxyInstance(classz.getClassLoader(), classz.getInterfaces(), this);

	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
	{
		before(args[0]);
		Object o = method.invoke(this.target, args);
		after();
		return o;

	}

	//target 应该是订单对象Order
	public void before(Object target)
			throws NoSuchMethodException, InvocationTargetException, IllegalAccessException
	{
		System.out.println("Proxy before method");
		//约定优于配置
		Long time = (Long) target.getClass().getMethod("getCreateTime").invoke(target);
		Integer dbRouter = Integer.valueOf(yearFormat.format(new Date(time)));
		System.out.println("静态代理类自动分配到【DB_" + dbRouter + "】数据源处理数据");
		DynamicDataSourceEntity.set(dbRouter);
	}

	public void after()
	{

		System.out.println("Proxy after method");
		//还原成默认的数据源
		DynamicDataSourceEntity.restore();
	}
}
