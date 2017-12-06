package com.ikilun;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CountDownLatchTest {
	private static int num = 0;
	private static ExecutorService service = Executors.newFixedThreadPool(3);
	private static Lock lock = new ReentrantLock();
	private static CountDownLatch latch = new CountDownLatch(10);
	public static void main(String[] args) {
		for(int i=0;i<10;i++){
			service.execute(new ClzNum2());
		}
		try {
			System.out.println("等待子线程执行完毕...");
			latch.await();
			System.out.println("子线程执行完毕...");
			System.out.println("继续执行主线程");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("结果"+num);
	}
	static class ClzNum2 implements Runnable{
		public ClzNum2(){
			
		}
		@Override
		public void run() {
			lock.lock();
			num++;
			System.out.println(Thread.currentThread().getName()+"==="+num);
			lock.unlock();
			latch.countDown();
		}
	}
}
