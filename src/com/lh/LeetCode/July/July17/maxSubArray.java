package com.lh.LeetCode.July.July17;

/**
 * 剑指 Offer 42. 连续子数组的最大和
 * <p>
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * <p>
 * 要求时间复杂度为O(n)。
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 10^5
 * -100 <= arr[i] <= 100
 *
 * @Author: LH
 * @Date: 2021/7/17 21:50
 */
public class maxSubArray {
}

class Solution {
    public int maxSubArray(int[] nums) {
        int tmp = 0, ans = nums[0];
        for (int num : nums) {
            tmp = Math.max(tmp + num, num);
            ans = Math.max(ans, tmp);
        }
        return ans;
    }
}