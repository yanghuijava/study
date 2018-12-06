package com.yanghui.study.algorithm.queue;

import lombok.Data;

@Data
public class ListQueue<T> {
	
	public static void main(String[] args) {
		ListQueue<String> queue = new ListQueue<>();
		System.out.println("queue=" + queue);
		queue.enqueue("a");
		queue.enqueue("b");
		queue.enqueue("c");
		queue.enqueue("d");
		System.out.println("queue=" + queue);
		
		System.out.println(queue.dequeue());
		System.out.println("queue=" + queue);
		System.out.println(queue.dequeue());
		System.out.println("queue=" + queue);
		System.out.println(queue.dequeue());
		System.out.println("queue=" + queue);
		System.out.println(queue.dequeue());
		System.out.println("queue=" + queue);
		System.out.println(queue.dequeue());
		System.out.println("queue=" + queue);
	}
	
	private Node head;
	private Node tail;
	
	public void enqueue(T item) {
		Node newNode = new Node();
		newNode.item = item;
		if(head == null || tail == null) {
			head = newNode;
			tail = newNode;
			return;
		}
		if(head == tail) {
			head.next = newNode;
			tail = newNode;
			return;
		}
		tail.next = newNode;
		tail = newNode;
	}
	
	public T dequeue() {
		if(head == null) {
			return null;
		}
		T result = head.item;
		head = head.next;
		if(head == null) {
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
		return result.toString() + "------" + "head=" + head.item + "------tail=" + tail.item;
	}

	@Data
	class Node{
		T item;
		Node next;
	}
}
