package com.yanghui.study.algorithm.sort;

public class MergeSort extends AbstractSort {

	@Override
	protected void executeSort(int[] arr) {
		doSort(arr, 0, arr.length - 1);
	}
	
	private void doSort(int[] arr,int start,int end) {
		if(start >= end)return;
		int middle = (start + end)/2;
		doSort(arr, start, middle);
		doSort(arr, middle + 1, end);
		merge(arr, start, middle, end);
	}
	
	private void merge(int[] arr,int start,int middle,int end) {
		int[] temp = new int[end - start + 1];
		int i = start;
		int j = middle + 1;
		int k = 0;
		while(i <= middle && j <= end) {
			if(less(arr, i, j)) {
				temp[k ++] = arr[i ++];
			}else {
				temp[k ++] = arr[j ++];
			}
		}
		int p=i,q=middle;
		if(i <= middle) {
			p = i;
			q = middle;
		}
		if(j <= end) {
			p = j;
			q = end;
		}
		for(int n=p;n<=q;n++) {
			temp[k ++] = arr[n];
		}
		for(int n=0;n<temp.length;n++) {
			arr[start ++] = temp[n];
		}
	}
}
