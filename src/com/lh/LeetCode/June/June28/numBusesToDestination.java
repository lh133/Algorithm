package com.lh.LeetCode.June.June28;

import java.util.*;

/**
 * 815. 公交路线
 * <p>
 * 给你一个数组 routes ，表示一系列公交线路，其中每个 routes[i] 表示一条公交线路，第 i 辆公交车将会在上面循环行驶。
 * <p>
 * 例如，路线 routes[0] = [1, 5, 7] 表示第 0 辆公交车会一直按序列 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 -> ... 这样的车站路线行驶。
 * 现在从 source 车站出发（初始时不在公交车上），要前往 target 车站。 期间仅可乘坐公交车。
 * <p>
 * 求出 最少乘坐的公交车数量 。如果不可能到达终点车站，返回 -1 。
 * <p>
 * 提示：
 * <p>
 * 1 <= routes.length <= 500.
 * 1 <= routes[i].length <= 105
 * routes[i] 中的所有值 互不相同
 * sum(routes[i].length) <= 105
 * 0 <= routes[i][j] < 106
 * 0 <= source, target < 106
 *
 * @Author: LH
 * @Date: 2021/6/28 9:51
 */
public class numBusesToDestination {
}

class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;

        int n = routes.length;
        boolean[][] edge = new boolean[n][n];
        Map<Integer, List<Integer>> rec = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int site :
                    routes[i]) {
                List<Integer> list = rec.getOrDefault(site, new ArrayList<>());
                for (int j : list) {
                    edge[i][j] = edge[j][i] = true;
                }
                list.add(i);
                rec.put(site, list);
            }
        }

        int[] dis = new int[n];
        Arrays.fill(dis, -1);
        Queue<Integer> queue = new LinkedList<>();
        for (int site : rec.getOrDefault(source, new ArrayList<>())) {
            dis[site] = 1;
            queue.offer(site);
        }
        while (!queue.isEmpty()) {
            int x = queue.poll();
            for (int y = 0; y < n; y++) {
                if (edge[x][y] && dis[y] == -1) {
                    dis[y] = dis[x] + 1;
                    queue.offer(y);
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int site : rec.getOrDefault(target, new ArrayList<>())) {
            if (dis[site] != -1) {
                ans = Math.min(ans, dis[site]);
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}