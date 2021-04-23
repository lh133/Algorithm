package com.lh.LeetCode.March.March4;

/**
 * 300. 最长递增子序列
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 * 提示：
 * 1 <= nums.length <= 2500
 * -104 <= nums[i] <= 104
 * 进阶：
 * 你可以设计时间复杂度为 O(n^2) 的解决方案吗？    动态规划
 * 你能将算法的时间复杂度降低到 O(n log(n)) 吗?  贪心+二分查找
 *
 * @Author: LH
 * @Date: 2021/3/4 10:57
 */
public class lengthOfLIS {
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        Solution solution = new Solution();
        int ans1 = solution.lengthOfLIS(nums);
        int ans2 = solution.lengthOfLIS_1(nums);
        System.out.println("动态规划，时间复杂度为O(n^2):" + ans1 + "\n" + "贪心+二分查找,时间复杂度为O(n log(n)):" + ans2);
    }
}


class Solution {

    // 动态规划算法
    // 状态定义：dp[i] 表示以 nums[i] 结尾的「上升子序列」的长度
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        //当nums只有一个数时，直接返回1
        if (len == 0)
            return 0;
        int[] dp = new int[len];
        //dp[0]对应的nums只有一个元素，故为1
        dp[0] = 1;
        //初始化最初的数
        int max_ans = 1;
        for (int i = 0; i < len; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            max_ans = Math.max(max_ans, dp[i]);
        }
        return max_ans;
    }

    // 贪心+二分查找
    // 状态设计思想：依然着眼于某个上升子序列的 结尾的元素，如果已经得到的上升子序列的结尾的数越小，那么遍历的时候后面接上一个数，会有更大的可能构成一个长度更长的上升子序列。
    // 既然结尾越小越好，我们可以记录 在长度固定的情况下，结尾最小的那个元素的数值
    public int lengthOfLIS_1(int[] nums) {
        int len = nums.length;
        if (len <= 1)
            return len;
        // 维护一个tail数组表示长度为 i + 1 的 所有 上升子序列的结尾的最小值。tail数组必定是单调递增的
        // 在遍历数组 nums 的过程中，看到一个新数 num，如果这个数 严格 大于有序数组 tail 的最后一个元素，就把 num 放在有序数组 tail 的后面，否则进入第 2 点；
        // 注意：这里的大于是「严格大于」，不包括等于的情况。
        //
        //在有序数组 tail 中查找第 1 个等于大于 num 的那个数，试图让它变小；
        // 如果有序数组 tail 中存在 等于 num 的元素，什么都不做，因为以 num 结尾的最短的「上升子序列」已经存在；
        // 如果有序数组 tail 中存在 大于 num 的元素，找到第 1 个，让它变小，这样我们就找到了一个 结尾更小的相同长度的上升子序列。
        int[] tail = new int[len];
        tail[0] = nums[0];
        // end 表示有序数组 tail 的最后一个已经赋值元素的索引
        int end = 0;
        for (int i = 1; i < len; i++) {
            // 如果比tail数组末尾元素大，直接加在后面
            if (nums[i] > tail[end]) {
                tail[++end] = nums[i];
            } else {
                // 二分法查找
                int left = 0;
                int right = end;
                while (left < right) {
                    int mid = left + ((right - left) >>> 1);
                    if (tail[mid] < nums[i])
                        left = mid + 1;
                    else
                        right = mid;
                }
                tail[left] = nums[i];
            }
            // 测试tail维护情况
//            System.out.println(Arrays.toString(tail));
        }
        return ++end;
    }
}

