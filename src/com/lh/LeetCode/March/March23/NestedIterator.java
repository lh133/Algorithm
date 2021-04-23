package com.lh.LeetCode.March.March23;

import java.util.*;

/**
 * 341. 扁平化嵌套列表迭代器
 * 给你一个嵌套的整型列表。请你设计一个迭代器，使其能够遍历这个整型列表中的所有整数。
 * 列表中的每一项或者为一个整数，或者是另一个列表。其中列表的元素也可能是整数或是其他列表。
 *
 * @Author: LH
 * @Date: 2021/3/23 10:23
 */

interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    List<NestedInteger> getList();
}

public class NestedIterator implements Iterator<Integer> {

    // Deque模拟栈，仅使用栈的操作
    Deque<NestedInteger> stack = new ArrayDeque<>();

    // 将所有 NestedInteger 逆序存放到栈中
    public NestedIterator(List<NestedInteger> nestedList) {
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            NestedInteger item = nestedList.get(i);
            stack.addLast(item);
        }
    }

    // 判断是否有下一个整数
    @Override
    public boolean hasNext() {
        // 迭代结束条件
        if (stack.isEmpty()) {
            return false;
        } else {
            // 将栈顶元素赋值给item，判断其是否为 int
            NestedInteger item = stack.peekLast();
            if (item.isInteger()) {
                return true;
            } else {
                // 不是 int 类型则为NestedInteger，出栈并进行迭代
                item = stack.pollLast();
                assert item != null;
                List<NestedInteger> list = item.getList();
                // 该 NestedInteger 再次逆序放入栈中
                for (int i = list.size() - 1; i >= 0; i--) {
                    stack.addLast(list.get(i));
                }
                // 递归
                return hasNext();
            }
        }
    }

    // 返回下一个整数
    @Override
    public Integer next() {
        return hasNext() ? Objects.requireNonNull(stack.pollLast()).getInteger() : -1;
    }
}