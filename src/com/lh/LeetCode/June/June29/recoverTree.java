package com.lh.LeetCode.June.June29;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 99. 恢复二叉搜索树
 * <p>
 * 给你二叉搜索树的根节点 root ，该树中的两个节点被错误地交换。请在不改变其结构的情况下，恢复这棵树。
 * <p>
 * 进阶：使用 O(n) 空间复杂度的解法很容易实现。你能想出一个只使用常数空间的解决方案吗？
 * <p>
 * 提示：
 * <p>
 * 树上节点的数目在范围 [2, 1000] 内
 * -231 <= Node.val <= 231 - 1
 *
 * @Author: LH
 * @Date: 2021/6/29 10:05
 */
public class recoverTree {
}

class Solution3 {
    public void recoverTree(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode x = null, y = null, pre = null;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // 使用pre保存前一次的节点，与当前节点进行比较
            if (pre != null && root.val < pre.val) {
                y = root;
                if (x == null) x = pre;
                else break;
            }
            pre = root;
            root = root.right;
        }
        swap(x, y);
    }

    // 交换值
    private void swap(TreeNode x, TreeNode y) {
        int tmp = x.val;
        x.val = y.val;
        y.val = tmp;
    }
}