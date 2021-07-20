package com.lh.LeetCode.July.July20;

import java.util.Arrays;

/**
 * 1877. 数组中最大数对和的最小值
 * <p>
 * 一个数对 (a,b) 的 数对和 等于 a + b 。最大数对和 是一个数对数组中最大的 数对和 。
 * <p>
 * 比方说，如果我们有数对 (1,5) ，(2,3) 和 (4,4)，最大数对和 为 max(1+5, 2+3, 4+4) = max(6, 5, 8) = 8 。
 * 给你一个长度为 偶数 n 的数组 nums ，请你将 nums 中的元素分成 n / 2 个数对，使得：
 * <p>
 * nums 中每个元素 恰好 在 一个 数对中，且
 * 最大数对和 的值 最小 。
 * 请你在最优数对划分的方案下，返回最小的 最大数对和 。
 * <p>
 * 提示：
 * <p>
 * n == nums.length
 * 2 <= n <= 105
 * n 是 偶数 。
 * 1 <= nums[i] <= 105
 *
 * @Author: LH
 * @Date: 2021/7/20 9:20
 */
public class minPairSum {
}

class Solution {
    public int minPairSum(int[] nums) {
        int n = nums.length;
        if (n == 2) return nums[0] + nums[1];
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < n / 2; i++) {
            ans = Math.max(nums[i] + nums[n - i - 1], ans);
        }
        return ans;
    }
}