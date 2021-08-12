package com.lh.LeetCode.August.August11;

import java.util.HashMap;
import java.util.Map;

/**
 * 446. 等差数列划分 II - 子序列
 * <p>
 * 给你一个整数数组 nums ，返回 nums 中所有 等差子序列 的数目。
 * <p>
 * 如果一个序列中 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该序列为等差序列。
 * <p>
 * 例如，[1, 3, 5, 7, 9]、[7, 7, 7, 7] 和 [3, -1, -5, -9] 都是等差序列。
 * 再例如，[1, 1, 2, 5, 7] 不是等差序列。
 * 数组中的子序列是从数组中删除一些元素（也可能不删除）得到的一个序列。
 * <p>
 * 例如，[2,5,10] 是 [1,2,1,2,4,1,5,10] 的一个子序列。
 * 题目数据保证答案是一个 32-bit 整数。\
 * <p>
 * 提示：
 * <p>
 * 1  <= nums.length <= 1000
 * -231 <= nums[i] <= 231 - 1
 *
 * @Author: LH
 * @Date: 2021/8/12 11:15
 */
public class numberOfArithmeticSlices {
}

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int ans = 0;
        int n = nums.length;
        // 公差范围可能大于int范围，故不使用数组存储
        // dp[i]表示一个以nums[i]结尾的哈希表，哈希表存储为 d:cnt 即公差和子序列个数
        Map<Long, Integer>[] dp = new Map[n];
        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                long d = (long) nums[i] - nums[j];
                int cnt = dp[j].getOrDefault(d, 0);
                ans += cnt;
                dp[i].put(d, dp[i].getOrDefault(d, 0) + cnt + 1);
            }
        }
        return ans;
    }
}