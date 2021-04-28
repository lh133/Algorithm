package com.lh.LeetCode.April.April27;

/**
 * 938. 二叉搜索树的范围和
 * 给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
 *
 * @Author: LH
 * @Date: 2021/4/28 14:58
 */
public class rangeSumBST {
    public static void main(String[] args) {

    }
}

class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;
        // root 节点的值大于 high
        // 由于二叉搜索树右子树上所有节点的值均大于根节点的值，即均大于 high，故无需考虑右子树，返回左子树的范围和。
        if (root.val > high) return rangeSumBST(root.left, low, high);
        // root 节点的值小于 low
        // 由于二叉搜索树左子树上所有节点的值均小于根节点的值，即均小于 low，故无需考虑左子树，返回右子树的范围和。
        if (root.val < low) return rangeSumBST(root.right, low, high);
        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }
}