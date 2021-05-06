package com.lh.LeetCode.May.May5;

/**
 * 740. 删除并获得点数
 * 给你一个整数数组 nums ，你可以对它进行一些操作。
 * <p>
 * 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除每个等于 nums[i] - 1 或 nums[i] + 1 的元素。
 * <p>
 * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
 *
 * @Author: LH
 * @Date: 2021/5/6 15:19
 */
public class deleteAndEarn {
    public static void main(String[] args) {
        int[] nums = {3, 4, 2};
        System.out.println(new Solution().deleteAndEarn(nums));
    }
}

class Solution {
    public int deleteAndEarn(int[] nums) {
        int maxVal = 0;
        for (int num :
                nums) {
            maxVal = Math.max(maxVal, num);
        }
        // 使用sum统计数组相同元素之和
        int[] sum = new int[maxVal + 1];
        for (int val :
                nums) {
            sum[val] += val;
        }
        return Earn(sum);
    }

    private int Earn(int[] sums) {
        int n = sums.length;
        int first = sums[0], second = Math.max(sums[0], sums[1]);
        for (int i = 2; i < n; i++) {
            int temp = second;
            second = Math.max(first + sums[i], second);
            first = temp;
        }
        return second;
    }
}
