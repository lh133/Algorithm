package com.lh.LeetCode.June.June12;

import java.util.Arrays;

/**
 * 1449. 数位成本和为目标值的最大数字
 * 给你一个整数数组 cost 和一个整数 target 。请你返回满足如下规则可以得到的 最大 整数：
 * <p>
 * 给当前结果添加一个数位（i + 1）的成本为 cost[i] （cost 数组下标从 0 开始）。
 * 总成本必须恰好等于 target 。
 * 添加的数位中没有数字 0 。
 * 由于答案可能会很大，请你以字符串形式返回。
 * <p>
 * 如果按照上述要求无法得到任何整数，请你返回 "0" 。
 * <p>
 * 提示：
 * <p>
 * cost.length == 9
 * 1 <= cost[i] <= 5000
 * 1 <= target <= 5000
 *
 * @Author: LH
 * @Date: 2021/6/12 20:06
 */
public class largestNumber {
}

class Solution {
    public String largestNumber(int[] cost, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= 9; i++) {
            int x = cost[i - 1];
            for (int j = x; j <= target; j++) {
                dp[j] = Math.max(dp[j], dp[j - x] + 1);
            }
        }
        if (dp[target] < 0) return "0";
        StringBuilder ans = new StringBuilder();
        for (int i = 9, j = target; i >= 1; i--) {
            int x = cost[i - 1];
            while (j >= x && dp[j] == dp[j - x] + 1) {
                ans.append(i);
                j -= x;
            }
        }
        return ans.toString();
    }
}