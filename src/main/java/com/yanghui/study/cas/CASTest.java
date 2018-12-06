package com.yanghui.study.cas;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;

import lombok.AllArgsConstructor;
import lombok.Data;

public class CASTest {
	
	@Data
	@AllArgsConstructor
	static class Count{
		private int count;
		
		public void add() {
			this.count++;
		}
	}
	
	private static Count c = new Count(0);
	
	public static void main(String[] args) {
//		AtomicLongFieldUpdater<String> lockFieldUpdater = AtomicLongFieldUpdater.newUpdater(String.class, "lock");
//		lockFieldUpdater.compareAndSet(obj, expect, update)
		int j = 1000;
		CountDownLatch latch = new CountDownLatch(j);
		for(int i=0;i<j;i++) {
			
		}
	}
}
