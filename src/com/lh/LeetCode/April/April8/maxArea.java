package com.lh.LeetCode.April.April8;

/**
 * 11. 盛最多水的容器
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器。
 *
 * @Author: LH
 * @Date: 2021/4/8 17:11
 */
public class maxArea {
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        Solution2 solution2 = new Solution2();
        int ans = solution2.maxArea(height);
        System.out.println(ans);
    }
}

class Solution2 {
    public int maxArea(int[] height) {
        int n = height.length;
        if (n == 0 || n == 1)
            return 0;
        int left = 0, right = n - 1;
        int ans = 0;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            ans = Math.max(ans, area);
            if (height[left] <= height[right])
                ++left;
            else
                --right;
        }
        return ans;
    }
}
