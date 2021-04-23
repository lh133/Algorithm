package com.lh.LeetCode.March.March25;

/**
 * 剑指 Offer 18. 删除链表的节点
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * 返回删除后的链表的头节点。
 *
 * @Author: LH
 * @Date: 2021/3/25 17:32
 */
public class deleteNode {

}

class Solution {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteNode(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode tail = dummy;
        while (tail.next != null) {
            if (tail.next.val == val) {
                tail.next = tail.next.next;
            } else {
                tail = tail.next;
            }
        }
        return dummy.next;
    }
}
