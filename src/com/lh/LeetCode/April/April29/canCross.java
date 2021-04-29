package com.lh.LeetCode.April.April29;

import java.util.Arrays;

/**
 * 403. 青蛙过河
 * 一只青蛙想要过河。 假定河流被等分为若干个单元格，并且在每一个单元格内都有可能放有一块石子（也有可能没有）。 青蛙可以跳上石子，但是不可以跳入水中。
 * 给你石子的位置列表 stones（用单元格序号 升序 表示）， 请判定青蛙能否成功过河（即能否在最后一步跳至最后一块石子上）。
 * 开始时， 青蛙默认已站在第一块石子上，并可以假定它第一步只能跳跃一个单位（即只能从单元格 1 跳至单元格 2 ）。
 * 如果青蛙上一步跳跃了 k 个单位，那么它接下来的跳跃距离只能选择为 k - 1、k 或 k + 1 个单位。 另请注意，青蛙只能向前方（终点的方向）跳跃。
 * 提示：
 * <p>
 * 2 <= stones.length <= 2000
 * 0 <= stones[i] <= 231 - 1
 * stones[0] == 0
 *
 * @Author: LH
 * @Date: 2021/4/29 10:51
 */
public class canCross {
    public static void main(String[] args) {
        int[] stones = {0, 1, 3, 5, 6, 8, 12, 17};
        System.out.println(new Solution().canCross(stones) ? "能" : "不能");
    }
}

// dfs+记忆化搜索
class Solution {
    // 记录当前石子在数组里的下标，上次跳跃距离，能否到达下一个石子
    private Boolean[][] record;

    public boolean canCross(int[] stones) {
        int n = stones.length;
        record = new Boolean[n][n];
        return dfs(stones, 0, 0);
    }

    /**
     * 判断能否跳到最后一颗石子上
     *
     * @param stones   石子列表
     * @param idx      当前位置下标
     * @param lastStep 上一次是经过多少步跳到当前位置的
     * @return 是否能跳到最后一块石子
     */
    private boolean dfs(int[] stones, int idx, int lastStep) {
        if (idx == stones.length - 1) {
            return true;
        }
        if (record[idx][lastStep] != null) {
            return record[idx][lastStep];
        }

        for (int curStep = lastStep - 1; curStep <= lastStep + 1; curStep++) {
            if (curStep > 0) {
                int j = Arrays.binarySearch(stones, idx + 1, stones.length, curStep + stones[idx]);
                if (j >= 0 && dfs(stones, j, curStep)) {
                    return record[idx][lastStep] = true;
                }
            }
        }
        return record[idx][lastStep] = false;
    }
}

// 动态规划
class Solution2 {
    public boolean canCross(int[] stones) {
        int n = stones.length;
        boolean[][] dp = new boolean[n][n];
        dp[0][0] = true;
        // 「现在所处的石子编号」为 i 时，「上一次跳跃距离」k 必定满足 k≤i。
        // 当第 i 个石子与第 i−1 个石子距离超过 ii 时，青蛙必定无法到达终点。
        for (int i = 1; i < n; i++) {
            if (stones[i] - stones[i - 1] > i) return false;
        }

        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                int k = stones[i] - stones[j];
                if (k > j + 1) {
                    break;
                }
                dp[i][k] = dp[j][k - 1] || dp[j][k] || dp[j][k + 1];
                if (i == n - 1 && dp[i][k]) {
                    return true;
                }
            }
        }
        return false;
    }
}