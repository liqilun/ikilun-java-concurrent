package com.ikilun;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class CallableAndFutureTest {
	public static void main(String[] args) {
		FutureTask<Integer> future = new FutureTask<Integer>(new CallTest());
		new Thread(future).start();
		try {
			System.out.println(future.get());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	static class CallTest implements Callable<Integer>{
		@Override
		public Integer call() throws Exception {
			Thread.sleep(3000);//TODO处理业务
			return new Random().nextInt(100);
		}
	}
}
