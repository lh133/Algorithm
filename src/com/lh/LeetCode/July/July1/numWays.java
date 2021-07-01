package com.lh.LeetCode.July.July1;

import java.util.*;

/**
 * LCP 07. 传递信息
 * <p>
 * 小朋友 A 在和 ta 的小伙伴们玩传信息游戏，游戏规则如下：
 * <p>
 * 有 n 名玩家，所有玩家编号分别为 0 ～ n-1，其中小朋友 A 的编号为 0
 * 每个玩家都有固定的若干个可传信息的其他玩家（也可能没有）。传信息的关系是单向的（比如 A 可以向 B 传信息，但 B 不能向 A 传信息）。
 * 每轮信息必须需要传递给另一个人，且信息可重复经过同一个人
 * 给定总玩家数 n，以及按 [玩家编号,对应可传递玩家编号] 关系组成的二维数组 relation。返回信息从小 A (编号 0 ) 经过 k 轮传递到编号为 n-1 的小伙伴处的方案数；若不能到达，返回 0。
 * <p>
 * 限制：
 * <p>
 * 2 <= n <= 10
 * 1 <= k <= 5
 * 1 <= relation.length <= 90, 且 relation[i].length == 2
 * 0 <= relation[i][0],relation[i][1] < n 且 relation[i][0] != relation[i][1]
 *
 * @Author: LH
 * @Date: 2021/7/1 17:05
 */
public class numWays {
}

// bfs
class Solution {
    public int numWays(int n, int[][] relations, int k) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] relation : relations) {
            int a = relation[0], b = relation[1];
            Set<Integer> set = map.getOrDefault(a, new HashSet<>());
            set.add(b);
            map.put(a, set);
        }
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(0);
        // 只遍历k次
        while (!deque.isEmpty() && k-- > 0) {
            int size = deque.size();
            while (size-- > 0) {
                int poll = deque.pollFirst();
                Set<Integer> es = map.get(poll);
                if (es == null) continue;
                for (int next : es) {
                    deque.addLast(next);
                }
            }
        }
        int ans = 0;
        while (!deque.isEmpty()) {
            if (deque.pollFirst() == n - 1) ans++;
        }
        return ans;
    }
}

// dp
class Solution2 {
    public int numWays(int n, int[][] relations, int k) {
        // dp[i][j] 表示经过 i 轮传递到编号 j 的玩家的方案数
        int[][] dp = new int[k + 1][n];
        dp[0][0] = 1;
        for (int i = 0; i < k; i++) {
            for (int[] relation : relations) {
                int start = relation[0], stop = relation[1];
                dp[i + 1][stop] += dp[i][start];
            }
        }
        return dp[k][n - 1];
    }
}