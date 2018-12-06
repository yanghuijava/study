package com.yanghui.study.algorithm.sort;

import java.util.Arrays;

public class FastSort2 extends AbstractSort {
	
	@Override
	protected void executeSort(int[] arr) {
		doSort(arr, 0, arr.length - 1);
	}
	
	private void doSort(int[] arr,int start,int end) {
		if(start >= end)return;
		int p = partition(arr, start, end);
		doSort(arr, start, p - 1);
		doSort(arr, p + 1, end);
	}
	
	private int partition(int[] arr,int start,int end) {
		int pivot = arr[start];
		int i = start + 1;
		for(int j=start + 1;j<=end;j++) {
			if(arr[j] < pivot) {
				if(i!=j)exch(arr, i, j);
				i ++;
			}
		}
		exch(arr, start, i - 1);
		return i - 1;
	}
	
	//[8, 1, 5, 0, 0, 8, 3, 8, 8, 5]
	//[3, 1, 5, 0, 0, 5, 8, 8, 8, 8]
	//[0, 1, 0, 3, 5, 5, 8, 8, 8, 8]
	//[0, 1, 0, 3, 5, 5, 8, 8, 8, 8]
	public static void main(String[] args) {
		int[] arr = new int[] {0, 1, 0, 3, 5, 5, 8, 8, 8, 8};
		int i = new FastSort2().partition2(arr, 1, 2);
		System.out.println(i);
		System.out.println(Arrays.toString(arr));
	}
	
	private int partition2(int[] arr,int start,int end) {
		int pivot = arr[start];
		int i = start + 1;
		int j = end;
		while(true) {
			while(arr[i] < pivot) {
				if(i>=end)break;
				i++;
			}
			while(arr[j] > pivot) {
				if(j<=start+1) break;
				j--;
			}
			if(i>=j)break;
			exch(arr, i, j);
		}
		exch(arr, start, i);
		return i;
	}
}
