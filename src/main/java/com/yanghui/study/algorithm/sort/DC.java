package com.yanghui.study.algorithm.sort;

public class DC {

	public static void main(String[] args) {
//		return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
		int h = "yanghui".hashCode();
		System.out.println(h ^ (h >>> 16));
	}
	
	
	public static int sum(int[] arr) {
		if(arr == null || arr.length == 0) {
			return 0;
		}
		if(arr.length == 1) {
			return arr[0];
		}
		int[] a = new int[arr.length - 1];
		for(int i=1;i<arr.length;i++) {
			a[i-1] = arr[i];
		}
		return arr[0] + sum(a);
	}
}
