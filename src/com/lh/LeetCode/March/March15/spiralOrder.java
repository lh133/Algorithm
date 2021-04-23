package com.lh.LeetCode.March.March15;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * 提示：
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 *
 * @Author: LH
 * @Date: 2021/3/15 22:50
 */
public class spiralOrder {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Solution solution = new Solution();
        List<Integer> ans = solution.spiralOrder(matrix);
        System.out.println(ans.toString());
    }
}

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int row = matrix.length, col = matrix[0].length;
        circle(matrix, 0, 0, row - 1, col - 1, ans);
        return ans;
    }

    private void circle(int[][] matrix, int x1, int y1, int x2, int y2, List<Integer> ans) {
        // 设置递归结束条件
        if (x2 < x1 || y2 < y1) return;

        // 只有一行时，按「行」遍历
        if (x1 == x2) {
            for (int i = y1; i <= y2; i++)
                ans.add(matrix[x1][i]);
            return;
        }

        // 只有一列时，按「列」遍历
        if (y1 == y2) {
            for (int i = x1; i <= x2; i++)
                ans.add(matrix[i][y1]);
            return;
        }

        //遍历当前一圈
        for (int i = y1; i < y2; i++) ans.add(matrix[x1][i]);
        for (int i = x1; i < x2; i++) ans.add(matrix[i][y2]);
        for (int i = y2; i > y1; i--) ans.add(matrix[x2][i]);
        for (int i = x2; i > x1; i--) ans.add(matrix[i][y1]);

        // 往里收一圈，继续作为新矩阵遍历
        circle(matrix, x1 + 1, y1 + 1, x2 - 1, y2 - 1, ans);
    }
}