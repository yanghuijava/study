package com.yanghui.study.algorithm.list;

import lombok.Data;

@Data
public class Node<T extends Comparable<T>> {

	private T item;
	private Node<T> next;
	
	public Node(T item) {
		if(item == null) {
			throw new RuntimeException("不能储存null对象");
		}
		this.item = item;
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	
	@Override
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append(item.toString()).append("--->");
		Node<T> p = next;
		while(p != null) {
			result.append(p.item.toString()).append("--->");
			p = p.next;
		}
		result.append("null");
		return result.toString();
	}
}
