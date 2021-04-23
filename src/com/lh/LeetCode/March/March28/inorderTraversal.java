package com.lh.LeetCode.March.March28;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 * <p>
 * 提示：
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 *
 * @Author: LH
 * @Date: 2021/3/28 9:29
 */
public class inorderTraversal {
    public static void main(String[] args) {

    }
}

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    /**
     * 递归解法
     *
     * @param root 根节点
     * @param res  结果集
     */
    private void inorder(TreeNode root, List<Integer> res) {
        if (root == null)
            return;
        // 先递归遍历左子树
        inorder(root.left, res);
        // root节点值加入结果
        res.add(root.val);
        // 递归遍历右子树
        inorder(root.right, res);
    }

    // 迭代法中序遍历
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}