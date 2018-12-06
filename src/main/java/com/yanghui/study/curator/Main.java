package com.yanghui.study.curator;

import java.util.concurrent.CountDownLatch;

public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		final Counter c = new Counter();
		int count = 1;
		final CountDownLatch latch = new CountDownLatch(count);
		for(int i=0;i<count;i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					c.add();
					latch.countDown();
				}
			}).start();
		}
		latch.await();
		System.out.println(c);
	}
}
