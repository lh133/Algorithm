package com.lh.LeetCode.March.March1;

/**
 * 303. 区域和检索 - 数组不可变
 * 给定一个整数数组  nums，求出数组从索引 i 到 j（i ≤ j）范围内元素的总和，包含 i、j 两点。
 * 实现 NumArray 类：
 * NumArray(int[] nums) 使用数组 nums 初始化对象
 * int sumRange(int i, int j) 返回数组 nums 从索引 i 到 j（i ≤ j）范围内元素的总和，包含 i、j 两点（也就是 sum(nums[i], nums[i + 1], ... , nums[j])）
 * 解决方法：前缀和
 *
 * @Author: LH
 * @Date: 2021/3/1 17:13
 */
public class NumArray {

    private final int[] preSum;

    public NumArray(int[] nums) {
        int len = nums.length;
        preSum = new int[len + 1];
        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return preSum[j + 1] - preSum[i];
    }
}

class main {
    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        int[] i_area = {0, 2, 0};
        int[] j_area = {2, 5, 5};
        int i, j;
        for (int k = 0; k < i_area.length; k++) {
            i = i_area[k];
            j = j_area[k];
            NumArray obj = new NumArray(nums);
            int ans = obj.sumRange(i, j);
            System.out.println(ans);
        }

    }
}