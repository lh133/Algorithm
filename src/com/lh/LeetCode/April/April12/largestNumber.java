package com.lh.LeetCode.April.April12;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 179. 最大数
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 *
 * @Author: LH
 * @Date: 2021/4/12 17:17
 */
public class largestNumber {
    public static void main(String[] args) {

    }
}

class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        // 转换成包装类型
        Integer[] numArr = new Integer[n];
        for (int i = 0; i < n; i++) {
            numArr[i] = nums[i];
        }

        Arrays.sort(numArr, (x, y) -> {
            long sx = 10, sy = 10;
            while (sx <= x) {
                sx *= 10;
            }
            while (sy <= y) {
                sy *= 10;
            }
            return (int) (-sy * x - y + sx * y + x);
        });

        if (numArr[0] == 0) {
            return "0";
        }
        StringBuilder ret = new StringBuilder();
        for (int num :
                numArr) {
            ret.append(num);
        }
        return ret.toString();
    }
}