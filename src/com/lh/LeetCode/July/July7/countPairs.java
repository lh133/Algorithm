package com.lh.LeetCode.July.July7;

import java.util.HashMap;
import java.util.Map;

/**
 * 1711. 大餐计数
 * <p>
 * 大餐 是指 恰好包含两道不同餐品 的一餐，其美味程度之和等于 2 的幂。
 * <p>
 * 你可以搭配 任意 两道餐品做一顿大餐。
 * <p>
 * 给你一个整数数组 deliciousness ，其中 deliciousness[i] 是第 i​​​​​​​​​​​​​​ 道餐品的美味程度，返回你可以用数组中的餐品做出的不同 大餐 的数量。
 * 结果需要对 10^9 + 7 取余。
 * <p>
 * 注意，只要餐品下标不同，就可以认为是不同的餐品，即便它们的美味程度相同。
 * <p>
 * 提示：
 * <p>
 * 1 <= deliciousness.length <= 105
 * 0 <= deliciousness[i] <= 220
 *
 * @Author: LH
 * @Date: 2021/7/7 9:28
 */
public class countPairs {
}

class Solution {
    public int countPairs(int[] deliciousness) {
        final int mod = 1000000007;
        int maxDel = 0;
        for (int d : deliciousness) {
            maxDel = Math.max(maxDel, d);
        }

        int maxSum = 2 * maxDel;
        int pairs = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int len = deliciousness.length;
        for (int val : deliciousness) {
            for (int sum = 1; sum <= maxSum; sum <<= 1) {
                int count = map.getOrDefault(sum - val, 0);
                pairs = (pairs + count) % mod;
            }
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        return pairs;
    }
}