package com.lh.LeetCode.June.June19;

import java.util.ArrayList;
import java.util.List;

/**
 * 1239. 串联字符串的最大长度
 * <p>
 * 给定一个字符串数组 arr，字符串 s 是将 arr 某一子序列字符串连接所得的字符串，如果 s 中的每一个字符都只出现过一次，那么它就是一个可行解。
 * <p>
 * 请返回所有可行解 s 中最长长度。
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 104
 * s 仅有英文字母和空格 ' ' 组成
 *
 * @Author: LH
 * @Date: 2021/6/21 9:32
 */
public class maxLength {
}

class Solution {
    int ans = 0;

    public int maxLength(List<String> arr) {
        // masks保存无重复字母的字符串对应的二进制值，第i位为1表示字符集合中含有第i个小写字母
        List<Integer> masks = new ArrayList<>();
        for (String s : arr) {
            int mask = 0;
            for (int i = 0; i < s.length(); i++) {
                int ch = s.charAt(i) - 'a';
                if (((mask >> ch) & 1) != 0) { // mask 已有 ch，则说明 s 含有重复字母，无法构成可行解
                    mask = 0;
                    break;
                }
                mask |= 1 << ch;// ch加入mask中
            }
            if (mask > 0) masks.add(mask);
        }
        backtrack(masks, 0, 0);
        return ans;
    }

    /**
     * 回溯算法
     *
     * @param masks 保存无重复字母的字符串对应的二进制值的数组
     * @param pos   遍历到的mask的下标
     * @param mask  当前连接得到的字符串对应二进制数为mask
     */
    private void backtrack(List<Integer> masks, int pos, int mask) {
        if (pos == masks.size()) {
            ans = Math.max(ans, Integer.bitCount(mask));
            return;
        }
        // mask 和 masks[pos] 无重复字母
        if ((mask & masks.get(pos)) == 0) backtrack(masks, pos + 1, mask | masks.get(pos));
        backtrack(masks, pos + 1, mask);
    }
}