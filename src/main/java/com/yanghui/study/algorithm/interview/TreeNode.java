package com.yanghui.study.algorithm.interview;

import java.util.ArrayList;
import java.util.List;

import com.yanghui.study.algorithm.tree.FindBinaryTree;

public class TreeNode {
	int val;
	 TreeNode left;
	 TreeNode right;
	 TreeNode(int x) { val = x; }
	 
	 public static void main(String[] args) {
//			TreeNode root = new TreeNode(5);
//			TreeNode rootLeft = new TreeNode(1);
//			TreeNode rootRight = new TreeNode(4);
//			root.left = rootLeft;
//			root.right = rootRight;
//			TreeNode rootRightR = new TreeNode(6);
//			TreeNode rootRightL = new TreeNode(3);
//			rootRight.right = rootRightR;
//			rootRight.left = rootRightL;
		 	TreeNode root = new TreeNode(1);
		 	root.left = new TreeNode(1);
			System.out.println(new Solution().isValidBST(root));
		}
}

class Solution {
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null) {
			return null;
		}
		int com1 = root.val > p.val ? 1 : (root.val == p.val ? 0 : -1);
		int com2 = root.val > q.val ? 1 : (root.val == q.val ? 0 : -1);
		if(com1 >= 0 && com2 <= 0) {
			return root;
		}
		if(com1 <= 0 && com2 >= 0) {
			return root;
		}
		if(com1 > 0 && com2 > 0) {
			return lowestCommonAncestor(root.left, p, q);
		}
		return lowestCommonAncestor(root.right, p, q);
    }
	
    public boolean isValidBST(TreeNode root) {
    	List<Integer> list = new ArrayList<>();
    	isFindBinaryTree(root, list);
    	for(int i=1;i<list.size();i++) {
    		if(list.get(i - 1) >= list.get(i)) {
				return false;
			}
    	}
    	System.out.println(list);
    	return true;
    }
    
    public void isFindBinaryTree(TreeNode root,List<Integer> list) {
    	if(root == null) {
    		return;
    	}
    	isFindBinaryTree(root.left, list);
    	list.add(root.val);
    	isFindBinaryTree(root.right, list);
    }
}
