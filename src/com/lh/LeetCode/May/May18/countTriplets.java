package com.lh.LeetCode.May.May18;

/**
 * 1442. 形成两个异或相等数组的三元组数目
 * 给你一个整数数组 arr 。
 * <p>
 * 现需要从数组中取三个下标 i、j 和 k ，其中 (0 <= i < j <= k < arr.length) 。
 * <p>
 * a 和 b 定义如下：
 * <p>
 * a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1]
 * b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k]
 * 注意：^ 表示 按位异或 操作。
 * <p>
 * 请返回能够令 a == b 成立的三元组 (i, j , k) 的数目。
 *
 * @Author: LH
 * @Date: 2021/5/18 10:13
 */
public class countTriplets {
}

class Solution {
    public int countTriplets(int[] arr) {
        int n = arr.length;
        // 定义异或前缀和
        int[] preXor = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            preXor[i + 1] = preXor[i] ^ arr[i];
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int k = i + 1; k < n; ++k) {
                if (preXor[i] == preXor[k + 1]) {
                    ans += k - i;
                }
            }
        }
        return ans;
    }
}