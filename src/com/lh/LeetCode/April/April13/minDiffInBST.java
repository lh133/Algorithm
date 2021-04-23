package com.lh.LeetCode.April.April13;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 783. 二叉搜索树节点最小距离
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 *
 * @Author: LH
 * @Date: 2021/4/13 14:32
 */
public class minDiffInBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(6);

        root.left = n1;
        root.right = n4;
        n1.left = n2;
        n1.right = n3;

        Solution solution = new Solution();
        System.out.println(solution.minDiffInBST(root));
    }
}

//递归
class Solution {
    int ans = Integer.MAX_VALUE;
    TreeNode pre = null;

    public int minDiffInBST(TreeNode root) {
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (pre != null)
            ans = Math.min(ans, root.val - pre.val);
        pre = root;
        dfs(root.right);
    }
}

// 迭代
class Solution2 {
    public int minDiffInBST(TreeNode root) {
        int ans = Integer.MAX_VALUE;
        TreeNode pre = null;
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre != null) {
                ans = Math.min(ans, root.val - pre.val);
            }
            pre = root;
            root = root.right;
        }
        return ans;
    }
}

// 二叉树定义
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