package com.lh.LeetCode.July.July24;

/**
 * 1736. 替换隐藏数字得到的最晚时间
 * <p>
 * 给你一个字符串 time ，格式为 hh:mm（小时：分钟），其中某几位数字被隐藏（用 ? 表示）。
 * <p>
 * 有效的时间为 00:00 到 23:59 之间的所有时间，包括 00:00 和 23:59 。
 * <p>
 * 替换 time 中隐藏的数字，返回你可以得到的最晚有效时间。
 * <p>
 * 提示：
 * <p>
 * time 的格式为 hh:mm
 * 题目数据保证你可以由输入的字符串生成有效的时间
 *
 * @Author: LH
 * @Date: 2021/7/28 9:51
 */
public class maximumTime {
}

class Solution {
    public String maximumTime(String time) {
        char[] arr = time.toCharArray();
        if (arr[0] == '?') {
            arr[0] = ('4' <= arr[1] && arr[1] <= '9') ? '1' : '2';
        }
        if (arr[1] == '?') {
            arr[1] = (arr[0] == '2') ? '3' : '9';
        }
        if (arr[3] == '?') {
            arr[3] = '5';
        }
        if (arr[4] == '?') {
            arr[3] = '9';
        }
        return new String(arr);
    }
}