package com.lh.LeetCode.July.July4;

import java.util.HashMap;
import java.util.Map;

/**
 * 645. 错误的集合
 * <p>
 * 集合 s 包含从 1 到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，导致集合 丢失了一个数字 并且 有一个数字重复 。
 * <p>
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。
 * <p>
 * 请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
 *
 * @Author: LH
 * @Date: 2021/7/4 12:50
 */
public class findErrorNums {
}

class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] ans = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int i = 1; i <= nums.length; i++) {
            int count = map.getOrDefault(i, 0);
            if (count == 2) ans[0] = i;
            else if (count == 0) ans[1] = i;
        }
        return ans;
    }
}