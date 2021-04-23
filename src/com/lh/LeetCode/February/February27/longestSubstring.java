package com.lh.LeetCode.February.February27;

import java.util.HashMap;

/**
 * 395. 至少有 K 个重复字符的最长子串
 * 给你一个字符串 s 和一个整数 k
 * 请你找出 s 中的最长子串，要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。
 * 1 <= s.length <= 10^4
 * s 仅由小写英文字母组成
 * 1 <= k <= 105
 * 解决方案，分治算法
 *
 * @Author: LH
 * @Date: 2021/3/1 16:32
 */
public class longestSubstring {
    public static void main(String[] args) {
        String s = "aaabb";
        int k = 3;
        Solution solution = new Solution();
        int longestSubstring = solution.longestSubstring(s, k);
        System.out.println(longestSubstring);
    }
}

class Solution {
    public int longestSubstring(String s, int k) {
        int ans;
        if (s.length() < k) return 0;
        HashMap<Character, Integer> counter = new HashMap();
        //统计字符出现次数，存入哈希表counter，key为字符，value为出现次数
        for (int i = 0; i < s.length(); i++) {
            counter.put(s.charAt(i), counter.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (char c : counter.keySet()) {
            if (counter.get(c) < k) {
                ans = 0;
                //遍历counter的key，当某个c的出现次数小于k时，以c为边界切割原字符串s
                for (String t : s.split(String.valueOf(c))) {
                    //递归判断切割出来的子串t
                    ans = Math.max(ans, longestSubstring(t, k));
                }
                return ans;
            }
        }
        return s.length();
    }
}