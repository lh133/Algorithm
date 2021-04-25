package com.lh.LeetCode.April.April24;

/**
 * 377. 组合总和 Ⅳ
 * 给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。
 * 题目数据保证答案符合 32 位整数范围。
 * 提示：
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 1000
 * nums 中的所有元素 互不相同
 * 1 <= target <= 1000
 * <p>
 * 进阶：如果给定的数组中含有负数会发生什么？问题会产生何种变化？如果允许负数出现，需要向题目中添加哪些限制条件？
 * 需要限制排列的最大长度
 *
 * @Author: LH
 * @Date: 2021/4/25 11:52
 */
public class combinationSum4 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int target = 4;
        System.out.println(new Solution().combinationSum4(nums, target));
    }
}

class Solution {
    // 动态规划
    // 状态定义dp[i][j]表示 组合长度为 i，凑成总和为 j 的方案数是多少
    //                i=0
    // dp[len][target]= ∑ ​dp[len−1][target−nums[i]],target⩾nums[i]
    //                n−1
    public int combinationSum4(int[] nums, int target) {
        // 因为 nums[i] 最小值为 1，因此构成答案的最大长度为 target
        int len = target;
        int[][] dp = new int[len + 1][target + 1];
        dp[0][0] = 1;
        int ans = 0;
        // 因为长度为i的方案依赖于长度为i-1的方案，所以先遍历len
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= target; j++) {
                for (int num :
                        nums) {
                    // 最后一个数选择 nums[0]，方案数为 dp[len - 1][target - nums[0]]
                    // 最后一个数选择 nums[1]，方案数为 dp[len - 1][target - nums[1]]
                    if (j >= num) {
                        dp[i][j] += dp[i - 1][j - num];
                    }
                }
            }
            ans += dp[i][target];
        }
        return ans;
    }

    // 取消物品维度实现降维
    // 定义 f[i] 为凑成总和为 i 的方案数是多少
    public int _combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num :
                    nums) {
                // 假设排列的最后一个元素是 num，则一定有 num≤i
                if (num <= i) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }
}