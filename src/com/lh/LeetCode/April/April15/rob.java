package com.lh.LeetCode.April.April15;

/**
 * 198. 打家劫舍
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
 * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 * @Author: LH
 * @Date: 2021/4/15 16:19
 */
public class rob {
    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 1};
        Solution solution = new Solution();
        System.out.println(solution.rob(nums));
    }
}

class Solution {
    // 用 dp[i] 表示前 i 间房屋能偷窃到的最高总金额，那么就有如下的状态转移方程：
    // dp[i]=max(dp[i−2]+nums[i],dp[i−1])
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int len = nums.length;
        if (len == 1)
            return nums[0];
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[len - 1];
    }

    // 空间优化
    @SuppressWarnings("DuplicatedCode")
    public int rob1(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int len = nums.length;
        if (len == 1)
            return nums[0];

        int first = nums[0];
        int second = Math.max(nums[1], nums[0]);

        for (int i = 2; i < len; i++) {
            int tmp = second;
            second = Math.max(first + nums[i], second);
            first = tmp;
        }
        return second;
    }
}
