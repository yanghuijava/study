package com.yanghui.study.algorithm.stack;

import java.util.Arrays;

import lombok.Data;

@Data
public class ArrayStack<T> {
	
	private T[] items;
	private int count;
	
	public ArrayStack() {
		this(8);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayStack(int n) {
		if(n <= 0) {
			n = 8;
		}
		this.items = (T[])new Object[n];
	}
	
	public boolean push(T item) {
		if(count >= items.length) {
			return false;
		}
		items[count++] = item;
		return true;
	}
	
	public T pop() {
		if(count == 0) {
			return null;
		}
		int c = --count;
		T result = items[c];
		items[c] = null;
	    return result;
	}
	
	@Override
	public String toString() {
		return Arrays.toString(this.items);
	}
	
	public static void main(String[] args) {
		ArrayStack<String> stack = new ArrayStack<>(2);
		stack.push("a");
		stack.push("b");
		System.out.println(stack.push("c"));
		System.out.println(stack);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack);
		stack.push("v");
		System.out.println(stack);
	}
}
