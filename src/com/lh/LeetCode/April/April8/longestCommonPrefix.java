package com.lh.LeetCode.April.April8;

/**
 * 14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * @Author: LH
 * @Date: 2021/4/8 17:34
 */
public class longestCommonPrefix {
    public static void main(String[] args) {
        String[] strings = {"flower", "flow", "flight"};
        Solution3 solution3 = new Solution3();
        String prefix = solution3.longestCommonPrefix(strings);
        System.out.println(prefix);
    }
}

class Solution3 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        // m:字符串长度，n:数组长度
        int m = strs[0].length();
        int n = strs.length;
        for (int i = 0; i < m; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < n; j++) {
                // 当结果超出最断字段串长度或字符不相等时返回前缀
                if (i == strs[j].length() || strs[j].charAt(i) != c)
                    return strs[0].substring(0, i);
            }
        }
        // 当strs[0]为最短字符串时
        return strs[0];
    }
}