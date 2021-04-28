package com.lh.LeetCode.April.April28;

/**
 * 633. 平方数之和
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
 *
 * @Author: LH
 * @Date: 2021/4/28 15:13
 */
public class judgeSquareSum {
    public static void main(String[] args) {
        int c = 15;
        System.out.println(new Solution().judgeSquareSum(c) ? "存在" : "不存在");
    }
}

class Solution {
    // 假定a <= b，使用双指针
    public boolean judgeSquareSum(int c) {
        // 初始化a
        long left = 0;
        // 初始化b
        long right = (long) Math.sqrt(c);
        while (left <= right) {
            long cur = left * left + right * right;
            if (cur == c) return true;
            else if (cur > c) right--;
            else left++;
        }
        return false;
    }
}