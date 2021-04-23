package com.lh.LeetCode.March.March21;

import java.util.Arrays;

/**
 * 73. 矩阵置零
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 * <p>
 * 进阶：
 * 一个直观的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个仅使用常量空间的解决方案吗？
 *
 * @Author: LH
 * @Date: 2021/3/21 22:34
 */
public class setZeroes {
    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        int[][] matrix1 = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        Solution solution = new Solution();
        solution.setZeroes(matrix);
        solution.setZeroes1(matrix1);
        System.out.println(Arrays.deepToString(matrix));
        System.out.println(Arrays.deepEquals(matrix,matrix1));
    }
}

class Solution {
    // 空间复杂度 O(M+N)
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = col[j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] || col[j])
                    matrix[i][j] = 0;
            }
        }
    }

    // 空间复杂度O(1)
    public void setZeroes1(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;

        // 1. 扫描「首行」和「首列」记录「首行」和「首列」是否该被置零
        boolean r0 = false, c0 = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                r0 = true;
                break;
            }
        }
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                c0 = true;
                break;
            }
        }

        // 2.1 扫描「非首行首列」的位置，如果发现零，将需要置零的信息存储到该行/列的「最左方」/「最上方」的格子内
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        // 2.2 根据刚刚记录在「最左方」和「最上方」格子内的置零信息，进行「非首行首列」置零
        for (int j = 1; j < n; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                Arrays.fill(matrix[i], 0);
            }
        }

        // 3. 根据最开始记录的「首行」和「首列」信息，进行「首行首列」置零
        if (r0) for (int i = 0; i < m; i++) matrix[i][0] = 0;
        if (c0) Arrays.fill(matrix[0], 0);
    }
}