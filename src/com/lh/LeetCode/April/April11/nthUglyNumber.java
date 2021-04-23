package com.lh.LeetCode.April.April11;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 264. 丑数 II
 * 给你一个整数 n ，请你找出并返回第 n 个 丑数 。
 * 丑数 就是只包含质因数 2、3 和/或 5 的正整数。
 *
 * @Author: LH
 * @Date: 2021/4/12 15:43
 */
public class nthUglyNumber {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.nthUglyNumber2(5));
    }
}

class Solution {
    // 最小根堆解法
    public int nthUglyNumber(int n) {
        int[] nums = {2, 3, 5};
        Set<Long> set = new HashSet<>();
        // PriorityQueue（优先级队列）,自动对元素进行排序
        PriorityQueue<Long> heap = new PriorityQueue<>();
        set.add(1L);
        heap.add(1L);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            assert !heap.isEmpty();
            long cur = heap.poll();
            ans = (int) cur;
            for (int num :
                    nums) {
                long next = cur * num;
                if (set.add(next)) {
                    heap.offer(next);
                }
            }
        }
        return ans;
    }

    // 动态规划解法
    public int nthUglyNumber2(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int p2 = 1, p3 = 1, p5 = 1;
        for (int i = 2; i <= n; i++) {
            int num2 = dp[p2] * 2, num3 = dp[p3] * 3, num5 = dp[p5] * 5;
            dp[i] = Math.min(Math.min(num2, num3), num5);
            if (dp[i] == num2) p2++;
            if (dp[i] == num3) p3++;
            if (dp[i] == num5) p5++;
        }
        return dp[n];
    }
}