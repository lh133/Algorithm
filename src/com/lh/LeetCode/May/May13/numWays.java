package com.lh.LeetCode.May.May13;

/**
 * 1269. 停在原地的方案数
 * 有一个长度为 arrLen 的数组，开始有一个指针在索引 0 处。
 * <p>
 * 每一步操作中，你可以将指针向左或向右移动 1 步，或者停在原地（指针不能被移动到数组范围外）。
 * <p>
 * 给你两个整数 steps 和 arrLen ，请你计算并返回：在恰好执行 steps 次操作以后，指针仍然指向索引 0 处的方案数。
 * <p>
 * 由于答案可能会很大，请返回方案数 模 10^9 + 7 后的结果。
 *
 * @Author: LH
 * @Date: 2021/5/13 9:46
 */
public class numWays {
    public static void main(String[] args) {
        System.out.println(new Solution().numWays2(500, 100000));
    }
}

class Solution {
    private final int MODULO = 1000000007;

    public int numWays(int steps, int arrLen) {
        int maxStep = Math.min(steps / 2, arrLen - 1);
        // dp[i][j]代表当前剩余操作数为 i，所在位置为 j 的所有方案数。
        int[][] dp = new int[steps + 1][maxStep + 1];
        dp[steps][0] = 1;
        for (int i = steps - 1; i >= 0; --i) {
            for (int j = 0; j <= maxStep; ++j) {
                dp[i][j] = (dp[i][j] + dp[i + 1][j]) % MODULO;
                if (j - 1 >= 0) dp[i][j] = (dp[i][j] + dp[i + 1][j - 1]) % MODULO;
                if (j + 1 <= maxStep) dp[i][j] = (dp[i][j] + dp[i + 1][j + 1]) % MODULO;
            }
        }
        return dp[0][0];
    }

    // 循环过程中确定一个边界，减少无效状态判断
    // 利用 dp[i][x] 依赖于 dp[i + 1][y]，使用「滚动数组」进行优化即可。
    public int numWays2(int steps, int arrLen) {
        int maxStep = Math.min(steps / 2, arrLen - 1);
        // dp[i][j]代表当前剩余操作数为 i，所在位置为 j 的所有方案数。
        int[][] dp = new int[2][maxStep + 1];
        dp[steps & 1][0] = 1;
        for (int i = steps - 1; i >= 0; --i) {
            // 添加边界，减少无效状态
            int edge = Math.min(i, maxStep);
//            if (edge != maxStep) System.out.println(edge + " " + maxStep);
            // 滚动数组
            int a = i & 1, b = (i + 1) & 1;
            for (int j = 0; j <= edge; ++j) {
                dp[a][j] = 0;
                dp[a][j] = (dp[a][j] + dp[b][j]) % MODULO;
                if (j - 1 >= 0) dp[a][j] = (dp[a][j] + dp[b][j - 1]) % MODULO;
                if (j + 1 <= maxStep) dp[a][j] = (dp[a][j] + dp[b][j + 1]) % MODULO;
            }
        }
        return dp[0][0];
    }
}