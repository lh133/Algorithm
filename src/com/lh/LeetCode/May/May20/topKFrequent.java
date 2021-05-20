package com.lh.LeetCode.May.May20;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 692. 前K个高频单词
 * <p>
 * 给一非空的单词列表，返回前 k 个出现次数最多的单词。
 * <p>
 * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
 * <p>
 * 注意：
 * <p>
 * 假定 k 总为有效值， 1 ≤ k ≤ 集合元素数。
 * 输入的单词均由小写字母组成。
 *
 * @Author: LH
 * @Date: 2021/5/20 9:17
 */
public class topKFrequent {
    public static void main(String[] args) {
        String[] words = {"i", "love", "knowledge", "i", "love", "coding"};
        System.out.println(new Solution().topKFrequent(words, 2));
    }
}

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> count = new HashMap<>();
        for (String word :
                words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        List<String> ans = new ArrayList<>();
        for (Map.Entry<String, Integer> entry :
                count.entrySet()) {
            ans.add(entry.getKey());
        }
        ans.sort((word1, word2) -> (count.get(word1).equals(count.get(word2)) ? word1.compareTo(word2) : count.get(word2) - count.get(word1)));
        return ans.subList(0, k);
    }
}