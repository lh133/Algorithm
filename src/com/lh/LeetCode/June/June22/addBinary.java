package com.lh.LeetCode.June.June22;

/**
 * 67. 二进制求和
 * <p>
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * 输入为 非空 字符串且只包含数字 1 和 0。
 * <p>
 * 提示：
 * <p>
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 *
 * @Author: LH
 * @Date: 2021/6/22 10:44
 */
public class addBinary {
    public static void main(String[] args) {
        String a = "11";
        String b = "1";
        System.out.println(new Solution3().addBinary(a,b));
    }
}

class Solution3 {
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int n = Math.max(a.length(), b.length()), carry = 0;
        for (int i = 0; i < n; i++) {
            carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            res.append((char)(carry % 2 + '0'));
            carry /= 2;
        }

        if (carry > 0) {
            res.append('1');
        }
        res.reverse();
        return res.toString();
    }
}