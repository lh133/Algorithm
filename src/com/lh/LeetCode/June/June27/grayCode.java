package com.lh.LeetCode.June.June27;

import java.util.ArrayList;
import java.util.List;

/**
 * 89. 格雷编码
 * <p>
 * 格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。
 * <p>
 * 给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。即使有多个不同答案，你也只需要返回其中一种。
 * <p>
 * 格雷编码序列必须以 0 开头。
 *
 * @Author: LH
 * @Date: 2021/6/27 21:05
 */
public class grayCode {
}

class Solution2 {
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < 1 << n; ++i) {
            ans.add(i ^ i >> 1);
        }
        return ans;
    }
}