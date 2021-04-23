package com.lh.LeetCode.April.April14;

 import java.util.Arrays;
import java.util.LinkedList;

/**
 * 剑指 Offer 06. 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 * @Author: LH
 * @Date: 2021/4/14 16:28
 */
public class reversePrint {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);

        head.next = n2;
        n2.next = n3;

        Solution solution = new Solution();
        int[] ans = solution.reversePrint(head);
        System.out.println(Arrays.toString(ans));
    }
}

class Solution {
    public int[] reversePrint(ListNode head) {
        LinkedList<Integer> stack = new LinkedList<>();
        ListNode node = head;
        while (node != null) {
            stack.addLast(node.val);
            node = node.next;
        }
        int[] ans = new int[stack.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = stack.removeLast();
        }
        return ans;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}