package com.lh.LeetCode.April.April26;

import java.util.Arrays;

/**
 * 1011. 在 D 天内送达包裹的能力
 * 传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。
 * 传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
 * 返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。
 *
 * @Author: LH
 * @Date: 2021/4/26 9:29
 */
public class shipWithinDays {
    public static void main(String[] args) {
        int[] weight = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int D = 5;
        System.out.println(new Solution().shipWithinDays(weight, D));
    }
}

class Solution {
    public int shipWithinDays(int[] weights, int D) {
        // 确定左右边界
        int left = Arrays.stream(weights).max().isPresent() ? Arrays.stream(weights).max().getAsInt() : 0;
        int right = Arrays.stream(weights).sum();
        while (left < right) {
            int mid = (left + right) / 2;
            // need 为需要运送的天数
            // cur 为当前这一天已经运送的包裹重量之和
            int need = 1, cur = 0;
            for (int weight :
                    weights) {
                if (cur + weight > mid) {
                    ++need;
                    cur = 0;
                }
            }
            if (need <= D)
                right = mid;
            else
                left = mid + 1;
        }
        return left;
    }
}