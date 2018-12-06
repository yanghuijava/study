package com.yanghui.study.algorithm.sort;

public class InsertSort extends AbstractSort {

	@Override
	protected void executeSort(int[] arr) {
		for(int i=1;i<arr.length;i++) {
			for(int j=i;j>0;j--) {
				if(less(arr, j, j - 1)) {
					exch(arr, j, j - 1);
				}else {
					break;
				}
			}
		}
	}
}
