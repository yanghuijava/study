package com.yanghui.study.algorithm.dp;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 最长公共子序列
 * @author think
 *
 */
public class LCS {

	public static void main(String[] args) {
		String str1 = "1A2C3D4B56";
		String str2 = "B1D23CA45B6A";
		
		System.out.println(lcs(str1, str2, str1.length() - 1, str2.length() - 1));
		System.out.println(lcs(str1, str2));
		System.out.println(lcs1(str1, str2));
	}
	
	public static LCSItems lcs1(String str1,String str2) {
		LCSItems[][] lcs = new LCSItems[str1.length()+1][str2.length()+1];
		for(int i=0;i<=str1.length();i++) {
			lcs[i][0] = new LCSItems(0, "");
		}
		for(int j=0;j<=str2.length();j++) {
			lcs[0][j] = new LCSItems(0, "");
		}
		for(int i=1;i<=str1.length();i++) {
			for(int j=1;j<=str2.length();j++) {
				if(str1.charAt(i-1) == str2.charAt(j-1)) {
					lcs[i][j] = new LCSItems(lcs[i-1][j-1].getLenght() + 1, lcs[i-1][j-1].getLcs() + str1.charAt(i-1));
				}else {
					LCSItems a = lcs[i][j - 1];
					LCSItems b = lcs[i - 1][j];
					lcs[i][j] = a.getLenght() > b.getLenght() ? a : b;
				}
			}
		}
		return lcs[str1.length()][str2.length()];
	}
	
	private static <T> void print(T[][] opt) {
		for (T[] a : opt) {
			for (T b : a) {
				System.out.print(b + " ");
			}
			System.out.println();
		}
	}
	
	public static int lcs(String str1,String str2) {
		int[][] lcs = new int[str1.length()+1][str2.length()+1];
		for(int i=0;i<=str1.length();i++) {
			lcs[i][0] = 0;
		}
		for(int j=0;j<=str2.length();j++) {
			lcs[0][j] = 0;
		}
		for(int i=1;i<=str1.length();i++) {
			for(int j=1;j<=str2.length();j++) {
				if(str1.charAt(i-1) == str2.charAt(j-1)) {
					lcs[i][j] = lcs[i-1][j-1] + 1;
				}else {
					int a = lcs[i][j - 1];
					int b = lcs[i - 1][j];
					lcs[i][j] = a > b ? a : b;
				}
			}
		}
		return lcs[str1.length()][str2.length()];
	}
	
	private static void print(int[][] opt) {
		for (int[] a : opt) {
			for (int b : a) {
				System.out.print(b + " ");
			}
			System.out.println();
		}
	}
	
	public static int lcs(String str1,String str2,int i,int j) {
		if(i < 0 || j < 0) {
			return 0;
		}
		if(str1.charAt(i) == str2.charAt(j)) {
			return lcs(str1, str2, i - 1, j - 1) + 1;
		}
		int a = lcs(str1, str2, i, j - 1);
		int b = lcs(str1, str2, i - 1, j);
		return a > b ? a : b;
	}
}

@Data
@AllArgsConstructor
class LCSItems{
	private int lenght;
	private String lcs;
}
