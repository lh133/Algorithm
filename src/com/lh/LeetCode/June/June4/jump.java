package com.lh.LeetCode.June.June4;

/**
 * 45. 跳跃游戏 II
 * <p>
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * <p>
 * 假设你总是可以到达数组的最后一个位置。
 * <p>
 * 提示:
 * <p>
 * 1 <= nums.length <= 1000
 * 0 <= nums[i] <= 105
 *
 * @Author: LH
 * @Date: 2021/6/4 10:12
 */
public class jump {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(new Solution2().jump(nums));
    }
}

class Solution2 {
    public int jump(int[] nums) {
        int n = nums.length;
        // 上次跳跃能到达的最远距离
        int end = 0;
        // 当前跳跃能到达的最远距离
        int maxPosition = 0;
        // 统计步数
        int ans = 0;
        for (int i = 0; i < n - 1; ++i) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            // 到达上次跳跃能到达的右边界
            if (i == end) {
                // 到达右边界
                end = maxPosition;
                // 统计步数
                ans++;
            }
        }
        return ans;
    }
}