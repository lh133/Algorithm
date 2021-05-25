package com.lh.LeetCode.May.May25;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1787. 使所有区间的异或结果为零
 * 给你一个整数数组 nums​​​ 和一个整数 k​​​​​ 。区间 [left, right]（left <= right）的 异或结果 是对下标位于 left 和 right（包括 left 和 right ）之间所有元素进行 XOR 运算的结果：nums[left] XOR nums[left+1] XOR ... XOR nums[right] 。
 * <p>
 * 返回数组中 要更改的最小元素数 ，以使所有长度为 k 的区间异或结果等于零。
 *
 * @Author: LH
 * @Date: 2021/5/25 11:18
 */
public class minChanges {
    public static void main(String[] args) {
        int[] nums = {1, 2, 0, 3, 0};
        System.out.println(new Solution().minChanges(nums, 1));
    }
}

// 根据题意，可知最后结果为周期为k的数组 nums[i] = nums[i+k]
class Solution {
    public int minChanges(int[] nums, int k) {
        int n = nums.length;
        int max = 1024;// 2^10
        // dp[i][xor] 表示前i列异或 = xor的最小修改次数 i：0~k-1， xor：0~2^10
        int[][] dp = new int[k][max];
        // g[i]表示前i列的最小修改次数
        int[] g = new int[k];
        for (int i = 0; i < k; i++) {
            Arrays.fill(dp[i], 0x3f3f3f3f);
            g[i] = 0x3f3f3f3f;
        }
        for (int i = 0, count = 0; i < k; i++, count = 0) {
            // 使用 map 和 cnt 分别统计当前列的「每个数的出现次数」和「有多少个数」
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = i; j < n; j += k) {
                map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
                count++;
            }
            if (i == 0) {
                // 第 0 列：只需要考虑如何将该列变为 xor 即可
                for (int xor = 0; xor < max; xor++) {
                    dp[0][xor] = Math.min(dp[0][xor], count - map.getOrDefault(xor, 0));
                    g[0] = Math.min(g[0], dp[0][xor]);
                }
            } else {
                // 其他列：考虑与前面列的关系
                for (int xor = 0; xor < max; xor++) {
                    dp[i][xor] = g[i - 1] + count;// 整列替换
                    for (int cur :
                            map.keySet()) {// 部分替换
                        dp[i][xor] = Math.min(dp[i][xor], dp[i - 1][xor ^ cur] + count - map.get(cur));
                    }
                    g[i] = Math.min(g[i], dp[i][xor]);
                }
            }
        }
        return dp[k - 1][0];
    }
}