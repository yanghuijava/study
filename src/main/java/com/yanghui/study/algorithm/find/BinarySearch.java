package com.yanghui.study.algorithm.find;

import lombok.Data;

/**
 * 二分查找法
 * @author think
 *
 */
public class BinarySearch {

	public static void main(String[] args) {
//		int[] arr = new int[] {0,8,8,8,8,8,8,8,8,9,9,9,9,10};
		int[] arr = new int[] {1,3,5,7,9,11};
//		System.out.println(binarySearchForFirst(arr, 8));
//		System.out.println(binarySearchForEnd(arr, 8));
//		System.out.println(binarySearchForFirstDD(arr, 4));
		System.out.println(binarySearchForEndXD(arr, 8));
	}
	
	/**
	 * 查找最后一个值小于等于给定值的元素
	 * @param arr
	 * @param item
	 * @return
	 */
	public static int binarySearchForEndXD(int[] arr,int item) {
		int start=0;
		int end = arr.length - 1;
		while(start <= end) {
			int middle = (start + end) / 2;
			if(arr[middle] > item) {
				end = middle - 1;
			}else {
				if(end == middle || arr[middle + 1] > item) {
					return middle;
				}else {
					start = middle + 1;
				}
			}
		}
		return -1;
	}
	
	
	/**
	 * 查找第一个值大于等于给定值的元素
	 * @param arr
	 * @param item
	 * @return
	 */
	public static int binarySearchForFirstDD(int[] arr,int item) {
		int start=0;
		int end = arr.length - 1;
		while(start <= end) {
			int middle = (start + end) / 2;
			if(arr[middle] < item) {
				start = middle + 1;
			}else {
				if(start == middle || arr[middle - 1] < item) {
					return middle;
				}else {
					end = middle - 1;
				}
			}
		}
		return -1;
	}
	
	/**
	 * 查找最后一个值等于给定值的元素
	 * @param arr
	 * @param item
	 * @return
	 */
	public static int binarySearchForEnd(int[] arr,int item) {
		int start=0;
		int end = arr.length - 1;
		while(start <= end) {
			int middle = (start + end) / 2;
			if(arr[middle] > item) {
				end = middle - 1;
			}else if(arr[middle] < item) {
				start = middle + 1;
			}else {
				if(middle == end || arr[middle + 1] != item) {
					return middle;
				}else {
					start = middle + 1;
				}
			}
		}
		return -1;
	}
	/**
	 * 查找第一个值等于给定值的元素
	 * @param arr
	 * @param item
	 * @return
	 */
	public static int binarySearchForFirst(int[] arr,int item) {
		int start=0;
		int end = arr.length - 1;
		while(start <= end) {
			int middle = (start + end) / 2;
			if(arr[middle] > item) {
				end = middle - 1;
			}else if(arr[middle] < item) {
				start = middle + 1;
			}else {
				if(middle == start || arr[middle - 1] != item) {
					return middle;
				}else {
					end = middle - 1;
				}
			}
		}
		return -1;
	}
	
	
	public static int binarySearch2(int[] arr,int item) {
		return doBinarySearch2(arr, item, 0, arr.length - 1);
	}
	
	private static int doBinarySearch2(int[] arr,int item,int start,int end) {
		if(start > end) {
			return -1;
		}
		int middle = (start + end) / 2;
		if(arr[middle] == item) {
			return middle;
		}else if(arr[middle] > item){
			return doBinarySearch2(arr, item, start, middle - 1);
		}else {
			return doBinarySearch2(arr, item, middle + 1, end);
		}
	}
	
	public static int binarySearch(int[] arr,int item) {
		int mid = -1;
		int low = 0;
		int high = arr.length - 1;
		while(low <= high) {
			mid = (high + low) / 2;
			if(arr[mid] == item) {
				return mid;
			}
			if(arr[mid] > item) {
				high = mid -1;
			}
			if(arr[mid] < item) {
				low = mid + 1;
			}
		}
		return -1;
	}
}

@Data
class Person implements Comparable<Person>{
	
	private String name;
	private int age;
	
	
	
	@Override
	public int compareTo(Person p) {
		if(this.age > p.getAge()) {
			return 1;
		}else if(this.age < p.getAge()) {
			return -1;
		}else {
			return 0;
		}
	}
	
	public Person(int age) {
		this.age = age;
	}
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
}
