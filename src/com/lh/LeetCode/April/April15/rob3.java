package com.lh.LeetCode.April.April15;

/**
 * 337. 打家劫舍 III
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。
 * 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 *
 * @Author: LH
 * @Date: 2021/4/16 11:01
 */
public class rob3 {
    public static void main(String[] args) {

    }
}

class Solution3 {
    public int rob(TreeNode root) {
        int[] result = robFunc(root);
        return Math.max(result[0], result[1]);
    }

    private int[] robFunc(TreeNode root) {
        if (root == null)
            return new int[2];
        // 0代表不偷当前结点，1代表偷当前结点
        int[] result = new int[2];

        int[] left = robFunc(root.left);
        int[] right = robFunc(root.right);

        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        result[1] = left[0] + right[0] + root.val;
        return result;
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