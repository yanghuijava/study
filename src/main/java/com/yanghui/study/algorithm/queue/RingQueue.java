package com.yanghui.study.algorithm.queue;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;

import lombok.Data;

@Data
public class RingQueue<T> {
	
	public static void main(String[] args) throws InterruptedException {
		RingQueue<String> queue = new RingQueue<>();
		for(int i=0;i<8;i++) {
			queue.enqueue("" + i);
		}
		System.out.println(queue);
		CountDownLatch cl = new CountDownLatch(8);
		for(int i=0;i<8;i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					System.out.println(queue.dequeue());
					cl.countDown();
				}
			}).start();
		}
		cl.await();
		System.out.println(queue);
	}
	
	private T[] items;
	private int head;
	private int tail;
	private int capacity;
	
	public RingQueue() {
		this(8);
	}
	
	@SuppressWarnings("unchecked")
	public RingQueue(int capacity) {
		if(capacity <= 0) {
			capacity = 8;
		}
		this.capacity = capacity;
		this.items = (T[])new Object[capacity];
	}
	
	public boolean enqueue(T item) {
		if((tail + 1) % capacity == head) {//判断队列是否满了的条件
			return false;
		}
		items[tail] = item;
		tail = (tail + 1) % capacity;
		return true;
	}
	
	public T dequeue() {
		if(tail == head) {
			return null;
		}
		T result = items[head];
		items[head] = null;
		head = (head + 1) % capacity;
		return result;
	}
	
	@Override
	public String toString() {
		return Arrays.toString(this.items) + "---head=" + head + "---tail=" + tail;
	}
}
