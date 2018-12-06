package com.yanghui.study.algorithm.sort;

public abstract class AbstractSort {
	
	protected void exch(int[] a,int i,int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	protected boolean less(int[] a,int i,int j) {
		return a[i] < a[j] ? true : false;
	}
	
	protected boolean isSort(int[] a) {
		for(int i=1;i<a.length;i++) {
			if(a[i-1] > a[i]) {
				return false;
			}
		}
		return true;
	}

	public void sort(int[] arr) {
		if(arr == null || arr.length == 1) {
			return;
		}
		long start = System.currentTimeMillis();
		executeSort(arr);
		System.out.println("耗时：" + (System.currentTimeMillis() - start) + "ms");
	}
	
	protected abstract void executeSort(int[] arr);
}
