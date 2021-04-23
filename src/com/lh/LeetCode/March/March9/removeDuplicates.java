package com.lh.LeetCode.March.March9;

import java.util.Stack;

/**
 * 1047. 删除字符串中的所有相邻重复项
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 * 提示：
 * 1 <= S.length <= 20000
 * S 仅由小写英文字母组成。
 *
 * @Author: LH
 * @Date: 2021/3/9 21:55
 */
public class removeDuplicates {
    public static void main(String[] args) {
        String s = "abbaca";
        Solution solution = new Solution();
        String ans2 = solution.removeDuplicates1(s);
        String ans1 = solution.removeDuplicates(s);
        System.out.println("ans1:" + ans1 + "\nans2:" + ans2);
    }
}

// 数组模拟栈解法
class Solution {
    public String removeDuplicates(String s) {
        // 字符串转为数组便于计算
        char[] cs = s.toCharArray();
        // 第一个字符需要放进数组，所以point初始化为-1
        int point = -1;
        for (char c : cs) {
            // 当与最后插入的值相同时，point回退
            if (point >= 0 && cs[point] == c) {
                point--;
            } else {
                // point后移，元素插入数组
                point++;
                cs[point] = c;
            }
        }
        return new String(cs, 0, point + 1);
    }

    // 用栈的解法
    public String removeDuplicates1(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            // 栈为空或栈顶元素与遍历元素c不等时，元素入栈
            if (stack.isEmpty() || stack.peek() != c) {
                stack.push(c);
            } else {
                stack.pop();
            }
        }
        // 用StringBuilder保存结果
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        // 由于栈先入后出的特性，将StringBuilder反转后输出
        return sb.reverse().toString();
    }
}