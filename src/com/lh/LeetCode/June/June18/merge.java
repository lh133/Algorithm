package com.lh.LeetCode.June.June18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 56. 合并区间
 * <p>
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 * <p>
 * 提示：
 * <p>
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 *
 * @Author: LH
 * @Date: 2021/6/18 15:38
 */
public class merge {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println(Arrays.deepToString(new Solution2().merge(intervals)));
    }
}

class Solution2 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[0][2];
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        // 保存合并后的结果
        List<int[]> merged = new ArrayList<>();
        for (int[] interval : intervals) {
            int L = interval[0], R = interval[1];
            // 当前区间左端点在merged集合最后一个区间的右端点之后，则两个区间没有重合，直接加入merged数组末尾
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) merged.add(new int[]{L, R});
                // 否则用当前区间的右端点更新数组 merged 中最后一个区间的右端点，取最大值
            else merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
        }
        return merged.toArray(new int[merged.size()][]);
    }
}