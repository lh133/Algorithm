package com.lh.LeetCode.March.March25;

/**
 * 82. 删除排序链表中的重复元素 II
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。
 * 返回同样按升序排列的结果链表。
 *
 * @Author: LH
 * @Date: 2021/3/25 16:12
 */
public class deleteDuplicates2 {
    public static void main(String[] args) {
    }
}

class Solution2 {
    public ListNode deleteDuplicates(ListNode head) {
        // 虚拟头结点
        ListNode dummy = new ListNode();
        // 遍历到的位置，也即结果链表的结尾
        ListNode tail = dummy;
        while (head != null) {
            if (head.next == null || head.val != head.next.val) {
                tail.next = head;
                tail = head;
            }
            // 跳过相同结点
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            head = head.next;
        }
        tail.next = null;
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