package com.lh.LeetCode.March.March22;

/**
 * 191. 位1的个数
 * 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。
 * 提示：
 * 请注意，在 Java 中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
 * 在 Java 中，编译器使用二进制补码记法来表示有符号整数。
 * 提示：
 * 输入必须是长度为 32 的 二进制串 。
 * 进阶：
 * 如果多次调用这个函数，你将如何优化你的算法？
 *
 * @Author: LH
 * @Date: 2021/3/22 22:41
 */
public class hammingWeight {
    public static void main(String[] args) {
        int n = 00000000000000000000000000001011;
        Solution solution = new Solution();
        int ans = solution.hammingWeight(n);
        int ans1 = solution.hammingWeight1(n);
        int ans2 = solution.hammingWeight2(n);
        System.out.println("ans:" + ans + "\nans1:" + ans1 + "\nans2:" + ans2);
    }
}

class Solution {
    // 右移32次，依次判断，这种方法会判断前面的0
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; ++i) {
            count += n & 1;
            n = n >> 1;
        }
        return count;
    }

    // 消除最后一个1
    public int hammingWeight1(int n) {
        int ans = 0;
        while (n != 0) {
            ans++;
            n = n & (n - 1);
        }
        return ans;
    }

    // 分组统计解法，暂时看不明白，待研究
    // 这个算法是一种合并计数器的策略。把输入数的32Bit当作32个计数器，代表每一位的1个数。
    // 然后合并相邻的2个“计数器”，使i成为16个计数器，每个计数器的值就是这2个Bit的1的个数；
    // 继续合并相邻的2个“计数器“，使i成为8个计数器，每个计数器的值就是4个Bit的1的个数。
    // 依次类推，直到将i变成一个计数器，那么它的值就是32Bit的i中值为1的Bit的个数。
    public int hammingWeight2(int n) {
        n = (n & 0x55555555) + ((n >>> 1) & 0x55555555); // 0x55555555 = 01010101010101010101010101010101
        n = (n & 0x33333333) + ((n >>> 2) & 0x33333333); // 0x33333333 = 00110011001100110011001100110011
        n = (n & 0x0f0f0f0f) + ((n >>> 4) & 0x0f0f0f0f); // 0x0f0f0f0f = 00001111000011110000111100001111
        n = (n & 0x00ff00ff) + ((n >>> 8) & 0x00ff00ff); // 0x00ff00ff = 00000000111111110000000011111111
        n = (n & 0x0000ffff) + ((n >>> 16) & 0x0000ffff);// 0x0000ffff = 00000000000000001111111111111111
        return n;
    }
}