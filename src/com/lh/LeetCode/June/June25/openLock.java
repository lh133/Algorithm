package com.lh.LeetCode.June.June25;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * 752. 打开转盘锁
 * <p>
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为 '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 * <p>
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 * <p>
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 * <p>
 * 字符串 target 代表可以解锁的数字，你需要给出解锁需要的最小旋转次数，如果无论如何不能解锁，返回 -1 。
 * <p>
 * 提示：
 * <p>
 * 1 <= deadends.length <= 500
 * deadends[i].length == 4
 * target.length == 4
 * target 不在 deadends 之中
 * target 和 deadends[i] 仅由若干位数字组成
 *
 * @Author: LH
 * @Date: 2021/6/25 10:07
 */
public class openLock {
}

class Solution {
    public int openLock(String[] deadends, String target) {
        if (target.equals("0000")) return 0;
        Set<String> dead = new HashSet<>();
        Collections.addAll(dead, deadends);
        if (dead.contains("0000")) return -1;

        // 定义两个队列，分别从开始和结束进行搜索
        Set<String> q1 = new HashSet<>();
        Set<String> q2 = new HashSet<>();
        Set<String> visited = new HashSet<>();

        int count = 0;
        q1.add("0000");
        q2.add(target);

        while (!q1.isEmpty() && !q2.isEmpty()) {
            // temp存储搜索结果
            Set<String> temp = new HashSet<>();

            for (String cur : q1) {// 将 q1 中的所有节点向周围扩散
                if (dead.contains(cur)) continue;
                if (q2.contains(cur)) return count;
                visited.add(cur);

                for (int i = 0; i < 4; i++) {// 将一个节点未遍历的相邻节点加入集合
                    String up = numUp(cur, i);
                    if (!visited.contains(up)) temp.add(up);

                    String down = numDown(cur, i);
                    if (!visited.contains(down)) temp.add(down);
                }
            }
            count++;

            // 使搜索在q1和q2之间切换
            q1 = q2;
            q2 = temp;
        }
        return -1;
    }

    private String numUp(String cur, int index) {//  num++
        char[] ch = cur.toCharArray();
        ch[index] = ch[index] == '9' ? '0' : (char) (ch[index] + 1);
        return new String(ch);
    }

    private String numDown(String cur, int index) {// num--
        char[] ch = cur.toCharArray();
        ch[index] = ch[index] == '0' ? '9' : (char) (ch[index] - 1);
        return new String(ch);
    }
}