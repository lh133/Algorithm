package com.lh.LeetCode.June.June25;

import java.util.*;

/**
 * 127. 单词接龙
 * <p>
 * 字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列：
 * <p>
 * 序列中第一个单词是 beginWord 。
 * 序列中最后一个单词是 endWord 。
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典 wordList 中的单词。
 * 给你两个单词 beginWord 和 endWord 和一个字典 wordList 。
 * 找到从 beginWord 到 endWord 的 最短转换序列 中的 单词数目 。如果不存在这样的转换序列，返回 0。
 * <p>
 * 提示：
 * <p>
 * 1 <= beginWord.length <= 10
 * endWord.length == beginWord.length
 * 1 <= wordList.length <= 5000
 * wordList[i].length == beginWord.length
 * beginWord、endWord 和 wordList[i] 由小写英文字母组成
 * beginWord != endWord
 * wordList 中的所有字符串 互不相同
 *
 * @Author: LH
 * @Date: 2021/6/25 11:08
 */
public class ladderLength {
}

class Solution2 {
    Set<String> set = new HashSet<>();

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        set.addAll(wordList);
        if (!set.contains(endWord)) return 0;
        int ans = bfs(beginWord, endWord);
        return ans == -1 ? 0 : ans + 1;
    }

    /**
     * 双向bfs
     *
     * @param beginWord 初始单词
     * @param endWord   目标单词
     * @return 字母转换次数
     */
    private int bfs(String beginWord, String endWord) {
        // d1 代表从起点 beginWord 开始搜索（正向）
        // d2 代表从结尾 endWord 开始搜索（反向）
        Deque<String> d1 = new ArrayDeque<>(), d2 = new ArrayDeque<>();
        d1.add(beginWord);
        d2.add(endWord);
        // m1 和 m2 分别记录两个方向出现的单词是经过多少次转换而来
        // 例如：m2 = {"xyz":3} 代表 xyz 由 endWord 替换 3 次字符而来
        Map<String, Integer> m1 = new HashMap<>(), m2 = new HashMap<>();
        m1.put(beginWord, 0);
        m2.put(endWord, 0);

        while (!d1.isEmpty() && !d2.isEmpty()) {
            int count = -1;
            if (d1.size() <= d2.size()) {
                count = update(d1, m1, m2);
            } else {
                count = update(d2, m2, m1);
            }
            if (count != -1) return count;
        }
        return -1;
    }

    /**
     * 从 deque 中取出一个单词进行扩散
     *
     * @param deque 需要转换的方向
     * @param cur   当前方向的距离字典
     * @param other 其他方向的距离
     * @return 转换次数
     */
    private int update(Deque<String> deque, Map<String, Integer> cur, Map<String, Integer> other) {
        String poll = deque.pollFirst();
        int n = poll.length();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 26; j++) {
                // 进行替换
                String updated = poll.substring(0, i) + String.valueOf((char) ('a' + j)) + poll.substring(i + 1);
                if (set.contains(updated)) {
                    // 如果该字符串在「当前方向」被记录过，跳过即可
                    if (cur.containsKey(updated)) continue;
                    // 如果该字符串在「另一方向」出现过，说明找到了联通两个方向的最短路
                    if (other.containsKey(updated)) {
                        return cur.get(poll) + 1 + other.get(updated);
                    } else {
                        // 否则加入deque队列中
                        deque.addLast(updated);
                        cur.put(updated, cur.get(poll) + 1);
                    }
                }
            }
        }
        return -1;
    }
}