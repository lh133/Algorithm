package com.lh.LeetCode.May.May3;

/**
 * @Author: LH
 * @Date: 2021/5/3 10:16
 */
public class reverse {
}

class Solution {
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