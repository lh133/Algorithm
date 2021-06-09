package com.lh.LeetCode.June.June9;

/**
 * 416. 分割等和子集
 * <p>
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 100
 *
 * @Author: LH
 * @Date: 2021/6/9 16:52
 */
public class canPartition {
}

// 能成功分割，则两边的和均为数组和的一半
class Solution2 {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 2 == 1) return false;
        int mid = sum / 2;
        // dp[i][j]表示前i个数，和是否恰好等于j
        boolean[] dp = new boolean[mid + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            int x = nums[i - 1];
            // 一维优化需要倒序遍历，保证当前状态i计算依赖的i-1状态未被修改
            for (int j = mid; j >= 0; j--) {
                // 状态转移写法
                // dp[j] = dp[j] || (j >= x ? dp[j - x] : false);
                // 优化写法
                dp[j] = dp[j] || (j >= x && dp[j - x]);
            }
        }
        return dp[mid];
    }
}