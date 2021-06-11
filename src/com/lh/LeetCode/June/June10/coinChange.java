package com.lh.LeetCode.June.June10;

import java.util.Arrays;

/**
 * 322. 零钱兑换
 * <p>
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 * 提示：
 * <p>
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 231 - 1
 * 0 <= amount <= 104
 *
 * @Author: LH
 * @Date: 2021/6/10 9:53
 */
public class coinChange {
}

class Solution {
    public int coinChange(int[] coins, int amount) {
        // dp[j] 表示恰好达到总和j所需要的最小硬币个数
        int[] dp = new int[amount + 1];
        // 避免无效值转移
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
/*        for (int i = 1; i <= amount; i++) {
            for (int coin :
                    coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }*/
        for (int i = 1; i <= coins.length; i++) {
            int x = coins[i - 1];
            for (int j = x; j <= amount; j++) {
                dp[j] = Math.min(dp[j], dp[j - x] + 1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}