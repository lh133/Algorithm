package com.lh.LeetCode.July.July18;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 面试题 10.02. 变位词组
 * <p>
 * 编写一种方法，对字符串数组进行排序，将所有变位词组合在一起。变位词是指字母相同，但排列不同的字符串。
 * <p>
 * 注意：本题相对原题稍作修改
 * <p>
 * 说明：
 * <p>
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 *
 * @Author: LH
 * @Date: 2021/7/19 9:53
 */
public class groupAnagrams {
}

class Solution {
    public List<List<String>> groupAnagrams(String[] ss) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : ss) {
            int[] cnts = new int[26];
            for (char c : s.toCharArray()) cnts[c - 'a']++;
            StringBuilder sb = new StringBuilder();
            for (int i : cnts) sb.append(i).append("_");
            String key = sb.toString();
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(s);
            map.put(key, list);
        }
        for (String key : map.keySet()) ans.add(map.get(key));
        return ans;
    }
}