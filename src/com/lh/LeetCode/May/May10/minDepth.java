package com.lh.LeetCode.May.May10;

/**
 * 111. 二叉树的最小深度
 * 给定一个二叉树，找出其最小深度。
 * <p>
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * <p>
 * 说明：叶子节点是指没有子节点的节点。
 *
 * @Author: LH
 * @Date: 2021/5/10 11:21
 */
public class minDepth {
}

class Solution4 {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;

        int min_depth = Integer.MAX_VALUE;
        if (root.left != null) min_depth = Math.min(minDepth(root.left), min_depth);
        if (root.right != null) min_depth = Math.min(minDepth(root.right), min_depth);

        return min_depth + 1;
    }
}