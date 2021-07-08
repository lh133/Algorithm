package com.lh.LeetCode.July.July8;

import java.util.HashMap;
import java.util.Map;

/**
 * 930. 和相同的二元子数组
 * <p>
 * 给你一个二元数组 nums ，和一个整数 goal ，请你统计并返回有多少个和为 goal 的 非空 子数组。
 * <p>
 * 子数组 是数组的一段连续部分。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 3 * 104
 * nums[i] 不是 0 就是 1
 * 0 <= goal <= nums.length
 *
 * @Author: LH
 * @Date: 2021/7/8 9:17
 */
public class numSubarraysWithSum {
}

class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int preSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int num : nums) {
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
            preSum += num;
            ans += map.getOrDefault(preSum - goal, 0);
        }
        return ans;
    }
}