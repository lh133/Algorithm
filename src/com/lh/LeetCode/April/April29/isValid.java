package com.lh.LeetCode.April.April29;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 * @Author: LH
 * @Date: 2021/4/29 17:39
 */
public class isValid {
    public static void main(String[] args) {
        String s = "{()[)}";
        System.out.println(new Solution4().isValid(s) ? "是有效的" : "不是有效的");
    }
}

class Solution4 {
    public boolean isValid(String s) {
        // 当字符串长度为单数是，必然不是有效的
        int n = s.length();
        if (n % 2 == 1) return false;

        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        // 使用栈暂存，找到对应的括号就出栈
        Deque<Character> stack = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (pairs.containsKey(c)) {
                // 当不匹配时，返回false
                if (stack.isEmpty() || stack.peek() != pairs.get(c)) return false;
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}