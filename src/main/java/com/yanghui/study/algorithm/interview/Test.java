package com.yanghui.study.algorithm.interview;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		int arr[] = new int[] {2,1,3,6,1,2,4,6,8,9,7,0,-1};
		fastSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void fastSort(int[] arr) {
		if(arr == null || arr.length == 0) {
			return;
		}
		fastSort(arr, 0, arr.length - 1);
	}
	
	
	public static void fastSort(int[] arr,int start,int end) {
		if(start >= end) {
			return;
		}
		int p = partation(arr,start,end);
		fastSort(arr, start, p - 1);
		fastSort(arr, p + 1, end);
	}


	private static int partation(int[] arr, int start, int end) {
		int p = arr[start];
		int i = start + 1;
		for(int j=i;j<=end;j++) {
			if(arr[j] < p) {
				if(i != j) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
				i ++;
			}
		}
		int temp = arr[start];
		arr[start] = arr[i-1];
		arr[i-1] = temp;
		return i-1;
	}
}
