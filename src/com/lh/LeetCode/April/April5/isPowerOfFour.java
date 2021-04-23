package com.lh.LeetCode.April.April5;

/**
 * 342. 4的幂
 * 给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；否则，返回 false 。
 * 整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4x
 *
 * @Author: LH
 * @Date: 2021/4/5 22:54
 */
public class isPowerOfFour {
    public static void main(String[] args) {
        int n = 16;
        Solution1 solution1 = new Solution1();
        boolean ans = solution1.isPowerOfFour(n);
        System.out.println(ans);
    }
}

class Solution1 {
    public boolean isPowerOfFour(int n) {
        return (n >= 0) && ((n & (n - 1)) == 0) && (n % 3 == 1);
    }
}
