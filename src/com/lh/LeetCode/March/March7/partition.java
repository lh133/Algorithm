package com.lh.LeetCode.March.March7;

import java.util.*;

/**
 * 131. 分割回文串
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 * 回文串 是正着读和反着读都一样的字符串。
 * 提示：
 * 1 <= s.length <= 16
 * s 仅由小写英文字母组成
 *
 * @Author: LH
 * @Date: 2021/3/7 20:07
 */
public class partition {
    public static void main(String[] args) {
        String s = "aab";
        Solution1 solution = new Solution1();
        List<List<String>> partition = solution.partition(s);
        System.out.println(Arrays.toString(partition.toArray()));
    }
}

class Solution1 {
    public List<List<String>> partition(String s) {
        int len = s.length();
        ArrayList<List<String>> solution = new ArrayList<>();
        if (len == 0) return solution;

        char[] charArray = s.toCharArray();
        // 动态规划进行预处理
        boolean[][] dp = new boolean[len][len];
        for (int right = 0; right < len; ++right) {
            for (int left = 0; left <= right; ++left) {
                if (charArray[left] == charArray[right] && (right - left <= 2 || dp[left + 1][right - 1]))
                    dp[left][right] = true;
            }
        }

        Deque<String> stack = new ArrayDeque<>();
        dfs(s, 0, len, dp, stack, solution);
        return solution;
    }

    private void dfs(String s, int index, int len, boolean[][] dp, Deque<String> path, List<List<String>> solution) {
        if (index == len) {
            solution.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < len; ++i) {
            if (dp[index][i]) {
                path.addLast(s.substring(index, i + 1));
                dfs(s, i + 1, len, dp, path, solution);
                path.removeLast();
            }
        }
    }
}