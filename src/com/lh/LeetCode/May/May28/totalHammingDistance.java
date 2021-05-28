package com.lh.LeetCode.May.May28;

/**
 * 477. 汉明距离总和
 * 两个整数的 汉明距离 指的是这两个数字的二进制数对应位不同的数量。
 * <p>
 * 计算一个数组中，任意两个数之间汉明距离的总和。
 * 注意:
 * <p>
 * 数组中元素的范围为从 0到 10^9。
 * 数组的长度不超过 10^4。
 *
 * @Author: LH
 * @Date: 2021/5/28 9:40
 */
public class totalHammingDistance {
}

class Solution {
    public int totalHammingDistance(int[] nums) {
        int ans = 0, n = nums.length;
        for (int i = 0; i < 30; ++i) {
            int c = 0;
            for (int val :
                    nums) {
                c += (val >> i) & 1;
            }
            ans += c * (n - c);
        }
        return ans;
    }
}