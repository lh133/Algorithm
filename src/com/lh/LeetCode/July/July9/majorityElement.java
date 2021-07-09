package com.lh.LeetCode.July.July9;

/**
 * 面试题 17.10. 主要元素
 * <p>
 * 数组中占比超过一半的元素称之为主要元素。给你一个 整数 数组，找出其中的主要元素。若没有，返回 -1 。
 * <p>
 * 请设计时间复杂度为 O(N) 、空间复杂度为 O(1) 的解决方案。
 *
 * @Author: LH
 * @Date: 2021/7/9 9:32
 */
public class majorityElement {
}

class Solution {
    public int majorityElement(int[] nums) {
        int vote = -1, count = 0;
        for (int num : nums) {
            if (count == 0) vote = num;
            if (vote == num) count++;
            else count--;
        }
        count = 0;
        int len = nums.length;
        for (int num : nums) {
            if (num == vote)
                count++;
        }
        return count * 2 > len ? vote : -1;
    }
}