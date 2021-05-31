package com.lh.LeetCode.May.May30;

/**
 * 231. 2 的幂
 * 给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 如果存在一个整数 x 使得 n == 2x ，则认为 n 是 2 的幂次方。
 *
 * @Author: LH
 * @Date: 2021/5/31 10:48
 */
public class isPowerOfTwo {

}

/**
 * 一个数 n 是 2 的幂，当且仅当 n 是正整数，并且 n 的二进制表示中仅包含 1 个 1
 * n & -n 移除最低位的 1
 * n & (n + 1) 获取最低位的 1
 */
class Solution {
    public boolean isPowerOfTwo(int n) {
//        return n > 0 && (n & -n) == n;
        return n > 0 && (n & (n + 1)) == 0;
    }
}
