package com.lh.LeetCode.April.April21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 四数之和
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * 注意：答案中不可以包含重复的四元组。
 *
 * @Author: LH
 * @Date: 2021/4/21 15:49
 */
public class fourSum {
    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        System.out.println(new Solution3().fourSum(nums, target).toString());
    }
}

class Solution3 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 4) return ans;
        int n = nums.length;
        Arrays.sort(nums);
        // 定义四个指针，固定前两个，与三数之和类似 April18\threeSum.java
        int a, b, c, d;
        for (a = 0; a < n - 3; a++) {
            if (a > 0 && nums[a] == nums[a - 1]) continue;
            for (b = a + 1; b < n - 2; b++) {
                if (b > a + 1 && nums[b] == nums[b - 1]) continue;
                c = b + 1;
                d = n - 1;
                while (c < d) {
                    int sum = nums[a] + nums[b] + nums[c] + nums[d];
                    if (sum > target)
                        d--;
                    else if (sum < target)
                        c++;
                    else {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[a]);
                        list.add(nums[b]);
                        list.add(nums[c]);
                        list.add(nums[d]);
                        ans.add(list);
                        while (c < d && nums[c + 1] == nums[c]) c++;
                        while (c < d && nums[d] == nums[d - 1]) d--;
                        c++;
                        d--;
                    }
                }
            }
        }
        return ans;
    }
}