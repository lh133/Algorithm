package com.lh.LeetCode.April.April13;

/**
 * 剑指 Offer 05. 替换空格
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 * @Author: LH
 * @Date: 2021/4/13 15:44
 */
public class replaceSpace {
    public static void main(String[] args) {
        String s = "We are happy.";
        Solution3 solution3 = new Solution3();
        System.out.println(solution3.replaceSpace(s));
    }
}

class Solution3 {
    public String replaceSpace(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c :
                chars) {
            if (c == ' ')
                sb.append("%20");
            else
                sb.append(c);
        }
        return sb.toString();
    }
}