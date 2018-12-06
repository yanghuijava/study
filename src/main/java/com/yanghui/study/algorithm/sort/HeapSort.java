package com.yanghui.study.algorithm.sort;

/**
 * 堆排序
 * @author think
 *
 */
public class HeapSort extends AbstractSort {

	@Override
	protected void executeSort(int[] arr) {
		for(int i=arr.length - 1;i > 0;i--) {
			buildHeap(arr, i);
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
		}
	}
	
	private void buildHeap(int[] arr,int n) {
		for(int j=n;j > 0;j --) {
			for(int m=j;m > 0;m = (m-1)/2) {
				if(arr[m] > arr[(m-1)/2]) {
					int temp = arr[m];
					arr[m] = arr[(m-1) / 2];
					arr[(m-1) / 2] = temp;
				}
			}
		}
	}
}
