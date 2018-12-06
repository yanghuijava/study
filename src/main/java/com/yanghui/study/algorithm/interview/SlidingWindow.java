package com.yanghui.study.algorithm.interview;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 滑动窗口的最大值
 * @author think
 *
 */
public class SlidingWindow {

	public static void main(String[] args) {
//		int[] nums = new int[] {1,2,3,4,1,3,0};
		int[] nums = new int[] {5,2,3,2,1,1,1};
//		int[] nums = new int[] {1,3,-1,-3,5,3,6,7};
//		int count = 1000000;
//		int[] nums = new int[count];
//		Random r = new Random();
//		for(int i=0;i<count;i++) {
//			nums[i] = r.nextInt(50);
//		}
		long start = System.currentTimeMillis();
		int[] result = new SlidingWindow().maxSlidingWindow2(nums, 3);
		System.out.println("耗时" + (System.currentTimeMillis() - start) + "毫秒");
		System.out.println(Arrays.toString(result));
	}
	
	
	/**
	 * 使用双端队列实现 时间复杂度为O(n)
	 * @param nums
	 * @param k
	 * @return
	 */
	public int[] maxSlidingWindow2(int[] nums, int k) {
		if(nums == null || nums.length == 0 || k < 1 || k > nums.length) {
        	return null;
        }
        if(k == 1) {
        	return nums;
        }
        int[] result = new int[nums.length - k + 1];
        int m = 0;
        ArrayDeque<Integer> queue = new ArrayDeque<>(k);
        for(int i=0;i<nums.length;i++) {
        	//把不在窗口的数据移除掉
        	while(!queue.isEmpty() && queue.peek() < i-k+1) {
        		queue.remove();
        	}
        	//比较大小，把较小的数据移除掉
        	while(!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
        		queue.removeLast();
        	}
        	queue.add(i);
        	if(i-k+1 < 0) {
        		continue;
        	}
        	result[m++] = nums[queue.peek()];
        }
        return result;
	}
	/**
	 * 使用最大堆实现 时间复杂度是O(NlogK)
	 * @param nums
	 * @param k
	 * @return
	 */
	public int[] maxSlidingWindow1(int[] nums, int k) {
		if(nums == null || nums.length == 0 || k < 1 || k > nums.length) {
        	return null;
        }
        if(k == 1) {
        	return nums;
        }
        int[] result = new int[nums.length - k + 1];
        int j = 0;
        //用优先队列构建最大堆
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if(o1.compareTo(o2) == 0) {
					return 0;
				}else if(o1.compareTo(o2) > 0) {
					return -1;
				}else {
					return 1;
				}
			}
		});
        for(int i=0;i<nums.length;i++) {
        	//把不在窗口的数据移除掉
        	if(i-k+1 > 0) {
        		queue.remove(nums[i-k]);
        	}
        	//把移进窗口的数据加入最大堆，最大值一定会在堆顶
        	queue.add(nums[i]);
        	if(i-k+1 < 0) {
        		continue;
        	}
        	result[j++] = queue.peek();
        }
        return result;
	}
}
