package com.lh.LeetCode.May.May10;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 872. 叶子相似的树
 * 请考虑一棵二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
 * <p>
 * 举个例子，如上图所示，给定一棵叶值序列为 (6, 7, 4, 9, 8) 的树。
 * <p>
 * 如果有两棵二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。
 * <p>
 * 如果给定的两个根结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。
 *
 * @Author: LH
 * @Date: 2021/5/10 9:58
 */
public class leafSimilar {
}

class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        dfs(root1, list1);

        List<Integer> list2 = new ArrayList<>();
        dfs(root2, list2);
        return list1.equals(list2);
    }

    /**
     * 深度优先遍历，获取叶值序列。递归
     *
     * @param root 树的根节点
     * @param list 叶值序列
     */
    private void dfs(TreeNode root, List<Integer> list) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            list.add(root.val);
            return;
        }
        dfs(root.left, list);
        dfs(root.right, list);
    }

    /**
     * 迭代
     *
     * @param root 树的根节点
     * @param list 叶值序列
     */
    private void _dfs(TreeNode root, List<Integer> list) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.left == null && root.right == null) list.add(root.val);
            root = root.right;
        }
    }
}