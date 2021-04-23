package com.lh.InsertSort;

import com.lh.Sort.IArraySort;

import java.util.Arrays;

/**
 * @Author: LH
 * @Date: 2020/10/22 14:57
 */
public class InsertSort implements IArraySort {

    public static int[] sort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        for (int i = 1; i < arr.length; i++) {

            int tmp = arr[i];

            int j = i;

            while (j > 0 && tmp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }

            if (j != i) {
                arr[j] = tmp;
            }

        }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {22, 25, 1, 55, 86, 45, 12, 5};
        int[] result = sort(arr);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
