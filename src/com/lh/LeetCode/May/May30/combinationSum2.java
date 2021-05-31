package com.lh.LeetCode.May.May30;

import java.util.*;

/**
 * 40. 组合总和 II
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用一次。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。
 *
 * @Author: LH
 * @Date: 2021/5/31 11:03
 */
public class combinationSum2 {
    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        System.out.println(new Solution2().combinationSum2(candidates, 8));
    }
}

class Solution2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int n = candidates.length;
        // 接收结果
        List<List<Integer>> ans = new ArrayList<>();
        if (n == 0) return ans;

        // 先进行排序
        Arrays.sort(candidates);
        // 查找路径
        Deque<Integer> path = new ArrayDeque<>(n);
        // 回溯
        backtrack(candidates, n, 0, target, path, ans);
        return ans;
    }

    /**
     * 回溯算法
     *
     * @param candidates 候选数组
     * @param length     数组长度
     * @param begin      开始搜索的数组位置的下标
     * @param target     查找的目标值，随递归加深而变化
     * @param path       搜索路径
     * @param ans        结果集
     */
    private void backtrack(int[] candidates, int length, int begin, int target, Deque<Integer> path, List<List<Integer>> ans) {
        // 递归退出条件
        if (target == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < length; i++) {
            // 剪枝，减去 candidates[i] 小于 0，减去后面的 candidates[i + 1] 肯定也小于 0（数组经过排序）
            if (target - candidates[i] < 0) break;
            // 去重，且保留处于不同递归层级上的相同值
            if (i > begin && candidates[i] == candidates[i - 1]) continue;
            path.addLast(candidates[i]);
//            System.out.println("递归之前 => " + path + "，剩余target = " + (target - candidates[i]));
            // 元素不可重复，故从i+1开始
            backtrack(candidates, length, i + 1, target - candidates[i], path, ans);
            // 不满足条件，回溯
            path.removeLast();
//            System.out.println("递归之后 => " + path + "，剩余target = " + (target - candidates[i]));
        }
    }
}