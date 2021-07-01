package com.lh.LeetCode.June.June27;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 909. 蛇梯棋
 * <p>
 * N x N 的棋盘 board 上，按从 1 到 N*N 的数字给方格编号，编号 从左下角开始，每一行交替方向。
 * <p>
 * 例如，一块 6 x 6 大小的棋盘，编号如下：
 * <p>
 * <p>
 * r 行 c 列的棋盘，按前述方法编号，棋盘格中可能存在 “蛇” 或 “梯子”；如果 board[r][c] != -1，那个蛇或梯子的目的地将会是 board[r][c]。
 * <p>
 * 玩家从棋盘上的方格 1 （总是在最后一行、第一列）开始出发。
 * <p>
 * 每一回合，玩家需要从当前方格 x 开始出发，按下述要求前进：
 * <p>
 * 选定目标方格：选择从编号 x+1，x+2，x+3，x+4，x+5，或者 x+6 的方格中选出一个目标方格 s ，目标方格的编号 <= N*N。
 * 该选择模拟了掷骰子的情景，无论棋盘大小如何，你的目的地范围也只能处于区间 [x+1, x+6] 之间。
 * 传送玩家：如果目标方格 S 处存在蛇或梯子，那么玩家会传送到蛇或梯子的目的地。否则，玩家传送到目标方格 S。
 * 注意，玩家在每回合的前进过程中最多只能爬过蛇或梯子一次：就算目的地是另一条蛇或梯子的起点，你也不会继续移动。
 * <p>
 * 返回达到方格 N*N 所需的最少移动次数，如果不可能，则返回 -1。
 * <p>
 * 提示：
 * <p>
 * 2 <= board.length = board[0].length <= 20
 * board[i][j] 介于 1 和 N*N 之间或者等于 -1。
 * 编号为 1 的方格上没有蛇或梯子。
 * 编号为 N*N 的方格上没有蛇或梯子。
 *
 * @Author: LH
 * @Date: 2021/6/27 20:31
 */
public class snakesAndLadders {
    public static void main(String[] args) {
        int[][] board = {
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 35, -1, -1, 13, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 15, -1, -1, -1, -1}};
        System.out.println(new Solution().snakesAndLadders(board));
    }
}

class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        if (board[0][0] != -1) return -1;
        // 将board扁平化，用nums存储
        int[] nums = new int[n * n + 1];
        // 根据给定二位数组特点进行扁平化，flag表示行的遍历方向
        boolean flag = true;
        for (int i = n - 1, idx = 1; i >= 0; --i) {
            for (int j = (flag ? 0 : n - 1); flag ? j < n : j >= 0; j += flag ? 1 : -1) {
                nums[idx++] = board[i][j];
            }
            flag = !flag;
        }
        return bfs(n, nums);
    }

    private int bfs(int n, int[] nums) {
        Deque<Integer> deque = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        deque.addLast(1);
        map.put(1, 0);
        while (!deque.isEmpty()) {
            int poll = deque.pollFirst();
            int step = map.get(poll);
            if (poll == n * n) return step;
            for (int i = 1; i <= 6; i++) {
                int tmp = poll + i;
                if (tmp <= 0 || tmp > n * n) continue;
                if (nums[tmp] != -1) tmp = nums[tmp];
//                System.out.println("第" + step + "----位置" + tmp);
                if (map.containsKey(tmp)) continue;
                map.put(tmp, step + 1);
                deque.addLast(tmp);
            }
        }
        return -1;
    }
}