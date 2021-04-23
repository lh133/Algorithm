package com.lh.LeetCode.March.March8;

/**
 * 7. 整数反转
 * 给你一个 32 位的有符号整数 x ，返回 x 中每位上的数字反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *
 * @Author: LH
 * @Date: 2021/3/8 23:42
 */
public class reverse {
    public static void main(String[] args) {
        int x = 123;
        Solution2 solution2 = new Solution2();
        int reverse = solution2.reverse(x);
        System.out.println(reverse);
        System.out.println(Integer.MAX_VALUE);
    }
}

class Solution2 {
    public int reverse(int x) {
        int ans = 0;
        while (x != 0) {
            int pop = x % 10;
            // 当出现 ans > MAX_VALUE / 10 且 还有pop需要添加 时，则一定溢出
            // 当出现 ans == MAX_VALUE / 10 且 pop > 7 时，则一定溢出，7是2^31 - 1的个位数
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && pop > 7))
                return 0;
            // 当出现 ans < MIN_VALUE / 10 且 还有pop需要添加 时，则一定溢出
            // 当出现 ans == MIN_VALUE / 10 且 pop < -8 时，则一定溢出，8是-2^31的个位数
            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && pop < -8))
                return 0;
            ans = ans * 10 + pop;
            x = x / 10;
        }
        return ans;
    }
}