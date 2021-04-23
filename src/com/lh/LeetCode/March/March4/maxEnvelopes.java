package com.lh.LeetCode.March.March4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 354. 俄罗斯套娃信封问题
 * 给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 * 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 * 说明:
 * 不允许旋转信封。
 * 解决方法：见第300题，注意 将 h 值作为排序的第二关键字进行降序排序，避免h值相等的情况出现
 *
 * @Author: LH
 * @Date: 2021/3/4 17:16
 */
public class maxEnvelopes {
    public static void main(String[] args) {
        int[][] envelopes = {{4, 5}, {4, 6}, {6, 7}, {2, 3}, {1, 1}};
        Solution1 solution1 = new Solution1();
        int i = solution1.maxEnvelopes(envelopes);
        System.out.println(i);
    }
}

class Solution1 {
    // 动态规划
    public int maxEnvelopes(int[][] envelopes) {
        int len = envelopes.length;
        if (len == 0) {
            return 0;
        }
        // 按w为第一关键字递增，h为第二关键字递减的顺序进行排序，避免 w 维度相等时组成套娃导致结果不符合题意
        Arrays.sort(envelopes, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            } else {
                return o1[1] - o2[1];
            }
        });

        int[] f = new int[len];
        // f[i]最小值为1
        Arrays.fill(f, 1);
        int ans = 1;
        for (int i = 1; i < len; ++i) {
            for (int j = 0; j < i; ++j) {
                if (envelopes[j][1] < envelopes[i][1])
                    f[i] = Math.max(f[i], f[j] + 1);
            }
            ans = Math.max(ans, f[i]);
        }
        return ans;
    }

    //二分查找+动态规划
    public int maxEnvelopes_1(int[][] envelopes) {
        if (envelopes.length == 0) {
            return 0;
        }

        int n = envelopes.length;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] e1, int[] e2) {
                if (e1[0] != e2[0]) {
                    return e1[0] - e2[0];
                } else {
                    return e2[1] - e1[1];
                }
            }
        });

        List<Integer> f = new ArrayList<>();
        f.add(envelopes[0][1]);
        for (int i = 1; i < n; ++i) {
            int num = envelopes[i][1];
            if (num > f.get(f.size() - 1)) {
                f.add(num);
            } else {
                int index = binarySearch(f, num);
                f.set(index, num);
            }
        }
        return f.size();
    }

    public int binarySearch(List<Integer> f, int target) {
        int low = 0, high = f.size() - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (f.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}