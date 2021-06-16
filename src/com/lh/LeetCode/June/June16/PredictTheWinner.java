package com.lh.LeetCode.June.June16;

/**
 * 486. 预测赢家
 * <p>
 * 给定一个表示分数的非负整数数组。 玩家 1 从数组任意一端拿取一个分数，随后玩家 2 继续从剩余数组任意一端拿取分数，然后玩家 1 拿，…… 。每次一个玩家只能拿取一个分数，分数被拿取之后不再可取。直到没有剩余分数可取时游戏结束。最终获得分数总和最多的玩家获胜。
 * <p>
 * 给定一个表示分数的数组，预测玩家1是否会成为赢家。你可以假设每个玩家的玩法都会使他的分数最大化。
 * <p>
 * 提示：
 * <p>
 * 1 <= 给定的数组长度 <= 20.
 * 数组里所有分数都为非负数且不会大于 10000000 。
 * 如果最终两个玩家的分数相等，那么玩家 1 仍为赢家。
 *
 * @Author: LH
 * @Date: 2021/6/16 9:23
 */
public class PredictTheWinner {
}

class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        // dp表示面对区间[i，j]，玩家的净胜分
        // dp[i][j] = max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1])
        int[] dp = new int[n];
        System.arraycopy(nums, 0, dp, 0, n);
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                // 如果甲拿nums[i]，那么变成乙面对区间[i+1...j]，这段区间内乙对甲的净胜分为dp[i+1][j]；那么甲对乙的净胜分就应该是nums[i] - dp[i+1][j]。
                // 如果甲拿nums[j]，同理可得甲对乙的净胜分为是nums[j] - dp[i][j-1]。
                dp[j] = Math.max(nums[i] - dp[j], nums[j] - dp[j - 1]);
            }
        }
        return dp[n - 1] >= 0;
    }
}