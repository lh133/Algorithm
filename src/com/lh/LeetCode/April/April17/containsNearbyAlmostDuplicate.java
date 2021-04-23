package com.lh.LeetCode.April.April17;

import java.util.TreeSet;

/**
 * 220. 存在重复元素 III
 * 给你一个整数数组 nums 和两个整数 k 和 t 。请你判断是否存在 两个不同下标 i 和 j，
 * 使得 abs(nums[i] - nums[j]) <= t ，同时又满足 abs(i - j) <= k 。
 * 如果存在则返回 true，不存在返回 false。
 *
 * @Author: LH
 * @Date: 2021/4/19 9:48
 */
public class containsNearbyAlmostDuplicate {
}

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            Long u = (long) nums[i];
            // 从 set 中找到小于等于 u 的最大值（小于等于 u 的最接近 u 的数）
            Long l = set.floor(u);
            // 从 ts 中找到大于等于 u 的最小值（大于等于 u 的最接近 u 的数）
            Long r = set.ceiling(u);
            if (l != null && u - l <= t) return true;
            if (r != null && r - u <= t) return true;
            set.add(u);
            if (i >= k) set.remove((long) nums[i - k]);
        }
        return false;
    }
}