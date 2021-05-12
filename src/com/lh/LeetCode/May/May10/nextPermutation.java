package com.lh.LeetCode.May.May10;

/**
 * 31. 下一个排列
 * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * <p>
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * <p>
 * 必须 原地 修改，只允许使用额外常数空间。
 *
 * @Author: LH
 * @Date: 2021/5/10 16:46
 */
public class nextPermutation {
}

class Solution5 {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        // 从后向前查找第一个非降序的相邻数据对
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            // 找到i右侧降序序列中比i大的值，进行交换
            while (j >= 0 && nums[i] >= nums[j])
                j--;
            swap(nums, i, j);
        }
        // 反转i之后的区间
        reverse(nums, i + 1);
    }

    /**
     * 交换数组中的两个数
     *
     * @param nums 数组
     * @param i    待交换数字的下标
     * @param j    待交换数字的下标
     */
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    /**
     * 反转数组的后面一段
     *
     * @param nums  数组
     * @param start 开始位置的下标
     */
    private void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}