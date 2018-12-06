package com.yanghui.study.algorithm.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class Item {

	private String name;
	private int weight;
	private int money;
}
@Data
@AllArgsConstructor
class ItemCount{
	private int total;
	private String items;
}

public class DPTest {

	public static void main(String[] args) {
//		int cap = 6;
//		Item[] items = new Item[] {
//				new Item("吉他",2, 4),
//				new Item("iphone",4, 5), 
//				new Item("笔记本", 1, 19),
//				new Item("音响", 5, 3),
//				new Item("ipad", 2, 2),
//				new Item("ipone", 3, 30)};
//		ItemCount ic = beibao1(items, cap);
//		String result = "";
//		for(String s : ic.getItems().split("-->")) {
//			result = result + items[Integer.valueOf(s)].getName() + ":" + items[Integer.valueOf(s)].getWeight() +  ",";
//		}
//		result = result.substring(0, result.length()-1);
//		System.out.println("背包容量为" + cap + "英镑可以放入物品：" + 
//				result + "达到最大价值：" + ic.getTotal() + "美元");
//		int[] arr = new int[] {2,4,5,1,8};
//		System.out.println(equalTarget(arr, 0));
//		System.out.println(equalTarget(arr, arr.length-1,0));
//		System.out.println(equalTarget(arr, 10));
//		System.out.println(equalTarget(arr,11));
//		int[] p = new int[] {1,5,8,9,10};
//		System.out.println(cuttingSteel(p));
		
		Item[] huowei = new Item[] {
				new Item("0号货位",1, 1),
				new Item("1号货位",3, 3),
				new Item("2号货位",8, 8),
				new Item("3号货位", 10, 10),
				new Item("4号货位", 12, 12),
				new Item("5号货位", 15, 15)};
		ItemCount ic1 = beibao1(huowei, 8);
		System.out.println(ic1);
		ItemCount ic2 = beibao1(huowei,10);
		System.out.println(ic2);
	}
	
	
	
	/**
	 * 切钢条
	 * @param p
	 * @return
	 */
	public static int cuttingSteel(int[] p) {
		int[] opt = new int[p.length+1];
		opt[0] = 0;
		for(int i=1;i<opt.length;i++) {
			int q = 0;
			for(int n=1;n<=i;n++) {
				int b = p[n-1] + opt[i-n];
				q = q > b ? q : b;
			}
			opt[i] = q;
		}
		System.out.println(Arrays.toString(opt));
		return opt[opt.length-1];
	}
	
	public static int cuttingSteel(int[] p,int n) {
		if(n == 0) {
			return 0;
		}
		int q = 0;
		for(int i=1;i<=n;i++) {
			int b = p[i-1] + cuttingSteel(p, n-i);
			q = q > b ? q : b;
		}
		return q;
	}
	
	public static int fbin1(int n) {
		if(n == 1 || n == 2) {
			return 1;
		}
		int[] opt = new int[n];
		opt[0] = 1;
		opt[1] = 1;
		for(int i=2;i<opt.length;i++) {
			opt[i] = opt[i-1] + opt[i-2];
		}
		return opt[opt.length - 1];
	}
	
	
	public static boolean equalTarget(int[] arr,int target) {
		Boolean[][] opt = new Boolean[arr.length][target+1];
		for(int t=0;t<target+1;t++) {
			opt[0][t] = false;
		}
		if(arr[0] < target+1) {
			opt[0][arr[0]] = true;
		}
		for(int i=0;i<arr.length;i++) {
			opt[i][0] = true;
		}
		for(int i=1;i<arr.length;i++) {
			for(int t=0;t<target+1;t++) {
				if(t < arr[i]) {
					opt[i][t] = opt[i-1][t];
				}else {
					opt[i][t] = opt[i-1][t] || opt[i-1][t-arr[i]];
				}
			}
		}
		return opt[arr.length -1][target];
	}
	
	public static boolean equalTarget(int[] arr,int i,int target) {
		if(i == 0) {
			return arr[0] == target;
		}
		if(target == 0) {
			return true;
		}
		if(arr[i] > target) {
			return equalTarget(arr, i-1, target);
		}
		return equalTarget(arr, i-1, target - arr[i]) || equalTarget(arr, i-1, target);
	}
	
	
	public static ItemCount beibao1(Item[] items, int cap) {
		ItemCount[][] opt = new ItemCount[items.length][cap + 1];
		for(int i=0;i<opt.length;i++) {
			for(int c=0;c<cap+1;c++) {
				if(i == 0) {
					if (c >= items[0].getWeight()) {
						opt[0][c] = new ItemCount(items[0].getMoney(), "0-->");
					}else {
						opt[0][c] = new ItemCount(0, "");
					}
					continue;
				}
				if(items[i].getWeight() > c) {
					opt[i][c] = opt[i-1][c];
				}else {
					ItemCount a = new ItemCount(items[i].getMoney() + opt[i-1][c - items[i].getWeight()].getTotal(), 
							opt[i-1][c - items[i].getWeight()].getItems() + i + "-->");
					ItemCount b = opt[i-1][c];
					opt[i][c] = a.getTotal() > b.getTotal() ? a : b;
				}
			}
		}
		print(opt);
		return opt[items.length-1][cap];
	}

	public static int beibao(Item[] items, int cap) {
		int[][] opt = new int[items.length][cap + 1];
		for(int i=0;i<opt.length;i++) {
			for(int c=0;c<cap+1;c++) {
				if(i == 0) {
					if (c >= items[0].getWeight()) {
						opt[0][c] = items[0].getMoney();
					}
					continue;
				}
				if(items[i].getWeight() > c) {
					opt[i][c] = opt[i-1][c];
				}else {
					int a = items[i].getMoney() + opt[i-1][c - items[i].getWeight()];
					int b = opt[i-1][c];
					opt[i][c] = a > b ? a : b;
				}
			}
		}
		return opt[items.length-1][cap];
	}

	private static <T> void print(T[][] opt) {
		for (T[] a : opt) {
			for (T b : a) {
				System.out.print(b + " ");
			}
			System.out.println();
		}
	}
	
	private static void print(int[][] opt) {
		for (int[] a : opt) {
			for (int b : a) {
				System.out.print(b + " ");
			}
			System.out.println();
		}
	}

	public static int beibao(Item[] items, int i, int cap) {
		if (i == 0) {
			if (cap >= items[i].getWeight()) {
				return items[i].getMoney();
			} else {
				return 0;
			}
		}
		if (items[i].getWeight() > cap) {
			return beibao(items, i - 1, cap);
		}
		int a = items[i].getMoney() + beibao(items, i - 1, cap - items[i].getWeight());
		int b = beibao(items, i - 1, cap);
		return a > b ? a : b;
	}

	/**
	 * 
	 * @param arr
	 * @return
	 */
	public static int dp(int[] arr) {
		int[] a = new int[arr.length];
		a[0] = arr[0];
		a[1] = arr[arr[0] > arr[1] ? 0 : 1];
		for (int i = 2; i < arr.length; i++) {
			int j1 = arr[i] + a[i - 2];
			int j2 = a[i - 1];
			a[i] = j1 > j2 ? j1 : j2;
		}
		System.out.println(Arrays.toString(a));
		return a[a.length - 1];
	}

	public static int recDp(int[] arr, int i) {
		if (i == 0) {
			return arr[i];
		}
		if (i == 1) {
			return arr[0] > arr[1] ? arr[0] : arr[1];
		}
		int a = arr[i] + recDp(arr, i - 2);
		int b = recDp(arr, i - 1);
		return a > b ? a : b;
	}
}
