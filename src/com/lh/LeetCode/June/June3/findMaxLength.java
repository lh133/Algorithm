package com.lh.LeetCode.June.June3;

import java.util.HashMap;
import java.util.Map;

/**
 * 525. 连续数组
 * <p>
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * nums[i] 不是 0 就是 1
 *
 * @Author: LH
 * @Date: 2021/6/3 9:42
 */
public class findMaxLength {
    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 1, 0, 1, 0, 1};
        System.out.println(new Solution().findMaxLength(nums));
    }
}

class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int[] preSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + (nums[i - 1] == 1 ? 1 : -1);
        }
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        for (int i = 2; i <= n; i++) {
            if (!map.containsKey(preSum[i - 2])) map.put(preSum[i - 2], i - 2);
            if (map.containsKey(preSum[i])) ans = Math.max(ans, i - map.get(preSum[i]));
        }
        return ans;
    }
}