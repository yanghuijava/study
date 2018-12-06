package com.yanghui.study.algorithm.sort;
/**
 * 冒泡排序
 * @author think
 *
 */
public class BubblingSort extends AbstractSort{

	@Override
	protected void executeSort(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			boolean flag = false;
			for(int j=0;j<arr.length - i - 1;j++) {
				if(less(arr, j + 1, j)) {
					exch(arr,j + 1, j);
					flag = true;
				}
			}
			if(!flag) {
				break;
			}
		}
	}
}
