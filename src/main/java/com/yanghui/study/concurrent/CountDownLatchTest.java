package com.yanghui.study.concurrent;

import java.util.concurrent.CountDownLatch;

@sun.misc.Contended
public class CountDownLatchTest {
	@sun.misc.Contended
	static Object o1 = new Object();
	static Object o2 = new Object();
	
	public static void main(String[] args) throws InterruptedException {
		final CountDownLatch c = new CountDownLatch(2);
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				c.countDown();
				System.out.println("1");
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
			}
		}).start();
		c.await();
		System.out.println("3");
	}
}
