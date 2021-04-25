package com.lh.LeetCode.April.April22;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * 363. 矩形区域不超过 K 的最大数值和
 * 给你一个 m x n 的矩阵 matrix 和一个整数 k ，找出并返回矩阵内部矩形区域的不超过 k 的最大数值和。
 * 题目数据保证总会存在一个数值和不超过 k 的矩形区域。
 * 进阶：如果行数远大于列数，该如何设计解决方案？
 *
 * @Author: LH
 * @Date: 2021/4/23 15:24
 */
public class maxSumSubmatrix {
    public static void main(String[] args) {
        int[][] matrix =
                {
                        {2, 2, -1}
                };
        int k = 3;
        System.out.println(new Solution().maxSumSubmatrix2(matrix, k));
    }
}

class Solution {
    // 直接使用二维前缀和
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int[][] preSum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                for (int p = i; p <= m; p++) {
                    for (int q = j; q <= n; q++) {
                        int cur = preSum[p][q] - preSum[i - 1][q] - preSum[p][j - 1] + preSum[i - 1][j - 1];
                        if (cur <= k)
                            ans = Math.max(ans, cur);
                    }
                }
            }
        }
        return ans;
    }

    // 转化为一维前缀和&二分
    public int maxSumSubmatrix2(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;

        int[][] preSum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }

        int ans = Integer.MIN_VALUE;
        // 遍历上边界
        for (int top = 1; top <= m; top++) {
            // 遍历下边界
            for (int down = top; down <= m; down++) {
                // 使用有序集合保存遍历到的右边界的前缀和
                TreeSet<Integer> ts = new TreeSet<>();
                // 避免子矩阵左边界与原矩阵左边列重合时，左矩阵无法取到0，导致计算错误
                ts.add(0);
                // 遍历右边界
                for (int r = 1; r <= n; r++) {
                    // 通过前缀和计算 right
                    int right = preSum[down][r] - preSum[top - 1][r];
                    // 找到left，由前缀和计算 right-left <= k转换而来
                    // ceiling()返回Set中大于/等于e的最小元素
                    Integer left = ts.ceiling(right - k);
                    if (left != null) {
                        int cur = right - left;
                        ans = Math.max(ans, cur);
                    }
                    // 遍历过的right加入集合
                    ts.add(right);
                }
            }
        }
        return ans;
    }

    // 进阶&优化，固定行或列根据各自长度决定
    public int maxSumSubmatrix3(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        // n>m为true，则列数大于行数，固定右边界，反之固定上边界
        boolean isRight = n > m;
        // 前缀和数组保存数量较大的 行or列
        int[] preSum = isRight ? new int[n + 1] : new int[m + 1];
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i <= (isRight ? m : n); i++) {
            Arrays.fill(preSum, 0);
            for (int j = i; j <= (isRight ? m : n); j++) {
                TreeSet<Integer> ts = new TreeSet<>();
                ts.add(0);
                int a = 0;
                for (int p = 1; p <= (isRight ? n : m); p++) {
                    preSum[p] += isRight ? matrix[j - 1][p - 1] : matrix[p - 1][j - 1];
                    a += preSum[p];
                    Integer b = ts.ceiling(a - k);
                    if (b != null) {
                        int cur = a - b;
                        ans = Math.max(ans, cur);
                    }
                    ts.add(a);
                }
            }
        }
        return ans;
    }
}