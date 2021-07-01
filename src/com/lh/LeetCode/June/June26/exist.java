package com.lh.LeetCode.June.June26;

/**
 * 79. 单词搜索
 * <p>
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * 提示：
 * <p>
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board 和 word 仅由大小写英文字母组成
 *
 * @Author: LH
 * @Date: 2021/6/26 22:49
 */
public class exist {
}

class Solution3 {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean flag = check(board, visited, i, j, word, 0);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 判断以网格的(i,j)位置出发能否找到单词s或s的子串
     *
     * @param board   输入
     * @param visited 记录是否已访问
     * @param i       开始位置列标
     * @param j       开始位置行标
     * @param s       查找的字符串
     * @param start   查找位置
     * @return 是否找到
     */
    private boolean check(char[][] board, boolean[][] visited, int i, int j, String s, int start) {
        if (board[i][j] != s.charAt(start)) return false;
        else if (start == s.length() - 1) return true;
        visited[i][j] = true;
        // 偏移量数组
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean res = false;
        for (int[] dir : dirs) {
            int xi = i + dir[0], xj = j + dir[1];
            if (xi >= 0 && xi < board.length && xj >= 0 && xj < board[0].length) {
                if (!visited[xi][xj]) {
                    boolean flag = check(board, visited, xi, xj, s, start + 1);
                    if (flag) {
                        res = true;
                        break;
                    }
                }
            }
        }
        // 没找到
        visited[i][j] = false;
        return res;
    }
}