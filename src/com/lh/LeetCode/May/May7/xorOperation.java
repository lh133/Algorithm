package com.lh.LeetCode.May.May7;

/**
 * 1486. 数组异或操作
 * 给你两个整数，n 和 start 。
 * <p>
 * 数组 nums 定义为：nums[i] = start + 2*i（下标从 0 开始）且 n == nums.length 。
 * <p>
 * 请返回 nums 中所有元素按位异或（XOR）后得到的结果。
 *
 * @Author: LH
 * @Date: 2021/5/7 9:32
 */
public class xorOperation {
}

class Solution {
    public int xorOperation(int n, int start) {
        int[] nums = new int[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = start + 2 * i;
            ans ^= nums[i];
        }
        return ans;
    }
}