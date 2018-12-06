package com.yanghui.study.algorithm.list;

import java.util.HashSet;
/**
 * 链表练习题
 * @author think
 *
 */
public class MainClass {
    
    public static void main(String[] args) {
//        Node<Integer> head1 = Solution.createListInt("[1,2,3,4,5,6,7,8,9]");
//        System.out.println(head1);
//        System.out.println(Solution.deleteLastKth(head1, 1));
    	Node<Integer> n1 = new Node<Integer>(1);
    	Node<Integer> n2 = new Node<Integer>(2);
    	Node<Integer> n3 = new Node<Integer>(3);
    	n1.setNext(n2);
    	n2.setNext(n3);
    	n3.setNext(n1);
    	System.out.println(Solution.hasCycle(n1));
    }
}

class Solution{
	
	
	public static Node<String> createListString(String input){
		Node<String> head = null;
		String str = input.substring(1, input.length() - 1);
		Node<String> tail = null; 
		for(String s : str.split(",")) {
			Node<String> node = new Node<String>(s);
			if(head == null) {
				head = node;
				tail = node;
			}else {
				tail.setNext(node);
				tail = node;
			}
		}
		return head;
	}
	
	public static Node<Integer> createListInt(String input){
		Node<Integer> head = null;
		String str = input.substring(1, input.length() - 1);
		Node<Integer> tail = null; 
		for(String s : str.split(",")) {
			Node<Integer> node = new Node<Integer>(Integer.valueOf(s));
			if(head == null) {
				head = node;
				tail = node;
			}else {
				tail.setNext(node);
				tail = node;
			}
		}
		return head;
	}
	
	/**
	 * 链表两两交换
	 * @param head
	 * @return
	 */
	public static <T extends Comparable<T>> Node<T> swapPairs(Node<T> head){
		if(head == null || head.getNext() == null) {
			return head;
		}
		Node<T> first = head;
		Node<T> second = head.getNext();
		Node<T> result = second;
		Node<T> pre = null;
		while(first != null && second != null) {
			Node<T> tempF = first.getNext().getNext();
			Node<T> tempS;
			if(second.getNext() == null) {
				tempS = null;
			}else {
				tempS = second.getNext().getNext();
			}
			if(pre != null) {
				pre.setNext(second);
			}
			first.setNext(first.getNext().getNext());
			second.setNext(first);
			pre = first;
			first = tempF;
			second = tempS;
		}
		return result;
	}
	/**
	 * 合并两个有序链表
	 * @param a
	 * @param b
	 * @return
	 */
	public static <T extends Comparable<T>> Node<T> merge(Node<T> a,Node<T> b){
		if(a == null)return b;
		if(b == null)return a;
		
		Node<T> p = a;
		Node<T> q = b;
		Node<T> head;
		if(p.getItem().compareTo(q.getItem()) > 0) {
			head = q;
			q = q.getNext();
		}else {
			head = p;
			p = p.getNext();
		}
		Node<T> node = head;
		while(p!=null && q!=null) {
			if(p.getItem().compareTo(q.getItem()) > 0) {
				node.setNext(q);
				q = q.getNext();
			}else {
				node.setNext(p);
				p = p.getNext();
			}
			node = node.getNext();
		}
		if(p != null) {
			node.setNext(p);
		}else {
			node.setNext(q);
		}
		return head;
	}
	
	/**
	 * 获取链表的中间节点
	 * @param node
	 * @return
	 */
	public static <T extends Comparable<T>> Node<T> findMiddleNode(Node<T> node){
		if(node == null) {
			return null;
		}
		if(node.getNext() == null) {
			return node;
		}
		Node<T> fast = node;
		Node<T> slow = node;
		while(fast.getNext() != null && fast.getNext().getNext() != null) {
			fast = fast.getNext().getNext();
			slow = slow.getNext();
		}
		return slow;
	}
	
	/**
	 * 删除第K个节点
	 * @param node
	 * @param k
	 * @return
	 */
	public static <T extends Comparable<T>> Node<T> deleteLastKth(Node<T> node,int k) {
		Node<T> pre = null;
		Node<T> fast = node;
		Node<T> slow = node;
		int i = 1;
		while(i < k && fast.getNext() != null) {
			fast = fast.getNext();
			++ i;
		}
		while(fast.getNext() != null) {
			fast = fast.getNext();
			pre = slow;
			slow = slow.getNext();
		}
		if(pre == null) {
			node = node.getNext();
		}else {
			pre.setNext(pre.getNext().getNext());
		}
		return node;
	}
	
	/**
	 * 链表是否有环
	 * @param head
	 * @return
	 */
	public static <T extends Comparable<T>> boolean hasCycle(Node<T> head) {
		if(head == null || head.getNext() == null) {
			return false;
		}
		Node<T> slow = head;
		Node<T> fast = head;
        while(fast != null && fast.getNext() != null) {
        	slow = slow.getNext();
        	fast = fast.getNext().getNext();
        	if(slow == fast) {
        		return true;
        	}
        }
        return false;
    }
	
	public static <T extends Comparable<T>> boolean hasCycle1(Node<T> head) {
		HashSet<Node<T>> set = new HashSet<>();
		for(Node<T> n=head;n!=null;n=n.getNext()) {
			if(set.contains(n)) {
				return true;
			}
			set.add(n);
		}
		return false;
	}
	/**
	 * 反转链表
	 * @param list
	 * @return
	 */
	public static <T extends Comparable<T>> Node<T> reverseList(Node<T> list) {
		Node<T> pre = null;
		Node<T> head = null;
		Node<T> cur = list;
		while(cur != null) {
			Node<T> next = cur.getNext();
			if(next == null) {
				head = cur;
			}
			cur.setNext(pre);
			pre = cur;
			cur = next;
		}
		return head;
    }
}