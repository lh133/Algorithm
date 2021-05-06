package com.lh.LeetCode.May.May6;

import java.util.Arrays;

/**
 * 1720. 解码异或后的数组
 * 未知 整数数组 arr 由 n 个非负整数组成。
 * <p>
 * 经编码后变为长度为 n - 1 的另一个整数数组 encoded ，其中 encoded[i] = arr[i] XOR arr[i + 1] 。例如，arr = [1,0,2,1] 经编码后得到 encoded = [1,2,3] 。
 * <p>
 * 给你编码后的数组 encoded 和原数组 arr 的第一个元素 first（arr[0]）。
 * <p>
 * 请解码返回原数组 arr 。可以证明答案存在并且是唯一的。
 *
 * @Author: LH
 * @Date: 2021/5/6 15:42
 */
public class decode {
    public static void main(String[] args) {
        int[] encoded = {1, 2, 3};
        System.out.println(Arrays.toString(new Solution().decode(encoded, 1)));
    }
}

class Solution {
    // 利用异或运算的性质
    // 异或运算满足交换律和结合律
    // 任意整数和自身做异或运算的结果都等于0
    // 任意整数和 00 做异或运算的结果都等于其自身
    public int[] decode(int[] encoded, int first) {
        int n = encoded.length + 1;
        int[] arr = new int[n];
        arr[0] = first;
        for (int i = 1; i < n; i++) {
            arr[i] = arr[i - 1] ^ encoded[i - 1];
        }
        return arr;
    }
}
