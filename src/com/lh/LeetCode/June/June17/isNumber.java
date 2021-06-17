package com.lh.LeetCode.June.June17;

/**
 * 65. 有效数字
 * <p>
 * 有效数字（按顺序）可以分成以下几个部分：
 * <p>
 * 一个 小数 或者 整数
 * （可选）一个 'e' 或 'E' ，后面跟着一个 整数
 * 小数（按顺序）可以分成以下几个部分：
 * <p>
 * （可选）一个符号字符（'+' 或 '-'）
 * 下述格式之一：
 * 至少一位数字，后面跟着一个点 '.'
 * 至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
 * 一个点 '.' ，后面跟着至少一位数字
 * 整数（按顺序）可以分成以下几个部分：
 * <p>
 * （可选）一个符号字符（'+' 或 '-'）
 * 至少一位数字
 * 部分有效数字列举如下：
 * <p>
 * ["2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"]
 * 部分无效数字列举如下：
 * <p>
 * ["abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"]
 * 给你一个字符串 s ，如果 s 是一个 有效数字 ，请返回 true 。
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 20
 * s 仅含英文字母（大写和小写），数字（0-9），加号 '+' ，减号 '-' ，或者点 '.' 。
 *
 * @Author: LH
 * @Date: 2021/6/17 9:52
 */
public class isNumber {
}

// 模拟
class Solution {
    public boolean isNumber(String s) {
        int n = s.length();
        char[] cs = s.toCharArray();
        int idx = -1;
        // 找到e或者E的位置，使用idx记录其下标
        for (int i = 0; i < n; i++) {
            if (cs[i] == 'e' || cs[i] == 'E') {
                if (idx == -1) idx = i;
                else return false;// idx!=-1 且 又找到 e，则为无效数字
            }
        }
        boolean ans;
        // e/E左侧可以为浮点数，右侧只能为整数
        if (idx != -1) {
            ans = check(cs, 0, idx - 1, false);
            ans &= check(cs, idx + 1, n - 1, true);
        } else {
            ans = check(cs, 0, n - 1, false);
        }
        return ans;
    }

    /**
     * 判断整数或浮点数是否合法
     *
     * @param cs          源字符串转换得到的字符数组
     * @param start       开始下标
     * @param end         结束下标
     * @param mustInteger 是否必须是整数
     * @return 是否是整数
     */
    private boolean check(char[] cs, int start, int end, boolean mustInteger) {
        if (start > end) return false;
        if (cs[start] == '+' || cs[start] == '-') start++;
        // 是否有小数点，是否有数字
        boolean hasDot = false, hasNum = false;
        for (int i = start; i <= end; i++) {
            if (cs[i] == '.') {
                if (mustInteger || hasDot) return false;
                hasDot = true;
            } else if (cs[i] >= '0' && cs[i] <= '9') {
                hasNum = true;
            } else {
                return false;
            }
        }
        return hasNum;
    }
}

class Solution2 {
    private int make(char c) {
        switch (c) {
            case ' ':
                return 0;
            case '+':
            case '-':
                return 1;
            case '.':
                return 3;
            case 'e':
            case 'E':
                return 4;
            default:
                if (c >= '0' && c <= '9') return 2;
        }
        return -1;
    }

    public boolean isNumber(String s) {
        int state = 0;
        int finals = 0b101101000;
        int[][] transfer = new int[][]
                {
                        {0, 1, 6, 2, -1},
                        {-1, -1, 6, 2, -1},
                        {-1, -1, 3, -1, -1},
                        {8, -1, 3, -1, 4},
                        {-1, 7, 5, -1, -1},
                        {8, -1, 5, -1, -1},
                        {8, -1, 6, 3, 4},
                        {-1, -1, 5, -1, -1},
                        {8, -1, -1, -1, -1}
                };
        char[] cs = s.toCharArray();
        for (char c : cs) {
            int id = make(c);
            if (id < 0) return false;
            state = transfer[state][id];
            if (state < 0) return false;
        }
        return (finals & (1 << state)) > 0;
    }
}