package com.lh.LeetCode.March.March31;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 90. 子集 II
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 *
 * @Author: LH
 * @Date: 2021/3/31 9:31
 */
public class subsetsWithDup {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        Solution1 solution = new Solution1();
        List<List<Integer>> subsets = solution.subsetsWithDup(nums);
        for (List<Integer> subset : subsets) {
            System.out.println(subset.toString());
        }
    }
}

class Solution1 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> tmp = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        dfs(0, nums, tmp, ans);
        return ans;
    }

    /**
     * @param idx  当前决策在输入数组的位置
     * @param nums 输入数组
     * @param tmp  当前方案
     * @param ans  结果集
     */
    private void dfs(int idx, int[] nums, List<Integer> tmp, List<List<Integer>> ans) {
        int len = nums.length;
        if (idx == len) {
            ans.add(new ArrayList<>(tmp));
            return;
        }

        // 记录当前位置的数，并找到等于当前数值的连续一段
        int t = nums[idx];
        int last = idx;
        while (last < len && nums[last] == t) last++;

        // 不选当前位置的元素，直接跳到 last 往下决策
        dfs(last, nums, tmp, ans);

        // 决策选择不同个数的 t 的情况
        for (int i = idx; i < last; i++) {
            tmp.add(nums[i]);
            dfs(last, nums, tmp, ans);
        }

        // 回溯对数值 t 的选择
        for (int i = idx; i < last; i++) {
            tmp.remove(tmp.size() - 1);
        }
    }
}
