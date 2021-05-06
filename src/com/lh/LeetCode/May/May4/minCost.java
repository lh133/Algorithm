package com.lh.LeetCode.May.May4;

/**
 * 1473. 粉刷房子 III
 * 在一个小城市里，有 m 个房子排成一排，你需要给每个房子涂上 n 种颜色之一（颜色编号为 1 到 n ）。有的房子去年夏天已经涂过颜色了，所以这些房子不需要被重新涂色。
 * <p>
 * 我们将连续相同颜色尽可能多的房子称为一个街区。（比方说 houses = [1,2,2,3,3,2,1,1] ，它包含 5 个街区  [{1}, {2,2}, {3,3}, {2}, {1,1}] 。）
 * <p>
 * 给你一个数组 houses ，一个 m * n 的矩阵 cost 和一个整数 target ，其中：
 * <p>
 * houses[i]：是第 i 个房子的颜色，0 表示这个房子还没有被涂色。
 * cost[i][j]：是将第 i 个房子涂成颜色 j+1 的花费。
 * 请你返回房子涂色方案的最小总花费，使得每个房子都被涂色后，恰好组成 target 个街区。如果没有可用的涂色方案，请返回 -1 。
 *
 * @Author: LH
 * @Date: 2021/5/4 10:44
 */
public class minCost {
    public static void main(String[] args) {
        int[] houses = {0, 0, 0, 0, 0};
        int[][] cost = {{1, 10}, {10, 1}, {10, 1}, {1, 10}, {5, 1}};
        System.out.println(new Solution().minCost(houses, cost, 5, 2, 3));
    }
}

class Solution {
    static int INF = 0x3f3f3f3f;

    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        // 定义 f[m][n][target] 为考虑前 m 间房子，且第 m 间房子的颜色编号为 n，前 m 间房子形成的分区数量为 target 的所有方案中的「最小上色成本」。
        int[][][] dp = new int[m + 1][n + 1][target + 1];

        // 街区数量不能为0
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j][0] = INF;
            }
        }

        for (int i = 1; i <= m; i++) {
            int color = houses[i - 1];
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= target; k++) {
                    // 当街区数大于房子数，状态无效
                    if (k > i) {
                        dp[i][j][k] = INF;
                        continue;
                    }

                    // 当前房子已经被粉刷过
                    if (color != 0) {
                        // 只有当 n 的颜色与房子颜色相同时，才允许转移
                        if (j == color) {
                            int tmp = INF;
                            // 第i间房组成新的街区，选择最优方案
                            for (int l = 1; l <= n; l++) {
                                if (l != j) {
                                    tmp = Math.min(tmp, dp[i - 1][l][k - 1]);
                                }
                            }
                            // 第i间房不形成新街区，与组成街区取最优
                            dp[i][j][k] = Math.min(dp[i - 1][j][k], tmp);
                        } else {// 其他状态无效
                            dp[i][j][k] = INF;
                        }

                        // 当前房子未粉刷过
                    } else {
                        int u = cost[i - 1][j - 1];
                        int tmp = INF;
                        for (int l = 1; l <= n; l++) {
                            // 形成新街区
                            if (l != j) {
                                tmp = Math.min(tmp, dp[i - 1][l][k - 1]);
                            }
                        }
                        // 不形成新街区的情况，与前面的情况取最优，并添加粉刷成本
                        dp[i][j][k] = Math.min(tmp, dp[i - 1][j][k]) + u;
                    }
                }
            }
        }

        // 从「考虑所有房间，并且形成分区数量为 t」的所有上色方案中找答案
        int ans = INF;
        for (int i = 1; i <= n; i++) {
            ans = Math.min(ans, dp[m][i][target]);
        }
        return ans == INF ? -1 : ans;
    }
}