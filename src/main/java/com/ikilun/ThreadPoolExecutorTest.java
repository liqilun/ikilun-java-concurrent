package com.ikilun;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorTest {
	private static BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<Runnable>(5);
	private static ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 10, 0, TimeUnit.SECONDS, workQueue);
	public static void main(String[] args) {
		executor.allowCoreThreadTimeOut(false);
		executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
		executor.execute(new Runnable() {
			@Override
			public void run() {
				
			}
		});
	}
}
