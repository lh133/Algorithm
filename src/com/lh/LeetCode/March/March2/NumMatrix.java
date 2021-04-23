package com.lh.LeetCode.March.March2;

/**
 * 304. 二维区域和检索 - 矩阵不可变
 * 3 0 1 4 2
 * 5 6 3 2 1
 * 1 2 0 1 5
 * 4 1 0 1 7
 * 1 0 3 0 5
 * 给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2) 。
 * 上图子矩阵左上角 (row1, col1) = (2, 1) ，右下角(row2, col2) = (4, 3)，该子矩形内元素的总和为 8。
 * 解决方法：前缀和
 *
 * @Author: LH
 * @Date: 2021/3/2 9:36
 */
public class NumMatrix {

    private final int[][] preSum;

    public NumMatrix(int[][] matrix) {
        //定义行和列的长度，避免空矩阵进入循环
        int m = matrix.length;
        int n = m == 0 ? 0 : matrix[0].length;
        preSum = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //preSum比matrix多一行一列，为了使0行0列的元素也能使用公式，减少特殊判断代码
                //建议画图理解
                preSum[i + 1][j + 1] = preSum[i][j + 1] + preSum[i + 1][j] - preSum[i][j] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        //建议画图理解
        return preSum[row2 + 1][col2 + 1] - preSum[row1][col2 + 1] - preSum[row2 + 1][col1] + preSum[row1][col1];
    }
}

class Test {
    public static void main(String[] args) {
        int[][] matrix = {{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
        int[] row1 = {2, 1, 1};
        int[] col1 = {1, 1, 2};
        int[] row2 = {4, 2, 2};
        int[] col2 = {3, 2, 4};
        NumMatrix obj = new NumMatrix(matrix);
        for (int i = 0; i < 3; i++) {
            int ans = obj.sumRegion(row1[i], col1[i], row2[i], col2[i]);
            System.out.println(ans);
        }
    }
}