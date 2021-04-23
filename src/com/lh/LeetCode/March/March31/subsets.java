package com.lh.LeetCode.March.March31;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: LH
 * @Date: 2021/3/31 9:52
 */
public class subsets {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Solution solution = new Solution();
        List<List<Integer>> subsets = solution.subsets(nums);
        for (List<Integer> subset : subsets) {
            System.out.println(subset.toString());
        }
    }
}

class Solution {
    List<Integer> tmp = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return ans;
    }

    // 回溯算法
    private void dfs(int cur, int[] nums) {
        // 退出并记录结果
        if (cur == nums.length) {
            ans.add(new ArrayList<>(tmp));
            return;
        }
        // 考虑取边界nums[cur]，临时存放在 tmp 中
        tmp.add(nums[cur]);
        dfs(cur + 1, nums);
        // 考虑不取边界nums[cur]，同时回溯 tmp 的状态
        tmp.remove(tmp.size() - 1);
        dfs(cur + 1, nums);
    }
}