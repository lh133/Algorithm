package com.lh.LeetCode.May.May27;

/**
 * 461. 汉明距离
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 * <p>
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 * <p>
 * 注意：
 * 0 ≤ x, y < 231.
 *
 * @Author: LH
 * @Date: 2021/5/27 10:50
 */
public class hammingDistance {
}

class Solution {
    int lowBit(int x) {
        return x & -x;
    }

    public int hammingDistance(int x, int y) {
        int ans = 0;
        for (int i = x ^ y; i > 0; i -= lowBit(i)) {
            ans++;
        }
        return ans;
    }
}