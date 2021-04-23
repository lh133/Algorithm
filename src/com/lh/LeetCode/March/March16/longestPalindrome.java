package com.lh.LeetCode.March.March16;

/**
 * 5. 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 提示：
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母（大写和/或小写）组成
 *
 * @Author: LH
 * @Date: 2021/3/16 22:00
 */
public class longestPalindrome {
    public static void main(String[] args) {
        String s = "babad";
        Solution1 solution1 = new Solution1();
        String ans = solution1.longestPalindrome(s);
        System.out.println(ans);
    }
}

class Solution1 {
    //暴力解法
    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        if (len == 1)
            return s;

        //最长回文串的长度
        int maxLen = 1;
        // 最长回文串开始位置的下标
        int start = 0;

        //枚举所有长度大于1的字串
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (j - i + 1 > maxLen && validPalindromic(chars, i, j)) {
                    maxLen = j - i + 1;
                    start = i;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }

    /**
     * 验证子串 s[left..right] 是否为回文串
     *
     * @param charArray 要判断的字符数组
     * @param left      左边界
     * @param right     右边界
     */
    private boolean validPalindromic(char[] charArray, int left, int right) {
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // 动态规划解法
    public String longestPalindrome1(String s) {
        int len = s.length();
        if (len == 1)
            return s;

        //最长回文串的长度
        int maxLen = 1;
        // 最长回文串开始位置的下标
        int start = 0;

        // dp[i][i]表示s[i][j]是否是回文串
        boolean[][] dp = new boolean[len][len];
        char[] chars = s.toCharArray();

        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (chars[i] != chars[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要 dp[i][j] == true 成立，就表示子串 s[i..j] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    start = i;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }
}