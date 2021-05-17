package com.lh.LeetCode.May.May14;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * <p>
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * <p>
 * 进阶：
 * <p>
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 *
 * @Author: LH
 * @Date: 2021/5/14 9:54
 */
public class searchRange {
}

class Solution2 {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int[] ans = new int[]{-1, -1};
        if (n == 0) return ans;

        // 使用两次二分查找，分别找到数字开始和结束的位置
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        if (nums[l] != target) {
            return ans;
        } else {
            ans[0] = l;
            l = 0;
            r = n - 1;
            while (l < r) {
                int mid = (l + r + 1) >> 1;
                if (nums[mid] <= target) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
        }
        ans[1] = l;
        return ans;
    }
}