package com.lh.LeetCode.March.March10;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 224. 基本计算器
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 * 提示：
 * 1 <= s.length <= 3 * 105
 * s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
 * s 表示一个有效的表达式
 *
 * @Author: LH
 * @Date: 2021/3/11 16:31
 */
public class calculate {
    public static void main(String[] args) {
        String s = "- 123 - (-1 + 2)";
        Solution solution = new Solution();
        int ans = solution.calculate(s);
        System.out.println(ans);
    }
}

class Solution {
    public int calculate(String s) {
        // 存放所有数字
        Deque<Integer> nums = new ArrayDeque<>();
        // 为了防止第一个数为负数，先往 nums 加个 0
        nums.add(0);
        // 将所有的空格去掉，并将 (- 替换为 (0-
        s = s.replaceAll(" ", "");
        s = s.replaceAll("\\(-", "(0-");
        //存放操作符,包括+/-
        Deque<Character> ops = new ArrayDeque<Character>();
        int len = s.length();
        char[] chars = s.toCharArray();
        for (int i = 0; i < len; i++) {
            char c = chars[i];
            if (c == '(') {
                ops.addLast(c);
            } else if (c == ')') {
                // 计算到最近一个左括号为止
                while (!ops.isEmpty()) {
                    char op = ops.peekLast();
                    if (op != '(') {
                        calc(nums, ops);
                    } else {
                        ops.pollLast();
                        break;
                    }
                }
            } else {
                if (isNum(c)) {
                    int u = 0;
                    int j = i;
                    // 将从 i 位置开始后面的连续数字整体取出，暂存在u中，加入 nums
                    while (j < len && isNum(chars[j]))
                        u = u * 10 + (chars[j++] - '0');
                    nums.addLast(u);
                    // i指向连续数字的最后一位
                    i = j - 1;
                } else {
                    // 有一个新操作要入栈时，先把栈内可以算的都算了
                    while (!ops.isEmpty() && ops.peekLast() != '(')
                        calc(nums, ops);
                    ops.addLast(c);
                }
            }
        }
        while (!ops.isEmpty())
            calc(nums, ops);
        assert nums.peekLast() != null;
        return nums.peekLast();
    }

    void calc(Deque<Integer> nums, Deque<Character> ops) {
        if (nums.isEmpty() || nums.size() < 2) return;
        if (ops.isEmpty()) return;
        int b = nums.pollLast(), a = nums.pollLast();
        char op = ops.pollLast();
        nums.addLast(op == '+' ? a + b : a - b);
    }

    boolean isNum(char c) {
        return Character.isDigit(c);
    }
}