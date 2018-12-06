package com.yanghui.study.semaphore;

public class Car implements Runnable {
	
	private Driver driver;
	
	public Car(Driver driver) {
		this.driver = driver;
	}

	@Override
	public void run() {
		driver.driveCar();
	}
}
