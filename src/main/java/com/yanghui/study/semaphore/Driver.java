package com.yanghui.study.semaphore;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Driver {
	
	private Semaphore semaphore = new Semaphore(5);
	
	public void driveCar() {
		boolean acquired = false;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
        	acquired = semaphore.tryAcquire(1000, TimeUnit.MILLISECONDS);
            if(acquired) {
            	 System.out.println(Thread.currentThread().getName() + " start at " + sdf.format(new Date()));
                 Thread.sleep(2000);
                 System.out.println(Thread.currentThread().getName() + " stop at " + sdf.format(new Date()));
            }else {
            	System.err.println(Thread.currentThread().getName() + "------------too fast-----------" + sdf.format(new Date()));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
        	if(acquired) {
        		semaphore.release();
        	}
        }
    }
}
