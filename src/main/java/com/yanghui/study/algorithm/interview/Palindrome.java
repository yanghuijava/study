package com.yanghui.study.algorithm.interview;

/**
 * 
 * @author think
 *
 */
public class Palindrome {

	public static void main(String[] args) {
		System.out.println(isPalindrome("noon"));
	}
	
	public static boolean isPalindrome(String s) {
		if(s == null || s.equals("")) {
			return false;
		}
		int start = 0;
		int end = s.length() - 1;
		while(start <= end) {
			if(s.charAt(start++) != s.charAt(end--)) {
				return false;
			}
		}
		return true;
	}
}
