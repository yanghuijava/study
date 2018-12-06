package com.yanghui.study.algorithm.queue;

import java.util.Arrays;

import lombok.Data;

@Data
public class ArrayQueue<T> {
	
	public static void main(String[] args) {
		ArrayQueue<String> queue = new ArrayQueue<>(3);
		queue.enqueue("a");
		queue.enqueue("b");
		queue.enqueue("c");
		System.out.println(queue.enqueue("d"));
		System.out.println(queue);
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue);
		System.out.println(queue.enqueue("d"));
		System.out.println(queue);
	}
	
	private T[] items;
	private int head;
	private int tail;
	
	public ArrayQueue(){
		this(8);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayQueue(int capacity){
		if(capacity <= 0) {
			capacity = 8;
		}
		this.items = (T[])new Object[capacity];
	}
	/**
	 * 入队
	 * @return
	 */
	public boolean enqueue(T item) {
		if(tail == items.length) {
			if(head == 0) {
				return false;
			}
			for(int i=head;i<items.length;i++) {
				items[i-head] = items[i];
			}
			tail = tail - head;
			head = 0;
		}
		items[tail ++] = item;
		return true;
	}
	/**
	 * 出队
	 * @return
	 */
	public T dequeue() {
		if(head == tail) {
			return null;
		}
		T result = items[head];
		items[head] = null;
		++ head;
		return result;
	}
	
	@Override
	public String toString() {
		return Arrays.toString(this.items)  + "\nhead=" + head + "----tail=" + tail;
	}
}
