package com.lh.LeetCode.February.February28;

/**
 * 896. 单调数列
 * 如果数组是单调递增或单调递减的，那么它是单调的。
 * 如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。 如果对于所有 i <= j，A[i]> = A[j]，那么数组 A 是单调递减的。
 * 当给定的数组 A 是单调数组时返回 true，否则返回 false。
 *
 * @Author: LH
 * @Date: 2021/2/28 23:24
 */
public class isMonotonic {
    public static void main(String[] args) {
        int[] A = {1, 2, 2, 3};
        Solution solution = new Solution();
        boolean monotonic = solution.isMonotonic(A);
        System.out.println(monotonic);
    }
}

class Solution {
    public boolean isMonotonic(int[] A) {
        //定义变量记录是否为递增or递减
        boolean inc = true;
        boolean dec = true;
        for (int i = 1; i < A.length; i++) {
            if (A[i] < A[i - 1])
                inc = false;
            if (A[i] > A[i - 1])
                dec = false;
            //如果两个都为false，则说明数组不是单调的
            if (!inc && !dec)
                return false;
        }
        return true;
    }
}