package com.lh.LeetCode.June.June24;

/**
 * 70. 爬楼梯
 * <p>
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 *
 * @Author: LH
 * @Date: 2021/6/24 11:18
 */
public class climbStairs {
}

class Solution2 {
    // 动态规划，滚动数组
    public int climbStairs(int n) {
        int a, b = 0, ans = 1;
        for (int i = 1; i <= n; i++) {
            a = b;
            b = ans;
            ans = a + b;
        }
        return ans;
    }

    // 斐波拉契数列
    public int climbStairs2(int n) {
        double sqrt5 = Math.sqrt(5);
        double fibn = Math.pow((1 + sqrt5) / 2, n + 1) - Math.pow((1 - sqrt5) / 2, n + 1);
        return (int) Math.round(fibn / sqrt5);
    }
}