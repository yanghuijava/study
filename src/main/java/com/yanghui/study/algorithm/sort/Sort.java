package com.yanghui.study.algorithm.sort;

import java.util.Arrays;
import java.util.Random;

public class Sort {
	
	public static void main(String[] args) {
//		Random r = new Random();
//		int n = 100;
//		int[] arr1 = new int[n];
//		for(int i=0;i<n;i++) {
//			arr1[i] = r.nextInt(n);
//		}
		int[] arr1 = new int[] {7,6,3,5,4,1,2,9,10,21,12,0,8,7};
		System.out.println(Arrays.toString(arr1));
		AbstractSort sort = new HeapSort();
		System.out.println("是否有序：" + sort.isSort(arr1));
		sort.sort(arr1);
		System.out.println("是否有序：" + sort.isSort(arr1));
		System.out.println(Arrays.toString(arr1));
	}
}
