package com.yanghui.study.algorithm.interview;

import java.util.PriorityQueue;

/**
 * 流式数据中的第K大元素
 * @author think
 *
 * @param <T>
 */
public class StreamingLastKth<T extends Comparable<T>> {
	
	private int k;
	private PriorityQueue<T> queue;
	
	public StreamingLastKth(int k) {
		this.k = k;
		queue = new PriorityQueue<>(this.k);
	}
	
	public T addAndGetLastKth(T[] a) {
		if(a == null) {
			return this.queue.peek();
		}
		for(T t : a) {
			add(t);
		}
		return this.queue.peek();
	}
	
	private void add(T item) {
		if(queue.size() < this.k) {
			this.queue.add(item);
		}else {
			T t = this.queue.peek();
			if(item.compareTo(t) > 0) {
				this.queue.remove(t);
				this.queue.add(item);
			}
		}
	}
	
	public static void main(String[] args) {
		StreamingLastKth<Integer> lk = new StreamingLastKth<>(3);
		System.out.println(lk.addAndGetLastKth(new Integer[] {-2,2,-9,0,10,18,17,12,90}));
		System.out.println(lk.addAndGetLastKth(new Integer[] {82,78,30}));
	}
}
