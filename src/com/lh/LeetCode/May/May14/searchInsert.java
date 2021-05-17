package com.lh.LeetCode.May.May14;

/**
 * 35. 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 你可以假设数组中无重复元素。
 *
 * @Author: LH
 * @Date: 2021/5/14 10:15
 */
public class searchInsert {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        System.out.println(new Solution3().searchInsert(nums, 5));
    }
}

class Solution3 {
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r + 1) >> 1;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}