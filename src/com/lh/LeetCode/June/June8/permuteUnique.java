package com.lh.LeetCode.June.June8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 47. 全排列 II
 * <p>
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 *
 * @Author: LH
 * @Date: 2021/6/8 16:17
 */
public class permuteUnique {
}

class Solution4 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums, ans, 0, res, visited);
        return ans;
    }

    private void backtrack(int[] nums, List<List<Integer>> ans, int start,
                           List<Integer> res, boolean[] visited) {
        if (start == nums.length) {
            ans.add(new ArrayList<>(res));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && visited[i - 1])) continue;
            res.add(nums[i]);
            visited[i] = true;
            backtrack(nums, ans, start + 1, res, visited);
            // 回溯
            visited[i] = false;
            res.remove(start);
        }
    }
}