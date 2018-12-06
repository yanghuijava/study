package com.yanghui.study.algorithm.find;

/**
 * 求一个数的平方根
 * @author think
 *
 */
public class SquareRoot {
	
	private static final double E = 0.000001D;
	
	public static void main(String[] args) {
		System.out.println(calculateSquareRoot(100));
	}
	
	public static double calculateSquareRoot(int i) {
		return doCalculateSquareRoot(i, 1, i);
	}
	
	private static double doCalculateSquareRoot(int i,double start,double end) {
		double middle = (start + end) / 2;
		if(middle * middle - i <= E && middle * middle - i >= -E) {
			return middle;
		}
		if(middle * middle - i > E) {
			return doCalculateSquareRoot(i, start, middle);
		}else {
			return doCalculateSquareRoot(i, middle, end);
		}
	}
}
