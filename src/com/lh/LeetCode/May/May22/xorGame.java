package com.lh.LeetCode.May.May22;

/**
 * 810. 黑板异或游戏
 * 黑板上写着一个非负整数数组 nums[i] 。Alice 和 Bob 轮流从黑板上擦掉一个数字，Alice 先手。如果擦除一个数字后，剩余的所有数字按位异或运算得出的结果等于 0 的话，当前玩家游戏失败。 (另外，如果只剩一个数字，按位异或运算得到它本身；如果无数字剩余，按位异或运算结果为 0。）
 * <p>
 * 并且，轮到某个玩家时，如果当前黑板上所有数字按位异或运算结果等于 0，这个玩家获胜。
 * <p>
 * 假设两个玩家每步都使用最优解，当且仅当 Alice 获胜时返回 true。
 *
 * @Author: LH
 * @Date: 2021/5/22 11:36
 */
public class xorGame {
}

// 果序列 nums 本身异或和为 0，天然符合「先手必胜态」的条件，答案返回 True ；
// 如果序列 nums 异或和不为 0，但序列长度为偶数，那么最终会出现「后手必败态」，推导出先手必胜，答案返回 True。
class Solution {
    public boolean xorGame(int[] nums) {
        if (nums.length % 2 == 0)
            return true;
        int xor = 0;
        for (int i :
                nums) {
            xor ^= i;
        }
        return xor == 0;
    }
}