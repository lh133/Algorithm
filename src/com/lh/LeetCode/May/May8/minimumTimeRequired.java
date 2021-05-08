package com.lh.LeetCode.May.May8;

/**
 * 1723. 完成所有工作的最短时间
 * 给你一个整数数组 jobs ，其中 jobs[i] 是完成第 i 项工作要花费的时间。
 * <p>
 * 请你将这些工作分配给 k 位工人。所有工作都应该分配给工人，且每项工作只能分配给一位工人。工人的 工作时间 是完成分配给他们的所有工作花费时间的总和。请你设计一套最佳的工作分配方案，使工人的 最大工作时间 得以 最小化 。
 * <p>
 * 返回分配方案中尽可能 最小 的 最大工作时间 。
 *
 * @Author: LH
 * @Date: 2021/5/8 9:55
 */
public class minimumTimeRequired {
    public static void main(String[] args) {
        int[] jobs = {254, 256, 256, 254, 251, 256, 254, 253, 255, 251, 251, 255};
        System.out.println(new Solution().minimumTimeRequired(jobs, 10));
        System.out.println(new Solution2().minimumTimeRequired(jobs, 10));
    }
}

class Solution {
    private int[] _jobs;
    private int n, _k;
    private int ans = 0x3f3f3f3f;

    public int minimumTimeRequired(int[] jobs, int k) {
        long startTime = System.currentTimeMillis();
        _jobs = jobs;
        n = jobs.length;
        _k = k;
        int[] sum = new int[k];
//        dfs(0,sum,0);
        dfs_pro(0, 0, sum, 0);
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
        return ans;
    }

    /**
     * 深度优先搜索,直接暴力搜索
     *
     * @param start 当前处理的job下标
     * @param sum   保存工人的工作量的数组
     * @param max   当前最大工作时间
     */
    private void dfs(int start, int[] sum, int max) {
        if (max >= ans) return;
        if (start == n) {
            ans = max;
            return;
        }
        for (int i = 0; i < _k; i++) {
            sum[i] += _jobs[start];
            dfs(start + 1, sum, Math.max(sum[i], max));
            sum[i] -= _jobs[start];
        }
    }

    /**
     * 优化版，有限分配给未分配工作的
     *
     * @param start 当前处理的job下标
     * @param used  已经分配工作的工人数
     * @param sum   保存工人的工作量的数组
     * @param max   当前最大工作时间
     */
    private void dfs_pro(int start, int used, int[] sum, int max) {
        if (max >= ans) return;
        if (start == n) {
            ans = max;
            return;
        }
        // 优先分配给未分配工作的工人
        if (used < _k) {
            sum[used] = _jobs[start];
            dfs_pro(start + 1, used + 1, sum, Math.max(sum[used], max));
            sum[used] = 0;
        }
        for (int i = 0; i < used; i++) {
            sum[i] += _jobs[start];
            dfs_pro(start + 1, used, sum, Math.max(sum[i], max));
            sum[i] -= _jobs[start];
        }
    }
}

// 状态压缩dp，无法理解
class Solution2 {
    public int minimumTimeRequired(int[] jobs, int k) {
        int n = jobs.length;
        int[] sum = new int[1 << n];
        // 初始化sum数组
        for (int i = 1; i < (1 << n); i++) {
            int x = Integer.numberOfTrailingZeros(i);
            int y = i - (1 << x);
            sum[i] = sum[y] + jobs[x];
        }

        int[][] dp = new int[k][1 << n];
        for (int i = 0; i < (1 << n); i++) {
            dp[0][i] = sum[i];
        }

        for (int i = 1; i < k; i++) {
            for (int j = 0; j < (1 << n); j++) {
                int minn = Integer.MAX_VALUE;
                for (int x = j; x != 0; x = (x - 1) & j) {
                    minn = Math.min(minn, Math.max(dp[i - 1][j - x], sum[x]));
                }
                dp[i][j] = minn;
            }
        }
        return dp[k - 1][(1 << n) - 1];
    }
}