package com.lh.LeetCode.April.April19;

/**
 * @Author: LH
 * @Date: 2021/4/19 10:02
 */
public class removeElement {
}

class Solution {
    public int removeElement(int[] nums, int val) {
        int idx = 0;
        for (int num :
                nums) {
            if (num != val)
                nums[idx++] = num;
        }
        return idx;
    }
}