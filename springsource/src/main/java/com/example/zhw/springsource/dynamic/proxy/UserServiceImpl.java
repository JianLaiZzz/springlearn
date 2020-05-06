package com.example.zhw.springsource.dynamic.proxy;

/**
 * @author: zhw
 * @createDate: 2020/5/5
 */
public class UserServiceImpl implements UserService
{
	/**
	 * 目标方法
	 */
	@Override
	public void add()
	{
		System.out.println("--------------------add---------------");
	}
}
