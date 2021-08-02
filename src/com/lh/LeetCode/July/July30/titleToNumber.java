package com.lh.LeetCode.July.July30;

/**
 * 171. Excel 表列序号
 * <p>
 * 给你一个字符串 columnTitle ，表示 Excel 表格中的列名称。返回该列名称对应的列序号。
 * <p>
 * 提示：
 * <p>
 * 1 <= columnTitle.length <= 7
 * columnTitle 仅由大写英文组成
 * columnTitle 在范围 ["A", "FXSHRXW"] 内
 *
 * @Author: LH
 * @Date: 2021/8/2 20:03
 */
public class titleToNumber {
}

class Solution {
    public int titleToNumber(String columnTitle) {
        int ans = 0;
        int multi = 1;
        for (int i = columnTitle.length() - 1; i >= 0; i--) {
            int k = columnTitle.charAt(i) - 'A' + 1;
            ans += k * multi;
            multi *= 26;
        }
        return ans;
    }
}