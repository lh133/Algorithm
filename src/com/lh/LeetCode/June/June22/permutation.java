package com.lh.LeetCode.June.June22;

import java.util.*;

/**
 * 剑指 Offer 38. 字符串的排列
 * <p>
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * <p>
 * 限制：
 * 1 <= s 的长度 <= 8
 *
 * @Author: LH
 * @Date: 2021/6/22 9:39
 */
public class permutation {
}

// 回溯算法
class Solution {
    List<String> res;
    boolean[] visited;

    public String[] permutation(String s) {
        int n = s.length();
        res = new ArrayList<>();
        visited = new boolean[n];
        char[] cs = s.toCharArray();
        Arrays.sort(cs);
        StringBuffer perm = new StringBuffer();
        backtrack(cs, 0, n, perm);
        int size = res.size();
        String[] ans = new String[size];
        for (int i = 0; i < size; i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    private void backtrack(char[] cs, int i, int n, StringBuffer perm) {
        if (i == n) {
            res.add(perm.toString());
            return;
        }
        for (int j = 0; j < n; j++) {
            if (visited[j] || (j > 0 && !visited[j - 1] && cs[j - 1] == cs[j])) {
                continue;
            }
            visited[j] = true;
            perm.append(cs[j]);
            backtrack(cs, i + 1, n, perm);
            perm.deleteCharAt(perm.length() - 1);
            visited[j] = false;
        }
    }
}