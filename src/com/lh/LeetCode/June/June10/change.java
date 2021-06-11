package com.lh.LeetCode.June.June10;

/**
 * 518. 零钱兑换 II
 * <p>
 * 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。
 * <p>
 * 注意:
 * <p>
 * 你可以假设：
 * <p>
 * 0 <= amount (总金额) <= 5000
 * 1 <= coin (硬币面额) <= 5000
 * 硬币种类不超过 500 种
 * 结果符合 32 位符号整数
 *
 * @Author: LH
 * @Date: 2021/6/10 11:13
 */
public class change {
}

class Solution2 {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        // dp[i]表示总和为i的方案数
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            int x = coins[i - 1];
            for (int j = x; j <= amount; j++) {
                dp[j] += dp[j - x];
            }
        }
        return dp[amount];
    }
}