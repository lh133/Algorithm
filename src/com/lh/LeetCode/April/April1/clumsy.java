package com.lh.LeetCode.April.April1;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 1006. 笨阶乘
 * 通常，正整数 n 的阶乘是所有小于或等于 n 的正整数的乘积。例如，factorial(10) = 10 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1。
 * 相反，我们设计了一个笨阶乘 clumsy：在整数的递减序列中，我们以一个固定顺序的操作符序列来依次替换原有的乘法操作符：乘法(*)，除法(/)，加法(+)和减法(-)。
 * 例如，clumsy(10) = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1。然而，这些运算仍然使用通常的算术运算顺序：我们在任何加、减步骤之前执行所有的乘法和除法步骤，并且按从左到右处理乘法和除法步骤。
 * 另外，我们使用的除法是地板除法（floor division），所以 10 * 9 / 8 等于 11。这保证结果是一个整数。
 * 实现上面定义的笨函数：给定一个整数 N，它返回 N 的笨阶乘。
 *
 * @Author: LH
 * @Date: 2021/4/1 15:29
 */
public class clumsy {
    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int i = 1; i <= 10000; i++) {
            int res = solution.clumsy(i);
            System.out.println(i + " : " + res + " : " + (res - i));
        }
    }
}

class Solution {
    public int clumsy(int N) {
        Deque<Integer> stack = new LinkedList<>();
        stack.push(N);
        N--;

        // 记录计算结果
        int ans = 0;
        // 用于四个一组，控制运算符
        int index = 0;
        while (N > 0) {
            if (index % 4 == 0) {
                stack.push(stack.pop() * N);
            } else if (index % 4 == 1) {
                stack.push(stack.pop() / N);
            } else if (index % 4 == 2) {
                stack.push(N);
            } else {
                // 直接入栈负值，下面处理直接相加即可
                stack.push(-N);
            }
            index++;
            N--;
        }

        // 栈内结果出栈求和
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }

    // 通过找规律进行结果输出
    public int clumsy1(int n) {
        int[] special = new int[]{1, 2, 6, 7};
        int[] diff = new int[]{1, 2, 2, -1};
        if (n <= 4) return special[(n - 1) % 4];
        return n + diff[n % 4];
    }
}