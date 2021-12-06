package com.lh.LeetCode.November.Nov30;

/**
 * @Author: LH
 * @Date: 2021/11/30 16:08
 * <p>
 * 400. 第 N 位数字
 * <p>
 * 给你一个整数 n ，请你在无限的整数序列 [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...] 中找出并返回第 n 位上的数字。
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 231 - 1
 * 第 n 位上的数字是按计数单位（digit）从前往后数的第 n 个数，
 */
public class findNthDigit {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findNthDigit(190));
    }
}

class Solution {
    public int findNthDigit(int n) {
        long base = 1, digitCnt = 1;
        while (n > base * 9 * digitCnt) {
            n -= (base * 9 * digitCnt);
            base *= 10;
            ++digitCnt;
        }
        // 因为取余和除法计算序数”都是zero-based的算子，而我们在while后只能得到一个one-based的序数,所以需要自减
        --n;
        return getKthDigit(base + n / digitCnt, n % digitCnt);
    }

    private int getKthDigit(long num, long k) {
        return String.valueOf(num).charAt((int) k) - '0';
    }
}