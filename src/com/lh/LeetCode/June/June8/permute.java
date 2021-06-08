package com.lh.LeetCode.June.June8;

import java.util.*;

/**
 * 46. 全排列
 * <p>
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * nums 中的所有整数 互不相同
 *
 * @Author: LH
 * @Date: 2021/6/8 15:38
 */
public class permute {
}

class Solution3 {
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> res = new ArrayList<>();
        for (int num :
                nums) {
            res.add(num);
        }

        backtrack(n, res, ans, 0);
        return ans;
    }

    /**
     * dfs，回溯
     *
     * @param len   数组长度
     * @param res   搜索中间值
     * @param ans   结果
     * @param start 开始回溯位置
     */
    private void backtrack(int len, List<Integer> res, List<List<Integer>> ans, int start) {
        if (start == len) ans.add(new LinkedList<>(res));// 获取拷贝
        for (int i = start; i < len; i++) {
            // 动态维护数组，交换两个数
            Collections.swap(res, start, i);
            // 继续搜索下一个数
            backtrack(len, res, ans, start + 1);
            // 回溯
            Collections.swap(res, start, i);
        }
    }
}