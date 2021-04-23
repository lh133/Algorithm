package com.lh.LeetCode.April.April5;

import java.util.Arrays;

/**
 * 88. 合并两个有序数组
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，
 * 这样它就有足够的空间保存来自 nums2 的元素。
 *
 * @Author: LH
 * @Date: 2021/4/5 22:28
 */
public class merge {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        Solution solution = new Solution();
        solution.merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
}

class Solution {
    // 从末尾向前插入数字
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1;
        int idx = m + n - 1;
        while (i >= 0 || j >= 0) {
            if (i >= 0 && j >= 0) {
                nums1[idx--] = nums1[i] >= nums2[j] ? nums1[i--] : nums2[j--];
            } else if (i >= 0) {
                // 当nums2中的数已经完全放入nums1时，nums2中的数依次放入nums1头部
                nums1[idx--] = nums1[i--];
            } else {
                // 当nums1中的数已经完全放到nums1末尾时，nums中的数依次放入nums1头部
                nums1[idx--] = nums2[j--];
            }
        }
    }
}