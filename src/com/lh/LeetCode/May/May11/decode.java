package com.lh.LeetCode.May.May11;

/**
 * 1734. 解码异或后的排列
 * 给你一个整数数组 perm ，它是前 n 个正整数的排列，且 n 是个 奇数 。
 * <p>
 * 它被加密成另一个长度为 n - 1 的整数数组 encoded ，满足 encoded[i] = perm[i] XOR perm[i + 1] 。比方说，如果 perm = [1,3,2] ，那么 encoded = [2,1] 。
 * <p>
 * 给你 encoded 数组，请你返回原始数组 perm 。题目保证答案存在且唯一。
 * <p>
 * 提示：
 * <p>
 * 3 <= n < 105
 * n 是奇数。
 * encoded.length == n - 1
 *
 * @Author: LH
 * @Date: 2021/5/11 15:30
 */
public class decode {
}

class Solution {
    public int[] decode(int[] encoded) {
        // 原数组的长度 n
        int n = encoded.length + 1;
        // 前n个正整数的异或结果为total，也即原数组所有值异或的结果
        int total = 0;
        for (int i = 1; i <= n; i++) {
            total ^= i;
        }
        // encoded数组每隔一位进行异或，结果为原数组除了perm[0]的所有值异或的结果
        int odd = 0;
        for (int i = 1; i < n - 1; i += 2) {
            odd ^= encoded[i];
        }
        // total异或odd的值即为perm[0]的值
        int[] perm = new int[n];
        perm[0] = total ^ odd;
        // 知道原数组第一个元素的值后，可以根据与May6\decode.java相同的推导方式，得知后面所有元素的值
        for (int i = 0; i < n - 1; i++) {
            perm[i + 1] = perm[i] ^ encoded[i];
        }
        return perm;
    }
}