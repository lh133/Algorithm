package com.lh.LeetCode.June.June23;

/**
 * 剑指 Offer 15. 二进制中1的个数
 * <p>
 * 请实现一个函数，输入一个整数（以二进制串形式），输出该数二进制表示中 1 的个数。
 * 例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
 * <p>
 * 提示：
 * <p>
 * 输入必须是长度为 32 的 二进制串 。
 *
 * @Author: LH
 * @Date: 2021/6/23 9:17
 */
public class hammingWeight {
}

class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n &= n - 1;
            count++;
        }
        return count;
    }
}