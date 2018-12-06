package com.yanghui.study.algorithm.dp;

public class Beibao {

	public static void main(String[] args) {
		int[] w = new int[] {1,3,8,10,12,15};
		System.out.println(beibao2(w, w.length - 1, 7));
	}
	
	public static int beibao2(int[] w,int i,int target) {
		if(i == 0) {
			if(w[i] >= target) {
				return w[i];
			}
			return 0;
		}
		int a = w[i] + beibao2(w, i-1, w[i] - target);
		int b = beibao2(w, i-1,target);
		if(a < target && b < target) {
			return 0;
		}else if(a > target && b > target) {
			return a < b ? a : b;
		}else if(a > target && b < target) {
			return a;
		}else if(a < target && b > target) {
			return b;
		}else {
			return a;
		}
	}
}
