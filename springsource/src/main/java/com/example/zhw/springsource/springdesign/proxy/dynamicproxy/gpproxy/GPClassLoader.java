package com.example.zhw.springsource.springdesign.proxy.dynamicproxy.gpproxy;

/**
 * @author zhangwei
 * @date 2020/11/9 21:33
 **/
public class GPClassLoader extends ClassLoader
{

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException
	{
		return super.findClass(name);
	}
}
