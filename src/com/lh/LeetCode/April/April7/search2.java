package com.lh.LeetCode.April.April7;

/**
 * 81. 搜索旋转排序数组 II
 * 已知存在一个按非降序排列的整数数组 nums ，数组中的值不必互不相同。
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转 ，
 * 使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
 * 例如， [0,1,2,4,4,4,5,6,6,7] 在下标 5 处经旋转后可能变为 [4,5,6,6,7,0,1,2,4,4] 。
 * 给你 旋转后 的数组 nums 和一个整数 target ，请你编写一个函数来判断给定的目标值是否存在于数组中。
 * 如果 nums 中存在这个目标值 target ，则返回 true ，否则返回 false 。
 *
 * @Author: LH
 * @Date: 2021/4/7 16:28
 */
public class search2 {
    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 3, 3, 3, 3};
        int target = 2;
        Solution2 solution2 = new Solution2();
        boolean ans = solution2.search(nums, target);
        System.out.println(ans ? "存在" : "不存在");
    }
}

class Solution2 {
    // 在非重复元素的查找基础上，当 nums[left] == nums[mid] == nums[right]时
    // 将当前二分区间的左边界加一，右边界减一，跳过相同元素，然后在新区间上继续二分查找。
    public boolean search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0)
            return false;
        if (len == 1)
            return nums[0] == target;
        int left = 0, right = len - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                ++left;
                --right;
            } else if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[len - 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }
}