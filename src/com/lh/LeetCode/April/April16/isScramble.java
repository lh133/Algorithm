package com.lh.LeetCode.April.April16;

/**
 * 87. 扰乱字符串
 * 使用下面描述的算法可以扰乱字符串 s 得到字符串 t ：
 * 如果字符串的长度为 1 ，算法停止
 * 如果字符串的长度 > 1 ，执行下述步骤：
 * 在一个随机下标处将字符串分割成两个非空的子字符串。即，如果已知字符串 s ，则可以将其分成两个子字符串 x 和 y ，且满足 s = x + y 。
 * 随机 决定是要「交换两个子字符串」还是要「保持这两个子字符串的顺序不变」。即，在执行这一步骤之后，s 可能是 s = x + y 或者 s = y + x 。
 * 在 x 和 y 这两个子字符串上继续从步骤 1 开始递归执行此算法。
 * 给你两个 长度相等 的字符串 s1 和 s2，判断 s2 是否是 s1 的扰乱字符串。如果是，返回 true ；否则，返回 false 。
 *
 * @Author: LH
 * @Date: 2021/4/16 11:44
 */
public class isScramble {
    public static void main(String[] args) {

    }
}

/**
 * 记忆化搜索
 */
class Solution {
    // -1 表示 false，1 表示 true，0 表示未计算
    int N = -1, Y = 1, EMPTY = 0;
    // 字符串长度
    int n;
    // cache[i][j][n] 表示从s1从i开始长度为n的字串与s2从j开始长度为n的字串是否互为扰乱
    int[][][] cache;
    // 定义全局变量供功能函数调用
    String s1;
    String s2;

    public boolean isScramble(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;
        if (s1.equals(s2)) return true;
        if (s1.length() != s2.length()) return false;

        n = s1.length();
        cache = new int[n][n][n + 1];
        return dfs(0, 0, n);
    }

    /**
     * @param i   s1子串开始位置
     * @param j   s2子串开始位置
     * @param len 子串长度
     * @return 是否互为扰乱字符串
     */
    private boolean dfs(int i, int j, int len) {
        if (cache[i][j][len] != EMPTY) return cache[i][j][len] == Y;
        String S = s1.substring(i, i + len), T = s2.substring(j, j + len);
        if (S.equals(T)) {
            cache[i][j][len] = Y;
            return true;
        }
        // 在进行详细比较前，检查词频以减少递归消耗
        if (!check(S, T)) {
            cache[i][j][len] = N;
            return false;
        }

        for (int k = 1; k < len; k++) {
            // 对应 s1 的 [0,i) & [i,n) 匹配 s2 的 [0,i) & [i,n)
            if (dfs(i, j, k) && dfs(i + k, j + k, len - k)) {
                cache[i][j][len] = Y;
                return true;
            }
            // 对应 s1 的 [0,i) & [i,n) 匹配 s2 的 [n-i,n) & [0,n-i)
            if (dfs(i, j + len - k, k) && dfs(i + k, j, len - k)) {
                cache[i][j][len] = Y;
                return true;
            }
        }
        cache[i][j][len] = N;
        return false;
    }

    // 检查 s1 和 s2 词频是否相同
    private boolean check(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int[] cnt1 = new int[26], cnt2 = new int[26];
        char[] cs1 = s1.toCharArray(), cs2 = s2.toCharArray();
        for (int i = 0; i < s1.length(); i++) {
            cnt1[cs1[i] - 'a']++;
            cnt2[cs2[i] - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (cnt1[i] != cnt2[i]) return false;
        }
        return true;
    }
}

/**
 * 动态规划解法
 */
class Solution2 {
    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) return true;
        if (s1.length() != s2.length()) return false;
        int n = s1.length();
        // 转成字符数组方便循环
        char[] c1 = s1.toCharArray(), c2 = s2.toCharArray();
        boolean[][][] dp = new boolean[n][n][n + 1];

        // len=1时单独讨论
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j][1] = c1[i] == c2[j];
            }
        }

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                for (int j = 0; j <= n - len; j++) {
                    for (int k = 1; k < len; k++) {
                        // 对应 s1 的 [0,i) & [i,n) 匹配 s2 的 [0,i) & [i,n)
                        boolean condition1 = dp[i][j][k] && dp[i + k][j + k][len - k];
                        // 对应 s1 的 [0,i) & [i,n) 匹配 s2 的 [n-i,n) & [0,n-i)
                        boolean condition2 = dp[i][j + len - k][k] && dp[i + k][j][len - k];
                        if (condition1 || condition2) {
                            dp[i][j][len] = true;
                        }
                    }
                }
            }
        }
        return dp[0][0][n];
    }
}