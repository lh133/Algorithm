package com.lh.LeetCode.April.April1;

import java.util.ArrayList;
import java.util.List;

/**
 * 6. Z 字形变换
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 * 请你实现这个将字符串进行指定行数变换的函数：
 * string convert(string s, int numRows);
 *
 * @Author: LH
 * @Date: 2021/4/1 16:59
 */
public class convert {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        Solution1 solution1 = new Solution1();
        String ans = solution1.convert(s, numRows);
        System.out.println(ans);
    }

}

class Solution1 {
    public String convert(String s, int numRows) {

        if (numRows == 1) return s;

        // 按序保存每一行的字符，最后从上往下进行输出
        List<StringBuilder> rows = new ArrayList<>();

        // 创建足够的行保存字符
        for (int i = 0; i < Math.min(s.length(), numRows); ++i) {
            rows.add(new StringBuilder());
        }

        // 表示当前的行数
        int curRow = 0;
        // 控制转向，即切换行
        boolean flag = false;

        for (char c :
                s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) flag = !flag;
            curRow = curRow + (flag ? 1 : -1);
        }

        StringBuilder ans = new StringBuilder();
        for (StringBuilder row :
                rows) {
            ans.append(row);
        }

        return ans.toString();
    }

    // 找到行号与字符索引规律，直接放入结果集
    public String convert1(String s, int numRows) {
        if (numRows == 0) return s;

        StringBuilder ans = new StringBuilder();
        int n = s.length();
        // 读取周期
        int T = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += T) {
                ans.append(s.charAt(i + j));
                if (i != 0 && i != numRows - 1 && j + T - i < n)
                    ans.append(s.charAt(j + T - i));
            }
        }
        return ans.toString();
    }
}