package com.lh.LeetCode.February.February24;

/**
 * 832. 翻转图像
 * 给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。
 * 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。
 * 反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。
 * 1 <= A.length = A[0].length <= 20
 * 0 <= A[i][j] <= 1
 *
 * @Author: LH
 * @Date: 2021/2/25 9:41
 */
public class flipAndInvertImage {
    public static void main(String[] args) {
        int[][] A = {{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
        Solution solution = new Solution();
        int[][] invertImage = solution.flipAndInvertImage(A);
        int length = invertImage.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                System.out.print(invertImage[i][j] + " ");
            }
            System.out.println();
        }
    }
}

//要点：找到翻转后反转的数字变化规律，制定算法
class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        int length = A.length;
        for (int i = 0; i < length; i++) {
            int left = 0, right = length - 1;
            while (left < right) {
                //如果对称的两边数字相等，则不进行水平翻转直接进行反转，如果对称的两边数字不同，则不需要进行任何操作
                if (A[i][left] == A[i][right]) {
                    A[i][left] ^= 1;
                    A[i][right] ^= 1;
                }
                left++;
                right--;
            }
            //如果为length为奇数，则补充对称轴的反转
            if (left == right) {
                A[i][left] ^= 1;
            }
        }
        return A;
    }
}