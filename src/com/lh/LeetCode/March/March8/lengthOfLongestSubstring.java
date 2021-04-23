package com.lh.LeetCode.March.March8;

import java.util.HashMap;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 提示：
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 *
 * @Author: LH
 * @Date: 2021/3/8 22:46
 */
public class lengthOfLongestSubstring {
    public static void main(String[] args) {
        String s = "dvdf";
        Solution1 solution1 = new Solution1();
        int max = solution1.lengthOfLongestSubstring(s);
        System.out.println(max);
    }
}

class Solution1 {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len == 0) return 0;
        // 定义map保存字符，map (k, v)，其中 key 值为字符，value值为字符下标;
        HashMap<Character, Integer> map = new HashMap<>();
        // 初始化最大值结果
        int max = 0;
        for (int start = 0, end = 0; end < len; end++) {
            // 获取当前end对应的字符
            char c = s.charAt(end);
            if (map.containsKey(c))
                start = Math.max(map.get(c) + 1, start);
            max = Math.max(max, end - start + 1);
            map.put(c, end);
        }
        return max;
    }
}