package com.lh.LeetCode.May.May29;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1074. 元素和为目标值的子矩阵数量
 * 给出矩阵 matrix 和目标值 target，返回元素总和等于目标值的非空子矩阵的数量。
 * <p>
 * 子矩阵 x1, y1, x2, y2 是满足 x1 <= x <= x2 且 y1 <= y <= y2 的所有单元 matrix[x][y] 的集合。
 * <p>
 * 如果 (x1, y1, x2, y2) 和 (x1', y1', x2', y2') 两个子矩阵中部分坐标不同（如：x1 != x1'），那么这两个子矩阵也不同。
 * <p>
 * 提示：
 * <p>
 * 1 <= matrix.length <= 100
 * 1 <= matrix[0].length <= 100
 * -1000 <= matrix[i] <= 1000
 * -10^8 <= target <= 10^8
 *
 * @Author: LH
 * @Date: 2021/5/31 10:00
 */
public class numSubmatrixSumTarget {
    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 0},
                {1, 1, 1},
                {0, 1, 0}
        };
        System.out.println(new Solution2().numSubmatrixSumTarget(matrix,0));
    }
}

class Solution2 {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        // m行n列
        int m = matrix.length, n = matrix[0].length;
        // 是否行数多于列数
        boolean isRight = m > n;
        // 行数多则为行和，列数多则为列和
        int[] preSum = new int[isRight ? m : n + 1];
        // 统计最终结果
        int ans = 0;
        for (int top = 1; top <= (isRight ? n : m); top++) {
            Arrays.fill(preSum, 0);
            for (int bottom = top; bottom <= (isRight ? n : m); bottom++) {
                // 哈希表保存key:前缀和 value:出现次数
                Map<Integer, Integer> map = new HashMap<>();
                int cur = 0;
                for (int i = 1; i <= (isRight ? m : n); i++) {
                    preSum[i] = (isRight ? matrix[i - 1][bottom - 1] : matrix[bottom - 1][i - 1]) + preSum[i];
                    cur += preSum[i];
                    if (cur == target) ans++;
                    // 在哈希表中找到前缀和为 preSum - k，ans增加相应次数
                    if (map.containsKey(cur - target)) ans += map.get(cur - target);
                    // 更新哈希表，维护其定义
                    map.put(cur, map.getOrDefault(cur, 0) + 1);
                }
            }
        }
        return ans;
    }
}