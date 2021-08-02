package com.lh.LeetCode.July.July27;

/**
 * 671. 二叉树中第二小的节点
 * 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。
 * <p>
 * 更正式地说，root.val = min(root.left.val, root.right.val) 总成立。
 * <p>
 * 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
 * <p>
 * 提示：
 * <p>
 * 树中节点数目在范围 [1, 25] 内
 * 1 <= Node.val <= 231 - 1
 * 对于树中每个节点 root.val == min(root.left.val, root.right.val)
 *
 * @Author: LH
 * @Date: 2021/8/2 19:24
 */
public class findSecondMinimumValue {
}

class Solution {
    int ans;
    int rootValue;

    public int findSecondMinimumValue(TreeNode root) {
        ans = -1;
        rootValue = root.val;
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode node) {
        if (node == null) return;
        if (ans != -1 && node.val >= ans) return;
        if (node.val > rootValue) ans = node.val;
        dfs(node.left);
        dfs(node.right);
    }
}
