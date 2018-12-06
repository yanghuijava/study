package com.yanghui.study.thread;

import java.util.concurrent.locks.LockSupport;

public class ThreadLocalTest {
	
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("child thread begin park");
				LockSupport.park();
				System.out.println("child thread end park");
			}
		});
		t1.start();
		Thread.sleep(1000);
		System.out.println("mian thread begin unpark");
		LockSupport.unpark(t1);
	}
}
