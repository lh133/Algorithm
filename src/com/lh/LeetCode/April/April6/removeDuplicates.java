package com.lh.LeetCode.April.April6;

/**
 * 26. 删除有序数组中的重复项
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * 说明：
 * 为什么返回数值是整数，但输出的答案是数组呢？
 * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 * 你可以想象内部操作如下:
 * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
 * int len = removeDuplicates(nums);
 * <p>
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
 * for (int i = 0; i < len; i++) {
 *     print(nums[i]);
 * }
 *
 * @Author: LH
 * @Date: 2021/4/6 9:39
 */
public class removeDuplicates {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        Solution solution = new Solution();
        int ans = solution.removeDuplicates(nums);
        for (int i = 0; i < ans; i++) {
            System.out.println(nums[i]);
        }
    }
}

class Solution {
    // 如果与遍历位置之前第 k 个数相同，则不进入if，跳过该数字
    public int removeDuplicates(int[] nums) {
        int ans = 0;
        for (int i : nums) {
            // k=1时
            if (ans < 1 || nums[ans - 1] != i)
                nums[ans++] = i;
        }
        return ans;
    }
}