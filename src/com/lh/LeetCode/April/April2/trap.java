package com.lh.LeetCode.April.April2;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 面试题 17.21. 直方图的水量
 * 给定一个直方图(也称柱状图)，假设有人从上面源源不断地倒水，最后直方图能存多少水量?直方图的宽度为 1。
 * https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/10/22/rainwatertrap.png
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的直方图，在这种情况下，可以接 6 个单位的水（蓝色部分表示水）。 感谢 Marcos 贡献此图。
 *
 * @Author: LH
 * @Date: 2021/4/2 9:47
 */
public class trap {
}

class Solution {
    // 动态规划，提前获取
    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) return 0;

        // 预处理，正序遍历数组，获得每个下标左侧的 height 最大值
        int[] leftMax = new int[n];
        // 边界处理
        leftMax[0] = height[0];
        for (int i = 1; i < n; ++i) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        // 预处理，逆序遍历数组，获得每个下标右侧的 height 最大值
        int[] rightMax = new int[n];
        // 边界处理
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ans;
    }

    // 单调栈
    public int trap1(int[] height) {
        int ans = 0;
        // 栈内存放下标，下标对应的 height 单调递减
        Deque<Integer> stack = new LinkedList<>();
        int n = height.length;
        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int right = stack.pop();
                if (stack.isEmpty()) break;
                int left = stack.peek();
                int curWidth = i - left - 1;
                int curHeight = Math.min(height[left], height[i]) - height[right];
                ans += curHeight * curWidth;
            }
            stack.push(i);
        }
        return ans;
    }
}