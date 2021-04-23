package com.lh.LeetCode.April.April21;

/**
 * 91. 解码方法
 * 一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：
 * "AAJF" ，将消息分组为 (1 1 10 6)
 * "KJF" ，将消息分组为 (11 10 6)
 * 注意，消息不能分组为  (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。
 * 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。
 * 题目数据保证答案肯定是一个 32 位 的整数。
 *
 * @Author: LH
 * @Date: 2021/4/21 9:38
 */
public class numDecodings {
    public static void main(String[] args) {
        String s = "12";
        System.out.println(new Solution().numDecodings(s));
    }
}

class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        s = " " + s;
        char[] chars = s.toCharArray();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        // i从1开始，跳过了添加的空格，如果有先导0，则不会出现下标为负的情况
        for (int i = 1; i <= n; i++) {
            // 单独一个数字组成一个编码
            int single = chars[i] - '0';
            // 两个数字组成一个编码
            int twice = (chars[i - 1] - '0') * 10 + (chars[i] - '0');
            // single必定为有效值
            if (1 <= single && single <= 9) dp[i] = dp[i - 1];
            // 如果double为有效值，则dp[i]可同时由dp[i - 1]与dp[i - 2]转移而来
            if (10 <= twice && twice <= 26) dp[i] += dp[i - 2];
        }
        return dp[n];
    }
}