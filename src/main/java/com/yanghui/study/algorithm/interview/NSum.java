package com.yanghui.study.algorithm.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * 两数之和
 * @author think
 *
 */
public class NSum {

	public static void main(String[] args) {
//		List<List<Integer>> result = twoSum(new int[] {1,3,0,2,2,4,1},4,0);
//		System.out.println(result);
		List<List<Integer>> result = threeSum(new int[] {-1, 0, 1, 2, -1, -4},0);
		System.out.println(result);
	}
	
	public static List<List<Integer>> threeSum(int[] nums,int sum) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		Set<String> set = new HashSet<>();
		for(int i=0;i<nums.length;i++) {
			if(nums.length - i < 2) {
				break;
			}
			int a = nums[i];
			List<List<Integer>> twoSum = twoSum(nums, sum - a, i + 1);
			if(!twoSum.isEmpty()) {
				for(List<Integer> items : twoSum) {
					if(set.contains(items.toString())) {
						continue;
					}
					List<Integer> list = new ArrayList<>();
					list.add(nums[i]);
					list.addAll(items);
					result.add(list);
					set.add(items.toString());
				}
			}
		}
		return result;
    }
	
	public static List<List<Integer>> twoSum(int[] arr,int target,int n) {
		List<List<Integer>> result = new ArrayList<>();
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i=n;i<arr.length;i++) {
			int poor = target - arr[i];
			if(map.containsKey(poor)) {
				List<Integer> list = new ArrayList<>();
				list.add(poor);
				list.add(arr[i]);
				result.add(list);
			}
			map.put(arr[i], i);
		}
		return result;
	}
	
	public static int[] twoSum(int[] arr,int sum) {
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i=0;i<arr.length;i++) {
			int poor = sum - arr[i];
			if(map.containsKey(poor)) {
				return new int[] {map.get(poor),i};
			}
			map.put(arr[i], i);
		}
		return new int[] {};
	}
}
