package com.lh.LeetCode.May.May24;

/**
 * 664. 奇怪的打印机
 * 有台奇怪的打印机有以下两个特殊要求：
 * <p>
 * 打印机每次只能打印由 同一个字符 组成的序列。
 * 每次可以在任意起始和结束位置打印新字符，并且会覆盖掉原来已有的字符。
 * 给你一个字符串 s ，你的任务是计算这个打印机打印它需要的最少打印次数。
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 100
 * s 由小写英文字母组成
 *
 * @Author: LH
 * @Date: 2021/5/24 16:50
 */
public class strangePrinter {
    public static void main(String[] args) {
        String s = "aacacbbb";
        System.out.println(new Solution().strangePrinter(s));// 4
    }
}

// 动态规划
// f[i][j] 表示打印完成区间 [i,j] 的最少操作数。
class Solution {
    public int strangePrinter(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; --i) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; ++j) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i][j - 1];
                } else {
                    int minCnt = Integer.MAX_VALUE;
                    for (int k = i; k < j; ++k) {
                        minCnt = Math.min(minCnt, dp[i][k] + dp[k + 1][j]);
                    }
                    dp[i][j] = minCnt;
                }
            }
        }
        return dp[0][n - 1];
    }
}