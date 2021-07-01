package com.lh.LeetCode.June.June26;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. 组合
 * <p>
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * @Author: LH
 * @Date: 2021/6/26 22:27
 */
public class combine {
}

class Solution2 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        if (n < k || k <= 0) return ans;
        List<Integer> path = new ArrayList<>();
        backtrack(n, k, 1, path, ans);
        return ans;
    }

    /**
     * 回溯
     *
     * @param n     输入
     * @param k     输入
     * @param start 开始的位置，题目从1开始
     * @param path  路径
     * @param ans   结果集
     */
    private void backtrack(int n, int k, int start, List<Integer> path, List<List<Integer>> ans) {
        if (path.size() == k) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i <= n; i++) {
            path.add(i);
            backtrack(n, k, i + 1, path, ans);
            path.remove(path.size() - 1);
        }
    }
}