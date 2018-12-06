package com.yanghui.study.algorithm.sort;

public class ShellSort extends AbstractSort {

	@Override
	protected void executeSort(int[] arr) {
		int len = arr.length;
		int h = 1;
		while(h < len / 3) {
			h = 3*h + 1;
		}
		while(h >= 1) {
			for(int i=h;i<len;i++) {
				for(int j=i;j-h >= 0;j = j-h) {
					if(less(arr, j, j-h)) {
						exch(arr, j, j-h);
					}
				}
			}
			h = h / 3;
		}
	}
}
