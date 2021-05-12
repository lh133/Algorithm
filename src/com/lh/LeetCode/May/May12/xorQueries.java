package com.lh.LeetCode.May.May12;

import java.util.Arrays;

/**
 * 1310. 子数组异或查询
 * 有一个正整数数组 arr，现给你一个对应的查询数组 queries，其中 queries[i] = [Li, Ri]。
 * <p>
 * 对于每个查询 i，请你计算从 Li 到 Ri 的 XOR 值（即 arr[Li] xor arr[Li+1] xor ... xor arr[Ri]）作为本次查询的结果。
 * <p>
 * 并返回一个包含给定查询 queries 所有结果的数组。
 *
 * @Author: LH
 * @Date: 2021/5/12 10:01
 */
public class xorQueries {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 8};
        int[][] queries = {{0, 1}, {1, 2}, {0, 3}, {3, 3}};
        System.out.println(Arrays.toString(new Solution().xorQueries(arr, queries)));
    }
}

class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        // 定义前缀数组保存arr前i个数异或的结果
        int[] preXor = new int[n + 1];
        for (int i = 0; i < n; i++) {
            preXor[i + 1] = preXor[i] ^ arr[i];
        }
        int m = queries.length;
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            ans[i] = preXor[queries[i][0]] ^ preXor[queries[i][1] + 1];
        }
        return ans;
    }
}