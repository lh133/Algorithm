package com.lh.LeetCode.March.March26;

/**
 * 12. 整数转罗马数字
 * 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
 *
 * @Author: LH
 * @Date: 2021/3/26 17:40
 */
public class intToRoman {
    public static void main(String[] args) {
        int num = 903;
        Solution2 solution2 = new Solution2();
        String ans = solution2.intToRoman(num);
        System.out.println(ans);
    }
}

class Solution2 {
    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        // 贪心算法
        for (int i = 0; i < values.length && num >= 0; i++) {
            while (values[i] <= num) {
                num -= values[i];
                sb.append(symbols[i]);
            }
        }
        return sb.toString();
    }
}
