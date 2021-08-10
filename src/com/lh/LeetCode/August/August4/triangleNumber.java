package com.lh.LeetCode.August.August4;

import java.util.Arrays;

/**
 * 611. 有效三角形的个数
 * <p>
 * 给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。
 * <p>
 * 注意:
 * <p>
 * 数组长度不超过1000。
 * 数组里整数的范围为 [0, 1000]。
 *
 * @Author: LH
 * @Date: 2021/8/10 16:54
 */
public class triangleNumber {
}

class Solution {
    public int triangleNumber(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int k = i;
            for (int j = i + 1; j < n; j++) {
                while (k + 1 < n && nums[k + 1] < nums[i] + nums[j]) {
                    k++;
                }
                ans += Math.max(k - j, 0);// 避免负值加入结果
            }
        }
        return ans;
    }
}