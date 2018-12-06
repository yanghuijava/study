package com.yanghui.study.algorithm.interview;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 判断括号是否有效
 * @author think
 * 
 */
public class EffectiveBrackets {
	
	private Map<String, String> map = new HashMap<>();
	
	public EffectiveBrackets() {
		this.map.put("(", ")");
		this.map.put("{", "}");
		this.map.put("[", "]");
	}

	public static void main(String[] args) {
		System.out.println(new EffectiveBrackets().isValid("("));
	}
	
	public boolean isValid(String s) {
		if(s == null) {
			return false;
		}
		if(s.equals("")) {
			return true;
		}
		char[] arr = s.toCharArray();
		Stack<String> stack = new Stack<>();
		for(char c : arr) {
			String item = null;
			if(stack.size() != 0) {
				item = stack.peek();
			}
			if(item == null || !String.valueOf(c).equals(this.map.get(item))) {
				stack.push(String.valueOf(c));
			}else {
				stack.pop();
			}
		}
		System.out.println(stack);
		return stack.size() == 0 ? true : false;
	}
}
