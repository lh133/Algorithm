package com.lh.LeetCode.June.June5;

/**
 * 86. 分隔链表
 * <p>
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * <p>
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目在范围 [0, 200] 内
 * -100 <= Node.val <= 100
 * -200 <= x <= 200
 *
 * @Author: LH
 * @Date: 2021/6/7 16:58
 */
public class partition {
}

class Solution2 {
    public ListNode partition(ListNode head, int x) {
        // 存放比x小的
        ListNode small = new ListNode(0);
        // 虚拟头节点
        ListNode dummySmall = small;
        // 存放比x大的
        ListNode large = new ListNode(0);
        // 虚拟头节点
        ListNode dummyLarge = large;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        large.next = null;
        small.next = dummyLarge.next;
        return dummySmall.next;
    }
}