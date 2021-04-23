package com.lh.LeetCode.February.February20;

import java.util.HashMap;
import java.util.Map;

/**
 * 697. 数组的度
 * 给定一个非空且只包含非负数的整数数组 nums，数组的度的定义是指数组里任一元素出现频数的最大值。
 * 你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 * 解决方法：哈希表
 *
 * @Author: LH
 * @Date: 2021/2/20 10:07
 */
public class FindShortestSubArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 1};
        Solution solution = new Solution();
        int ans = solution.findShortestSubArray(nums);
        System.out.println(ans);
    }
}

class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int key = nums[i];
            int[] array = map.get(key);
            if (array != null) {
                array[0]++;//出现次数
                array[2] = i;//最后一次出现位置
            } else {
                map.put(key, new int[]{1, i, i});//将数组中的数字，第一次出现位置，最后一次出现位置保存到hashMap中
            }
        }

        int maxCount = 0;
        int minLength = 0;
        //遍历hashmap
        for (Map.Entry<Integer, int[]> entry : map.entrySet()
        ) {
            int[] array = entry.getValue();
            int count = array[0];
            int length = array[2] - array[1] + 1;
            if (count > maxCount) {
                maxCount = count;
                minLength = length;
            } else if (count == maxCount) {
                minLength = Math.min(minLength, length);
            }
        }
        return minLength;
    }
}