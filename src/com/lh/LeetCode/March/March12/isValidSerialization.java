package com.lh.LeetCode.March.March12;

import java.util.LinkedList;

/**
 * 331. 验证二叉树的前序序列化
 * 序列化二叉树的一种方法是使用前序遍历。当我们遇到一个非空节点时，我们可以记录下这个节点的值。如果它是一个空节点，我们可以使用一个标记值记录，例如 #。
 * 例如，下面的二叉树可以被序列化为字符串 "9,3,4,#,#,1,#,#,2,#,6,#,#"，其中 # 代表一个空节点。
 * 给定一串以逗号分隔的序列，验证它是否是正确的二叉树的前序序列化。编写一个在不重构树的条件下的可行算法。
 * 每个以逗号分隔的字符或为一个整数或为一个表示 null 指针的 '#' 。
 * 你可以认为输入格式总是有效的，例如它永远不会包含两个连续的逗号，比如 "1,,3" 。
 *
 * @Author: LH
 * @Date: 2021/3/14 22:04
 */
//      _9_
//     /   \
//    3     2
//   / \   / \
//  4   1  #  6
// / \ / \   / \
// # # # #   # #
public class isValidSerialization {
    public static void main(String[] args) {
        String s = "9,3,4,#,#,1,#,#,2,#,6,#,#";
        Solution solution = new Solution();
        boolean ans = solution.isValidSerialization(s);
        boolean ans1 = solution.isValidSerialization1(s);
        System.out.println("ans1：" + ans);
        System.out.println("ans2：" + ans1);
    }
}

class Solution {

    // 方法一，使用栈解决，由于是前序遍历，把有效的叶子节点使用 "#" 代替，即x，#，#替换为#
    public boolean isValidSerialization(String s) {
        // 定义一个栈，暂存结果
        LinkedList<String> stack = new LinkedList<>();
        String[] ss = s.split(",");
        for (String c : ss) {
            stack.push(c);
            while (stack.size() >= 3
                    && stack.get(0).equals("#")
                    && stack.get(1).equals("#")
                    && !stack.get(2).equals("#")) {
                stack.pop();
                stack.pop();
                stack.pop();
                stack.push("#");
            }
        }
        return stack.size() == 1 && stack.poll().equals("#");
    }

    //方法二，使用入度出度判断
    public boolean isValidSerialization1(String s) {
        char[] cs = s.toCharArray();
        int out = 0, in = -1;
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == ',')
                continue;
            in++;
            if (out < in)
                return false;
            if (cs[i] <= '9' && cs[i] >= '0') {
                out += 2;
                while (i < cs.length - 1 && cs[i + 1] >= '0' && cs[i + 1] <= '9')
                    i++;
            }
        }
        return out == in;
    }
}