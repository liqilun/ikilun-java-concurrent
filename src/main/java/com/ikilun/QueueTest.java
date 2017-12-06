package com.ikilun;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class QueueTest {
	public static void main(String[] args) {
		BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(5);
		for(int i=0;i<10;i++){
			//queue.add(i); 超出容量的大小会抛出异常
			queue.offer(i);
		}
		//返回队列头部的元素而不移除此元素
		System.out.println(queue.element());//无元素会抛出异常
		System.out.println(queue.peek());
	}
}
