package com.lh.LeetCode.April.April9;

/**
 * @Author: LH
 * @Date: 2021/4/9 9:51
 */
public class findMin {
    public static void main(String[] args) {
        int[] nums = {2, 3, 5, 1, 2, 2, 2};
        Solution solution = new Solution();
        int min = solution.findMin(nums);
        System.out.println(min);
    }
}

class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                --right;
            }
        }
        return nums[left];
    }
}