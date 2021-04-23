package com.lh.LeetCode.April.April6;

/**
 * 80. 删除有序数组中的重复项 II
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 最多出现两次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * @Author: LH
 * @Date: 2021/4/6 10:07
 */
public class removeDuplicates2 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        Solution2 solution2 = new Solution2();
        int ans = solution2.removeDuplicates(nums);
        for (int i = 0; i < ans; i++) {
            System.out.println(nums[i]);
        }
    }
}

class Solution2 {
    // 如果与遍历位置之前第 k 个数相同，则不进入if，跳过该数字
    public int removeDuplicates(int[] nums) {
        int ans = 0;
        for (int i : nums) {
            // k=2时
            if (ans < 2 || nums[ans - 2] != i)
                nums[ans++] = i;
        }
        return ans;
    }
}
