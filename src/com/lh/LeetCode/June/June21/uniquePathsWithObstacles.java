package com.lh.LeetCode.June.June21;

/**
 * 63. 不同路径 II
 * <p>
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * <p>
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * <p>
 * 提示：
 * <p>
 * m == obstacleGrid.length
 * n == obstacleGrid[i].length
 * 1 <= m, n <= 100
 * obstacleGrid[i][j] 为 0 或 1
 *
 * @Author: LH
 * @Date: 2021/6/21 11:03
 */
public class uniquePathsWithObstacles {
}

class Solution4 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid[0].length, n = obstacleGrid.length;
        int[] dp = new int[m];
        // 判断起点处是否可达
        dp[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int[] ints : obstacleGrid) {
            for (int j = 0; j < m; ++j) {
                if (ints[j] == 1) {
                    dp[j] = 0;
                    continue;
                }
                if (j - 1 >= 0 && ints[j - 1] == 0) dp[j] += dp[j - 1];
            }
        }
        return dp[m - 1];
    }
}