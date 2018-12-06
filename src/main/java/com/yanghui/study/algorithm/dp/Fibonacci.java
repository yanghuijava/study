package com.yanghui.study.algorithm.dp;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

	public static void main(String[] args) {
		System.out.println(fib(40));
		System.out.println(fib(null,40));
		System.out.println(fib1(40));
		System.out.println(fib2(40));
	}
	
	public static int fib2(int n) {
		if(n <= 1) {
			return 1;
		}
		int result = 0;
		int last = 1;
		int lastToNext = 1;
		for(int i=2;i<=n;i++) {
			result = last + lastToNext;
			lastToNext = last;
			last = result;
		}
		return result;
	}
	
	public static int fib1(int n) {
		if(n <= 1) {
			return 1;
		}
		int[] opt = new int[n+1];
		opt[0] = 1;
		opt[1] = 1;
		for(int i=2;i<opt.length;i++) {
			opt[i] = opt[i-1] + opt[i-2];
		}
		return opt[opt.length - 1];
	}
	
	public static int fib(int n) {
		if(n <= 1) {
			return 1;
		}
		return fib(n-1) + fib(n-2);
	}
	
	public static int fib(Map<Integer,Integer> map,int n) {
		if(n <= 1) {
			return 1;
		}
		if(map == null) {
			map = new HashMap<Integer, Integer>();
		}
		int n1,n2;
		if(map.get(n-1) != null) {
			n1 = map.get(n-1);
		}else {
			n1 = fib(map, n-1);
			map.put(n-1, n1);
		}
		if(map.get(n-2) != null) {
			n2 = map.get(n-2);
		}else {
			n2 = fib(map, n-2);
			map.put(n-2, n2);
		}
		return n1 + n2;
	}
}
