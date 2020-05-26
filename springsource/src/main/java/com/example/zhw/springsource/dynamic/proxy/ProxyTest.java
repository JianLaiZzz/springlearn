package com.example.zhw.springsource.dynamic.proxy;

import org.junit.Test;

/**
 * @author: zhw
 * @createDate: 2020/5/5
 */
public class ProxyTest
{

	@Test
	public void testProxy()
	{
		UserService userService = new UserServiceImpl();

		MyInvocationHandler invocationHandler = new MyInvocationHandler(userService);

		UserService proxy = (UserService) invocationHandler.getProxyObject();

		proxy.add();
	}

	@Test
	public void testGenerateProxyClass()
	{
		ProxyGeneratorUtils.writeProxyClassToHardDisk("F:/$Proxy11.class");
	}

}
