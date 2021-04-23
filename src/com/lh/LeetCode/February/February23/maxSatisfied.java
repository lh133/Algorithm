package com.lh.LeetCode.February.February23;

/**
 * 1052. 爱生气的书店老板
 * 今天，书店老板有一家店打算试营业 customers.length 分钟。每分钟都有一些顾客（customers[i]）会进入书店，所有这些顾客都会在那一分钟结束后离开。
 * 在某些时候，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。 当书店老板生气时，那一分钟的顾客就会不满意，不生气则他们是满意的。
 * 书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 X 分钟不生气，但却只能使用一次。
 * 请你返回这一天营业下来，最多有多少客户能够感到满意的数量。
 * 解决方法：滑动窗口
 *
 * @Author: LH
 * @Date: 2021/2/23 9:32
 */
public class maxSatisfied {
    public static void main(String[] args) {
        int[] customers = {1, 0, 1, 2, 1, 1, 7, 5};
        int[] grumpy =    {0, 1, 0, 1, 0, 1, 0, 1};
        int X = 3;
        Solution solution = new Solution();
        int ans = solution.maxSatisfied(customers, grumpy, X);
        System.out.println(ans);
    }
}

class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int init = 0;
        int len = customers.length;
        //所有老板没有生气的节点的顾客数目
        for (int i = 0; i < len; i++) {
            if (grumpy[i] == 0)
                init += customers[i];
        }
        //初始窗口内能挽留的顾客数目
        int count = 0;
        for (int i = 0; i < X; i++) {
            if (grumpy[i] == 1)
                count += customers[i];
        }
        //遍历数组 求解滑动窗口内最大值
        int max = count;
        for (int i = X; i < len; i++) {
            count = count - (customers[i - X] * grumpy[i - X]) + (customers[i] * grumpy[i]);//窗口开始滑动
            max = Math.max(max, count);
        }
        return init + max;
    }
}