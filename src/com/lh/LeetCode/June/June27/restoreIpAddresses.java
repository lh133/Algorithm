package com.lh.LeetCode.June.June27;

import java.util.ArrayList;
import java.util.List;

/**
 * 93. 复原 IP 地址
 * <p>
 * 给定一个只包含数字的字符串，用以表示一个 IP 地址，返回所有可能从 s 获得的 有效 IP 地址 。你可以按任何顺序返回答案。
 * <p>
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * <p>
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 3000
 * s 仅由数字组成
 *
 * @Author: LH
 * @Date: 2021/6/27 21:20
 */
public class restoreIpAddresses {
}

class Solution3 {
    // IP的段数
    static final int SEG_COUNT = 4;

    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        int[] path = new int[SEG_COUNT];
        dfs(s, path, ans, 0, 0);
        return ans;
    }

    /**
     * 回溯
     *
     * @param s      原字符串
     * @param path   保存四段ip的数组
     * @param ans    结果集
     * @param segIDX 数组索引
     * @param start  字符串开始位置
     */
    private void dfs(String s, int[] path, List<String> ans, int segIDX, int start) {
        // 找到4段IP并遍历完字符串，则为有效答案
        if (segIDX == SEG_COUNT) {
            if (start == s.length()) {
                StringBuilder addr = new StringBuilder();
                for (int i = 0; i < SEG_COUNT; i++) {
                    addr.append(path[i]);
                    if (i != SEG_COUNT - 1) addr.append('.');
                }
                ans.add(addr.toString());
            }
            return;
        }

        // 遍历完字符串还没找到
        if (start == s.length()) return;

        // 当前数字为0，则这段IP为0
        if (s.charAt(start) == '0') {
            path[segIDX] = 0;
            dfs(s, path, ans, segIDX + 1, start + 1);
        }

        // 寻找每段IP
        int addr = 0;
        for (int end = start; end < s.length(); end++) {
            addr = addr * 10 + (s.charAt(end) - '0');
            if (addr > 0 && addr <= 0xff) {
                path[segIDX] = addr;
                dfs(s, path, ans, segIDX + 1, end + 1);
            } else {
                break;
            }
        }
    }
}
