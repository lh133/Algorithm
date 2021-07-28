package com.lh.LeetCode.July.July23;

/**
 * 1893. 检查是否区域内所有整数都被覆盖
 * <p>
 * 给你一个二维整数数组 ranges 和两个整数 left 和 right 。每个 ranges[i] = [starti, endi] 表示一个从 starti 到 endi 的 闭区间 。
 * <p>
 * 如果闭区间 [left, right] 内每个整数都被 ranges 中 至少一个 区间覆盖，那么请你返回 true ，否则返回 false 。
 * <p>
 * 已知区间 ranges[i] = [starti, endi] ，如果整数 x 满足 starti <= x <= endi ，那么我们称整数x 被覆盖了。
 * <p>
 * 提示：
 * <p>
 * 1 <= ranges.length <= 50
 * 1 <= starti <= endi <= 50
 * 1 <= left <= right <= 50
 *
 * @Author: LH
 * @Date: 2021/7/23 10:18
 */
public class isCovered {
}

class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        int[] diff = new int[52];
        for (int[] range : ranges) {
            ++diff[range[0]];
            --diff[range[1] + 1];
        }

        int curr = 0;
        for (int i = 1; i <= 50; i++) {
            curr += diff[i];
            if (i >= left && i <= right && curr <= 0)
                return false;
        }
        return true;
    }
}
