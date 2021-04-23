package com.lh.LeetCode.February.February26;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1178. 猜字谜
 * 外国友人仿照中国字谜设计了一个英文版猜字谜小游戏，请你来猜猜看吧。
 * 字谜的迷面 puzzle 按字符串形式给出，如果一个单词 word 符合下面两个条件，那么它就可以算作谜底：
 * 单词 word 中包含谜面 puzzle 的第一个字母。
 * 单词 word 中的每一个字母都可以在谜面 puzzle 中找到。
 * 例如，如果字谜的谜面是 "abcdefg"，那么可以作为谜底的单词有 "faced", "cabbage", 和 "baggage"；而 "beefed"（不含字母 "a"）以及 "based"（其中的 "s" 没有出现在谜面中）都不能作为谜底。
 * 返回一个答案数组 answer，数组中的每个元素 answer[i] 是在给出的单词列表 words 中可以作为字谜迷面 puzzles[i] 所对应的谜底的单词数目。
 *
 * @Author: LH
 * @Date: 2021/3/1 16:14
 */
public class findNumOfValidWords {
}

class Solution {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        Map<Integer, Integer> map = new HashMap<>();
        for (String word : words) {
            int key = 0;
            for (char ch : word.toCharArray()) key |= 1 << ch - 'a';
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        List<Integer> res = new ArrayList<>(puzzles.length);
        for (String p : puzzles) {
            char[] puzzle = p.toCharArray();
            res.add(dfs(puzzle, 1, map, 1 << puzzle[0] - 'a'));// 首字符必选
        }
        return res;
    }

    public int dfs(char[] puzzle, int idx, Map<Integer, Integer> map, int key) {
        if (idx == puzzle.length) return map.getOrDefault(key, 0);
        // 首字符之外的字符可选可不选，两种情况
        return dfs(puzzle, idx + 1, map, key) + dfs(puzzle, idx + 1, map, key | 1 << puzzle[idx] - 'a');
    }
}