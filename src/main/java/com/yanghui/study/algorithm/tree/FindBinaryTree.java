package com.yanghui.study.algorithm.tree;

import java.util.LinkedList;
import java.util.Queue;

import lombok.Data;
@Data
public class FindBinaryTree<K extends Comparable<K>,V> {
	
	public static void main(String[] args) {
		FindBinaryTree<Integer,Integer> tree = new FindBinaryTree<>();
		tree.put(100, 100);
		tree.put(200, 200);
		tree.put(80, 80);
		tree.put(50, 50);
		tree.put(70, 70);
		tree.put(90, 90);
		tree.put(85, 85);
		tree.put(95, 95);
		tree.put(300, 300);
		tree.put(190, 190); 
		System.out.println(tree.getHigh());
//		FindBinaryTree<String,String> tree = new FindBinaryTree<>();
//		tree.put("E", "E");
//		tree.put("D", "D");
//		tree.put("A", "A");
//		tree.put("Q", "Q");
//		tree.put("J", "J");
//		tree.put("M", "M");
//		tree.put("T", "T");
//		tree.put("S", "S");
//		tree.printMiddle();
//		System.out.println(tree.floor("Q"));
//		System.out.println(tree.select(5));
//		System.out.println(tree.rank("J"));
//		System.out.println(tree.keys("D", "T"));
	}
	
	private Node root;
	
	public int size() {
		return size(this.root);
	}
	private int size(Node n) {
		if(null == n) {
			return 0;
		}
		return n.n;
	}
	
	public V get(K key) {
		return get(this.root, key);
	}
	
	public V get(Node n,K key) {
		if(null == n || key == null) {
			return null;
		}
		int com = key.compareTo(n.key);
		if(com > 0) {
			return get(n.right, key);
		}else if(com < 0) {
			return get(n.left, key);
		}else {
			return n.value;
		}
	}
	
	public void put(K key,V value) {
		if(null == key) {
			throw new RuntimeException("键值不能为空");
		}
		this.root = put(this.root,key,value);
	}
	
	private Node put(Node n,K key,V value) {
		if(null == n) {
			return new Node(key,value,1);
		}
		int com = key.compareTo(n.key);
		if(com > 0) {
			n.right = put(n.right, key, value);
		}else if(com < 0) {
			n.left = put(n.left, key, value);
		}else {
			n.value = value;
		}
		n.n = size(n.left) + size(n.right) + 1;
		return n;
	}
	
	public K min() {
		return min(this.root).key;
	}
	
	public Node min(Node n) {
		if(null == n.left) {
			return n;
		}
		return min(n.left);	
	}
	
	public K max() {
		return max(this.root).key;
	}
	
	public Node max(Node n) {
		if(null == n.right) {
			return n;
		}
		return max(n.right);
	}
	
	/**
	 * 查找小于等于key的键值
	 * @param key
	 * @return
	 */
	public K floor(K key) {
		Node node = this.floor(this.root, key);
		if(node == null) {
			return null;
		}
		return node.key;
	}
	
	private Node floor(Node n,K key) {
		if(n == null) {
			return null;
		}
		int com = key.compareTo(n.key);
		if(com == 0) {
			return n;
		}
		if(com < 0) {
			return floor(n.left, key); 
		}
		Node node = floor(n.right,key);
		if(node != null) {
			return node;
		}
		return n;
	}
	
	/**
	 * 查询排名第k的元素
	 * @param k
	 * @return
	 */
	public K select(int k) {
		Node n = select(this.root,k-1);
		if(n == null) {
			return null;
		}
		return n.key;
	}
	private Node select(Node x,int k) {
		if(null == x) {
			return null;
		}
		int t = size(x.left);
		if(t > k) {
			return select(x.left, k);
		}else if(t < k) {
			return select(x.right, k - t -1);
		}
		return x;
	}
	/**
	 * 查key的排名
	 * @param key
	 * @return
	 */
	public int rank(K key) {
		return rank(this.root, key);
	}
	private int rank(Node x,K key) {
		if(null == x)return 0;
		int com = key.compareTo(x.key);
		if(com > 0) {
			return rank(x.right, key) + size(x.left) + 1;
		}else if(com < 0) {
			return rank(x.left,key);
		}else {
			return size(x.left) + 1;
		}
	}
	
	/**
	 * 删除最小元素
	 */
	public void deleteMin() {
		root = deleteMin(this.root);
	}
	private Node deleteMin(Node x) {
		if(null == x.left) {
			return x.right;
		}
		x.left = deleteMin(x.left);
		x.n = size(x.left) + size(x.right) + 1;
		return x;
	}
	
	public void deleteMax() {
		root = deleteMax(this.root);
	}
	private Node deleteMax(Node x) {
		if(null == x.right) {
			return x.left;
		}
		x.right = deleteMax(x.right);
		x.n = size(x.left) + size(x.right) + 1;
		return x;
	}
	
	public void delete(K key) {
		root = delete(this.root, key);
	}
	public Node delete(Node x,K key) {
		if(null == x) {
			return null;
		}
		int com = key.compareTo(x.key);
		if(com > 0) {
			x.right = delete(x.right,key);
		}else if(com < 0) {
			x.left = delete(x.left,key);
		}else {
			Node t = x;
			x = min(t.right);
			x.right = deleteMin(t.right);
			x.left = t.left;
		}
		x.n = size(x.left) + size(x.right) + 1;
		return x;
	}
	
	public Iterable<K> keys(){
		return keys(min(),max());
	}
	public Iterable<K> keys(K lo,K hi){
		Queue<K> queue = new LinkedList<>();
		keys(queue, this.root, lo, hi);
		return queue;
	}
	private void keys(Queue<K> queue,Node x,K lo,K hi) {
		if(null == x)return;
		int comlo = lo.compareTo(x.key);
		int comhi = hi.compareTo(x.key);
		if(comlo < 0) {
			keys(queue, x.left, lo, hi);
		}
		if(comlo <= 0 && comhi >= 0) {
			queue.add(x.key);
		}
		if(comhi > 0) {
			keys(queue, x.right, lo, hi);
		}
	}
	
	/**
	 * 中序遍历
	 */
	public void printMiddle() {
		printMiddle(this.root);
	}
	private void printMiddle(Node x) {
		if(null == x)return;
		printMiddle(x.left);
		System.out.println(x.key);
		printMiddle(x.right);
	}
	
	/**
	 * 前序遍历
	 */
	public void printPre() {
		printPre(root);
	}
	public void printPre(Node x) {
		if(x == null)return;
		System.out.println(x.key);
		printPre(x.left);
		printPre(x.right);
	}
	/**
	 * 后序遍历
	 */
	public void printLast() {
		printLast(root);
	}
	public void printLast(Node x) {
		if(x == null) {
			return;
		}
		printLast(x.left);
		printLast(x.right);
		System.out.println(x.key);
	}
	
	public int getHigh() {
		return getHigt(root);
	}
	
	private int getHigt(Node node) {
		if(null == node)return 0;
		if(node.left == null)return 1 + getHigt(node.right);
		if(node.right == null) return 1 + getHigt(node.left);
		return 1 + Math.max(getHigt(node.right), getHigt(node.left));
	}
	
	public int getTotal() {
		return this.root.getN();
	}
	
	@Data
	public class Node{
		private K key;
		private V value;
		private Node left;
		private Node right;
		private int n;
		public Node(K key, V value,int n) {
			this.key = key;
			this.value = value;
			this.n = n;
		}
	}
}
