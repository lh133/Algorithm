package com.lh.LeetCode.February.February26;

/**
 * 2.两数相加
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 *
 * @Author: LH
 * @Date: 2021/2/26 11:33
 */
public class addTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        Solution2 solution2 = new Solution2();
        ListNode ans = solution2.addTwoNumbers(l1, l2);
        System.out.print("[" + ans.val + "," + ans.next.val + "," + ans.next.next.val + "," + ans.next.next.next.val + "]");
    }
}

class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //先初始化一个预先指针 pre，该指针的下一个节点指向真正的头结点head。
        //使用预先指针的目的在于链表初始化时无可用节点值，而且链表构造过程需要指针移动，进而会导致头指针丢失，无法返回结果。
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;

//            carry = sum / 10;
//            sum = sum % 10;
            carry = sum > 9 ? 1 : 0;
            sum = sum > 9 ? sum - 10 : sum;
            //给真正的头结点赋值
            cur.next = new ListNode(sum);

            cur = cur.next;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        //如果计算结束，carry=1，则末尾添加一位
        if (carry == 1) {
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }
}


//单链表定义，单个结点
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