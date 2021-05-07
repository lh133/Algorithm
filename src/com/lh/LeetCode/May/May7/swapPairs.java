package com.lh.LeetCode.May.May7;

/**
 * 24. 两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * @Author: LH
 * @Date: 2021/5/7 10:07
 */
public class swapPairs {
}

class Solution2 {
    public ListNode swapPairs(ListNode head) {
        // 定义虚拟头结点
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            ListNode first = cur.next;
            ListNode second = cur.next.next;
            cur.next = second;
            first.next = second.next;
            second.next = first;
            cur = first;
        }
        return dummy.next;
    }

    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cur = head.next;
        head.next = swapPairs2(cur.next);
        cur.next = head;
        return cur;
    }
}