package com.yanghui.study.memory;

public class MemoryTest {
	
	public static void main(String[] args) {
		try {
			byte[] byes = new byte[15 * 1024 * 1024];
			System.out.println("hello word!");
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						Thread.sleep(20 * 1000);
						System.out.println(Thread.currentThread().getName());
						byte[] byes = new byte[30 * 1024 * 1024];
					} catch (Throwable e) {
						e.printStackTrace();
					}
				}
			}).start();
			Thread.sleep(Integer.MAX_VALUE);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
