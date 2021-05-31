package com.lh.LeetCode.May.May29;

import java.util.HashMap;
import java.util.Map;

/**
 * 560. 和为K的子数组
 * <p>
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 * <p>
 * 说明 :
 * <p>
 * 数组的长度为 [1, 20,000]。
 * 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 *
 * @Author: LH
 * @Date: 2021/5/31 9:25
 */
public class subarraySum {
    public static void main(String[] args) {
        int[] nums = {1,1,1};
        System.out.println(new Solution().subarraySum(nums,2));
    }
}

class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0, preSum = 0;
        // key:前缀和 value:该前缀和出现次数
        Map<Integer, Integer> preSumMap = new HashMap<>();
        preSumMap.put(0, 1);
        for (int num :
                nums) {
            preSum += num;
            // 找到前缀和为 preSum - k
            if (preSumMap.containsKey(preSum - k))
                count += preSumMap.get(preSum - k);
            // 更新map
            preSumMap.put(preSum, preSumMap.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }
}
