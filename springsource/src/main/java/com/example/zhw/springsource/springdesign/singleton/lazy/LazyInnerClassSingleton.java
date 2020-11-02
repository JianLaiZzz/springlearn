package com.example.zhw.springsource.springdesign.singleton.lazy;

/**
 * @author zhangwei
 * @date 2020/11/1 19:07
 **/
public class LazyInnerClassSingleton
{

	private LazyInnerClassSingleton()
	{
		if (LazyHolder.LAZY_INNER_CLASS_SINGLETON != null)
		{
			throw new RuntimeException("不允许创建多个实例");
		}
	}

	public static final LazyInnerClassSingleton getInstance()
	{
		//在返回结果以前，一定会先加载内部类
		return LazyHolder.LAZY_INNER_CLASS_SINGLETON;
	}

	//默认不加载
	private static class LazyHolder
	{
		private static final LazyInnerClassSingleton LAZY_INNER_CLASS_SINGLETON = new LazyInnerClassSingleton();
	}
}
