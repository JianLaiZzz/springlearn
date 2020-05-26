package com.example.zhw.springsource.cas;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: zhw
 * @createDate: 2020/5/13
 */
public class VolatileTest
{
	public static volatile int race = 0;

	private static final int THREADS_COUNT = 20;

	public static CountDownLatch countDownLatch = new CountDownLatch(THREADS_COUNT);

	public static AtomicInteger atomicInteger = new AtomicInteger(0);

	//	//一种方式
	//	public static synchronized void increase()
	//	{
	//		race++;
	//	}

	//一种方式
	public static void increase()
	{
		atomicInteger.getAndIncrement();
	}

	public static void main(String args[]) throws InterruptedException
	{
		Thread[] threads = new Thread[THREADS_COUNT];
		for (int i = 0; i < THREADS_COUNT; i++)
		{
			threads[i] = new Thread(new Runnable()
			{
				@Override
				public void run()
				{

					for (int i = 0; i < 10000; i++)
					{
						increase();
					}
					countDownLatch.countDown();
				}
			});
			threads[i].start();
		}

		countDownLatch.await();
		System.out.println(atomicInteger);

	}

}
