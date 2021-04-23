package com.lh.LeetCode.March.March18;

/**
 * @Author: LH
 * @Date: 2021/3/18 22:26
 */
public class reverseBetween {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Solution.ListNode head = new Solution.ListNode(1);
        head.next = new Solution.ListNode(2);
        head.next.next = new Solution.ListNode(3);
        head.next.next.next = new Solution.ListNode(4);
        head.next.next.next.next = new Solution.ListNode(5);
        int left = 2, right = 4;
        Solution.ListNode ans = solution.reverseBetween(head, left, right);
        System.out.println("[" + ans.val + "," + ans.next.val + "," + ans.next.next.val + "," + ans.next.next.next.val + "," + ans.next.next.next.next.val + "]");
    }
}

class Solution {

    // Definition for singly-linked list.
    public static class ListNode {
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

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode listNode = new ListNode(-1);
        listNode.next = head;
        // 永远指向待反转区域的第一个节点 left 的前一个节点
        ListNode pre = listNode;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        // 指向待反转区域的第一个节点 left
        ListNode cur = pre.next;
        ListNode next;
        // 建议画图理解节点的交换
        for (int i = 0; i < right - left; i++) {
            // next永远指向cur的下一个节点
            next = cur.next;
            // ①将cur节点的下一个结点指向next节点的下一个节点，结合②next.next = pre.next 将cur节点移动到cur的下一个节点即当前next处
            cur.next = next.next;
            // ②将next节点的下一个节点指向pre节点的下一个节点，结合③pre.next = next 将next节点的值放到pre后
            next.next = pre.next;
            // ③将pre节点的下一个节点指向next节点，即将next节点放到pre之后
            pre.next = next;
        }
        return listNode.next;
    }
}
