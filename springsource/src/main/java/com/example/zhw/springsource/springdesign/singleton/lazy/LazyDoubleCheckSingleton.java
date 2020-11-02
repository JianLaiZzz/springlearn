package com.example.zhw.springsource.springdesign.singleton.lazy;

/**
 * @author zhangwei
 * @date 2020/11/1 18:41
 **/
public class LazyDoubleCheckSingleton
{

	private volatile static LazyDoubleCheckSingleton lazyDoubleCheckSingleton;

	private LazyDoubleCheckSingleton()
	{
	}

	public static LazyDoubleCheckSingleton getInstance()
	{

		//        三、最外层为何要有if (instance == null)判断：
		//
		//        因为我们在分析二中，发现依旧存在着性能问题，也就是说，只要getInstance方法被调用，那么就会执行同步这个操作，于是我们加个判断，当instance没有被实例化的时候，也就是需要去实例化的时候才去同步。
		//	    
		if (lazyDoubleCheckSingleton == null)
		{
			synchronized (LazyDoubleCheckSingleton.class)
			{
				if (lazyDoubleCheckSingleton == null)
				{
					lazyDoubleCheckSingleton = new LazyDoubleCheckSingleton();
				}
			}
		}

		return lazyDoubleCheckSingleton;

	}

}
