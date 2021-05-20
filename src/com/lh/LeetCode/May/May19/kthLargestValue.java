package com.lh.LeetCode.May.May19;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 1738. 找出第 K 大的异或坐标值
 * 给你一个二维矩阵 matrix 和一个整数 k ，矩阵大小为 m x n 由非负整数组成。
 * <p>
 * 矩阵中坐标 (a, b) 的 值 可由对所有满足 0 <= i <= a < m 且 0 <= j <= b < n 的元素 matrix[i][j]（下标从 0 开始计数）执行异或运算得到。
 * <p>
 * 请你找出 matrix 的所有坐标中第 k 大的值（k 的值从 1 开始计数）。
 *
 * @Author: LH
 * @Date: 2021/5/19 18:11
 */
public class kthLargestValue {
<<<<<<< HEAD
    public static void main(String[] args) {
        int[][] matrix = {{5,2},{1,6}};
        System.out.println(new Solution().kthLargestValue(matrix,1));
    }
=======
>>>>>>> github/master
}

class Solution {
    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] pre = new int[m + 1][n + 1];
        List<Integer> ans = new ArrayList<>();
<<<<<<< HEAD
        // 获取二维前缀和
=======
>>>>>>> github/master
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                pre[i][j] = pre[i - 1][j] ^ pre[i][j - 1] ^ pre[i - 1][j - 1] ^ matrix[i - 1][j - 1];
                ans.add(pre[i][j]);
                if (ans.size() > k) break;
            }
        }
<<<<<<< HEAD
        // 排序并获取结果
=======
>>>>>>> github/master
        ans.sort((o1, o2) -> o2 - o1);
        return ans.get(k - 1);
    }
}

// 小根堆
class Solution2 {
    public int kthLargestValue(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        int[][] sum = new int[m + 1][n + 1];
        PriorityQueue<Integer> q = new PriorityQueue<>(k, (a, b) -> a - b);
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i - 1][j] ^ sum[i][j - 1] ^ sum[i - 1][j - 1] ^ mat[i - 1][j - 1];
                if (q.size() < k) {
                    q.add(sum[i][j]);
                } else {
                    assert q.peek() != null;
                    if (sum[i][j] > q.peek()) {
                        q.poll();
                        q.add(sum[i][j]);
                    }
                }
            }
        }
        return q.peek();
    }
}