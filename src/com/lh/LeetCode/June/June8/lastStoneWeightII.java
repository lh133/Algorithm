package com.lh.LeetCode.June.June8;

/**
 * 1049. 最后一块石头的重量 II
 * <p>
 * 有一堆石头，用整数数组 stones 表示。其中 stones[i] 表示第 i 块石头的重量。
 * <p>
 * 每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 * <p>
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块 石头。返回此石头 最小的可能重量 。如果没有石头剩下，就返回 0。
 * <p>
 * 提示：
 * <p>
 * 1 <= stones.length <= 30
 * 1 <= stones[i] <= 100
 *
 * @Author: LH
 * @Date: 2021/6/8 11:06
 */
public class lastStoneWeightII {
}

class Solution2 {
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int sum = 0;
        for (int stone :
                stones) {
            sum += stone;
        }
        int mid = sum / 2;
        int[][] dp = new int[n + 1][mid + 1];
        for (int i = 1; i <= n; i++) {
            int x = stones[i - 1];
            for (int j = 0; j <= mid; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= x) dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - x] + x);
            }
        }
        return Math.abs(sum - dp[n][mid] - dp[n][mid]);
    }

    // 空间优化
    public int lastStoneWeightII2(int[] stones) {
        int n = stones.length;
        int sum = 0;
        for (int stone :
                stones) {
            sum += stone;
        }
        int mid = sum / 2;
        int[] dp = new int[mid + 1];
        for (int i = 1; i <= n; i++) {
            int x = stones[i - 1];
            for (int j = mid; j >= x; j--) {
                dp[j] = Math.max(dp[j], dp[j - x] + x);
            }
        }
        return Math.abs(sum - dp[mid] - dp[mid]);
    }
}