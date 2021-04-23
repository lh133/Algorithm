package com.lh.LeetCode.March.March23;

/**
 * 9. 回文数
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 *
 * @Author: LH
 * @Date: 2021/3/23 17:22
 */
public class isPalindrome {
    public static void main(String[] args) {
        int x = 12121;
        Solution solution = new Solution();
        boolean ans = solution.isPalindrome(x);
        System.out.println(ans);
    }
}

class Solution {
    // 翻转后半段数字进行判断
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int reverse = 0;
        while (x > reverse) {
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }
        return x == reverse || x == reverse / 10;
    }
}
