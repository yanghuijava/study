package com.yanghui.study.algorithm.find;

import java.util.Arrays;
/**
 * 在无序数组中查找第K大元素
 * 使用 时间复杂度是O(n)的方法来解：
 * n + n/2 + n/4 + ... + 1 = 2n -1
 * @author think
 *
 */
public class FindKth {

	public static void main(String[] args) {
		int[] arr = new int[] {1,2,3,4,5,6};
		System.out.println(Arrays.toString(arr));
		System.out.println(new FindKth().findKth(arr, 1));
	}
	
	
	public int findKth(int[] arr,int k) {
		int index = doFindKth(arr, 0, arr.length - 1, k);
		return arr[index];
	}
	
	private int doFindKth(int[] arr,int start,int end,int k) {
		int p = partition(arr, start, end);
		if(p + 1 == k) {
			return p;
		}else if(p + 1 < k) {
			return doFindKth(arr, p + 1, end, k);
		}else {
			return doFindKth(arr, start, p - 1, k);
		}
	}
	
	public int partition(int[] arr,int start,int end) {
		int pivot = arr[start];
		int i = start + 1;
		for(int j=start + 1;j<=end;j++) {
			if(arr[j] > pivot) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
			}
		}
		int temp = arr[start];
		arr[start] = arr[i-1];
		arr[i-1] = temp;
		return i - 1;
	}
}
