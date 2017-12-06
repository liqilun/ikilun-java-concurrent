package com.ikilun;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLookTest {
	private static int num = 0;
	private static ExecutorService service = Executors.newFixedThreadPool(3);
	private static Lock lock = new ReentrantLock();
	public static void main(String[] args) {
		for(int i=0;i<10;i++){
			service.execute(new ClzNum());
		}
		System.out.println("结果"+num);
	}
	static class ClzNum implements Runnable{
		public ClzNum(){
			
		}
		@Override
		public void run() {
			lock.lock();
			num++;
			System.out.println(Thread.currentThread().getName()+"==="+num);
			lock.unlock();
		}
	}
}
