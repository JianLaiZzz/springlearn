package com.example.zhw.springsource.bio;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author: zhw
 * @createDate: 2020/5/31
 */
public class TimeServerHandlerExecutePool
{
	ExecutorService executorService;

	public TimeServerHandlerExecutePool(int maxsize, int queuesize)
	{
		executorService = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(), maxsize,
				120L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(queuesize));

	}

	public void execute(Runnable task)
	{
		executorService.execute(task);
	}

}
