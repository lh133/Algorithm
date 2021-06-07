package com.lh.LeetCode.June.June6;

/**
 * 474. 一和零
 * <p>
 * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
 * <p>
 * 请你找出并返回 strs 的最大子集的大小，该子集中 最多 有 m 个 0 和 n 个 1 。
 * <p>
 * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
 * <p>
 * 提示：
 * <p>
 * 1 <= strs.length <= 600
 * 1 <= strs[i].length <= 100
 * strs[i] 仅由 '0' 和 '1' 组成
 * 1 <= m, n <= 100
 *
 * @Author: LH
 * @Date: 2021/6/7 9:58
 */
public class findMaxForm {
}

class Solution {
    /**
     * 动态规划
     *
     * @param strs 二进制字符串数组
     * @param m    0的最大个数
     * @param n    1的最大个数
     * @return 子数组最大长度
     */
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        // 预处理出每个字符串中0和1的个数
        int[][] cnt = new int[len][2];
        for (int i = 0; i < len; i++) {
            int zero = 0, one = 0;
            for (char c :
                    strs[i].toCharArray()) {
                if (c == '0') zero++;
                else one++;
            }
            cnt[i] = new int[]{zero, one};
        }

        // 处理第一个字符串的情况
        int[][][] dp = new int[len][m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                dp[0][i][j] = (i >= cnt[0][0] && j >= cnt[0][1]) ? 1 : 0;
            }
        }

        // 考虑其余字符串
        for (int i = 1; i < len; i++) {
            int zero = cnt[i][0], one = cnt[i][1];
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    int a = dp[i - 1][j][k];
                    int b = (j >= zero && k >= one) ? dp[i - 1][j - zero][k - one] + 1 : 0;
                    dp[i][j][k] = Math.max(a, b);
                }
            }
        }
        return dp[len - 1][m][n];
    }
}