package com.yanghui.study.algorithm.interview;

/**
 * 合并k个有序列表
 * @author think
 *
 */
public class MergerKList {
	
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n11 = new ListNode(4);
		ListNode n12 = new ListNode(5);
		n1.next = n11;
		n11.next = n12;
		
		ListNode n2 = new ListNode(1);
		ListNode n21 = new ListNode(3);
		ListNode n22 = new ListNode(4);
		n2.next = n21;
		n21.next = n22;
		
		ListNode n3 = new ListNode(2);
		ListNode n31 = new ListNode(6);
		n3.next = n31;
		
		ListNode node = new MergerKList().mergeKLists(new ListNode[] {n1,n2,n3});
		node.print();
	}
	
	public ListNode mergeKLists(ListNode[] lists) {
		if(lists.length == 1) {
			return lists[0];
		}
		ListNode node = mergeTwo(lists[0], lists[1]);
        for(int i=2;i<lists.length;i++) {
        	node = mergeTwo(node, lists[i]);
        }
        return node;
    }
	
	private ListNode mergeTwo(ListNode n1,ListNode n2) {
		ListNode i = n1;
		ListNode j = n2;
		ListNode head;
		if(i.val <= j.val) {
			head = i;
			i = i.next;
		}else {
			head = j;
			j = j.next;
		}
		ListNode node = head;
		while(i != null && j != null) {
			if(i.val <= j.val) {
				node.next = i;
				i = i.next;
			}else {
				node.next = j;
				j = j.next;
			}
			node = node.next;
		}
		if(i != null) {
			node.next = i;
		}
		if(j != null) {
			node.next = j;
		}
		return head;
	}
}
