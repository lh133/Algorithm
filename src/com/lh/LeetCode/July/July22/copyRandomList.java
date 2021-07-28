package com.lh.LeetCode.July.July22;

/**
 * 138. 复制带随机指针的链表
 * <p>
 * 给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
 * <p>
 * 构造这个链表的 深拷贝。 深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。复制链表中的指针都不应指向原链表中的节点 。
 * <p>
 * 例如，如果原链表中有 X 和 Y 两个节点，其中 X.random --> Y 。那么在复制链表中对应的两个节点 x 和 y ，同样有 x.random --> y 。
 * <p>
 * 返回复制链表的头节点。
 * <p>
 * 用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
 * <p>
 * val：一个表示 Node.val 的整数。
 * random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
 * 你的代码 只 接受原链表的头节点 head 作为传入参数。
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 1000
 * -10000 <= Node.val <= 10000
 * Node.random 为空（null）或指向链表中的节点。
 *
 * @Author: LH
 * @Date: 2021/7/23 9:42
 */
public class copyRandomList {
}

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        // 在原链表每个节点后添加一个相同值的节点 A->B->C ==> A->A`->B->B`->C->C`
        for (Node node = head; node != null; node = node.next.next) {
            Node copy = new Node(node.val);
            copy.next = node.next;
            node.next = copy;
        }

        // 将random节点映射到拷贝节点上
        for (Node node = head; node != null; node = node.next.next) {
            Node copy = node.next;
            copy.random = (node.random != null) ? node.random.next : null;
        }

        Node copyHead = head.next;
        for (Node node = head; node != null; node = node.next) {
            Node copy = node.next;
            // 还原原链表，拆分拷贝结果
            node.next = node.next.next;
            // 组合拷贝结果
            copy.next = (copy.next != null) ? copy.next.next : null;
        }
        return copyHead;
    }
}