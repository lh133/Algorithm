package com.lh.LeetCode.April.April4;

import java.util.Arrays;

/**
 * 781. 森林中的兔子
 * 森林中，每个兔子都有颜色。其中一些兔子（可能是全部）告诉你还有多少其他的兔子和自己有相同的颜色。我们将这些回答放在 answers 数组里。
 * 返回森林中兔子的最少数量。
 *
 * @Author: LH
 * @Date: 2021/4/4 12:36
 */
public class numRabbits {
    public static void main(String[] args) {
        int[] answers = {1, 0, 1, 0, 0};
        Solution solution = new Solution();
        int ans = solution.numRabbits(answers);
        System.out.println(ans);
    }
}

class Solution {
    public int numRabbits(int[] answers) {
        Arrays.sort(answers);
        int n = answers.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int count = answers[i];
            ans += count + 1;
            int k = count;
            // 尽量多的消除回答相同的‘兔子’
            while (k-- > 0 && i + 1 < n && answers[i] == answers[i + 1])
                i++;
        }
        return ans;
    }
}