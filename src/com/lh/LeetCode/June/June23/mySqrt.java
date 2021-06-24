package com.lh.LeetCode.June.June23;

/**
 * 69. x 的平方根
 * <p>
 * 实现 int sqrt(int x) 函数。
 * <p>
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * <p>
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * @Author: LH
 * @Date: 2021/6/23 10:13
 */
public class mySqrt {
    public static void main(String[] args) {
        int x = 8;
        System.out.println(new Solution3().mySqrt(x));
    }
}

class Solution3 {
    public int mySqrt(int x) {
        int left = 0, right = x;
        while (left < right) {
            int mid = (left + right + 1) >> 1;
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("left = " + left + ", right = " + right + ", mid = " + mid);
            if (mid > x / mid) right = mid - 1;
            else left = mid;
        }
        return left;
    }
}