package com.lh.LeetCode.May.May20;

/**
 * 38. 外观数列
 * 给定一个正整数 n ，输出外观数列的第 n 项。
 * <p>
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
 * <p>
 * 你可以将其视作是由递归公式定义的数字字符串序列：
 * <p>
 * countAndSay(1) = "1"
 * countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。
 * 前五项如下：
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 第一项是数字 1
 * 描述前一项，这个数是 1 即 “ 一 个 1 ”，记作 "11"
 * 描述前一项，这个数是 11 即 “ 二 个 1 ” ，记作 "21"
 * 描述前一项，这个数是 21 即 “ 一 个 2 + 一 个 1 ” ，记作 "1211"
 * 描述前一项，这个数是 1211 即 “ 一 个 1 + 一 个 2 + 二 个 1 ” ，记作 "111221"
 * 要 描述 一个数字字符串，首先要将字符串分割为 最小数量的组，每个组都由连续的最多相同字符组成。
 * 然后对于每个组，先描述字符的数量，然后描述字符，形成一个描述组。
 * 要将描述转换为数字字符串，先将每组中的字符数量用数字替换，再将所有描述组连接起来。
 *
 * @Author: LH
 * @Date: 2021/5/20 9:42
 */
public class countAndSay {
    public static void main(String[] args) {
        System.out.println(new Solution2().countAndSay(4));
    }
}

class Solution2 {
    public String countAndSay(int n) {
        String ans = "1";
        int count;
        for (int i = 2; i <= n; ++i) {
            StringBuilder builder = new StringBuilder();
            count = 1;
            char pre = ans.charAt(0);
            for (int j = 1; j < ans.length(); ++j) {
                char c = ans.charAt(j);
                if (c == pre) {
                    count++;
                } else {
                    builder.append(count).append(pre);
                    pre = c;
                    count = 1;
                }
            }
            builder.append(count).append(pre);
            ans = builder.toString();
        }
        return ans;
    }
}