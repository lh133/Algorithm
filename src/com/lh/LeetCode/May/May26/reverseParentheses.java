package com.lh.LeetCode.May.May26;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 1190. 反转每对括号间的子串
 * 给出一个字符串 s（仅含有小写英文字母和括号）。
 * <p>
 * 请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。
 * <p>
 * 注意，您的结果中 不应 包含任何括号。
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 2000
 * s 中只有小写英文字母和括号
 * 我们确保所有括号都是成对出现的
 *
 * @Author: LH
 * @Date: 2021/5/26 9:25
 */
public class reverseParentheses {
    public static void main(String[] args) {
        String s = "(abcd)";
        System.out.println(new Solution().reverseParentheses(s));
    }
}

class Solution {
    public String reverseParentheses(String s) {
        Deque<String> stack = new LinkedList<>();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(builder.toString());
                builder.setLength(0);
            } else if (ch == ')') {
                builder.reverse();
                builder.insert(0, stack.pop());
            } else {
                builder.append(ch);
            }
        }
        return builder.toString();
    }
}