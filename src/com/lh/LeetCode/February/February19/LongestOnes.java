package com.lh.LeetCode.February.February19;

/**
 * 1004.最大连续1的个数 III
 * 给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1。
 * 返回仅包含 1 的最长（连续）子数组的长度。
 * 解决方案；滑动窗口法
 *
 * @Author: LH
 * @Date: 2021/2/19 10:39
 */

public class LongestOnes {
    public static void main(String[] args) {
        int[] A = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        int K = 3;
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();
        int ans = solution.longestOnes(A, K);
        int ans1 = solution2.longestOnes(A, K);
        System.out.println("解法一：" + ans + "\n" + "解法二：" + ans1);
    }
}

class Solution {
    public int longestOnes(int[] A, int K) {
        int N = A.length;
        int ans = 0;
        int left = 0, right = 0;
        int zeros = 0;
        while (right < N) {
            //right主动右移
            if (A[right] == 0)
                zeros++;
            while (zeros > K) {
                //当zeros零的个数大于K时，left被动右移，仅当left当前位置跨过0时，减少zeros计数
                if (A[left++] == 0)
                    zeros--;
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }
}

class Solution2 {
    public int longestOnes(int[] A, int K) {
        int l = 0, r = 0;
        while (r < A.length) {
            if (A[r++] == 0) {
                K--;
            }
            //仅当K<0时，l++
            if (K < 0 && A[l++] == 0) {
                K++;
            }
        }
        return r - l;
    }
}

