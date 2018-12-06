package com.yanghui.study.algorithm.dp;
import java.util.Arrays;
public class KnapsackProblem {
    public static void main(String[] args) {
        int[] weight = {2, 4, 1, 5, 2,3};
        int[] price = {4, 5, 19, 3, 2,30};
        int knapsackWeight = 6;
        int value = knapsackProblem(weight, price, knapsackWeight);
        System.out.println(value);
    }

    /**
     * 动态规划求解0-1背包问题
     * @param weight 物品重量
     * @param price 物品价值
     * @param knapsackWeight 背包承重量
     * @return
     */
    private static int knapsackProblem(int[] weight, int[] price, int knapsackWeight) {
        int row = weight.length + 1;
        int col = knapsackWeight + 1;
        int[][] solutionMatrix = new int[row][col];
        int[] values = new int[row];
        values[0] = 0;
        for (int i = 0; i < row; i++) {
            solutionMatrix[i][0] = 0;
        }
        for (int j = 0; j < col; j++) {
            solutionMatrix[0][j] = 0;
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                solutionMatrix[i][j] = solutionMatrix[i - 1][j];
                if (j - weight[i - 1] >= 0 && solutionMatrix[i - 1][j - weight[i - 1]] + price[i - 1] > solutionMatrix[i][j]) {
                    solutionMatrix[i][j] = solutionMatrix[i - 1][j - weight[i - 1]] + price[i - 1];
                }
            }
            values[i] = solutionMatrix[i][col - 1];
        }
        Arrays.sort(values);
        return values[values.length - 1];
    }
}