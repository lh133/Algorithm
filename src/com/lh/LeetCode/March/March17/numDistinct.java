package com.lh.LeetCode.March.March17;

/**
 * 115. 不同的子序列
 * 给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。
 * 字符串的一个 子序列 是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
 * 题目数据保证答案符合 32 位带符号整数范围。
 * 提示：
 * 0 <= s.length, t.length <= 1000
 * s 和 t 由英文字母组成
 *
 * @Author: LH
 * @Date: 2021/3/18 22:18
 */
public class numDistinct {
    public static void main(String[] args) {
        String s = "rabbbit";
        String t = "rabbit";
        Solution solution = new Solution();
        int ans = solution.numDistinct(s, t);
        System.out.println(ans);
    }
}

class Solution {
    // 动态规划
    public int numDistinct(String s, String t) {
        // 技巧：往原字符头部插入空格，这样得到 char 数组是从 1 开始
        // 同时由于往头部插入相同的（不存在的）字符，不会对结果造成影响，而且可以使得 f[i][0] = 1，可以将 1 这个结果滚动下去
        int n = s.length(), m = t.length();
        s = " " + s;
        t = " " + t;
        char[] cs = s.toCharArray(), ct = t.toCharArray();
        // f(i,j) 代表考虑「s 中的下标为 0~i 字符」和「t 中下标为 0~j 字符」是否匹配
        int[][] f = new int[n + 1][m + 1];
        // 原字符只有小写字符，当往两个字符插入空格之后，f[i][0] = 1 是一个显而易见的初始化条件
        for (int i = 0; i <= n; i++) f[i][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // 包含两种决策：
                // 不使用 cs[i] 进行匹配，则有 f[i][j] = f[i - 1][j]
                f[i][j] = f[i - 1][j];
                // 使用 cs[i] 进行匹配，则要求 cs[i] == ct[j]，然后有  f[i][j] += f[i - 1][j - 1]
                if (cs[i] == ct[j]) {
                    f[i][j] += f[i - 1][j - 1];
                }
            }
        }
        return f[n][m];
    }
}
