package com.lh.LeetCode.June.June8;

import java.util.PriorityQueue;

/**
 * 1046. 最后一块石头的重量
 * <p>
 * 有一堆石头，每块石头的重量都是正整数。
 * <p>
 * 每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 * <p>
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
 * <p>
 * 提示：
 * <p>
 * 1 <= stones.length <= 30
 * 1 <= stones[i] <= 1000
 *
 * @Author: LH
 * @Date: 2021/6/8 10:46
 */
public class lastStoneWeight {
    public static void main(String[] args) {
        int[] stones = {2, 7, 4, 1, 8, 1};
        System.out.println(new Solution().lastStoneWeight(stones));
    }
}

class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int stone :
                stones) {
            pq.offer(stone);
        }
        while (pq.size() > 1) {
            // 最大数出堆
            int a = pq.poll();
            // 次大数出堆
            assert !pq.isEmpty();
            int b = pq.poll();
            if (a > b) pq.offer(a - b);
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }
}
