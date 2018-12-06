package com.yanghui.study.algorithm.interview;

public class Gupiao {
	
	public static void main(String[] args) {
//		int[] arr = new int[] {7,1,5,3,6,4};
//		int[] arr = new int[] {1,2,3,4,5};
//		int[] arr = new int[] {7,6,4,3,1};
//		System.out.println(gupiao(new int[] {7,1,5,3,6,4}));
//		System.out.println(gupiao(new int[] {1,2,3,4,5}));
//		System.out.println(gupiao(new int[] {7,6,4,3,1}));
		//7,1,5,3,6,4
		//
		int[] p = new int[] {2,4,1,6};
		System.out.println(maxProfit(p));
		System.out.println(maxProfit(p,p.length-1));
	}
	/**
	 * 可多次买卖一支股票
	 * @param arr
	 * @return
	 */
	public static int gupiao(int[] arr) {
		int result = 0;
		for(int i=0;i<arr.length-1;i++) {
			if(arr[i] < arr[i+1]) {
				result = result + arr[i+1] - arr[i];
			}
		}
		return result;
	}
	
	public static int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
	}
	
	public static int maxProfit(int[] prices,int i) {
		if(i == 0) {
			return 0;
		}
		if(i == 1) {
			return prices[1] - prices[0] > 0 ? prices[1] - prices[0]  : 0;
		}
		int a = prices[i] - maxProfit(prices,i-1);
		int b = prices[i-1] - maxProfit(prices,i-2);
		return a > b ? a : b;
	}
}
