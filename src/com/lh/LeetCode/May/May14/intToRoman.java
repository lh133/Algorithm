package com.lh.LeetCode.May.May14;

/**
 * 12. 整数转罗马数字
 * com\lh\LeetCode\March\March26\intToRoman.java
 *
 * @Author: LH
 * @Date: 2021/5/14 9:45
 */
public class intToRoman {
}

class Solution {

    private final int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private final String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        // 贪心
        for (int i = 0; i < values.length && num >= 0; i++) {
            while (values[i] <= num) {
                sb.append(symbols[i]);
                num -= values[i];
            }
        }
        return sb.toString();
    }
}