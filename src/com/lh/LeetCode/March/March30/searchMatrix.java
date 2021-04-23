package com.lh.LeetCode.March.March30;

/**
 * 74. 搜索二维矩阵
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * <p>
 * 提示：
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -104 <= matrix[i][j], target <= 104
 *
 * @Author: LH
 * @Date: 2021/3/30 17:08
 */
public class searchMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target = 13;
        Solution solution = new Solution();
        boolean b = solution.searchMatrix(matrix, target);
        System.out.println(b);
    }
}

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowIdx = binarySearchColumn(matrix, target);
        return binarySearchRow(matrix[rowIdx], target);
    }

    //第一次二分查找,从上往下找到最后一个比target小的数的行号
    private int binarySearchColumn(int[][] matrix, int target) {
        int up = 0, down = matrix.length - 1;
        while (up < down) {
            int mid = up + down + 1 >> 1;
            if (matrix[mid][0] <= target) {
                up = mid;
            } else {
                down = mid - 1;
            }
        }
        return up;
    }

    //第二次二分，判断target是否在目标行内，特别注意循环的跳出条件设置
    private boolean binarySearchRow(int[] row, int target) {
        int l = 0, r = row.length - 1;
        while (l <= r) {
            int mid = l + r + 1 >> 1;
            if (row[mid] == target) {
                return true;
            } else if (row[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }
}