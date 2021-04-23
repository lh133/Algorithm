package com.lh.LeetCode.March.March24;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 456. 132 模式
 * 给你一个整数数组 nums ，数组中共有 n 个整数。132 模式的子序列 由三个整数 nums[i]、nums[j] 和 nums[k] 组成，并同时满足：i < j < k 和 nums[i] < nums[k] < nums[j] 。
 * 如果 nums 中存在 132 模式的子序列 ，返回 true ；否则，返回 false 。
 * 进阶：很容易想到时间复杂度为 O(n^2) 的解决方案，你可以设计一个时间复杂度为 O(n logn) 或 O(n) 的解决方案吗？
 * 提示：
 * n == nums.length
 * 1 <= n <= 104
 * -109 <= nums[i] <= 109
 *
 * @Author: LH
 * @Date: 2021/3/24 11:17
 */
public class find132pattern {
    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 4};
        Solution solution = new Solution();
//        boolean ans = solution.find132pattern(nums);
        boolean ans1 = solution.find132pattern1(nums);
//        System.out.println("ans:" + ans);
        System.out.println("\nans1:" + ans1);
    }
}

class Solution {
    // 暴力解法
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        int num_i = nums[0];
        for (int j = 0; j < n - 1; j++) {
            // 提前判断，减少运行时间
            if (nums[j] <= num_i) {
                num_i = nums[j];
                continue;
            }
            for (int k = n - 1; k > j; k--) {
                if (num_i < nums[k] && nums[k] < nums[j])
                    return true;
            }
//            num_i = Math.min(nums[j], num_i);
        }
        return false;
    }

    // 单调栈
    public boolean find132pattern1(int[] nums) {
        int n = nums.length;
        Deque<Integer> desc_stack = new ArrayDeque<>();
        // mid_nums 次大值，代表132中的2
        int mid_nums = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            // 将 nums[i] 与得到的 mid_nums 进行比较，如果小于 mid_nums 则已经找到【1】
            if ((nums[i]) < mid_nums) return true;
            // 栈顶元素比nums[i]小，则说明找到了132中的【2】，弹出栈顶元素，赋值给mid_nums,之后只需要往左循环找到【1】即可
            while (!desc_stack.isEmpty() && desc_stack.peek() < nums[i]) {
                // 栈顶元素比当前的 nums[i] 小，则已找到次大值，赋值即可，次大值取最大，便于找到更小的值
                mid_nums = Math.max(mid_nums, desc_stack.pop());
            }
            desc_stack.push(nums[i]);
        }
        return false;
    }
}