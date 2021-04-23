package com.lh.LeetCode.February.February21;

import java.util.TreeMap;

/**
 * 1438. 绝对差不超过限制的最长连续子数组
 * 给你一个整数数组 nums ，和一个表示限制的整数 limit，请你返回最长连续子数组的长度，该子数组中的任意两个元素之间的绝对差必须小于或者等于 limit 。
 * 如果不存在满足条件的子数组，则返回 0 。
 * 解决方法：滑动窗口法
 *
 * @Author: LH
 * @Date: 2021/2/21 11:18
 */
public class longestSubarray {
    public static void main(String[] args) {
        int[] nums = {8, 2, 4, 7};
        int limit = 4;
        Solution solution = new Solution();
        int ans = solution.longestSubarray(nums, limit);
        System.out.println(ans);
    }
}

class Solution {
    public int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int left = 0, right = 0;
        int ans = 0;
        while (right < nums.length) {
            //value值作为判断标识，初始值为1，为0时移除不满足条件的left，并使left被动右移
            treeMap.put(nums[right], treeMap.getOrDefault(nums[right], 0) + 1);
            //大于限制条件，则对left的value减1，使其变为0，再通过判断将其删除
            while (treeMap.lastKey() - treeMap.firstKey() > limit) {
                treeMap.put(nums[left], treeMap.get(nums[left]) - 1);
                if (treeMap.get(nums[left]) == 0) {
                    treeMap.remove(nums[left]);
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }
}