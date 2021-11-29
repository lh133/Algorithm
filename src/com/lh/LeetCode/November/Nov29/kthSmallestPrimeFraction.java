package com.lh.LeetCode.November.Nov29;

import java.util.Arrays;
import java.util.Objects;
import java.util.PriorityQueue;

/**
 * 786. 第 K 个最小的素数分数
 * <p>
 * 给你一个按递增顺序排序的数组 arr 和一个整数 k 。数组 arr 由 1 和若干 素数  组成，且其中所有整数互不相同。
 * 对于每对满足 0 < i < j < arr.length 的 i 和 j ，可以得到分数 arr[i] / arr[j] 。
 * 那么第 k 个最小的分数是多少呢?  以长度为 2 的整数数组返回你的答案, 这里 answer[0] == arr[i] 且 answer[1] == arr[j] 。
 * <p>
 * 提示：
 * <p>
 * 2 <= arr.length <= 1000
 * 1 <= arr[i] <= 3 * 104
 * arr[0] == 1
 * arr[i] 是一个 素数 ，i > 0
 * arr 中的所有数字 互不相同 ，且按 严格递增 排序
 * 1 <= k <= arr.length * (arr.length - 1) / 2
 *
 * @Author: LH
 * @Date: 2021/11/29 14:32
 */
public class kthSmallestPrimeFraction {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5};
        Solution solution = new Solution();
        int[] ans = solution.kthSmallestPrimeFraction(arr, 3);
        System.out.println(Arrays.toString(ans));
    }
}

class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> {
            double i1 = arr[a[0]] * 1.0 / arr[a[1]], i2 = arr[b[0]] * 1.0 / arr[b[1]];
            return Double.compare(i1, i2);
        });
        for (int i = 1; i < n; i++) q.add(new int[]{0, i});
        while (k-- > 1) {
            int[] poll = q.poll();
            int i = Objects.requireNonNull(poll)[0], j = poll[1];
            if (i + 1 < j) q.add(new int[]{i + 1, j});
        }
        int[] poll = q.poll();
        assert poll != null;
        return new int[]{arr[poll[0]], arr[poll[1]]};
    }
}