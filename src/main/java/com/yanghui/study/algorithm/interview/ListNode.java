package com.yanghui.study.algorithm.interview;

import lombok.Data;
@Data
public class ListNode {
	
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
	
	public void print() {
		String s = "";
		for(ListNode n=this;n!=null;n=n.next) {
			s = s + n.val + "--->";
		}
		System.out.println(s);
	}
}
