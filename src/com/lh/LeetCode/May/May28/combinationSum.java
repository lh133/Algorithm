package com.lh.LeetCode.May.May28;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 39. 组合总和
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 *
 * @Author: LH
 * @Date: 2021/5/28 16:28
 */
public class combinationSum {
    public static void main(String[] args) {
        int[] candidates = {1, 2, 3, 4, 6, 7, 8, 9, 11, 22, 12, 13};
        System.out.println(new Solution2().combinationSum(candidates, 22));
    }
}

class Solution2 {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        long start = System.nanoTime();
        Arrays.sort(candidates);
        List<Integer> track = new ArrayList<>();
        backtrack(candidates, target, 0, track);
//        System.out.println(System.nanoTime() - start);//打印执行时间
        return ans;
    }

    /**
     * 回溯法找组合，无重复元素1所以不需要去重
     *
     * @param candidates 原数组
     * @param target     目标值
     * @param start      开始搜索的数组索引
     * @param track      当前搜索路径
     */
    private void backtrack(int[] candidates, int target, int start, List<Integer> track) {
        if (target == 0) {
            ans.add(new ArrayList<>(track));
            return;
        }
        for (int i = start; i < candidates.length; ++i) {
            // 元素经过排序，target - 当前元素 < 0,则减去后面的元素都会小于0
            if (target - candidates[i] < 0) break;
            track.add(candidates[i]);
            // 将i作为start，实现剪枝
            backtrack(candidates, target - candidates[i], i, track);
            track.remove(track.size() - 1);
        }
    }
}