package com.lh.LeetCode.April.April18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 *
 * @Author: LH
 * @Date: 2021/4/19 10:39
 */
public class threeSum {
}

// 首先对数组进行排序，排序后固定一个数 nums[i]nums[i]，再使用左右指针指向 nums[i]nums[i]后面的两端，
// 数字分别为 nums[L]nums[L] 和 nums[R]nums[R]，计算三个数的和 sum 判断是否满足为 0，满足则添加进结果集
class Solution2 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 3) return ans;
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            // 如果三数中最小的数nums[i]>0,则一定不满足条件
            if (nums[i] > 0) break;
            // 去掉重复值
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1;
            int r = n - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    // 去重
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    while (r > l && nums[r] == nums[r - 1]) r--;
                    l++;
                    r--;
                } else if (sum < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return ans;
    }
}