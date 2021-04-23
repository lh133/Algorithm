package com.lh.LeetCode.March.March16;

import java.util.Arrays;

/**
 * 59. 螺旋矩阵 II
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * 提示：
 * 1 <= n <= 20
 *
 * @Author: LH
 * @Date: 2021/3/16 20:59
 */
public class generateMatrix {
    public static void main(String[] args) {
        int n = 3;
        Solution solution = new Solution();
        int[][] ans = solution.generateMatrix(n);
        System.out.println(Arrays.deepToString(ans));
    }
}

class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        circle(0, 0, n - 1, n - 1, 1, ans);
        return ans;
    }

    private void circle(int x1, int y1, int x2, int y2, int start, int[][] ans) {
        if (x1 > x2 || y1 > y2) return;

        if (x1 == x2) {
            ans[x1][y1] = start;
            return;
        }

        //由外围到内圈，均不取边界
        int val = start;
        //向右
        for (int i = y1; i < y2; i++) {
            ans[x1][i] = val++;
        }
        //向下
        for (int i = x1; i < x2; i++) {
            ans[i][y2] = val++;
        }
        //向左
        for (int i = y2; i > y1; i--) {
            ans[x2][i] = val++;
        }
        //向上
        for (int i = x2; i > x1; i--) {
            ans[i][y1] = val++;
        }

        //缩小圈子进行递归
        circle(x1 + 1, y1 + 1, x2 - 1, y2 - 1, val, ans);
    }
}