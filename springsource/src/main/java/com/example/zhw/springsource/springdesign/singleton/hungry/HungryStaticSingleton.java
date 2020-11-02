package com.example.zhw.springsource.springdesign.singleton.hungry;

/**
 * @author zhangwei
 * @date 2020/10/28 21:22
 **/
public class HungryStaticSingleton
{

	private static HungryStaticSingleton hungrySingleton;

	static
	{
		hungrySingleton = new HungryStaticSingleton();
	}

	private HungryStaticSingleton()
	{
	}

	public static HungryStaticSingleton getHungrySingleton()
	{
		return hungrySingleton;
	}
}
