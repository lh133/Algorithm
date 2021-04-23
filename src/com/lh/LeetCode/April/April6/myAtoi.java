package com.lh.LeetCode.April.April6;

import java.util.HashMap;
import java.util.Map;

/**
 * 8. 字符串转换整数 (atoi)
 * 请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
 * 函数 myAtoi(string s) 的算法如下：
 * 读入字符串并丢弃无用的前导空格
 * 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
 * 如果整数数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231 − 1 的整数应该被固定为 231 − 1 。
 * 返回整数作为最终结果。
 * <p>
 * 注意：
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。
 *
 * @Author: LH
 * @Date: 2021/4/6 11:05
 */
public class myAtoi {
    public static void main(String[] args) {
        String s = "-91283472332";
        Solution3 solution3 = new Solution3();
        System.out.println(solution3.myAtoi(s));
    }
}

class Solution3 {
    // 暴力求解
    public int myAtoi(String s) {
        int len = s.length();
        // 转换为字符数组
        char[] chars = s.toCharArray();
        // 遍历到的位置
        int idx = 0;
        // 去除空格
        while (idx < len && chars[idx] == ' ')
            idx++;
        // 去掉已经为空或直接为空，则退出
        if (idx == len) {
            return 0;
        }
        // 如果有符号则记录符号
        int sign = 1;
        if (chars[idx] == '+') {
            idx++;
        } else if (chars[idx] == '-') {
            idx++;
            sign = -1;
        }

        int num = 0;
        while (idx < len) {
            // 对后续的数字进行非法输入判断
            char cur = chars[idx];
            if (cur > '9' || cur < '0')
                break;
            // 进行越界判断
            if (num > Integer.MAX_VALUE / 10 || (num == Integer.MAX_VALUE / 10 && (cur - '0') > Integer.MAX_VALUE % 10))
                return Integer.MAX_VALUE;
            if (num < Integer.MIN_VALUE / 10 || (num == Integer.MIN_VALUE / 10 && (cur - '0') > -(Integer.MIN_VALUE % 10)))
                return Integer.MIN_VALUE;
            // 转换合法字符
            num = num * 10 + sign * (cur - '0');
            idx++;
        }
        return num;
    }

    // 借鉴parseInt函数的实现
    public int MyAtoi2(String s) {

        int result = 0;
        boolean negative = false;
        int i = 0, len = s.length();
        int limit = -Integer.MAX_VALUE;
        int multmin;
        int digit;

        // remove ' 'before s
        while (i < len) {
            if (s.charAt(i) == ' ') {
                i++;
            } else {
                break;
            }
        }

        if (i < len) {
            char firstChar = s.charAt(i);
            if (firstChar < '0') { // Possible leading "+" or "-"
                if (firstChar == '-') {
                    negative = true;
                    limit = Integer.MIN_VALUE;
                } else if (firstChar != '+')
                    return 0;
                i++;
                if (len == 1) // Cannot have lone "+" or "-"
                    return 0;
            }
            multmin = limit / 10;
            while (i < len) {
                // Accumulating negatively avoids surprises near MAX_VALUE
                digit = Character.digit(s.charAt(i++), 10);
                if (digit < 0) {
                    return negative ? result : -result;
                }
                if (result < multmin) {
                    return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                result *= 10;
                if (result < limit + digit) {
                    return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                result -= digit;
            }
        } else {
            return 0;
        }
        return negative ? result : -result;
    }
}

// 确定有限状态机DFA
class Solution4 {
    public int myAtoi(String str) {
        Automaton automaton = new Automaton();
        int length = str.length();
        for (int i = 0; i < length; ++i) {
            automaton.get(str.charAt(i));
        }
        return (int) (automaton.sign * automaton.ans);
    }
}

class Automaton {
    public int sign = 1;
    public long ans = 0;
    private String state = "start";
    private final Map<String, String[]> table = new HashMap<String, String[]>() {{
        put("start", new String[]{"start", "signed", "in_number", "end"});
        put("signed", new String[]{"end", "end", "in_number", "end"});
        put("in_number", new String[]{"end", "end", "in_number", "end"});
        put("end", new String[]{"end", "end", "end", "end"});
    }};

    public void get(char c) {
        state = table.get(state)[get_col(c)];
        if ("in_number".equals(state)) {
            ans = ans * 10 + c - '0';
            ans = sign == 1 ? Math.min(ans, (long) Integer.MAX_VALUE) : Math.min(ans, -(long) Integer.MIN_VALUE);
        } else if ("signed".equals(state)) {
            sign = c == '+' ? 1 : -1;
        }
    }

    private int get_col(char c) {
        if (c == ' ') {
            return 0;
        }
        if (c == '+' || c == '-') {
            return 1;
        }
        if (Character.isDigit(c)) {
            return 2;
        }
        return 3;
    }
}