package com.lh.LeetCode.April.April15;

/**
 * 213. 打家劫舍 II
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，
 * 这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额。
 *
 * @Author: LH
 * @Date: 2021/4/15 16:56
 */
public class rob2 {
    public static void main(String[] args) {

    }
}

class Solution2 {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return 0;
        if (n == 1)
            return nums[0];
        else if (n == 2)
            return Math.max(nums[0], nums[1]);
        // 分别对应取第一个数和不取第一个数的情况
        return Math.max(robRange(nums, 0, n - 2), robRange(nums, 1, n - 1));
    }

    /**
     * 划定偷窃范围，算出其最大金额
     *
     * @param nums  待偷窃的数组
     * @param start 开始位置的下标
     * @param end   结束位置的下标
     * @return 能偷到的最大金额
     */
    private int robRange(int[] nums, int start, int end) {
        int first = nums[start], second = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i < end; i++) {
            int tmp = second;
            second = Math.max(first + nums[i], second);
            first = tmp;
        }
        return second;
    }
}