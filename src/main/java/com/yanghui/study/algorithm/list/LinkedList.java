package com.yanghui.study.algorithm.list;


import lombok.Data;

@Data
public class LinkedList<T> {
	
	public static void main(String[] args) {
		System.out.println(null == null);
	}
	private Node1<T> head;
	private Node1<T> last;
	
	public void put(T item) {
		if(head == null) {
			head = new Node1<T>();
			head.item = item;
			last = head;
		}else if(head == last) {
			Node1<T> newNode = new Node1<T>();
			newNode.item = item;
			last.next = newNode;
			last = newNode;
			head.next = last;
		}else {
			Node1<T> newNode = new Node1<T>();
			newNode.item = item;
			last.next = newNode;
			last = newNode;
		}
	}
	
	public void printAll() {
		for(Node1<T> n = head;n != null;n=n.next) {
			System.out.print(n.item + " ");
		}
		System.out.println();
	}
}

@Data
class Node1<T>{
	T item;
	Node1<T> next;
}