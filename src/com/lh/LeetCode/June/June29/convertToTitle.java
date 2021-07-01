package com.lh.LeetCode.June.June29;

/**
 * 168. Excel表列名称
 * <p>
 * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
 *
 * @Author: LH
 * @Date: 2021/6/29 9:30
 */
public class convertToTitle {
}

class Solution {
    public String convertToTitle(int columnNumbers) {
        StringBuilder sb = new StringBuilder();
        while (columnNumbers > 0) {
            int a0 = (columnNumbers - 1) % 26 + 1;
            sb.append((char) (a0 - 1 + 'A'));
            columnNumbers = (columnNumbers - a0) / 26;
        }
        return sb.reverse().toString();
    }
}