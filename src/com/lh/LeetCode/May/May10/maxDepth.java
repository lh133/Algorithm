package com.lh.LeetCode.May.May10;

/**
 * 104. 二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * @Author: LH
 * @Date: 2021/5/10 11:18
 */
public class maxDepth {
}

class Solution4 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        else {
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left, right) + 1;
        }
    }
}