package com.yanghui.study.algorithm.interview;

import java.util.Stack;

/**
 * 栈实现队列
 * @author think
 *
 */
public class StackQueue<T> {

	public static void main(String[] args) {
		StackQueue<String> queue = new StackQueue<>();
		queue.enqueue("a");
		queue.enqueue("b");
		queue.enqueue("c");
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		queue.enqueue("d");
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
	}
	
	private Stack<T> en = new Stack<>();
	private Stack<T> de = new Stack<>();
	
	public void enqueue(T item) {
		en.push(item);
	}
	
	public T dequeue() {
		if(de.size() <= 0) {
			while(en.size() > 0) {
				T t = en.pop();
				de.push(t);
			}
		}
		return de.pop();
	}
}
