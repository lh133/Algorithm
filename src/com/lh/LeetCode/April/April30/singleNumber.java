package com.lh.LeetCode.April.April30;

/**
 * 136. 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * @Author: LH
 * @Date: 2021/4/30 10:27
 */
public class singleNumber {
    public static void main(String[] args) {

    }
}

class Solution2 {
    // 使用异或，数组中的全部元素的异或运算结果即为数组中只出现一次的数字。
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int num :
                nums) {
            ans = ans ^ num;
        }
        return ans;
    }
}