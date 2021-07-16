package com.lh.LeetCode.July.July16;

/**
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * <p>
 * 统计一个数字在排序数组中出现的次数。
 * <p>
 * 限制：
 * <p>
 * 0 <= 数组长度 <= 50000
 *
 * @Author: LH
 * @Date: 2021/7/16 16:31
 */
public class search {
}

class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return 0;
        // 记录target的左右边界
        int lBorder, rBorder;

        int left = 0, right = n - 1;

        // 二分寻找第一次出现target的下标
        while (left < right) {
            int mid = left + right >> 1;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (nums[right] != target) return 0;
        lBorder = right;

        // 二分寻找target最后一次出现的位置
        left = 0;
        right = n - 1;
        while (left < right) {
            int mid = left + right + 1 >> 1;
            if (nums[mid] <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
//        if (nums[right] != target) return 0;
        rBorder = right;

        return rBorder - lBorder + 1;
    }
}