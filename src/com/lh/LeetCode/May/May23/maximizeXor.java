package com.lh.LeetCode.May.May23;

/**
 * 1707. 与数组中元素的最大异或值
 * 给你一个由非负整数组成的数组 nums 。另有一个查询数组 queries ，其中 queries[i] = [xi, mi] 。
 * <p>
 * 第 i 个查询的答案是 xi 和任何 nums 数组中不超过 mi 的元素按位异或（XOR）得到的最大值。换句话说，答案是 max(nums[j] XOR xi) ，其中所有 j 均满足 nums[j] <= mi 。如果 nums 中的所有元素都大于 mi，最终答案就是 -1 。
 * <p>
 * 返回一个整数数组 answer 作为查询的答案，其中 answer.length == queries.length 且 answer[i] 是第 i 个查询的答案。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length, queries.length <= 105
 * queries[i].length == 2
 * 0 <= nums[j], xi, mi <= 109
 *
 * @Author: LH
 * @Date: 2021/5/24 15:54
 */
public class maximizeXor {
}

class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        Trie trie = new Trie();
        for (int val : nums) {
            trie.insert(val);
        }
        int numQ = queries.length;
        int[] ans = new int[numQ];
        for (int i = 0; i < numQ; ++i) {
            ans[i] = trie.getMaxXorWithLimit(queries[i][0], queries[i][1]);
        }
        return ans;
    }
}

/**
 * 字典树及相关方法
 */
class Trie {
    static final int L = 30;
    Trie[] children = new Trie[2];
    int min = Integer.MAX_VALUE;

    public void insert(int val) {
        Trie node = this;
        node.min = Math.min(node.min, val);
        for (int i = L - 1; i >= 0; --i) {
            int bit = (val >> i) & 1;
            if (node.children[bit] == null) {
                node.children[bit] = new Trie();
            }
            node = node.children[bit];
            node.min = Math.min(node.min, val);
        }
    }

    public int getMaxXorWithLimit(int val, int limit) {
        Trie node = this;
        if (node.min > limit) {
            return -1;
        }
        int ans = 0;
        for (int i = L - 1; i >= 0; --i) {
            int bit = (val >> i) & 1;
            if (node.children[bit ^ 1] != null && node.children[bit ^ 1].min <= limit) {
                ans |= 1 << i;
                bit ^= 1;
            }
            node = node.children[bit];
        }
        return ans;
    }
}