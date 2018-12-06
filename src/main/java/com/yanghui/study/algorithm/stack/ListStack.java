package com.yanghui.study.algorithm.stack;

import lombok.Data;

@Data
public class ListStack<T> {
	
	public static void main(String[] args) {
		ListStack<String> stack = new ListStack<>(3);
		stack.push("A");
		stack.push("B");
		stack.push("C");
		System.out.println(stack.push("D"));
		System.out.println(stack);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack);
	}
	
	private Node head;
	private Node tail;
	private int capacity;
	private int count;
	
	public ListStack() {
		this(8);
	}
	
	public ListStack(int n) {
		if(n <= 0) {
			n = 8;
		}
		this.capacity = n;
	}
	
	
	public boolean push(T item) {
		if(count >= capacity) {
			return false;
		}
		Node newNode = new Node();
		newNode.item = item;
		count ++;
		if(head == null) {
			head = newNode;
			tail = newNode;
		}else if(head == tail) {
			head.next = newNode;
			tail = newNode;
		}else {
			tail.next = newNode;
			tail = newNode;
		}
		return true;
	}
	
	public T pop() {
		if(count <= 0) {
			return null;
		}
		count --;
		T result = tail.item;
		Node last = null;
		for(Node n=head;n!=null;n=n.next) {
			if(n.next != null && n.next == tail) {
				last = n;
				break;
			}
		}
		if(last != null) {
			last.next = null;
			tail = last;
		}else {
			head = null;
			tail = null;
		}
		return result;
	}
	
	
	
	
	@Override
	public String toString() {
		if(head == null) {
			return null;
		}
		StringBuffer result = new StringBuffer();
		for(Node n=head;n!=null;n=n.next) {
			result.append(n.item).append("|");
		}
		result.deleteCharAt(result.length() - 1);
		return result.toString();
	}
	
	@Data
	class Node{
		private T item;
		private Node next;
	}
}
