package com.lh.SelectionSort;

import com.lh.Sort.IArraySort;

import java.util.Arrays;

/**
 * @Author: LH
 * @Date: 2020/10/22 9:34
 */
public class SelectionSort implements IArraySort {
    public static int[] sort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (i != min) {
                int tmp = arr[i];
                arr[i] = arr[min];
                arr[min] = tmp;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {22, 25, 1, 55, 86, 45, 12, 5};
        int[] result = sort(arr);
        for (int value : result) {
            System.out.println(value);
        }
    }
}
