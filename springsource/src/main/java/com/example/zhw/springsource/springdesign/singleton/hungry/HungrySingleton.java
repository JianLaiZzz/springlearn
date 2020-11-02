package com.example.zhw.springsource.springdesign.singleton.hungry;

/**
 * @author zhangwei
 */
public class HungrySingleton
{

	private static HungrySingleton hungrySingleton = new HungrySingleton();

	private HungrySingleton()
	{
	}

	public static HungrySingleton getHungrySingleton()
	{
		return hungrySingleton;
	}
}
