package com.lh.LeetCode.March.March7;

import java.util.*;

/**
 * 51. N 皇后
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * 提示：
 * 1 <= n <= 9
 * 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。
 *
 * @Author: LH
 * @Date: 2021/3/7 20:40
 */
public class solveNQueens {
    public static void main(String[] args) {
        int n = 4;
        Solution solution = new Solution();
        List<List<String>> nQueens = solution.solveNQueens(n);
        System.out.println(Arrays.toString(nQueens.toArray()));
    }
}

class Solution {
    ArrayList<List<String>> solutions = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        // 定义二维数组表示棋盘
        char[][] board = new char[n][n];
        for (char[] i : board) {
            //棋盘初始化，所有格子填充.
            Arrays.fill(i, '.');
        }
        // 调用回溯算法进行搜索
        backtrack(board, 0);
        return solutions;
    }

    void backtrack(char[][] board, int row) {
        int len = board.length;
        // 如果row == len，说明已经遍历到最后
        if (row == len) {
            // 添加到结果集
            solutions.add(array2List(board));
            return;
        }

        for (int i = 0; i < len; ++i) {
            // 如果产生冲突，即判断不合法，则返回循环开头
            if (!isValid(board, row, i)) {
                continue;
            }
            // 当合法时，将Q放入棋盘，即做选择
            board[row][i] = 'Q';
            // 对下一行棋盘进行回溯判断，即判断未探索区域
            backtrack(board, row + 1);
            // 如果当前位置不能遍历到最后一行，则当前遍历的行复原，尝试下一个位置，即撤销选择
            board[row][i] = '.';
        }
    }

    // 数组转列表
    List<String> array2List(char[][] board) {
        List<String> res = new LinkedList<>();
        for (char[] i : board) {
            StringBuilder sb = new StringBuilder();
            for (char j : i) {
                sb.append(j);
            }
            res.add(sb.toString());
        }
        return res;
    }

    // 判断是否合法，true为合法
    boolean isValid(char[][] board, int row, int col) {
        int len = board.length;
        // 检查列
        for (char[] chars : board) {
            if (chars[col] == 'Q')
                return false;
        }
        // 检查右上
        for (int i = row - 1, j = col + 1; i >= 0 && j < len; i--, j++) {
            if (board[i][j] == 'Q')
                return false;
        }
        // 检查左上
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q')
                return false;
        }
        return true;
    }
}