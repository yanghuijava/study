package com.yanghui.study.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class NonReentrantLock implements Lock{
	
	private final Sync sync = new Sync();
	
	@Override
	public void lock() {
		sync.acquire(0);
	}

	@Override
	public void lockInterruptibly() throws InterruptedException {
		sync.acquireInterruptibly(1);
	}

	@Override
	public boolean tryLock() {
		return sync.tryAcquire(1);
	}

	@Override
	public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
		return sync.tryAcquireNanos(1, unit.toNanos(time));
	}

	@Override
	public void unlock() {
		sync.release(1);
	}

	@Override
	public Condition newCondition() {
		return sync.newCondition();
	}
	
	private static class Sync extends AbstractQueuedSynchronizer{

		private static final long serialVersionUID = 1L;

		@Override
		protected boolean tryAcquire(int arg) {
			assert arg == 1;
			if(compareAndSetState(0, 1)) {
				setExclusiveOwnerThread(Thread.currentThread());
				return true;
			}
			return false;
		}

		@Override
		protected boolean tryRelease(int arg) {
			assert arg == 1;
			if(getState() == 0) {
				throw new IllegalMonitorStateException();
			}
			setExclusiveOwnerThread(null);
			setState(0);
			return true;
		}

		@Override
		protected boolean isHeldExclusively() {
			return this.getState() == 1;
		}
		
		Condition newCondition() {
			return new ConditionObject();
		}
	}
	
	private static int i = 0;
	public static void main(String[] args) throws InterruptedException {
		NonReentrantLock lock = new NonReentrantLock();
		int c = 200;
		CountDownLatch cl = new CountDownLatch(c);
		for(int j=0;j<c;j++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						lock.lock();
						i++;
					}finally {
						lock.unlock();
						cl.countDown();
					}
				}
			}).start();;
		}
		cl.await();
		System.out.println(i);
	}
}
