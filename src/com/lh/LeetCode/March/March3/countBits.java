package com.lh.LeetCode.March.March3;

import java.util.Arrays;

/**
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 * 进阶:
 * 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
 * 要求算法的空间复杂度为O(n)。
 * 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 java 中的 Integer.bitCount）来执行此操作。
 * 解决方法：动态规划
 *
 * @Author: LH
 * @Date: 2021/3/3 10:44
 */
public class countBits {
    public static void main(String[] args) {
        int num = 4;
        Solution solution = new Solution();
        int[] bits = solution.countBits(num);
        System.out.println(Arrays.toString(bits));
    }
}

class Solution {
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            //ans[i] = 「i >> 1 所包含的 1 的个数」+「i 的最低位是否为 1」
            ans[i] = ans[i >> 1] + (i & 1);
        }
        return ans;
    }
}