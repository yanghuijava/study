package com.yanghui.study.algorithm.sort;

/**
 * 计数排序
 * @author think
 *
 */
public class CountSort extends AbstractSort {

	@Override
	protected void executeSort(int[] arr) {
		//找到数组的最大值
		int max = arr[0];
		for(int i=1;i<arr.length;i++) {
			if(max < arr[i]) {
				max = arr[i];
			}
		}
		//统计数组中每个元素的个数
		int[] c = new int[max+1];
		for(int i=0;i<arr.length;i++) {
			c[arr[i]] ++;
		}
		//累加
		for(int i=1;i<c.length;i++) {
			c[i] = c[i] + c[i-1];
		}
		//申请一个临时数组，存储排好序的数据
		int[] b = new int[arr.length];
		for(int i=arr.length - 1;i >= 0;i--) {
			b[c[arr[i]] - 1] = arr[i];
			c[arr[i]] = c[arr[i]] - 1;
		}
		//copy回原数组
		for(int i=0;i<b.length;i++) {
			arr[i] = b[i];
		}
	}
}
