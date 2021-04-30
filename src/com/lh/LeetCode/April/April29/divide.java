package com.lh.LeetCode.April.April29;

/**
 * 29. 两数相除
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 *
 * @Author: LH
 * @Date: 2021/4/29 15:48
 */
public class divide {
    public static void main(String[] args) {
        int dividend = 10;
        int divisor = 3;
        System.out.println(new Solution3().divide(dividend, divisor));
    }
}

class Solution3 {
    /**
     * 使用位运算
     *
     * @param dividend 被除数
     * @param divisor  除数
     * @return 相除后取整的结果
     */
    public int divide(int dividend, int divisor) {
        //用异或来计算是否符号相异
        boolean isNag = (dividend ^ divisor) < 0;
        int result = 0;
        // 都变为负数进行计算
        if (dividend > 0) dividend = -dividend;
        if (divisor > 0) divisor = -divisor;
        while (dividend <= divisor) {
            int temp_result = -1;
            int temp_divisor = divisor;
            while (dividend <= (temp_divisor << 1)) {
                if (temp_divisor < (Integer.MIN_VALUE >> 1)) break;
                temp_result = temp_result << 1;
                temp_divisor = temp_divisor << 1;
            }
            dividend = dividend - temp_divisor;
            result += temp_result;
        }
        if (!isNag) {
            if (result <= Integer.MIN_VALUE) return Integer.MAX_VALUE;
            result = -result;
        }
        return result;
    }
}