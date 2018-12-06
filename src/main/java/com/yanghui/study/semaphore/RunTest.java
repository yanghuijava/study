package com.yanghui.study.semaphore;

public class RunTest {

	public static void main(String[] args) throws InterruptedException {
		Driver driver = new Driver();
		for(int i=0;i<20;i++) {
			Car car = new Car(driver);
			new Thread(car).start();
			Thread.sleep(50);
		}
		Thread.sleep(Integer.MAX_VALUE);
	}
}
