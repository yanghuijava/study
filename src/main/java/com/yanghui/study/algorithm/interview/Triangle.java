package com.yanghui.study.algorithm.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {
	
	public static void main(String[] args) {
		List<List<Integer>> triangle = new ArrayList<>();
		List<Integer> l1 = new ArrayList<>();
		l1.add(2);
		triangle.add(l1);
		
		List<Integer> l2 = new ArrayList<>();
		l2.add(3);
		l2.add(4);
		triangle.add(l2);
		
		List<Integer> l3 = new ArrayList<>();
		l3.add(6);
		l3.add(5);
		l3.add(7);
		triangle.add(l3);
		
		List<Integer> l4 = new ArrayList<>();
		l4.add(4);
		l4.add(1);
		l4.add(8);
		l4.add(3);
		triangle.add(l4);
//		System.out.println(minimumTotal(triangle, 0, 0));
		System.out.println(minimumTotal1(triangle));
	}
	
	static void print(int[][] gezi) {
		for(int i=0;i<gezi.length;i++) {
			System.out.println(Arrays.toString(gezi[i]));
		}
	}
	
	public static int minimumTotal1(List<List<Integer>> triangle) {
		int[] opt = new int[triangle.size()];
		for(int j=triangle.get(triangle.size() - 1).size() - 1;j >= 0;j--) {
			opt[j] = triangle.get(triangle.size() - 1).get(j);
		}
		for(int i=triangle.size() - 2;i >= 0;i--) {
			for(int j=0;j < triangle.get(i).size();j++) {
				opt[j] = triangle.get(i).get(j) + Math.min(opt[j], opt[j+1]);
			}
		}
		System.out.println(Arrays.toString(opt));
		return opt[0];
	}
	
	public static int minimumTotal(List<List<Integer>> triangle) {
		int[][] opt = new int[triangle.size()][triangle.get(triangle.size() - 1).size()];
		for(int j=triangle.get(triangle.size() - 1).size()-1;j >=0;j--) {
			opt[triangle.size() - 1][j] = triangle.get(triangle.size() - 1).get(j);
		}
		for(int i=triangle.size() - 2;i >= 0;i--) {
			for(int j=i;j >= 0;j--) {
				opt[i][j] = triangle.get(i).get(j) + Math.min(opt[i+1][j], opt[i+1][j+1]);
			}
		}
		print(opt);
		return opt[0][0];
	}

	public static int minimumTotal(List<List<Integer>> triangle,int i,int j) {
		if(i == triangle.size() - 1) {
			return triangle.get(i).get(j);
		}
		return triangle.get(i).get(j) + Math.min(minimumTotal(triangle, i+1, j), minimumTotal(triangle, i+1, j+1));
	}
}
