package com.lh.LeetCode.June.June18;

import java.util.ArrayList;
import java.util.List;

/**
 * 57. 插入区间
 * <p>
 * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
 * <p>
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * <p>
 * 提示：
 * <p>
 * 0 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= intervals[i][0] <= intervals[i][1] <= 105
 * intervals 根据 intervals[i][0] 按 升序 排列
 * newInterval.length == 2
 * 0 <= newInterval[0] <= newInterval[1] <= 105
 *
 * @Author: LH
 * @Date: 2021/6/18 16:15
 */
public class insert {
}

class Solution3 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0], right = newInterval[1];
        boolean placed = false;
        List<int[]> ansList = new ArrayList<>();
        for (int[] interval : intervals) {
            if (interval[0] > right) {
                // interval在插入区间的右侧且无交集
                if (!placed) {
                    // 还未替换
                    ansList.add(new int[]{left, right});
                    placed = true;
                }
                ansList.add(interval);
            } else if (interval[1] < left) {
                // interval在插入区间左侧且无交集
                ansList.add(interval);
            } else {
                // interval与插入区间有交集，计算并集
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }
        // 如果没有找到插入位置，则放到最后位置
        if (!placed) {
            ansList.add(new int[]{left, right});
        }
        return ansList.toArray(new int[ansList.size()][]);
    }
}