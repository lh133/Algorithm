package com.lh.LeetCode.April.April10;

/**
 * 263. 丑数
 * 给你一个整数 n ，请你判断 n 是否为 丑数 。如果是，返回 true ；否则，返回 false 。
 * 丑数 就是只包含质因数 2、3 和/或 5 的正整数。
 *
 * @Author: LH
 * @Date: 2021/4/12 15:36
 */
public class isUgly {
    public static void main(String[] args) {
        int n = 60;
        Solution solution = new Solution();
        boolean b = solution.isUgly(n);
        System.out.println(b);
    }
}

class Solution {
    public boolean isUgly(int n) {
        if (n <= 0) return false;
        while (n % 2 == 0) n /= 2;
        while (n % 3 == 0) n /= 3;
        while (n % 5 == 0) n /= 3;
        return n == 1;
    }
}
