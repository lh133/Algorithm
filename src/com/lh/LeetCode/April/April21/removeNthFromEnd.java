package com.lh.LeetCode.April.April21;

/**
 * 19. 删除链表的倒数第 N 个结点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 进阶：你能尝试使用一趟扫描实现吗？
 *
 * @Author: LH
 * @Date: 2021/4/21 16:16
 */
public class removeNthFromEnd {
    public static void main(String[] args) {
        ListNode n5 = new ListNode(5);
        ListNode n4 = new ListNode(4, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode head = new ListNode(1, n2);
        int n = 2;
        System.out.println(n3.next.val);
        new Solution4().removeNthFromEnd(head, n);
        System.out.println(n3.next.val);
    }
}

class Solution4 {
    // 双指针
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode right = head;
        ListNode left = dummy;
        for (int i = 0; i < n; i++) {
            right = right.next;
        }
        // left,right指针同时向右移动，直到right到达链表尾部，left的下一个结点就是倒数第n个结点
        while (right != null) {
            right = right.next;
            left = left.next;
        }
        // 删除left的下一个结点，即倒数第n个结点
        left.next = left.next.next;
        return dummy.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}