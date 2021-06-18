package com.lh.LeetCode.June.June18;

/**
 * 483. 最小好进制
 * <p>
 * 对于给定的整数 n, 如果n的k（k>=2）进制数的所有数位全为1，则称 k（k>=2）是 n 的一个好进制。
 * <p>
 * 以字符串的形式给出 n, 以字符串的形式返回 n 的最小好进制。
 *
 * @Author: LH
 * @Date: 2021/6/18 14:28
 */
public class smallestGoodBase {
}

class Solution {
    public String smallestGoodBase(String n) {
        // 将字符串转换为十进制long类型值
        long m = Long.parseLong(n);
        // max表示n = k^0+k^1+...+k^m 中m的最大值
        int max = (int) (Math.log(m) / Math.log(2) + 1);
        // 因题目要求取得最小好进制，从大到小枚举len，判断k是否为整数
        for (int len = max; len >= 3; len--) {
            // 计算得出k的值
            long k = (long) Math.pow(m, 1.0 / (len - 1));
            long res = 0;
            // 还原原数据 m
            for (int i = 0; i < len; i++) res = res * k + 1;
            // 若还原出的数res = m，返回对应k值
            if (res == m) return String.valueOf(k);
        }
        // 遍历结束没找到结果，则返回 n-1，(11)n-1进制 = n;
        return String.valueOf(m - 1);
    }
}