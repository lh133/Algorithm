package com.lh.LeetCode.March.March27;

/**
 * 61. 旋转链表
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 * <p>
 * 提示：
 * 链表中节点的数目在范围 [0, 500] 内
 * -100 <= Node.val <= 100
 * 0 <= k <= 2 * 109
 *
 * @Author: LH
 * @Date: 2021/3/27 23:23
 */
public class rotateRight {
    public static void main(String[] args) {

    }
}

class Solution1 {
    // 使用「快慢指针」找到倒数第 k 个节点（新头结点）
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;
        // 计算有效的 k 值：对于与链表长度成整数倍的「旋转」都是没有意义的（旋转前后链表不变）
        // tot记录链表长度
        int tot = 0;
        ListNode tmp = head;
        // 获取链表长度
        while (tmp != null && ++tot > 0)
            tmp = tmp.next;
        // 对k取余
        k %= tot;
        if (k == 0)
            return head;

        // 使用「快慢指针」找到倒数第 k 个节点（新头结点）：latter会停在「新头结点」的「前一位」，也就是「新尾结点」
        ListNode former = head, latter = head;
        while (k-- > 0)
            former = former.next;
        while (former.next != null) {
            latter = latter.next;
            former = former.next;
        }
        // 保存新头结点，并将新尾结点的 next 指针置空
        ListNode newHead = latter.next;
        latter.next = null;
        // 将新链表的前半部分（原链表的后半部分）与原链表的头结点链接上
        former.next = head;
        return newHead;
    }

    //先成环，再断开：
    //找到原链表的最后一个节点，将其与原链表的头结点相连（成环），并统计链表长度，更新有效 k 值
    //从原链表的头节点出发，找到需要断开的点，进行断开
    public ListNode rotateRight1(ListNode head, int k) {
        if (head == null || k == 0) return head;
        // 先将链表成环，并记录链表的长度
        // tmp 会记录住原链表最后一位节点
        int tot = 0;
        ListNode tmp = head;
        while (tmp.next != null && ++tot > 0) tmp = tmp.next;
        tot++;
        k %= tot;
        if (k == 0) return head;

        // 正式成环
        tmp.next = head;

        // 从原链表 head 出发，走 tot-(k+1) 步，找到「新尾结点」进行断开，并将其下一个节点作为新节点返回
        k = tot - k - 1;
        while (k-- > 0) head = head.next;
        ListNode newHead = head.next;
        head.next = null;
        return newHead;
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