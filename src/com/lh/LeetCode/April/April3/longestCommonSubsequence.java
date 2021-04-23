package com.lh.LeetCode.April.April3;

/**
 * 1143. 最长公共子序列
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 *
 * @Author: LH
 * @Date: 2021/4/3 21:27
 */
public class longestCommonSubsequence {
    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        Solution solution = new Solution();
        int ans = solution.longestCommonSubsequence(text1, text2);
        System.out.println("ans:" + ans);
    }

}

class Solution {
    // 定义 dp[i][j] 表示 text1[0:i-1] 和 text2[0:j-1] 的最长公共子序列。
    // 状态转移方程：dp[i][j]=dp[i−1][j−1]+1, 当 text1[i - 1] == text2[j - 1]
    // dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]), 当 text1[i - 1] != text2[j - 1]
    public int longestCommonSubsequence(String text1, String text2) {
        int M = text1.length(), N = text2.length();
        int[][] dp = new int[M + 1][N + 1];
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
                System.out.println(dp[i][j]);
            }
        }
        return dp[M][N];
    }
}
