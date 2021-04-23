package com.lh.LeetCode.April.April16;

import java.util.LinkedList;

/**
 * 剑指 Offer 09. 用两个栈实现队列
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 * @Author: LH
 * @Date: 2021/4/16 17:04
 */
public class Main {
    public static void main(String[] args) {
        CQueue queue = new CQueue();
        queue.appendTail(1);
        int i = queue.deleteHead();
        int i1 = queue.deleteHead();
        System.out.println(i + "," + i1);
    }
}

class CQueue {

    private final LinkedList<Integer> stack1, stack2;

    public CQueue() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    public void appendTail(int value) {
        stack1.addLast(value);
    }

    public int deleteHead() {
        if (!stack2.isEmpty()) return stack2.removeLast();
        if (stack1.isEmpty()) return -1;
        while (!stack1.isEmpty())
            stack2.addLast(stack1.removeLast());
        return stack2.removeLast();
    }
}