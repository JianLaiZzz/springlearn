package com.example.zhw.springsource.springdesign.singleton.lazy;

/**
 * @author zhangwei
 * @date 2020/11/1 18:18
 **/
public class LazySimpleSingleton
{

	private LazySimpleSingleton()
	{
	};

	private static LazySimpleSingleton lazySimpleSingleton;

	public synchronized static LazySimpleSingleton getLazySimpleSingleton()
	{

		if (null == lazySimpleSingleton)
		{
			lazySimpleSingleton = new LazySimpleSingleton();
		}
		return lazySimpleSingleton;
	}
}
