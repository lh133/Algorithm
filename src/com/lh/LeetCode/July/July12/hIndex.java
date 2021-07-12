package com.lh.LeetCode.July.July12;

/**
 * 275. H 指数 II
 * <p>
 * 给定一位研究者论文被引用次数的数组（被引用次数是非负整数），数组已经按照 升序排列 。编写一个方法，计算出研究者的 h 指数。
 * <p>
 * h 指数的定义: “h 代表“高引用次数”（high citations），一名科研人员的 h 指数是指他（她）的 （N 篇论文中）总共有 h 篇论文分别被引用了至少 h 次。（其余的 N - h 篇论文每篇被引用次数不多于 h 次。）"
 * <p>
 * 说明:
 * <p>
 * 如果 h 有多有种可能的值 ，h 指数是其中最大的那个。
 * <p>
 * 进阶：
 * <p>
 * 这是 H 指数 的延伸题目，本题中的 citations 数组是保证有序的。
 * 你可以优化你的算法到对数时间复杂度吗？
 *
 * @Author: LH
 * @Date: 2021/7/12 11:10
 */
public class hIndex {
}

class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int left = 0, right = n - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (citations[mid] >= n - mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return citations[left] >= n - left ? n - left : 0;
    }
}