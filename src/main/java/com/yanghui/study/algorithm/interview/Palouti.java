package com.yanghui.study.algorithm.interview;

public class Palouti {
	
	public static void main(String[] args) {
		System.out.println(new Palouti().climbStairs(9));
	}
	
	public int climbStairs(int n) {
		if(n == 1) {
			return 1;
		}
		if(n == 2) {
			return 2;
		}
		int result = 0;
		int pre = 2;
		int preToPre = 1;
		for(int i=3;i<=n;i++) {
			result += pre + preToPre;
			preToPre = pre;
			pre = result;
		}
		return result;
	}
}
