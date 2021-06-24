package com.lh.LeetCode.June.June24;

import java.util.HashMap;
import java.util.Map;

/**
 * 149. 直线上最多的点数
 * <p>
 * 给你一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点。求最多有多少个点在同一条直线上。
 * <p>
 * 提示：
 * <p>
 * 1 <= points.length <= 300
 * points[i].length == 2
 * -104 <= xi, yi <= 104
 * points 中的所有点 互不相同
 *
 * @Author: LH
 * @Date: 2021/6/24 10:05
 */
public class maxPoints {
}

class Solution {
    public int maxPoints(int[][] points) {
        if (points.length == 2) return 2;
        int n = points.length;
        int ans = 1;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int count = 2;
                // 枚举一条直线
                int x1 = points[i][0], y1 = points[i][1];
                int x2 = points[j][0], y2 = points[j][1];

                int deltaX = x2 - x1, deltaY = y2 - y1;

                // 判断[x3,y3]是否在直线上
                for (int k = j + 1; k < n; k++) {
                    int x3 = points[k][0], y3 = points[k][1];
                    if ((y3 - y1) * deltaX == (x3 - x1) * deltaY) count++;
                }
                if (count > ans) ans = count;
            }
        }
        return ans;
    }
}