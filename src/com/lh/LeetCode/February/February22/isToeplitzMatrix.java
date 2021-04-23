package com.lh.LeetCode.February.February22;

/**
 * 766. 托普利茨矩阵
 * 给你一个 m x n 的矩阵 matrix 。如果这个矩阵是托普利茨矩阵，返回 true ；否则，返回 false 。
 * 如果矩阵上每一条由左上到右下的对角线上的元素都相同，那么这个矩阵是 托普利茨矩阵 。
 * 解决方法：只要每个元素都跟其右下角元素相等就满足条件。只要这样遍历结束之后，就能保证所有对角线上的元素就都是相等的。
 *
 * @Author: LH
 * @Date: 2021/2/22 15:47
 */
public class isToeplitzMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}};
        Solution solution = new Solution();
        boolean isToeplitzMatrix = solution.isToeplitzMatrix(matrix);
        if (isToeplitzMatrix = true)
            System.out.println("是托普利茨矩阵");
        else
            System.out.println("不是托普利茨矩阵");
    }
}

class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m - 1; ++i) {
            for (int j = 0; j < n - 1; j++) {
                if (matrix[i][j] != matrix[i + 1][j + 1])
                    return false;
            }
        }
        return true;
    }
}