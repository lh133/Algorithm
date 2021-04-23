package com.lh.LeetCode.March.March6;

import java.util.Arrays;
import java.util.Stack;

/**
 * 503. 下一个更大元素 II
 * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。
 * 数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。
 * 如果不存在，则输出 -1。
 * 注意: 输入数组的长度不会超过 10000。
 *
 * @Author: LH
 * @Date: 2021/3/6 12:52
 */
public class nextGreaterElements {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        Solution solution = new Solution();
        int[] ans = solution.nextGreaterElements(nums);
        System.out.println(Arrays.toString(ans));
    }
}

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        Arrays.fill(ans, -1);
        // 定义一个单调栈，单调不升，保存数组下标
        Stack<Integer> stack = new Stack<>();
        // 最多两次循环nums数组即可得出结果
        for (int i = 0; i < 2 * len; ++i) {
            // 单调栈非空且nums大于栈顶保存的下标对应的数组元素时，将栈顶元素弹出并保存对应的nums到结果数组内
            while (!stack.isEmpty() && nums[i % len] > nums[stack.peek()]) {
                ans[stack.pop()] = nums[i % len];
            }
            // 入栈
            stack.push(i % len);
        }
        return ans;
    }
}