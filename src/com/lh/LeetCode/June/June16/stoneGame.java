package com.lh.LeetCode.June.June16;

/**
 * 877. 石子游戏
 * <p>
 * 亚历克斯和李用几堆石子在做游戏。偶数堆石子排成一行，每堆都有正整数颗石子 piles[i] 。
 * <p>
 * 游戏以谁手中的石子最多来决出胜负。石子的总数是奇数，所以没有平局。
 * <p>
 * 亚历克斯和李轮流进行，亚历克斯先开始。 每回合，玩家从行的开始或结束处取走整堆石头。 这种情况一直持续到没有更多的石子堆为止，此时手中石子最多的玩家获胜。
 * <p>
 * 假设亚历克斯和李都发挥出最佳水平，当亚历克斯赢得比赛时返回 true ，当李赢得比赛时返回 false 。
 * <p>
 * 提示：
 * <p>
 * 2 <= piles.length <= 500
 * piles.length 是偶数。
 * 1 <= piles[i] <= 500
 * sum(piles) 是奇数。
 *
 * @Author: LH
 * @Date: 2021/6/16 10:54
 */
public class stoneGame {
}

class Solution2 {
    // 区间dp，同PredictTheWinner
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[] dp = new int[n];
        System.arraycopy(piles, 0, dp, 0, n);
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                dp[j] = Math.max(piles[i] - dp[j], piles[j] - dp[j - 1]);
            }
        }
        return dp[n - 1] > 0;
    }

    // 博弈论
    // 先手可以决定后手选取的奇偶性，因此先手只需要在进行第一次操作前计算原序列中「奇数总和」和「偶数总和」哪个大，
    // 然后每一次决策都「限制」对方只能选择「最优奇偶性序列」的对立面即可。
    public boolean stoneGame2(int[] piles) {
        return true;
    }
}