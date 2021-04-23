package com.lh.LeetCode.April.April23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 368. 最大整除子集
 * 给你一个由 无重复 正整数组成的集合 nums ，请你找出并返回其中最大的整除子集 answer ，子集中每一元素对 (answer[i], answer[j]) 都应当满足：
 * answer[i] % answer[j] == 0 ，或
 * answer[j] % answer[i] == 0
 * 如果存在多个有效解子集，返回其中任何一个均可。
 *
 * @Author: LH
 * @Date: 2021/4/23 17:06
 */
public class largestDivisibleSubset {
    public static void main(String[] args) {
        int[] nums = {9, 18, 54, 90, 108, 180, 360, 540, 720};
        System.out.println(new Solution().largestDivisibleSubset(nums));
    }
}

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        // 记录当前数字能组成的整除子集长度
        int[] f = new int[n];
        // 记录f[i]的状态是由哪个下标转移而来
        int[] g = new int[n];
        for (int i = 0; i < n; i++) {
            // pre保存当前状态的前一个状态
            int len = 1, pre = i;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    if (f[j] + 1 > len) {
                        len = f[j] + 1;
                        pre = j;
                    }
                }
            }
            f[i] = len;
            g[i] = pre;
        }

        // 获取最大长度，并取得下标
        int max = -1, idx = -1;
        for (int i = 0; i < n; i++) {
            if (f[i] > max) {
                idx = i;
                max = f[i];
            }
        }

        // 回溯g，根据g记录的转移路径获取具体的子集
        List<Integer> ans = new ArrayList<>();
        while (ans.size() != max) {
            ans.add(nums[idx]);
            idx = g[idx];
        }
        return ans;
    }
}