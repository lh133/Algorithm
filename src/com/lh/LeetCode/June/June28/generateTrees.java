package com.lh.LeetCode.June.June28;

import java.util.LinkedList;
import java.util.List;

/**
 * 95. 不同的二叉搜索树 II
 * <p>
 * 给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 8
 *
 * @Author: LH
 * @Date: 2021/6/28 11:04
 */
public class generateTrees {
}

class Solution3 {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new LinkedList<>();
        return dfs(1, n);
    }

    private List<TreeNode> dfs(int start, int end) {
        List<TreeNode> allTrees = new LinkedList<>();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTree = dfs(start, i - 1);

            List<TreeNode> rightTree = dfs(i + 1, end);

            for (TreeNode left : leftTree) {
                for (TreeNode right : rightTree) {
                    TreeNode cur = new TreeNode(i);
                    cur.left = left;
                    cur.right = right;
                    allTrees.add(cur);
                }
            }
        }
        return allTrees;
    }
}