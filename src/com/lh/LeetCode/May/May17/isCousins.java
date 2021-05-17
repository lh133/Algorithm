package com.lh.LeetCode.May.May17;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 993. 二叉树的堂兄弟节点
 * 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
 * <p>
 * 如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。
 * <p>
 * 我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。
 * <p>
 * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。
 *
 * @Author: LH
 * @Date: 2021/5/17 11:15
 */
public class isCousins {
}

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        int[] x_depth = dfs(root, null, 0, x);
        int[] y_depth = dfs(root, null, 0, y);
        return x_depth[1] == y_depth[1] && x_depth[0] != y_depth[0];
    }

    /**
     * 深度优先搜索
     *
     * @param root   开始节点
     * @param father 开始节点的父节点
     * @param depth  开始深度
     * @param t      搜索目标值
     * @return [父节点的值, 当前搜索节点的深度]
     */
    private int[] dfs(TreeNode root, TreeNode father, int depth, int t) {
        if (root == null) return new int[]{-1, -1};//-1代表搜索不到目标值
        if (root.val == t) return new int[]{father != null ? father.val : 1, depth};//1代表搜索目标值为根节点
        int[] l = dfs(root.left, root, depth + 1, t);
        if (l[0] != -1) return l;
        return dfs(root.right, root, depth + 1, t);
    }

    /**
     * 广度优先搜索
     *
     * @param root 开始节点
     * @param t    搜索目标值
     * @return [父节点的值, 当前搜索节点的深度]
     */
    private int[] bfs(TreeNode root, int t) {
        Deque<Object[]> stack = new ArrayDeque<>();
        stack.addLast(new Object[]{root, null, 0});
        while (!stack.isEmpty()) {
            int size = stack.size();
            while (size-- > 0) {
                Object[] poll = stack.pollFirst();
                assert poll != null;
                TreeNode cur = (TreeNode) poll[0], father = (TreeNode) poll[1];
                int depth = (Integer) poll[2];

                if (cur.val == t) return new int[]{father != null ? father.val : 0, depth};
                if (cur.left != null) stack.addLast(new Object[]{cur.left, cur, depth + 1});
                if (cur.right != null) stack.addLast(new Object[]{cur.right, cur, depth + 1});
            }
        }
        return new int[]{-1, -1};
    }
}