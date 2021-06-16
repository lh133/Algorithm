package com.lh.LeetCode.June.June16;

/**
 * 50. Pow(x, n)
 * <p>
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。
 * <p>
 * 提示：
 * <p>
 * -100.0 < x < 100.0
 * -231 <= n <= 231-1
 * -104 <= xn <= 104
 *
 * @Author: LH
 * @Date: 2021/6/16 16:19
 */
public class myPow {
}

class Solution3 {
    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    // 快速幂+递归
    private double quickMul(double x, Long N) {
        if (N == 0) {
            return 1.0;
        }
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }

    // 快速幂+迭代
    private double quickMul2(double x, Long N) {
        double ans = 1.0;
        // 贡献的初始值为 x
        double x_contribute = x;
        // 在对 N 进行二进制拆分的同时计算答案
        while (N > 0) {
            // 如果 N 二进制表示的最低位为 1，那么需要计入贡献
            if (N % 2 == 1) {
                ans *= x_contribute;
            }
            // 随着 N 二进制位的升高，贡献不断平方
            x_contribute *= x_contribute;
            // 舍弃 N 二进制的最低位
            N = N >> 2;
        }
        return ans;
    }
}