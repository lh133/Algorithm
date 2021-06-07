package com.lh.LeetCode.June.June5;

/**
 * 203. 移除链表元素
 * <p>
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 * <p>
 * 提示：
 * <p>
 * 列表中的节点在范围 [0, 104] 内
 * 1 <= Node.val <= 50
 * 0 <= k <= 50
 *
 * @Author: LH
 * @Date: 2021/6/5 20:49
 */
public class removeElements {
}

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        dfs(dummy, dummy.next, val);
        return dummy.next;
    }

    /**
     * 递归搜索函数
     *
     * @param pre  当前节点
     * @param root 下一个节点
     * @param val  搜索值
     */
    private void dfs(ListNode pre, ListNode root, int val) {
        if (root == null) return;
        if (root.val == val) {
            pre.next = root.next;
        } else {
            pre = root;
        }
        dfs(pre, pre.next, val);
    }

    public ListNode removeElements2(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null) {
            if (cur.next.val == val)
                cur.next = cur.next.next;
            else
                cur = cur.next;
        }
        return dummy.next;
    }
}