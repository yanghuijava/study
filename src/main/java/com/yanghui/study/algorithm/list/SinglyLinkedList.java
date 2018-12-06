package com.yanghui.study.algorithm.list;

import lombok.Data;

@Data
public class SinglyLinkedList<T extends Comparable<T>> {
	
	public static void main(String[] args) {
		SinglyLinkedList<Integer> list1 = new SinglyLinkedList<>();
		list1.put(1);
		list1.put(3);
		list1.put(5);
		list1.put(7);
		list1.put(9);
		System.out.println(list1);
		list1.deleteBottomN(5);
		System.out.println(list1);
		
	}
	
	private Node head;
	
	/**
	 * 删除倒数第m个节点
	 * @param n
	 */
	public void deleteBottomN(int m) {
		int total = 0;
		for(Node n=head;n!=null;n=n.next) {
			total ++;
		}
		int j = total - m;
		if(j < 0) {
			return;
		}
		int i = 0;
		Node deleteNode = null;
		for(Node n=head;n!=null;n=n.next) {
			if(j == i++) {
				deleteNode = n;
				break;
			}
		}
		if(deleteNode == null) {
			return;
		}
		if(deleteNode == head) {
			head = head.next;
			return;
		}
		Node p = null;
		for(Node n=head;n!=null;n=n.next) {
			if(n.next != null && n.next == deleteNode) {
				p = n;
				break;
			}
		}
		if(p == null) {
			return;
		}
		p.next = deleteNode.next;
	}
	
	/**
	 * 获取中间节点
	 * @return
	 */
	public Node getMiddleNode() {
		if(head == null) {
			return null;
		}
		if(head.next == null) {
			return head;
		}
		int total = 0;
		for(Node n=head;n!=null;n=n.next) {
			total ++;
		}
		int middle = total / 2 + 1;
		int count = 0;
		for(Node n=head;n!=null;n=n.next) {
			count ++;
			if(count == middle) {
				return n;
			}
		}
		return null;
	}
	
	/**
	 * 检查链表是否有环
	 * @return
	 */
	public boolean isHaveRing() {
		if(head == null) {
			return false;
		}
		if(head.next == null) {
			return false;
		}
		for(Node n1=head;n1!=null;n1=n1.next) {
			for(Node n2=n1;n2!=null;n2=n2.next) {
				if(n1 == n2.next) {
					System.out.println("链表有环，节点为：" + n1.item + "--" + n2.item);
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * 创建首尾相连环
	 */
	public void makeRing() {
		if(this.head == null) {
			return;
		}
		if(this.head.next == null) {
			head.next = head;
			return;
		}
		Node endNode = null;
		for(Node n=head;n!=null;n=n.next) {
			if(n.next == null) {
				endNode = n;
				break;
			}
		}
		endNode.next = head;
	}
	/**
	 * 链表反转
	 */
	public void reverse() {
		Node newHead = null;
		for(Node n=head;n!=null;n=n.next) {
			if(newHead == null) {
				newHead = new Node();
				newHead.item = n.item;
			}else {
				Node newNode = new Node();
				newNode.item = n.item;
				newNode.next = newHead;
				newHead = newNode;
			}
		}
		head = newHead;
	}
	
	public void put(T item) {
		checkItem(item);
		if(head == null) {
			head = new Node();
			head.item = item;
		}else {
			Node last = null;
			Node n = head;
			while(n != null) {
				if(n.next == null) {
					last = n;
					break;
				}
				n = n.next;
			}
			Node newNode = new Node();
			newNode.item = item;
			last.next = newNode;
		}
	}
	
	private void checkItem(T item) {
		if(item == null) {
			throw new RuntimeException("不能储存null！");
		}
	}
	
	public void putToHead(T item) {
		checkItem(item);
		if(head == null) {
			head = new Node();
			head.item = item;
		}else {
			Node newHead = new Node();
			newHead.item = item;
			newHead.next = head;
			head = newHead;
		}
	}
	
	public void delete(T item) {
		if(item == null) {
			return;
		}
		if(head == null) {
			return;
		}
		if(head.next == null) {
			if(head.item.equals(item)) {
				head = null;
			}
			return;
		}
		if(head.item.equals(item)) {
			head = head.next;
			return;
		}
		Node last = null;
		Node current = null;
		for(Node n=head;n!=null;n=n.next) {
			if(n.next != null && n.next.item.equals(item)) {
				last = n;
			}
			if(n.item.equals(item)) {
				current = n;
				break;
			}
		}
		if(current == null) {
			return;
		}
		last.next = current.next;
	}
	
	public void putOrderly(T item) {
		checkItem(item);
		Node newNode = new Node();
		newNode.item = item;
		if(head == null) {
			head = newNode;
			return;
		}
		if(head.next == null) {
			if(head.item.compareTo(item) > 0) {
				newNode.next = head;
				head = newNode;
			}else {
				head.next = newNode;
			}
			return;
		}
		if(head.item.compareTo(item) >= 0) {
			newNode.next = head;
			head = newNode;
			return;
		}
		for(Node n=head;n!=null;n=n.next) {
			if(n.next == null) {
				if(n.item.compareTo(item) < 0) {
					n.next = newNode;
				}
			}else {
				if(n.item.compareTo(item) < 0 && n.next.item.compareTo(item) > 0) {
					newNode.next = n.next;
					n.next = newNode;
				}
			}
		}
	}
	
	
	
	
	public void sort() {
		if(this.head == null) {
			return;
		}
		for(Node n=head;n!=null;n=n.next) {
			Node minNode = n;
			for(Node m=n.next;m!=null;m=m.next) {
				if(minNode.item.compareTo(m.item) > 0) {
					minNode = m;
				}
			}
			if(n.item.compareTo(minNode.item) != 0) {
				T temp = n.item;
				n.item = minNode.item;
				minNode.item = temp;
			}
		}
	}
	
	public void merge(Node node) {
		Node endNode = null;
		if(head == null) {
			head = node;
			return;
		}
		for(Node n=head;n!=null;n=n.next) {
			if(n.next == null) {
				endNode = n;
				break;
			}
		}
		if(endNode != null) {
			endNode.next = node;
		}
	}
	
	@Override
	public String toString() {
		if(head == null) {
			return "";
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
		T item;
		Node next;
	}
}
