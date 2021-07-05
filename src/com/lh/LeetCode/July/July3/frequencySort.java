package com.lh.LeetCode.July.July3;

import java.util.*;

/**
 * 451. 根据字符出现频率排序
 * <p>
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 *
 * @Author: LH
 * @Date: 2021/7/3 15:27
 */
public class frequencySort {
}

class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            int frequency = map.getOrDefault(c, 0) + 1;
            map.put(c, frequency);
        }
        List<Character> list = new ArrayList<>(map.keySet());
        list.sort((a, b) -> map.get(b) - map.get(a));
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            char c = list.get(i);
            int frequency = map.get(c);
            for (int j = 0; j < frequency; j++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}