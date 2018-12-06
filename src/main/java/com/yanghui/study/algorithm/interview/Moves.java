package com.yanghui.study.algorithm.interview;

import java.util.Arrays;

public class Moves {

	public static void main(String[] args) throws InterruptedException {
		int[][] gezi = new int[8][8];
		gezi[1][2] = 1;
		gezi[1][6] = 1;
		gezi[2][4] = 1;
		gezi[3][0] = 1;
		gezi[3][2] = 1;
		gezi[3][5] = 1;
		gezi[4][2] = 1;
		gezi[5][3] = 1;
		gezi[5][4] = 1;
		gezi[5][6] = 1;
		gezi[6][1] = 1;
		gezi[6][5] = 1;
		gezi[7][4] = 1;
		print(gezi);
		System.out.println("-------------------------------");
//		System.out.println(rev_dp(gezi, 0, 0));
		System.out.println(dp(gezi));
	}
	
	static int dp(int[][] gezi) {
		int[][] opt = new int[gezi.length][gezi[0].length];
		opt[opt.length - 1][opt[0].length - 1] = 1;
		for(int j=opt[0].length-2;j >= 0;j--) {
			if(gezi[opt.length-1][j] == 1) {
				opt[opt.length-1][j] = 0;
			}else {
				opt[opt.length-1][j] = opt[opt.length-1][j + 1];
			}
		}
		for(int i=opt.length-2;i >= 0;i--) {
			if(gezi[i][opt[0].length-1] == 1) {
				opt[i][opt[0].length-1] = 0;
			}else {
				opt[i][opt[0].length-1] = opt[i + 1][opt[0].length-1];
			}
		}
//		print(opt);
		for(int i=opt.length-2;i >= 0;i--) {
			for(int j=opt[0].length-2;j >= 0;j--) {
				if(gezi[i][j] != 1) {
					opt[i][j] = opt[i][j+1] + opt[i+1][j];
				}else {
					opt[i][j] = 0;
				}
			}
		}
		print(opt);
		return opt[0][0];
	}
	
	static int rev_dp(int[][] gezi,int i,int j) {
		if(i == gezi.length - 1 || j == gezi[0].length - 1)return 1;
		if(gezi[i][j] == 1)return 0;
		return rev_dp(gezi,i+1,j) + rev_dp(gezi,i,j+1);
	}
	
	static void print(int[][] gezi) {
		for(int i=0;i<gezi.length;i++) {
			System.out.println(Arrays.toString(gezi[i]));
		}
	}
}
