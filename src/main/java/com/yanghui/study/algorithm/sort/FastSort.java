package com.yanghui.study.algorithm.sort;

public class FastSort extends AbstractSort {
	
	@Override
	protected void executeSort(int[] arr) {
		int[] result = doSort(arr);
		for(int i=0;i<result.length;i++) {
			arr[i] = result[i];
		}
	}
	
	private int[] doSort(int[] arr) {
		if(arr == null || arr.length < 2) {
			return arr;
		}
		int povit = arr[0];
		int lessNumber = 0;
		int greaterNumer = 0;
		for(int i=1;i<arr.length;i++) {
			if(arr[i] <= povit) {
				lessNumber ++;
			}
			if(arr[i] > povit) {
				greaterNumer ++;
			}
		}
		int[] less = new int[lessNumber];
		int[] greater = new int[greaterNumer];
		int lessIndex = 0;
		int greaterIndex = 0;
		for(int i=1;i<arr.length;i++) {
			if(arr[i] <= povit) {
				less[lessIndex++] = arr[i];
			}
			if(arr[i] > povit) {
				greater[greaterIndex++] = arr[i];
			}
		}
		return merge(doSort(less),povit,doSort(greater));
	}
	
	private int[] merge(int[] a1,int povit,int[] a2) {
		int[] result = new int[a1.length + 1 + a2.length];
		for(int i=0;i<a1.length;i++) {
			result[i] = a1[i];
		}
		result[a1.length] = povit;
		int j = a1.length + 1;
		for(int i=0;i<a2.length;i++) {
			result[j++] = a2[i];
		}
		return result;
	}
}
