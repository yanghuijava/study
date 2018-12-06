package com.yanghui.study.curator;

import java.util.concurrent.TimeUnit;

import org.apache.curator.framework.recipes.locks.InterProcessMutex;

import lombok.Data;

@Data
public class Counter {
	
	private int count = 0;
	
	private String path = "/yanghui/Counter";
	public void add() {
		InterProcessMutex lock = ReentrantLock.getLock(path);
		try {
			lock.acquire();
			System.out.println(lock.isAcquiredInThisProcess());
			count ++;
			print();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				lock.release();
				System.out.println(lock.isAcquiredInThisProcess());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void print() {
		InterProcessMutex lock = ReentrantLock.getLock(path);
		try {
			boolean b = lock.acquire(10000,TimeUnit.MILLISECONDS);
			if(b) {
				System.out.println("---------------" + count);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(lock.isAcquiredInThisProcess())lock.release();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void reduce() {
		InterProcessMutex lock = ReentrantLock.getLock(path);
		try {
			lock.acquire();
			count --;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				lock.release();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
