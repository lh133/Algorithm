package com.lh.LeetCode.April.April18;

/**
 * 26. 删除有序数组中的重复项
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * @Author: LH
 * @Date: 2021/4/19 10:13
 */
public class removeDuplicates {
}

class Solution {
    public int removeDuplicates(int[] nums) {
        int idx = 0;
        for (int num :
                nums) {
            if (idx < 1 || nums[idx - 1] != num)
                nums[idx++] = num;
        }
        return idx;
    }
}