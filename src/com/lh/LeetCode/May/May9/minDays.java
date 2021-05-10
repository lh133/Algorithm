package com.lh.LeetCode.May.May9;

/**
 * 1482. 制作 m 束花所需的最少天数
 * 给你一个整数数组 bloomDay，以及两个整数 m 和 k 。
 * <p>
 * 现需要制作 m 束花。制作花束时，需要使用花园中 相邻的 k 朵花 。
 * <p>
 * 花园中有 n 朵花，第 i 朵花会在 bloomDay[i] 时盛开，恰好 可以用于 一束 花中。
 * <p>
 * 请你返回从花园中摘 m 束花需要等待的最少的天数。如果不能摘到 m 束花则返回 -1 。
 *
 * @Author: LH
 * @Date: 2021/5/9 22:34
 */
public class minDays {
    public static void main(String[] args) {
        int[] bloomDay = {1, 10, 3, 10, 2};
        System.out.println(new Solution().minDays(bloomDay, 3, 1));
    }
}

class Solution {
    private int _m, n, _k;

    public int minDays(int[] bloomDay, int m, int k) {
        n = bloomDay.length;
        _m = m;
        _k = k;
        // 当花园里花总数不够时，直接返回-1
        if (n < m * k) return -1;
        // 找到二分的精确右边界
        int left = 0, right = 0;
        for (int i = 0; i < n; i++) {
            right = Math.max(bloomDay[i], right);
        }
        while (left < right) {
            int mid = left + right >> 1;
            if (check(bloomDay, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    /**
     * 判断是否可以组成花束
     *
     * @param bloomDay 开花时间数组
     * @param mid      预估开花时间
     * @return 是否满足条件
     */
    private boolean check(int[] bloomDay, int mid) {
        // count统计当前状况下能做出的花束数量
        int count = 0;
        for (int i = 0; i < n && count < _m; ) {
            // cur统计连续的花的数量
            int cur = bloomDay[i] <= mid ? 1 : 0, j = i;
            // 判断是否有连续的花足够组成花束
            if (cur > 0) {
                while (cur < _k && j + 1 < n && bloomDay[j + 1] <= mid) {
                    j++;
                    cur++;
                }
                // 当足够组成一束花，则count++
                if (cur == _k) count++;
                // 跳过已经采摘的花
                i = j + 1;
            } else {
                i++;
            }
        }
        return count >= _m;
    }
}