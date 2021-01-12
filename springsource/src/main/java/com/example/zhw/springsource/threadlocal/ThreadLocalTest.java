package com.example.zhw.springsource.threadlocal;

/**
 * @author zhangwei
 * @date 2020/11/5 22:14
 **/
public class ThreadLocalTest
{
	private static ThreadLocal<String> threadLocal = new ThreadLocal<>();
	private static ThreadLocal<String> threadLocal2 = new ThreadLocal<>();

	public static void main(String[] args)
	{
		threadLocal.set("zhangsan");
		threadLocal2.set("lisi");

		System.out.println(threadLocal.get());

	}
}
