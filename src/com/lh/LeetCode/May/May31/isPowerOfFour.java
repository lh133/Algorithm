package com.lh.LeetCode.May.May31;

/**
 * 342. 4的幂
 * 给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4x
 *
 * @Author: LH
 * @Date: 2021/5/31 11:34
 */
public class isPowerOfFour {
    public static void main(String[] args) {
        System.out.println(new Solution().isPowerOfFour(16));
    }
}

/**
 * 4的幂除以 3 的余数一定为 1
 * n 是 4 的幂，那么 n 的二进制表示中有且仅有一个 1，并且这个 1 出现在从低位开始的第偶数个二进制位上
 */
class Solution {
    public boolean isPowerOfFour(int n) {
//        return (n & (n - 1)) == 0 && n % 3 == 1;
        return n > 0 && (n & (n - 1)) == 0 && (n & 0xaaaaaaaa) == 0;
    }
}