package com.lh.LeetCode.April.April20;

/**
 * 28. 实现 strStr()
 * 实现 strStr() 函数。
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
 * <p>
 * 说明：
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。
 *
 * @Author: LH
 * @Date: 2021/4/20 9:22
 */
public class strStr {
    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";
        Solution solution = new Solution();
        int i = solution.strStr(haystack, needle);
        System.out.println(i);
    }
}

class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        // 获取两个字符串长度
        int m = haystack.length(), n = needle.length();

        // 字符串前面添加空格，使下标从0开始
        haystack = " " + haystack;
        needle = " " + needle;

        char[] T = haystack.toCharArray();
        char[] P = needle.toCharArray();

        // 构建next数组，长度为匹配串的长度
        int[] next = new int[n + 1];
        // 构建next数组
        for (int i = 2, j = 0; i <= n; i++) {
            // 匹配不成功的话，j = next(j)
            while (j > 0 && P[i] != P[j + 1]) j = next[j];
            // 匹配成功的话，先让 j++
            if (P[i] == P[j + 1]) j++;
            // 然后更新 next[i]，结束本次循环，i++
            next[i] = j;
        }
        // 匹配过程,i从1开始,指向原串T，j = 0,指向匹配串及next数组
        for (int i = 1, j = 0; i <= m; i++) {
            // 匹配不成功 j = next(j);P[j+1]跳过前面补的空格
            while (j > 0 && T[i] != P[j + 1]) j = next[j];
            // 匹配成功的话，先让 j++，结束本次循环后 i++
            if (T[i] == P[j + 1]) j++;
            // 匹配成功，返回下标
            if (j == n) return i - n;
        }
        return -1;
    }
}