package com.lh.LeetCode.March.March26;

/**
 * 83. 删除排序链表中的重复元素
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 * 返回同样按升序排列的结果链表。
 * 提示：
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序排列
 *
 * @Author: LH
 * @Date: 2021/3/25 17:56
 */
public class deleteDuplicates {
    public static void main(String[] args) {

    }
}

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        // 初始值在链表值范围之外
        ListNode dummy = new ListNode(-101, head);
        ListNode tail = dummy;
        while (tail.next != null) {
            // 相等时跳过下一个重复值
            if (tail.val == tail.next.val) {
                tail.next = tail.next.next;
            } else {
                tail = tail.next;
            }
        }
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