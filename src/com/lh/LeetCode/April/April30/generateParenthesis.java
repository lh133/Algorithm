package com.lh.LeetCode.April.April30;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * @Author: LH
 * @Date: 2021/4/30 16:08
 */
public class generateParenthesis {
    public static void main(String[] args) {
        System.out.println(new Solution5().generateParenthesis(3));
    }
}

class Solution5 {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    /**
     * 回溯算法，枚举所有可能的结果
     *
     * @param ans   保存所有结果
     * @param cur   暂存正在进行添加的字符串
     * @param left  左括号个数
     * @param right 右括号个数
     * @param max   括号的对数，为题目要求的 n
     */
    private void backtrack(List<String> ans, StringBuilder cur, int left, int right, int max) {
        // 结果符合要求，则返回
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }
        // 左括号个数小于n，添加一个左括号
        if (left < max) {
            cur.append('(');
            // 左括号数加一，继续尝试添加
            backtrack(ans, cur, left + 1, right, max);
            // 回溯，注意 cur.length-1 指向最后添加的一个括号
            cur.deleteCharAt(cur.length() - 1);
        }
        if (right < left) {
            cur.append(')');
            // 右括号数加一，继续尝试添加
            backtrack(ans, cur, left, right + 1, max);
            // 回溯
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
