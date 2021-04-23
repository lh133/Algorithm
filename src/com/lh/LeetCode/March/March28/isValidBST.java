package com.lh.LeetCode.March.March28;

/**
 * 98. 验证二叉搜索树
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 假设一个二叉搜索树具有如下特征：
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 * @Author: LH
 * @Date: 2021/3/31 16:23
 */
public class isValidBST {

}

class Solution1 {
    double pre = -Double.MAX_VALUE;

    // 二叉搜索树中序遍历为递增的，所以使用中序遍历判断是否递增即可
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        // 访问左子树
        if (!isValidBST(root.left)) return false;
        // 判断当前节点
        if (root.val <= pre) return false;
        // 保存当前值
        pre = root.val;
        // 访问右子树
        return isValidBST(root.right);
    }
}
