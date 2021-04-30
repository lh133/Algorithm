package com.lh.LeetCode.April.April30;

import java.util.HashMap;
import java.util.Map;

/**
 * 137. 只出现一次的数字 II
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 * 进阶：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * @Author: LH
 * @Date: 2021/4/30 9:54
 */
public class singleNumber2 {
    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 2};
        System.out.println(new Solution().singleNumber2(nums));
    }
}

class Solution {
    // 哈希表
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num :
                nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int k :
                map.keySet()) {
            if (map.get(k) == 1) return k;
        }
        return -1;
    }

    // 位运算
    public int singleNumber2(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int total = 0;
            for (int num :
                    nums) {
                total += ((num >> i) & 1);
            }
            if (total % 3 != 0) {
                ans = ans | 1 << i;
            }
        }
        return ans;
    }
}