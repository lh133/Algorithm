package com.lh.LeetCode.June.June2;

import java.util.HashSet;
import java.util.Set;

/**
 * 523. 连续的子数组和
 * <p>
 * 给你一个整数数组 nums 和一个整数 k ，编写一个函数来判断该数组是否含有同时满足下述条件的连续子数组：
 * <p>
 * 子数组大小 至少为 2 ，且
 * 子数组元素总和为 k 的倍数。
 * 如果存在，返回 true ；否则，返回 false 。
 * <p>
 * 如果存在一个整数 n ，令整数 x 符合 x = n * k ，则称 x 是 k 的一个倍数。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 109
 * 0 <= sum(nums[i]) <= 231 - 1
 * 1 <= k <= 231 - 1
 *
 * @Author: LH
 * @Date: 2021/6/2 10:59
 */
public class checkSubarraySum {
}

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] preSum = new int[n + 1];
        for (int i = 1; i <= n; ++i) preSum[i] = preSum[i - 1] + nums[i - 1];
        Set<Integer> set = new HashSet<>();
        for (int i = 2; i <= n; i++) {
            set.add(preSum[i - 2] % k);
            if (set.contains(preSum[i] % k)) return true;
        }
        return false;
    }
}