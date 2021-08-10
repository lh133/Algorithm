package com.lh.LeetCode.August.August5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 802. 找到最终的安全状态
 * <p>
 * 在有向图中，以某个节点为起始节点，从该点出发，每一步沿着图中的一条有向边行走。如果到达的节点是终点（即它没有连出的有向边），则停止。
 * <p>
 * 对于一个起始节点，如果从该节点出发，无论每一步选择沿哪条有向边行走，最后必然在有限步内到达终点，则将该起始节点称作是 安全 的。
 * <p>
 * 返回一个由图中所有安全的起始节点组成的数组作为答案。答案数组中的元素应当按 升序 排列。
 * <p>
 * 该有向图有 n 个节点，按 0 到 n - 1 编号，其中 n 是 graph 的节点数。图以下述形式给出：graph[i] 是编号 j 节点的一个列表，满足 (i, j) 是图的一条有向边。
 * <p>
 * 提示：
 * <p>
 * n == graph.length
 * 1 <= n <= 104
 * 0 <= graph[i].length <= n
 * graph[i] 按严格递增顺序排列。
 * 图中可能包含自环。
 * 图中边的数目在范围 [1, 4 * 104] 内。
 *
 * @Author: LH
 * @Date: 2021/8/10 20:20
 */
public class eventualSafeNodes {
}

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> rg = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            rg.add(new ArrayList<>());
        }
        int[] inDeg = new int[n];
        for (int x = 0; x < n; ++x) {
            for (int y : graph[x]) {
                rg.get(y).add(x);
            }
            inDeg[x] = graph[x].length;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            if (inDeg[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int y = queue.poll();
            for (int x : rg.get(y)) {
                if (--inDeg[x] == 0) {
                    queue.offer(x);
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (inDeg[i] == 0) {
                ans.add(i);
            }
        }
        return ans;
    }
}