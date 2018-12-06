package com.yanghui.study.algorithm.list;

import lombok.Data;

@Data
public class LRUCache<K,V> {
	
	public static void main(String[] args) {
		int capacity = 3;
		LRUCache<String,Integer> lru = new LRUCache<>(capacity);
		for(int i=0;i<capacity;i++) {
			lru.put("lru-" + i, i);
		}
		System.out.println(lru);
		
		lru.put("lru-4", 44);
		System.out.println(lru);
		
		lru.put(null, -1);
		System.out.println(lru);
		lru.put(null, -2);
		System.out.println(lru);
		
		lru.put("lru-8", 8);
		System.out.println(lru);
		
		System.out.println(lru.get("lru-5"));
		System.out.println(lru);
		
		lru.put(null, -1);
		System.out.println(lru);
		
		lru.put("lru-6", 66);
		System.out.println(lru);
		
		System.out.println(lru.length);
		
		System.out.println(lru.get("lru-8"));
		
		System.out.println(lru);
	}
	
	private Node head;
	private int capacity;
	private int length;
	
	public LRUCache() {
		this.capacity = 8;
	}
	
	public LRUCache(int capacity) {
		if(capacity <= 0) {
			capacity = 8;
		}
		this.capacity = capacity;
	}
	
	/**
	 * 根据key查找节点，支持key为null
	 * @param key
	 * @return
	 */
	private Node findNodeByKey(K key) {
		for(Node n=head;n!=null;n=n.next) {
			if(key == null) {
				if(n.key == key) {
					return n;
				}
			}else {
				if(key.equals(n.key)) {
					return n;
				}
			}
		}
		return null;
	}
	
	/**
	 * 删除最后一个节点
	 */
	private void deleteEndNode() {
		if(head == null) {
			return;
		}
		if(head.next == null) {
			length --;
			head = null;
		}
		Node endLastNode = null;
		for(Node n=head;n!=null;n=n.next) {
			if(n.next != null && n.next.next == null) {
				endLastNode = n;
				break;
			}
		}
		endLastNode.next = null;
		length --;
	}
	/**
	 * 删除指定节点
	 * @param n
	 */
	private void deleteByNode(Node node) {
		if(node == null) {
			return;
		}
		if(head == null) {
			return;
		}
		if(head.next == null) {
			if(head.key == null) {
				if(head.key == node.key) {
					head = null;
					length --;
				}
			}else {
				if(head.key.equals(node.key)) {
					head = null;
					length --;
				}
			}
			return;
		}
		if(head.key == null && head.key == node.key) {
			head = head.next;
			length --;
			return;
		}
		if(head.key != null && head.key.equals(node.key)) {
			head = head.next;
			length --;
			return;
		}
		Node last = null;
		for(Node n=head;n!=null;n=n.next) {
			if(n.next != null) {
				if(n.next.key == null) {
					if(n.next.key == node.key) {
						last = n;
						break;
					}
				}else {
					if(n.next.key.equals(node.key)) {
						last = n;
						break;
					}
				}
			}
		}
		if(last != null) {
			last.next = node.next;
			length --;
		}
	}
	
	private void putToHead(Node n) {
		if(n == null) {
			return;
		}
		n.next = head;
		head = n;
		length ++;
	}
	
	public void put(K key,V value) {
		Node findNode = findNodeByKey(key);
		if(findNode == null && length >= capacity) {
			deleteEndNode();
		}
		if(head == null) {
			head = new Node();
			head.key = key;
			head.value = value;
			length ++;
			return;
		}
		if(findNode == null) {
			Node newHead = new Node();
			newHead.key = key;
			newHead.value = value;
			putToHead(newHead);
		}else {
			Node newNode = new Node();
			newNode.key = findNode.key;
			newNode.value = value;
			deleteByNode(findNode);
			putToHead(newNode);
		}
	}
	
	public V get(K key) {
		if(head == null) {
			return null;
		}
		Node findNode = null;
		for(Node n=head;n!=null;n=n.next) {
			if(key == null) {
				if(n.key == key) {
					findNode = n;
					break;
				}
			}else {
				if(key.equals(n.key)) {
					findNode = n;
					break;
				}
			}
		}
		if(findNode == null) {
			return null;
		}
		Node newNode = new Node();
		newNode.key = findNode.key;
		newNode.value = findNode.value;
		deleteByNode(findNode);
		putToHead(newNode);
		return findNode.value;
	}
	
	@Override
	public String toString() {
		if(head == null) {
			return "";
		}
		StringBuffer result = new StringBuffer();
		for(Node n=head;n!=null;n=n.next) {
			result.append("key=").append(n.key).append(",value=").append(n.value).append("|");
		}
		result.deleteCharAt(result.length() - 1);
		return result.toString();
	}
	
	
	
	@Data
	class Node{
		K key;
		V value;
		Node next;
	}
}
