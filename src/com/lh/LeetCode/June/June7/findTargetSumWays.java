package com.lh.LeetCode.June.June7;

import java.util.HashMap;
import java.util.Map;

/**
 * 494. 目标和
 * 给你一个整数数组 nums 和一个整数 target 。
 * <p>
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 * <p>
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 20
 * 0 <= nums[i] <= 1000
 * 0 <= sum(nums[i]) <= 1000
 * -1000 <= target <= 100
 *
 * @Author: LH
 * @Date: 2021/6/7 11:00
 */
public class findTargetSumWays {
}

class Solution {
    Map<String, Integer> map = new HashMap<>();

    public int findTargetSumWays(int[] nums, int target) {
//        return dfs(nums, target, 0, 0);
        return dfs2(nums, target, 0, 0);
    }

    /**
     * dfs暴力求解
     *
     * @param nums   输入数组
     * @param target 目标值
     * @param idx    遍历开始位置
     * @param cur    当前值
     * @return 满足条件的方案数
     */
    private int dfs(int[] nums, int target, int idx, int cur) {
        if (idx == nums.length) return cur == target ? 1 : 0;
        int left = dfs(nums, target, idx + 1, cur + nums[idx]);
        int right = dfs(nums, target, idx + 1, cur - nums[idx]);
        return left + right;
    }

    /**
     * dfs+记忆化搜索
     *
     * @param nums   输入数组
     * @param target 目标值
     * @param idx    遍历开始位置
     * @param cur    当前值
     * @return 满足条件的方案数
     */
    private int dfs2(int[] nums, int target, int idx, int cur) {
        String key = idx + "_" + cur;
        if (map.containsKey(key)) return map.get(key);
        if (idx == nums.length) {
            map.put(key, cur == target ? 1 : 0);
            return map.get(key);
        }
        int left = dfs2(nums, target, idx + 1, cur + nums[idx]);
        int right = dfs2(nums, target, idx + 1, cur - nums[idx]);
        map.put(key, left + right);
        return map.get(key);
    }

    // 动态规划，设数组nums总和为s，在过程中变为负数的绝对值和为m，则有target=(s-m)-m，即m=(s-target)/2
    // 问题即转换为，只使用+，从数组中凑出总和为m的方案数，且需要保证s-target能被2整除
    // 问题转换为 01背包问题
    // 定义dp[i][j]为从nums凑出总和恰好为j的方案数。
    // 最终答案为dp[n][m]，dp[0][0]=1为起始条件
    public int findTargetSumWays2(int[] nums, int target) {
        int n = nums.length;
        // 求得总和
        int s = 0;
        for (int item :
                nums) {
            s += item;
        }
        // 判断前提条件
        if (target > s || (s - target) % 2 != 0) return 0;
        int m = (s - target) / 2;
        int[][] dp = new int[n + 1][m + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            int x = nums[i - 1];
            for (int j = 0; j <= m; j++) {
                dp[i][j] += dp[i - 1][j];
                if (j >= x) dp[i][j] += dp[i - 1][j - x];
            }
        }
        return dp[n][m];
    }
}