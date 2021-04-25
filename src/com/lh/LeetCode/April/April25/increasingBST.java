package com.lh.LeetCode.April.April25;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 897. 递增顺序搜索树
 * 给你一棵二叉搜索树，请你 按中序遍历 将其重新排列为一棵递增顺序搜索树.
 * 使树中最左边的节点成为树的根节点，并且每个节点没有左子节点，只有一个右子节点。
 *
 * @Author: LH
 * @Date: 2021/4/25 22:49
 */
public class increasingBST {
    public static void main(String[] args) {

    }
}

// 递归
class Solution {
    List<TreeNode> list = new ArrayList<>();

    public TreeNode increasingBST(TreeNode root) {
        dfs(root);
        TreeNode dummy = new TreeNode(-1);
        TreeNode cur = dummy;
        for (TreeNode node :
                list) {
            cur.right = node;
            node.left = null;
            cur = node;
        }
        return dummy.right;
    }

    // 中序遍历，深度优先搜索
    void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        list.add(root);
        dfs(root.right);
    }
}

// 迭代
class Solution2 {
    List<TreeNode> list = new ArrayList<>();

    public TreeNode increasingBST(TreeNode root) {
        dfs(root);
        TreeNode dummy = new TreeNode(-1);
        TreeNode cur = dummy;
        for (TreeNode node : list) {
            cur.right = node;
            node.left = null;
            cur = node;
        }
        return dummy.right;
    }

    void dfs(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pollLast();
            list.add(cur);
            assert cur != null;
            cur = cur.right;
        }
    }
}