package com.yanghui.study.algorithm.interview;

public class Pow {
	
	public static void main(String[] args) {
		System.out.println(pow(2, 32));
	}
	
	public static double pow(double x,int n) {
		if(n < 0)return 1 / doPow(x, -n);
		return doPow(x, n);
	}
	
	private static double doPow(double x,int n) {
		if(n == 0) {
			return 1;
		}
		double half = doPow(x,n/2);
		if(n % 2 == 0) {
			return half * half;
		}
		return half * half * x;
	}
}
