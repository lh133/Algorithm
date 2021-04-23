package com.lh.LeetCode.February.February25;

/**
 * 867. 转置矩阵
 * 给你一个二维整数数组 matrix， 返回 matrix 的 转置矩阵 。
 * 矩阵的 转置 是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 1000
 * 1 <= m * n <= 105
 * -10^9 <= matrix[i][j] <= 10^9
 *
 * @Author: LH
 * @Date: 2021/2/25 11:19
 */
public class transpose {
    public static void main(String[] args) {
        int[][] A = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Solution solution = new Solution();
        int[][] transpose = solution.transpose(A);
        int Row = transpose.length;
        int Col = transpose[0].length;
        for (int i = 0; i < Row; i++) {
            for (int j = 0; j < Col; j++) {
                System.out.print(transpose[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class Solution {
    public int[][] transpose(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        int[][] ans = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[j][i] = A[i][j];
            }
        }
        return ans;
    }
}