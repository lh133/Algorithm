package com.lh.LeetCode.June.June1;

import java.util.Arrays;

/**
 * 1744. 你能在你最喜欢的那天吃到你最喜欢的糖果吗？
 * 给你一个下标从 0 开始的正整数数组 candiesCount ，其中 candiesCount[i] 表示你拥有的第 i 类糖果的数目。同时给你一个二维数组 queries ，其中 queries[i] = [favoriteTypei, favoriteDayi, dailyCapi] 。
 * <p>
 * 你按照如下规则进行一场游戏：
 * <p>
 * 你从第 0 天开始吃糖果。
 * 你在吃完 所有 第 i - 1 类糖果之前，不能 吃任何一颗第 i 类糖果。
 * 在吃完所有糖果之前，你必须每天 至少 吃 一颗 糖果。
 * 请你构建一个布尔型数组 answer ，满足 answer.length == queries.length 。answer[i] 为 true 的条件是：在每天吃 不超过 dailyCapi 颗糖果的前提下，你可以在第 favoriteDayi 天吃到第 favoriteTypei 类糖果；否则 answer[i] 为 false 。注意，只要满足上面 3 条规则中的第二条规则，你就可以在同一天吃不同类型的糖果。
 * <p>
 * 请你返回得到的数组 answer 。
 * <p>
 * 提示：
 * <p>
 * 1 <= candiesCount.length <= 105
 * 1 <= candiesCount[i] <= 105
 * 1 <= queries.length <= 105
 * queries[i].length == 3
 * 0 <= favoriteTypei < candiesCount.length
 * 0 <= favoriteDayi <= 109
 * 1 <= dailyCapi <= 109
 *
 * @Author: LH
 * @Date: 2021/6/1 9:22
 */
public class canEat {
    public static void main(String[] args) {
        int[] candiesCount = {16, 38, 8, 41, 30, 31, 14, 45, 3, 2, 24, 23, 38, 30, 31, 17, 35, 4, 9, 42,
                28, 18, 37, 18, 14, 46, 11, 13, 19, 3, 5, 39, 24, 48, 20, 29, 4, 19, 36, 11, 28, 49, 38, 16,
                23, 24, 4, 22, 29, 35, 45, 38, 37, 40, 2, 37, 8, 41, 33, 8, 40, 27, 13, 4, 33, 5, 8, 14, 19, 35, 31, 8, 8};
        int[][] queries = {{35, 669, 5}, {72, 822, 74}, {47, 933, 94}, {62, 942, 85}, {42, 596, 11},
                {56, 1066, 18}, {54, 571, 45}, {39, 890, 100}, {3, 175, 26}, {48, 1489, 37}, {40, 447, 52},
                {30, 584, 7}, {26, 1486, 38}, {21, 1142, 21}, {9, 494, 96}, {56, 759, 81}, {13, 319, 16},
                {20, 1406, 57}, {11, 1092, 19}, {24, 670, 67}, {38, 1702, 33}, {5, 676, 32}, {50, 1386, 77},
                {36, 1551, 87}, {29, 1445, 13}, {58, 977, 13}, {7, 887, 64}, {37, 1396, 23}, {0, 765, 69},
                {40, 1083, 86}, {43, 1054, 49}, {48, 690, 92}, {28, 1201, 56}, {47, 948, 43}, {57, 233, 25},
                {32, 1293, 65}, {0, 1646, 34}, {43, 1467, 39}, {39, 484, 23}, {21, 1576, 69}, {12, 1222, 68},
                {9, 457, 83}, {32, 65, 9}, {10, 1424, 42}, {35, 534, 3}, {23, 83, 22}, {33, 501, 33}, {25, 679, 51},
                {2, 321, 42}, {1, 240, 68}, {7, 1297, 42}, {45, 480, 72}, {26, 1472, 9}, {6, 649, 90}, {26, 361, 57},
                {49, 1592, 7}, {11, 158, 95}, {35, 448, 24}, {41, 1654, 10}, {61, 510, 43}, {31, 1230, 95},
                {11, 1471, 12}, {37, 43, 84}, {56, 1147, 48}, {69, 1368, 65}, {22, 170, 24}, {56, 192, 80},
                {34, 1207, 69}, {1, 1226, 22}, {37, 1633, 50}, {11, 98, 58}, {17, 125, 13}, {0, 1490, 5},
                {37, 1732, 43}, {45, 793, 14}, {16, 578, 72}, {50, 241, 78}};
        // ans:{true,true,true,true,true,true,true,true,false,false,true,true,false,false,false,true,true,false,false,false,false,false,false,false,false,true,false,false,false,false,false,true,false,true,true,false,false,false,true,false,false,false,false,false,true,true,true,false,false,false,false,true,false,false,true,false,true,true,false,true,false,false,true,true,true,true,true,false,false,false,true,true,false,false,true,false,true}
        System.out.println(Arrays.toString(new Solution().canEat(candiesCount, queries)));
    }
}

class Solution {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        int m = candiesCount.length, n = queries.length;
        // 结果数组
        boolean[] answer = new boolean[n];
        // 预处理出前缀和数组
        long[] sum = new long[m + 1];
        for (int i = 1; i <= m; ++i) {
            sum[i] = sum[i - 1] + candiesCount[i - 1];
        }
        // 遍历查找吃掉queries[i][1]的最大最小时间
        for (int i = 0; i < n; ++i) {
            // t:最喜欢的糖果类型;d:最喜欢的那天，从第0天开始吃，所以需要+1;c:最多吃糖数
            int t = queries[i][0], d = queries[i][1] + 1, c = queries[i][2];
            // a:最快吃糖天数;b:最慢吃糖天数
            long a = sum[t] / c + 1, b = sum[t + 1];
            // 判断结果是否落在[a,b]区间内
            answer[i] = a <= d && d <= b;
        }
        return answer;
    }
}