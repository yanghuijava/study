package com.yanghui.study.algorithm.interview;
/**
 * 连续子数组的最大和
 * @author think
 *
 */
public class MaximumSequenceSum {

	public static void main(String[] args) {
		int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4,-1,-2,10};
		System.out.println(new MaximumSequenceSum().maxSubArray(nums));
		System.out.println(new MaximumSequenceSum().maxSubArray1(nums));
		System.out.println(new MaximumSequenceSum().maxSubArray2(nums));
		System.out.println(new MaximumSequenceSum().maxSubArrayDP(nums));
	}
	
	public int maxSubArrayDP(int[] nums) {
		if(nums == null || nums.length == 0) {
			return 0;
		}
		int max = nums[0];
		int sum = nums[0];
		for(int i=1;i<nums.length;i++) {
			sum = Math.max(nums[i], sum + nums[i]);
			if(sum > max) {
				max = sum;
			}
		}
		return max;
	}

	public int maxSubArray2(int[] nums) {
		int result = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			int max = 0;
			for (int j = i; j < nums.length; j++) {
				max += nums[j];
				result = result > max ? result : max;
			}
		}
		return result;
	}

	public int maxSubArray1(int[] nums) {
		int result = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i; j < nums.length; j++) {
				int max = 0;
				for (int k = i; k <= j; k++) {
					max += nums[k];
				}
				result = result > max ? result : max;
			}
		}
		return result;
	}

	public int maxSubArray(int[] nums) {
		int max = Integer.MIN_VALUE, sum = 0;
		for (int i = 0; i < nums.length; i++) {
			if (sum < 0) {
				sum = nums[i];
			}else{
				sum += nums[i];
			}
			if (sum > max) {
				max = sum;
			}
		}
		return max;
	}
}
