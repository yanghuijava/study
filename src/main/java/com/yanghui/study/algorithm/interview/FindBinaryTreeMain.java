package com.yanghui.study.algorithm.interview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.yanghui.study.algorithm.tree.FindBinaryTree;

public class FindBinaryTreeMain {

	public static void main(String[] args) {
		FindBinaryTree<Integer,Integer> tree = new FindBinaryTree<>();
		tree.put(100, 100);
		tree.put(200, 200);
		tree.put(80, 80);
		tree.put(50, 50);
//		tree.put(70, 70);
		tree.put(90, 90);
//		tree.put(85, 85);
//		tree.put(95, 95);
//		tree.put(150, 150);
//		tree.put(300, 300);
		System.out.println(maxDepth(tree.getRoot()));
		System.out.println(maxDepth1(tree.getRoot()));
		System.out.println(minDepth(tree.getRoot()));
		System.out.println(minDepth1(tree.getRoot()));
	}
	
	/********************************************************************************************************
	 * 获取二叉树的最小深度
	 ********************************************************************************************************/
	/**
	 * 广度优先遍历
	 * @param root
	 * @return
	 */
	public static <K extends Comparable<K>,V> int minDepth(FindBinaryTree<K,V>.Node root){
		int minDepth = 0;
		if(root == null) {
			return minDepth;
		}
		Queue<FindBinaryTree<K,V>.Node> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			int levelCount = queue.size();
			boolean flag = false;
			for(int i=0;i<levelCount;i++) {
				FindBinaryTree<K,V>.Node node = queue.poll();
				if(node.getLeft() != null) {
					queue.add(node.getLeft());
				}
				if(node.getRight() != null) {
					queue.add(node.getRight());
				}
				if(node.getLeft() == null && node.getRight() == null) {
					flag = true;
					break;
				}
			}
			minDepth ++;
			if(flag) {
				break;
			}
		}
		return minDepth;
	}
	public static <K extends Comparable<K>,V> int minDepth1(FindBinaryTree<K,V>.Node root){
		if(root == null) {
			return 0;
		}
		if(root.getLeft() == null && root.getRight() == null) return 1;
		
		if(root.getLeft() == null)return minDepth1(root.getRight()) + 1;
		if(root.getRight() == null)return minDepth1(root.getLeft()) + 1;
		
		return 1 + Math.min(minDepth1(root.getLeft()), minDepth1(root.getRight()));
	}
	/********************************************************************************************************
	 * 获取二叉树的最大深度
	 ********************************************************************************************************/
	/**
	 * 
	 * @param root
	 * @return
	 */
	public static <K extends Comparable<K>,V> int maxDepth(FindBinaryTree<K,V>.Node root){
		int maxDepth = 0;
		if(root == null) {
			return maxDepth;
		}
		Queue<FindBinaryTree<K,V>.Node> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			int levelCount = queue.size();
			for(int i=0;i<levelCount;i++) {
				FindBinaryTree<K,V>.Node node = queue.poll();
				if(node.getLeft() != null) {
					queue.add(node.getLeft());
				}
				if(node.getRight() != null) {
					queue.add(node.getRight());
				}
			}
			maxDepth ++;
		}
		return maxDepth;
	}
	/**
	 * 分治法
	 * @param root
	 * @return
	 */
	public static <K extends Comparable<K>,V> int maxDepth1(FindBinaryTree<K,V>.Node root){
		if(root == null) {
			return 0;
		}
		if(root.getLeft() == null) return maxDepth1(root.getRight()) + 1;
		if(root.getRight() == null) return maxDepth1(root.getLeft()) + 1;
		return 1 + Math.max(maxDepth1(root.getLeft()), maxDepth1(root.getRight()));
	}
	
	/********************************************************************************************************
	 * 按层次遍历的节点值
	 ********************************************************************************************************/
	/** 
	 * 使用广度优先遍历
	 * @param root
	 * @return
	 */
	public static <K extends Comparable<K>,V> List<List<K>> levelOrder(FindBinaryTree<K,V>.Node root){
		List<List<K>> result = new ArrayList<>();
		if(null == root) {
			return result;
		}
		Queue<FindBinaryTree<K,V>.Node> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			int level = queue.size();
			List<K> items = new ArrayList<>();
			for(int i=0;i<level;i++) {
				FindBinaryTree<K,V>.Node node = queue.poll();
				items.add(node.getKey());
				if(node.getLeft() != null) {
					queue.add(node.getLeft());
				}
				if(node.getRight() != null) {
					queue.add(node.getRight());
				}
			}
			result.add(items);
		}
		return result;
	}
	
	/**
	 * 验证一棵树是不是二叉搜索树
	 * @param node
	 * @return
	 */
	public static <K extends Comparable<K>,V> boolean isFindBinaryTree(FindBinaryTree<K,V> tree) {
		if(tree == null) {
			return true;
		}
		List<K> list = new ArrayList<>();
		isFindBinaryTree(tree.getRoot(), list);
		for(int i=1;i<list.size();i++) {
			if(list.get(i - 1).compareTo(list.get(i)) > 0) {
				return false;
			}
		}
		return true;
	}
	private static <K extends Comparable<K>,V> void isFindBinaryTree(FindBinaryTree<K,V>.Node node,List<K> list) {
		if(null == node) {
			return;
		}
		isFindBinaryTree(node.getLeft(),list);
		list.add(node.getKey());
		isFindBinaryTree(node.getRight(),list);
	}
	/**
	 * 获取两个节点的公共祖先
	 * @param node
	 * @param k1
	 * @param k2
	 * @return
	 */
	public static <K extends Comparable<K>,V> K commonAncestor(FindBinaryTree<K, V> tree,K k1,K k2) {
		FindBinaryTree<K,V>.Node result =null;
		if(isFindBinaryTree(tree)) {
			result = doCommonAncestor2(tree.getRoot(), k1, k2);
		}else {
			result = doCommonAncestor(tree.getRoot(), k1, k2);
		}
		if(result == null) {
			return null;
		}
		return result.getKey();
	}
	
    private static <K extends Comparable<K>,V> FindBinaryTree<K,V>.Node doCommonAncestor(FindBinaryTree<K,V>.Node node,K k1,K k2) {
		if(node == null) {
			return null;
		}
		int com1 = k1.compareTo(node.getKey());
		int com2 = k2.compareTo(node.getKey());
		if(com1 == 0 || com2 == 0) {
			return node;
		}
		FindBinaryTree<K,V>.Node left = doCommonAncestor(node.getLeft(), k1, k2);
		FindBinaryTree<K,V>.Node right = doCommonAncestor(node.getRight(), k1, k2);
		if(left == null) {
			return right;
		}
		if(right == null) {
			return left;
		}
		return node;
	}
    
    
    private static <K extends Comparable<K>,V> FindBinaryTree<K,V>.Node doCommonAncestor2(FindBinaryTree<K,V>.Node node,K k1,K k2) {
		if(node == null) {
			return null;
		}
		int com1 = node.getKey().compareTo(k1);
		int com2 = node.getKey().compareTo(k2);
		if(com1 >= 0 && com2 <= 0) {
			return node;
		}
		if(com1 <= 0 && com2 >= 0) {
			return node;
		}
		if(com1 > 0 && com2 > 0) {
			return doCommonAncestor2(node.getLeft(), k1, k2);
		}
		return doCommonAncestor2(node.getRight(), k1, k2);
	}
}
