package com.yanghui.study.algorithm.interview;

import java.util.Stack;

public class StackMain {
	
	public static void main(String[] args) {
		StackMain sm = new StackMain();
		sm.push(8);
		sm.push(9);
		sm.push(4);
		sm.push(3);
		sm.push(2);
		sm.push(1);
		sm.push(10);
		System.out.println("min=" + sm.min());
		System.out.println(sm.pop());
		System.out.println("min=" + sm.min());
		System.out.println(sm.pop());
		System.out.println("min=" + sm.min());
		System.out.println(sm.pop());
		System.out.println("min=" + sm.min());
	}
	
	private Stack<Integer> stack;
	private Stack<Integer> min;
	
	public StackMain() {
		this.stack = new Stack<>();
		this.min = new Stack<>();
	}
	
	public void push(Integer item) {
		this.stack.push(item);
		if(min.isEmpty()) {
			this.min.push(item);
		}else {
			Integer i = this.min.peek();
			if(i.intValue() < item.intValue()) {
				this.min.push(i);
			}else {
				this.min.push(item);
			}
		}
	}
	
	public Integer pop() {
		if(this.stack.isEmpty()) {
			return null;
		}
		Integer result = this.stack.pop();
		this.min.pop();
		return result;
	}
	
	public Integer min() {
		return this.min.peek();
	}
}
