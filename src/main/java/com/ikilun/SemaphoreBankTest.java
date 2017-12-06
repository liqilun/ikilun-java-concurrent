package com.ikilun;

import java.util.concurrent.Semaphore;

//5个人同时去银行办理业务，但银行只有2个业务员，最开始，2个人同时办理，然后，任何一个业务办理完毕，马上办理下一个
public class SemaphoreBankTest {
	private static Semaphore semaphore = new Semaphore(2);
	private static int peopleNum = 5;
	public static void main(String[] args) {
		for(int i=1;i<=peopleNum;i++){
			new BankService(semaphore, i).start();
		}
	}
}
class BankService extends Thread{
	private Semaphore semaphore;
	private Integer num;
	
	public BankService(Semaphore semaphore, Integer num) {
		this.semaphore = semaphore;
		this.num = num;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Semaphore getSemaphore() {
		return semaphore;
	}

	public void setSemaphore(Semaphore semaphore) {
		this.semaphore = semaphore;
	}

	@Override
	public void run() {
		System.out.println("第"+num+"个用户等待叫号");
		try {
			semaphore.acquire();
			System.out.println("第"+num+"个用户正在处理业务");
			System.out.println("还剩服务员："+semaphore.availablePermits()+"位");
			Thread.sleep(10000);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			semaphore.release();
		}
		System.out.println("第"+num+"个用户处理完成");
		System.out.println("=======================");
	}
	
}