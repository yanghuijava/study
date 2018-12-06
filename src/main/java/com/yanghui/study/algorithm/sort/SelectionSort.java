package com.yanghui.study.algorithm.sort;

public class SelectionSort extends AbstractSort {

	@Override
	protected void executeSort(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			int min = i;
			for(int j=i + 1;j<arr.length;j++) {
				if(less(arr, j, min)) {
					min = j;
				}
			}
			if(arr[i] != arr[min]) {
				exch(arr, i, min);
			}
		}
	}
}
