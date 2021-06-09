package com.lh.LeetCode.June.June9;

/**
 * 879. 盈利计划
 * <p>
 * 集团里有 n 名员工，他们可以完成各种各样的工作创造利润。
 * <p>
 * 第 i 种工作会产生 profit[i] 的利润，它要求 group[i] 名成员共同参与。如果成员参与了其中一项工作，就不能参与另一项工作。
 * <p>
 * 工作的任何至少产生 minProfit 利润的子集称为 盈利计划 。并且工作的成员总数最多为 n 。
 * <p>
 * 有多少种计划可以选择？因为答案很大，所以 返回结果模 10^9 + 7 的值。
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 100
 * 0 <= minProfit <= 100
 * 1 <= group.length <= 100
 * 1 <= group[i] <= 100
 * profit.length == group.length
 * 0 <= profit[i] <= 100
 *
 * @Author: LH
 * @Date: 2021/6/9 9:39
 */
public class profitableSchemes {
    public static void main(String[] args) {
        System.out.println(new Solution().profitableSchemes2(5, 3, new int[]{2, 2}, new int[]{2, 3}));
    }
}

class Solution {
    private final int MOD = (int) (1e9 + 7);

    // 三维dp
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int len = profit.length;
        // dp[i][j][k]表示在前i个工作中选择了j个员工，且利润至少为k的盈利计划总数目
        int[][][] dp = new int[len + 1][n + 1][minProfit + 1];
        dp[0][0][0] = 1;
        for (int i = 1; i <= len; i++) {
            int members = group[i - 1], earn = profit[i - 1];
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= minProfit; k++) {
                    if (j < members) dp[i][j][k] = dp[i - 1][j][k];
                    else dp[i][j][k] = (dp[i - 1][j][k] + dp[i - 1][j - members][Math.max(0, k - earn)]) % MOD;
                }
            }
        }
        int count = 0;
        for (int i = 0; i <= n; i++) {
            count = (count + dp[len][i][minProfit]) % MOD;
        }
        return count;
    }

    // 优化为二维
    public int profitableSchemes2(int n, int minProfit, int[] group, int[] profit) {
        int len = profit.length;
        // dp[j][k]表示至少选择 j个员工，且利润至少为k的盈利计划总数目
        int[][] dp = new int[n + 1][minProfit + 1];
        // 初始化，当最小利润为0时，总能找到一种方案
        for (int j = 0; j <= n; j++) {
            dp[j][0] = 1;
        }
        for (int i = 1; i <= len; i++) {
            int members = group[i - 1], earn = profit[i - 1];
            for (int j = n; j >= members; j--) {
                for (int k = minProfit; k >= 0; k--) {
                    dp[j][k] = (dp[j][k] + dp[j - members][Math.max(0, k - earn)]) % MOD;
                }
            }
        }
        return dp[n][minProfit];
    }
}