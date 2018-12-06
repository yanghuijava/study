package com.yanghui.study.dealLock;

public class DealLockTest {
	
	private static Object o1 = new Object();
	private static Object o2 = new Object();
	

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (o1){
					System.out.println(Thread.currentThread().getName() + "获取到o1的锁了！");
					try {
						Thread.sleep(1000 * 5);
						synchronized (o2){
							System.out.println(Thread.currentThread().getName() + "获取到o2的锁了！");
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (o2){
					System.out.println(Thread.currentThread().getName() + "获取到o2的锁了！");
					try {
						Thread.sleep(1000 * 5);
						synchronized (o1){
							System.out.println(Thread.currentThread().getName() + "获取到o1的锁了！");
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		t1.start();
		t2.start();
		t1.join();
		t2.join();
	}
}
