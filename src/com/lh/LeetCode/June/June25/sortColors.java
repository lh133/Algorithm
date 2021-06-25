package com.lh.LeetCode.June.June25;

/**
 * 75. 颜色分类
 * <p>
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 提示：
 * <p>
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] 为 0、1 或 2
 *
 * @Author: LH
 * @Date: 2021/6/25 11:52
 */
public class sortColors {
}

class Solution3 {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int p0 = 0, p2 = n - 1;
        for (int i = 0; i <= p2; ++i) {
            if (nums[i] == 0) {
                nums[i] = nums[p0];
                nums[p0] = 0;
                ++p0;
            }
            if (nums[i] == 2) {
                nums[i] = nums[p2];
                nums[p2] = 2;
                --p2;
                // 如果交换之后，nums[i] 不等于 1，则需要再进行一次交换
                if (nums[i] != 1) {
                    --i;
                }
            }
        }
    }
}